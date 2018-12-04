package HundirLaFlota;

import java.util.Scanner;

import tools.tools;

public class barcos {

	/*
	 * Este metodo comprobara si se está intentando colocar un barco donde ya hay otro situado
	 */
	public static boolean hayColision(char[][] tablero, int longitudBarco, int fila, int columna, int orientacion) {
		// creamos la variable colision a false para guardar el resultado de la
		// comprobación
		boolean colision = false;

		// Comprobaremos si hay colision segun la orientacion que se haya elegido
		if (orientacion == 1) {

			// Bucle para devolver el dato mientras el barco siga teniendo longitud, y
			// no haya otro barco en el sitio.
			for (int i = 0; i < longitudBarco && colision == false; i++, fila--) {

				// Mientras sea agua el resultado escogido no habr� colisi�n
				if (tablero[fila][columna] == '~') {
					colision = false;
				} else {
					colision = true;
				}
			}
		} else if (orientacion == 2) {
			for (int i = 0; i < longitudBarco && colision == false; i++, fila++) {
				if (tablero[fila][columna] == '~') {
					colision = false;
				} else {
					colision = true;
				}
			}
		} else if (orientacion == 3) {
			for (int i = 0; i < longitudBarco && colision == false; i++, columna--) {
				if (tablero[fila][columna] == '~') {
					colision = false;
				} else {
					colision = true;
				}
			}
		} else if (orientacion == 4) {
			for (int i = 0; i < longitudBarco && colision == false; i++, columna++) {
				if (tablero[fila][columna] == '~') {
					colision = false;
				} else {
					colision = true;
				}
			}
		}

		// Devolvemos el valor que nos indica si se solapa o no
		return colision;
	}

	/* 
	 * Este método se encargara de crear un menú para ingresar los barcos del jugador
	 */
	public static void menuBarcos(char[][] tablero) {

		Scanner teclado = new Scanner(System.in);
		int opcion;
		int contador = 0;
		int barco2 = 3, barco3 = 2, barco4 = 1;
		int longitudBarco;

		do {
			tableros.visualizar(tablero);
			System.out.println("----------------------------------------");
			System.out.println("Elija una opcion para colocar los barcos");
			System.out.println("----------------------------------------");
			System.out.println("1.- Agregar barcos de 2. Quedan: " + barco2);
			System.out.println("2.- Agregar barcos de 3. Quedan: " + barco3);
			System.out.println("3.- Agregar barcos de 4. Queda: " + barco4);
			System.out.println("---------------------------------");
			opcion = tools.obtenerEntero("Elija una opción del 1 al 3");

			// Si la opcion es menor que -1 o mayor que 3 saltaria una advertencia para
			// introducir una opcion correcta
			if (opcion < 1 || opcion > 3) {
				System.out.println("Las opciones validas son [1-3] [Salir -1]");
				opcion = tools.obtenerEntero("Elija otra opcion");
			}

			// Aqui vas incrementando los barcos dependiendo de la opcion que escojas
			// mientras el contador sea distinto a 0
			// cuando sea 0 parara y se ira a la siguiente
			if (opcion == 1) {
				if (barco2 != 0) {
					longitudBarco = 2;
					if(colocarBarcosJugador(tablero,longitudBarco)==true) {
						barco2--;
						System.out.println("Barco introducido correctamente");
					}else {
						System.out.println("Coordenadas incorrectas");;
					}
					
					
				}
			}

			else if (opcion == 2) {
				if (barco3 != 0) {
					longitudBarco = 3;
					if(colocarBarcosJugador(tablero,longitudBarco)==true) {
						barco3--;
						System.out.println("Barco introducido correctamente");
					}else {
						System.out.println("Coordenadas incorrectas");;
					}
				}
			}

			else if (opcion == 3) {
				if (barco4 != 0) {
					longitudBarco = 4;
					if(colocarBarcosJugador(tablero,longitudBarco)==true) {
						barco4--;
						System.out.println("Barco introducido correctamente");
					}else {
						System.out.println("Coordenadas incorrectas");;
					}
				}
			}

			

		} while (barco2 != 0 || barco3 != 0 || barco4 != 0);

	}

