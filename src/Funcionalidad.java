import java.util.HashMap;

public interface Funcionalidad {
	public HashMap<String, Vuelo> mostrar();
	public void insertar(Vendidos venta);
	public void modificar(String codigo_vuelo, int dni, String codigo_venta, Vendidos venta);
	public void cancelar(String codigo_vuelo, int dni, String codigo_venta);
}
