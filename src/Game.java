import country.Country;
import player.Player;
import province.*;
import unit.Army;
import unit.Navy;
import unit.Unit;

import java.util.*;

public class Game {
    private final Map<String, Country> countries = Map.of(
            "AUS", new Country("Austria", "AUS", "#8B4513"),
            "ENG", new Country("England", "ENG", "#F08080"),
            "FRA", new Country("France", "FRA", "#00BFFF"),
            "GER", new Country("Germany", "GER", "#696969"),
            "ITA", new Country("Italy", "ITA", "#008000"),
            "RUS", new Country("Russia", "RUS", "#800080"),
            "TUR", new Country("Turkey", "TUR", "#FFFF00")
    );

    private final SortedMap<String, Province> provinces = new TreeMap<>() {{
        put("ADR", new SeaProvince("Adriatic Sea", "ADR", true));
        put("AEG", new SeaProvince("Aegean Sea", "AEG", true));
        put("Alb", new CoastalProvince("Albania", "Alb", true));
        put("Ank", new CoastalProvince("Ankara", "Ank", true, countries.get("TUR"),
                new SupplyCenter(countries.get("TUR"))));
        put("Apu", new CoastalProvince("Apulia", "Apu", true, countries.get("ITA")));
        put("Arm", new CoastalProvince("Armenia", "Arm", true, countries.get("TUR")));
        put("BAL", new SeaProvince("Baltic Sea", "BAL", true));
        put("BAR", new SeaProvince("Barents Sea", "BAR", true));
        put("BLA", new SeaProvince("Black Sea", "BLA", true));
        put("Bel", new CoastalProvince("Belgium", "Bel", true,
                new SupplyCenter()));
        put("Ber", new CoastalProvince("Berlin", "Ber", true, countries.get("GER"),
                new SupplyCenter(countries.get("GER"))));
        put("Blr", new CoastalProvince("Balearic Islands", "Blr", true));
        put("Boh", new LandlockedProvince("Bohemia", "Boh", true, countries.get("AUS")));
        put("Bre", new CoastalProvince("Brest", "Bre", true, countries.get("FRA"),
                new SupplyCenter(countries.get("FRA"))));
        put("Bud", new LandlockedProvince("Budapest", "Bud", true, countries.get("AUS"),
                new SupplyCenter(countries.get("AUS"))));
        put("Bul", new LandlockedProvince("Bulgaria", "Bul", true,
                new SupplyCenter()));
        put("Bul_ec", new CoastalProvince("Bulgaria East Coast", "Bul_ec", true,
                new SupplyCenter()));
        put("Bul_sc", new CoastalProvince("Bulgaria South Coast", "Bul_sc", true,
                new SupplyCenter()));
        put("Bur", new LandlockedProvince("Burgundy", "Bur", true, countries.get("FRA")));
        put("Cly", new CoastalProvince("Clyde", "Cly", true, countries.get("ENG")));
        put("Con", new CoastalProvince("Constantinople", "Con", true, countries.get("TUR"),
                new SupplyCenter(countries.get("TUR"))));
        put("Cor", new CoastalProvince("Corsica", "Cor", false, countries.get("FRA")));
        put("Cre", new CoastalProvince("Crete", "Cre", false));
        put("Den", new CoastalProvince("Denmark", "Den", true,
                new SupplyCenter()));
        put("EAS", new SeaProvince("Eastern Mediterranean", "EAS", true));
        put("ENG", new SeaProvince("English Channel", "ENG", true));
        put("Edi", new CoastalProvince("Edinburgh", "Edi", true, countries.get("ENG"),
                new SupplyCenter(countries.get("ENG"))));
        put("Fin", new CoastalProvince("Finland", "Fin", true, countries.get("RUS")));
        put("Gal", new LandlockedProvince("Galicia", "Gal", true, countries.get("AUS")));
        put("Gas", new CoastalProvince("Gascony", "Gas", true, countries.get("FRA")));
        put("GoB", new SeaProvince("Gulf of Bothnia", "GoB", true));
        put("GoL", new SeaProvince("Gulf of Lyon", "GoL", true));
        put("Gre", new CoastalProvince("Greece", "Gre", true,
                new SupplyCenter()));
        put("HEL", new SeaProvince("Heligoland Bight", "HEL", true));
        put("Hol", new CoastalProvince("Holland", "Hol", true,
                new SupplyCenter()));
        put("ION", new SeaProvince("Ionian Sea", "ION", true));
        put("IRI", new SeaProvince("Irish Sea", "IRI", true));
        put("Ice", new CoastalProvince("Iceland", "Ice", false));
        put("Ire", new CoastalProvince("Ireland", "Ire", false, countries.get("ENG")));
        put("Kie", new CoastalProvince("Kiel", "Kie", true, countries.get("GER"),
                new SupplyCenter(countries.get("GER"))));
        put("Lpl", new CoastalProvince("Liverpool", "Lpl", true, countries.get("ENG"),
                new SupplyCenter(countries.get("ENG"))));
        put("Lvn", new CoastalProvince("Livonia", "Lvn", true, countries.get("RUS")));
        put("Lon", new CoastalProvince("London", "Lon", true, countries.get("ENG"),
                new SupplyCenter(countries.get("ENG"))));
        put("Mar", new CoastalProvince("Marseilles", "Mar", true, countries.get("FRA"),
                new SupplyCenter(countries.get("FRA"))));
        put("MAO", new SeaProvince("Mid-Atlantic Ocean", "MAO", true));
        put("Mos", new LandlockedProvince("Moscow", "Mos", true, countries.get("RUS"),
                new SupplyCenter(countries.get("RUS"))));
        put("Mun", new LandlockedProvince("Munich", "Mun", true, countries.get("GER"),
                new SupplyCenter(countries.get("GER"))));
        put("Nap", new CoastalProvince("Naples", "Nap", true, countries.get("ITA"),
                new SupplyCenter(countries.get("ITA"))));
        put("NAO", new SeaProvince("North-Atlantic_Ocean", "NAO", true));
        put("NAf", new CoastalProvince("North Africa", "NAf", true));
        put("NTH", new SeaProvince("North Sea", "NTH", true));
        put("Nor", new CoastalProvince("Norway", "Nor", true,
                new SupplyCenter()));
        put("NWG", new SeaProvince("Norwegian Sea", "NWG", true));
        put("Par", new LandlockedProvince("Paris", "Par", true, countries.get("FRA"),
                new SupplyCenter(countries.get("FRA"))));
        put("Pic", new CoastalProvince("Picardy", "Pic", true, countries.get("FRA")));
        put("Pie", new CoastalProvince("Piedmont", "Pie", true, countries.get("ITA")));
        put("Por", new CoastalProvince("Portugal", "Por", true,
                new SupplyCenter()));
        put("Pru", new CoastalProvince("Prussia", "Pru", true, countries.get("GER")));
        put("Rom", new CoastalProvince("Rome", "Rom", true, countries.get("ITA"),
                new SupplyCenter(countries.get("ITA"))));
        put("Ruh", new LandlockedProvince("Ruhr", "Ruh", true, countries.get("GER")));
        put("Rum", new CoastalProvince("Rumania", "Rum", true,
                new SupplyCenter()));
        put("SKA", new SeaProvince("Skagerrak", "SKA", true));
        put("Sar", new CoastalProvince("Sardinia", "Sar", false, countries.get("ITA")));
        put("Ser", new LandlockedProvince("Serbia", "Ser", true,
                new SupplyCenter()));
        put("Sev", new CoastalProvince("Sevastopol", "Sev", true, countries.get("RUS"),
                new SupplyCenter(countries.get("RUS"))));
        put("Sic", new CoastalProvince("Sicily", "Sic", false, countries.get("ITA")));
        put("Sil", new LandlockedProvince("Silesia", "Sil", true, countries.get("GER")));
        put("Smy", new CoastalProvince("Smyrna", "Smy", true, countries.get("TUR"),
                new SupplyCenter(countries.get("TUR"))));
        put("Spa", new LandlockedProvince("Spain", "Spa", true,
                new SupplyCenter()));
        put("Spa_nc", new CoastalProvince("Spain North Coast", "Spa_nc", true,
                new SupplyCenter()));
        put("Spa_sc", new CoastalProvince("Spain South Coast", "Spa_sc", true,
                new SupplyCenter()));
        put("StP", new LandlockedProvince("St. Petersburg", "StP", true, countries.get("RUS"),
                new SupplyCenter(countries.get("RUS"))));
        put("StP_nc", new CoastalProvince("St. Petersburg North Coast", "StP_nc", true, countries.get("RUS"),
                new SupplyCenter(countries.get("RUS"))));
        put("StP_sc", new CoastalProvince("St. Petersburg South Coast", "StP_sc", true, countries.get("RUS"),
                new SupplyCenter(countries.get("RUS"))));
        put("Swe", new CoastalProvince("Sweden", "Swe", true,
                new SupplyCenter()));
        put("Swi", new LandlockedProvince("Switzerland", "Swi", false));
        put("Syr", new CoastalProvince("Syria", "Syr", true, countries.get("TUR")));
        put("Tri", new LandlockedProvince("Trieste", "Tri", true, countries.get("AUS"),
                new SupplyCenter(countries.get("AUS"))));
        put("Tun", new CoastalProvince("Tunis", "Tun", true,
                new SupplyCenter()));
        put("Tus", new CoastalProvince("Tuscany", "Tus", true, countries.get("ITA")));
        put("Tyr", new LandlockedProvince("Tyrolia", "Tyr", true, countries.get("AUS")));
        put("TYS", new SeaProvince("Tyrrhenian Sea", "TYS", true));
        put("Ukr", new LandlockedProvince("Ukraine", "Ukr", true, countries.get("RUS")));
        put("Ven", new CoastalProvince("Venice", "Ven", true, countries.get("ITA"),
                new SupplyCenter(countries.get("ITA"))));
        put("Vie", new LandlockedProvince("Vienna", "Vie", true, countries.get("AUS"),
                new SupplyCenter(countries.get("AUS"))));
        put("Wal", new CoastalProvince("Wales", "Wal", true, countries.get("ENG")));
        put("War", new LandlockedProvince("Warsaw", "War", true, countries.get("RUS"),
                new SupplyCenter(countries.get("RUS"))));
        put("WES", new SeaProvince("Western Mediterranean", "WES", true));
        put("Yor", new CoastalProvince("Yorkshire", "Yor", true, countries.get("ENG")));
    }};

