package vista;

import java.util.Iterator;

import javax.swing.JLabel;

public class Titulo extends Thread {

	// Atributos
	private String titulo;
	private String medman;
	private int pos;
	private JLabel lblTitulo;

	// Constructores
	public Titulo(JLabel lbltitulo) {
		super();
		this.lblTitulo = lbltitulo;
		this.titulo = "";
		this.medman = "M E D M A N ";
	}

	// Métodos
	@Override
	public void run() {

		super.run();
		this.pos = 0;
		try {
			while (true) {
				for (int i = 0; i < 25; i++) {
					for (int j = pos; j < 6; j++) {
						titulo += (int) Math.round(Math.random() * 9)+" ";
					}
					lblTitulo.setText(medman.substring(0, pos*2)+titulo);
					titulo="";
					sleep(50);
				}
				
				if (pos==6) {
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

}
