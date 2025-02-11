
public class Vendidos {
	private int asiento;
	private String dni;
	private String nombre;
	private String apellido;
	private String dniPagador;
	private String tarjeta;
	private String codigoVenta;

	public Vendidos() {

	}

	public Vendidos(int asiento, String dni, String nombre, String apellido, String dniPagador, String tarjeta,
			String codigoVenta) {
		this.asiento = asiento;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dniPagador = dniPagador;
		this.tarjeta = tarjeta;
		this.codigoVenta = codigoVenta;

	}

	public int getAsiento() {
		return asiento;
	}

	public void setAsiento(int asiento) {
		this.asiento = asiento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDniPagador() {
		return dniPagador;
	}

	public void setDniPagador(String dniPagador) {
		this.dniPagador = dniPagador;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(String codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

}
