package hu.petrik.beadando.ui;

import javax.swing.JComponent;
import javax.swing.JPanel;

import hu.petrik.beadando.data.Results;
import net.java.dev.designgridlayout.DesignGridLayout;

@SuppressWarnings("serial")
public abstract class CenterPanel extends JPanel {

	protected MainFrame parent;
	protected Results results;
	protected DesignGridLayout layoutHelper;
	protected JComponent[] requiredComponents;
	
	CenterPanel(MainFrame parent) {
		this.parent = parent;
		this.results = parent.finalResults;
		initComponents();
		this.layoutHelper = new DesignGridLayout(this);
	
	}
	
	
	protected abstract void initComponents();
	protected abstract void save();
}
