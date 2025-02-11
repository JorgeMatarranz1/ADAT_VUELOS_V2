
public class Controlador {
	public void ejecutar() {
		Vista vista = new Vista();
		MongoManager mongo = new MongoManager();
		int opc = vista.menu2();
		switch (opc) {
		case 1: 
			vista.verVuelos(mongo.mostrar());
			
			mongo.insertar(vista.pedirDatos(), vista.pedirCodigoVuelo());
			break;
		case 2:
			mongo.cancelar(vista.pedirCodigoVuelo(), vista.pedirDatos2());
			break;
		case 3:
			mongo.modificar(vista.pedirCodigoVuelo(), vista.pedirDatos2(), vista.pedirDatos());
			break;
		case 4:
			System.exit(0);
			break;
		default:
			System.err.println("Vane pendeja");
		}
	}
}
