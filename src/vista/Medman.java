package vista;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

public class Medman extends Thread {

	// Atributos
	private Buffer buffer;
	private int type=2;

	// Constructores
	public Medman(Buffer buffer) {
		super();
		this.buffer = buffer;
	}

	// Métodos
	@Override
	public void run() {
		while (true) {
			try {
				sleep(200);
				buffer.moverMedman();
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
}
