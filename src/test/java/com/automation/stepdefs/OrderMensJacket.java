package com.automation.stepdefs;

import java.io.IOException;

import org.testng.Assert;

import com.automation.repository.HomePage;
import com.automation.repository.JacketsMen;
import com.automation.repository.MenPage;
import com.automation.support.Hooks;
import com.automation.support.ReadProperties;
import com.automation.test.CucumberBase;
import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
//import io.cucumber.java.en.Then;

public class OrderMensJacket extends CucumberBase{
	
	String jacketType;
	HomePage home;
	MenPage men;
	JacketsMen jackets;
	
	@Given("^Navigate to the Application URL$")
	public void navigate_to_the_Application_URL() throws IOException {
		String applicationURL = ReadProperties.getProperties("APPLICATION_URL");
		Hooks.launchURL(applicationURL);
	}
	
	@Given("^I am on Luma testing application$")
	public void i_am_on_Luma_testing_application() throws Throwable {
	    home = getHomePage();
	    home.verifyHome();
	}

	@When("^I select the menu as Men > Jackets$")
	public void i_select_the_menu_as_Men_Jackets() throws Throwable {
	    home = getHomePage();
	    home.clickOnMenLink();
	    men = getMenPage();
	    men.clickOnCategoryJackets();
	}

	@Then("^I should be able to view the list of jackets available$")
	public void i_should_be_able_to_view_the_list_of_jackets_available() throws Throwable {
	    jackets = getJacketsMenPage();
	    jackets.verifySideHeader();
	    jackets.isElementDisplayedXpath(JacketsMen.productItemsGrid);
	}

	@When("^I click on the jacket type \"([^\"]*)\"$")
	public void i_click_on_the_jacket_type(String jacketType) throws Throwable {
	    this.jacketType = jacketType;
		jackets = getJacketsMenPage();
		jackets.chooseJacketType(this.jacketType);
		Reporter.addStepLog("User has clicked on jacket type");
	}

	@When("^I select the size as \"([^\"]*)\", color as \"([^\"]*)\" and quantity (\\d+)$")
	public void i_select_the_size_as_color_as_and_quantity(String size, String color, int quantity) throws Throwable {
	    jackets = getJacketsMenPage();
		jackets.wait(5);
		jackets.chooseJacketAttributes(size, color, quantity);
	}

	@When("^I click on 'Add to Cart' button$")
	public void i_click_on_Add_to_Cart_button() throws Throwable {
	    jackets = getJacketsMenPage();
	    jackets.clickOnAddToCart();
	    jackets.wait(10);
	}

	@Then("^Product item must be successfully added to the cart$")
	public void product_item_must_be_successfully_added_to_the_cart() throws Throwable {
	    jackets = getJacketsMenPage();
		Assert.assertEquals(jackets.getTextXpath(JacketsMen.addedToCartMsg).trim(), 
				"You added "+this.jacketType+" to your shopping cart.");
	}

}
