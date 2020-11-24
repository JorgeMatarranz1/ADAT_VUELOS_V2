import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Vista {
	Scanner sc = new Scanner(System.in);
	Utils ut = new Utils();

	public void menu() {
		System.out.println("Seleccione codigo del vuelo: ");
		System.out.println("-------------------------");
	}

	public void verVuelos(HashMap<String, Vuelo> vuelos) {
		for (HashMap.Entry<String, Vuelo> entry : vuelos.entrySet()) {
			Vuelo v = (Vuelo) entry.getValue();
			System.out.println("\n" + "CODIGO VUELO: " + v.getCodigo());
			System.out.println("ORIGEN: " + v.getOrigen());
			System.out.println("DESTINO: " + v.getDestino());
			System.out.println("FECHA: " + v.getFecha());
			System.out.println("HORA: " + v.getHora());
			System.out.println("PLAZAS TOTALES: " + v.getPtotales());
			System.out.println("PLAZAS DISPONIBLES: " + v.getPdisponibles());
			System.out.println("--------------------------------------");
		}
	}

	public int menu2() {
		System.out.println("Seleccione opcion: ");
		System.out.println("-------------------------");
		System.out.println("1. Comprar billete");
		System.out.println("2. Borrar billete");
		System.out.println("3. Modificar billete");
		System.out.println("4. Salir");
		System.out.println("-------------------------");
		int opcion = sc.nextInt();
		return opcion;
	}

	public Vendidos pedirDatos2() {
		Vendidos ven = new Vendidos();
		System.out.print("Introduce DNI: ");
		String dni = sc.next();
		String codigo_venta= sc.next();
		ven.setDni(dni);
		ven.setCodigoVenta(codigo_venta);
		return ven;
	}

	public Vendidos pedirDatos() {
		Vendidos ven = new Vendidos();
		System.out.print("Introduce dni del pasajero: ");
		String dni_pasajero = sc.next();
		System.out.print("Introduce nombre del pasajero: ");
		String nombre = sc.next();
		System.out.print("Introduce apellido del pasajero: ");
		String apellido = sc.next();
		System.out.print("Introduce DNI del pagador: ");
		String dni = sc.next();
		System.out.print("Introduce tarjeta: ");
		String tarjeta = sc.nextLine();
		
		ven.setDni(dni_pasajero);
		ven.setNombre(nombre);
		ven.setApellido(apellido);
		ven.setTarjeta(tarjeta);
		ven.setDniPagador(dni);
		ven.setCodigoVenta(ut.CodigoventaAleatorio());

		return ven;
	}

	public String pedirCodigoVuelo() {
		String cod = "";
		System.out.print("Introduce codigo de vuelo: ");
		cod = sc.next();
		return cod;
	}
}
