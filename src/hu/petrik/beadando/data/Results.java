package hu.petrik.beadando.data;

import java.awt.Component;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Results {

	private LinkedHashMap<String, String> values;

	public Results() {
		values = new LinkedHashMap<String, String>();
	}

	public void putValue(JLabel text, Component c) {
		if (c instanceof JTextArea) {
			putValue(text, (JTextArea) c);
		} else if (c instanceof JTextField) {
			putValue(text, (JTextField) c);
		} else if (c instanceof JList) {
			putValue(text, (JList) c);
		} else if (c instanceof JSpinner) {
			putValue(text, (JSpinner) c);
		} else if (c instanceof JCheckBox) {
			putValue(text, (JCheckBox) c);
		} else if (c instanceof JComboBox) {
			putValue(text, (JComboBox) c);
		} else if (c instanceof JRadioButton) {
			putValue(text, (JRadioButton) c);
		}
	}

	private void putValue(JLabel text, JTextArea value) {
		values.put(text.getText(), value.getText());
	}

	private void putValue(JLabel text, JTextField value) {
		values.put(text.getText(), value.getText());
	}

	private void putValue(JLabel text, JList value) {
		values.put(text.getText(), (String) value.getSelectedValue());
	}

	private void putValue(JLabel text, JSpinner value) {
		values.put(text.getText(), (String) value.getValue());
	}

	private void putValue(JLabel text, JCheckBox value) {
		values.put(text.getText(), (String) value.getSelectedObjects()[0]);
	}

	public void putValue(JLabel text, JCheckBox value1, JCheckBox value2) {
		if (value1.isSelected()) {
			values.put(text.getText(), (String) value1.getSelectedObjects()[0]);
		} else {
			values.put(text.getText(), (String) value2.getSelectedObjects()[0]);
		}

	}

	private void putValue(JLabel text, JComboBox value) {
		values.put(text.getText(), (String) value.getSelectedItem());
	}

	private void putValue(JLabel text, JRadioButton value) {
		values.put(text.getText(), value.isSelected() ? "Igen" : "Nem");
	}

	public void putValue(JLabel text, JRadioButton value1, JRadioButton value2) {
		if (value1.getText().equals("Igen") && value1.isSelected()) {
			values.put(text.getText(), "igen");
		} else {
			values.put(text.getText(), "nem");
		}

	}

	public String toString() {
		StringBuffer buf = new StringBuffer();

		for (String s : values.keySet()) {
			buf.append(s).append("=").append(values.get(s)).append("\n");
		}

		return buf.toString();

	}

	public void export() {
		if (values.isEmpty()) {
			throw new IllegalStateException("A values tábla üres. Először töltse fel panelenként az eredményeket!");
		}
		try {
			final FileWriter writer = new FileWriter("export.txt");
			for (String key : values.keySet()) {
				writer.write(key + "=" + values.get(key) + System.lineSeparator());
			}
			writer.close();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	
	public void clear() {
		values.clear();
	}

}
