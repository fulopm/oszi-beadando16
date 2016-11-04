package hu.petrik.beadando.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
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
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import hu.petrik.beadando.data.Results;

public class CenterMobilePanel extends CenterPanel {

	private JLabel osLabel;
	private JList osList;

	private JLabel osVersionLabel;
	private JComboBox osVersionList;

	private JLabel opinionLabel;
	private JComboBox opinionList;

	private JLabel otherOsLabel;
	private JCheckBox otherOsCheckYes;
	private JCheckBox otherOsCheckNo;
	private ButtonGroup otherOsGroup;

	private JLabel osSecurityLabel;
	private JTextArea osSecurityArea;

	private JButton saveButton;

	CenterMobilePanel(MainFrame parent) {
		super(parent);
		layoutHelper.row().grid(osLabel).add(osList);
		layoutHelper.row().grid(osVersionLabel).add(osVersionList);
		layoutHelper.row().grid(opinionLabel).add(opinionList);
		layoutHelper.row().grid(otherOsLabel).add(otherOsCheckYes).add(otherOsCheckNo);
		layoutHelper.row().center().fill().add(new JSeparator());
		layoutHelper.row().grid(osSecurityLabel).add(new JScrollPane(osSecurityArea));
		layoutHelper.emptyRow();
		layoutHelper.row().right().add(saveButton);

	}

	@Override
	protected void initComponents() {
		osLabel = new JLabel(UIConstants.UI_CONTENTPANEL_MOBI_OS);
		osList = new JList(UIConstants.UI_CONTENTPANEL_MOBI_OS_MODEL);
		osList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO OS verzió választó implementálása
				final String selectedOs = (String) osList.getSelectedValue();
				osVersionList.setModel(new DefaultComboBoxModel(

						(selectedOs.equals("Android") ? UIConstants.UI_CONTENTPANEL_MOBI_OS_ANDROID_VERSIONS
								: (selectedOs.equals("iOS") ? UIConstants.UI_CONTENTPANEL_MOBI_OS_IOS_VERSIONS
										: UIConstants.UI_CONTENTPANEL_MOBI_OS_WINDOWS_VERSIONS))

				));

			}
		});

		osVersionLabel = new JLabel(UIConstants.UI_CONTENTPANEL_MOBI_OS_VERSION);
		osVersionList = new JComboBox(UIConstants.UI_CONTENTPANEL_MOBI_OS_IOS_VERSIONS);

		opinionLabel = new JLabel(UIConstants.UI_CONTENTPANEL_MOBI_OPINION);
		opinionList = new JComboBox(UIConstants.UI_CONTENTPANEL_DESK_OPINION_LIST_MODEL);

		otherOsLabel = new JLabel(UIConstants.UI_CONTENTPANEL_MOBI_HEARD_OTHER);
		otherOsCheckYes = new JCheckBox("Igen");
		otherOsCheckNo = new JCheckBox("Nem");
		otherOsGroup = new ButtonGroup();
		otherOsGroup.add(otherOsCheckYes);
		otherOsGroup.add(otherOsCheckNo);

		osSecurityLabel = new JLabel(UIConstants.UI_CONTENTPANEL_MOBI_SECURITY);
		osSecurityArea = new JTextArea(3, 20);
		osSecurityArea.setLineWrap(true);
		osSecurityArea.setWrapStyleWord(true);

		saveButton = new JButton("Mentés & tovább");

		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				save();

			}
		});

		requiredComponents = new JComponent[2];
		requiredComponents[0] = osSecurityArea;
		requiredComponents[1] = osList;

	}

	public JList getOsList() {
		return osList;
	}

	public JComboBox getOsOpinionList() {
		return opinionList;
	}

	@Override
	protected void save() {
		for (JComponent c : requiredComponents) {
			if (c instanceof JList && c.isEnabled() && ((JList) c).isSelectionEmpty()) {
				JOptionPane.showMessageDialog(parent,
						"Nem válaszotta ki az operációs rendszerét!\nTöltse ki,majd mentse újra!", "H I B A",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else if (c instanceof JTextArea && ((JTextArea) c).getText().isEmpty()) {
				JOptionPane.showMessageDialog(parent,
						"Nem írta le véleményét a mobil operációs rendszerek biztonságáról!\nTöltse ki, majd mentse újra!",
						"H I B A", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}

		for (Component c : getComponents()) {
			c.setEnabled(false);
		}
		results.putValue(osLabel, osList);
		results.putValue(osVersionLabel, osVersionList);
		results.putValue(opinionLabel, opinionList);
		results.putValue(otherOsLabel, otherOsCheckYes, otherOsCheckNo);
		results.putValue(osSecurityLabel, osSecurityArea);

		setVisible(false);

		JOptionPane.showMessageDialog(parent,
				"Eredmények elmentve, és exportálva lesznek az export.txt állományba!\nRészletek\n" + results,
				"E X P O R T", JOptionPane.INFORMATION_MESSAGE);

		results.export();


		
		if (JOptionPane.showConfirmDialog(parent,
				"Sikeres exportálás az \"export.txt\" állományba!\nBezárja a programot?", "K É S Z",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			this.parent.dispose();
			System.exit(0);
		}

	}

}
