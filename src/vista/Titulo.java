package vista;

import java.util.Iterator;

import javax.swing.JLabel;

public class Titulo extends Thread {

	// Atributos
	private String[] titulo;
	private String[] medman = {"M","E","D","M","A","N"};
	private int pos;
	private JLabel lblTitulo;

	// Constructores
	public Titulo(JLabel lbltitulo) {
		super();
		this.lblTitulo = lbltitulo;
		this.titulo  = new String[6];
	}

	// Métodos
	@Override
	public void run() {

		super.run();
		this.pos=0;
		try {
			while (true) {
				for (int i = 0; i < 20; i++) {					
					for (int j = pos; j < titulo.length; j++) {
						titulo[j] = String.valueOf((int) Math.round(Math.random() * 9));
						for (int k = 0; k < pos; k++) {
							lblTitulo.setText(medman[k]);
						}
						lblTitulo.setText(lblTitulo.getText()+titulo[j]);
					}
					sleep(50);
					lblTitulo.setText("");
				}
				
				if (pos<titulo.length) {
					pos++;
				}else {
					pos=0;
					lblTitulo.setText(medman[0]+medman[1]+medman[2]+medman[3]+medman[4]+medman[5]);
				}
				
				sleep(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
