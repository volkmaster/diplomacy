package player;

import country.Country;
import unit.Unit;

import java.util.*;

public class Player {
    private boolean human;
    private Country country;
    private Map<String, Unit> units;

    public Player(boolean human, Country country) {
        this.human = human;
        this.country = country;
        this.units = new TreeMap<>();
    }

    public boolean isHuman() {
        return human;
    }

    public Country getCountry() {
        return country;
    }

    public Map<String, Unit> getUnits() {
        return units;
    }

    public List<Unit> listUnits() {
        return new ArrayList<>(units.values());
    }

    public void addUnit(Unit unit) {
        units.put(unit.getLocation().getTag(), unit);
    }

    public void removeUnit(Unit unit) {
        units.remove(unit.getLocation().getTag());
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", country.getName(), human ? "human" : "AI");
    }
}
