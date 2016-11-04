package hu.petrik.beadando.ui;

import javax.swing.*;

public class UIConstants {

	public static final int APP_FRAME_WIDTH = 800;
	public static final int APP_FRAME_HEIGHT = 600;

	public static final String UI_MENUPANEL_PERSONAL = "1) személyes adatok";
	public static final String UI_MENUPANEL_DESKTOP = "2) asztali operációs rendszerek";
	public static final String UI_MENUPANEL_MOBILE = "3) mobil operációs rendszerek";

	public static final String UI_CONTENTPANEL_NAME = "(1.1) Név:";
	public static final String UI_CONTENTPANEL_EMAIL = "(1.2) E-mail cím:";
	public static final String UI_CONTENTPANEL_AGE = "(1.3) Kor:";
	public static final String UI_CONTENTPANEL_HAS_COMPUTER = "(1.4) Van-e Önnek számítógépe?";
	public static final String UI_CONTENTPANEL_HAS_PHONE = "(1.5) Van-e Önnek okostelefonja?";
	public static final String UI_CONTENTPANEL_SALARY = "(1.6) Az Ön havi jövedelme:";

	public static final SpinnerModel UI_CONTENTPANEL_SALARY_SPINNER_MODEL = new SpinnerListModel(
			new String[] { "0 - 99.000 Ft", "100.000 - 129.000 Ft", "130.000 - 149.000 Ft", "150.000 - 179.000 Ft",
					"180.000 - 200.000 Ft", "200.000 Ft felett" });

	public static final String UI_CONTENTPANEL_DESK_OS = "(2.1) Milyen operációs rendszert/rendszereket használ?";
	public static final String[] UI_CONTENTPANEL_DESK_OS_SPINNER_MODEL = new String[] { "Linux/UNIX alapú", "MacOS",
			"Windows" };
	public static final String UI_CONTENTPANEL_DESK_OPINION = "(2.2) Mennyire kedveli Ön ezt a rendszert?";

	public static final String[] UI_CONTENTPANEL_DESK_OPINION_LIST_MODEL = new String[] { "5 Nagyon kedvelem",
			"4 Kedvelem", "3 Semleges", "2 Nem kedvelem", "1 Utálom" };

	public static final String UI_CONTENTPANEL_DESK_HEARD_OTHER = "(2.3) Hallott már ezelőtt ezekről az operációs rendszerekről?";

	public static final String UI_CONTENTPANEL_DESK_OS_DEF = "(2.4) Ön szerint mi az operációs rendszer?";
	public static final String UI_CONTENTPANEL_DESK_OS_CREATOR = "(2.5) Írjon egy olyan személyt minden rendszer mellé, aki Ön szerint a rendszerhez köthető!";
	public static final String UI_CONTENTPANEL_DESK_OS_WIN = "(2.5.1) Windows";
	public static final String UI_CONTENTPANEL_DESK_OS_LIN = "(2.5.2) Linux";
	public static final String UI_CONTENTPANEL_DESK_OS_MAC = "(2.5.3) MacOS";

	public static final String UI_CONTENTPANEL_MOBI_OS = "(3.1) Milyen operációs rendszer van a telefonján?";
	public static final String[] UI_CONTENTPANEL_MOBI_OS_MODEL = new String[] { "iOS", "Android", "Windows" };

	public static final String[] UI_CONTENTPANEL_MOBI_OS_ANDROID_VERSIONS = new String[] { "Gingerbread (2.3–2.3.7)",
			"Honeycomb (3.0–3.2.6)", "Ice Cream Sandwich (4.0–4.0.4)", "Jelly Bean (4.1–4.3.1)", "KitKat (4.4–4.4.4)",
			"Lollipop (5.0-5.1.1)", "Marshmallow (6.0)", "Nougat (7.0)" };
	public static final String[] UI_CONTENTPANEL_MOBI_OS_IOS_VERSIONS = new String[] { "iOS 5", "iOS 6", "iOS 7",
			"iOS 8", "iOS 9", "iOS 10" };
	public static final String[] UI_CONTENTPANEL_MOBI_OS_WINDOWS_VERSIONS = new String[] { "WindowsPhone 7",
			"Windows Phone 8", "Windows Phone 8.1", "Windows Phone 10", "Egyéb" };
	
	
	public static final String UI_CONTENTPANEL_MOBI_OS_VERSION = "(3.2) Jelenleg milyen verziót használ ebből a rendszerből?";
	public static final String UI_CONTENTPANEL_MOBI_OPINION = "(3.3) Mennyire kedveli Ön ezt a rendszert?";
	public static final String UI_CONTENTPANEL_MOBI_HEARD_OTHER = "(3.4) Hallott már ezelőtt ezekről az operációs rendszerekről?";
	
	public static final String UI_CONTENTPANEL_MOBI_SECURITY = "(3.5) Ön szerint miért fontos, hogy egy mobil operációs rendszer biztonságos legyen?";
	

}
