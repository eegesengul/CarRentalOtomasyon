import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FaturaYazdir implements VehiclesArrays {

    private static int faturaSay = 0;

    public FaturaYazdir(KayitliKullanici musteri, Vehicle arac) throws IOException {

        faturaSay += 1;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Fatura" + faturaSay + ".txt"))) {

            writer.write("\t-Car Rental-\n\t");
            writer.write(musteri.firstName + " " + musteri.lastName + "\n\n");

            writer.write(arac.getBrand() + " " + arac.getModel() + " " + arac.getVehicleType() + " " + arac.getYear() + " Model Araç ....");


        }
    }
}