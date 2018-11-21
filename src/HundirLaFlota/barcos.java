package HundirLaFlota;
import tools.tools;
public class barcos {

	/*
	 * Este metodo comprobara si se est� intentando colocar un barco donde ya hay
	 * otro situado
	 */
	public boolean hayColision(char[][] tablero, int longitudBarco, int fila, int columna, int orientacion) {
		//creamos la variable colision a false para guardar el resultado de la comprobación
		boolean colision = false;
		
		//Comprobaremos si hay colision segun la orientacion que se haya elegido
		if (orientacion == 1) {
			
			//Bucle para devolver el dato mientras el barco siga teniendo longitud, y
			//  no haya otro barco en el sitio.
			for (int i = 0; i < longitudBarco && colision == false; i++, fila--) {
				
				//Mientras sea agua el resultado escogido no habr� colisi�n
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
	 * En este m�todo se comprobar� si el barco se va a intentar colocar dentro de el tablero
	 * o se intenta insertar fuera de el tablero
	 */
	public static boolean cabeBarco(char[][] tablero, int longitudBarco, int fila, int columna, int orientacion,boolean jugador){
		// Creamos la variable en la que se va a almacenar si el barco queda dentro del tablero o no
		boolean dentro = true;
			
			// Se comprueba si el barco cabe seg�n la orientacion que este tenga
			if (orientacion == 1) {
				// Se realiza un bucle para que se realice la comprobaci�n siempre que el barco siga teniendo longitud
				// y que no se est� intentando situar fuera
				for (int i = 0; i < longitudBarco && dentro == true; i++, fila--) {
				
					if ((tablero[fila][columna]>=tablero[0][1]) && (tablero[fila][columna]<=tablero[9][9])) {
						dentro = true;
					} else {
						dentro = false;
					}
				}
			} else if (orientacion == 2) {
				for (int i = 0; i < longitudBarco && dentro == true; i++, fila++) {
					if ((tablero[fila][columna]>=tablero[0][1]) && (tablero[fila][columna]<=tablero[9][9])) {
						dentro = true;
					} else {
						dentro = false;
					}
				}
			} else if (orientacion == 3) {
				for (int i = 0; i < longitudBarco && dentro == true; i++, columna--) {
					if ((tablero[fila][columna]>=tablero[0][1]) && (tablero[fila][columna]<=tablero[9][9])) {
						dentro = true;
					} else {
						dentro = false;
					}
				}
			} else if (orientacion == 4) {
				for (int i = 0; i < longitudBarco && dentro == true; i++, columna++) {
					if ((tablero[fila][columna]>=tablero[0][1]) && (tablero[fila][columna]<=tablero[9][9])) {
						dentro = true;
					} else {
						dentro = false;
					}
				}
			}
		
		// devolvemos el valor que nos indica si el barco quedaria dentro del tablero o no
		return dentro;
	}
	
	
	/*
	 * En este metodo se va a sumar todas las longitudes de los barcos, para poder llevar
	 * una cuenta inicial de las vidas que les quedan a cada jugador.
	 */
	public int vidas(char[][]tablero){
		// en la variable cuenta guardaremos el recuento de cada barco de todo el vector
		int cuenta=0;
		for (int i = 0 ; i < tablero[0].length; i++) {
			for (int j = 0 ; j < tablero.length; j++) {
				if(tablero[i][j]=='B') {
					cuenta++; 
				}
			}
		}
		return cuenta;
	}
	

	public void colocarBarcosJugador(char[][] tablero, char[][] tableroDisparos, int[] barcos) {
		
//		Scanner teclado = new Scanner(System.in);
		
		int fila;
		int columna;
		int orientacion;
		int longitudBarco;
		String posicion;
		
		//Jugador = true ya que estamos hablando de los barcos del jugador, no del pc.
		boolean jugador=true;
		
		for (int i = 0; i < barcos.length; i++) {
				do {
					longitudBarco = barcos[i];
					
					posicion = tools.obtenerString("Indique la posicion donde quieras colocar el barco");
					fila=(int)posicion.charAt(0);
					columna = posicion.charAt(1);
					
					System.out.println("En que direccion lo quieres: ");
					System.out.println("---------------------------- ");
					System.out.println("1: Arriba ");
					System.out.println("2: Abajo ");
					System.out.println("3: Izquierda ");
					System.out.println("4: Derecha ");
			
					//Importas el metodo obtenerEntero que lo que hara sera seleccionar un numero del 1 al 4
					//para elegir la orientacion
					orientacion = tools.obtenerEntero("Introduce la direccion a continuacion: ");
					
					//Si marcas la opcion 1 te creara un barco hacia arriba si hay un hueco y no hay colision 
					//en el tablero entonces colocaras el barco con una B de barco restando la fila mientras la 
					//longitud del barco sea mayor que 0
					if (orientacion==1) {
						if ((cabeBarco(tablero, longitudBarco, fila, columna, orientacion, jugador)==true
								&& hayColision(tablero, longitudBarco, fila, columna, orientacion)==false)) {
							do {
								
								tablero[fila][columna]='B';
								fila--;
								
							} while (longitudBarco>0);
						}
					//Si marcas la opcion 2 te creara un barco hacia abajo si hay un hueco y no hay colision 
					//en el tablero entonces colocaras el barco con una B de barco sumando la fila mientras la 
					//longitud del barco sea mayor que 0
					} else if (orientacion==2) {
						if (cabeBarco(tablero, longitudBarco, fila, columna, orientacion, jugador)==true 
								&& hayColision(tablero, longitudBarco, fila, columna, orientacion)==false) {
							do {
								tablero[fila][columna]='B';
								fila++;
								
							} while (longitudBarco>0);
						}
						
					//Si marcas la opcion 3 te creara un barco hacia la izquierda si hay un hueco y no hay colision 
					//en el tablero entonces colocaras el barco con una B de barco restando la columna mientras la 
					//longitud del barco sea mayor que 0
					} else if (orientacion==3) {
						if (cabeBarco(tablero, longitudBarco, fila, columna, orientacion, jugador)==true 
								&& hayColision(tablero, longitudBarco, fila, columna, orientacion)==false) {
							do {
								tablero[fila][columna]='B';
								columna--;
								
							} while (longitudBarco>0);
							
					
							
					//Si marcas la opcion 4 te creara un barco hacia la derecha si hay un hueco y no hay colision 
					//en el tablero entonces colocaras el barco con una B de barco sumando la columna mientras la 
					//longitud del barco sea mayor que 0	
					} else if (orientacion==4) {
						if (cabeBarco(tablero, longitudBarco, fila, columna, orientacion, jugador)==true 
								&& hayColision(tablero, longitudBarco, fila, columna, orientacion)==false) {
							do {
								tablero[fila][columna]='B';
								columna++;
								
							} while (longitudBarco>0);
					}
						
					}
					
				} 
		} while(i<barcos.length);
	}
	}
		
	/* 
	 *Este metodo dara una posicion aleatoria para posicionar el barco
	 */
		public void colocarBarcosPC(char[][] tablero, char[][]tableroPC, int[] barcos){
			int fila, columna, longitudBarco, orientacion;
			boolean jugador=false;
			
			for(int i=0;i<barcos.length;i++) {				
				do {
						//Aqui damos una posicion aleatoria para un barco
						fila=tools.numAleatorio(0, 9);	
						columna=tools.numAleatorio(1, 9);
						longitudBarco=barcos[i];	
						orientacion=tools.numAleatorio(1,4);
						
				}
				while(!colocarBarco(tablero, tableroPC, longitudBarco, fila, columna, orientacion, jugador));
				
			}
		}
		/*
		 * Este metodo comprueba llamando al metodo hayColision, que se pueda colocar el barco, en caso
		 * afirmativo pasa un true como que se puede colocar el barco y lo coloca
		 */
	public boolean colocarBarco(char[][] tablero, char [][] tableroPC, int longitudBarco, int fila, int columna, int orientacion,boolean jugador){
		//Si jugador es true, quiere decir que vamos a comprobar y colocar en el tablero del jugador
			
				//A partir de aquí hace lo mismo pero para el caso de que haya que posicionar barcos del pc
				if(orientacion==1) {
					for(int i=0;i<longitudBarco;i++, fila--) {
						if((hayColision(tableroPC, longitudBarco, fila, columna, orientacion))) {
							return false;
						}
						if(!cabeBarco(tableroPC, longitudBarco, fila, columna, orientacion, jugador)) {
							return false;
						}
					}
				}else {
					if(orientacion==2) {
						for(int i=0;i<longitudBarco;i++, fila++) {
							if((hayColision(tableroPC, longitudBarco, fila, columna, orientacion))) {
								return false;
							}
							if(!cabeBarco(tableroPC, longitudBarco, fila, columna, orientacion, jugador)) {
								return false;
							}
						}
					}else {
						if(orientacion==3) {
							for(int i=0;i<longitudBarco;i++, columna++) {
								if((hayColision(tableroPC, longitudBarco, fila, columna, orientacion))) {
									return false;
								}
								if(!cabeBarco(tableroPC, longitudBarco, fila, columna, orientacion, jugador)) {
									return false;
								}
							}
						}else {
							if(orientacion==4) {
								for(int i=0;i<longitudBarco;i++, columna--) {
									if((hayColision(tableroPC, longitudBarco, fila, columna, orientacion))) {
										return false;
									}
									if(!cabeBarco(tableroPC, longitudBarco, fila, columna, orientacion, jugador)) {
										return false;
									}
								}
							}
						}
					}
				}
				
				if(orientacion==1) {
					for(int i=0;i<longitudBarco;i++, fila--) {
						tableroPC[fila][columna]='B';
					}
				}else {
					if(orientacion==2) {
						for(int i=0;i<longitudBarco;i++, fila++) {
							tableroPC[fila][columna]='B';
						}
					}else {
						if(orientacion==3) {
							for(int i=0;i<longitudBarco;i++, columna++) {
								tableroPC[fila][columna]='B';
							}
						}else {
							if(orientacion==4) {
								for(int i=0;i<longitudBarco;i++, columna--) {
									tableroPC[fila][columna]='B';
								}
							}
						}
					}
				}
				
				return true;
			
		}

}