package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import api_control.PokeAPI;
import api_model.Ability;
import api_model.Pokemon;
import api_model.Stat;
import control.WrapLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;

public class PokemonDetailDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PokemonDetailDialog dialog = new PokemonDetailDialog("pikachu");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PokemonDetailDialog(String name) {

		PokeAPI api = new PokeAPI();
		Pokemon p = api.getDataOfPokemon(name);
		
		setTitle(name.toUpperCase().replace('-', ' ') + " DETAIL");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 800, 610);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel pokemonImg = new JLabel();
		pokemonImg.setIcon(new ImageIcon("sprites/pokemon/" + p.getId() + ".png"));
		pokemonImg.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));

		JLabel lblName = new JLabel();
		lblName.setText(p.getName().toUpperCase());
		lblName.setForeground(Color.ORANGE);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 30));

		JLabel lbl1 = new JLabel("Weight");
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblWeight = new JLabel();
		lblWeight.setText(Integer.toString(p.getWeight()));
		lblWeight.setForeground(Color.ORANGE);
		lblWeight.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lbl2 = new JLabel("Height");
		lbl2.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblHeight = new JLabel();
		lblHeight.setText(Integer.toString(p.getHeight()));
		lblHeight.setForeground(Color.ORANGE);
		lblHeight.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lbl3 = new JLabel("Base experience");
		lbl3.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblBaseExp = new JLabel();
		lblBaseExp.setText(Integer.toString(p.getBase_experience()));
		lblBaseExp.setForeground(Color.ORANGE);
		lblBaseExp.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lbl4 = new JLabel("Default");
		lbl4.setFont(new Font("Tahoma", Font.BOLD, 16));

		JLabel lblIsDefault = new JLabel();
		if (p.getIs_default()) lblIsDefault.setText("<html><font color='green'>YES</font></html>");
		else lblIsDefault.setText("<html><font color='red'>NO</font></html>");
		lblIsDefault.setForeground(Color.ORANGE);
		lblIsDefault.setFont(new Font("Tahoma", Font.BOLD, 16));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "<html><font color=\"white\" size=\"4\">Type(s)</font></html>", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));

		JScrollPane scrollPane = new JScrollPane();

		table = new JTable();
		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Stat", "Effort", "Base Stat"
				}
				) {
			Class[] columnTypes = new Class[] {
					String.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
					false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
		for (int i = 0; i < p.getStats().size(); i++) {
			model.addRow(new Object[]{p.getStats().get(i).getStat().getName(), p.getStats().get(i).getEffort(), p.getStats().get(i).getBase_stat()});
		}
		table.setModel(model);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(0).setMinWidth(90);
		table.getColumnModel().getColumn(0).setMaxWidth(150);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setMinWidth(40);
		table.getColumnModel().getColumn(1).setMaxWidth(60);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setMinWidth(40);
		table.getColumnModel().getColumn(2).setMaxWidth(60);
		
		JScrollPane heldItensSP = new JScrollPane();
		heldItensSP.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		heldItensSP.getVerticalScrollBar().setUnitIncrement(16);
		
		JPanel heldItensPanel = new JPanel();
		heldItensPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Held Items", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		heldItensPanel.setLayout(new WrapLayout(FlowLayout.LEADING));
		heldItensSP.setViewportView(heldItensPanel);
		
		int size = p.getHeld_items().size();
		for (int i = 0; i < size; i++) {
			heldItensPanel.add(new HeldItensPanel(p.getHeld_items().get(i).getItem().getName()));
		}

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addComponent(heldItensSP, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(pokemonImg, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblName, GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lbl1)
							.addGap(18)
							.addComponent(lblWeight, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lbl2)
							.addGap(18)
							.addComponent(lblHeight, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lbl3)
							.addGap(18)
							.addComponent(lblBaseExp, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lbl4)
							.addGap(18)
							.addComponent(lblIsDefault, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(pokemonImg, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
					.addGap(57)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl1)
						.addComponent(lblWeight)
						.addComponent(lbl2)
						.addComponent(lblHeight)
						.addComponent(lbl3)
						.addComponent(lblBaseExp)
						.addComponent(lbl4)
						.addComponent(lblIsDefault))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(heldItensSP, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
							.addComponent(table, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);

		JLabel lblAbilities = new JLabel();
		lblAbilities.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Abilities", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		lblAbilities.setFont(new Font("Tahoma", Font.BOLD, 12));
		String abilitiesBuilder = "<html>";
		int abilitiesSize = p.getAbilities().size();
		lblAbilities.setVerticalAlignment(SwingConstants.TOP);
		for (int i = 0; i < abilitiesSize; i++) {
			Ability a = p.getAbilities().get(i).getAbility();
			abilitiesBuilder += a.getName().toUpperCase() + "<br>";
		}
		abilitiesBuilder += "</html>";
		lblAbilities.setText(abilitiesBuilder);
		scrollPane.setViewportView(lblAbilities);

		JLabel lblTypes = new JLabel();
		lblTypes.setFont(new Font("Tahoma", Font.BOLD, 16));
		String typesBuilder = "";
		int typesSize = p.getTypes().size();
		for (int i = 0; i < typesSize; i++) {
			api_model.Type t = p.getTypes().get(i).getType();
			typesBuilder += t.getName().toUpperCase();
			if (i != (typesSize - 1)) typesBuilder += ", ";
		}
		lblTypes.setText(typesBuilder);

		lblTypes.setVerticalAlignment(SwingConstants.TOP);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblTypes, GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
						.addContainerGap())
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblTypes, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
						.addContainerGap())
				);
		panel.setLayout(gl_panel);
		contentPanel.setLayout(gl_contentPanel);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}
}
