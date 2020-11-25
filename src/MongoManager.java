
import java.util.HashMap;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoManager implements Funcionalidad {
<<<<<<< HEAD
	private MongoClient mongo;
	private MongoDatabase db;
	private MongoCollection collection;
	Utils ut;

	public MongoManager() {
		mongo = new MongoClient("localhost", 27017);
		db = mongo.getDatabase("vuelos2_0");
		collection = db.getCollection("vuelos");
=======
	MongoDatabase db;
	MongoCollection<Document> collection;
	public MongoManager() {
		 MongoClient mongo = new MongoClient("localhost", 27017);
		db = mongo.getDatabase("adat_vuelos");
		collection = db.getCollection("vuelosV2");
>>>>>>> 31807605ae95cc078e246f8a34bf78ab888d5576
	}

	@Override
	public HashMap<String, Vuelo> mostrar() {
		HashMap<String, Vuelo> vuelos = new HashMap<String, Vuelo>();
<<<<<<< HEAD
=======
		
>>>>>>> 31807605ae95cc078e246f8a34bf78ab888d5576
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
	
	
	//venta son los nuevos datos
	@Override
<<<<<<< HEAD
	public void insertar(Vendidos venta, String cod_vuelo) {
		int asiento = 0;
		FindIterable fi = collection.find();
		MongoCursor cur = fi.cursor();
		while (cur.hasNext()) {
			Document doc = (Document) cur.next();
			asiento = doc.getInteger("vendidos.asiento");
			if (asiento == venta.getAsiento()) {
				asiento = ut.numeroAsiento();
			}
		}
		Document quienCambio = new Document("id", cod_vuelo);

		Document listItem = new Document("vendidos",
				new BasicDBObject("asiento", asiento).append("dni", venta.getDni())
						.append("apellido", venta.getApellido()).append("nombre", venta.getNombre())
						.append("dniPagador", venta.getDniPagador()).append("tarjeta", venta.getTarjeta())
						.append("codigoVenta", venta.getCodigoVenta()));
		Document updateQuery = new Document("$push", listItem);

		collection.updateOne(quienCambio, updateQuery);
	}

	@Override
	public void modificar(String codigo_vuelo, Vendidos venta, Vendidos datos) {

	}

	@Override
	public void cancelar(String codigo_vuelo, Vendidos ven) {

=======
	public void modificar(String codigo_vuelo, Vendidos venta, Vendidos datos) {
		
		
	}

	@Override
	public void cancelar(String codigo_vuelo, Vendidos ven) {
		
		
	}

	@Override
	public void insertar(Vendidos venta, String cod_venta) {
		venta.setCodigoVenta(cod_venta);
		
>>>>>>> 31807605ae95cc078e246f8a34bf78ab888d5576
	}

}
