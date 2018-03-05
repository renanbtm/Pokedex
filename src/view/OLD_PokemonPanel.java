package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import api_model.Pokemon;

public class OLD_PokemonPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public OLD_PokemonPanel(Pokemon p) {
		setMaximumSize(new Dimension(32767, 175));
		setMinimumSize(new Dimension(480, 175));
		setBorder(new LineBorder(new Color(224, 255, 255), 2, true));
		
		JLabel imgLbl = new JLabel();
		imgLbl.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		imgLbl.setBackground(new Color(151, 252, 126));
		try {
			imgLbl.setIcon(new ImageIcon(new URL(p.getSprites().getFront_default())));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel nameLbl = new JLabel(p.getName());
		nameLbl.setForeground(Color.ORANGE);
		nameLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		nameLbl.setHorizontalTextPosition(SwingConstants.CENTER);
		nameLbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lbl1 = new JLabel("DEFAULT");
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl1.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lbl2 = new JLabel("BASE EXPERIENCE");
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl2.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel isDefaultLbl = new JLabel();
		if (p.getIs_default()) isDefaultLbl.setText("YES");
		else isDefaultLbl.setText("NO");
		isDefaultLbl.setHorizontalTextPosition(SwingConstants.CENTER);
		isDefaultLbl.setHorizontalAlignment(SwingConstants.CENTER);
		isDefaultLbl.setForeground(Color.GREEN);
		isDefaultLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel baseExperienceLbl = new JLabel(Integer.toString(p.getBase_experience()));
		baseExperienceLbl.setHorizontalTextPosition(SwingConstants.CENTER);
		baseExperienceLbl.setHorizontalAlignment(SwingConstants.CENTER);
		baseExperienceLbl.setForeground(Color.ORANGE);
		baseExperienceLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lbl3 = new JLabel("WEIGHT");
		lbl3.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lbl4 = new JLabel("HEIGHT");
		lbl4.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel weightLbl = new JLabel(Integer.toString(p.getWeight()));
		weightLbl.setForeground(Color.ORANGE);
		weightLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel heightLbl = new JLabel(Integer.toString(p.getHeight()));
		heightLbl.setForeground(Color.ORANGE);
		heightLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lbl5 = new JLabel("ID");
		lbl5.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel idLbl = new JLabel(Integer.toString(p.getId()));
		idLbl.setForeground(Color.ORANGE);
		idLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lbl6 = new JLabel("TYPE(S)");
		lbl6.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblTypes = new JLabel(p.getTypesToPrint());
		lblTypes.setForeground(Color.ORANGE);
		lblTypes.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(baseExperienceLbl, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addComponent(imgLbl, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(nameLbl, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(isDefaultLbl, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lbl6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lbl3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(weightLbl)
							.addGap(18)
							.addComponent(lbl4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(heightLbl)
							.addGap(18)
							.addComponent(lbl5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(idLbl))
						.addComponent(lblTypes, GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lbl1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(isDefaultLbl))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(nameLbl, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lbl3)
										.addComponent(weightLbl)
										.addComponent(lbl4)
										.addComponent(heightLbl)
										.addComponent(lbl5)
										.addComponent(idLbl)))
								.addComponent(imgLbl, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
							.addGap(17)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbl2)
								.addComponent(lbl6))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(baseExperienceLbl)
						.addComponent(lblTypes))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
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
				setBorder(new LineBorder(new Color(224, 255, 255), 2, true));
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				setBorder(new LineBorder(new Color(50, 100, 255), 2, true));
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("CLICADO");
			}
		});
	}

}
