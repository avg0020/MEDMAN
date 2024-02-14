package vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ScrollPaneConstants;

public class Records extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Inicio parent;

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
	private Font font_15 = new Font("Consolas", Font.PLAIN, 15);

	// Boders
	private Border borderR = new LineBorder(R, 2);
	private Border borderB = new LineBorder(B, 2);
	private Border borderG = new LineBorder(G, 2);
	private Border border = borderG;

	// Botones
	private JButton btnExit;
	private JTable table;

	// Combo
	private JComboBox comboBox;

	// Fondos
	private JLabel lblFondoG;
	private JLabel lblFondoR;
	private JLabel lblFondoB;
	private ImageIcon fondo;

	// Otros
	private int dificulty;
	List<String> users = new ArrayList<>();
	List<String> points = new ArrayList<>();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Records frame = new Records();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Records(Inicio parent, int dificulty) {
		this.parent = parent;
		this.dificulty = dificulty;
		// ------------------------------------------------------Frame------------------------------------------------------
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/medac.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1024, 819);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.BLACK);
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

		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 1024, 819);
		panelMenu.setBorder(null);
		panelMenu.setBackground(Color.BLACK);
		panelMenu.setOpaque(false);
		panelMenu.setLayout(null);
		contentPane.add(panelMenu);
		contentPane.setComponentZOrder(panelMenu, 0);

		// ------------------------------------------------------Botones------------------------------------------------------

		// Salir
		int xBtnExit = 412, yBtnExit = 660;
		int wBtnExit = 200, hBtnExit = 50;
		btnExit = new JButton("Menu");
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
				parent.setVisible(true);
				dispose();
			}
		});
		panelMenu.add(btnExit);

		// Tabla
		JScrollPane scrollPaneTable = new JScrollPane();
		scrollPaneTable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPaneTable.setBounds(100, 100, 824, 522);
		panelMenu.add(scrollPaneTable);

		table = new JTable();
		table.setBounds(0, 0, 824, 522);
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setCellSelectionEnabled(true);
		table.setShowGrid(false);
		table.setBorder(null);
		table.setFont(font_20);
		table.setForeground(Color.WHITE);
		table.setRowHeight(35);
		table.setRowSelectionAllowed(false);
		table.setColumnSelectionAllowed(false);
		table.getTableHeader().setFont(font_20);
		table.getTableHeader().setBackground(color);
		table.getTableHeader().setBorder(border);
		scrollPaneTable.setViewportView(table);
		scrollPaneTable.add(table);

		comboBox = new JComboBox();
		comboBox.setBounds(100, 660, 200, 50);
		comboBox.setFont(font_30);
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(color);
		comboBox.setBorder(border);
		comboBox.addItem("Facil");
		comboBox.addItem("Meida");
		comboBox.addItem("Dificil");
		comboBox.setSelectedIndex(dificulty);
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (comboBox.getSelectedIndex()) {
				case 0:
					setEasy();
					scrollPaneTable.setComponentZOrder(table, 0);
					break;
				case 1:
					setMedium();
					scrollPaneTable.setComponentZOrder(table, 0);
					break;
				case 2:
					setHard();
					scrollPaneTable.setComponentZOrder(table, 0);
					break;
				}
			}
		});
		panelMenu.add(comboBox);

		switch (dificulty) {
		case 0:
			setEasy();
			scrollPaneTable.setComponentZOrder(table, 0);
			break;
		case 1:
			setMedium();
			scrollPaneTable.setComponentZOrder(table, 0);
			break;
		case 2:
			setHard();
			scrollPaneTable.setComponentZOrder(table, 0);
			break;
		}
	}

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

		// Botones
		btnExit.setForeground(color);
		btnExit.setBorder(border);

		// Combobox
		comboBox.setBackground(color);
		comboBox.setBorder(border);

		loadRecords();
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

		// Botones
		btnExit.setForeground(color);
		btnExit.setBorder(border);

		// Combobox
		comboBox.setBackground(color);
		comboBox.setBorder(border);

		loadRecords();
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

		// Botones
		btnExit.setForeground(color);
		btnExit.setBorder(border);

		// Combobox
		comboBox.setBackground(color);
		comboBox.setBorder(border);

		loadRecords();
	}

	// Leer archivos
	public void loadRecords() {
		// Ruta del archivo donde se guardará el texto
		String filepath = "";
		switch (dificulty) {
		case 0:
			filepath = "Easy.txt";
			break;
		case 1:
			filepath = "Medium.txt";
			break;
		case 2:
			filepath = "Hard.txt";
			break;
		}

		// Usamos try-with-resources para asegurarnos de que el BufferedReader se cierre
		// correctamente
		try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
			String linea;
			String[] partes = new String[2];
			users.clear();
			points.clear();

			// Leemos cada línea del archivo mientras haya líneas que leer
			while ((linea = br.readLine()) != null) {
				partes = linea.split(":");
				users.add(partes[0]);
				points.add(partes[1]);
			}
		} catch (IOException e) {
			// Manejamos cualquier excepción de entrada/salida (IOException) que pueda
			// ocurrir
			e.printStackTrace();
		}
		// Invertir la lista
        Collections.reverse(users);
        Collections.reverse(points);
        
        //Cargar la tabla
		loadTableStock(table, users, points);
	}

	public void loadTableStock(JTable table, List users, List points) {

		// Prepara la tabla
		DefaultTableModel model = new DefaultTableModel(new Object[][] {}, new String[] { "Usuario", "puntuacion" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}
		};
		table.setModel(model);
		JTableHeader header = table.getTableHeader();
		int lines = 15;
		model.setRowCount(lines);
		
		int fila = 0, columna = 0;

		// Carga los datos
		model.setValueAt("Usuario", fila, columna);
		model.setValueAt("Puntuacion", fila, columna + 1);
		
		for (int i = 0; i < lines-1 && i < users.size(); i++) {
			model.setValueAt(users.get(i), i+1, columna);
			model.setValueAt(points.get(i), i+1, columna + 1);
		}

		// Se alinea el texto de las columnas
		Renderer tcr = new Renderer();
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(tcr);
		table.setDefaultRenderer(Object.class, tcr);
	}

	// Clase para cambiar el color de las filas
	public class Renderer extends DefaultTableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {

			// Evalua en que fila esta
			if (row % 2 == 0) {
				setBackground(color);
			} else {
				setBackground(Color.BLACK);
			}

			return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		}

	}
}
