package common;

import country.Country;
import province.*;
import unit.Army;
import unit.Navy;
import unit.Unit;

import java.util.*;

public final class Constants {
    public static final Map<String, Country> INITIAL_COUNTRIES = new HashMap<String, Country>() {{
        put("AUS", new Country("Austria", "AUS", "#8B4513", "#D89260"));
        put("ENG", new Country("England", "ENG", "#F08080", "#A43434"));
        put("FRA", new Country("France", "FRA", "#00BFFF", "#005999"));
        put("GER", new Country("Germany", "GER", "#696969", "#CFCFCF"));
        put("ITA", new Country("Italy", "ITA", "#008000", "#004D00"));
        put("RUS", new Country("Russia", "RUS", "#BA55D3", "#6E0987"));
        put("TUR", new Country("Turkey", "TUR", "#E6E600", "#808000"));
    }};

    public static final Map<String, Province> INITIAL_PROVINCES = new HashMap<String, Province>() {{
        put("ADR", new SeaProvince("Adriatic Sea", "ADR", true));
        put("AEG", new SeaProvince("Aegean Sea", "AEG", true));
        put("Alb", new CoastalProvince("Albania", "Alb", true));
        put("Ank", new CoastalProvince("Ankara", "Ank", true, INITIAL_COUNTRIES.get("TUR"),
                new SupplyCenter(INITIAL_COUNTRIES.get("TUR"))));
        put("Apu", new CoastalProvince("Apulia", "Apu", true, INITIAL_COUNTRIES.get("ITA")));
        put("Arm", new CoastalProvince("Armenia", "Arm", true, INITIAL_COUNTRIES.get("TUR")));
        put("BAL", new SeaProvince("Baltic Sea", "BAL", true));
        put("BAR", new SeaProvince("Barents Sea", "BAR", true));
        put("BLA", new SeaProvince("Black Sea", "BLA", true));
        put("Bel", new CoastalProvince("Belgium", "Bel", true,
                new SupplyCenter()));
        put("Ber", new CoastalProvince("Berlin", "Ber", true, INITIAL_COUNTRIES.get("GER"),
                new SupplyCenter(INITIAL_COUNTRIES.get("GER"))));
        put("Blr", new CoastalProvince("Balearic Islands", "Blr", true));
        put("Boh", new LandlockedProvince("Bohemia", "Boh", true, INITIAL_COUNTRIES.get("AUS")));
        put("Bre", new CoastalProvince("Brest", "Bre", true, INITIAL_COUNTRIES.get("FRA"),
                new SupplyCenter(INITIAL_COUNTRIES.get("FRA"))));
        put("Bud", new LandlockedProvince("Budapest", "Bud", true, INITIAL_COUNTRIES.get("AUS"),
                new SupplyCenter(INITIAL_COUNTRIES.get("AUS"))));
        put("Bul", new LandlockedProvince("Bulgaria", "Bul", true,
                new SupplyCenter()));
        put("Bul_ec", new CoastalProvince("Bulgaria East Coast", "Bul_ec", true,
                new SupplyCenter()));
        put("Bul_sc", new CoastalProvince("Bulgaria South Coast", "Bul_sc", true,
                new SupplyCenter()));
        put("Bur", new LandlockedProvince("Burgundy", "Bur", true, INITIAL_COUNTRIES.get("FRA")));
        put("Cly", new CoastalProvince("Clyde", "Cly", true, INITIAL_COUNTRIES.get("ENG")));
        put("Con", new CoastalProvince("Constantinople", "Con", true, INITIAL_COUNTRIES.get("TUR"),
                new SupplyCenter(INITIAL_COUNTRIES.get("TUR"))));
        put("Cor", new CoastalProvince("Corsica", "Cor", false, INITIAL_COUNTRIES.get("FRA")));
        put("Cre", new CoastalProvince("Crete", "Cre", false));
        put("Den", new CoastalProvince("Denmark", "Den", true,
                new SupplyCenter()));
        put("EAS", new SeaProvince("Eastern Mediterranean", "EAS", true));
        put("ENG", new SeaProvince("English Channel", "ENG", true));
        put("Edi", new CoastalProvince("Edinburgh", "Edi", true, INITIAL_COUNTRIES.get("ENG"),
                new SupplyCenter(INITIAL_COUNTRIES.get("ENG"))));
        put("Fin", new CoastalProvince("Finland", "Fin", true, INITIAL_COUNTRIES.get("RUS")));
        put("Gal", new LandlockedProvince("Galicia", "Gal", true, INITIAL_COUNTRIES.get("AUS")));
        put("Gas", new CoastalProvince("Gascony", "Gas", true, INITIAL_COUNTRIES.get("FRA")));
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
        put("Ire", new CoastalProvince("Ireland", "Ire", false, INITIAL_COUNTRIES.get("ENG")));
        put("Kie", new CoastalProvince("Kiel", "Kie", true, INITIAL_COUNTRIES.get("GER"),
                new SupplyCenter(INITIAL_COUNTRIES.get("GER"))));
        put("Lon", new CoastalProvince("London", "Lon", true, INITIAL_COUNTRIES.get("ENG"),
                new SupplyCenter(INITIAL_COUNTRIES.get("ENG"))));
        put("Lpl", new CoastalProvince("Liverpool", "Lpl", true, INITIAL_COUNTRIES.get("ENG"),
                new SupplyCenter(INITIAL_COUNTRIES.get("ENG"))));
        put("Lvn", new CoastalProvince("Livonia", "Lvn", true, INITIAL_COUNTRIES.get("RUS")));
        put("MAO", new SeaProvince("Mid-Atlantic Ocean", "MAO", true));
        put("Mar", new CoastalProvince("Marseilles", "Mar", true, INITIAL_COUNTRIES.get("FRA"),
                new SupplyCenter(INITIAL_COUNTRIES.get("FRA"))));
        put("Mos", new LandlockedProvince("Moscow", "Mos", true, INITIAL_COUNTRIES.get("RUS"),
                new SupplyCenter(INITIAL_COUNTRIES.get("RUS"))));
        put("Mun", new LandlockedProvince("Munich", "Mun", true, INITIAL_COUNTRIES.get("GER"),
                new SupplyCenter(INITIAL_COUNTRIES.get("GER"))));
        put("NAO", new SeaProvince("North Atlantic Ocean", "NAO", true));
        put("NAf", new CoastalProvince("North Africa", "NAf", true));
        put("NTH", new SeaProvince("North Sea", "NTH", true));
        put("NWG", new SeaProvince("Norwegian Sea", "NWG", true));
        put("Nap", new CoastalProvince("Naples", "Nap", true, INITIAL_COUNTRIES.get("ITA"),
                new SupplyCenter(INITIAL_COUNTRIES.get("ITA"))));
        put("Nwy", new CoastalProvince("Norway", "Nwy", true,
                new SupplyCenter()));
        put("ORE", new SeaProvince("Oresund", "ORE", false));
        put("Par", new LandlockedProvince("Paris", "Par", true, INITIAL_COUNTRIES.get("FRA"),
                new SupplyCenter(INITIAL_COUNTRIES.get("FRA"))));
        put("Pic", new CoastalProvince("Picardy", "Pic", true, INITIAL_COUNTRIES.get("FRA")));
        put("Pie", new CoastalProvince("Piedmont", "Pie", true, INITIAL_COUNTRIES.get("ITA")));
        put("Por", new CoastalProvince("Portugal", "Por", true,
                new SupplyCenter()));
        put("Pru", new CoastalProvince("Prussia", "Pru", true, INITIAL_COUNTRIES.get("GER")));
        put("Rom", new CoastalProvince("Rome", "Rom", true, INITIAL_COUNTRIES.get("ITA"),
                new SupplyCenter(INITIAL_COUNTRIES.get("ITA"))));
        put("Ruh", new LandlockedProvince("Ruhr", "Ruh", true, INITIAL_COUNTRIES.get("GER")));
        put("Rum", new CoastalProvince("Rumania", "Rum", true,
                new SupplyCenter()));
        put("SKA", new SeaProvince("Skagerrak", "SKA", true));
        put("Sar", new CoastalProvince("Sardinia", "Sar", false, INITIAL_COUNTRIES.get("ITA")));
        put("Ser", new LandlockedProvince("Serbia", "Ser", true,
                new SupplyCenter()));
        put("Sev", new CoastalProvince("Sevastopol", "Sev", true, INITIAL_COUNTRIES.get("RUS"),
                new SupplyCenter(INITIAL_COUNTRIES.get("RUS"))));
        put("Sic", new CoastalProvince("Sicily", "Sic", false, INITIAL_COUNTRIES.get("ITA")));
        put("Sil", new LandlockedProvince("Silesia", "Sil", true, INITIAL_COUNTRIES.get("GER")));
        put("Smy", new CoastalProvince("Smyrna", "Smy", true, INITIAL_COUNTRIES.get("TUR"),
                new SupplyCenter(INITIAL_COUNTRIES.get("TUR"))));
        put("SoM", new SeaProvince("Sea of Marmara", "SoM", false));
        put("Spa", new LandlockedProvince("Spain", "Spa", true,
                new SupplyCenter()));
        put("Spa_nc", new CoastalProvince("Spain North Coast", "Spa_nc", true,
                new SupplyCenter()));
        put("Spa_sc", new CoastalProvince("Spain South Coast", "Spa_sc", true,
                new SupplyCenter()));
        put("StP", new LandlockedProvince("St. Petersburg", "StP", true, INITIAL_COUNTRIES.get("RUS"),
                new SupplyCenter(INITIAL_COUNTRIES.get("RUS"))));
        put("StP_nc", new CoastalProvince("St. Petersburg North Coast", "StP_nc", true, INITIAL_COUNTRIES.get("RUS"),
                new SupplyCenter(INITIAL_COUNTRIES.get("RUS"))));
        put("StP_sc", new CoastalProvince("St. Petersburg South Coast", "StP_sc", true, INITIAL_COUNTRIES.get("RUS"),
                new SupplyCenter(INITIAL_COUNTRIES.get("RUS"))));
        put("Swe", new CoastalProvince("Sweden", "Swe", true,
                new SupplyCenter()));
        put("Swi", new LandlockedProvince("Switzerland", "Swi", false));
        put("Syr", new CoastalProvince("Syria", "Syr", true, INITIAL_COUNTRIES.get("TUR")));
        put("TYS", new SeaProvince("Tyrrhenian Sea", "TYS", true));
        put("Tri", new LandlockedProvince("Trieste", "Tri", true, INITIAL_COUNTRIES.get("AUS"),
                new SupplyCenter(INITIAL_COUNTRIES.get("AUS"))));
        put("Tun", new CoastalProvince("Tunis", "Tun", true,
                new SupplyCenter()));
        put("Tus", new CoastalProvince("Tuscany", "Tus", true, INITIAL_COUNTRIES.get("ITA")));
        put("Tyr", new LandlockedProvince("Tyrolia", "Tyr", true, INITIAL_COUNTRIES.get("AUS")));
        put("Ukr", new LandlockedProvince("Ukraine", "Ukr", true, INITIAL_COUNTRIES.get("RUS")));
        put("Ven", new CoastalProvince("Venice", "Ven", true, INITIAL_COUNTRIES.get("ITA"),
                new SupplyCenter(INITIAL_COUNTRIES.get("ITA"))));
        put("Vie", new LandlockedProvince("Vienna", "Vie", true, INITIAL_COUNTRIES.get("AUS"),
                new SupplyCenter(INITIAL_COUNTRIES.get("AUS"))));
        put("WES", new SeaProvince("Western Mediterranean", "WES", true));
        put("Wal", new CoastalProvince("Wales", "Wal", true, INITIAL_COUNTRIES.get("ENG")));
        put("War", new LandlockedProvince("Warsaw", "War", true, INITIAL_COUNTRIES.get("RUS"),
                new SupplyCenter(INITIAL_COUNTRIES.get("RUS"))));
        put("Yor", new CoastalProvince("Yorkshire", "Yor", true, INITIAL_COUNTRIES.get("ENG")));
    }};

