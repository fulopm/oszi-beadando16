package hu.petrik.beadando;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.logging.*;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import hu.petrik.beadando.ui.MainFrame;

public class Main {
	private static MainFrame frame;

	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {

		Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				LOGGER.log(Level.SEVERE, "ERROR>", e);
				JOptionPane.showMessageDialog(frame, "Hiba történt! A hiba részletei ki lettek írva a kimenetre. \n(" + e.toString()+")", "Error", JOptionPane.ERROR_MESSAGE);

			}
		});

		
		UIManager.put("OptionPane.yesButtonText", "Igen");
		UIManager.put("OptionPane.noButtonText", "Nem");
		
		for (LookAndFeelInfo i : UIManager.getInstalledLookAndFeels()) {
			if (i.getName().contains("Nimbus")) {
				try {
					UIManager.setLookAndFeel(i.getClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e1) {
					throw new RuntimeException(e1);
				}
			}
		}

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				frame = new MainFrame();
				frame.setVisible(true);

			}
		});

	}
}
