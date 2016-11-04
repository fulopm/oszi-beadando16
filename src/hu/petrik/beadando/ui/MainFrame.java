package hu.petrik.beadando.ui;

import static hu.petrik.beadando.Constants.APP_NAME;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import hu.petrik.beadando.data.Results;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel mainPanel;

	/* PANELS */
	private JPanel upMenuPanel;
	private JPanel downFooterPanel;
	private JPanel centerContentPanel;

	/* MENU COMPONENTS */
	private JButton upMenuButtonPersonal;
	private JButton upMenuButtonDesktop;
	private JButton upMenuButtonMobile;

	/* FOOTER COMPONENTS */
	private JLabel downFooterLabelCopy;

	/* CONTENT COMPONENTS */
	private CenterPersonalPanel centerContentPanelPersonal;
	private CenterDesktopPanel centerContentPanelDesktop;
	private CenterMobilePanel centerContentMobilePanel;

	private final JComponent[] upMenuPanelComponents = { upMenuButtonPersonal, upMenuButtonDesktop,
			upMenuButtonMobile };

	private final JComponent[] centerContentPanelComponents = { centerContentPanelPersonal, centerContentPanelDesktop,
			centerContentMobilePanel };

	private final JComponent[] downFooterPanelComponents = { downFooterLabelCopy };

	final Results finalResults;

	public MainFrame() {
		finalResults = new Results();
		setTitle(APP_NAME);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainPanel = new JPanel();
		this.setContentPane(mainPanel);

		initPanelComponents();
		buildUI();

		loadAndSetIcons();
		pack();
		setLocationRelativeTo(null);

	}

	private void buildUI() {
		mainPanel.setLayout(new BorderLayout());

		/* LEFT MENU PANEL */

		upMenuPanel = new JPanel();
		upMenuPanel.setLayout(new GridLayout(1, 3));
		upMenuPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

		for (JComponent c : upMenuPanelComponents) {
			upMenuPanel.add(c);
		}

		/* DOWN FOOTER PANEL */

		downFooterPanel = new JPanel();

		for (JComponent c : downFooterPanelComponents) {
			downFooterPanel.add(c);

		}

		/* CENTER CONTENT PANEL */

		centerContentPanel = new JPanel();

		for (JComponent c : centerContentPanelComponents) {
			centerContentPanel.add(c);
		}

		mainPanel.add(upMenuPanel, BorderLayout.NORTH);
		mainPanel.add(downFooterPanel, BorderLayout.SOUTH);
		mainPanel.add(centerContentPanel, BorderLayout.CENTER);

	}

	private void initPanelComponents() {
		/* LEFT MENU PANEL */
		upMenuPanelComponents[0] = new JButton(UIConstants.UI_MENUPANEL_PERSONAL);
		upMenuPanelComponents[0].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * centerContentPanel.getComponents()[0].setVisible(true);
				 * centerContentPanel.getComponents()[1].setVisible(false);
				 * centerContentPanel.getComponents()[2].setVisible(false);
				 * upMenuPanelComponents[0].setEnabled(true);
				 * upMenuPanelComponents[1].setEnabled(false);
				 * upMenuPanelComponents[2].setEnabled(false); pack();
				 * setLocationRelativeTo(null);
				 */
				switchContentPanel(-1, 0);

			}
		});

		upMenuPanelComponents[1] = new JButton(UIConstants.UI_MENUPANEL_DESKTOP);
		upMenuPanelComponents[1].setEnabled(false);
		upMenuPanelComponents[1].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * centerContentPanel.getComponents()[0].setVisible(false);
				 * centerContentPanel.getComponents()[1].setVisible(true);
				 * centerContentPanel.getComponents()[2].setVisible(false);
				 * upMenuPanelComponents[0].setEnabled(false);
				 * upMenuPanelComponents[1].setEnabled(true);
				 * upMenuPanelComponents[2].setEnabled(false); pack();
				 * setLocationRelativeTo(null);
				 */

				switchContentPanel(-1, 1);

			}
		});

		upMenuPanelComponents[2] = new JButton(UIConstants.UI_MENUPANEL_MOBILE);
		upMenuPanelComponents[2].setEnabled(false);
		upMenuPanelComponents[2].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * centerContentPanel.getComponents()[0].setVisible(false);
				 * centerContentPanel.getComponents()[1].setVisible(false);
				 * centerContentPanel.getComponents()[2].setVisible(true);
				 * 
				 * upMenuPanelComponents[0].setEnabled(false);
				 * upMenuPanelComponents[1].setEnabled(false);
				 * upMenuPanelComponents[2].setEnabled(true); pack();
				 * setLocationRelativeTo(null);
				 */

				switchContentPanel(-1, 2);
			}
		});

		/* DOWN FOOTER PANEL */
		downFooterPanelComponents[0] = new JLabel("FM, 11.D - 2016");

		/* CENTER CONTENT PANEL */
		centerContentPanelComponents[0] = new CenterPersonalPanel(this);

		centerContentPanelComponents[1] = new CenterDesktopPanel(this);
		centerContentPanelComponents[1].setVisible(false);

		centerContentPanelComponents[2] = new CenterMobilePanel(this);
		centerContentPanelComponents[2].setVisible(false);

	}

	JComponent getMenuPanelComponent(int id) {
		if (id < 0 || id > upMenuPanelComponents.length - 1) {
			throw new IllegalArgumentException("A keresett komponens azonosítója érvénytelen.");
		}

		return upMenuPanelComponents[id];
	}

	JComponent getContentPanelComponent(int id) {
		if (id < 0 || id > centerContentPanelComponents.length - 1) {
			throw new IllegalArgumentException("A keresett komponens azonosítója érvénytelen.");
		}

		return centerContentPanelComponents[id];
	}

	private void loadAndSetIcons() {

		ArrayList<Image> temp = new ArrayList<Image>();

		try {
			for (int i = 1; i < 8; i++) {
				temp.add(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("logo_" + i+".png")));
			}
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}

		setIconImages(temp);
		temp.clear();
		temp = null;
	}

	public void switchContentPanel(int from, int to) {

		switch (from) {
		case 0:
			getContentPanelComponent(to == 1 ? 2 : 1).setVisible(false);
			getMenuPanelComponent(to == 1 ? 2 : 1).setEnabled(false);
			break;
		case 1:
			getContentPanelComponent(to == 0 ? 1 : 0).setVisible(false);
			getMenuPanelComponent(to == 0 ? 1 : 0).setEnabled(false);
			break;
		case 2:
			getContentPanelComponent(to == 2 ? 1 : 2).setVisible(false);
			getMenuPanelComponent(to == 2 ? 1 : 2).setEnabled(false);
			break;
		default:
			for (int i = 0; i < centerContentPanelComponents.length; i++) {
				if (i != to) {
					centerContentPanelComponents[i].setVisible(false);
				} else {
					centerContentPanelComponents[i].setVisible(true);
				}
			}

			for (int i = 0; i < upMenuPanelComponents.length; i++) {
				if (i != to) {
					upMenuPanelComponents[i].setEnabled(false);
				} else {
					upMenuPanelComponents[i].setEnabled(true);
				}
			}
			pack();
			setLocationRelativeTo(null);
			return;

		}
		getContentPanelComponent(from).setVisible(false);
		getContentPanelComponent(to).setVisible(true);
		getMenuPanelComponent(from).setEnabled(false);
		getMenuPanelComponent(to).setEnabled(true);

		pack();
		setLocationRelativeTo(null);

	}

}
