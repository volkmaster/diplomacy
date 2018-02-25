package province;

import unit.Unit;

public class Province {
    private String name;
    private String tag;
    private boolean passable;
    private Unit unit;

    public static final String COLOR_NEUTRAL = "#FFA500";

    public Province(String name, String tag, boolean passable) {
        this.name = name;
        this.tag = tag;
        this.passable = passable;
        this.unit = null;
    }

    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }

    public boolean isPassable() {
        return passable;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return String.format("%-30s| %-12s| %-12s",
                name,
                tag,
                passable ? "yes" : "no"
        );
    }
}
