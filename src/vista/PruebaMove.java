package vista;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PruebaMove extends JFrame implements KeyListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblMedman = new JLabel();
	
	private Buffer buffer = new Buffer();
	private Medman medman = new Medman(buffer,lblMedman);
	
	

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
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		addKeyListener(this);
		setContentPane(contentPane);
		medman.start();
		
		lblMedman.setBounds(0, 0, 100, 100);
		lblMedman.setIcon(new ImageIcon(getClass().getResource("/resources/medman.png")));
		contentPane.add(lblMedman);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		switch(e.getKeyChar()) {
		case 'a': 
			medman.setXDirection(-10);
			medman.setYDirection(0);
			//lblMedman.setLocation(lblMedman.getX()-10, lblMedman.getY());
			break;
		case 's':
			medman.setXDirection(0);
			medman.setYDirection(+10);
			//lblMedman.setLocation(lblMedman.getX(), lblMedman.getY()-10);
			break;
		case 'd':
			medman.setXDirection(10);
			medman.setYDirection(0);
			//lblMedman.setLocation(lblMedman.getX()+10, lblMedman.getY());
			break;
		case 'w':
			medman.setXDirection(0);
			medman.setYDirection(-10);
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
