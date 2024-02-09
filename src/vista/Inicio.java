package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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

public class Inicio extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// Colores
	private Color gris = new Color(240, 240, 240);
	private Color naranja_claro = new Color(255, 127, 39);
	private Color naranja_oscuro = new Color(236, 118, 0);
	private Color rojo_claro = new Color(237, 28, 36);
	private Color rojo_oscuro = new Color(206, 0, 0);

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
		
		// ------------------------------------------------------ Frame ------------------------------------------------------
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 819);
		contentPane = new JPanel();
		contentPane.setBackground(gris);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
        setFocusTraversalKeysEnabled(false);
        contentPane = new JPanel() {
			@Override
			public void paint(Graphics g) {
				Image bg = new ImageIcon(getClass().getResource("/Resources/fondoInicio.gif")).getImage();
				g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
				setOpaque(false);
				super.paint(g);
			}
		};
		setContentPane(contentPane);
		

		// ------------------------------------------------------ Componentes ------------------------------------------------------

		// Titulo de la pantalla
		JLabel lblTitulo = new JLabel();
		lblTitulo.setBounds(275, 64, 393, 87);
		lblTitulo.setIcon(new ImageIcon(getClass().getResource("/resources/titulo.png")));
		contentPane.add(lblTitulo);

		// Gifs
		JLabel lblGif1 = new JLabel();
		lblGif1.setBounds(145, 53, 100, 100);
		lblGif1.setIcon(new ImageIcon(getClass().getResource("/resources/medac.gif")));
		contentPane.add(lblGif1);

		JLabel lblGif2 = new JLabel();
		lblGif2.setBounds(698, 53, 100, 100);
		lblGif2.setIcon(new ImageIcon(getClass().getResource("/resources/medac.gif")));
		contentPane.add(lblGif2);

		// Panel del menu Inicio
		JPanel panelMenu = new JPanel();
		panelMenu.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMenu.setBounds(275, 210, 393, 410);
		panelMenu.setBackground(gris);
		panelMenu.setOpaque(true);
		panelMenu.setLayout(null);
		//contentPane.add(panelMenu);

		// Botón partida un jugador
		JButton btnInit1Player = new JButton("1 Jugador");
		btnInit1Player.setBackground(naranja_claro);
		btnInit1Player.setBounds(100, 25, 200, 30);
		btnInit1Player.setBorderPainted(false);
		btnInit1Player.setFont(new Font("DejaVu Sans", Font.BOLD, 19));
		btnInit1Player.addMouseListener(new MouseListener() {
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
				btnInit1Player.setBackground(naranja_claro);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnInit1Player.setBackground(naranja_oscuro);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		panelMenu.add(btnInit1Player);

		// Boton iniciar partida
		JButton btnInit2Players = new JButton("2 Jugadores");
		btnInit2Players.setBackground(rojo_claro);
		btnInit2Players.setBounds(100, 80, 200, 30);
		btnInit2Players.setBorderPainted(false);
		btnInit2Players.setFont(new Font("DejaVu Sans", Font.BOLD, 19));
		btnInit2Players.addMouseListener(new MouseListener() {
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
				btnInit2Players.setBackground(rojo_claro);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnInit2Players.setBackground(rojo_oscuro);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		panelMenu.add(btnInit2Players);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(100, 100, 480, 480);
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/resources/hearth.gif")));
		//contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel();
		lblNewLabel1.setBounds(300, 300, 480, 480);
		lblNewLabel1.setIcon(new ImageIcon(getClass().getResource("/resources/hearth2.gif")));
		//contentPane.add(lblNewLabel1);
		
		// ------------------------------------------------------ Lógica ------------------------------------------------------
		
	}
}