	/*
	 * Este método se encarga de comprobar si se está situando el barco dentro de el tablero
	 */
	public static boolean cabeBarco(char[][] tablero, int longitudBarco, int fila, int columna, int orientacion) {
		// Creamos la variable en la que se va a almacenar si el barco queda dentro del
		// tablero o no
		boolean dentro = true;

		// Se comprueba si el barco cabe seg�n la orientacion que este tenga
		if (orientacion == 1) {
			// Se realiza un bucle para que se realice la comprobaci�n siempre que el barco
			// siga teniendo longitud
			// y que no se est� intentando situar fuera
			for (int i = 0; i < longitudBarco && dentro == true; i++, fila--) {

				if (fila >= 0 && columna >= 1 && fila <= 9 && columna <= 9) {
					dentro = true;
				} else {
					dentro = false;
				}
			}
		} else if (orientacion == 2) {
			for (int i = 0; i < longitudBarco && dentro == true; i++, fila++) {
				if (fila >= 0 && columna >= 1 && fila <= 9 && columna <= 9) {
					dentro = true;
				} else {
					dentro = false;
				}
			}
		} else if (orientacion == 3) {
			for (int i = 0; i < longitudBarco && dentro == true; i++, columna--) {
				if (fila >= 0 && columna >= 1 && fila <= 9 && columna <= 9) {
					dentro = true;
				} else {
					dentro = false;
				}
			}
		} else if (orientacion == 4) {
			for (int i = 0; i < longitudBarco && dentro == true; i++, columna++) {
				if (fila >= 0 && columna >= 1 && fila <= 9 && columna <= 9) {
					dentro = true;
				} else {
					dentro = false;
				}
			}
		}

		// devolvemos el valor que nos indica si el barco quedaria dentro del tablero o
		// no
		return dentro;
	}

