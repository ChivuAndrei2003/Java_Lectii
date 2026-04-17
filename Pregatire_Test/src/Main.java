import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException, java.io.IOException {
        BiletAutocar b1 = new BiletAutocar("Bucuresti", "Brasov", 180, TipReducere.STUDENT);
        BiletAutocar b2 = new BiletAutocar("Cluj", "Oradea", 150, TipReducere.PENSIONAR);
        BiletAutocar b3 = new BiletAutocar("Iasi", "Bacau", 120, TipReducere.STUDENT);

        b1.setStatii(new String[]{"Ploiesti", "Sinaia"});
        b2.setStatii(new String[]{"Huedin"});
        b3.setStatii(new String[]{"Roman"});

        System.out.println("Statii b1: " + Arrays.toString(b1.getStatii()));
        System.out.println("Tip reducere b1: " + b1.getTipReducere());

        System.out.println("Reducere b1: " + b1.getReducere());
        System.out.println("Pret b1: " + b1.getPret());

        System.out.println(b1);

        BiletAutocar copie = b1.clone();
        String[] statiiCopie = copie.getStatii();
        statiiCopie[0] = "MODIFICAT";
        copie.setStatii(statiiCopie);
        System.out.println("Original statii: " + Arrays.toString(b1.getStatii()));
        System.out.println("Copie statii: " + Arrays.toString(copie.getStatii()));

        BiletAutocar.emiteBilet(b1);
        BiletAutocar.emiteBilet(b2);
        BiletAutocar.emiteBilet(b3);

        List<BiletAutocar> emise = BiletAutocar.bileteEmise();
        System.out.println("Bilete emise: " + emise.size());
        emise.forEach(System.out::println);

        Stream<BiletAutocar> filtrate = Utils.filtreazaBileteStudent(emise, 170);
        System.out.println("Filtrate:");
        filtrate.forEach(System.out::println);

        Utils.salveazBiletInFisierText(b1);
        System.out.println("Biletul b1 a fost salvat in fisier.");
    }
}
