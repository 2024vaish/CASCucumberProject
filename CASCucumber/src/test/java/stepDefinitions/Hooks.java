package stepDefinitions;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.*;
import factory.BaseClass;

public class Hooks {
	WebDriver driver;
	Properties p;
	
	@Before
	public void setup() throws IOException {
		FileReader file = new FileReader("C:\\Users\\2303838\\eclipse-workspace-selenium\\CASProject\\CASProject\\src\\test\\resources\\config.properties");
		p= new Properties();
		p.load(file);
		// Logger logger = LogManager.getLogger(this.getClass());
		driver=BaseClass.initializeBrowser();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://be.cognizant.com");
		driver.manage().window().maximize();
	}
	
	@After
	public void teardown() {
		driver.close();
	}

}
