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
	
	//Labels
	private JLabel lblMedman = new JLabel();
	private JLabel lblMedast21 = new JLabel();
	private JLabel lblMedast22 = new JLabel();
	private JLabel lblMedast23 = new JLabel();
	private JLabel lblMedast24 = new JLabel();
	private JLabel lblPremio1 = new JLabel();
	private JLabel lblPremio2 = new JLabel();
	private JLabel lblPremio3 = new JLabel();
	private JLabel lblPremio4 = new JLabel();
	private JLabel lblPremio5 = new JLabel();
	private JLabel lblPremio6 = new JLabel();
	private JLabel lblMapa = new JLabel();
	
	//Objetos
	private Buffer buffer = new Buffer(lblMedman, this);
	private Medman medman = new Medman(buffer);
	private Medgast medgast21 = new Medgast(buffer,lblMedast21,21);
	private Medgast medgast22 = new Medgast(buffer, lblMedast22, 22);
	private Medgast medgast23 = new Medgast(buffer, lblMedast23, 23);
	private Medgast medgast24 = new Medgast(buffer, lblMedast24, 24);

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
		setBounds(100, 100, 1200, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		addKeyListener(this);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		medman.start();
		medgast21.start();
		medgast22.start();
		medgast23.start();
		medgast24.start();
		
		//Panel con el mapa
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(200, 200, 860, 420);
		contentPane.add(panel);

		// Medman
		lblMedman.setBounds(200, 180, 20, 20);
		lblMedman.setIcon(new ImageIcon(getClass().getResource("/resources/medman.png")));
		panel.add(lblMedman);

		// Medgasts
		lblMedast21.setBounds(420, 180, 20, 20);
		lblMedast21.setIcon(new ImageIcon(getClass().getResource("/resources/medgast.png")));
		panel.add(lblMedast21);
		
		lblMedast22.setBounds(400, 180, 20, 20);
		lblMedast22.setIcon(new ImageIcon(getClass().getResource("/resources/medgastG.png")));
		panel.add(lblMedast22);
		
		lblMedast23.setBounds(400, 220, 20, 20);
		lblMedast23.setIcon(new ImageIcon(getClass().getResource("/resources/medgastP.png")));
		panel.add(lblMedast23);
		
		lblMedast24.setBounds(420, 220, 20, 20);
		lblMedast24.setIcon(new ImageIcon(getClass().getResource("/resources/medgastY.png")));
		panel.add(lblMedast24);
		
		//Premios
		lblPremio1.setBounds(buffer.getYPremios(0)*20+40, buffer.getXPremios(0)*20+40, 20, 20);
		lblPremio1.setIcon(new ImageIcon(getClass().getResource("/resources/diploma.png")));
		panel.add(lblPremio1);
		
		lblPremio2.setBounds(buffer.getYPremios(1)*20+40, buffer.getXPremios(1)*20+40, 20, 20);
		lblPremio2.setIcon(new ImageIcon(getClass().getResource("/resources/diploma.png")));
		panel.add(lblPremio2);
		
		lblPremio3.setBounds(buffer.getYPremios(2)*20+40, buffer.getXPremios(2)*20+40, 20, 20);
		lblPremio3.setIcon(new ImageIcon(getClass().getResource("/resources/diploma.png")));
		panel.add(lblPremio3);
		
		lblPremio4.setBounds(buffer.getYPremios(3)*20+40, buffer.getXPremios(3)*20+40, 20, 20);
		lblPremio4.setIcon(new ImageIcon(getClass().getResource("/resources/diploma.png")));
		panel.add(lblPremio4);
		
		lblPremio5.setBounds(buffer.getYPremios(4)*20+40, buffer.getXPremios(4)*20+40, 20, 20);
		lblPremio5.setIcon(new ImageIcon(getClass().getResource("/resources/diploma.png")));
		panel.add(lblPremio5);
		
		lblPremio6.setBounds(buffer.getYPremios(5)*20+40, buffer.getXPremios(5)*20+40, 20, 20);
		lblPremio6.setIcon(new ImageIcon(getClass().getResource("/resources/diploma.png")));
		panel.add(lblPremio6);
		// Mapa
		lblMapa.setBounds(0, 0, 860, 420);
		lblMapa.setIcon(new ImageIcon(getClass().getResource("/resources/mapa.jpg")));
		panel.add(lblMapa);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		switch (e.getKeyChar()) {
		case 'a':
			buffer.setXDirection(-20);
			buffer.setYDirection(0);
			break;
		case 's':
			buffer.setXDirection(0);
			buffer.setYDirection(+20);
			break;
		case 'd':
			buffer.setXDirection(+20);
			buffer.setYDirection(0);
			break;
		case 'w':
			buffer.setXDirection(0);
			buffer.setYDirection(-20);
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
	
	
}
