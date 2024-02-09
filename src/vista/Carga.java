package vista;

import java.awt.EventQueue;
import java.awt.desktop.ScreenSleepEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Carga extends JFrame implements Runnable{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Carga frame = new Carga();
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
	public Carga() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 304);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setUndecorated(true);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 500, 304);
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/resources/carga.gif")));
		contentPane.add(lblNewLabel);
		
		Thread hilo=new Thread(this);
		hilo.start();
	}
	
	@Override
	public void run() {
		try{
            Thread.sleep(2000);
            Inicio ini = new Inicio();
            ini.setVisible(true);
            dispose();
        }catch (InterruptedException e) { }
	}

}
