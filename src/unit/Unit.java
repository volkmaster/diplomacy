package unit;

import country.Country;
import province.Province;

public class Unit {
    protected Country owner;
    protected Province location;

    public Unit(Country owner, Province location) {
        this.owner = owner;
        this.location = location;
    }

    public Country getOwner() {
        return owner;
    }

    public Province getLocation() {
        return location;
    }

    public void setLocation(Province location) {
        this.location = location;
    }

    public void setOwner(Country owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return String.format("Owner: %s | Location: %s", owner, location.getTag());
    }
}
