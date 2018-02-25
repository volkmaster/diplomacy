import common.Constants;
import country.Country;
import province.Province;
import unit.Unit;

import java.util.*;

public class Game {
    private Map<String, Country> countries;
    private Map<String, Province> provinces;

    public Game() {
        countries = Constants.INITIAL_COUNTRIES;
        provinces = Constants.INITIAL_PROVINCES;

        List<String> tags = new ArrayList<>(countries.keySet());
        String tag = tags.get(new Random().nextInt(tags.size()));
        countries.get(tag).setHuman(true);

        Country country;
        Province province;
        for (Unit unit : Constants.INITIAL_UNITS) {
            country = unit.getOwner();
            province = unit.getLocation();
            country.addUnit(unit);
            province.setUnit(unit);
        }
    }

    public Map<String, Country> getCountries() {
        return countries;
    }

    public Collection<Country> listCountries() {
        return countries.values();
    }

    public Map<String, Province> getProvinces() {
        return provinces;
    }

    public Collection<Province> listProvinces() {
        return provinces.values();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("INITIAL_COUNTRIES + INITIAL_UNITS:\n");
        Country country;
        for (String tag : countries.keySet()) {
            country = countries.get(tag);
            builder.append(String.format("\t%s\n", country));
            for (Unit unit : country.listUnits()) {
                builder.append(String.format("\t\t%s\n", unit));
            }
        }

        builder.append("\n");

        builder.append("INITIAL_PROVINCES:\n");
        builder.append(String.format("\t%-5s| %-30s| %-12s| %-12s| %-15s| %-25s| %-25s| %-12s\n", "#", "Name", "Tag",
                "Passable", "Owner", "Supply center owner", "Supply center occupier", "Type"));
        builder.append("\t");
        for (int i = 0; i < 150; i++) {
            builder.append('-');
        }
        builder.append("\n");
        int i = 0;
        for (String tag : provinces.keySet()) {
            builder.append(String.format("\t%-5d| %s\n", ++i, provinces.get(tag)));
        }

        return builder.toString();
    }
}