    public static final Map<String, List<String>> SPECIAL_PROVINCES = new HashMap<String, List<String>>() {{
        put("Bul", Arrays.asList("Bul", "Bul_ec", "Bul_sc"));
        put("Bul_ec", Arrays.asList("Bul", "Bul_ec", "Bul_sc"));
        put("Bul_sc", Arrays.asList("Bul", "Bul_ec", "Bul_sc"));
        put("Spa", Arrays.asList("Spa", "Spa_nc", "Spa_sc"));
        put("Spa_nc", Arrays.asList("Spa", "Spa_nc", "Spa_sc"));
        put("Spa_sc", Arrays.asList("Spa", "Spa_nc", "Spa_sc"));
        put("StP", Arrays.asList("StP", "StP_nc", "StP_sc"));
        put("StP_nc", Arrays.asList("StP", "StP_nc", "StP_sc"));
        put("StP_sc", Arrays.asList("StP", "StP_nc", "StP_sc"));
    }};

    public static final List<Unit> INITIAL_UNITS = Arrays.asList(
        new Army(INITIAL_COUNTRIES.get("AUS"), INITIAL_PROVINCES.get("Bud")),
        new Navy(INITIAL_COUNTRIES.get("AUS"), INITIAL_PROVINCES.get("Tri")),
        new Army(INITIAL_COUNTRIES.get("AUS"), INITIAL_PROVINCES.get("Vie")),
        new Navy(INITIAL_COUNTRIES.get("ENG"), INITIAL_PROVINCES.get("Edi")),
        new Navy(INITIAL_COUNTRIES.get("ENG"), INITIAL_PROVINCES.get("Lon")),
        new Army(INITIAL_COUNTRIES.get("ENG"), INITIAL_PROVINCES.get("Lpl")),
        new Navy(INITIAL_COUNTRIES.get("FRA"), INITIAL_PROVINCES.get("Bre")),
        new Army(INITIAL_COUNTRIES.get("FRA"), INITIAL_PROVINCES.get("Mar")),
        new Army(INITIAL_COUNTRIES.get("FRA"), INITIAL_PROVINCES.get("Par")),
        new Army(INITIAL_COUNTRIES.get("GER"), INITIAL_PROVINCES.get("Ber")),
        new Navy(INITIAL_COUNTRIES.get("GER"), INITIAL_PROVINCES.get("Kie")),
        new Army(INITIAL_COUNTRIES.get("GER"), INITIAL_PROVINCES.get("Mun")),
        new Navy(INITIAL_COUNTRIES.get("ITA"), INITIAL_PROVINCES.get("Nap")),
        new Army(INITIAL_COUNTRIES.get("ITA"), INITIAL_PROVINCES.get("Rom")),
        new Army(INITIAL_COUNTRIES.get("ITA"), INITIAL_PROVINCES.get("Ven")),
        new Army(INITIAL_COUNTRIES.get("RUS"), INITIAL_PROVINCES.get("Mos")),
        new Navy(INITIAL_COUNTRIES.get("RUS"), INITIAL_PROVINCES.get("Sev")),
        new Navy(INITIAL_COUNTRIES.get("RUS"), INITIAL_PROVINCES.get("StP_sc")),
        new Army(INITIAL_COUNTRIES.get("RUS"), INITIAL_PROVINCES.get("War")),
        new Navy(INITIAL_COUNTRIES.get("TUR"), INITIAL_PROVINCES.get("Ank")),
        new Army(INITIAL_COUNTRIES.get("TUR"), INITIAL_PROVINCES.get("Con")),
        new Army(INITIAL_COUNTRIES.get("TUR"), INITIAL_PROVINCES.get("Smy"))
    );

