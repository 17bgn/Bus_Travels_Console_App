package bgn17;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;

public class LogoDisplay {
	
	public static void logoDisplay(String path) {
		try (FileInputStream fis= new FileInputStream(new File(path))) {
			int temp = 0 ;
			while((temp = fis.read())!=-1) {
				System.out.print((char)temp);
			}
		}catch(FileNotFoundException e) {
			System.out.println("\nOh Oh!!! We Couldn't Fetch the Logo (-_-)");
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//	logoDisplay("C:\\Users\\bgnag\\eclipse-workspace\\BUS_TRAVELS_Project\\src\\bgn17\\Plogo.txt");
}
