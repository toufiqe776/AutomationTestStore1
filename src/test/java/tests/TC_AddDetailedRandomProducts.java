package tests;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.categoryPage;
import page.indexPage;

public class TC_AddDetailedRandomProducts extends BaseClass {

	@Test
	public void addTwoRandomProductsWithDetailsToCart()  throws IOException{
	    indexPage homePage = new indexPage(driver);
	    List<WebElement> categories = homePage.getMainCategoryLinks();

	    // Select random category
	    Random rand = new Random();
	    int catIndex = rand.nextInt(categories.size());
	    WebElement selectedCategory = categories.get(catIndex);
	    String selectedCategoryName = selectedCategory.getText().trim();

	    System.out.println("Navigating to category: " + selectedCategoryName);
	    selectedCategory.click();

	    categoryPage category = new categoryPage(driver);
	    List<WebElement> productBlocks = category.getProductBlocks();

	    Assert.assertTrue(productBlocks.size() >= 2,
	        "Not enough products to add 2. Available: " + productBlocks.size());

	    // Select 2 unique random products
	    Set<Integer> selectedIndices = new HashSet<>();
	    while (selectedIndices.size() < 2) {
	        selectedIndices.add(rand.nextInt(productBlocks.size()));
	    }

	    System.out.println("\nAdding 2 Random Products with Details:\n");

	    for (int index : selectedIndices) {
	        WebElement product = productBlocks.get(index);

	        try {
	            // Get name and URL
	            WebElement nameElement = product.findElement(By.cssSelector(".prdocutname"));
	            String productName = nameElement.getText().trim();
	            String productUrl = nameElement.getAttribute("href");

	            // Get price
	            String productPrice;
	            try {
	                productPrice = product.findElement(By.cssSelector(".oneprice")).getText().trim();
	            } catch (Exception e) {
	                productPrice = product.findElement(By.cssSelector(".pricenew")).getText().trim();
	            }

	            String quantity = "1"; // default

	            // Click Add to Cart
	            WebElement addButton = product.findElement(By.cssSelector(".productcart"));
	            addButton.click();

	            // Log
	            System.out.println("Product Name: " + productName);
	            System.out.println("Product Price: " + productPrice);
	            System.out.println("Quantity: " + quantity);
	            System.out.println("Product URL: " + productUrl);
	            System.out.println("--------------------------------------------------");

	        } catch (Exception e) {
	            System.out.println("❌ Failed to extract product at index " + index + ": " + e.getMessage());
	        }
	    }
	}

}
