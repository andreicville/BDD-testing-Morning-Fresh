package stepDefinitions;

import java.util.HashMap;
import java.util.Map;

public class SmoothieSchema {

	private Map<String, Integer> pointsPerCategory = new HashMap<>();
	private DrinkCatalog catalog;

	public SmoothieSchema(DrinkCatalog catalog) {
		this.catalog = catalog;
	}

	public void setPointsPerCategory(String category, Integer points) {
		pointsPerCategory.put(category, points);

	}

	public int getPointsFor(String drink) {

		return pointsPerCategory.get(categoryOf(drink));
	}

	private String categoryOf(String drink) {
		return catalog.getCategoryOf(drink);
	}

}
