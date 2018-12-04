package HundirLaFlota;

import tools.tools;

public class disparos {

	/*
	 * Este metodo dispara una posicion aleatoria en la que aun no haya disparado el
	 * pc
	 * 
	 */
	public static void disparoPC(char[][] tableroPCDisp, char[][] tablero) {
//		DECLARAMOS LAS COORDENADAS DEL DISPARO		
		int fila;
		int columna;
//		REALIZAMOS UN BUCLE PARA QUE DISPARE SIEMPRE QUE NO SE HAYA DISPARADO EN UN SITIO CON ANTERIORIDAD
		do {
			fila = (int) (Math.random() * 9);
			columna = (int) (Math.random() * 8 + 1);
			hacerDisparo(tableroPCDisp, tablero, fila, columna);
		} while (tablero[fila][columna] == '*' || tablero[fila][columna] == 'T');
	}

	/*
	 * Método que se encarga de pedir unas coordenadas para que el jugador dispare
	 */
	public static void disparoJugador(char[][] tableroDisparosJugador, char[][] tableroPC) {
//		DECLARAMOS LAS VARIABLES QUE NECESITAMOS PARA LAS COORDENADAS DEL DISPARO
		int[] posicion = new int[2];
		int fila;
		int columna;
//		PEDIREMOS LAS COORDENADAS PARA UN SITIO EN EL QUE NO SE HAYA DISPARADO TODAVÍA	
		do {
			tools.coordenadas("Indica la posicion a la que deseas disparar Ej.[A4]", posicion);
			fila = posicion[0];
			columna = posicion[1];
			hacerDisparo(tableroDisparosJugador, tableroPC, fila, columna);
		} while (tableroPC[fila][columna] == '*' || tableroPC[fila][columna] == 'T');
	}

	/*
	 * Método que se encarga de comprobar donde ha caido el disparo y alternar los
	 * campos
	 */
	public static void hacerDisparo(char[][] tableroDisparos, char[][] tableroDisparado, int fila, int columna) {
//		CONDICIONAMOS EL RESULTADO DEL DISPARO QUE SE REALICE
		if (tableroDisparado[fila][columna] == 'B') {
			tableroDisparado[fila][columna] = 'T';
			tableroDisparos[fila][columna] = 'T';
			System.out.println("¡¡TOCADO!!");
		} else if (tableroDisparado[fila][columna] == '~') {
			tableroDisparado[fila][columna] = '*';
			tableroDisparos[fila][columna] = '*';
			System.out.println("CHOFT");
		}
	}
}
