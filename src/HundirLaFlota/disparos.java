package HundirLaFlota;

import tools.tools;

public class disparos {
	
	/*
	 * Este metodo dispara una posicion aleatoria en la que aun no haya disparado el pc
	 */
	public static void disparoPC(char[][] tableroPCDisp, char[][] tablero){
		int fila;
		int columna;
		
		do {
			fila=tools.numAleatorio(0, 9);
			columna=tools.numAleatorio(1, 9);
			
		}while(tableroPCDisp[fila][columna]!='*' || tableroPCDisp[fila][columna]!='T');
		
		if(tablero[fila][columna]=='B') {
			tablero[fila][columna]='T';	
		}	
		tableroPCDisp[fila][columna]='T';
	}
	
	public static void disparoJugador(char[][] tableroDisparosJugador, char[][] tableroPC) {

		String disparo;
		int[] posicion = new int[2];
		int fila;
		int columna;

		//
		do {
			tools.coordenadas("Indica la posicion a la que deseas disparar Ej.[A4]",posicion);
			disparo =  tools.obtenerString("Indica la posicion donde quieres disparar");
			fila = posicion[0];
			columna = posicion[1];

		} while (tableroPC[fila][columna] != '*' || tableroPC[fila][columna] != 'T');

		if (tableroPC[fila][columna] == 'B') {
			tableroPC[fila][columna] = 'T';
			System.out.println("¡¡TOCADO!!");
		} else {
			tableroPC[fila][columna] = '*';
			System.out.println("CHOFT");
		}

	}
}
