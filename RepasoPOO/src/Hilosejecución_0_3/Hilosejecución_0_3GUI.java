package Hilosejecución_0_3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hilosejecución_0_3GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hilosejecución_0_3GUI window = new Hilosejecución_0_3GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Hilosejecución_0_3GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Show Mesage");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread launchThread = new Thread(new Runnable() {
	                @Override
	                public void run() {
	                    try {
	                        LaunchThread.main(null); // Llama al main de LaunchThread
	                    } catch (Exception ex) {
	                        ex.printStackTrace();
	                    }
	                }
	            });
				launchThread.start();
			}
		});
		btnNewButton.setBounds(164, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
