package page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class categoryPage {
	
	 WebDriver driver;

	    public categoryPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    // Selector for visible product thumbnails
	    @FindBy(css = "div.fixed_wrapper .prdocutname")
	    List<WebElement> visibleProducts;

	    public List<WebElement> getVisibleProducts() {
	        return visibleProducts;
	    }
	    
	    
	    // Product containers (to get names or links)
	    @FindBy(css = ".fixed_wrapper .prdocutname")
	    private List<WebElement> productNames;

	    // "Add to Cart" buttons
	    @FindBy(css = ".productcart")
	    private List<WebElement> addToCartButtons;

	    public List<WebElement> getProductNames() {
	        return productNames;
	    }

	    public List<WebElement> getAddToCartButtons() {
	        return addToCartButtons;
	    }
	    
	    // Product containers (each thumbnail block)
	    @FindBy(css = "div.thumbnail")
	    private List<WebElement> productBlocks;

	    public List<WebElement> getProductBlocks() {
	        return productBlocks;
	    }

}
