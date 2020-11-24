import java.util.HashMap;

public interface Funcionalidad {
	public HashMap<String, Vuelo> mostrar();
	public void insertar(Vendidos venta, String cod_vuelo);
	public void modificar(String codigo_vuelo, Vendidos venta, Vendidos datos);
	public void cancelar(String codigo_vuelo, Vendidos ven);
}
