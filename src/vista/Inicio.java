package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
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
		setBounds(0, 0, 1024, 819);
		contentPane = new JPanel() {
			@Override
			public void paint(Graphics g) {
				Image bg = new ImageIcon(getClass().getResource("/Resources/fondoInicio.gif")).getImage();
				g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
				setOpaque(false);
				super.paint(g);
			}
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
        setFocusTraversalKeysEnabled(false);
		setContentPane(contentPane);
		

		// ------------------------------------------------------ Componentes ------------------------------------------------------

		// Gifs
		JLabel lblGif1 = new JLabel();
		lblGif1.setBounds(145, 53, 100, 100);
		lblGif1.setIcon(new ImageIcon(getClass().getResource("/resources/medac.gif")));
		//contentPane.add(lblGif1);

		JLabel lblGif2 = new JLabel();
		lblGif2.setBounds(698, 53, 100, 100);
		lblGif2.setIcon(new ImageIcon(getClass().getResource("/resources/medac.gif")));
		contentPane.setLayout(null);
		//contentPane.add(lblGif2);

		// Panel del menu Inicio
		JPanel panelMenu = new JPanel();
		panelMenu.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMenu.setBounds(250, 0, 524, 819);
		panelMenu.setBackground(Color.BLACK);
		panelMenu.setOpaque(true);
		panelMenu.setLayout(null);
		contentPane.add(panelMenu);
		
		// Titulo de la pantalla
		JLabel lblTitulo = new JLabel();
		lblTitulo.setBounds(112, 20, 300, 100);
		lblTitulo.setForeground(new Color(0, 128, 0));
		lblTitulo.setFont(new Font("MingLiU-ExtB", Font.PLAIN, 80));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		panelMenu.add(lblTitulo);		
		
		
		Titulo t = new Titulo(lblTitulo);
		t.start();
		// ------------------------------------------------------ Lógica ------------------------------------------------------
		
	}
}
