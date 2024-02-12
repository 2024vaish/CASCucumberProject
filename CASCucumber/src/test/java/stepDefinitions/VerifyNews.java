package stepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.BaseClass;
import io.cucumber.java.en.*;
import pageObjects.*;

public class VerifyNews {
	WebDriver driver;
	HomePage hp;
	News n;
	NewsInfoPage ns;
	
	List<String> newsList;
	List<String> homePageNewsList;
	@Given("the user is on News Page")
	public void the_user_is_on_news_page() {
		BaseClass.getLogger().info("Goto BeCognizant News page");
		hp=new HomePage(BaseClass.getDriver());
		homePageNewsList=hp.headerText();
		hp.clickSeeAllLink();
		n=new News(BaseClass.getDriver());
	}

	@Given("user verifies the news headings")
	public void user_verifies_the_news_headings() {
		newsList=n.getNewsText();
		System.out.println(homePageNewsList.size());
		System.out.println(newsList.size());
		int count=0;
		for(String s:homePageNewsList) {
			for(String s2:newsList) {
				if(s.equals(s2)) {
					System.out.println(s+"news is present on both Pages");
					count++;
				}
			}
		}
		System.out.println(count+"news are matched");
		
		
	  
	}

	@When("user clicks on news header")
	public void user_clicks_on_news_header() throws InterruptedException {
		//Thread.sleep(5);
		n.clickNewsHeader(0);
		
		
	    
	}

	@Then("the user should be redirected to the next page")
	public void the_user_should_be_redirected_to_the_next_page()
	{
		//System.out.println(driver.getTitle());
	}

	@Then("user should capture the news details")
	public void user_should_capture_the_news_details() throws InterruptedException, IOException {
		Thread.sleep(5);
		ns=new NewsInfoPage(BaseClass.getDriver());
		ns.getNewsDetails(0);
	  
	}


}
