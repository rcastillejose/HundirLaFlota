package tools;

import java.util.Scanner;

public class tools {

	/*
	 * Método que inserta líneas para hacer parecer que se borra la pantalla 
	 */
	public static void borrar() {
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
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println(msg);
		return entrada.next();
	}
	

	
	/*
	 * Método de introducir un enter para continuar
	 */
	public void enter() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Pulsa [INTRO] para continuar.");
		entrada.nextLine();
		
	}

	
	/*
	 * Método en el que se introducen las coordenadas de una matriz
	 */
	public static int[] coordenadas(String msg,int[]coordenadas) {
		boolean coordenadaCorrecta=false;
		Scanner entrada = new Scanner(System.in);
		String teclado;
		
		while(!coordenadaCorrecta) {
			
			System.out.println(msg);
			teclado = entrada.next();
			if (teclado.length()<2) {
				System.out.println("Introduce una dirección válida");
				teclado = entrada.next();
			} else {
			coordenadas[0] = (int) teclado.toUpperCase().charAt(0)-'A';
			coordenadas[1] = (int) teclado.charAt(1)-'0';
			//System.out.println(coordenadas[0]+" "+coordenadas[1]);
			coordenadaCorrecta = true;
			}
		}	
		
		return coordenadas;
	}
	
}
