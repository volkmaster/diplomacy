package country;

public class Country {
    private String name;
    private String tag;
    private String color;

    public Country(String name, String tag, String color) {
        this.name = name;
        this.tag = tag;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("%s/%s", name, tag);
    }
}
