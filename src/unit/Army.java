package unit;

import country.Country;
import org.w3c.dom.Element;
import province.Province;

public class Army extends Unit {
    private final String TYPE = "army";

    public Army(Country owner, Province location) {
        super(owner, location);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Type: %s", TYPE);
    }
}