    public static final Map<String, List<String>> ARMY_MOVES = new HashMap<String, List<String>>() {{
        put("Alb", Arrays.asList("Gre", "Ser", "Tri"));
        put("Ank", Arrays.asList("Arm", "Con", "Smy", "Syr"));
        put("Apu", Arrays.asList("Nap", "Rom", "Ven"));
        put("Arm", Arrays.asList("Ank", "Sev", "Smy", "Syr"));
        put("Bel", Arrays.asList("Bur", "Hol", "Pic", "Ruh"));
        put("Ber", Arrays.asList("Kie", "Mun", "Pru", "Sil"));
        put("Boh", Arrays.asList("Gal", "Mun", "Sil", "Tyr", "Vie"));
        put("Bre", Arrays.asList("Gas", "Par", "Pic"));
        put("Bud", Arrays.asList("Gal", "Rum", "Ser", "Tri", "Vie"));
        put("Bul", Arrays.asList("Con", "Gre", "Rum", "Ser"));
        put("Bur", Arrays.asList("Bel", "Gas", "Mar", "Mun", "Par", "Pic"));
        put("Cly", Arrays.asList("Edi", "Lpl"));
        put("Con", Arrays.asList("AEG", "Ank", "Bul", "Smy"));
        put("Den", Arrays.asList("Kie", "Swe"));
        put("Edi", Arrays.asList("Cly", "Lpl", "Yor"));
        put("Fin", Arrays.asList("StP", "Swe"));
        put("Gal", Arrays.asList("Boh", "Bud", "Rum", "Sil", "Ukr", "Vie", "War"));
        put("Gas", Arrays.asList("Bre", "Bur", "Mar", "Par", "Spa"));
        put("Gre", Arrays.asList("Alb", "Bul", "Ser"));
        put("Hol", Arrays.asList("Bel", "Kie", "Ruh"));
        put("Kie", Arrays.asList("Ber", "Den", "Hol", "Mun", "Ruh"));
        put("Lon", Arrays.asList("Wal", "Yor"));
        put("Lpl", Arrays.asList("Cly", "Edi", "Wal", "Yor"));
        put("Lvn", Arrays.asList("Mos", "Pru", "StP", "War"));
        put("Mar", Arrays.asList("Bur", "Gas", "Pie", "Spa"));
        put("Mos", Arrays.asList("Lvn", "Sev", "StP", "Ukr", "War"));
        put("Mun", Arrays.asList("Ber", "Boh", "Bur", "Kie", "Ruh", "Sil", "Tyr"));
        put("NAf", Arrays.asList("Tun"));
        put("Nap", Arrays.asList("Apu", "Rom"));
        put("Nwy", Arrays.asList("Fin", "StP", "Swe"));
        put("Par", Arrays.asList("Bre", "Bur", "Gas", "Pic"));
        put("Pic", Arrays.asList("Bel", "Bre", "Bur", "Par"));
        put("Pie", Arrays.asList("Mar", "Tus", "Ven"));
        put("Por", Arrays.asList("Spa"));
        put("Pru", Arrays.asList("Ber", "Lvn", "Sil", "War"));
        put("Rom", Arrays.asList("Apu", "Nap", "Tus", "Ven"));
        put("Ruh", Arrays.asList("Bel", "Bur", "Hol", "Kie", "Mun"));
        put("Rum", Arrays.asList("Bud", "Bul", "Gal", "Ser", "Sev", "Ukr"));
        put("Ser", Arrays.asList("Alb", "Bud", "Bul", "Gre", "Rum", "Tri"));
        put("Sev", Arrays.asList("Arm", "Mos", "Rum", "Ukr"));
        put("Sil", Arrays.asList("Ber", "Boh", "Gal", "Mun", "Pru", "War"));
        put("Smy", Arrays.asList("Ank", "Arm", "Con", "Syr"));
        put("Spa", Arrays.asList("Gas", "Mar", "Por"));
        put("StP", Arrays.asList("Fin", "Lvn", "Mos", "Nwy"));
        put("Swe", Arrays.asList("Den", "Fin", "Nwy"));
        put("Syr", Arrays.asList("Arm", "Smy"));
        put("Tri", Arrays.asList("Alb", "Bud", "Ser", "Tyr", "Ven", "Vie"));
        put("Tun", Arrays.asList("NAf"));
        put("Tus", Arrays.asList("Pie", "Rom", "Ven"));
        put("Tyr", Arrays.asList("Boh", "Mun", "Tri", "Ven", "Vie"));
        put("Ukr", Arrays.asList("Gal", "Mos", "Rum", "Sev", "War"));
        put("Ven", Arrays.asList("Apu", "Pie", "Rom", "Tri", "Tus", "Tyr"));
        put("Vie", Arrays.asList("Bud", "Boh", "Gal", "Tri", "Tyr"));
        put("Wal", Arrays.asList("Lon", "Lpl", "Yor"));
        put("War", Arrays.asList("Gal", "Lvn", "Mos", "Pru", "Sil", "Ukr"));
        put("Yor", Arrays.asList("Edi", "Lon", "Lpl", "Wal"));
    }};

