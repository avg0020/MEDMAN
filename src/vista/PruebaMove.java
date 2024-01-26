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
	private JLabel lblMedman = new JLabel();
	private JLabel lblMedast21 = new JLabel();
	private JLabel lblMedast22 = new JLabel();
	private JLabel lblMedast23 = new JLabel();
	private JLabel lblMedast24 = new JLabel();
	private JLabel lblMapa = new JLabel();

	private Buffer buffer = new Buffer(lblMedman);
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
		JPanel panel = new JPanel();
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

}
