package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import api_control.PokeAPI;
import api_model.Berry;

public class BerryDetailDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			BerryDetailDialog dialog = new BerryDetailDialog(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BerryDetailDialog(String name) {
		
		PokeAPI api = new PokeAPI();
		Berry b = api.getDataOfBerry(name);
		
		setModal(true);
		setResizable(false);
		setTitle(name.toUpperCase().replace('-', ' ') + " DETAIL");
		setBounds(100, 100, 600, 270);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel berryImg = new JLabel();
		berryImg.setIcon(new ImageIcon("sprites/berries/" + name + "-berry.png"));
		
		JLabel lblName = new JLabel(name.toUpperCase().replace('-', ' '));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.ORANGE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lbl1 = new JLabel("Size");
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblSize = new JLabel(Integer.toString(b.getSize()));
		lblSize.setForeground(Color.ORANGE);
		lblSize.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lbl2 = new JLabel("Natural Gift Power");
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNgp = new JLabel(Integer.toString(b.getNatural_gift_power()));
		lblNgp.setForeground(Color.ORANGE);
		lblNgp.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lbl3 = new JLabel("Smoothness");
		lbl3.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblSmoothness = new JLabel(Integer.toString(b.getSmoothness()));
		lblSmoothness.setForeground(Color.ORANGE);
		lblSmoothness.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lbl4 = new JLabel("Natural Gift Type");
		lbl4.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblNgt = new JLabel(b.getNatural_gift_type().getName().toUpperCase());
		lblNgt.setForeground(Color.ORANGE);
		lblNgt.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lbl5 = new JLabel("Max. Harvest");
		lbl5.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblMaxHarvest = new JLabel(Integer.toString(b.getMax_harvest()));
		lblMaxHarvest.setForeground(Color.ORANGE);
		lblMaxHarvest.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lbl6 = new JLabel("Soil Drayness");
		lbl6.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblSoilDryness = new JLabel(Integer.toString(b.getSoil_dryness()));
		lblSoilDryness.setForeground(Color.ORANGE);
		lblSoilDryness.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lbl7 = new JLabel("Growth Time");
		lbl7.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblGTime = new JLabel(Integer.toString(b.getGrowth_time()));
		lblGTime.setForeground(Color.ORANGE);
		lblGTime.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(berryImg, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblName, GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lbl5)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblMaxHarvest, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lbl6)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblSoilDryness, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addComponent(lbl4)
											.addGap(18)
											.addComponent(lblNgt, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addComponent(lbl1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblSize, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lbl2)))
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lbl7)
											.addGap(10)
											.addComponent(lblGTime, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addGap(10)
											.addComponent(lblNgp, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lbl3)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblSmoothness, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(berryImg, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbl1)
								.addComponent(lblNgp)
								.addComponent(lblSmoothness)
								.addComponent(lblSize)
								.addComponent(lbl2)
								.addComponent(lbl3))
							.addGap(33)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbl4)
								.addComponent(lblNgt)
								.addComponent(lbl7)
								.addComponent(lblGTime))
							.addGap(32)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbl5)
								.addComponent(lblMaxHarvest)
								.addComponent(lbl6)
								.addComponent(lblSoilDryness)))
						.addComponent(scrollPane))
					.addContainerGap(238, Short.MAX_VALUE))
		);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Flavor (Potency)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setViewportView(panel);
		
		JLabel lblFlavor = new JLabel();
		String flavorBuilder = "<html>";
		int size = b.getFlavors().size();
		for (int i = 0; i < size; i++) {
			flavorBuilder += b.getFlavors().get(i).getFlavor().getName().toUpperCase();
			flavorBuilder += " ( " + b.getFlavors().get(i).getPotency() + " )<br>";
		}
		flavorBuilder += "</html>";
		lblFlavor.setText(flavorBuilder);
		lblFlavor.setVerticalAlignment(SwingConstants.TOP);
		lblFlavor.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFlavor, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFlavor, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPanel.setLayout(gl_contentPanel);
	}
}
