import java.util.HashMap;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoManager implements Funcionalidad {
	MongoDatabase db;
	MongoCollection<Document> collection;
	public MongoManager() {
		 MongoClient mongo = new MongoClient("localhost", 27017);
		db = mongo.getDatabase("adat_vuelos");
		collection = db.getCollection("vuelosV2");
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
	
	
	//venta son los nuevos datos
	@Override
	public void modificar(String codigo_vuelo, Vendidos venta, Vendidos datos) {
		
		
	}

	@Override
	public void cancelar(String codigo_vuelo, Vendidos ven) {
		
		
	}

	@Override
	public void insertar(Vendidos venta, String cod_venta) {
		venta.setCodigoVenta(cod_venta);
		
	}

}
