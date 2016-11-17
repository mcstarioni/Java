package HomeWork.ClassWork;

/**
 * Created by mcstarioni on 17.11.2016.
 */
public class Drink implements Item{
    public final double price;
    public final String name;
    public final String description;
    public Drink(double price, String name, String description) {
        this.price = price;
        this.name = name;
        this.description = description;
    }
    public Drink(String name, String description)
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
