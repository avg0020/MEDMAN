package vista;

import javax.swing.JLabel;

public class Buffer {

	// Atributos
	private JLabel lbl;
	private int xDirection, yDirection, xTablero = 0, yTablero = 0;
	private int[][] tablero = new int[6][6];

	// Constructor

	public Buffer(JLabel lbl) {
		this.lbl = lbl;

		this.tablero[2][2] = 1;
		this.tablero[3][2] = 1;
		this.tablero[4][2] = 1;

		this.tablero[4][3] = 1;
		this.tablero[4][4] = 1;

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j]);
			}
			System.out.println("");
		}
	}

	// Métodos
	public void mover() {

		// a
		if (xDirection < 0 && lbl.getX() + xDirection >= 0) {
			if (tablero[xTablero - 1][yTablero] != 1) {
				lbl.setLocation(lbl.getX() + xDirection, lbl.getY() + yDirection);
				xTablero--;
				System.out.println("a: "+xTablero + " | " + yTablero);
			}
		}

		// d
		if (xDirection > 0 && lbl.getX() + xDirection <= 500) {
			if (tablero[xTablero + 1][yTablero] != 1) {
				lbl.setLocation(lbl.getX() + xDirection, lbl.getY() + yDirection);
				xTablero++;
				System.out.println("d: "+xTablero + " | " + yTablero);
			}
		}

		// w
		if (yDirection < 0 && lbl.getY() + yDirection >= 0) {
			if (tablero[xTablero][yTablero - 1] != 1) {
				lbl.setLocation(lbl.getX() + xDirection, lbl.getY() + yDirection);
				yTablero--;
				System.out.println("w: "+xTablero + " | " + yTablero);
			}
		}

		// s
		if (yDirection > 0 && lbl.getY() + yDirection <= 500) {
			if (tablero[xTablero][yTablero + 1] != 1) {
				lbl.setLocation(lbl.getX() + xDirection, lbl.getY() + yDirection);
				yTablero++;
				System.out.println("a: "+xTablero + " | " + yTablero);
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
