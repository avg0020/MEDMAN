package vista;

import javax.swing.JLabel;

public class Buffer {

	// Atributos
	private JLabel lbl;
	private int xDirection, yDirection, xTablero = 7, yTablero = 8;

	// Matriz del mapa
	// 0 - Camino
	// 1 - Muro
	// 2 - Medgast
	// 3 - Medman
	// 4 - Premios
	// 5 - Salida izquierda
	// 6 - Salida derecha

	private int[][] tablero = {
			{ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, /**/ 1, 0, 0, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 1, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 0, 0, 1, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 0, 1 },
			{ 1, 0, 1, 1, 0, /**/ 1, 0, 1, 1, 1, /**/ 0, 1, 0, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 0, 1, 0, /**/ 1, 1, 1, 0, 1, /**/ 0, 1, 1, 1, 0, /**/ 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 1, 0, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 0, 1, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 0, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 0, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 0, 1, 1, 1, /**/ 1, 1, 1, 0, 1, /**/ 1, 1, 1, 1, 0, /**/ 1, 1, 0, 1 },
			// ------------------------------------------------------------------------------------------------------------------------------
			{ 1, 0, 0, 0, 0, /**/ 0, 0, 0, 1, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0,
					0, 0, 0, /**/ 0, 0, 1, 0, 0, /**/ 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, /**/ 0, 1, 0, 0, 0, /**/ 1, 0, 1, 1, 1, /**/ 1, 0, 1, 1, 1, /**/ 0, 0, 1, 1, 1, /**/ 1, 0,
					1, 1, 1, /**/ 1, 0, 1, 0, 1, /**/ 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, /**/ 0, 1, 1, 0, 1, /**/ 1, 0, 1, 0, 0, /**/ 0, 0, 1, 0, 0, /**/ 1, 0, 1, 0, 0, /**/ 1, 0,
					1, 0, 0, /**/ 0, 0, 1, 0, 1, /**/ 1, 1, 1, 1 },
			{ 1, 1, 1, 5, 0, /**/ 0, 1, 0, 1, 0, /**/ 1, 0, 1, 1, 1, /**/ 1, 0, 1, 0, 0, /**/ 1, 0, 1, 1, 1, /**/ 1, 0,
					1, 0, 1, /**/ 1, 1, 1, 0, 0, /**/ 6, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, /**/ 0, 1, 0, 0, 0, /**/ 1, 0, 1, 0, 0, /**/ 0, 0, 1, 0, 0, /**/ 1, 0, 1, 0, 0, /**/ 1, 0,
					1, 0, 0, /**/ 0, 0, 1, 0, 1, /**/ 1, 1, 1, 1 },
			// ------------------------------------------------------------------------------------------------------------------------------
			{ 1, 1, 1, 1, 1, /**/ 0, 1, 0, 1, 0, /**/ 1, 0, 1, 1, 1, /**/ 1, 0, 1, 1, 1, /**/ 0, 0, 1, 0, 0, /**/ 1, 0,
					1, 1, 1, /**/ 1, 0, 1, 0, 1, /**/ 1, 1, 1, 1 },
			{ 1, 0, 0, 0, 0, /**/ 0, 0, 0, 1, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0,
					0, 0, 0, /**/ 0, 0, 1, 0, 0, /**/ 0, 0, 0, 1 },
			{ 1, 0, 1, 1, 0, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 0, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 0, 1, 1, 1, /**/ 1, 1,
					1, 0, 1, /**/ 1, 1, 1, 1, 0, /**/ 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 1, 0, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 0, 1, 0, /**/ 0, 0,
					0, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 0, /**/ 1, 0, 1, 1, 1, /**/ 0, 1, 0, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 0, 1, 0, /**/ 1, 1,
					1, 0, 1, /**/ 0, 1, 1, 1, 0, /**/ 1, 1, 0, 1 },
			// ------------------------------------------------------------------------------------------------------------------------------
			{ 1, 0, 0, 0, 0, /**/ 1, 0, 0, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 1, 0, 0, /**/ 0, 0, 0, 0, 0, /**/ 0, 0,
					0, 0, 1, /**/ 0, 0, 0, 0, 0, /**/ 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1,
					1, 1, 1, /**/ 1, 1, 1, 1, 1, /**/ 1, 1, 1, 1 } };

	// Constructor
	public Buffer(JLabel lbl) {
		this.lbl = lbl;
	}

	// Métodos

	// Movimiento del personaje
	public void moverMedman() {

		// a
		if (tablero[xTablero][yTablero - 1] == 0 && xDirection == -20) {
			lbl.setLocation(lbl.getX() + xDirection, lbl.getY() + yDirection);
			yTablero--;
		}

		// d
		if (tablero[xTablero][yTablero + 1] == 0 && xDirection == +20) {
			lbl.setLocation(lbl.getX() + xDirection, lbl.getY() + yDirection);
			yTablero++;
		}

		// w
		if (tablero[xTablero - 1][yTablero] == 0 && yDirection == -20) {
			lbl.setLocation(lbl.getX() + xDirection, lbl.getY() + yDirection);
			xTablero--;

		}

		// s
		if (tablero[xTablero + 1][yTablero] == 0 && yDirection == +20) {
			lbl.setLocation(lbl.getX() + xDirection, lbl.getY() + yDirection);
			xTablero++;
		}

		// Izquierda - Derecha
		if (tablero[xTablero][yTablero - 1] == 5 && xDirection == -20) {
			lbl.setLocation(720, 200);
			xTablero = 8;
			yTablero = 34;
		}

		// Derecha - Izquierda
		if (tablero[xTablero][yTablero + 1] == 6 && xDirection == +20) {
			lbl.setLocation(120, 200);
			xTablero = 8;
			yTablero = 4;
		}
	}

	// Movimiento de los fantasmas
	// 0 - derecha
	// 1 - arriba
	// 2 - izquierda
	// 3 - abajo

	public void moverMedgast(Medgast medgast) {
		// Asegura una posición valida
		boolean isPosible = false;
		while (isPosible == false) {
			// Le damos prioridad a continuar el la direccion que va para que intente
			// avanzar
			double continuar = Math.round(Math.random());
			if (continuar>0.75) {
				medgast.setDireccion((int) Math.round(Math.random()*4));
			}
			switch (medgast.getDireccion()) {
			case 0: // Derecha
				if (tablero[medgast.getxTablero()][medgast.getyTablero() + 1] == 0) {
					
					isPosible = true;
				}
				break;
			case 1: // Arriba
				if (tablero[medgast.getxTablero() - 1][medgast.getyTablero()] == 0) {
					
					isPosible = true;
				}
				break;
			case 2: // Izquierda
				if (tablero[medgast.getxTablero()][medgast.getyTablero() - 1] == 0) {
					
					isPosible = true;
				}
				break;
			case 3: // Abajo
				if (tablero[medgast.getxTablero() + 1][medgast.getyTablero()] == 0) {
					
					isPosible = true;
				}
				break;
			default:
				break;
			}
		}
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
}
