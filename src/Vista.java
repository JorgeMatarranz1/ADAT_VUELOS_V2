import java.util.HashMap;

public class Vista {
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

	public void menu2() {
		System.out.println("Seleccione opcion: ");
		System.out.println("-------------------------");
		System.out.println("1. Comprar billete");
		System.out.println("2. Borrar billete");
		System.out.println("3. Modificar billete");
		
	}
}
