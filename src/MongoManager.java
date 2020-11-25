
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.BSONObject;
import org.bson.Document;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

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
		FindIterable fi = collection.find(quienCambio);
		MongoCursor cur = fi.cursor();
		while (cur.hasNext()) {
			Document doc = (Document) cur.next();
			System.out.println(doc);
			ArrayList asientos = (ArrayList) doc.getList("vendidos.asiento", Document.class);
			asiento = doc.getInteger("vendidos.asiento");
			System.out.println(asiento);
			if (asiento == venta.getAsiento()) {
				asiento = ut.numeroAsiento();
			}

		}
		Document listItem = new Document("vendidos",
				new BasicDBObject("asiento", asiento).append("dni", venta.getDni())
						.append("apellido", venta.getApellido()).append("nombre", venta.getNombre())
						.append("dniPagador", venta.getDniPagador()).append("tarjeta", venta.getTarjeta())
						.append("codigoVenta", venta.getCodigoVenta()))
				.append("$inc", new BasicDBObject("plazas_disponibles", -1));
		Document updateQuery = new Document("$push", listItem);

		collection.updateOne(quienCambio, updateQuery);
	}

	@Override
	public void modificar(String codigo_vuelo, Vendidos venta, Vendidos datos) {
		Document quienCambio = new Document("codigo", codigo_vuelo)
				.append("vendidos.codigoVenta", venta.getCodigoVenta()).append("vendidos.dni", venta.getDni());
		System.out.println(quienCambio);
		Document listItem = new Document("vendidos.$.dni", datos.getDni())
				.append("vendidos.$.apellido", datos.getApellido()).append("vendidos.$.nombre", datos.getNombre())
				.append("vendidos.$.dniPagador", datos.getDniPagador()).append("vendidos.$.tarjeta", datos.getTarjeta())
				.append("vendidos.$.codigoVenta", datos.getCodigoVenta());
		System.out.println(listItem);
		Document updateQuery = new Document("$set", listItem);

		System.out.println(collection.updateMany(quienCambio, updateQuery));
	}

	@Override
	public void cancelar(String codigo_vuelo, Vendidos ven) {
//		Document doc = new Document("codigo", codigo_vuelo)
//				.append("vendidos.codigoVenta", ven.getCodigoVenta())
//				.append("vendidos.dni", ven.getDni());
//
//		collection.deleteMany(doc);
		Document query = new Document("codigo", codigo_vuelo);

		Document update = new Document("$pull", new Document("vendidos.$.dni", ven.getDni())
				.append("vendidos.$.codigoVenta", ven.getCodigoVenta())
				.append("$inc", new BasicDBObject("plazas_disponibles", -1)));

		collection.updateOne(query, update);
	}

}
