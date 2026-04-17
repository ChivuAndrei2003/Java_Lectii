import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Utils {

    public static Stream<BiletAutocar> filtreazaBileteStudent(List<BiletAutocar> bilete, float valoare) {
        return bilete.stream()
                .filter(b -> b.getTipReducere() == TipReducere.STUDENT)
                .filter(b -> b.getDistanta() < valoare);
    }

    public static void salveazBiletInFisierText(BiletAutocar bilet) throws IOException {
        try (FileWriter writer = new FileWriter("bilet.txt")) {
            writer.write("Plecare: " + bilet.getPlecare() + System.lineSeparator());
            writer.write("Sosire: " + bilet.getSosire() + System.lineSeparator());
            writer.write("Distanta: " + bilet.getDistanta() + System.lineSeparator());
            writer.write("Tip reducere: " + bilet.getTipReducere() + System.lineSeparator());
            writer.write("Statii: " + Arrays.toString(bilet.getStatii()) + System.lineSeparator());
            writer.write("Reducere: " + bilet.getReducere() + System.lineSeparator());
            writer.write("Pret: " + bilet.getPret() + System.lineSeparator());
        }
    }
}
