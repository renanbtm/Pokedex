package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
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

public class PokemonPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public PokemonPanel(String name, int id) {
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setMinimumSize(new Dimension(120, 160));
		setMaximumSize(new Dimension(120, 160));
		setBorder(new LineBorder(new Color(255, 0, 0), 1, true));
		
		JLabel imgPokemon = new JLabel();
		imgPokemon.setPreferredSize(new Dimension(96, 96));
		imgPokemon.setMinimumSize(new Dimension(96, 96));
		imgPokemon.setMaximumSize(new Dimension(96, 96));
		if (id <= 802) imgPokemon.setIcon(new ImageIcon("sprites/pokemon/" + id + ".png"));
		else if (id <= 892) imgPokemon.setIcon(new ImageIcon("sprites/pokemon/" + (id+9198) + ".png"));
		else imgPokemon.setIcon(new ImageIcon("img/miss.png"));
		imgPokemon.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		imgPokemon.setForeground(Color.GRAY);
		imgPokemon.setBackground(Color.GRAY);
		
		JLabel namePokemon = new JLabel(name.toUpperCase().replace('-', ' '));
		namePokemon.setForeground(Color.ORANGE);
		namePokemon.setHorizontalAlignment(SwingConstants.CENTER);
		
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
				new PokemonDetailDialog(name).setVisible(true);
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addComponent(imgPokemon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(51))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(namePokemon, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
					.addGap(10))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(imgPokemon, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(namePokemon, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);

	}
}
