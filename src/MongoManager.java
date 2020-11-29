import java.util.HashMap;
import java.util.List;
import org.bson.Document;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;

public class MongoManager implements Funcionalidad {
	private MongoClient mongo;
	private MongoDatabase db;
	private MongoCollection collection;
	Utils ut;

	public MongoManager() {
		mongo = new MongoClient("localhost", 27017);
		db = mongo.getDatabase("vuelos2_0");
		collection = db.getCollection("vuelos");

	}

	@Override
	public HashMap<String, Vuelo> mostrar() {
		HashMap<String, Vuelo> vuelos = new HashMap<String, Vuelo>();
		MongoCursor<Document> cursor = collection.find().iterator();

		while (cursor.hasNext()) {
			Vuelo v = new Vuelo();
			Document doc = (Document) cursor.next();
			v.setCodigo(doc.getString("codigo"));
			v.setOrigen(doc.getString("origen"));
			v.setDestino(doc.getString("destino"));
			v.setFecha(doc.getString("fecha"));
			v.setHora(doc.getString("hora"));
			v.setPtotales(doc.getInteger("plazas_totales"));
			v.setPdisponibles(doc.getInteger("plazas_disponibles"));
			vuelos.put(doc.getString("codigo"), v);
		}
		return vuelos;
	}

	// venta son los nuevos datos
	@Override
	public void insertar(Vendidos venta, String cod_vuelo) {
		Document quienCambio = new Document("codigo", cod_vuelo);
		int asiento = 0;
		Document nodes = (Document) collection.find(quienCambio)
				.projection(Projections.fields(Projections.include("vendidos.asiento"), Projections.excludeId()))
				.first();
		List<Document> list = (List<Document>) nodes.get("vendidos");
		if (list == null) {
			asiento = venta.getAsiento();
		} else {
			for (Document d : list) {
				asiento = (int) d.get("asiento");
				if (asiento == venta.getAsiento()) {
					asiento = ut.numeroAsiento();
				} else {
					asiento = venta.getAsiento();
				}
			}
		}

		Document listItem = new Document("vendidos",
				new BasicDBObject("asiento", asiento).append("dni", venta.getDni())
						.append("apellido", venta.getApellido()).append("nombre", venta.getNombre())
						.append("dniPagador", venta.getDniPagador()).append("tarjeta", venta.getTarjeta())
						.append("codigoVenta", venta.getCodigoVenta()));

		Document updateQuery = new Document("$push", listItem).append("$inc",
				new BasicDBObject("plazas_disponibles", -1));

		collection.updateOne(quienCambio, updateQuery);
		System.out.println("Su codigo de compra es: " + venta.getCodigoVenta());
	}

	@Override
	public void modificar(String codigo_vuelo, Vendidos venta, Vendidos datos) {
		Document quienCambio = new Document("codigo", codigo_vuelo)
				.append("vendidos.codigoVenta", venta.getCodigoVenta()).append("vendidos.dni", venta.getDni());
		Document listItem = new Document("vendidos.$.dni", datos.getDni())
				.append("vendidos.$.apellido", datos.getApellido()).append("vendidos.$.nombre", datos.getNombre())
				.append("vendidos.$.dniPagador", datos.getDniPagador()).append("vendidos.$.tarjeta", datos.getTarjeta())
				.append("vendidos.$.codigoVenta", datos.getCodigoVenta());
		Document updateQuery = new Document("$set", listItem);

		collection.updateMany(quienCambio, updateQuery);
	}

	@Override
	public void cancelar(String codigo_vuelo, Vendidos ven) {
		BasicDBObject query = new BasicDBObject("codigo", codigo_vuelo);
		BasicDBObject fields = new BasicDBObject("vendidos",
				new BasicDBObject("dni", ven.getDni()).append("codigoVenta", ven.getCodigoVenta()));
		BasicDBObject update = new BasicDBObject("$pull", fields).append("$inc",
				new BasicDBObject("plazas_disponibles", 1));

		collection.updateOne(query, update);

	}

}
