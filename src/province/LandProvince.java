package province;

import country.Country;

public class LandProvince extends Province {
    private Country owner;
    private SupplyCenter supplyCenter;

    public LandProvince(String name, String tag, boolean passable) {
        this(name, tag, passable, null, null);
    }

    public LandProvince(String name, String tag, boolean passable, Country owner) {
        this(name, tag, passable, owner, null);
    }

    public LandProvince(String name, String tag, boolean passable, SupplyCenter supplyCenter) {
        this(name, tag, passable, null, supplyCenter);
    }

    public LandProvince(String name, String tag, boolean passable, Country owner, SupplyCenter supplyCenter) {
        super(name, tag, passable);
        this.owner = owner;
        this.supplyCenter = supplyCenter;
    }

    public Country getOwner() {
        return owner;
    }

    public SupplyCenter getSupplyCenter() {
        return supplyCenter;
    }

    public void setSupplyCenter(SupplyCenter supplyCenter) {
        this.supplyCenter = supplyCenter;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("| %-15s| %-25s| %-25s",
                owner != null ? owner : "",
                supplyCenter != null ? (supplyCenter.getOwner() != null ? supplyCenter.getOwner() : "") : "",
                supplyCenter != null ? (supplyCenter.getOccupier() != null ? supplyCenter.getOccupier() : "") : ""
        );
    }
}
