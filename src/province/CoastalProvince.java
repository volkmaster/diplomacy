package province;

import country.Country;

public class CoastalProvince extends LandProvince {
    public static final String TYPE = "coastal";

    public CoastalProvince(String name, String tag, boolean passable) {
        super(name, tag, passable);
    }

    public CoastalProvince(String name, String tag, boolean passable, Country owner) {
        super(name, tag, passable, owner);
    }

    public CoastalProvince(String name, String tag, boolean passable, SupplyCenter supplyCenter) {
        super(name, tag, passable, supplyCenter);
    }

    public CoastalProvince(String name, String tag, boolean passable, Country owner, SupplyCenter supplyCenter) {
        super(name, tag, passable, owner, supplyCenter);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("| %-12s", TYPE);
    }
}
