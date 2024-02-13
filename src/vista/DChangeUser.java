package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;

public class DChangeUser extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Inicio parent;

	// Colores
	private Color color;

	// Borders
	private Border border;

	// Fonts
	private Font font_20 = new Font("Consolas", Font.PLAIN, 20);
	private Font font_25 = new Font("Consolas", Font.PLAIN, 25);
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DChangeUser dialog = new DChangeUser(null, null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DChangeUser(Inicio parent, Color color, Border border) {
		this.parent = parent;
		this.border = border;
		this.color = color;
		// ------------------------------------------------------Dialog------------------------------------------------------
		setBounds(774, 460, 373, 465);
		setResizable(false);
		setUndecorated(true);
		getContentPane().setLayout(null);
		getContentPane().add(contentPanel);
		contentPanel.setBounds(0, 0, 373, 465);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		contentPanel.setBackground(Color.BLACK);

		JPanel panel = new JPanel();
		panel.setBounds(20, 20, 315, 75);
		panel.setBorder(new TitledBorder(new LineBorder(color, 2), "  Nuevo Nombre  ", TitledBorder.LEADING,
				TitledBorder.TOP, font_25, color));
		panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		contentPanel.add(panel);

		// ------------------------------------------------------TextField------------------------------------------------------
		textField = new JTextField();
		textField.setBounds(20, 10, 260, 65);
		textField.setForeground(color);
		textField.setFont(font_20);
		textField.setBorder(null);
		textField.setOpaque(false);
		textField.setBackground(null);
		textField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				if (textField.getText().length() > 12) {
					e.setKeyChar(textField.getText().charAt(12));
					textField.setText(textField.getText().substring(0, 12));
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		panel.add(textField);

		// ------------------------------------------------------Botones------------------------------------------------------
		// Boton Guardar
		int xBtnSave = 20, yBtnSave = 110;
		int wBtnSave = 150, hBtnSave = 50;
		JButton btnSave = new JButton("Guardar");
		btnSave.setBounds(xBtnSave, yBtnSave, wBtnSave, hBtnSave);
		btnSave.setFont(font_20);
		btnSave.setForeground(color);
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
				btnSave.setForeground(color);
				btnSave.setBackground(Color.BLACK);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnSave.setLocation(xBtnSave - 10, yBtnSave - 5);
				btnSave.setSize(wBtnSave + 20, hBtnSave + 10);
				btnSave.setFont(font_25);
				btnSave.setForeground(Color.BLACK);
				btnSave.setBackground(color);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				parent.getU().setTitulo(formatUser());
				parent.getU().setPos(0);
				dispose();
			}
		});
		btnSave.setFocusable(false);
		contentPanel.add(btnSave);
		
		// Boton Cancelar
		int xBtnCancel = 185, yBtnCancel = 110;
		int wBtnCancel = 150, hBtnCancel = 50;
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(xBtnCancel, yBtnCancel, wBtnCancel, hBtnCancel);
		btnCancel.setFont(font_20);
		btnCancel.setForeground(color);
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setBorder(border);
		btnCancel.setFocusPainted(false);
		btnCancel.addMouseListener(new MouseListener() {

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
				btnCancel.setLocation(xBtnCancel, yBtnCancel);
				btnCancel.setSize(wBtnCancel, hBtnCancel);
				btnCancel.setFont(font_20);
				btnCancel.setForeground(color);
				btnCancel.setBackground(Color.BLACK);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnCancel.setLocation(xBtnCancel - 10, yBtnCancel - 5);
				btnCancel.setSize(wBtnCancel + 20, hBtnCancel + 10);
				btnCancel.setFont(font_25);
				btnCancel.setForeground(Color.BLACK);
				btnCancel.setBackground(color);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFocusable(false);
		contentPanel.add(btnCancel);

	}
	
	public String formatUser() {
		String user="";
		
		for (int i = 0; i < textField.getText().length(); i++) {
			user += textField.getText().charAt(i)+" ";
		}
		
		return user;
	}
}
