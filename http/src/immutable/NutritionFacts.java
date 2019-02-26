package immutable;

// Builder Pattern
public class NutritionFacts {
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;

	public static class Builder {
		// Required parameters
		private final int servingSize;
		private final int servings;

		// Optional parameters - initialized to default values
		private int calories = 0;
		private int fat = 0;
		private int carbohydrate = 0;
		private int sodium = 0;

		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}

		public Builder calories(int val) {
			calories = val;
			return this;
		}

		public Builder fat(int val) {
			fat = val;
			return this;
		}

		public Builder carbohydrate(int val) {
			carbohydrate = val;
			return this;
		}

		public Builder sodium(int val) {
			sodium = val;
			return this;
		}

		public NutritionFacts build() {
			return new NutritionFacts(this);
		}
	}

	private NutritionFacts(Builder builder) {
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}

	public int getServingSize() {
		return servingSize;
	}
	
	public NutritionFacts setServingSize(int servingSize) {
		return new NutritionFacts.Builder(servingSize, this.servings)
		.calories(this.calories)
		.sodium(this.sodium)
		.carbohydrate(this.carbohydrate)
		.fat(this.fat)
		.build();
	}

	public int getServings() {
		return servings;
	}

	public NutritionFacts setServings(int servings) {
		return new NutritionFacts.Builder(this.servingSize, servings)
		.calories(this.calories)
		.sodium(this.sodium)
		.carbohydrate(this.carbohydrate)
		.fat(this.fat)
		.build();
	}

	public int getCalories() {
		return calories;
	}
	
	public NutritionFacts setCalories(int calories) {
		return new NutritionFacts.Builder(this.servingSize, this.servings)
		.calories(calories)
		.sodium(this.sodium)
		.carbohydrate(this.carbohydrate)
		.fat(this.fat)
		.build();
	}


	public int getFat() {
		return fat;
	}

	public NutritionFacts setFat(int fat) {
		return new NutritionFacts.Builder(this.servingSize, this.servings)
		.calories(this.calories)
		.sodium(this.sodium)
		.carbohydrate(this.carbohydrate)
		.fat(fat)
		.build();
	}

	public int getSodium() {
		return sodium;
	}
	
	public NutritionFacts setSodium(int sodium) {
		return new NutritionFacts.Builder(this.servingSize, this.servings)
		.calories(this.calories)
		.sodium(sodium)
		.carbohydrate(this.carbohydrate)
		.fat(this.fat)
		.build();
	}

	public int getCarbohydrate() {
		return carbohydrate;
	}
	
	public NutritionFacts setCorbohydrate(int carbohydrate) {
		return new NutritionFacts.Builder(this.servingSize, this.servings)
		.calories(this.calories)
		.sodium(this.sodium)
		.carbohydrate(carbohydrate)
		.fat(this.fat)
		.build();
	}


	@Override
	public String toString() {
		return "NutritionFacts [servingSize=" + servingSize + ", servings=" + servings + ", calories=" + calories
				+ ", fat=" + fat + ", sodium=" + sodium + ", carbohydrate=" + carbohydrate + "]";
	}
}