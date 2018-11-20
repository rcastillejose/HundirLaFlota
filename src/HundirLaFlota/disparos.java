package HundirLaFlota;

import tools.tools;

public class disparos {
	
	/*
	 * Este metodo dispara una posicion aleatoria en la que aun no haya disparado el pc
	 */
	public void disparoPC(char[][] tableroPCDisp, char[][] tablero){
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
	
	public void disparoJugador(char[][] tableroDisparosJugador, char[][] tableroPC) {

		String disparo;
		String posicion;
		int fila;
		int columna;

		//
		do {
			posicion = tools.obtenerString("hola");
			disparo =  tools.obtenerString("Indica la posicion donde quieres disparar");
			fila = (int) disparo.charAt(0);
			columna = (int) disparo.charAt(1);

		} while (tableroPC[fila][columna] != '*' || tableroPC[fila][columna] != 'T');

		if (tableroPC[fila][columna] == 'B') {
			tableroPC[fila][columna] = 'T';

		}

	}
}
