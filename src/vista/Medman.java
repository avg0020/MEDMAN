package vista;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;

public class Medman extends Thread {

	// Atributos
	private Buffer buffer;
	private boolean isPlaying, finish;

	// Constructores
	public Medman(Buffer buffer) {
		super();
		this.buffer = buffer;
		this.isPlaying = true;
		this.finish = false;
	}

	// Métodos
	@Override
	public void run() {
		while (isPlaying && finish==false) {
			try {
				sleep(200);
				buffer.moverMedman();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

	public boolean isPlaying() {
		return isPlaying;
	}

	public void setPlaying(boolean isPlaying) {
		this.isPlaying = isPlaying;
	}
	
	public void endMedman() {
		this.isPlaying = false;
	}

	public Buffer getBuffer() {
		return buffer;
	}

	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}
	
	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}
}
