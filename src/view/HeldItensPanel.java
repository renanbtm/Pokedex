package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

public class HeldItensPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public HeldItensPanel(String name) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel imgItem = new JLabel();
		imgItem.setIcon(new ImageIcon("sprites/items/" + name + ".png"));
		imgItem.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel itemName = new JLabel(name.toUpperCase().replace('-', ' '));
		itemName.setForeground(Color.ORANGE);
		itemName.setFont(new Font("Tahoma", Font.BOLD, 12));
		itemName.setHorizontalAlignment(SwingConstants.TRAILING);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(9)
					.addComponent(imgItem, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(itemName, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
					.addGap(9))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(imgItem, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
						.addComponent(itemName, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
					.addGap(10))
		);
		setLayout(groupLayout);

	}
}
