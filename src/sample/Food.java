package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by shawn on 11/11/2015.
 */
public class Food implements Comparable<Food>
{
    private StringProperty name;
    private StringProperty ingredient;
    public Food(String name, String ingredient)
    {
        this.name = new SimpleStringProperty(name);
        this.ingredient = new SimpleStringProperty(ingredient);
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + this.getName() + '\'' +
                ", ingredient='" + this.getIngredient() + '\'' +
                '}' + "\n";
    }

    @Override
    public int compareTo(Food other) {

        String name1 = name.getValue();
        String name2 = other.getName();
        return name1.compareTo(name2);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getIngredient() {
        return ingredient.get();
    }

    public StringProperty ingredientProperty() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient.set(ingredient);
    }
}
