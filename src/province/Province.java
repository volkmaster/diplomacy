package province;

public class Province {
    protected String name;
    protected String tag;
    protected boolean passable;

    public Province(String name, String tag, boolean passable) {
        this.name = name;
        this.tag = tag;
        this.passable = passable;
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

    @Override
    public String toString() {
        return String.format("%-30s| %-12s| %-12s",
                name,
                tag,
                passable ? "yes" : "no"
        );
    }
}
