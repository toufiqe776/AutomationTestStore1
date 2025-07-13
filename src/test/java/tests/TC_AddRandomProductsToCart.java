package tests;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.categoryPage;
import page.indexPage;

public class TC_AddRandomProductsToCart extends BaseClass {
	
	
	@Test
	public void addTwoRandomProductsToCart() throws  IOException {
	    // Initialize Home Page
	    indexPage homePage = new indexPage(driver);
	    List<WebElement> categories = homePage.getMainCategoryLinks();

	    // Pick a random category
	    Random rand = new Random();
	    int catIndex = rand.nextInt(categories.size());
	    WebElement selectedCategory = categories.get(catIndex);
	    String selectedCategoryName = selectedCategory.getText().trim();

	    System.out.println("Navigating to category: " + selectedCategoryName);
	    selectedCategory.click();

	    // Initialize Category Page
	    categoryPage category = new categoryPage(driver);
	    List<WebElement> productNames = category.getProductNames();
	    List<WebElement> addButtons = category.getAddToCartButtons();

	    // Ensure both lists have products and match
	    int maxIndex = Math.min(productNames.size(), addButtons.size());
	    Assert.assertTrue(maxIndex >= 2,
	        "Not enough products to add 2. Available: " + maxIndex);

	    // Select 2 unique random indices
	    Set<Integer> selectedIndices = new HashSet<>();
	    while (selectedIndices.size() < 2) {
	        selectedIndices.add(rand.nextInt(maxIndex));
	    }

	    System.out.println("\nAdding the following products to cart:");
	    for (int index : selectedIndices) {
	        String productName = productNames.get(index).getText().trim();
	        System.out.println("- " + productName);
	        addButtons.get(index).click();
	    }
	    }
}
