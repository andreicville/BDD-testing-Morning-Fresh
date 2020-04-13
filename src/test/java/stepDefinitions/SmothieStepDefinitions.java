package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SmothieStepDefinitions {
	private DrinkCatalog drinkCatalog = new DrinkCatalog();
	private SmoothieSchema smoothieSchema = new SmoothieSchema(drinkCatalog);
	private MorningFreshnessMember michael;

	@Given("the following drink categories:")
	public void the_following_drink_categories(List<Map<String, String>> drinkCategories) {
		drinkCategories.stream().forEach(drinkCategory -> {
			String drink = drinkCategory.get("Drink");
			String category = drinkCategory.get("Category");
			Integer points = Integer.parseInt(drinkCategory.get("Points"));
			drinkCatalog.addDrink(drink, category);
			smoothieSchema.setPointsPerCategory(category, points);
		});

	}

	@Given("^(.*) is a morning Freshness Member$")
	public void michael_is_a_morning_Freshness_Member(String name) {
		michael = new MorningFreshnessMember(name, smoothieSchema);
	}

	@When("^(.*) purchases (\\d+) (.*) drinks?")
	public void michael_purchases_Banana_drinks(String name, Integer amount, String drink) {
         michael.orders(amount, drink);
	}

	@Then("he should earn {int} points")
	public void he_should_earn_points(Integer expectedPoints) {
       // Assert.assertEquals(expectedPoints, michael.getPoints());
        Assert.assertEquals(expectedPoints,  michael.getPoints());
	}

}
