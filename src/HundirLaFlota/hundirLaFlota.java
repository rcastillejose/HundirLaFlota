package HundirLaFlota;
import tools.tools;

public class hundirLaFlota {

	public static void main(String[] args) {
		
		//IMPORTAMOS LOS PAQUETES QUE SE UTILIZARAN
		tools tools = new tools();
		
		// DECLARAMOS VARIABLES Y VECTORES QUE SE UTILIZAR�N
		char[][] tableroJ= new char [10][10];
		char[][] disparoJugador= new char [10][10];
		char[][] tableroPc= new char [10][10];
		char[][] disparoPc= new char [10][10];
		
		String nombre;
		
		//P�GINA DE BIENVENIDA		
		System.out.println();
		System.out.println();
		System.out.println();		
		System.out.println("		**************************************************");
		System.out.println("		**************************************************");
		System.out.println("		****      BIENVENIDO A HUNDIR LA FLOTA        ****");
		System.out.println("		**************************************************");
		System.out.println("		*********************************************RDR**");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		nombre = tools.obtenerString("Introduce tu nombre para comenzar: ");
		tools.enter();
 
		tools.borrar();
		
		//SE INICIAN LOS TABLEROS A UTILIZAR EN EL JUEGO
		tableros.iniciar(tableroJ);
		tableros.iniciar(disparoJugador);
		tableros.iniciar(tableroPc);
		tableros.iniciar(disparoPc);
		
		//RELLENAMOS EL TABLERO DEL JUGADOR Y EL DEL PC
		System.out.println("Bienvenido " + nombre + ", en primer luegar vamos a rellenar el siguiente tablero con tus barcos");
		tableros.visualizar(tableroJ);
		tools.enter();
		
		tools.borrar();
		
		barcos.menuBarcos(tableroJ);
		
		System.out.println("Se han introducido todos los barcos correctamente");
		tools.enter();
		tools.borrar();
		
		//AHORA COMIENZA EL JUEGO

			System.out.println("Tienes "+ barcos.vidas(tableroJ)+"vidas");
			tableros.visualizar(tableroJ);
		
		
		
	}

}
