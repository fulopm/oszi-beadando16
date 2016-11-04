package hu.petrik.beadando.util;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

public class FileUtil {

	public static File[] loadFiles(String path) {
		File dir = new File(path);
		
		if (!dir.isDirectory() || !dir.canRead()) {
			return null;
		}
	
		return dir.listFiles();
	}
	
}
