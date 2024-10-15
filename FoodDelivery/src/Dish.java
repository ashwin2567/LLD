public class Dish {
    FoodItem name;
    double price;

    public Dish(FoodItem name, double price) {
        this.name = name;
        this.price = price;
    }

    public FoodItem getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
