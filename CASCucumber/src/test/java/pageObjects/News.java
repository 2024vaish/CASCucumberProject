package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ExcelUtils;

public class News extends BasePage {
	//ExcelUtils obj=new ExcelUtils();
	HomePage hp=new HomePage(driver);
	public News(WebDriver driver) {
		super(driver);
		
	}


	WebElement newsTitle=driver.findElement(By.xpath("//span[contains(text(),'News')]"));
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	List<WebElement>newsLinks=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@id='news_text_title']")));
	
	//newsLinks=
	public void getlist() {
		
		
		newsLinks=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@id='news_text_title']")));
		
		
	}
	
	public List<String> getNewsText(){
		this.getlist();
		List<String> newsHeadings=new ArrayList<String>();
		for(WebElement ele:newsLinks)
		{
			newsHeadings.add(ele.getText());
		}
		System.out.println(newsHeadings.size()+"--------");
		return newsHeadings;
	}
	
	public void writeToExcel() throws IOException {
		this.getlist();
		//ExcelUtils eu=new ExcelUtils();
		List<String> newsHeadings=new ArrayList<String>();
		String text;
		for(int i=0;i<newsLinks.size();i++)
		{
			text=newsLinks.get(i).getText();
			newsHeadings.add(text);
		}
		//eu.writeExcel(newsHeadings,0);
		
	}
	
	public void clickNewsHeader(int i) throws InterruptedException {
			this.getlist();
			WebElement item=newsLinks.get(i);
			System.out.println(item.getText());
			item.click();
			Thread.sleep(10000);
			
			
		}
		
	}



