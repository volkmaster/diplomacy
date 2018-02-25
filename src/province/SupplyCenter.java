package province;

import country.Country;

public class SupplyCenter {
    private Country owner;
    private Country occupier;

    public SupplyCenter() {
        this(null);
    }

    public SupplyCenter(Country owner) {
        this.owner = owner;
        this.occupier = owner;
    }

    public Country getOwner() {
        return owner;
    }

    public void setOwner(Country owner) {
        this.owner = owner;
    }

    public Country getOccupier() {
        return occupier;
    }

    public void setOccupier(Country occupier) {
        this.occupier = occupier;
    }

    @Override
    public String toString() {
        return String.format("Owner: %s | Occupier: %s", occupier, owner);
    }
}
