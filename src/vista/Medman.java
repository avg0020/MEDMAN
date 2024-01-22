package vista;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

public class Medman extends Thread {

	// Atributos
	private Buffer buffer;
	private JLabel lbl;
	private int xDirection, yDirection;

	// Constructores
	public Medman(Buffer buffer, JLabel lbl) {
		super();
		this.buffer = buffer;
		this.lbl = lbl;
		this.xDirection = 0;
		this.yDirection = 0;
	}

	// Métodos
	@Override
	public void run() {
		while (true) {
			try {
				sleep(200);
				
				if (xDirection<0 && lbl.getX()+xDirection>=0) {
					lbl.setLocation(lbl.getX()+xDirection, lbl.getY()+yDirection);
				}
				
				if (xDirection>0 && lbl.getX()+xDirection<=500) {
					lbl.setLocation(lbl.getX()+xDirection, lbl.getY()+yDirection);
				}
				
				if (yDirection<0 && lbl.getY()+yDirection>=0) {
					lbl.setLocation(lbl.getX()+xDirection, lbl.getY()+yDirection);
				}
				
				if (yDirection>0 && lbl.getY()+yDirection<=500) {
					lbl.setLocation(lbl.getX()+xDirection, lbl.getY()+yDirection);
				}
			} catch (InterruptedException e) {
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
