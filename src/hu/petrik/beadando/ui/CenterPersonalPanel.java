package hu.petrik.beadando.ui;

import static hu.petrik.beadando.ui.UIConstants.UI_CONTENTPANEL_AGE;
import static hu.petrik.beadando.ui.UIConstants.UI_CONTENTPANEL_EMAIL;
import static hu.petrik.beadando.ui.UIConstants.UI_CONTENTPANEL_HAS_COMPUTER;
import static hu.petrik.beadando.ui.UIConstants.UI_CONTENTPANEL_HAS_PHONE;
import static hu.petrik.beadando.ui.UIConstants.UI_CONTENTPANEL_NAME;
import static hu.petrik.beadando.ui.UIConstants.UI_CONTENTPANEL_SALARY;
import static hu.petrik.beadando.ui.UIConstants.UI_CONTENTPANEL_SALARY_SPINNER_MODEL;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import hu.petrik.beadando.data.Results;
import net.java.dev.designgridlayout.DesignGridLayout;
import net.java.dev.designgridlayout.LabelAlignment;

public class CenterPersonalPanel extends CenterPanel implements ActionListener {
	private JLabel nameLabel;
	private JTextField nameField;

	private JLabel emailLabel;
	private JTextField emailField;

	private JLabel ageLabel;
	private JTextField ageField;

	private JLabel hasComputerLabel;
	private JRadioButton hasComputerButtonYes;
	private JRadioButton hasComputerButtonNo;
	private ButtonGroup hasComputerGroup;

	private JLabel hasPhoneLabel;
	private JRadioButton hasPhoneButtonYes;
	private JRadioButton hasPhoneButtonNo;
	private ButtonGroup hasPhoneGroup;

	private JLabel salaryLabel;
	private JSpinner salarySpinner;

	private JButton saveButton;

	CenterPersonalPanel(MainFrame parent) {
		super(parent);
		layoutHelper.labelAlignment(LabelAlignment.LEFT);
		layoutHelper.row().grid(nameLabel).add(nameField);
		layoutHelper.row().grid(emailLabel).add(emailField);
		layoutHelper.row().grid(ageLabel).add(ageField);
		layoutHelper.row().grid(hasComputerLabel).add(hasComputerButtonYes).add(hasComputerButtonNo);
		layoutHelper.row().grid(hasPhoneLabel).add(hasPhoneButtonYes).add(hasPhoneButtonNo);
		layoutHelper.row().grid(salaryLabel).add(salarySpinner);
		layoutHelper.emptyRow();
		layoutHelper.row().right().add(saveButton);

	}

	protected void initComponents() {
		nameLabel = new JLabel(UI_CONTENTPANEL_NAME);
		nameField = new JTextField(20);

		emailLabel = new JLabel(UI_CONTENTPANEL_EMAIL);
		emailField = new JTextField(20);

		ageLabel = new JLabel(UI_CONTENTPANEL_AGE);
		ageField = new JTextField(20);

		hasComputerLabel = new JLabel(UI_CONTENTPANEL_HAS_COMPUTER);
		hasComputerButtonYes = new JRadioButton("Igen");
		hasComputerButtonNo = new JRadioButton("Nem");
		hasComputerGroup = new ButtonGroup();
		hasComputerGroup.add(hasComputerButtonYes);
		hasComputerGroup.add(hasComputerButtonNo);

		hasComputerButtonNo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					((CenterDesktopPanel) parent.getContentPanelComponent(1)).getOsList().setEnabled(false);
					((CenterDesktopPanel) parent.getContentPanelComponent(1)).getOsOpinionList().setEnabled(false);
				} else {
					((CenterDesktopPanel) parent.getContentPanelComponent(1)).getOsList().setEnabled(true);
					((CenterDesktopPanel) parent.getContentPanelComponent(1)).getOsOpinionList().setEnabled(true);
				}
			}
		});

		hasPhoneLabel = new JLabel(UI_CONTENTPANEL_HAS_PHONE);
		hasPhoneButtonYes = new JRadioButton("Igen");
		hasPhoneButtonNo = new JRadioButton("Nem");
		hasPhoneButtonNo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					((CenterMobilePanel) parent.getContentPanelComponent(2)).getOsList().setEnabled(false);
					((CenterMobilePanel) parent.getContentPanelComponent(2)).getOsOpinionList().setEnabled(false);
				} else {
					((CenterMobilePanel) parent.getContentPanelComponent(2)).getOsList().setEnabled(true);
					((CenterMobilePanel) parent.getContentPanelComponent(2)).getOsOpinionList().setEnabled(true);
				}
				
			}
		});
		
		hasPhoneGroup = new ButtonGroup();
		hasPhoneGroup.add(hasPhoneButtonYes);
		hasPhoneGroup.add(hasPhoneButtonNo);

		salaryLabel = new JLabel(UI_CONTENTPANEL_SALARY);
		salarySpinner = new JSpinner(UI_CONTENTPANEL_SALARY_SPINNER_MODEL);

		saveButton = new JButton("Mentés & tovább");
		saveButton.addActionListener(this);

		requiredComponents = new JComponent[2];
		requiredComponents[0] = emailField;
		requiredComponents[1] = ageField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == saveButton) {
			save();
		}

	}

	protected void save() {
		for (JComponent c : requiredComponents) {
			
			if (((JTextField) c).getText().isEmpty()) {
				JOptionPane.showMessageDialog(parent,
						"Az egyik kötelező mező [kor; email] nem lett kitöltve!\nTöltse ki őket,majd mentse újra!",
						"H I B A", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}

		for (Component c : getComponents()) {
			c.setEnabled(false);
		}
		results.putValue(nameLabel, nameField);
		results.putValue(emailLabel, emailField);
		results.putValue(ageLabel, ageField);
		results.putValue(hasComputerLabel, hasComputerButtonYes, hasComputerButtonNo);
		results.putValue(hasPhoneLabel, hasPhoneButtonYes, hasPhoneButtonNo);
		results.putValue(salaryLabel, salarySpinner);

		parent.switchContentPanel(0, 1);

	}

}
