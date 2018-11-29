package tools;

import java.util.Scanner;

public class tools {

	/*
	 * El m�todo de borrar lo que hace es insertar muchas 
	 * l�neas para parecer que empieza en blanco
	 */
	
	public void borrar() {
		for (int i = 0; i < 40; i++) {
			System.out.println();
		}
	}

	
	
	
	//Metodo en el que se mostrar� un mensaje y habr� que introducir un n�mero entero
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
	
	//Metodo en el que se mostrar� un mensaje y habr� que introducir un String
	public static String obtenerString (String msg) {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println(msg);
		return entrada.next();
	}
	
	//Metodo en el que se mostrar� un mensaje y habr� que introducir un n�mero float
	public static float obtenerFloat(String msg) {
		Scanner entrada = new Scanner(System.in);
		float valor = 0;
		String teclado;
		boolean loop = true;

		do {
			try {
				System.out.println(msg);
				teclado = entrada.next();
				valor = Float.parseFloat(teclado);
			//	System.out.println(valor);
				loop = false;
			} catch (Exception e) {
				System.out.println("Introduce un numero en formato numérico y con decimales");
			}
		} while (loop);

		return valor;
	}
	
	// Metodo en el que hay que introducir enter para continuar
	public void enter() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Pulsa [INTRO] para continuar.");
		entrada.nextLine();
		
	}
	
	//Metodo en el que se mostrar� un mensaje y habr� que introducir un caracter en may�scula
	public static char obtenerChar(String msg) {
		Scanner entrada = new Scanner(System.in);
		char valor = 0;
		String teclado;
		boolean loop = true;

		do {
				System.out.println(msg);
				teclado = entrada.next();
				valor = teclado.charAt(0);
				if (valor < 'A' || valor >'Z' || teclado.length() > 1) {
					System.out.println("Tienes que introducir una sola letra y esta ha de estar en mayuscula");
				} else { 
				loop = false;
				}
			
		} while (loop);

		return valor;
	}
	
	//Metodo en el que se mostrar� un mensaje y habr� que introducir un n�mero double
	public static double obtenerDouble(String msg) {
		Scanner entrada = new Scanner(System.in);
		double valor = 0;
		String teclado;
		boolean loop = true;

		do {
			try {
				System.out.println(msg);
				teclado = entrada.next();
				valor = Float.parseFloat(teclado);
			//	System.out.println(valor);
				loop = false;
			} catch (Exception e) {
				System.out.println("Introduce un numero en formato numérico y con decimales");
			}
		} while (loop);

		return valor;
	}
	
	// Metodo en el que se introduciran coordenadas para un tablero
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
			coordenadas[0] = (int) teclado.toUpperCase().charAt(0);
			coordenadas[1] = (int) teclado.charAt(1);
			coordenadaCorrecta = true;
			}
		}	
		
		return coordenadas;
		//return new int[] {fila,columna};
	//  int coordenadas[] = coordenadas();
	//  fila = coordenadas[0]; 
	//	columna = coordenadas[1]);
	}
	
	
	public static void mostrar(String[][] v) {
		for (int columna = 0; columna < v[0].length; columna++) {
			System.out.print(v[0][columna] + "\t");
		}
		System.out.println();
		for (int fila = 1; fila < v.length; fila++) {
			System.out.print(v[fila][0] + "\t");
			for (int columna = 1; columna < v[0].length; columna++) {
				System.out.printf("%.2f",Float.parseFloat(v[fila][columna]));
				System.out.print("\t");
			}
			System.out.println();
		}
	}
	
	
	public static char letraAleatoria(){
		int resultado=(int)(Math.random()*26+36); 
		char letra=(char)resultado;
		return letra;
	}
	
	
	public static int numAleatorio(int maximo, int minimo) {
		int random=(int)(Math.random()*(maximo-minimo+1)+minimo);
		return random;
	}
	
}
