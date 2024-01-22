package vista;

import javax.swing.JLabel;

public class Buffer {

	// Atributos
	private JLabel lbl;
	private int xDirection, yDirection, xTablero = 0, yTablero = 0;
	private int[][] tablero = new int[860][720];

	// Constructor

	public Buffer(JLabel lbl) {
		this.lbl = lbl;
	}

	// Métodos
	public void mover() {

		// a
		if (xDirection < 0 && lbl.getX() + xDirection >= 0) {
			if (tablero[xTablero - 1][yTablero] != 1) {
				lbl.setLocation(lbl.getX() + xDirection, lbl.getY() + yDirection);
				xTablero--;
			}
		}

		// d
		if (xDirection > 0 && lbl.getX() + xDirection <= 840) {
			if (tablero[xTablero + 1][yTablero] != 1) {
				lbl.setLocation(lbl.getX() + xDirection, lbl.getY() + yDirection);
				xTablero++;
			}
		}

		// w
		if (yDirection < 0 && lbl.getY() + yDirection >= 0) {
			if (tablero[xTablero][yTablero - 1] != 1) {
				lbl.setLocation(lbl.getX() + xDirection, lbl.getY() + yDirection);
				yTablero--;
			}
		}

		// s
		if (yDirection > 0 && lbl.getY() + yDirection <= 400) {
			if (tablero[xTablero][yTablero + 1] != 1) {
				lbl.setLocation(lbl.getX() + xDirection, lbl.getY() + yDirection);
				yTablero++;
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
