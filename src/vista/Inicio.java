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
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Color grisFondo = new Color(240, 240, 240);
	private Color naranja = new Color(255,127,39);
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
		// JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 760);
		contentPane = new JPanel();
		contentPane.setBackground(grisFondo);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		
		
		// Titulo de la pantalla
		JLabel lblTitulo = new JLabel();
		lblTitulo.setBounds(275, 64, 393, 87);
		lblTitulo.setIcon(new ImageIcon(getClass().getResource("/resources/titulo.png")));
		
		contentPane.add(lblTitulo);
		
		// Panel del menu Inicio
		JPanel panelMenu = new JPanel();
		panelMenu.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMenu.setBounds(275, 210, 393, 410);
		panelMenu.setBackground(grisFondo);
		panelMenu.setOpaque(true);
		panelMenu.setLayout(null);
		
		contentPane.add(panelMenu);
		
		
		//Boton iniciar partida
		JButton btnInitPartida = new JButton("Single Player");
		btnInitPartida.setBackground(naranja);
		btnInitPartida.setBounds(100, 25, 200, 30);
		btnInitPartida.setBorderPainted(false);
		btnInitPartida.setFont(new Font("DejaVu Sans", Font.BOLD, 19));
		
		panelMenu.add(btnInitPartida);
	}
}
