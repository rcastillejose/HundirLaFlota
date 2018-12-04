package tools;

import java.util.Scanner;

public class tools {

	/*
	 * Método que se encarga de borrar la pantalla
	 */
	public static void borrar() {
// INGRESAMOS MUCHAS LÍNEAS A LA VEZ PARA SIMULAR EL CAMBIO DE PÁGINA
		for (int i = 0; i < 40; i++) {
			System.out.println();
		}
	}
	
	/*
	 * Metodo para obtener un número entero
	 */
	public static int obtenerEntero(String msg) {
		
		Scanner entrada = new Scanner(System.in);
		
		int valor = 0;
		String teclado;
		boolean loop = true;
//		SE MOSTRARÁ UN MENSAJE EN PANTALLA QUE SE ELIJA CUANDO SE LLAME Y SE ENCARGARÁ
//		DE QUE LO QUE SE INTRODUZCA SEA UN NÚMERO ENTERO O DARA ERROR
		do {
			try {
				System.out.println(msg);
				teclado = entrada.next();
				valor = Integer.parseInt(teclado);
				loop = false;
			} catch (Exception e) {
				System.out.println("Introduce un numero en formato num�rico");
			}
		} while (loop);

		return valor;
	}
	
	/*
	 * Metodo para mostrar un mensaje;
	 */
	public static String obtenerString(String msg) {
//		SE MOSTRARÁ UN MENSAJE EN PANTALLA Y OBTENDREMOS UN STRING
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.next();
	}
	
	/*
	 * Método de introducir un enter para continuar
	 */
	public void enter() {
//		PEDIREMOS QUE SE PULSE LA TECLA ENTER PARA CONTINUAR
		Scanner entrada = new Scanner(System.in);
		System.out.println("Pulsa [INTRO] para continuar.");
		entrada.nextLine();
	}

	
	/*
	 * Método en el que se introducen las coordenadas de una matriz
	 */
	public static int[] coordenadas(String msg,int[]coordenadas) {
//		DECLARAMOS LAS VARIABLES NECESARIAS PARA OBTENER UN STRING
		boolean coordenadaCorrecta=false;
		Scanner entrada = new Scanner(System.in);
		String teclado;
//		MIENTRAS LAS COORDENADAS ESTÉN BIEN PUESTAS CAMBIAREMOS LOS DATOS PARA OBTENER UN VECTOR
//		CON LAS COORDENADAS ELEGIDAS
		while(!coordenadaCorrecta) {
			System.out.println(msg);
			teclado = entrada.next();
//		CONDICIONAMOS EL TAMAÑO DEL STRING INTRODUCIDO
			if (teclado.length()<2) {
				System.out.println("Introduce una dirección válida");
				teclado = entrada.next();
			} else {
//		TRANSFORMAMOS LAS COORDENADAS EN MAYUSCULAS, EN CARACTER Y LE RESTAMOS LA PRIMERA LETRA PARA
//		OBTENER EL NÚMERO
			coordenadas[0] = (int) teclado.toUpperCase().charAt(0)-'A';
			coordenadas[1] = (int) teclado.charAt(1)-'0';
// 		EJEMPLO PARA SABER LAS COORDENADAS QUE OBTENEMOS
			//System.out.println(coordenadas[0]+" "+coordenadas[1]);
			coordenadaCorrecta = true;
			}
		}	
//		DEVOLVEMOS EL VECTOR CON LAS COORDENADAS YA CONVERTIDAS EN NUMEROS
		return coordenadas;
	}
	
}
