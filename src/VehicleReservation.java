import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class VehicleReservation extends Vehicle implements VehiclesArrays {

    Date startDate;
    Date endDate;
    Scanner scanner = new Scanner(System.in);
    private static final long MAX_RESERVATION_DAYS = 180;
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

    AracGirisi vehicleIO = new AracGirisi();


    public VehicleReservation() throws IOException, ParseException {

    }
    public Date[] SelectReservationStartAndEndDate(){

        Date currnetDate = new Date();

        System.out.print("Başlangıç tarihini (MM/dd/yyyy formatında) girin: ");
        String startDateString = scanner.nextLine();
        try {
            startDate = dateFormat.parse(startDateString);
        } catch (ParseException e) {

            System.out.println("Geçersiz tarih formatı. Başlangıç tarihi ayarlanamadı.");

        }
            if (startDate.before(currnetDate) || startDate.equals(currnetDate)) {
                System.out.println("Geçmiş tarihli rezervasyon yapılamaz");
                return null;
            }




        // Kullanıcıdan endDate'ı alma
        System.out.print("Bitiş tarihini (MM/dd/yyyy formatında) girin: ");
        String endDateString = scanner.nextLine();

        try {
            endDate = dateFormat.parse(endDateString);
        } catch (ParseException e) {
            System.out.println("Geçersiz tarih formatı. Bitiş tarihi ayarlanamadı.");
        }






        long differnce = startDate.getTime() - endDate.getTime();//Tarihler arasındaki fark
        long daysDifference = differnce / (1000* 60 * 60 * 24);// Milisaniyeyi güne çevir

        if (daysDifference > MAX_RESERVATION_DAYS){
            System.out.println("Rezervasyon tarihi çok ileri bir tarihte");
        }

        return new Date[]{startDate, endDate};

    }
    public void makeReservation(User driver,Vehicle vehicle,Date startDate,Date endDate){



        if (vehicle.getVehicleType().equals("sedan")){


            vehicle.setIsReserve("true");
            vehicle.setStartDate(startDate);
            vehicle.setEndDate(endDate);
           // vehicleIO.listVehiclesByType(vehicle.getVehicleType(),vehicle.getEndDate(),startDate);

        }
        else if (vehicle.getVehicleType().equals("suv")) {

            vehicle.setIsReserve("true");
            vehicle.setStartDate(startDate);
            vehicle.setEndDate(endDate);
            System.out.println("");


         // vehicleIO.listVehiclesByType(vehicle.getVehicleType(),vehicle.getEndDate(),startDate);
        }
        else if (vehicle.getVehicleType().equals("van")) {
            vehicle.setIsReserve("true");
            vehicle.setStartDate(startDate);
            vehicle.setEndDate(endDate);

           // vehicleIO.listVehiclesByType(vehicle.getVehicleType(),vehicle.getEndDate(),startDate);

        }
        else if (vehicle.getVehicleType().equals("scooter")) {
             vehicle.setIsReserve("true");
            vehicle.setStartDate(startDate);
            vehicle.setEndDate(endDate);
           // vehicleIO.listVehiclesByType(vehicle.getVehicleType(),vehicle.getEndDate(),startDate);

        }
        else if (vehicle.getVehicleType().equals("sportbike")) {
             vehicle.setIsReserve("true");
            vehicle.setStartDate(startDate);
            vehicle.setEndDate(endDate);
          //  vehicleIO.listVehiclesByType(vehicle.getVehicleType(),vehicle.getEndDate(),startDate);

        } else if (vehicle.getVehicleType().equals("atv")) {
            vehicle.setIsReserve("true");
            vehicle.setStartDate(startDate);
            vehicle.setEndDate(endDate);
          //  vehicleIO.listVehiclesByType(vehicle.getVehicleType(),vehicle.getEndDate(),startDate);

        }





    }



}
