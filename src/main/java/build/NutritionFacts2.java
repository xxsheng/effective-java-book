package build;

import sun.reflect.generics.tree.Tree;

import javax.xml.soap.Node;

public class NutritionFacts2 {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public NutritionFacts2(Builder1 builder) {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }

    public static class Builder1 {
        // required parameters;
        private final int servingSize;
        private final int servings;

        // optional parameters
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder1(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder1 calories(int calories) {
            this.calories = calories;
            return this;
        }

        public Builder1 fat(int fat) {
            this.fat = fat;
            return this;
        }

        public Builder1 sodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        public Builder1 carbohydrate(int carbohydrate) {
            this.carbohydrate = carbohydrate;
            return this;
        }

        public NutritionFacts2 build() {
            return new NutritionFacts2(this);
        }
    }
    
}
