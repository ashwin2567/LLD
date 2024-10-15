import java.util.List;

public class Menu {
    List<Dish> dishList;

    public Menu(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public List<Dish> getDishList() {
        return dishList;
    }
}