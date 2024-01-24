package vista;

import javax.swing.JLabel;

public class Medgast extends Thread {
	// Atributos
	private int type, xTablero, yTablero, direccion;
	private Buffer buffer;
	private JLabel lbl;
	private boolean isFirstTurn;

	// Constructores
	public Medgast(Buffer buffer, JLabel lbl, int type) {
		super();
		this.buffer = buffer;
		this.lbl = lbl;
		this.type = type;
		this.isFirstTurn = true;
		this.xTablero=8;
		this.yTablero=21;
	}

	// Métodos
	@Override
	public void run() {
		while (true) {
			try {
				if (isFirstTurn) {
					movimientoSalida();
				}
				sleep(200);
				buffer.moverMedgast(this);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Buffer getBuffer() {
		return buffer;
	}

	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}
	
	
	public int getxTablero() {
		return xTablero;
	}

	public void setxTablero(int xTablero) {
		this.xTablero = xTablero;
	}

	public int getyTablero() {
		return yTablero;
	}

	public void setyTablero(int yTablero) {
		this.yTablero = yTablero;
	}
	
	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	public JLabel getLbl() {
		return lbl;
	}

	public void setLbl(JLabel lbl) {
		this.lbl = lbl;
	}

	public void movimientoSalida() {
		try {
			switch (type) {
			case 21:
				sleep(200);
				lbl.setLocation(420, 200);
				sleep(200);
				lbl.setLocation(440, 200);
				sleep(200);
				lbl.setLocation(460, 200);
				isFirstTurn = false;
				break;
			case 22:
				sleep(200);
				lbl.setLocation(420, 200);
				sleep(200);
				lbl.setLocation(440, 200);
				sleep(200);
				lbl.setLocation(460, 200);
				isFirstTurn = false;
				break;
			case 23:
				sleep(200);
				lbl.setLocation(420, 200);
				sleep(200);
				lbl.setLocation(440, 200);
				sleep(200);
				lbl.setLocation(460, 200);
				isFirstTurn = false;
				break;
			case 24:
				sleep(200);
				lbl.setLocation(420, 200);
				sleep(200);
				lbl.setLocation(440, 200);
				sleep(200);
				lbl.setLocation(460, 200);
				isFirstTurn = false;
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
}
