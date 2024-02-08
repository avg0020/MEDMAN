package vista;

import java.util.concurrent.Semaphore;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Buffer {

	// Atributos
	private JLabel lblmedman;
	private int xDirection, yDirection, xTablero = 7, yTablero = 8, contPremios=0;
	private int []xPremios = new int[6];
	private int []yPremios = new int[6];
	private PruebaMove game;
	private Semaphore semaforoMedman = new Semaphore(1);
	private int vidas;
	
	// Matriz del mapa
	// 0 - Camino
	// 1 - Muro
	// 20 - Medgast
	// 3 - Medman
	// 40 - Premios
	// 5 - Salida izquierda
	// 6 - Salida derecha

	private int[][] tablero = {
			{ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, /**/ 1, 0, 0, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 1, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 0, 0, 1, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 0, 1 },
			{ 1, 0, 1, 1, 0, /**/ 1, 0, 1, 1, 1, /**/ 0, 1, 0, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 0, 1, 0, /**/ 1, 1, 1, 0, 1, /**/ 0, 1, 1, 1, 0, /**/ 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 1, 0, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 0, 1, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 0, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 0, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 0, 1, 1, 1, /**/ 1, 1, 1, 0, 1, /**/ 1, 1, 1, 1, 0, /**/ 1, 1, 0, 1 },
			// ------------------------------------------------------------------------------------------------------------------------------
			{ 1, 0, 0, 0, 0, /**/ 0, 0, 0, 1, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 1, 0, 0, /**/ 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, /**/ 0, 1, 0, 0, 0, /**/ 1, 0, 1, 1, 1, /**/ 1, 0, 1, 1, 1, /**/ 0, 0, 1, 1, 1, /**/ 1, 0, 1, 1, 1, /**/ 1, 0, 1, 0, 1, /**/ 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, /**/ 0, 1, 1, 3, 1, /**/ 1, 0, 1, 0, 0, /**/ 0, 0, 1, 1, 1, /**/ 1, 0, 1, 0, 0, /**/ 1, 0, 1, 0, 0, /**/ 0, 0, 1, 0, 1, /**/ 1, 1, 1, 1 },
			{ 1, 1, 1, 5, 0, /**/ 0, 1, 0, 1, 0, /**/ 1, 0, 1, 1, 1, /**/ 1, 0, 1, 1, 1, /**/ 1, 0, 1, 1, 1, /**/ 1, 0, 1, 0, 1, /**/ 1, 1, 1, 0, 0, /**/ 6, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, /**/ 0, 1, 0, 0, 0, /**/ 1, 0, 1, 0, 0, /**/ 0, 0, 1, 1, 1, /**/ 1, 0, 1, 0, 0, /**/ 1, 0, 1, 0, 0, /**/ 0, 0, 1, 0, 1, /**/ 1, 1, 1, 1 },
			// ------------------------------------------------------------------------------------------------------------------------------
			{ 1, 1, 1, 1, 1, /**/ 0, 1, 0, 1, 0, /**/ 1, 0, 1, 1, 1, /**/ 1, 0, 1, 1, 1, /**/ 0, 0, 1, 0, 0, /**/ 1, 0, 1, 1, 1, /**/ 1, 0, 1, 0, 1, /**/ 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, /**/ 0, 0, 0, 1, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 1, 0, 0, /**/ 0, 0, 0, 1 },
			{ 1, 0, 1, 1, 0, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 0, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 0, 1, 1, 1, /**/ 1, 1, 1, 0, 1, /**/ 1, 1, 1, 1, 0, /**/ 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 1, 0, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 0, 1, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 0, /**/ 1, 0, 1, 1, 1, /**/ 0, 1, 0, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 0, 1, 0, /**/ 1, 1, 1, 0, 1, /**/ 0, 1, 1, 1, 0, /**/ 1, 1, 0, 1 },
			// ------------------------------------------------------------------------------------------------------------------------------
			{ 1, 0, 0, 0, 0, /**/ 1, 0, 0, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 1, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 0, 0, 1, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1 } };

	// Constructor
	public Buffer(JLabel lbl, PruebaMove game) {
		this.lblmedman = lbl;
		this.game = game;
		this.vidas = 3;
		for (int i = 0; i < 6; i++) {
			boolean isValid = false;
			int x, y;
			
			//Hasta que sea una posicion valida para colocar los premios
			do {
				x = (int)Math.round(Math.random()*16);
				y = (int)Math.round(Math.random()*38);
				
				if (tablero[x][y]==0) {
					isValid = true;
				}
			} while (isValid == false);
			
			System.out.println(x+" | "+y);
			tablero[x][y]=41+i;
			xPremios[i]=x;
			yPremios[i]=y;
		}
	}
	
	// Métodos

	// Movimiento del personaje
	public void moverMedman() throws Exception{
		// a
		if ((tablero[xTablero][yTablero - 1] == 0 || tablero[xTablero][yTablero - 1] > 40) && xDirection == -30) {
			lblmedman.setLocation(lblmedman.getX() + xDirection, lblmedman.getY() + yDirection);
			yTablero--;
		}

		// d
		if ((tablero[xTablero][yTablero + 1] == 0 || tablero[xTablero][yTablero + 1] > 40) && xDirection == +30) {
			lblmedman.setLocation(lblmedman.getX() + xDirection, lblmedman.getY() + yDirection);
			yTablero++;
		}

		// w
		if ((tablero[xTablero - 1][yTablero] == 0 || tablero[xTablero - 1][yTablero] > 40) && yDirection == -30) {
			lblmedman.setLocation(lblmedman.getX() + xDirection, lblmedman.getY() + yDirection);
			xTablero--;
		}

		// s
		if ((tablero[xTablero + 1][yTablero] == 0 || tablero[xTablero + 1][yTablero] > 40) && yDirection == +30) {
			lblmedman.setLocation(lblmedman.getX() + xDirection, lblmedman.getY() + yDirection);
			xTablero++;
		}

		// Izquierda - Derecha
		if (tablero[xTablero][yTablero - 1] == 5 && xDirection == -30) {
			lblmedman.setLocation(1050, 240);
			xTablero = 8;
			yTablero = 35;
		}

		// Derecha - Izquierda
		if (tablero[xTablero][yTablero + 1] == 6 && xDirection == +30) {
			lblmedman.setLocation(90, 240);
			xTablero = 8;
			yTablero = 3;
		}
		
		semaforoMedman.acquire();
		if((xTablero==game.getMedgast21().getxTablero() && yTablero==game.getMedgast21().getyTablero()) || 
		   (xTablero==game.getMedgast22().getxTablero() && yTablero==game.getMedgast22().getyTablero()) ||
		   (xTablero==game.getMedgast24().getxTablero() && yTablero==game.getMedgast23().getyTablero()) ||
		   (xTablero==game.getMedgast24().getxTablero() && yTablero==game.getMedgast24().getyTablero())) {
			
			morir();
			
		}
		semaforoMedman.release();
		
		if(tablero[xTablero][yTablero] >40) {
			cogerPremio();
		}
	}

	// Movimiento de los fantasmas
	// 0 - derecha
	// 1 - arriba
	// 2 - izquierda
	// 3 - abajo

	public void moverMedgast(Medgast medgast) throws Exception{
		// Asegura una posición valida
		boolean isPosible = false;
		while (isPosible == false) {
			// Le damos prioridad a continuar el la direccion que va para que intente
			// avanzar
			double continuar = Math.round(Math.random());
			if (continuar>0.75) {
				medgast.setDireccion((int) Math.round(Math.random()*4));
				
			}
			
			//Se ve si la dirección es posible
			switch (medgast.getDireccion()) {
			case 0: // Derecha
				if (tablero[medgast.getxTablero()][medgast.getyTablero() + 1] == 0 || tablero[medgast.getxTablero()][medgast.getyTablero() + 1] > 40 ) {
					medgast.getLbl().setLocation(medgast.getLbl().getX() + 30, medgast.getLbl().getY());
					medgast.setyTablero(medgast.getyTablero()+1);					
					isPosible=true;
				} 
				break;
			case 1: // Arriba
				if (tablero[medgast.getxTablero() - 1][medgast.getyTablero()] == 0 || tablero[medgast.getxTablero() - 1][medgast.getyTablero()] > 40 ) {
					medgast.getLbl().setLocation(medgast.getLbl().getX(), medgast.getLbl().getY() - 30);
					medgast.setxTablero(medgast.getxTablero()-1);					
					isPosible = true;
				}
				break;
			case 2: // Izquierda
				if (tablero[medgast.getxTablero()][medgast.getyTablero() - 1] == 0 || tablero[medgast.getxTablero()][medgast.getyTablero() - 1] > 40 ) {
					medgast.getLbl().setLocation(medgast.getLbl().getX() - 30, medgast.getLbl().getY());
					medgast.setyTablero(medgast.getyTablero()-1);						
					isPosible = true;
				}
				break;
			case 3: // Abajo
				if (tablero[medgast.getxTablero() + 1][medgast.getyTablero()] == 0 || tablero[medgast.getxTablero() + 1][medgast.getyTablero()] > 40) {
					medgast.getLbl().setLocation(medgast.getLbl().getX(), medgast.getLbl().getY()+30);
					medgast.setxTablero(medgast.getxTablero()+1);					
					isPosible = true;
				}
				break;
			}
		}
		semaforoMedman.acquire();
		if(medgast.getxTablero()==xTablero && medgast.getyTablero()==yTablero) {
			morir();
		}
		semaforoMedman.release();
	}
	
	// Coger el premio
	public void cogerPremio() {
		if (tablero[xTablero][yTablero] > 40) {
			switch (tablero[xTablero][yTablero]) {
			case 41:
				game.getPanel().remove(game.getLblPremio1());
				contPremios++;
				break;
			case 42:
				game.getPanel().remove(game.getLblPremio2());
				contPremios++;
				break;
			case 43:
				game.getPanel().remove(game.getLblPremio3());
				contPremios++;
				break;
			case 44:
				game.getPanel().remove(game.getLblPremio4());
				contPremios++;
				break;
			case 45:
				game.getPanel().remove(game.getLblPremio5());
				contPremios++;
				break;
			case 46:
				game.getPanel().remove(game.getLblPremio6());
				contPremios++;
				break;				
			}
		}
	}
	
	public boolean isPremio(Medgast medgast) {
		if(tablero[medgast.getxTablero()][medgast.getyTablero()]>40) {
			return true;
		}else {
			return false;
		}
	}
	
	public void morir() throws InterruptedException {
		//Medman
		tablero[xTablero][yTablero]=0;
		xTablero=7;
		yTablero=8;
		tablero[7][8]=3;
		xDirection=0;
		yDirection=0;
		lblmedman.setLocation(240, 210);
		
		//Medgast
		game.resetMegast21();
		game.resetMegast22();
		game.resetMegast23();
		game.resetMegast24();
		
		//Otros
		vidas--;
	}
	
	// Getter y Setter
	public int getXDirection() {
		return xDirection;
	}

	public void setXDirection(int xDirecction) {
		this.xDirection = xDirecction;
	}

	public int getYDirection() {
		return yDirection;
	}

	public void setYDirection(int yDirection) {
		this.yDirection = yDirection;
	}

	public int getXPremios(int position) {
		return xPremios[position];
	}
	
	public int getYPremios(int position) {
		return yPremios[position];
	}

	public void setxTablero(int xTablero) {
		this.xTablero = xTablero;
	}

	public int[] getxPremios() {
		return xPremios;
	}

	public void setxPremios(int[] xPremios) {
		this.xPremios = xPremios;
	}
	
	
}
