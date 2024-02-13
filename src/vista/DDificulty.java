package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class DDificulty extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Inicio parent;

	// Colores
	private Color R = new Color(206, 0, 26);
	private Color G = new Color(35, 146, 23);
	private Color B = new Color(15, 0, 152);

	// Fonts
	private Font font_35 = new Font("Consolas", Font.PLAIN, 35);
	private Font font_30 = new Font("Consolas", Font.PLAIN, 30);

	// Boders
	private Border borderR = new LineBorder(R, 2);
	private Border borderB = new LineBorder(B, 2);
	private Border borderG = new LineBorder(G, 2);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DDificulty dialog = new DDificulty(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DDificulty(Inicio parent) {
		this.parent = parent;

		// ------------------------------------------------------Dialog------------------------------------------------------
		setBounds(719, 346, 480, 480);
		setResizable(false);
		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBackground(Color.BLACK);

		// ------------------------------------------------------Titulo------------------------------------------------------
		JLabel lblTitulo = new JLabel("Dificultad");
		lblTitulo.setBounds(0, 20, 480, 100);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(font_35);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblTitulo);

		// ------------------------------------------------------Botones------------------------------------------------------

		// Play
		int xBtnEasy = 140, yBtnEasy = 125;
		int wBtnEasy = 200, hBtnEasy = 50;
		JButton btnEasy = new JButton("Facil");
		btnEasy.setBounds(xBtnEasy, yBtnEasy, wBtnEasy, hBtnEasy);
		btnEasy.setFont(font_30);
		btnEasy.setForeground(B);
		btnEasy.setBackground(Color.BLACK);
		btnEasy.setBorder(borderB);
		btnEasy.setFocusPainted(false);
		btnEasy.addMouseListener(new MouseListener() {

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
				btnEasy.setLocation(xBtnEasy, yBtnEasy);
				btnEasy.setSize(wBtnEasy, hBtnEasy);
				btnEasy.setFont(font_30);
				btnEasy.setForeground(B);
				btnEasy.setBackground(Color.BLACK);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnEasy.setLocation(xBtnEasy - 10, yBtnEasy - 5);
				btnEasy.setSize(wBtnEasy + 20, hBtnEasy + 10);
				btnEasy.setFont(font_35);
				btnEasy.setForeground(Color.BLACK);
				btnEasy.setBackground(B);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		btnEasy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parent.setEasy();
				dispose();
			}
		});
		contentPanel.add(btnEasy);

		// Medium
		int xBtnMedium = 142, yBtnMedium = 225;
		int wBtnMedium = 200, hBtnMedium = 50;
		JButton btnMedium = new JButton("Media");
		btnMedium.setBounds(xBtnMedium, yBtnMedium, wBtnMedium, hBtnMedium);
		btnMedium.setFont(font_30);
		btnMedium.setForeground(G);
		btnMedium.setBackground(Color.BLACK);
		btnMedium.setBorder(borderG);
		btnMedium.setFocusPainted(false);
		btnMedium.addMouseListener(new MouseListener() {

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
				btnMedium.setLocation(xBtnMedium, yBtnMedium);
				btnMedium.setSize(wBtnMedium, hBtnMedium);
				btnMedium.setFont(font_30);
				btnMedium.setForeground(G);
				btnMedium.setBackground(Color.BLACK);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnMedium.setLocation(xBtnMedium - 10, yBtnMedium - 5);
				btnMedium.setSize(wBtnMedium + 20, hBtnMedium + 10);
				btnMedium.setFont(font_35);
				btnMedium.setForeground(Color.BLACK);
				btnMedium.setBackground(G);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		btnMedium.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parent.setMedium();
				dispose();
			}
		});
		contentPanel.add(btnMedium);

		// Hard
		int xBtnHard = 142, yBtnHard = 325;
		int wBtnHard = 200, hBtnHard = 50;
		JButton btnHard = new JButton("Dificil");
		btnHard.setBounds(xBtnHard, yBtnHard, wBtnHard, hBtnHard);
		btnHard.setFont(font_30);
		btnHard.setForeground(R);
		btnHard.setBackground(Color.BLACK);
		btnHard.setBorder(borderR);
		btnHard.setFocusPainted(false);
		btnHard.addMouseListener(new MouseListener() {

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
				btnHard.setLocation(xBtnHard, yBtnHard);
				btnHard.setSize(wBtnHard, hBtnHard);
				btnHard.setFont(font_30);
				btnHard.setForeground(R);
				btnHard.setBackground(Color.BLACK);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnHard.setLocation(xBtnHard - 10, yBtnHard - 5);
				btnHard.setSize(wBtnHard + 20, hBtnHard + 10);
				btnHard.setFont(font_35);
				btnHard.setForeground(Color.BLACK);
				btnHard.setBackground(R);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		btnHard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parent.setHard();
				dispose();
			}
		});
		contentPanel.add(btnHard);
	}

}
