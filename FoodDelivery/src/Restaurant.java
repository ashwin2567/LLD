import java.util.Map;

public class Restaurant {
    private String name;
    private Menu menu;
    private boolean isOpen;
    private final int maxCapacity;
    private int currCapacity;

    public Restaurant(String name, Menu menu, int maxCapacity) {
        this.name = name;
        this.menu = menu;
        this.isOpen = true;
        this.maxCapacity = maxCapacity;
        this.currCapacity = 0;
    }

    public int getCurrCapacity() {
        return currCapacity;
    }

    public String getName() {
        return name;
    }

    public Menu getMenu() {
        return menu;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setCurrCapacity(int currCapacity) {
        this.currCapacity = currCapacity;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}
