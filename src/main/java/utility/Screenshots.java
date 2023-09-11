package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshots {
	public static void getScreenshot(WebDriver driver) throws IOException {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//File destination = new File("C:\\Users\\shimp\\OneDrive\\Desktop\\Automation-tool\\Screenshot"+name+".jpg");
		File destination = new File("C:\\ss\\img.png");

		FileHandler.copy(source, destination);
	}
}
