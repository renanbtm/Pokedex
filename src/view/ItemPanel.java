package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

public class ItemPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public ItemPanel(String name, int id) {
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setMinimumSize(new Dimension(120, 160));
		setMaximumSize(new Dimension(120, 160));
		setBorder(new LineBorder(new Color(255, 0, 0), 1, true));
		
		JLabel imgItem = new JLabel();
		imgItem.setPreferredSize(new Dimension(96, 96));
		imgItem.setMinimumSize(new Dimension(96, 96));
		imgItem.setMaximumSize(new Dimension(96, 96));
		if (id <= 848) imgItem.setIcon(new ImageIcon("sprites/items/" + name + ".png"));
		else imgItem.setIcon(new ImageIcon("img/miss.png"));
		imgItem.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		imgItem.setForeground(Color.GRAY);
		imgItem.setBackground(Color.GRAY);
		
		JLabel itemName = new JLabel(name.toUpperCase().replace('-', ' '));
		itemName.setForeground(Color.ORANGE);
		itemName.setFont(new Font("Tahoma", Font.BOLD, 11));
		itemName.setHorizontalAlignment(SwingConstants.CENTER);
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				setBorder(new LineBorder(new Color(255, 0, 0), 1, true));
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setBorder(new LineBorder(new Color(255, 170, 0), 1, true));
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				new ItemDetailDialog(name).setVisible(true);
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(84)
					.addComponent(imgItem, GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
					.addGap(84))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(9)
					.addComponent(itemName, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
					.addGap(9))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(imgItem, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(itemName, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);

	}
}
