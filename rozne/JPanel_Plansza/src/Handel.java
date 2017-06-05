import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import java.awt.Insets;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;

public class Handel {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Handel window = new Handel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Handel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 433, 301);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 200, 39);
		frame.getContentPane().add(panel);
		
		JButton btnDodajPole = new JButton("Dodaj Pole");
		panel.add(btnDodajPole);
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"#1", "#3", "#5", "#6", "#8", "#9", "#11", "#12", "#13", "#14", "#15", "#16", "#18", "#19", "#21", "#23", "#24", "#25", "#26", "#27", "#28", "#29", "#31", "#32", "#34", "#35", "#37", "#39"}));
		comboBox.setMaximumRowCount(28);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(210, 0, 200, 39);
		frame.getContentPane().add(panel_1);
		
		JButton btnDodajPole_1 = new JButton("Dodaj Pole");
		panel_1.add(btnDodajPole_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"#1", "#3", "#5", "#6", "#8", "#9", "#11", "#12", "#13", "#14", "#15", "#16", "#18", "#19", "#21", "#23", "#24", "#25", "#26", "#27", "#28", "#29", "#31", "#32", "#34", "#35", "#37", "#39"}));
		comboBox_1.setMaximumRowCount(28);
		panel_1.add(comboBox_1);
		
		JButton button = new JButton("$0");
		button.setBounds(0, 228, 65, 20);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("$100");
		button_1.setBounds(60, 228, 65, 20);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("$0");
		button_2.setBounds(210, 228, 65, 20);
		frame.getContentPane().add(button_2);
		
		JButton btnNewButton = new JButton("$100");
		btnNewButton.setBounds(270, 228, 65, 20);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnProponuj = new JButton("Proponuj");
		btnProponuj.setBounds(111, 191, 89, 23);
		frame.getContentPane().add(btnProponuj);
		
		JLabel lblkasa = new JLabel("$200(kasa)");
		lblkasa.setBounds(135, 231, 65, 14);
		frame.getContentPane().add(lblkasa);
		
		JLabel lblkasa_1 = new JLabel("$200(kasa)");
		lblkasa_1.setBounds(344, 231, 66, 14);
		frame.getContentPane().add(lblkasa_1);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.BLUE);
		separator.setBackground(Color.BLUE);
		separator.setBounds(204, 0, 2, 248);
		frame.getContentPane().add(separator);
		
		JList list = new JList();
		list.setFont(new Font("Verdana", Font.PLAIN, 12));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Gracz1", "Gracz2", "Gracz3", "Gracz4"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(210, 136, 50, 72);
		frame.getContentPane().add(list);
	}
}