    public static final Map<String, List<String>> NAVY_MOVES = new HashMap<String, List<String>>() {{
        put("ADR", Arrays.asList("Alb", "Apu", "ION", "Tri", "Ven"));
        put("AEG", Arrays.asList("Bul_sc", "Con", "EAS", "Gre", "ION", "Smy"));
        put("Alb", Arrays.asList("ADR", "Gre", "ION", "Tri"));
        put("Ank", Arrays.asList("Arm", "BLA", "Con"));
        put("Apu", Arrays.asList("ADR", "ION", "Nap", "Ven"));
        put("Arm", Arrays.asList("Ank", "BLA", "Sev", "Syr"));
        put("BAL", Arrays.asList("Ber", "Den", "GoB", "Kie", "Lvn", "Pru", "Swe"));
        put("BAR", Arrays.asList("NWG", "Nwy", "StP_nc"));
        put("BLA", Arrays.asList("Ank", "Arm", "Bul_ec", "Con", "Rum", "Sev"));
        put("Bel", Arrays.asList("ENG", "Hol", "NTH", "Pic"));
        put("Ber", Arrays.asList("BAL", "Kie", "Pru"));
        put("Bre", Arrays.asList("ENG", "Gas", "MAO", "Pic"));
        put("Bul_ec", Arrays.asList("BLA", "Con", "Rum"));
        put("Bul_sc", Arrays.asList("AEG", "Con", "Gre"));
        put("Cly", Arrays.asList("Edi", "Lpl", "NAO", "NWG"));
        put("Con", Arrays.asList("AEG", "BLA", "Ank", "BLA", "Bul_ec", "Bul_sc", "Smy"));
        put("Den", Arrays.asList("BAL", "HEL", "Kie", "NTH", "SKA", "Swe"));
        put("EAS", Arrays.asList("AEG", "ION", "Smy", "Syr"));
        put("ENG", Arrays.asList("Bel", "Bre", "IRI", "Lon", "MAO", "NTH", "Pic", "Wal"));
        put("Edi", Arrays.asList("Cly", "NTH", "NWG", "Yor"));
        put("Fin", Arrays.asList("GoB", "Nwy", "StP_sc", "Swe"));
        put("Gas", Arrays.asList("Bre", "MAO", "Spa_nc"));
        put("GoB", Arrays.asList("Fin", "Lvn", "Swe", "StP_sc"));
        put("GoL", Arrays.asList("Mar", "Pie", "Spa_sc", "Tus", "TYS", "WES"));
        put("Gre", Arrays.asList("AEG", "Alb", "Bul_sc", "ION"));
        put("HEL", Arrays.asList("Den", "Hol", "Kie", "NTH"));
        put("Hol", Arrays.asList("Bel", "Hel", "Kie", "NTH"));
        put("ION", Arrays.asList("ADR", "AEG", "Alb", "Apu", "EAS", "Gre", "Nap", "Tun", "TYS"));
        put("IRI", Arrays.asList("ENG", "Lpl", "MAO", "NAO", "Wal"));
        put("Kie", Arrays.asList("BAL", "Ber", "Den", "HEL", "Hol"));
        put("Lon", Arrays.asList("ENG", "NTH", "Wal", "Yor"));
        put("Lpl", Arrays.asList("Cly", "IRI", "NAO", "Wal"));
        put("Lvn", Arrays.asList("BAL", "GoB", "Pru", "StP_sc"));
        put("MAO", Arrays.asList("Bre", "ENG", "Gas", "IRI", "NAO", "Por", "Spa_nc", "Spa_sc", "WES"));
        put("Mar", Arrays.asList("GoL", "Pie", "Spa_sc"));
        put("NAO", Arrays.asList("Cly", "IRI", "Lpl", "MAO", "NWG"));
        put("NAf", Arrays.asList("MAO", "Tun", "WES"));
        put("NTH", Arrays.asList("Bel", "Den", "Edi", "ENG", "HEL", "Hol", "Lon", "NWG", "Nwy", "SKA", "Yor"));
        put("NWG", Arrays.asList("BAR", "Edi", "NAO", "Nwy"));
        put("Nap", Arrays.asList("Apu", "ION", "Rom", "TYS"));
        put("Nwy", Arrays.asList("BAR", "Fin", "NTH", "NWG", "SKA", "StP_nc", "Swe"));
        put("Pic", Arrays.asList("Bel", "Bre", "ENG"));
        put("Pie", Arrays.asList("GoL", "Mar", "Tus"));
        put("Por", Arrays.asList("MAO", "Spa_nc", "Spa_sc"));
        put("Pru", Arrays.asList("BAL", "Ber", "Lvn"));
        put("Rom", Arrays.asList("Nap", "Tus", "TYS"));
        put("Rum", Arrays.asList("BLA", "Bul_ec", "Sev"));
        put("SKA", Arrays.asList("Den", "NTH", "Nwy", "Swe"));
        put("Sev", Arrays.asList("Arm", "BLA", "Rum"));
        put("Smy", Arrays.asList("AEG", "Con", "EAS", "Syr"));
        put("Spa_nc", Arrays.asList("Gas", "MAO", "Por"));
        put("Spa_sc", Arrays.asList("GoL", "MAO", "Mar", "Por", "WES"));
        put("StP_nc", Arrays.asList("BAR", "Nwy"));
        put("StP_sc", Arrays.asList("Fin", "GoB", "Lvn"));
        put("Swe", Arrays.asList("BAL", "Den", "Fin", "GoB", "Nwy", "SKA"));
        put("Syr", Arrays.asList("EAS", "Smy"));
        put("TYS", Arrays.asList("GoL", "ION", "Nap", "Rom", "Tun", "Tus", "WES"));
        put("Tri", Arrays.asList("ADR", "Alb", "Ven"));
        put("Tun", Arrays.asList("ION", "NAf", "TYS", "WES"));
        put("Tus", Arrays.asList("GoL", "Pie", "Rom", "TYS"));
        put("Ven", Arrays.asList("ADR", "Apu", "Tri"));
        put("WES", Arrays.asList("GoL", "NAf", "Spa_sc", "Tun", "TYS"));
        put("Wal", Arrays.asList("ENG", "IRI", "Lon", "Lpl"));
        put("Yor", Arrays.asList("Edi", "Lon", "NTH"));
    }};

    private Constants() { }
}
