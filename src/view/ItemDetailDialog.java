package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import api_control.PokeAPI;
import api_model.Item;

public class ItemDetailDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			ItemDetailDialog dialog = new ItemDetailDialog(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ItemDetailDialog(String name) {
		
		PokeAPI api = new PokeAPI();
		Item i = api.getDataOfItem(name);
		
		setModal(true);
		setResizable(false);
		setTitle(name.toUpperCase().replace('-', ' ') + " DETAIL");
		setBounds(100, 100, 600, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel itemImg = new JLabel();
		itemImg.setIcon(new ImageIcon("sprites/items/" + name + ".png"));
		
		JLabel itemName = new JLabel(name.toUpperCase().replace('-', ' '));
		itemName.setHorizontalAlignment(SwingConstants.CENTER);
		itemName.setForeground(Color.ORANGE);
		itemName.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "Attributes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lbl1 = new JLabel("Fling power");
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblFlingPower = new JLabel(Integer.toString(i.getFling_power()));
		lblFlingPower.setForeground(Color.ORANGE);
		lblFlingPower.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lbl2 = new JLabel("Cost");
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblCost = new JLabel(Integer.toString(i.getCost()));
		lblCost.setForeground(Color.ORANGE);
		lblCost.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JTextPane txtpnEffect = new JTextPane();
		txtpnEffect.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtpnEffect.setFocusable(false);
		txtpnEffect.setEditable(false);
		txtpnEffect.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtpnEffect.setText(i.getEffect_entries().get(0).getEffect());
		
		JLabel lblAttributes = new JLabel();
		String attributesBuilder = "";
		int size = i.getAttributes().size();
		for (int x = 0; x < size; x++) {
			attributesBuilder += i.getAttributes().get(x).getName().toUpperCase().replace('-', ' ');
			if (x != size - 1) attributesBuilder += ", ";
		}
		lblAttributes.setText(attributesBuilder);
		lblAttributes.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAttributes.setVerticalAlignment(SwingConstants.TOP);
		GroupLayout gl_panel = new GroupLayout(panel);
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnEffect, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
							.addComponent(itemImg, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(itemName, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lbl1)
							.addGap(18)
							.addComponent(lblFlingPower, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
							.addComponent(lbl2)
							.addGap(18)
							.addComponent(lblCost, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(itemName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(itemImg, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl1)
						.addComponent(lblFlingPower)
						.addComponent(lblCost)
						.addComponent(lbl2))
					.addGap(18)
					.addComponent(txtpnEffect, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAttributes, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAttributes, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPanel.setLayout(gl_contentPanel);
	}
}
