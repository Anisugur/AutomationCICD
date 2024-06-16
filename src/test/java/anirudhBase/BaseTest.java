package anirudhBase;

//import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import anirudh.Methods.Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public Login login;
	
	public WebDriver InitializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Ani\\eclipse-workspace\\SeleniumFrameworkDesign\\src\\main\\java\\anirudh\\resources\\GlobalData.properties");
		prop.load(fis);
		
		String browserName=System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		if(browserName.contains("chrome")) {
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		if(browserName.contains("headless")) {
		options.addArguments("headless");
		}
		driver = new ChromeDriver(options);
		driver.manage().window().setSize(new Dimension(1440,900));
		}else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver","C:\\Users\\Ani\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		return driver;
		
	}
	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException {
		
		String jsocontent= FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);
		
		ObjectMapper Mapper = new ObjectMapper();
		List<HashMap <String,String>> data = Mapper.readValue(jsocontent,new TypeReference<List<HashMap<String,String>>>(){});
		return data;
	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source,file);
		return System.getProperty("user.dir")+"//reports//" + testCaseName + ".png";
	}
	
	@BeforeMethod
	public Login launchApplication() throws IOException {
		
		driver=InitializeDriver();
		login = new Login(driver);
		login.goTo();
		return login;
	}
	
	@AfterMethod
	public void Over() {
		driver.quit();
	}
}
