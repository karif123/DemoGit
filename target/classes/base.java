package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	
	public WebDriver driver;
	public FileInputStream fis;
	//public Properties prop = new Properties();
	public WebDriver initializeDriver() throws IOException {
		//Create an object of Properties class
		Properties prop = new Properties();
		//Create a properties file in main section and give its path.
		//FileInputStream fis = new FileInputStream("C:\\Users\\Biku\\Documents\\eclipse-workspace-Maven\\MavenFrameWork\\src\\main\\java\\resources\\data.properties"); 
		//Dynamic path of the current location of the project is given as
		//System.getProperty("user.dir")
		//Then the dynamic path of data.properties file is as below. 
		//It works for any machine
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis); //load the data.properties file
		String browserName = prop.getProperty("browser");
	//Maven also parameterized: mvn test -Dbrowser=chrome
	//When we want to read the browser from above mvn comand	
	//	String browserName=System.getProperty("browser");
		System.out.println(browserName);
				
		if(browserName.contains("Chrome")) {
			//Use Chrome driver with headless or standard mode
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			if(browserName.contains("headless")) {
				option.addArguments("headless");
			}
			driver = new ChromeDriver(option);
		}
		
		else if(browserName.equals("Firefox")) {
			//Use gecko driver
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equals("IE")) {
			//Use IE driver
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		else if(browserName.equals("Edge")) {
			//Use edge driver
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		//Specify the the Implicit time out on driver
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Above implicitlyWait(10, TimeUnit.SECONDS) is deprecated. 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	  }
	
	public String getURL() throws IOException {
		Properties prop = new Properties();
		//Create a ,properties file in main section and give its path.
		fis = new FileInputStream("C:\\Users\\Biku\\Documents\\eclipse-workspace-Maven\\MavenFrameWork\\src\\main\\java\\resources\\data.properties"); 
		prop.load(fis);
		String url = prop.getProperty("url");
		System.out.println(url);
		return url;
		
	}
	
	public String getScreenshotPath(String testCaseMethodName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srouce = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseMethodName+".png";
		FileUtils.copyFile(srouce, new File(destinationFile));
		return destinationFile; 
	}
	
}
