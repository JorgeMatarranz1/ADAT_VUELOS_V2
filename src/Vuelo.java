
public class Vuelo {
	private String codigo;
	private String origen;
	private String destino;
	private String fecha;
	private String hora;
	private int pdisponibles;
	private int ptotales;

	public Vuelo(String codigo, String origien, String destino, String fecha, String hora, int ptotales,
			int pdisponibles) {
		this.codigo = codigo;
		this.origen = origien;
		this.destino = destino;
		this.fecha = fecha;
		this.hora = hora;
		this.ptotales = ptotales;
		this.pdisponibles = pdisponibles;
	}

	public Vuelo() {

	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public int getPdisponibles() {
		return pdisponibles;
	}

	public void setPdisponibles(int pdisponibles) {
		this.pdisponibles = pdisponibles;
	}

	public int getPtotales() {
		return ptotales;
	}

	public void setPtotales(int ptotales) {
		this.ptotales = ptotales;
	}
}
