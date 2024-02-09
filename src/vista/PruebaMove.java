package vista;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class PruebaMove extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;

	// Labels
	
	//Meman
	private JLabel lblMedman = new JLabel();
	
	//Medgast
	private JLabel lblMedgast21 = new JLabel();
	private JLabel lblMedgast22 = new JLabel();
	private JLabel lblMedgast23 = new JLabel();
	private JLabel lblMedgast24 = new JLabel();
	
	//Premios
	private JLabel lblPremio1 = new JLabel();
	private JLabel lblPremio2 = new JLabel();
	private JLabel lblPremio3 = new JLabel();
	private JLabel lblPremio4 = new JLabel();
	private JLabel lblPremio5 = new JLabel();
	private JLabel lblPremio6 = new JLabel();
	
	//Derrotas
	private JLabel lblVictoria = new JLabel();
	private JLabel lblDerrota = new JLabel();
	
	//Mapa
	private JLabel lblMapa = new JLabel();
	
	//Vida
	private JLabel lblVida1 = new JLabel();
	private JLabel lblVida2 = new JLabel();
	private JLabel lblVida3 = new JLabel();
	
	// Objetos
	private Buffer buffer = new Buffer(lblMedman, this);
	private Medman medman = new Medman(buffer);
	private Medgast medgast21 = new Medgast(buffer, lblMedgast21, 21);
	private Medgast medgast22 = new Medgast(buffer, lblMedgast22, 22);
	private Medgast medgast23 = new Medgast(buffer, lblMedgast23, 23);
	private Medgast medgast24 = new Medgast(buffer, lblMedgast24, 24);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaMove frame = new PruebaMove();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PruebaMove() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1186, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.BLACK);
		addKeyListener(this);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		medman.start();
		medgast21.start();
		medgast22.start();
		medgast23.start();
		medgast24.start();

		// Panel con el mapa
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(0, 200, 1170, 510);
		contentPane.add(panel);

		// Medman
		lblMedman.setBounds(240, 210, 30, 30);
		lblMedman.setIcon(new ImageIcon(getClass().getResource("/resources/medman.png")));
		buffer.setMedman(medman);
		panel.add(lblMedman);

		// Medgasts
		lblMedgast21.setBounds(570, 210, 30, 30);
		lblMedgast21.setIcon(new ImageIcon(getClass().getResource("/resources/medgastO.png")));
		panel.add(lblMedgast21);

		lblMedgast22.setBounds(540, 210, 30, 30);
		lblMedgast22.setIcon(new ImageIcon(getClass().getResource("/resources/medgastR.png")));
		panel.add(lblMedgast22);

		lblMedgast23.setBounds(540, 270, 30, 30);
		lblMedgast23.setIcon(new ImageIcon(getClass().getResource("/resources/medgastB.png")));
		panel.add(lblMedgast23);

		lblMedgast24.setBounds(570, 270, 30, 30);
		lblMedgast24.setIcon(new ImageIcon(getClass().getResource("/resources/medgastP.png")));
		panel.add(lblMedgast24);

		// Premios
		lblPremio1.setBounds(buffer.getYPremios(0) * 30, buffer.getXPremios(0) * 30, 30, 30);
		lblPremio1.setIcon(new ImageIcon(getClass().getResource("/resources/diploma.png")));
		panel.add(lblPremio1);

		lblPremio2.setBounds(buffer.getYPremios(1) * 30, buffer.getXPremios(1) * 30, 30, 30);
		lblPremio2.setIcon(new ImageIcon(getClass().getResource("/resources/diploma.png")));
		panel.add(lblPremio2);

		lblPremio3.setBounds(buffer.getYPremios(2) * 30, buffer.getXPremios(2) * 30, 30, 30);
		lblPremio3.setIcon(new ImageIcon(getClass().getResource("/resources/diploma.png")));
		panel.add(lblPremio3);

		lblPremio4.setBounds(buffer.getYPremios(3) * 30, buffer.getXPremios(3) * 30, 30, 30);
		lblPremio4.setIcon(new ImageIcon(getClass().getResource("/resources/diploma.png")));
		panel.add(lblPremio4);

		lblPremio5.setBounds(buffer.getYPremios(4) * 30, buffer.getXPremios(4) * 30, 30, 30);
		lblPremio5.setIcon(new ImageIcon(getClass().getResource("/resources/diploma.png")));
		panel.add(lblPremio5);

		lblPremio6.setBounds(buffer.getYPremios(5) * 30, buffer.getXPremios(5) * 30, 30, 30);
		lblPremio6.setIcon(new ImageIcon(getClass().getResource("/resources/diploma.png")));
		panel.add(lblPremio6);

		// Victoria derrota
		lblVictoria.setBounds(100, 100, 480, 460);
		lblVictoria.setIcon(new ImageIcon(getClass().getResource("/resources/victoria.gif")));
		lblVictoria.setVisible(false);
		panel.add(lblVictoria);
		
		lblDerrota.setBounds(100, 100, 480, 460);
		lblDerrota.setIcon(new ImageIcon(getClass().getResource("/resources/derrota.gif")));
		lblDerrota.setVisible(false);
		panel.add(lblDerrota);
		
		//Vidas
		lblVida1.setBounds(100, 100, 60, 60);
		lblVida1.setIcon(new ImageIcon(getClass().getResource("/resources/hearth.gif")));
		contentPane.add(lblVida1);
		
		lblVida2.setBounds(160, 100, 60, 60);
		lblVida2.setIcon(new ImageIcon(getClass().getResource("/resources/hearth.gif")));
		contentPane.add(lblVida2);
		
		lblVida3.setBounds(220, 100, 60, 60);
		lblVida3.setIcon(new ImageIcon(getClass().getResource("/resources/hearth.gif")));
		contentPane.add(lblVida3);

		// Mapa
		lblMapa.setBounds(0, 0, 1170, 510);
		lblMapa.setIcon(new ImageIcon(getClass().getResource("/resources/mapa.jpg")));
		panel.add(lblMapa);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		switch (e.getKeyChar()) {
		case 'a':
			buffer.setXDirection(-30);
			buffer.setYDirection(0);
			break;
		case 's':
			buffer.setXDirection(0);
			buffer.setYDirection(+30);
			break;
		case 'd':
			buffer.setXDirection(+30);
			buffer.setYDirection(0);
			break;
		case 'w':
			buffer.setXDirection(0);
			buffer.setYDirection(-30);
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public JLabel getLblPremio1() {
		return lblPremio1;
	}

	public void setLblPremio1(JLabel lblPremio1) {
		this.lblPremio1 = lblPremio1;
	}

	public JLabel getLblPremio2() {
		return lblPremio2;
	}

	public void setLblPremio2(JLabel lblPremio2) {
		this.lblPremio2 = lblPremio2;
	}

	public JLabel getLblPremio3() {
		return lblPremio3;
	}

	public void setLblPremio3(JLabel lblPremio3) {
		this.lblPremio3 = lblPremio3;
	}

	public JLabel getLblPremio4() {
		return lblPremio4;
	}

	public void setLblPremio4(JLabel lblPremio4) {
		this.lblPremio4 = lblPremio4;
	}

	public JLabel getLblPremio5() {
		return lblPremio5;
	}

	public void setLblPremio5(JLabel lblPremio5) {
		this.lblPremio5 = lblPremio5;
	}

	public JLabel getLblPremio6() {
		return lblPremio6;
	}

	public void setLblPremio6(JLabel lblPremio6) {
		this.lblPremio6 = lblPremio6;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public Medgast getMedgast21() {
		return medgast21;
	}

	public Medgast getMedgast22() {
		return medgast22;
	}

	public Medgast getMedgast23() {
		return medgast23;
	}

	public Medgast getMedgast24() {
		return medgast24;
	}

	public void resetMegast21() {
		lblMedgast21.setBounds(570, 210, 30, 30);
		medgast21.setFirstTurn(true);
		medgast21.setDireccion(-1);
		medgast21.setxTablero(-1);
		medgast21.setyTablero(-1);
	}

	public void resetMegast22() {
		lblMedgast22.setBounds(540, 210, 30, 30);
		medgast22.setFirstTurn(true);
		medgast22.setDireccion(-1);
		medgast22.setxTablero(-1);
		medgast22.setyTablero(-1);
	}

	public void resetMegast23() {
		lblMedgast23.setBounds(540, 270, 30, 30);
		medgast23.setFirstTurn(true);
		medgast23.setDireccion(-1);
		medgast23.setxTablero(-1);
		medgast23.setyTablero(-1);
	}

	public void resetMegast24() {
		lblMedgast24.setBounds(570, 270, 30, 30);
		medgast24.setFirstTurn(true);
		medgast24.setDireccion(-1);
		medgast24.setxTablero(-1);
		medgast24.setyTablero(-1);
	}

	public void endMegast21() {
		medgast21.setPlaying(false);
	}

	public void endMegast22() {
		medgast22.setPlaying(false);
	}

	public void endMegast23() {
		medgast23.setPlaying(false);
	}

	public void endMegast24() {
		medgast24.setPlaying(false);
	}
	
	public void win() {
		lblVictoria.setVisible(true);
		lblVictoria.setComponentZOrder(lblVictoria, 1);
	}
	
	public void losse() {
		lblDerrota.setVisible(true);
		lblDerrota.setComponentZOrder(lblDerrota, 1);
	}
	
	public void losseLife(int vida) {
		switch (vida) {
		case 1:
			lblVida1.setIcon(new ImageIcon(getClass().getResource("/resources/hearthBoom1.gif")));
			break;
		case 2:
			lblVida2.setIcon(new ImageIcon(getClass().getResource("/resources/hearthBoom2.gif")));
			break;
		case 3:
			lblVida3.setIcon(new ImageIcon(getClass().getResource("/resources/hearthBoom3.gif")));
			break;
		}
	}
}
