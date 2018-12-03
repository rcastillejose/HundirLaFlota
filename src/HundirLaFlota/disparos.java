package HundirLaFlota;

import tools.tools;

public class disparos {

	/*
	 * Este metodo dispara una posicion aleatoria en la que aun no haya disparado el pc
	 * 
	 */
	public static void disparoPC(char[][] tableroPCDisp, char[][] tablero) {
		int fila;
		int columna;

		do {
			fila = (int) (Math.random() * 9);
			columna = (int) (Math.random() * 8 + 1);
			hacerDisparo(tableroPCDisp,tablero,fila,columna);
		} while (tablero[fila][columna] == '*' && tablero[fila][columna] == 'T');
	}

	/*
	 * Método que se encarga de pedir unas coordenadas para que el jugador dispare
	 */
	public static void disparoJugador(char[][] tableroDisparosJugador, char[][] tableroPC) {

		int[] posicion = new int[2];
		int fila;
		int columna;

		tools.coordenadas("Indica la posicion a la que deseas disparar Ej.[A4]", posicion);

		fila = posicion[0];
		columna = posicion[1];

		hacerDisparo(tableroDisparosJugador,tableroPC,fila,columna);

	}
	
	/*
	 * Método que se encarga de comprobar donde ha caido el disparo y alternar los campos
	 */
	public static void hacerDisparo(char[][] tableroDisparosJugador, char[][] tableroPC,int fila,int columna) {
		
		if (tableroPC[fila][columna] == 'B') {
			tableroPC[fila][columna] = 'T';
			tableroDisparosJugador[fila][columna] = 'T';
			System.out.println("¡¡TOCADO!!");
		} else if (tableroPC[fila][columna] == '~') {
			tableroPC[fila][columna] = '*';
			tableroDisparosJugador[fila][columna] = '*';
			System.out.println("CHOFT");
		}
	}
}
