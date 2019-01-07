package screenshot;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityTest 
{
	 
 public static void utility(WebDriver driver,String screenshot)
 {
	
	 try {
		
		TakesScreenshot sc = (TakesScreenshot)driver;
		 File src = sc.getScreenshotAs(OutputType.FILE);
		 
		 FileHandler.copy(src, new File("./Screenshots/" + screenshot + ".png"));
	} 
	catch (IOException e)
	 {
		System.out.println("Exception while taking screenshot " + e.getMessage());
	}
	 
	 
	 
		
				
	
 }
}
