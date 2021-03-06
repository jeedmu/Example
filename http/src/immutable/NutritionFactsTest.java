package immutable;


public class NutritionFactsTest {

	public static void main(String[] args) {
		NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
				.calories(100)
				.sodium(35)
				.carbohydrate(27)
				.build();
		System.out.println(cocaCola);
		cocaCola = cocaCola.setCalories(50);
		System.out.println(cocaCola);
	}

}
