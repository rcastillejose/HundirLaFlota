package HundirLaFlota;

public class tableros {
	
	/*
	 * El metodo iniciar se encarga de crar tableros
	 * Tu le pasas un tablero y el metodo te crea
	 * el tablero.
	 */
	public static void iniciar(char[][] tablero) {
		for (int i = 0 ; i < tablero[0].length; i++){
			tablero[i][0] = (char) ('A' + i);
			for (int j = 1 ; j < tablero.length; j++) {
				tablero[i][j]='~';
			}
		}
	}
	
	/*
	 * Este metodo se encarga de visualizar el tablero
	 * Se pasa un tablero y te devuelve el tablero por
	 * pantalla.
	 */
	
	public static void visualizar(char[][] tablero) {
		for (int i = 0 ; i < tablero[0].length; i++) {
			System.out.println("");
			for (int j = 0; j < tablero.length; j++) {
				System.out.print(tablero[i][j]+ " ");
			}
		}
		System.out.println();
		System.out.println("  1 2 3 4 5 6 7 8 9");
	}
}
