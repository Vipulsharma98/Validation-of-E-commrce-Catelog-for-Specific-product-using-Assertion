package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.testng.Assert;


public class accessProductViaCategory {

	WebDriver driver = null;

	@Given("user navigates to ebay")
	public void userNavigatesToEbay() {
		System.setProperty("webdriver.chrome.driver","C:/Users/hp/AccessProduct_Ebay/src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
	}

	@Then("user clicks on Shop by category")
	public void userClicksOnShopbycategory(){
		WebElement shop_by_category = driver.findElement(By.xpath("//button[text()=' Shop by category']"));
		shop_by_category.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

	}

	@And("user clicks on Cell Phones & accessories")
	public void userClicksOnCellPhonesAndAccessories() {
		WebElement cell_phones_and_accessories = driver.findElement(By.xpath("//a[text()='Cell phones & accessories']"));
		cell_phones_and_accessories.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@And("user clicks on Cell Phones & Smartphones")
	public void userClicksOnCellPhonesAndSmartphones() {
		WebElement cell_phones_and_smartphones = driver.findElement(By.xpath("//a[text()='Cell Phones & Smartphones']"));
		driver.findElement(By.xpath("//a[text()='Cell Phones & Smartphones']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@And("user clicks on See all under Shop by Brand")
	public void userClicksOnSeeAllUnderShopByBrand() {
		WebElement see_all = driver.findElement(By.xpath("//button[contains(@data-see-all,'Shop by Brand')]//span[text()='See All']"));
		see_all.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@And("user Add filters")
	public void userAddFilters() {
		WebElement screen_size=driver.findElement(By.xpath("//span[text()='Screen Size']"));
		screen_size.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement select_screen_size=driver.findElement(By.id("c3-subPanel-Screen%20Size_5.5%20-%205.9%20in_cbx"));
		select_screen_size.click();
		Assert.assertTrue(select_screen_size.isSelected());
		WebElement price =driver.findElement(By.xpath("//span[@class='x-overlay-aspect__label' and text()='Price']"));
		price.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement set_min_price = driver.findElement(By.xpath("//input[@aria-label='Minimum Value, US Dollar']"));
		set_min_price.sendKeys("500");
		WebElement set_max_price=driver.findElement(By.xpath("//input[@aria-label='Maximum Value, US Dollar']")); 
		set_max_price.sendKeys("1000");
		WebElement item_location = driver.findElement(By.xpath("//span[text()='Item Location']"));
		item_location.click();
		WebElement select_location_worldwide = driver.findElement(By.xpath("//input[@value='Worldwide']"));
		select_location_worldwide.click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Worldwide']")).isSelected());
	}

	@And("user clicks on Apply button")
	public void userClicksOnApplyButton() {
		WebElement click_apply_btn = driver.findElement(By.xpath("//button[@aria-label='Apply']"));
		click_apply_btn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	@Then("user Verifies that the filter tags are applied")
	public void userVerifiesFilterTagsApplied() {
		WebElement filterApplied  = driver.findElement(By.xpath("//span[contains(text(),'filters applied')]"));
		filterApplied.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement priceTag = driver.findElement(By.xpath("//span[contains(text(),'Price')]"));
		assert priceTag.isDisplayed();

		WebElement itemLocationTag = driver.findElement(By.xpath("//span[contains(text(),'Item Location')]"));
		assert itemLocationTag.isDisplayed();

		WebElement screenSizeTag = driver.findElement(By.xpath("//span[contains(text(),'Screen Size')]"));
		assert screenSizeTag.isDisplayed();
	}

	@When("user type {string} in the search bar")
	public void userTypeInTheSearchBar(String searchName) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement searchBar = driver.findElement(By.xpath("//input[@id='gh-ac']"));
		searchBar.sendKeys(searchName);
	}

	@And("user change categories to Computers Tablets and Networking")
	public void userChangeCategoriesToComputersTabletsNetworking() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement click_all_categories = driver.findElement(By.xpath("//select[@id='gh-cat']"));
		click_all_categories.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement selectCategory = driver.findElement(By.xpath("//option[text()='Computers/Tablets & Networking']"));
		selectCategory.click();
	}

	@And("user clicks on search button")
	public void userClicksOnSearchButton() {
		WebElement searchButton = driver.findElement(By.id("gh-btn"));
		searchButton.click();
	}

	@Then("user should see page load completely with name {string}")
	public void userShouldSeePageLoadCompletelyWithName(String searchName) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		String title = driver.getTitle();
		Assert.assertTrue(title.contains(searchName));

	}

	@And("user should see first search result name matches with {string}")
	public void userShouldSeeFirstSearchResultNameMatchesWith(String searchName) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		WebElement first_Search_result  = driver.findElement(By.xpath("(//span[@role='heading'])[2]"));
		String result_Name = first_Search_result.getText();
		System.out.print(result_Name);
		Assert.assertTrue(result_Name.contains(searchName));
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}




}
