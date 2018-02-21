package unit;

import country.Country;
import province.Province;

public class Army extends Unit {
    private final String type = "army";

    public Army(Country owner, Province location) {
        super(owner, location);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Type: %s", type);
    }
}
