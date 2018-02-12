package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;

import api_control.PokeAPI;
import api_model.IndexPokemons;
import api_model.Pokemon;
import control.CommonData;
import control.WrapLayout;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ImageIcon;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		
		try {
			Properties props = new Properties();
			props.put("logoString", "Pokedex");
			HiFiLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setTitle("POKEDEX - By TheRBTM");
		setIconImage(new ImageIcon("img/program_icon.png").getImage());
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setMinimumSize(new Dimension(550, 300));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JScrollPane pokemonsSP = new JScrollPane();
		pokemonsSP.getVerticalScrollBar().setUnitIncrement(16);
		tabbedPane.addTab("POKÉMONS", new ImageIcon("img/pokemon_panel_icon.png"), pokemonsSP, "List of all pokémons");
		
		JPanel pokemonsPanel = new JPanel();
		pokemonsPanel.setLayout(new WrapLayout(FlowLayout.LEADING));
		pokemonsSP.setViewportView(pokemonsPanel);
		
		for (int i = 0; i < 949; i++) {
			pokemonsPanel.add(new PokemonPanel(CommonData.pokemonCatalogue.get(i).getName(), i+1));
		}
		
		JScrollPane berriesSP = new JScrollPane();
		berriesSP.getVerticalScrollBar().setUnitIncrement(16);
		tabbedPane.addTab("BERRIES", new ImageIcon("img/berry_panel_icon.png"), berriesSP, "List of all berrys");
		
		JPanel berriesPanel = new JPanel();
		berriesPanel.setLayout(new WrapLayout(FlowLayout.LEADING));
		berriesSP.setViewportView(berriesPanel);
		
		for (int i = 0; i < 64; i++) {
			berriesPanel.add(new BerryPanel(CommonData.berryCatalogue.get(i).getName()));
		}
		
		JScrollPane itemsSP = new JScrollPane();
		itemsSP.getVerticalScrollBar().setUnitIncrement(16);
		tabbedPane.addTab("ITEMS", new ImageIcon("img/items_panel_icon.png"), itemsSP, "List of all items");
		
		JPanel itemsPanel = new JPanel();
		itemsPanel.setLayout(new WrapLayout(FlowLayout.LEADING));
		itemsSP.setViewportView(itemsPanel);
		
		for (int i = 0; i < 867; i++) {
			itemsPanel.add(new ItemPanel(CommonData.itemCatalogue.get(i).getName(), i+1));
		}
		
		contentPane.setLayout(gl_contentPane);
		
	}
}