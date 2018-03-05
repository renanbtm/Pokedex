package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

import api_control.PokeAPI;

public class ProgramStart extends JDialog {
	
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		try {
			ProgramStart dialog = new ProgramStart();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private final JPanel contentPanel = new JPanel();
	JProgressBar progressBar = new JProgressBar();
	JLabel lblInformation = new JLabel("...");
	
	public ProgramStart() {
		setModal(true);
		setUndecorated(true);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblInformation.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInformation.setForeground(Color.WHITE);
		lblInformation.setVerticalAlignment(SwingConstants.TOP);
		lblInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformation.setBounds(0, 261, 450, 14);
		contentPanel.add(lblInformation);
		
		JLabel lblImg = new JLabel("");
		lblImg.setBounds(0, 0, 450, 275);
		lblImg.setIcon(new ImageIcon("img/startImage.jpg"));
		
		contentPanel.add(lblImg);
		
		progressBar.setBounds(0, 275, 450, 25);
		progressBar.setStringPainted(true);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setForeground(new Color(40, 210, 150));
		
		SwingWorker<Object, Object> w = new SwingWorker<Object, Object>() {

			@Override
			protected Object doInBackground() throws Exception {
				PokeAPI api = new PokeAPI();
				lblInformation.setText("Loading pokémons");
				api.loadAllPokemons(progressBar);
				//new MainFrame(progressBar).setVisible(true);
				//dispose();
				lblInformation.setText("Loading berrys");
				api.loadAllBerrys(progressBar);
				lblInformation.setText("Loading items");
				api.loadAllItems(progressBar);
				MainFrame frame = new MainFrame();
				dispose();
				frame.setVisible(true);
				return null;
			}
		};
		
		contentPanel.add(progressBar);
		w.execute();
	}
}