    private final List<Unit> units = List.of(
            new Army(countries.get("AUS"), provinces.get("Bud")),
            new Navy(countries.get("AUS"), provinces.get("Tri")),
            new Army(countries.get("AUS"), provinces.get("Vie")),
            new Navy(countries.get("ENG"), provinces.get("Edi")),
            new Navy(countries.get("ENG"), provinces.get("Lon")),
            new Army(countries.get("ENG"), provinces.get("Lpl")),
            new Navy(countries.get("FRA"), provinces.get("Bre")),
            new Army(countries.get("FRA"), provinces.get("Mar")),
            new Army(countries.get("FRA"), provinces.get("Par")),
            new Army(countries.get("GER"), provinces.get("Ber")),
            new Navy(countries.get("GER"), provinces.get("Kie")),
            new Army(countries.get("GER"), provinces.get("Mun")),
            new Navy(countries.get("ITA"), provinces.get("Nap")),
            new Army(countries.get("ITA"), provinces.get("Rom")),
            new Army(countries.get("ITA"), provinces.get("Ven")),
            new Army(countries.get("RUS"), provinces.get("Mos")),
            new Navy(countries.get("RUS"), provinces.get("Sev")),
            new Navy(countries.get("RUS"), provinces.get("StP")),
            new Army(countries.get("RUS"), provinces.get("War")),
            new Navy(countries.get("TUR"), provinces.get("Ank")),
            new Army(countries.get("TUR"), provinces.get("Con")),
            new Army(countries.get("TUR"), provinces.get("Smy"))
    );

    private Map<String, Player> players;

    public Game() {
        List<String> tags = new ArrayList<>(countries.keySet());
        Collections.shuffle(tags);

        players = new HashMap<>();
        players.put(tags.get(0), new Player(true, countries.get(tags.get(0))));
        for (int i = 1; i < countries.size(); i++) {
            players.put(tags.get(i), new Player(false, countries.get(tags.get(i))));
        }

        for (Unit unit : units) {
            players.get(unit.getOwner().getTag()).addUnit(unit);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("PLAYERS + UNITS:\n");
        for (String tag : players.keySet()) {
            Player player = players.get(tag);
            builder.append(String.format("\t%s\n", player));
            for (Unit unit : player.listUnits()) {
                builder.append(String.format("\t\t%s\n", unit));
            }
        }

        builder.append("\n");

        builder.append("PROVINCES:\n");
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
