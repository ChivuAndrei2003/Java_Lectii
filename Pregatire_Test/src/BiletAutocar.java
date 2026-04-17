import java.util.ArrayList;
import java.util.List;

public class BiletAutocar extends BiletAbstract {
    private static final List<BiletAutocar> BILETE_EMISE = new ArrayList<>();

    private final TipReducere tipReducere;
    private String[] statii;

    public BiletAutocar(String plecare, String sosire, int distanta, TipReducere tipReducere) {
        super(plecare, sosire, distanta);
        this.tipReducere = tipReducere;
    }

    public TipReducere getTipReducere() {
        return tipReducere;
    }

    public String[] getStatii() {
        return statii == null ? null : statii.clone();
    }

    public void setStatii(String[] statii) {
        this.statii = statii == null ? null : statii.clone();
    }

    @Override
    public float getReducere() {
        if (tipReducere == TipReducere.STUDENT) {
            return 0.5f;
        }
        if (tipReducere == TipReducere.PENSIONAR) {
            return 0.9f;
        }
        return 0.0f;
    }

    @Override
    public float getPret() {
        return super.getPret() * getDistanta() * (1 - getReducere());
    }

    @Override
    public BiletAutocar clone() throws CloneNotSupportedException {
        BiletAutocar copie = (BiletAutocar) super.clone();
        copie.statii = statii == null ? null : statii.clone();
        return copie;
    }

    @Override
    public String toString() {
        return "-- " + getPlecare() + " " + getSosire() + " " + getDistanta() + " --";
    }

    public static void emiteBilet(BiletAutocar bilet) {
        BILETE_EMISE.add(bilet);
    }

    public static List<BiletAutocar> bileteEmise() {
        return new ArrayList<>(BILETE_EMISE);
    }
}
