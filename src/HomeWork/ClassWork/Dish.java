package HomeWork.ClassWork;

/**
 * Created by mcstarioni on 17.11.2016.
 */
public class Dish implements Item{
    public final double price;
    public final String name;
    public final String description;
    public Dish(double price, String name, String description) {
        this.price = price;
        this.name = name;
        this.description = description;
    }
    public Dish(String name, String description)
    {
        price = 0;
        this.name = name;
        this.description = description;
    }

    @Override
    public double price() {
        return price;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return description;
    }
}
