package stepDefinitions;

public class MorningFreshnessMember {
	private String name;
	private SmoothieSchema schema;
	private int points;

	public MorningFreshnessMember(String name, SmoothieSchema schema) {
		this.name = name;
		this.schema = schema;
	}

	public void orders(Integer amount, String drink) {
		points += schema.getPointsFor(drink) * amount;
	}

	public Integer getPoints() {

		return points;
	}
}
