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

public class BerryPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public BerryPanel(String name) {
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setMinimumSize(new Dimension(120, 160));
		setMaximumSize(new Dimension(120, 160));
		setBorder(new LineBorder(new Color(255, 0, 0), 1, true));
		
		JLabel imgBerry = new JLabel();
		imgBerry.setPreferredSize(new Dimension(96, 96));
		imgBerry.setMinimumSize(new Dimension(96, 96));
		imgBerry.setMaximumSize(new Dimension(96, 96));
		imgBerry.setIcon(new ImageIcon("sprites/berries/" + name + "-berry.png"));
		imgBerry.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		imgBerry.setForeground(Color.GRAY);
		imgBerry.setBackground(Color.GRAY);
		
		JLabel berryName = new JLabel(name.toUpperCase().replace('-', ' '));
		berryName.setForeground(Color.ORANGE);
		berryName.setFont(new Font("Tahoma", Font.BOLD, 11));
		berryName.setHorizontalAlignment(SwingConstants.CENTER);
		
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
				new BerryDetailDialog(name).setVisible(true);
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addComponent(imgBerry, GroupLayout.PREFERRED_SIZE, 48, Short.MAX_VALUE)
					.addGap(75))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(9)
					.addComponent(berryName, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
					.addGap(11))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(imgBerry, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(berryName, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);

	}
}
