package vista;

import javax.swing.JLabel;

public class Medgast extends Thread {
	// Atributos
	private int type, xTablero, yTablero, direccion;
	private Buffer buffer;
	private JLabel lbl;
	private boolean isFirstTurn;
	private boolean isPlaying;
	private boolean finish;
	private int speed;
	
	// Constructores
	public Medgast(Buffer buffer, JLabel lbl, int type) {
		super();
		this.buffer = buffer;
		this.lbl = lbl;
		this.type = type;
		this.isFirstTurn = true;
		this.isPlaying = true;
		this.finish = false;
	}
	
	// Métodos
	@Override
	public void run() {
		while (isPlaying && finish==false) {
			try {
				if (isFirstTurn) {
					movimientoSalida();
				}
				sleep(speed);
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
	
	public boolean isFirstTurn() {
		return isFirstTurn;
	}

	public void setFirstTurn(boolean isFirstTurn) {
		this.isFirstTurn = isFirstTurn;
	}

	public boolean isPlaying() {
		return isPlaying;
	}

	public void setPlaying(boolean isPlaying) {
		this.isPlaying = isPlaying;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

	public void movimientoSalida() {
		try {
			switch (type) {
			case 21:
				sleep(speed);
				lbl.setLocation(570, 240);
				sleep(speed);
				lbl.setLocation(600, 240);
				sleep(speed);
				lbl.setLocation(630, 240);
				this.xTablero=8;
				this.yTablero=21;
				isFirstTurn = false;
				break;
			case 22:
				sleep(600);
				lbl.setLocation(540, 240);
				sleep(speed);
				lbl.setLocation(570, 240);
				sleep(speed);
				lbl.setLocation(600, 240);
				sleep(speed);
				lbl.setLocation(630, 240);
				this.xTablero=8;
				this.yTablero=21;
				isFirstTurn = false;
				break;
			case 23:
				sleep(1000);
				lbl.setLocation(570, 240);
				sleep(speed);
				lbl.setLocation(600, 240);
				sleep(speed);
				lbl.setLocation(630, 240);
				this.xTablero=8;
				this.yTablero=21;
				isFirstTurn = false;
				break;
			case 24:
				sleep(1600);
				lbl.setLocation(540, 240);
				sleep(speed);
				lbl.setLocation(570, 240);
				sleep(speed);
				lbl.setLocation(600, 240);
				sleep(speed);
				lbl.setLocation(630, 240);
				this.xTablero=8;
				this.yTablero=21;
				isFirstTurn = false;
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
