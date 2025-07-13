package tests;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.categoryPage;
import page.indexPage;

public class TC_NavigateRandomCategory extends BaseClass {
	
	  @Test
	    public void navigateToRandomCategoryAndAssertProducts() {
	        indexPage homePage = new indexPage(driver);
	        List<WebElement> categories = homePage.getMainCategoryLinks();

	        // Pick a random category
	        Random random = new Random();
	        int index = random.nextInt(categories.size());
	        WebElement selectedCategory = categories.get(index);
	        String selectedName = selectedCategory.getText();

	        System.out.println("Navigating to category: " + selectedName);
	        selectedCategory.click();

	        // After navigation, check for visible products
	        categoryPage category = new categoryPage(driver);
	        List<WebElement> products = category.getVisibleProducts();

	        System.out.println("Visible products found: " + products.size());
	        for (WebElement p : products) {
	            System.out.println("- " + p.getText());
	        }

	        // Assert at least 3 products are visible
	        Assert.assertTrue(products.size() >= 3,
	            "Expected at least 3 products in category '" + selectedName + "', but found " + products.size());
	    }

}
