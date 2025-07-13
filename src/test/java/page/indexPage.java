package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {
	
	 WebDriver driver;

	    public indexPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    // PageFactory: Top-level main categories from nav bar
	    @FindBy(css = "ul.nav-pills > li")
	    List<WebElement> mainCategoryList;

	    // Getter method for category list
	    public List<WebElement> getMainCategoryList() {
	        return mainCategoryList;
	    }
	    // Top navigation menu items (main categories)
	    @FindBy(css = "ul.nav-pills > li > a")
	    List<WebElement> mainCategoryLinks;

	    public List<WebElement> getMainCategoryLinks() {
	        return mainCategoryLinks;
	    }

}
