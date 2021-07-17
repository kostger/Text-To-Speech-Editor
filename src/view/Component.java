package view;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Component {

	private static JComboBox<String> comboBox;
	
	public JComponent encodingType (String str) {
		JComponent panel = new JPanel();
		String[] boxOptions = { "None", "Atbash", "Rot-13" };
		comboBox = new JComboBox<String>(boxOptions);
		panel.add(new JLabel(str));
		panel.add(comboBox);
		return panel;
	}
	
	public static String getEncodingType() {
		
		String item = comboBox.getSelectedItem().toString();
		return item;
	}
}
