package unit;

import country.Country;
import org.w3c.dom.Element;
import province.Province;

public class Navy extends Unit {
    private final String TYPE = "navy";

    public Navy(Country owner, Province location) {
        super(owner, location);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Type: %s", TYPE);
    }
}
