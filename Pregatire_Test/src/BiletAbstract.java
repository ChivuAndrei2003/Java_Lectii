public abstract class BiletAbstract implements Cumparabil, Cloneable {
    private final String plecare;
    private final String sosire;
    private final int distanta;

    public BiletAbstract(String plecare, String sosire, int distanta) {
        this.plecare = plecare;
        this.sosire = sosire;
        this.distanta = distanta;
    }

    public String getPlecare() {
        return plecare;
    }

    public String getSosire() {
        return sosire;
    }

    public int getDistanta() {
        return distanta;
    }

    @Override
    public float getPret() {
        return 3.0f;
    }

    public abstract float getReducere();
}
