package tests;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import page.indexPage;

public class TC_PrintMainCategory extends BaseClass {
	
	 @Test(priority=0)
	    public void printMainCategories() throws IOException{

	        indexPage homePage = new indexPage(driver);

	        List<WebElement> categories = homePage.getMainCategoryList();

	        System.out.println("Main Categories on Homepage:");
	        for (WebElement category : categories) {
	            String text = category.getText().trim();
	            if (!text.isEmpty()) {
	                System.out.println("- " + text);
	            }
	        }
	    }

	 @Test(priority=0)
	    public void navigateToRandomCategory() throws IOException {
	        indexPage homePage = new indexPage(driver);

	        List<WebElement> categories = homePage.getMainCategoryLinks();

	        System.out.println("Available Categories:");
	        for (WebElement cat : categories) {
	            System.out.println("- " + cat.getText());
	        }

	        // Pick a random category
	        Random random = new Random();
	        int index = random.nextInt(categories.size());

	        WebElement selectedCategory = categories.get(index);
	        String selectedName = selectedCategory.getText();

	        System.out.println("\nNavigating to random category: " + selectedName);
	        selectedCategory.click();

	        // Optionally verify navigation
	        String currentUrl = driver.getCurrentUrl();
	        System.out.println("Navigated to URL: " + currentUrl);
	    }
	 
}
