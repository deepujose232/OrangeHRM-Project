package basepackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utiltiy.TimeUtils;

public class BaseHRMClass {
	
	public static Properties prop=new Properties(); // make it public static to use in other classes also
	public static WebDriver driver;
	
	//step 1 create a constructor
	
	public BaseHRMClass() {
		
		//When you are dealing with files always put in try catch, may be the file missing chances are there 
		try {
		FileInputStream file=new FileInputStream("C:\\Users\\deepu\\Rocians QA software classes\\eclipse\\HRmanagement\\src\\test\\java\\environmentvariables\\Config.properties");
		prop.load(file);
	}
		//catch for file not found
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		// catch for reading data issues
        catch(IOException a) {
        	a.printStackTrace();
        }
	}
	// constructor ends here
		
	//Step 2 create method with common commands which will be used in the child classes
		
		public static void intiate() {
			//driver path,maximize page, pageload, implicit, get url
			//If browser =chrome use code webdriver.chrome.driver
		    //else If browser=firefox use code webdriver.gecko.driver
			
			String browsername=prop.getProperty("browser"); // to access prop. make the prop as public static
			//prop.getProperty("") is the code for reading data from config file.
			if (browsername.equals("Chrome")){
				System.setProperty("webdriver.chrome.driver", "Chromedriver.exe");
				driver = new ChromeDriver();
			}
				else
			if (browsername.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
				driver = new FirefoxDriver();
				}
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeUtils.timepage));
			//time is created in a different package and we are accessing it here
			driver.get(prop.getProperty("URL"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeUtils.timepage));
			}
		public static void screenshots(String Filename) {
			File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
			FileUtils.copyFile(file,new File("C:\\Users\\deepu\\Rocians QA software classes\\eclipse\\HRmanagement\\src\\test\\java\\screenshots\\Screenshots"+Filename+".jpg"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		}}

	

