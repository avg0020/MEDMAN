package vista;

import java.util.Iterator;

import javax.swing.JLabel;

public class Titulo extends Thread {

	// Atributos
	private String nums;
	private String titulo;
	private int pos;
	private JLabel lblTitulo;
	private boolean finish;

	// Constructores
	public Titulo(JLabel lbltitulo, String titulo) {
		super();
		this.lblTitulo = lbltitulo;
		this.nums = "";
		this.titulo = titulo;
		this.finish = false;
	}

	// Métodos
	@Override
	public void run() {

		super.run();
		this.pos = 0;
		try {
			while (finish==false) {
				for (int i = 0; i < 25; i++) {
					for (int j = pos; j < titulo.length()/2; j++) {
						nums += (int) Math.round(Math.random() * 9)+" ";
					}
					lblTitulo.setText(titulo.substring(0, pos*2)+nums);
					nums="";
					sleep(50);
				}
				
				if (pos==titulo.length()/2) {
					pos=0;
					sleep(5000);
				}else {
					pos++;					
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

}
