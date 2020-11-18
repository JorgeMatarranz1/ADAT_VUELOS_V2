import java.util.Scanner;

public class Controlador {
	public void ejecutar() {
		Scanner sc = new Scanner(System.in);
		Vista vista = new Vista();
		MongoManager mongo = new MongoManager();
		vista.verVuelos(mongo.mostrar());
		String cod;
		vista.menu();
		cod = sc.next();
		
	}
}
