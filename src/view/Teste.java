package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Teste extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teste frame = new Teste();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public Teste() throws MalformedURLException, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel imgLabel = new JLabel("");
		imgLabel.setBorder(new LineBorder(Color.ORANGE, 3, true));
		imgLabel.setBounds(10, 11, 96, 96);
		BufferedImage img = ImageIO.read(new URL("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/10.png"));
		imgLabel.setIcon(new ImageIcon(img));
		
		contentPane.add(imgLabel);
	}
}