	/*
	 * Método, que se encarga de hacer un recuento instantáneo que que le queda al poseedor del tablero que se nombre
	 */
	public static int vidas(char[][] tablero) {
		// en la variable cuenta guardaremos el recuento de cada barco de todo el vector
		int cuenta = 0;
		for (int i = 0; i < tablero[0].length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				if (tablero[i][j] == 'B') {
					cuenta++;
				}
			}
		}
		return cuenta-1;
	}

	/*
	 * Desde menuBarcos se llama este método para introducir la orientacion hacia la que irá el barco y comprobar si colisiona o si cabe
	 */
	public static boolean colocarBarcosJugador(char[][] tablero, int longitudBarco) {
		boolean resultado = false;
		int fila;
		int columna;
		int orientacion;
		int[] coordenadas = new int[2];

		
		tableros.visualizar(tablero);
		tools.coordenadas("Introduce las coordenadas donde irá el barco", coordenadas);
		fila = coordenadas[0];
		columna = coordenadas[1];

		System.out.println("En que direccion lo quieres: ");
		System.out.println("---------------------------- ");
		System.out.println("1: Arriba ");
		System.out.println("2: Abajo ");
		System.out.println("3: Izquierda ");
		System.out.println("4: Derecha ");

		orientacion = tools.obtenerEntero("Introduce la orientación a continuacion: ");
		if(ponerBarco(tablero,orientacion,fila,columna,longitudBarco)==false) {
			return resultado;
		}else {
			return resultado =true;
		}
//		if (orientacion == 1) {
//			if ((cabeBarco(tablero, longitudBarco, fila, columna, orientacion) == true
//					&& hayColision(tablero, longitudBarco, fila, columna, orientacion) == false)) {
//				do {
//
//					tablero[fila][columna] = 'B';
//					longitudBarco--;
//					fila--;
//
//				} while (longitudBarco > 0);
//			}
//
//		} else if (orientacion == 2) {
//			if ((cabeBarco(tablero, longitudBarco, fila, columna, orientacion) == true
//					&& hayColision(tablero, longitudBarco, fila, columna, orientacion) == false)) {
//				do {
//					tablero[fila][columna] = 'B';
//					longitudBarco--;
//					fila++;
//
//				} while (longitudBarco > 0);
//			}
//
//		} else if (orientacion == 3) {
//			if ((cabeBarco(tablero, longitudBarco, fila, columna, orientacion) == true
//					&& hayColision(tablero, longitudBarco, fila, columna, orientacion) == false)) {
//				do {
//					tablero[fila][columna] = 'B';
//					longitudBarco--;
//					columna--;
//
//				} while (longitudBarco > 0);
//
//			} else if (orientacion == 4) {
//				if ((cabeBarco(tablero, longitudBarco, fila, columna, orientacion) == true
//						&& hayColision(tablero, longitudBarco, fila, columna, orientacion) == false)) {
//					do {
//						tablero[fila][columna] = 'B';
//						longitudBarco--;
//						columna++;
//
//					} while (longitudBarco > 0);
//				}
//			}
//		}

	}

	/*
	 * Método que genera barcos y posiciones aleatorias en las que se se realizara hasta que estén todos los barcos colocados 
	 */
	public static void barcoAleatorio(char[][] tablero) {

//		Scanner teclado = new Scanner(System.in);
		int[] barcos = { 2, 2, 2, 3, 3, 4 };
		int fila, columna, orientacion,longitudBarco;

		// for (int i = 0; i < barcos.length; i++) {
		
			for (int i = 0;i<barcos.length;i++) {
				do {	
					fila = (int) (Math.random() * 9);
					columna = (int) (Math.random() * 8 + 1);
					orientacion = (int) (Math.random() * 4 + 1);
					longitudBarco = barcos[i];
					System.out.println(fila + " " + columna + " " + orientacion);
				}while (ponerBarco(tablero,orientacion,fila,columna,longitudBarco)==false);
			}
		
	}	
	
	/*
	 * Método que comprobará si el barco que se ha generado aleatoriamente cabe dentro del vector o se coloca encima de otro barco
	 */
	public static boolean ponerBarco(char[][] tablero, int orientacion, int fila, int columna, int longitudBarco) {
			boolean resultado=false;
			if (orientacion == 1) {
				if ((cabeBarco(tablero, longitudBarco, fila, columna, orientacion) == true
						&& hayColision(tablero, longitudBarco, fila, columna, orientacion) == false)) {
					do {

						tablero[fila][columna] = 'B';
						longitudBarco--;
						fila--;

					} while (longitudBarco > 0);
					resultado = true;
				} 

			} else if (orientacion == 2) {
				if ((cabeBarco(tablero, longitudBarco, fila, columna, orientacion) == true
						&& hayColision(tablero, longitudBarco, fila, columna, orientacion) == false)) {
					do {
						tablero[fila][columna] = 'B';
						longitudBarco--;
						fila++;

					} while (longitudBarco > 0);
					resultado = true;
				}

			} else if (orientacion == 3) {
				if ((cabeBarco(tablero, longitudBarco, fila, columna, orientacion) == true
						&& hayColision(tablero, longitudBarco, fila, columna, orientacion) == false)) {
					do {
						tablero[fila][columna] = 'B';
						longitudBarco--;
						columna--;

					} while (longitudBarco > 0);
					resultado = true;
				}
			} else if (orientacion == 4) {
					if ((cabeBarco(tablero, longitudBarco, fila, columna, orientacion) == true
							&& hayColision(tablero, longitudBarco, fila, columna, orientacion) == false)) {
						do {
							tablero[fila][columna] = 'B';
							longitudBarco--;
							columna++;

						} while (longitudBarco > 0);
						resultado = true;
					}
				}
			return resultado;
		}	
}