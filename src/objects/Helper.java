package objects;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Helper {

	public static boolean chechFileExist(String path) {
		
	File tempFile = new File (path);
	
	boolean exists = tempFile.exists();
		
	return exists;
	
	} 
	
	
	public static String getDateShiftPlanning() {
		
		LocalDateTime now = LocalDateTime.now(); 

		String date = "";
		
		int day = now.getDayOfMonth();
		int month = now.getMonth().getValue() -1;
		int year = now.getYear();
		
		date = day + "%2c" + month + "%2c" + year;
	
		return date;
		
	}
	
	public static String getDateAvailability() {
		
		LocalDateTime now = LocalDateTime.now(); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String date = formatter.format(now);
		
		return date;
		
	}
	
	
}
