import java.util.Random;

public class Utils {
	public String CodigoventaAleatorio() {
		char[] chars = "ABCEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
		StringBuilder sb = new StringBuilder(9);
		Random random = new Random();
		for (int i = 0; i < 9; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String codigo_venta = sb.toString();
		return codigo_venta;
	}

	public int numeroAsiento() {
		int asiento = 0;
		asiento = (int) (Math.random() * 200 + 1);
		return asiento;
	}
}
