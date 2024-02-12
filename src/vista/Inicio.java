package vista;

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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// Colores
	private Color R = new Color(206, 0, 26);
	private Color G = new Color(35, 146, 23);
	private Color B = new Color(15, 0, 152);

	// Fonts
	private Font font_69 = new Font("Consolas", Font.PLAIN, 69);
	private Font font_35 = new Font("Consolas", Font.PLAIN, 35);
	private Font font_30 = new Font("Consolas", Font.PLAIN, 30);

	// Boders
	private Border borderR = new LineBorder(R, 2);
	private Border borderB = new LineBorder(B, 2);
	private Border borderG = new LineBorder(G, 2);

	// Fondos
	private JLabel lblFondoG;
	private JLabel lblFondoR;
	private JLabel lblFondoB;
	
	//Otros
	private int dificulty;
	
	
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

		// ------------------------------------------------------Frame------------------------------------------------------
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 819);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		setFocusTraversalKeysEnabled(false);
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

		// ------------------------------------------------------Titulo------------------------------------------------------
		JLabel lblTitulo = new JLabel();
		lblTitulo.setBounds(20, 20, 520, 100);
		lblTitulo.setForeground(G);
		lblTitulo.setFont(font_69);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panelMenu.add(lblTitulo);

		Titulo t = new Titulo(lblTitulo);
		t.start();

		// ------------------------------------------------------Botones------------------------------------------------------

		// Play
		int xBtnPlay = 162, yBtnPlay = 360;
		int wBtnPlay = 200, hBtnPlay = 50;
		JButton btnPlay = new JButton("Jugar");
		btnPlay.setBounds(xBtnPlay, yBtnPlay, wBtnPlay, hBtnPlay);
		btnPlay.setFont(font_30);
		btnPlay.setForeground(G);
		btnPlay.setBackground(Color.BLACK);
		btnPlay.setBorder(borderG);
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
				btnPlay.setForeground(G);
				btnPlay.setBackground(Color.BLACK);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnPlay.setLocation(xBtnPlay - 10, yBtnPlay - 5);
				btnPlay.setSize(wBtnPlay + 20, hBtnPlay + 10);
				btnPlay.setFont(font_35);
				btnPlay.setForeground(Color.BLACK);
				btnPlay.setBackground(G);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		panelMenu.add(btnPlay);

		// Dificultad
		int xBtnDificulty = 162, yBtnDificulty = 460;
		int wBtnDificulty = 200, hBtnDificulty = 50;
		JButton btnDificulty = new JButton("Dificultad");
		btnDificulty.setBounds(xBtnDificulty, yBtnDificulty, wBtnDificulty, hBtnDificulty);
		btnDificulty.setFont(font_30);
		btnDificulty.setForeground(G);
		btnDificulty.setBackground(Color.BLACK);
		btnDificulty.setBorder(borderG);
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
				btnDificulty.setForeground(G);
				btnDificulty.setBackground(Color.BLACK);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnDificulty.setLocation(xBtnDificulty - 10, yBtnDificulty - 5);
				btnDificulty.setSize(wBtnDificulty + 20, hBtnDificulty + 10);
				btnDificulty.setFont(font_35);
				btnDificulty.setForeground(Color.BLACK);
				btnDificulty.setBackground(G);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		panelMenu.add(btnDificulty);

		// Salir
		int xBtnExit = 162, yBtnExit = 560;
		int wBtnExit = 200, hBtnExit = 50;
		JButton btnExit = new JButton("Salir");
		btnExit.setBounds(xBtnExit, yBtnExit, wBtnExit, hBtnExit);
		btnExit.setFont(font_30);
		btnExit.setForeground(G);
		btnExit.setBackground(Color.BLACK);
		btnExit.setBorder(borderG);
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
				btnExit.setForeground(G);
				btnExit.setBackground(Color.BLACK);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setLocation(xBtnExit - 10, yBtnExit - 5);
				btnExit.setSize(wBtnExit + 20, hBtnExit + 10);
				btnExit.setFont(font_35);
				btnExit.setForeground(Color.BLACK);
				btnExit.setBackground(G);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panelMenu.add(btnExit);

//		JButton btnGreen = new JButton("Green");
//		btnGreen.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				lblFondoG.setVisible(true);
//				lblFondoR.setVisible(false);
//				lblFondoB.setVisible(false);
//				lblTitulo.setForeground(G);
//			}
//		});
//		btnGreen.setBounds(228, 360, 89, 23);
//		panelMenu.add(btnGreen);
//		
//		JButton btnRed = new JButton("Red");
//		btnRed.setBounds(228, 407, 89, 23);
//		btnRed.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				lblFondoR.setVisible(true);
//				lblFondoG.setVisible(false);
//				lblFondoB.setVisible(false);
//				lblTitulo.setForeground(R);
//			}
//		});
//		panelMenu.add(btnRed);
//		
//		JButton btnBlue = new JButton("Blue");
//		btnBlue.setBounds(229, 451, 89, 23);
//		btnBlue.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				lblFondoB.setVisible(true);
//				lblFondoG.setVisible(false);
//				lblFondoR.setVisible(false);
//				lblTitulo.setForeground(B);
//			}
//		});
//		panelMenu.add(btnBlue);

		// ------------------------------------------------------Métodos------------------------------------------------------
		
	}
}
