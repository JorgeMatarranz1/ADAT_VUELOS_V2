
public class Controlador {
	public void ejecutar() {
		Vista vista = new Vista();
		MongoManager mongo = new MongoManager();
		vista.menu();
		int opc = vista.menu2();
		switch (opc) {
		case 1: 
			vista.verVuelos(mongo.mostrar());
			
			mongo.insertar(vista.pedirDatos(), vista.pedirCodigoVuelo());
<<<<<<< HEAD
=======
			vista.pedirDatos();
>>>>>>> 31807605ae95cc078e246f8a34bf78ab888d5576
			break;
		case 2:
			mongo.cancelar(vista.pedirCodigoVuelo(), vista.pedirDatos2());
			break;
		case 3:
			mongo.modificar(vista.pedirCodigoVuelo(), vista.pedirDatos(), vista.pedirDatos2());
			break;
		case 4:
			System.exit(0);
			break;
		default:
			System.err.println("Vane pendeja");
		}
	}
}
