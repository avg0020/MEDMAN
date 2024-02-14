package vista;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Inicio frame;

	// Colores
	private Color R = new Color(206, 0, 26);
	private Color G = new Color(35, 146, 23);
	private Color B = new Color(15, 0, 152);
	private Color color = G;

	// Fonts
	private Font font_69 = new Font("Consolas", Font.PLAIN, 69);
	private Font font_35 = new Font("Consolas", Font.PLAIN, 35);
	private Font font_30 = new Font("Consolas", Font.PLAIN, 30);
	private Font font_20 = new Font("Consolas", Font.PLAIN, 20);

	// Boders
	private Border borderR = new LineBorder(R, 2);
	private Border borderB = new LineBorder(B, 2);
	private Border borderG = new LineBorder(G, 2);
	private Border border = borderG;

	// Fondos
	private JLabel lblFondoG;
	private JLabel lblFondoR;
	private JLabel lblFondoB;

	// Labels
	private JLabel lblTitulo;
	private JLabel lblUser;
	private JLabel lblU;

	// Titulos
	private Titulo u;
	private Titulo t;

	// Botones
	private JButton btnPlay;
	private JButton btnDificulty;
	private JButton btnExit;
	private JButton btnChangeUser;
	private JButton btnPoints;

	// Otros
	private int dificulty;
	private int speed;
	private ImageIcon fondo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		this.frame = this;
		this.fondo = new ImageIcon(getClass().getResource("/resources/fondoInicio.gif"));
		this.speed = 100;
		this.dificulty = 1;

		// ------------------------------------------------------Frame------------------------------------------------------
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 819);
		contentPane = new JPanel();
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/medac.png")));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		setUndecorated(true);
		setContentPane(contentPane);

		// ------------------------------------------------------Fondos------------------------------------------------------
		// Verde
		lblFondoG = new JLabel();
		lblFondoG.setBounds(0, 0, 1024, 819);
		lblFondoG.setIcon(new ImageIcon(getClass().getResource("/resources/fondoInicio.gif")));
		lblFondoG.setVisible(true);
		contentPane.add(lblFondoG);

		// Rojo
		lblFondoR = new JLabel();
		lblFondoR.setBounds(0, 0, 1024, 819);
		lblFondoR.setIcon(new ImageIcon(getClass().getResource("/resources/fondoInicioR.gif")));
		lblFondoR.setVisible(false);
		contentPane.add(lblFondoR);

		// Azul
		lblFondoB = new JLabel();
		lblFondoB.setBounds(0, 0, 1024, 819);
		lblFondoB.setIcon(new ImageIcon(getClass().getResource("/resources/fondoInicioB.gif")));
		lblFondoB.setVisible(false);
		contentPane.add(lblFondoB);

		// ------------------------------------------------------Paneles------------------------------------------------------
		// Panel del menu Inicio
		JPanel panelMenu = new JPanel();
		panelMenu.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMenu.setBounds(250, 0, 524, 819);
		panelMenu.setBackground(Color.BLACK);
		panelMenu.setOpaque(true);
		panelMenu.setLayout(null);
		contentPane.add(panelMenu);
		contentPane.setComponentZOrder(panelMenu, 0);

		// ------------------------------------------------------Usuario------------------------------------------------------
		lblU = new JLabel();
		lblU.setBounds(100, 160, 70, 100);
		lblU.setForeground(color);
		lblU.setFont(font_20);
		lblU.setText("USER: ");
		lblU.setHorizontalAlignment(SwingConstants.CENTER);
		panelMenu.add(lblU);

		lblUser = new JLabel();
		lblUser.setBounds(170, 160, 300, 100);
		lblUser.setForeground(color);
		lblUser.setFont(font_20);
		lblUser.setHorizontalAlignment(SwingConstants.LEFT);
		panelMenu.add(lblUser);

		u = new Titulo(lblUser, generarUsuario(), 10000, 10);
		u.start();

		// ------------------------------------------------------Titulo------------------------------------------------------
		lblTitulo = new JLabel();
		lblTitulo.setBounds(20, 40, 520, 100);
		lblTitulo.setForeground(color);
		lblTitulo.setFont(font_69);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panelMenu.add(lblTitulo);

		t = new Titulo(lblTitulo, "M E D M A N ", 5000, 25);
		t.start();

		// ------------------------------------------------------Botones------------------------------------------------------

		// Play
		int xBtnPlay = 162, yBtnPlay = 360;
		int wBtnPlay = 200, hBtnPlay = 50;
		btnPlay = new JButton("Jugar");
		btnPlay.setBounds(xBtnPlay, yBtnPlay, wBtnPlay, hBtnPlay);
		btnPlay.setFont(font_30);
		btnPlay.setForeground(color);
		btnPlay.setBackground(Color.BLACK);
		btnPlay.setBorder(border);
		btnPlay.setFocusPainted(false);
		btnPlay.addMouseListener(new MouseListener() {

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
				btnPlay.setLocation(xBtnPlay, yBtnPlay);
				btnPlay.setSize(wBtnPlay, hBtnPlay);
				btnPlay.setFont(font_30);
				btnPlay.setForeground(color);
				btnPlay.setBackground(Color.BLACK);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnPlay.setLocation(xBtnPlay - 10, yBtnPlay - 5);
				btnPlay.setSize(wBtnPlay + 20, hBtnPlay + 10);
				btnPlay.setFont(font_35);
				btnPlay.setForeground(Color.BLACK);
				btnPlay.setBackground(color);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		btnPlay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Game1P g = new Game1P(frame, fondo, color, border, speed, dificulty);
				g.setVisible(true);
				frame.setVisible(false);
			}
		});
		panelMenu.add(btnPlay);

		// Dificultad
		int xBtnDificulty = 162, yBtnDificulty = 460;
		int wBtnDificulty = 200, hBtnDificulty = 50;
		btnDificulty = new JButton("Dificultad");
		btnDificulty.setBounds(xBtnDificulty, yBtnDificulty, wBtnDificulty, hBtnDificulty);
		btnDificulty.setFont(font_30);
		btnDificulty.setForeground(color);
		btnDificulty.setBackground(Color.BLACK);
		btnDificulty.setBorder(border);
		btnDificulty.setFocusPainted(false);
		btnDificulty.addMouseListener(new MouseListener() {

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
				btnDificulty.setLocation(xBtnDificulty, yBtnDificulty);
				btnDificulty.setSize(wBtnDificulty, hBtnDificulty);
				btnDificulty.setFont(font_30);
				btnDificulty.setForeground(color);
				btnDificulty.setBackground(Color.BLACK);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnDificulty.setLocation(xBtnDificulty - 10, yBtnDificulty - 5);
				btnDificulty.setSize(wBtnDificulty + 20, hBtnDificulty + 10);
				btnDificulty.setFont(font_35);
				btnDificulty.setForeground(Color.BLACK);
				btnDificulty.setBackground(color);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		btnDificulty.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DDificulty d = new DDificulty(frame);
				d.setModal(true);
				d.setVisible(true);
			}
		});
		panelMenu.add(btnDificulty);

		// Dificultad
		int xBtnPoints = 162, yBtnPoints = 560;
		int wBtnPoints = 200, hBtnPoints = 50;
		btnPoints = new JButton("Historial");
		btnPoints.setBounds(xBtnPoints, yBtnPoints, wBtnPoints, hBtnPoints);
		btnPoints.setFont(font_30);
		btnPoints.setForeground(color);
		btnPoints.setBackground(Color.BLACK);
		btnPoints.setBorder(border);
		btnPoints.setFocusPainted(false);
		btnPoints.addMouseListener(new MouseListener() {

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
				btnPoints.setLocation(xBtnPoints, yBtnPoints);
				btnPoints.setSize(wBtnPoints, hBtnPoints);
				btnPoints.setFont(font_30);
				btnPoints.setForeground(color);
				btnPoints.setBackground(Color.BLACK);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnPoints.setLocation(xBtnPoints - 10, yBtnPoints - 5);
				btnPoints.setSize(wBtnPoints + 20, hBtnPoints + 10);
				btnPoints.setFont(font_35);
				btnPoints.setForeground(Color.BLACK);
				btnPoints.setBackground(color);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		btnPoints.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Records r = new Records(frame, dificulty);
				r.setVisible(true);
			}
		});
		panelMenu.add(btnPoints);

		// Salir
		int xBtnExit = 162, yBtnExit = 660;
		int wBtnExit = 200, hBtnExit = 50;
		btnExit = new JButton("Salir");
		btnExit.setBounds(xBtnExit, yBtnExit, wBtnExit, hBtnExit);
		btnExit.setFont(font_30);
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
				btnExit.setSize(wBtnExit, hBtnExit);
				btnExit.setFont(font_30);
				btnExit.setForeground(color);
				btnExit.setBackground(Color.BLACK);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setLocation(xBtnExit - 10, yBtnExit - 5);
				btnExit.setSize(wBtnExit + 20, hBtnExit + 10);
				btnExit.setFont(font_35);
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
				dispose();
			}
		});
		panelMenu.add(btnExit);

		btnChangeUser = new JButton();
		btnChangeUser.setBounds(60, 190, 30, 30);
		btnChangeUser.setIcon(new ImageIcon(getClass().getResource("/Resources/editG.png")));
		btnChangeUser.setBackground(Color.BLACK);
		btnChangeUser.setBorder(null);
		btnChangeUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DChangeUser u = new DChangeUser(frame, color, border);
				u.setModal(true);
				u.setVisible(true);
			}
		});
		btnChangeUser.setFocusPainted(false);
		panelMenu.add(btnChangeUser);
	}

	// ------------------------------------------------------Métodos------------------------------------------------------

	// Cambiar a facil
	public void setEasy() {
		// Dificultad
		dificulty = 0;

		// Fondos
		lblFondoG.setVisible(false);
		lblFondoR.setVisible(false);
		lblFondoB.setVisible(true);
		fondo = new ImageIcon(getClass().getResource("/Resources/fondoInicioB.gif"));

		// Colores
		color = B;
		border = borderB;

		// Titulo
		lblTitulo.setForeground(color);
		lblU.setForeground(color);
		lblUser.setForeground(color);

		// Botones
		btnPlay.setForeground(color);
		btnPlay.setBorder(border);
		btnDificulty.setForeground(color);
		btnDificulty.setBorder(border);
		btnExit.setForeground(color);
		btnExit.setBorder(border);
		btnPoints.setForeground(color);
		btnPoints.setBorder(border);
		btnChangeUser.setIcon(new ImageIcon(getClass().getResource("/Resources/editB.png")));

		// Velocidad
		speed = 150;
	}

	// Cambiar a medio
	public void setMedium() {
		// Dificultad
		dificulty = 1;

		// Fondos
		lblFondoG.setVisible(true);
		lblFondoR.setVisible(false);
		lblFondoB.setVisible(false);
		fondo = new ImageIcon(getClass().getResource("/Resources/fondoInicio.gif"));

		// Colores
		color = G;
		border = borderG;

		// Titulo
		lblTitulo.setForeground(color);
		lblU.setForeground(color);
		lblUser.setForeground(color);

		// Botones
		btnPlay.setForeground(color);
		btnPlay.setBorder(border);
		btnDificulty.setForeground(color);
		btnDificulty.setBorder(border);
		btnExit.setForeground(color);
		btnExit.setBorder(border);
		btnPoints.setForeground(color);
		btnPoints.setBorder(border);
		btnChangeUser.setIcon(new ImageIcon(getClass().getResource("/Resources/editG.png")));

		// Velocidad
		speed = 100;
	}

	// Cambiar a dificil
	public void setHard() {
		// Dificultad
		dificulty = 2;

		// Fondos
		lblFondoG.setVisible(false);
		lblFondoR.setVisible(true);
		lblFondoB.setVisible(false);
		fondo = new ImageIcon(getClass().getResource("/Resources/fondoInicioR.gif"));

		// Colores
		color = R;
		border = borderR;

		// Titulo
		lblTitulo.setForeground(color);
		lblU.setForeground(color);
		lblUser.setForeground(color);

		// Botones
		btnPlay.setForeground(color);
		btnPlay.setBorder(border);
		btnDificulty.setForeground(color);
		btnDificulty.setBorder(border);
		btnExit.setForeground(color);
		btnExit.setBorder(border);
		btnPoints.setForeground(color);
		btnPoints.setBorder(border);
		btnChangeUser.setIcon(new ImageIcon(getClass().getResource("/Resources/editR.png")));

		// Velocidad
		speed = 50;
	}

	public void endHilos() {
		u.setFinish(true);
		t.setFinish(true);
	}

	public String generarUsuario() {
		String user = "U N K N O W N ";

		// Obtener la fecha y hora actual del sistema
		LocalDateTime fechaHoraActual = LocalDateTime.now();

		// Obtener la cantidad de nanosegundos desde el inicio del sistema
		String nanosegundos = String.valueOf(fechaHoraActual.getNano());

		for (int i = nanosegundos.length() - 6; i < nanosegundos.length(); i++) {
			user += nanosegundos.charAt(i) + " ";
		}

		return user;
	}

	public Titulo getU() {
		return u;
	}

	public void setU(Titulo u) {
		this.u = u;
	}

	public JLabel getLblUser() {
		return lblUser;
	}

	public void setLblUser(JLabel lblUser) {
		this.lblUser = lblUser;
	}
}
