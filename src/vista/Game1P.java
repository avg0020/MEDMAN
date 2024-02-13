package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class Game1P extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private Inicio parent;
	private Game1P frame;
	
	// Colores
	private Color color;

	// Fonts
	private Font font_20 = new Font("Consolas", Font.PLAIN, 20);
	private Font font_25 = new Font("Consolas", Font.PLAIN, 25);
	private Font font_50 = new Font("Consolas", Font.PLAIN, 50);

	// Boders
	private Border border;

	// Fondo
	private ImageIcon fondo;

	// Meman
	private JLabel lblMedman = new JLabel();

	// Medgast
	private JLabel lblMedgast21 = new JLabel();
	private JLabel lblMedgast22 = new JLabel();
	private JLabel lblMedgast23 = new JLabel();
	private JLabel lblMedgast24 = new JLabel();

	// Premios
	private JLabel lblPremio1 = new JLabel();
	private JLabel lblPremio2 = new JLabel();
	private JLabel lblPremio3 = new JLabel();
	private JLabel lblPremio4 = new JLabel();
	private JLabel lblPremio5 = new JLabel();
	private JLabel lblPremio6 = new JLabel();

	// Derrotas
	private JLabel lblVictoria = new JLabel();
	private JLabel lblDerrota = new JLabel();

	// Mapa
	private JLabel lblMapa = new JLabel();

	// Pausa
	private JLabel lblPause = new JLabel();

	// Timer
	private Timer timer;

	// Vida
	private JLabel lblVida1 = new JLabel();
	private JLabel lblVida2 = new JLabel();
	private JLabel lblVida3 = new JLabel();

	// Velocidad
	private int speed;

	// Objetos
	private Buffer buffer = new Buffer(lblMedman, this);
	private Medman medman = new Medman(buffer);
	private Medgast medgast21 = new Medgast(buffer, lblMedgast21, 21);
	private Medgast medgast22 = new Medgast(buffer, lblMedgast22, 22);
	private Medgast medgast23 = new Medgast(buffer, lblMedgast23, 23);
	private Medgast medgast24 = new Medgast(buffer, lblMedgast24, 24);
	
	//Puntos
	private int points;
	JLabel lblPoints;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game1P frame = new Game1P(null, new ImageIcon(getClass().getResource("/Resources/fondoInicio.gif")),
							new Color(35, 146, 23), new LineBorder(new Color(35, 146, 23), 2), 150);
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
	public Game1P(Inicio parent, ImageIcon fondo, Color color, Border border, int speed) {
		this.frame = this;
		this.parent = parent;
		this.fondo = fondo;
		this.color = color;
		this.border = border;
		this.speed = speed;
		this.points = 0;
		medgast21.setSpeed(speed);
		medgast22.setSpeed(speed);
		medgast23.setSpeed(speed);
		medgast24.setSpeed(speed);

		// Frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1186, 900);
		contentPane = new JPanel() {
			@Override
			public void paint(Graphics g) {
				Image bg = fondo.getImage();
				g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
				setOpaque(false);
				super.paint(g);
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.BLACK);
		addKeyListener(this);
		setUndecorated(true);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

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

		// Vidas
		JPanel panelVidas = new JPanel();
		panelVidas.setBorder(border);
		panelVidas.setBackground(Color.BLACK);
		panelVidas.setLayout(null);
		panelVidas.setBounds(468, 90, 250, 100);
		contentPane.add(panelVidas);

		lblVida1.setBounds(10, 20, 60, 60);
		lblVida1.setIcon(new ImageIcon(getClass().getResource("/resources/hearth.gif")));
		panelVidas.add(lblVida1);

		lblVida2.setBounds(100, 20, 60, 60);
		lblVida2.setIcon(new ImageIcon(getClass().getResource("/resources/hearth.gif")));
		panelVidas.add(lblVida2);

		lblVida3.setBounds(190, 20, 60, 60);
		lblVida3.setIcon(new ImageIcon(getClass().getResource("/resources/hearth.gif")));
		panelVidas.add(lblVida3);

		// Mapa
		lblMapa.setBounds(0, 0, 1170, 510);
		lblMapa.setIcon(new ImageIcon(getClass().getResource("/resources/mapa.jpg")));
		panel.add(lblMapa);

		// Pausa
		lblPause.setBounds(443, 400, 300, 100);
		lblPause.setHorizontalAlignment(SwingConstants.CENTER);
		lblPause.setForeground(color);
		lblPause.setBorder(border);
		lblPause.setBackground(Color.BLACK);
		lblPause.setText("Pulse space para comenzar");
		lblPause.setFont(font_20);
		lblPause.setOpaque(true);
		contentPane.add(lblPause);
		contentPane.setComponentZOrder(lblPause, 0);

		// Timer
		JLabel lblTimer = new JLabel();
		lblTimer.setBounds(218, 90, 200, 100);
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimer.setForeground(color);
		lblTimer.setBorder(border);
		lblTimer.setBackground(Color.BLACK);
		lblTimer.setText("00:00");
		lblTimer.setFont(font_50);
		lblTimer.setOpaque(true);
		contentPane.add(lblTimer);

		timer = new Timer(lblTimer);
		buffer.setTimer(timer);

		// Puntuacion
		lblPoints = new JLabel();
		lblPoints.setBounds(768, 90, 200, 100);
		lblPoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoints.setForeground(color);
		lblPoints.setBorder(border);
		lblPoints.setBackground(Color.BLACK);
		lblPoints.setText("0");
		lblPoints.setFont(font_50);
		lblPoints.setOpaque(true);
		contentPane.add(lblPoints);

		// Boton volver al menu
		int xBtnBackMenu = 368, yBtnBackMenu = 750;
		int wBtnBackMenu = 200, hBtnBackMenu = 50;
		JButton btnBackMenu = new JButton("Menu Principal");
		btnBackMenu.setBounds(xBtnBackMenu, yBtnBackMenu, wBtnBackMenu, hBtnBackMenu);
		btnBackMenu.setFont(font_20);
		btnBackMenu.setForeground(color);
		btnBackMenu.setBackground(Color.BLACK);
		btnBackMenu.setBorder(border);
		btnBackMenu.setFocusPainted(false);
		btnBackMenu.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnBackMenu.setLocation(xBtnBackMenu, yBtnBackMenu);
				btnBackMenu.setSize(wBtnBackMenu, hBtnBackMenu);
				btnBackMenu.setFont(font_20);
				btnBackMenu.setForeground(color);
				btnBackMenu.setBackground(Color.BLACK);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnBackMenu.setLocation(xBtnBackMenu - 10, yBtnBackMenu - 5);
				btnBackMenu.setSize(wBtnBackMenu + 20, hBtnBackMenu + 10);
				btnBackMenu.setFont(font_25);
				btnBackMenu.setForeground(Color.BLACK);
				btnBackMenu.setBackground(color);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		btnBackMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parent.setVisible(true);
				endHilos();
				dispose();
			}
		});
		btnBackMenu.setFocusable(false);
		contentPane.add(btnBackMenu);

		// Boton salir
		int xBtnExit = 618, yBtnExit = 750;
		int wBtnBackExit = 200, hBtnExit = 50;
		JButton btnExit = new JButton("Salir");
		btnExit.setBounds(xBtnExit, yBtnExit, wBtnBackExit, hBtnExit);
		btnExit.setFont(font_20);
		btnExit.setForeground(color);
		btnExit.setBackground(Color.BLACK);
		btnExit.setBorder(border);
		btnExit.setFocusPainted(false);
		btnExit.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setLocation(xBtnExit, yBtnExit);
				btnExit.setSize(wBtnBackExit, hBtnExit);
				btnExit.setFont(font_20);
				btnExit.setForeground(color);
				btnExit.setBackground(Color.BLACK);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setLocation(xBtnExit - 10, yBtnExit - 5);
				btnExit.setSize(wBtnBackExit + 20, hBtnExit + 10);
				btnExit.setFont(font_25);
				btnExit.setForeground(Color.BLACK);
				btnExit.setBackground(color);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				endHilos();
				parent.endHilos();
				parent.dispose();
				dispose();
			}
		});
		btnExit.setFocusable(false);
		contentPane.add(btnExit);
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
		case ' ':
			lblPause.setVisible(false);
			buffer.setXDirection(0);
			buffer.setYDirection(0);
			medman.start();
			medgast21.start();
			medgast22.start();
			medgast23.start();
			medgast24.start();
			timer.start();
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

	public void endTimer() {
		timer.setRunning(false);
	}
	
	public void addPoints(int p) {
		points+=p;
		lblPoints.setText(String.valueOf(points));
	}
	
	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public void win() {
		DVictory v = new DVictory(parent, frame);
		v.setVisible(true);
		v.setModal(true);
	}

	public void losse() {
		DGameOver v = new DGameOver(parent, frame);
		v.setVisible(true);
		v.setModal(true);
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
	
	public void endHilos() {
		medman.setFinish(true);
		medgast21.setFinish(true);
		medgast22.setFinish(true);
		medgast23.setFinish(true);
		medgast24.setFinish(true);
		timer.setFinish(true);
	}
}
