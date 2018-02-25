package province;

public class SeaProvince extends Province {
    public static final String TYPE = "sea";

    public SeaProvince(String name, String tag, boolean passable) {
        super(name, tag, passable);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("| %-15s| %-25s| %-25s| %-12s",
                "",
                "",
                "",
                TYPE
        );
    }
}
