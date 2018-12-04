package HundirLaFlota;

import java.util.Scanner;

import tools.tools;

public class barcos {

	/*
	 * Este metodo comprobara si se está intentando colocar un barco donde ya hay
	 * otro situado
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
	 * Este método se encargara de crear un menú para ingresar los barcos del
	 * jugador
	 */
	public static void menuBarcos(char[][] tablero) {

		Scanner teclado = new Scanner(System.in);
		int opcion;
		int contador = 0;
		int barco2 = 3, barco3 = 2, barco4 = 1;
		int longitudBarco;
//		CREAMOS EL MENÚ QUE SE REPETIRÁ HASTA INTRODUCIR LOS BARCOS
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

// 			CONDICIONAMOS LA ELECCION DEL MENU

			if (opcion < 1 || opcion > 3) {
				System.out.println("Las opciones validas son [1-3] [Salir -1]");
				opcion = tools.obtenerEntero("Elija otra opcion");
			}
//			SEGUN LA ELECCION DEL BARCO LE OTORGAMOS LONGITUD Y CONDICIONAMOS EL INTRODUCIR EL BARCO
			if (opcion == 1) {
				if (barco2 != 0) {
					longitudBarco = 2;
					if (colocarBarcosJugador(tablero, longitudBarco) == true) {
						barco2--;
						System.out.println("Barco introducido correctamente");
					} else {
						System.out.println("Coordenadas incorrectas");
						
					}
				}
			} else if (opcion == 2) {
				if (barco3 != 0) {
					longitudBarco = 3;
					if (colocarBarcosJugador(tablero, longitudBarco) == true) {
						barco3--;
						System.out.println("Barco introducido correctamente");
					} else {
						System.out.println("Coordenadas incorrectas");
						
					}
				}
			} else if (opcion == 3) {
				if (barco4 != 0) {
					longitudBarco = 4;
					if (colocarBarcosJugador(tablero, longitudBarco) == true) {
						barco4--;
						System.out.println("Barco introducido correctamente");
					} else {
						System.out.println("Coordenadas incorrectas");
						
					}
				}
			}
		} while (barco2 != 0 || barco3 != 0 || barco4 != 0);

	}

	/*
	 * Este método se encarga de comprobar si se está situando el barco dentro de el
	 * tablero
	 */
	public static boolean cabeBarco(char[][] tablero, int longitudBarco, int fila, int columna, int orientacion) {
//		CREAMOS LA VARIABLE QUE NOS DIRÁ SI ESTA DENTRO DE EL TABLERO EL BARCO
		boolean dentro = true;

//		COMPROBAMOS SEGÚN LA ORIENTACIÓN SI EL BARCO ESTÁ DENTRO DURANTE TODA SU LONGITUD
		if (orientacion == 1) {
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
//		DEVOLVEMOS LA VARIABLE PARA AVERIGUAR SI HAY QUE REPETIR CON OTRA COORDENADA
		return dentro;
	}

	/*
	 * Método, que se encarga de hacer un recuento instantáneo que que le queda al
	 * poseedor del tablero que se nombre
	 */
	public static int vidas(char[][] tablero) {
//		RECORREMOS LA MATRIZ BUSCANDO DONDE HAY REGISTROS DE BARCOS PARA CONTAR LAS VIDAS 
		int cuenta = 0;
		for (int i = 0; i < tablero[0].length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				if (tablero[i][j] == 'B') {
					cuenta++;
				}
			}
		}
//		DEVOLVEMOS EL RESULTADO MENOS 1 YA QUE TENEMOS UNA B EN EL TABLERO POR LAS COORDENADAS
		return cuenta - 1;
	}

	/*
	 * Desde menuBarcos se llama este método para introducir la orientacion hacia la
	 * que irá el barco y comprobar si colisiona o si cabe
	 */
	public static boolean colocarBarcosJugador(char[][] tablero, int longitudBarco) {
//		CREAMOS LAS VARIABLES NECESARIAS PARA IMPLEMENTAR EL BARCO		
		boolean resultado = false;
		int fila;
		int columna;
		int orientacion;
		int[] coordenadas = new int[2];

//		INTRODUCIMOS LAS COORDENADAS E INDICAMOS LA DIRECCIÓN QUE TENDRÁ EL BARCO
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
//		COMPROBAMOS SI EL BARCO SERÁ INTRODUCIDO O NOS TOCARÁ REPETIR EL METODO QUE SERÁ LLAMADO
		if (ponerBarco(tablero, orientacion, fila, columna, longitudBarco) == false) {
			return resultado;
		} else {
			return resultado = true;
		}
	}

	/*
	 * Método que genera barcos y posiciones aleatorias en las que se se realizara
	 * hasta que estén todos los barcos colocados
	 */
	public static void barcoAleatorio(char[][] tablero) {
//		CREAMOS LAS VARIABLES NECESARIAS Y EL VECTOR CON LOS BARCOS QUE SE VAN A INTRODUCIR DENTRO
		int[] barcos = { 2, 2, 2, 3, 3, 4 };
		int fila, columna, orientacion, longitudBarco;
//		RECORREMOS LOS BARCOS UNO A UNO, PROPORCIONANDOLES UNA COORDENADA Y ORIENTACION ALEATORIA
		for (int i = 0; i < barcos.length; i++) {
//		REALIZAMOS UN BUCLE PARA INSERTAR UN BARCO SIEMPRE QUE LAS COORDENADAS NO SEAN LAS NECESARIAS			
			do {
				fila = (int) (Math.random() * 9);
				columna = (int) (Math.random() * 8 + 1);
				orientacion = (int) (Math.random() * 4 + 1);
				longitudBarco = barcos[i];
			} while (ponerBarco(tablero, orientacion, fila, columna, longitudBarco) == false);
		}
	}

	/*
	 * Método que comprobará si el barco que se ha generado aleatoriamente cabe
	 * dentro del vector o se coloca encima de otro barco
	 */
	public static boolean ponerBarco(char[][] tablero, int orientacion, int fila, int columna, int longitudBarco) {
//		CREAMOS LA VARIABLE QUE NOS DIRÁ SI EL BARCO SE HA INTRODUCIDO
		boolean resultado = false;
//		CONDICIONAMOS POR ORIENTACIÓN SI SE VA A INTRODUCIR EL BARCO SI CABE Y NO SOLAPA 		
		if (orientacion == 1) {
			if ((cabeBarco(tablero, longitudBarco, fila, columna, orientacion) == true
					&& hayColision(tablero, longitudBarco, fila, columna, orientacion) == false)) {
//		INGRESAMOS 'B' EN EL TABLERO HASTA QUE SE ACABE LA LONGITUD DEL BARCO				
				do {
					tablero[fila][columna] = 'B';
					longitudBarco--;
					fila--;
				} while (longitudBarco > 0);
//		CAMBIAMOS LA VARIABLE PARA SABER QUE SE HA INTRODUCIDO
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
//		DEVOLVEMOS EL RESULTADO DE LO QUE SE HA REALIZADO PARA ACLARAR SI SE HA INTRODUCIDO EL BARCO
		return resultado;
	}
}