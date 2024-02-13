package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class DGameOver extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Inicio grandparent;
	private Game1P parent;
	
	//Fonts
	private Font font_25 = new Font("Consolas", Font.PLAIN, 25);
	private Font font_20 = new Font("Consolas", Font.PLAIN, 20);

	// Borders
	private Border border = new LineBorder(Color.WHITE, 2);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DGameOver dialog = new DGameOver(null,null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DGameOver(Inicio grandparent, Game1P parent) {
		this.grandparent = grandparent;
		this.parent = parent;
		
		setBounds(0, 0, 520, 760);
		setLocationRelativeTo(null);
		setUndecorated(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBackground(Color.BLACK);
		
		// Gif Victoria
		JLabel lblFondo = new JLabel();
		lblFondo.setBounds(20, 125, 480, 460);
		lblFondo.setIcon(new ImageIcon(getClass().getResource("/resources/derrota.gif")));
		contentPanel.add(lblFondo);
		
		// Texto
		JLabel lblTexto = new JLabel();
		lblTexto.setBounds(10, 0, 480, 50);
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTexto.setForeground(Color.WHITE);
		lblTexto.setBorder(null);
		lblTexto.setBackground(Color.BLACK);
		lblTexto.setText("Usted no consigue su título MEDAC");
		lblTexto.setFont(font_25);
		contentPanel.add(lblTexto);
		
		//Puntos
		JLabel lblPoints = new JLabel();
		lblPoints.setBounds(10, 75, 480, 50);
		lblPoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoints.setForeground(Color.WHITE);
		lblPoints.setBorder(null);
		lblPoints.setBackground(Color.BLACK);
		lblPoints.setText("Puntuacion Total:  "+parent.getPoints());
		lblPoints.setFont(font_25);
		contentPanel.add(lblPoints);
		
		// Boton volver al menu
				int xBtnBackMenu = 50, yBtnBackMenu = 650;
				int wBtnBackMenu = 200, hBtnBackMenu = 50;
				JButton btnBackMenu = new JButton("Menu Principal");
				btnBackMenu.setBounds(xBtnBackMenu, yBtnBackMenu, wBtnBackMenu, hBtnBackMenu);
				btnBackMenu.setFont(font_20);
				btnBackMenu.setForeground(Color.WHITE);
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
						btnBackMenu.setForeground(Color.WHITE);
						btnBackMenu.setBackground(Color.BLACK);
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						btnBackMenu.setLocation(xBtnBackMenu - 10, yBtnBackMenu - 5);
						btnBackMenu.setSize(wBtnBackMenu + 20, hBtnBackMenu + 10);
						btnBackMenu.setFont(font_25);
						btnBackMenu.setForeground(Color.BLACK);
						btnBackMenu.setBackground(Color.WHITE);
					}

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub

					}
				});
				btnBackMenu.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						grandparent.setVisible(true);
						parent.dispose();
						dispose();
					}
				});
				btnBackMenu.setFocusable(false);
				contentPanel.add(btnBackMenu);

				// Boton Guardar
				int xBtnSave = 270, yBtnSave = 650;
				int wBtnSave = 200, hBtnSave = 50;
				JButton btnSave = new JButton("Guardar");
				btnSave.setBounds(xBtnSave, yBtnSave, wBtnSave, hBtnSave);
				btnSave.setFont(font_20);
				btnSave.setForeground(Color.WHITE);
				btnSave.setBackground(Color.BLACK);
				btnSave.setBorder(border);
				btnSave.setFocusPainted(false);
				btnSave.addMouseListener(new MouseListener() {

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
						btnSave.setLocation(xBtnSave, yBtnSave);
						btnSave.setSize(wBtnSave, hBtnSave);
						btnSave.setFont(font_20);
						btnSave.setForeground(Color.WHITE);
						btnSave.setBackground(Color.BLACK);
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						btnSave.setLocation(xBtnSave - 10, yBtnSave - 5);
						btnSave.setSize(wBtnSave + 20, hBtnSave + 10);
						btnSave.setFont(font_25);
						btnSave.setForeground(Color.BLACK);
						btnSave.setBackground(Color.WHITE);
					}

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub

					}
				});
				btnSave.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						grandparent.setVisible(true);
						parent.dispose();
						dispose();
					}
				});
				btnSave.setFocusable(false);
				contentPanel.add(btnSave);
	}

}
