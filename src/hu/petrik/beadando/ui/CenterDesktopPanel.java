package hu.petrik.beadando.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import net.java.dev.designgridlayout.LabelAlignment;


public class CenterDesktopPanel extends CenterPanel {


	private JLabel osLabel;
	private JList osList;

	private JLabel opinionLabel;
	private JComboBox opinionList;

	private JLabel otherOsLabel;
	private JCheckBox otherOsCheckYes;
	private JCheckBox otherOsCheckNo;
	private ButtonGroup otherOsGroup;

	private JLabel osDefLabel;
	private JTextArea osDefArea;

	private JLabel osCreatorLabel;
	private JLabel osWindowsLabel;
	private JLabel osLinuxLabel;
	private JLabel osMacOSLabel;
	private JTextField osWindowsField;
	private JTextField osLinuxField;
	private JTextField osMacOSField;
	
	private JButton saveButton;

	CenterDesktopPanel(MainFrame parent) {
		super(parent);
		layoutHelper.labelAlignment(LabelAlignment.LEFT);
		layoutHelper.row().grid(osLabel).add(osList);
		layoutHelper.row().grid(opinionLabel).add(opinionList);
		layoutHelper.row().grid(otherOsLabel).add(otherOsCheckYes).add(otherOsCheckNo);
		layoutHelper.row().center().fill().add(new JSeparator());
		layoutHelper.row().grid(osDefLabel).add(new JScrollPane(osDefArea));
		layoutHelper.row().grid(osCreatorLabel).add();
		// TODO jobbra kéne zárni ezeket
		layoutHelper.row().grid(osWindowsLabel).add(osWindowsField);
		layoutHelper.row().grid(osLinuxLabel).add(osLinuxField);
		layoutHelper.row().grid(osMacOSLabel).add(osMacOSField);
		layoutHelper.emptyRow();
		layoutHelper.row().right().add(saveButton);
	}

	protected void initComponents() {
		osLabel = new JLabel(UIConstants.UI_CONTENTPANEL_DESK_OS);
		osList = new JList(UIConstants.UI_CONTENTPANEL_DESK_OS_SPINNER_MODEL);
		osList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		osList.setSelectionBackground(Color.LIGHT_GRAY);

		opinionLabel = new JLabel(UIConstants.UI_CONTENTPANEL_DESK_OPINION);
		opinionList = new JComboBox(UIConstants.UI_CONTENTPANEL_DESK_OPINION_LIST_MODEL);

		otherOsLabel = new JLabel(UIConstants.UI_CONTENTPANEL_DESK_HEARD_OTHER);
		otherOsCheckYes = new JCheckBox("Igen");
		otherOsCheckNo = new JCheckBox("Nem");
		otherOsGroup = new ButtonGroup();
		otherOsGroup.add(otherOsCheckYes);
		otherOsGroup.add(otherOsCheckNo);

		osDefLabel = new JLabel(UIConstants.UI_CONTENTPANEL_DESK_OS_DEF);
		osDefArea = new JTextArea(3, 20);
		osDefArea.setLineWrap(true);
		osDefArea.setWrapStyleWord(true);

		osCreatorLabel = new JLabel(UIConstants.UI_CONTENTPANEL_DESK_OS_CREATOR);
		osWindowsLabel = new JLabel(UIConstants.UI_CONTENTPANEL_DESK_OS_WIN);
		osLinuxLabel = new JLabel(UIConstants.UI_CONTENTPANEL_DESK_OS_LIN);
		osMacOSLabel = new JLabel(UIConstants.UI_CONTENTPANEL_DESK_OS_MAC);
		osWindowsField = new JTextField();
		osLinuxField = new JTextField();
		osMacOSField = new JTextField();
		
		saveButton = new JButton("Mentés & tovább");
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				save();
				
			}
		});
		
		requiredComponents = new JComponent[1];
		requiredComponents[0] = osDefArea;
	}

	public JList getOsList() {
		return this.osList;
	}

	public JComboBox getOsOpinionList() {
		return this.opinionList;
	}

	@Override
	protected void save() {
		for(JComponent c:requiredComponents) {
			if (c instanceof JTextArea && ((JTextArea)c).getText().isEmpty()) {
				JOptionPane.showMessageDialog(parent,
						"Nem adta meg, hogy Ön szerint mit jelent egy operációs rendszerl!\nTöltse ki, majd mentse újra!",
						"H I B A", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		
		for (Component c : getComponents()) {
			c.setEnabled(false);
		}
		results.putValue(osLabel, osList);
		results.putValue(opinionLabel, opinionList);
		results.putValue(otherOsLabel, otherOsCheckYes, otherOsCheckNo);
		results.putValue(osDefLabel, osDefArea);
		results.putValue(osWindowsLabel, osWindowsField);
		results.putValue(osLinuxLabel, osLinuxField);
		results.putValue(osMacOSLabel, osMacOSField);

		parent.switchContentPanel(1, 2);
	}

}
