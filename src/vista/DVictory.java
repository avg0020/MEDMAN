package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class DVictory extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DVictory dialog = new DVictory();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DVictory() {
		setBounds(0, 0, 480, 580);
		setLocationRelativeTo(null);
		//setUndecorated(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBackground(Color.BLACK);
		
		// Gif Victoria
		JLabel lblFondo = new JLabel();
		lblFondo.setBounds(0, 80, 480, 460);
		lblFondo.setIcon(new ImageIcon(getClass().getResource("/resources/victoria.gif")));
		contentPanel.add(lblFondo);
		
		// Texto
		JLabel lblTexto = new JLabel();
		lblTexto.setBounds(0, 0, 480, 100);
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTexto.setForeground(new Color(255, 255, 255));
		lblTexto.setBorder(null);
		lblTexto.setBackground(Color.BLACK);
		lblTexto.setText("Usted obtiene su título MEDAC");
		lblTexto.setFont(new Font("MingLiU-ExtB", Font.PLAIN, 25));
		contentPanel.add(lblTexto);
	}

}
