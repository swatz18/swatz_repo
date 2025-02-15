package stepDefinitions;

import static org.junit.Assert.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPageObj;
import pageObjects.ProfilePageObj;

public class ProfileStepDef {
	
	WebDriver driver;
	LoginPageObj lp;
	ProfilePageObj pp;
	WebDriverWait wait=new WebDriverWait(Base.getDriver(),Duration.ofSeconds(20));
	
	@Given("I naviagte to my profile")
	public void i_naviagte_to_my_profile() {
		lp=new LoginPageObj(Base.getDriver());
		lp.selectLogin();
		lp.enterCredentials("swathihsnk26@gmail.com", "Welcomemec1!");
		lp.selectLoginButton();
		pp=new ProfilePageObj(Base.getDriver());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("View")));
	    pp.clickViewProfile();
	    //pp.closeChat();
	}
	@Given("Click on carrer profile")
	public void click_on_carrer_profile() {
	    pp.clickCarrerProfile();
	    pp.editCarrerProfile();
	    boolean res=pp.verifyFormIsPresent();
	    assertTrue(res);
	}
	@When("I click on {string}, select\\/deslect a {string}")
	public void i_click_on_select_deslect_a(String string, String string2) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("locationSugg")));
		pp.clickForLocation();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Chennai']/i")));
	    boolean isSelected=pp.isLocationSelected();
	    if(isSelected)
	    {
	    	pp.addLocation();
	    	System.out.print("Added Chennai to location prefernce");
	    }
	    else
	    {
	    	pp.addLocation();
	    	System.out.print("Removed Chennai to location prefernce");
	    }
	    pp.clickLocationLabel();
	    Thread.sleep(2000);
	}
	@When("clcik on save button")
	public void clcik_on_save_button() {
		pp.clickcpSaveButton();
	}
	@Then("I should see profile updated as {string}")
	public void i_should_see_message(String exp_text) {
	    String msg=pp.verifyProfileUpdateStatus();
	    assertTrue(msg.contains(exp_text));
	}
}
