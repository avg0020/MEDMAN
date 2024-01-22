package vista;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class PruebaMove extends JFrame implements KeyListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblMedman = new JLabel();
	private JLabel lblMuro = new JLabel();
	private JLabel lblMuro2 = new JLabel();
	
	private Buffer buffer = new Buffer(lblMedman);
	private Medman medman = new Medman(buffer);
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaMove frame = new PruebaMove();
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
	public PruebaMove() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		addKeyListener(this);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		medman.start();
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBounds(100, 100, 600, 600);
		contentPane.add(panel);
		
		
		lblMedman.setBounds(0, 0, 100, 100);
		lblMedman.setIcon(new ImageIcon(getClass().getResource("/resources/medman.png")));
		panel.add(lblMedman);
		
		lblMuro.setBounds(200, 200, 300, 100);
		lblMuro.setBackground(Color.BLUE);
		lblMuro.setOpaque(true);
		panel.add(lblMuro);
		
		lblMuro2.setBounds(400, 300, 100, 200);
		lblMuro2.setBackground(Color.RED);
		lblMuro2.setOpaque(true);
		panel.add(lblMuro2);
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		switch(e.getKeyChar()) {
		case 'a': 
			buffer.setXDirection(-100);
			buffer.setYDirection(0);
			//lblMedman.setLocation(lblMedman.getX()-10, lblMedman.getY());
			break;
		case 's':
			buffer.setXDirection(0);
			buffer.setYDirection(+100);
			//lblMedman.setLocation(lblMedman.getX(), lblMedman.getY()-10);
			break;
		case 'd':
			buffer.setXDirection(+100);
			buffer.setYDirection(0);
			//lblMedman.setLocation(lblMedman.getX()+10, lblMedman.getY());
			break;
		case 'w':
			buffer.setXDirection(0);
			buffer.setYDirection(-100);
			//lblMedman.setLocation(lblMedman.getX(), lblMedman.getY()+10);
			break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
