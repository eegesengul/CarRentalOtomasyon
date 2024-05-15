import java.io.*;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;



public class AracGirisi implements VehiclesArrays{
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");


    String dateStr = "01/01/1970";
    Date vehicleDefaultDate;

    {
        try {
            vehicleDefaultDate = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    Scanner klavye = new Scanner(System.in);



    public void setPlate(Vehicle vehicle){

        String plateNumber = enterPlate();
        vehicle.setVehiclePlate(plateNumber);
    }
    public String enterPlate(){
        Scanner scanner = new Scanner(System.in);
        String plateNumber;
        do{
            System.out.print("Lütfen Aracın Plakasını girin Örneğin(34PLT34): ");
            plateNumber = scanner.nextLine().trim().toUpperCase();//trim ile basdaki sondaki boşukları silip uppercase ile büyük harfe dönüştürdük
            if (!isPlateNumberRight(plateNumber)){
                System.out.print("Hatalı plaka düzeni lütfen tekrar girin");
            }

        } while(!isPlateNumberRight(plateNumber));

        return plateNumber;
    }
    public static boolean isPlateNumberRight(String plateNumber){
        //plaka uzunluğu kontorlü
        if(plateNumber.length() < 5 || plateNumber.length() > 8){
            return false;
        }
        //Character.isDigit() fonksiyonu karakterin rakam olup olmmadığını kontrol eder. sayısal ise true döner değilse false
        if(!Character.isDigit(plateNumber.charAt(0)) ||!Character.isDigit(plateNumber.charAt(0))){
            return false;
        }
        if(!Character.isDigit(plateNumber.charAt(plateNumber.length() - 2)) || !Character.isDigit(plateNumber.charAt(plateNumber.length() - 1))){

            return false;
        }
        // Orta kısımda harf olup olmadığının kontrol edilmesii. Character.isLetter da Character.isDigit gibi çalışır
        for (int i = 2; i < plateNumber.length() - 2; i++) {
            if (!Character.isLetter(plateNumber.charAt(i))) {
                return false;
            }
        }

        return true;

    }


   /*  GUNCELEMELER

   4.01.2024 20:00
   Arraylistler VehiclesArarys Interface'ine taşındı artık araclara her sınıftan erişebileceğiz.
   Sınıf adı arac ismeleri olarak degistirildi

    ArrayList<Sedan> sedanList = new ArrayList<>();
    ArrayList<Suv> suvList = new ArrayList<>();
    ArrayList<Van> vanList = new ArrayList<>();
    ArrayList<Scooter> scooterList = new ArrayList<>();
    ArrayList<Sportbike> sportbikeList = new ArrayList<>();
    ArrayList<Atv> atvList = new ArrayList<>();

    */


    public void returnVehicle(String vehicleType){

     Vehicle vehicle = vehicleSelect(vehicleType,"true");
     vehicle.setIsReserve("false");
     System.out.println("Aracın yeni KM değerini girin ");
     vehicle.setKm(klavye.nextInt());



    }
    public Vehicle vehicleSelect(String vehicleType,String reserveStatue){


        listVehiclesByType(vehicleType,reserveStatue);



        System.out.println("Arac seciniz ");
        int selectedCar = klavye.nextInt();

        selectedCar-=1;

        if (vehicleType.equals("sedan")){

           return sedanList.get(selectedCar);

        }
        else if (vehicleType.equals("suv")) {

            return suvList.get(selectedCar);

        }
        else if (vehicleType.equals("van")) {

            return vanList.get(selectedCar);


        }
        else if (vehicleType.equals("scooter")) {

            return scooterList.get(selectedCar);


        }
        else if (vehicleType.equals("sportbike")) {

            return sportbikeList.get(selectedCar);


        } else if (vehicleType.equals("atv")) {

            return atvList.get(selectedCar);


        }

        return null;



    }

    public void listVehiclesByType(String type){
        int counter = 1;
        switch (type.toLowerCase()) {
            case "sedan":
                System.out.println("Sedan Araclar");
                for (Sedan sedan : sedanList){
                    System.out.println(counter+"."+sedan.getBrand()+" "+sedan.getModel()+" "+
                            sedan.getColor()+" "+sedan.getKm()+" KM"+" "+sedan.getYear());
                    counter++;
                }
                counter = 0;
                break;
            case "suv":
                System.out.println("Suv Araclar");
                for(Suv suv : suvList){
                    System.out.println(counter+"."+suv.getBrand()+" "+suv.getModel()+" "+suv.getCekis()+" "+
                            suv.getColor()+" "+suv.getKm()+"KM "+suv.getYear()+"Model");
                }
                counter = 0;
                break;
            case "van":
                System.out.println("Van Aracla");
                for(Van van : vanList){

                    System.out.println(counter+"."+van.getBrand()+" "+van.getModel()+" "+van.getColor()+" "+van.getKm()+"KM "+van.getYear()+"Model "+
                            van.getSuKapasitesi()+"LİTRE SU KAPASİTESİ, "+van.getBuzdolabiKapasitesi()+
                            " ADET BUZDOLABI SAYISI, "+van.getYatakSay()+"ADET YATAK SAYİSİ, "+van.getOcakSay()+"ADET OCAK SAYİSİ");
                    counter++;
                }
                counter = 0;
                break;
            case "scooter":
                System.out.println("Scooter Araclar");
                for(Scooter sc : scooterList){
                    System.out.println(counter+"."+sc.getBrand()+" "+sc.getModel()+" "+sc.getColor()+" "+sc.getKm()+" KM "+sc.getYear()+
                            " Model"+sc.getSepetKapasitesi()+" Sepet kapasitesi");
                    counter++;
                }
                counter = 0;
                break;
            case "sporbike":
                System.out.println("Sportbike Araclar");
                for(Sportbike sp : sportbikeList){
                    System.out.println(counter+"."+sp.getBrand()+" "+sp.getModel()+
                            " "+sp.getColor()+" "+sp.getKm()+" KM "+sp.getYear()+" Model "+sp.getMaksHiz()+"KM/S MAKS HİZ");
                    counter++;
                }
            case "atv":
                System.out.println("Atv Araclar");
                for(Atv atv : atvList){
                    System.out.println(counter+"."+atv.getBrand()+" "+atv.getModel()+" "+atv.getColor()+" "+atv.getKm()+" KM "+atv.getYear()+" Model");
                    counter++;
                }
                counter = 0;

                break;
            default:System.out.println("EROR"); break;

        }
    }
    public void listVehiclesByType(String type,String isReserved){

        int counter = 1;
        switch (type.toLowerCase()) {
            case "sedan":
                System.out.println("Sedan Araclar");
                for (Sedan sedan : sedanList){
                    if(sedan.getIsReserve().equals(isReserved)) {
                        System.out.println(counter + "." + sedan.getBrand() + " " + sedan.getModel() + " " +
                                sedan.getColor() + " " + sedan.getKm() + " KM" + " " + sedan.getYear());

                    }
                    counter++;
                }
                counter = 0;
                break;
            case "suv":
                System.out.println("Suv Araclar");
                for(Suv suv : suvList){
                    if(suv.getIsReserve().equals(isReserved)) {
                        System.out.println(counter + "." + suv.getBrand() + " " + suv.getModel() + " " + suv.getCekis() + " " +
                                suv.getColor() + " " + suv.getKm() + "KM " + suv.getYear() + "Model");

                    }
                    counter++;
                }
                counter = 0;
                break;
            case "van":
                System.out.println("Van Aracla");
                for(Van van : vanList){
                    if(van.getIsReserve().equals(isReserved)) {
                        System.out.println(counter + "." + van.getBrand() + " " + van.getModel() + " " + van.getColor() + " " + van.getKm() + "KM " + van.getYear() + "Model " +
                                van.getSuKapasitesi() + "LİTRE SU KAPASİTESİ, " + van.getBuzdolabiKapasitesi() +
                                " ADET BUZDOLABI SAYISI, " + van.getYatakSay() + "ADET YATAK SAYİSİ, " + van.getOcakSay() + "ADET OCAK SAYİSİ");

                    }
                    counter++;
                }
                counter = 0;
                break;
            case "scooter":
                System.out.println("Scooter Araclar");
                for(Scooter sc : scooterList){
                    if(sc.getIsReserve().equals(isReserved)) {
                        System.out.println(counter + "." + sc.getBrand() + " " + sc.getModel() + " " + sc.getColor() + " " + sc.getKm() + " KM " + sc.getYear() +
                                " Model" + sc.getSepetKapasitesi() + " Sepet kapasitesi");

                    }
                    counter++;
                }
                counter = 0;
                break;
            case "sporbike":
                System.out.println("Sportbike Araclar");

                for(Sportbike sp : sportbikeList){
                    if(sp.getIsReserve().equals(isReserved)) {
                        System.out.println(counter + "." + sp.getBrand() + " " + sp.getModel() +
                                " " + sp.getColor() + " " + sp.getKm() + " KM " + sp.getYear() + " Model " + sp.getMaksHiz() + "KM/S MAKS HİZ");

                    }
                    counter++;
                }
            case "atv":
                System.out.println("Atv Araclar");
                for(Atv atv : atvList){
                    if(atv.getIsReserve().equals(isReserved)) {
                        System.out.println(counter + "." + atv.getBrand() + " " + atv.getModel() + " " + atv.getColor() + " " + atv.getKm() + " KM " + atv.getYear() + " Model");

                    }
                    counter++;
                }
                counter = 0;

                break;
            default:System.out.println("EROR"); break;

        }
    }
    public void dosyalariGuncelle(){


        //SEDAN
       try (BufferedWriter writer = new BufferedWriter(new FileWriter("sedan.txt"))) {
            for (Sedan car : sedanList) {

                writer.write(car.getPassangerCapacity()+"-"+car.getModel()+"-"+car.getColor()+"-"+car.getYear()+"-"+car.getBrand()+"-"+car.getKm()+
                        "-"+car.getIsReserve()+"-"+car.getVehicleType()+"-"+dateFormat.format(car.getStartDate())+"-"+dateFormat.format(car.getEndDate())+"-"+car.getVehiclePlate());
                writer.newLine();
            }
            System.out.println("Sedan araclar basariyla kaydedildi");
        } catch (IOException e) {
            System.out.println("Kayıt yapılırken bir hata olustu" + e.getMessage());
        }

        //SPORTBİKE
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sportbike.txt"))) {
            for (Sportbike car : sportbikeList) {
                writer.write(car.getPassangerCapacity()+"-"+car.getModel()+"-"+car.getColor()+"-"+
                        car.getYear()+"-"+car.getBrand()+"-"+car.getKm()+"-"+car.getSifirYuzSuresi()+"-"+car.getMaksHiz()+"-"+car.getIsReserve()+
                        "-"+car.getVehicleType()+"-"+dateFormat.format(car.getStartDate())+"-"+dateFormat.format(car.getEndDate())+"-"+car.getVehiclePlate());
                writer.newLine();
            }
            System.out.println("Sportbike araclar basariyla kaydedildi");
        } catch (IOException e) {
            System.out.println("Kayıt yapılırken bir hata olustu" + e.getMessage());
        }
        //SUV
       try (BufferedWriter writer = new BufferedWriter(new FileWriter("suv.txt"))) {
            for (Suv car : suvList) {
                writer.write(car.getPassangerCapacity()+"-"+car.getModel()+"-"+car.getColor()+"-"+car.getYear()+"-"+
                        car.getBrand()+"-"+car.getKm()+"-"+car.getCekis()+"-"+car.getIsReserve()+"-"+car.getVehicleType()+
                        "-"+dateFormat.format(car.getStartDate())+"-"+dateFormat.format(car.getEndDate())+"-"+car.getVehiclePlate());
                writer.newLine();
            }
            System.out.println("SUV araclar basariyla kaydedildi");
        } catch (IOException e) {
            System.out.println("Kayıt yapılırken bir hata olustu" + e.getMessage());
        }
       //VAN
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("van.txt"))) {
            for (Van car : vanList) {
                writer.write(car.getPassangerCapacity()+"-"+car.getModel()+"-"+car.getColor()+"-"+car.getYear()+"-"
                        +car.getBrand()+"-"+car.getKm()+"-"+car.getOcakSay()+"-"+car.getYatakSay()+"-"+car.getBuzdolabiKapasitesi()+
                        "-"+car.getSuKapasitesi()+"-"+car.getIsReserve()+"-"+car.getVehicleType()+"-"+dateFormat.format(car.getStartDate())+
                        "-"+dateFormat.format(car.getEndDate())+"-"+car.getVehiclePlate());

                writer.newLine();
            }
            System.out.println("Van araclar basariyla kaydedildi");
        } catch (IOException e) {
            System.out.println("Kayıt yapılırken bir hata olustu" + e.getMessage());
        }

      //SCOOTER
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("scooter.txt"))) {
            for (Scooter car : scooterList) {
                writer.write(car.getPassangerCapacity()+"-"+car.getModel()+"-"+car.getColor()+"-"+
                        car.getYear()+"-"+car.getBrand()+"-"+car.getKm()+"-"+car.getSepetKapasitesi()+"-" +car.getIsReserve()+
                        "-"+car.getVehicleType()+"-"+dateFormat.format(car.getStartDate())+"-"+dateFormat.format(car.getEndDate())+"-"+car.getVehiclePlate());
                writer.newLine();
            }
            System.out.println("Scooter araclar basariyla kaydedildi");
        } catch (IOException e) {
            System.out.println("Kayıt yapılırken bir hata olustu" + e.getMessage());
        }

        //ATV
       try (BufferedWriter writer = new BufferedWriter(new FileWriter("atv.txt"))) {
           for (Atv car : atvList) {
                writer.write(car.getPassangerCapacity()+"-"+car.getModel()+"-"+car.getColor()+"-"+car.getYear()+"-"+car.getBrand()+"-"+
                        car.getKm()+"-"+car.getIsReserve()+"-"+car.getVehicleType()+"-"+dateFormat.format(car.getStartDate())+
                        "-"+dateFormat.format(car.getEndDate())+"-"+car.getVehiclePlate());
                writer.newLine();
            }
            System.out.println("Atv araclar basariyla kaydedildi");
       } catch (IOException e) {
            System.out.println("Kayıt yapılırken bir hata olustu" + e.getMessage());
        }



    }

    public void aracCek() throws IOException, ParseException {


        File sedanArac = new File("sedan.txt");
        FileWriter fSedanYaz= new FileWriter(sedanArac,true);
        BufferedWriter sedanYaz=new BufferedWriter(fSedanYaz);
        FileReader fSedanOku = new FileReader(sedanArac);
        BufferedReader sedanOku = new BufferedReader(fSedanOku);

        String line1;
        while ((line1 = sedanOku.readLine()) != null) {  // Txt'de Sıradaki Satır Boş Değilse Satırı Çeken Kısım

            String[] veriler1 = line1.split("-");  // Satırdaki Verileri "-" İle Ayırarak String Dizisine Atayan Kısım
            Sedan arac1 = new Sedan();
            arac1.setPassangerCapacity(Integer.parseInt(veriler1[0])); //String Tipindeki Veriyi Int'e çevirip değişkene atama
            arac1.setModel(veriler1[1]);
            arac1.setColor(veriler1[2]);
            arac1.setYear(Integer.parseInt(veriler1[3]));
            arac1.setBrand(veriler1[4]);
            arac1.setKm(Integer.parseInt(veriler1[5]));
            arac1.setIsReserve(veriler1[6]);// RESERVE DURUMU
            arac1.setVehicleType(veriler1[7]);//ARAC TİPİ. VehicleResvation sınıf için gerekli listeleme metodunda o yüzden ekledim.
            arac1.setStartDate(dateFormat.parse(veriler1[8]));
            arac1.setEndDate(dateFormat.parse(veriler1[9]));
            arac1.setVehiclePlate(veriler1[10]);
            sedanList.add(arac1);
        }



        File suvArac = new File("suv.txt");
        FileWriter fSuvYaz= new FileWriter(suvArac,true);
        BufferedWriter suvYaz=new BufferedWriter(fSuvYaz);
        FileReader fSuvOku = new FileReader(suvArac);
        BufferedReader suvOku = new BufferedReader(fSuvOku);

        String line2;
        while ((line2 = suvOku.readLine()) != null) {

            String[] veriler2 = line2.split("-");
            Suv arac2 = new Suv();
            arac2.setPassangerCapacity(Integer.parseInt(veriler2[0]));
            arac2.setModel(veriler2[1]);
            arac2.setColor(veriler2[2]);
            arac2.setYear(Integer.parseInt(veriler2[3]));
            arac2.setBrand(veriler2[4]);
            arac2.setKm(Integer.parseInt(veriler2[5]));
            arac2.setCekis(veriler2[6]);
            arac2.setIsReserve(veriler2[7]);
            arac2.setVehicleType(veriler2[8]);
            arac2.setStartDate(dateFormat.parse(veriler2[9]));
            arac2.setEndDate(dateFormat.parse(veriler2[10]));
            arac2.setVehiclePlate(veriler2[11]);


            suvList.add(arac2);
        }



        File vanArac = new File("van.txt");
        FileWriter fVanYaz= new FileWriter(vanArac,true);
        BufferedWriter vanYaz=new BufferedWriter(fVanYaz);
        FileReader fVanOku= new FileReader(vanArac);
        BufferedReader vanOku = new BufferedReader(fVanOku);

        String line3;
        while ((line3 = vanOku.readLine()) != null) {

            String[] veriler3 = line3.split("-");
            Van arac3 = new Van();
            arac3.setPassangerCapacity(Integer.parseInt(veriler3[0]));
            arac3.setModel(veriler3[1]);
            arac3.setColor(veriler3[2]);
            arac3.setYear(Integer.parseInt(veriler3[3]));
            arac3.setBrand(veriler3[4]);
            arac3.setKm(Integer.parseInt(veriler3[5]));
            arac3.setOcakSay(Integer.parseInt(veriler3[6]));
            arac3.setYatakSay(Integer.parseInt(veriler3[7]));
            arac3.setBuzdolabiKapasitesi(Integer.parseInt(veriler3[8]));
            arac3.setSuKapasitesi(Integer.parseInt(veriler3[9]));
            arac3.setIsReserve(veriler3[10]);
            arac3.setVehicleType(veriler3[11]);
            arac3.setStartDate(dateFormat.parse(veriler3[12]));
            arac3.setEndDate(dateFormat.parse(veriler3[13]));
            arac3.setVehiclePlate(veriler3[14]);
            vanList.add(arac3);
        }



        File scooterArac = new File("scooter.txt");
        FileWriter fScooterYaz= new FileWriter(scooterArac,true);
        BufferedWriter scooterYaz=new BufferedWriter(fScooterYaz);
        FileReader fScooterOku = new FileReader(scooterArac);
        BufferedReader scooterOku = new BufferedReader(fScooterOku);

        String line4;
        while ((line4 = scooterOku.readLine()) != null) {

            String[] veriler4 = line4.split("-");
            Scooter arac4 = new Scooter();
            arac4.setPassangerCapacity(Integer.parseInt(veriler4[0]));
            arac4.setModel(veriler4[1]);
            arac4.setColor(veriler4[2]);
            arac4.setYear(Integer.parseInt(veriler4[3]));
            arac4.setBrand(veriler4[4]);
            arac4.setKm(Integer.parseInt(veriler4[5]));
            arac4.setSepetKapasitesi(Integer.parseInt(veriler4[6]));
            arac4.setIsReserve(veriler4[7]);
            arac4.setVehicleType(veriler4[8]);
            arac4.setStartDate(dateFormat.parse(veriler4[9]));
            arac4.setEndDate(dateFormat.parse(veriler4[10]));
            arac4.setVehiclePlate(veriler4[11]);
            scooterList.add(arac4);
        }



        File sportbikeArac = new File("sportbike.txt");
        FileWriter fSportbikeYaz= new FileWriter(sportbikeArac,true);
        BufferedWriter sportbikeYaz=new BufferedWriter(fSportbikeYaz);
        FileReader fSportbikeOku = new FileReader(sportbikeArac);
        BufferedReader sportbikeOku = new BufferedReader(fSportbikeOku);

        String line5;
        while ((line5 = sportbikeOku.readLine()) != null) {

            String[] veriler5 = line5.split("-");
            Sportbike arac5 = new Sportbike();
            arac5.setPassangerCapacity(Integer.parseInt(veriler5[0]));
            arac5.setModel(veriler5[1]);
            arac5.setColor(veriler5[2]);
            arac5.setYear(Integer.parseInt(veriler5[3]));
            arac5.setBrand(veriler5[4]);
            arac5.setKm(Integer.parseInt(veriler5[5]));
            arac5.setSifirYuzSuresi(Double.parseDouble(veriler5[6]));
            arac5.setMaksHiz(Integer.parseInt(veriler5[7]));
            arac5.setIsReserve(veriler5[8]);
            arac5.setVehicleType(veriler5[9]);
            arac5.setStartDate(dateFormat.parse(veriler5[10]));
            arac5.setEndDate(dateFormat.parse(veriler5[11]));
            arac5.setVehiclePlate(veriler5[12]);
            sportbikeList.add(arac5);

        }



        File atvArac = new File("atv.txt");
        FileWriter fAtvYaz= new FileWriter(atvArac,true);
        BufferedWriter atvYaz=new BufferedWriter(fAtvYaz);
        FileReader fAtvOku = new FileReader(atvArac);
        BufferedReader atvOku = new BufferedReader(fAtvOku);

        String line6;
        while ((line6 = atvOku.readLine()) != null) {

            String[] veriler6 = line6.split("-");
            Atv arac6 = new Atv();
            arac6.setPassangerCapacity(Integer.parseInt(veriler6[0]));
            arac6.setModel(veriler6[1]);
            arac6.setColor(veriler6[2]);
            arac6.setYear(Integer.parseInt(veriler6[3]));
            arac6.setBrand(veriler6[4]);
            arac6.setKm(Integer.parseInt(veriler6[5]));
            arac6.setIsReserve(veriler6[6]);
            arac6.setVehicleType(veriler6[7]);
            arac6.setStartDate(dateFormat.parse(veriler6[8]));
            arac6.setEndDate(dateFormat.parse(veriler6[9]));
            arac6.setVehiclePlate(veriler6[10]);

            atvList.add(arac6);
        }




    }

    //ARAC EKLERKEN REZERVE DURUMUNU DİREKT FALSE OLARAK ATAMAYI EKLEDİM. REZERVE EDİLİNCE TRUE OLARAK GUNCELLENECK
    public void sedanEKle(){
        Sedan sedan = new Sedan();

        System.out.print("Yolcu Kapasitesini Giriniz: ");
        sedan.setPassangerCapacity(klavye.nextInt());
        klavye.nextLine();
        System.out.print("Araç Modelini Giriniz: ");
        sedan.setModel(klavye.nextLine());
        System.out.print("Araç Rengini Giriniz: ");
        sedan.setColor(klavye.nextLine());
        System.out.print("Araç Yılını Giriniz: ");
        sedan.setYear(klavye.nextInt());
        klavye.nextLine();
        System.out.print("Araç Markasını Giriniz: ");
        sedan.setBrand(klavye.nextLine());
        System.out.print("Araç Kilometresini Giriniz: ");
        sedan.setKm(klavye.nextInt());
        sedan.setIsReserve("false");
        sedan.setVehicleType("sedan");
        sedan.setEndDate(vehicleDefaultDate);
        sedan.setStartDate(vehicleDefaultDate);
        setPlate(sedan);

        sedanList.add(sedan);
    }

    public void suvEkle(){
        Suv suv = new Suv();

        System.out.print("Yolcu Kapasitesini Giriniz: ");
        suv.setPassangerCapacity(klavye.nextInt());
        klavye.nextLine();
        System.out.print("Araç Modelini Giriniz: ");
        suv.setModel(klavye.nextLine());
        System.out.print("Araç Rengini Giriniz: ");
        suv.setColor(klavye.nextLine());
        System.out.print("Araç Yılını Giriniz: ");
        suv.setYear(klavye.nextInt());
        klavye.nextLine();
        System.out.print("Araç Markasını Giriniz: ");
        suv.setBrand(klavye.nextLine());
        System.out.print("Araç Kilometresini Giriniz: ");
        suv.setKm(klavye.nextInt());
        klavye.nextLine();
        System.out.print("Araç Çekiş Tipini Giriniz: ");
        suv.setCekis(klavye.nextLine());
        suv.setIsReserve("false");
        suv.setVehicleType("suv");
        suv.setEndDate(vehicleDefaultDate);
        suv.setStartDate(vehicleDefaultDate);
        setPlate(suv);

        suvList.add(suv);
    }

    public void vanEkle(){
        Van van = new Van();

        System.out.print("Yolcu Kapasitesini Giriniz: ");
        van.setPassangerCapacity(klavye.nextInt());
        klavye.nextLine();
        System.out.print("Araç Modelini Giriniz: ");
        van.setModel(klavye.nextLine());
        System.out.print("Araç Rengini Giriniz: ");
        van.setColor(klavye.nextLine());
        System.out.print("Araç Yılını Giriniz: ");
        van.setYear(klavye.nextInt());
        klavye.nextLine();
        System.out.print("Araç Markasını Giriniz: ");
        van.setBrand(klavye.nextLine());
        System.out.print("Araç Kilometresini Giriniz: ");
        van.setKm(klavye.nextInt());
        System.out.print("Araç Ocak Sayısını Giriniz: ");
        van.setOcakSay(klavye.nextInt());
        System.out.print("Araç Yatak Sayısını Giriniz: ");
        van.setYatakSay(klavye.nextInt());
        System.out.print("Araç Buzdolabı Kapasitesini Giriniz: ");
        van.setBuzdolabiKapasitesi(klavye.nextInt());
        System.out.print("Araç Su Kapasitesini Giriniz: ");
        van.setSuKapasitesi(klavye.nextInt());
        van.setIsReserve("false");
        van.setVehicleType("van");
        van.setEndDate(vehicleDefaultDate);
        van.setStartDate(vehicleDefaultDate);
        setPlate(van);

        vanList.add(van);
    }


    public void  scooterEkle(){
        Scooter scooter = new Scooter();

        System.out.print("Yolcu Kapasitesini Giriniz: ");
        scooter.setPassangerCapacity(klavye.nextInt());
        klavye.nextLine();
        System.out.print("Araç Modelini Giriniz: ");
        scooter.setModel(klavye.nextLine());
        System.out.print("Araç Rengini Giriniz: ");
        scooter.setColor(klavye.nextLine());
        System.out.print("Araç Yılını Giriniz: ");
        scooter.setYear(klavye.nextInt());
        klavye.nextLine();
        System.out.print("Araç Markasını Giriniz: ");
        scooter.setBrand(klavye.nextLine());
        System.out.print("Araç Kilometresini Giriniz: ");
        scooter.setKm(klavye.nextInt());
        System.out.print("Araç Sepet Kapasitesini Giriniz: ");
        scooter.setSepetKapasitesi(klavye.nextInt());
        scooter.setIsReserve("false");
        scooter.setVehicleType("scooter");
        scooter.setEndDate(vehicleDefaultDate);
        scooter.setStartDate(vehicleDefaultDate);
        setPlate(scooter);
        scooterList.add(scooter);
    }


    public  void sportbikeEkle(){
        Sportbike sportbike = new Sportbike();

        System.out.print("Yolcu Kapasitesini Giriniz: ");
        sportbike.setPassangerCapacity(klavye.nextInt());
        klavye.nextLine();
        System.out.print("Araç Modelini Giriniz: ");
        sportbike.setModel(klavye.nextLine());
        System.out.print("Araç Rengini Giriniz: ");
        sportbike.setColor(klavye.nextLine());
        System.out.print("Araç Yılını Giriniz: ");
        sportbike.setYear(klavye.nextInt());
        klavye.nextLine();
        System.out.print("Araç Markasını Giriniz: ");
        sportbike.setBrand(klavye.nextLine());
        System.out.print("Araç Kilometresini Giriniz: ");
        sportbike.setKm(klavye.nextInt());
        System.out.print("Araç 0-100 Süresini Giriniz: ");
        sportbike.setSifirYuzSuresi(klavye.nextDouble());
        System.out.print("Aracın Maksimum Hızını Giriniz: ");
        sportbike.setMaksHiz(klavye.nextInt());
        sportbike.setIsReserve("false");
        sportbike.setVehicleType("sportbike");
        sportbike.setEndDate(vehicleDefaultDate);
        sportbike.setStartDate(vehicleDefaultDate);
        setPlate(sportbike);

        sportbikeList.add(sportbike);
    }

    public void atvEkle(){

        Atv atv = new Atv();

        System.out.print("Yolcu Kapasitesini Giriniz: ");
        atv.setPassangerCapacity(klavye.nextInt());
        klavye.nextLine();
        System.out.print("Araç Modelini Giriniz: ");
        atv.setModel(klavye.nextLine());
        System.out.print("Araç Rengini Giriniz: ");
        atv.setColor(klavye.nextLine());
        System.out.print("Araç Yılını Giriniz: ");
        atv.setYear(klavye.nextInt());
        klavye.nextLine();
        System.out.print("Araç Markasını Giriniz: ");
        atv.setBrand(klavye.nextLine());
        System.out.print("Araç Kilometresini Giriniz: ");
        atv.setKm(klavye.nextInt());
        atv.setIsReserve("false");
        atv.setVehicleType("atv");
        atv.setEndDate(vehicleDefaultDate);
        atv.setStartDate(vehicleDefaultDate);
        setPlate(atv);

        atvList.add(atv);
    }



    public void aracSil(String aracTur) {

        int aracSira = 0;
        try {
            aracSira = klavye.nextInt();
            klavye.nextLine();
            if(aracSira==0) {
                throw new InputMismatchException();
            }

            switch (aracTur) {
                case "sedan": sedanList.remove(aracSira-1); break;

                case "suv": suvList.remove(aracSira-1); break;

                case "van": vanList.remove(aracSira-1); break;

                case "scooter": scooterList.remove(aracSira-1); break;

                case "sportbike": sportbikeList.remove(aracSira-1); break;

                case "atv": atvList.remove(aracSira-1); break;
            }
        } catch (InputMismatchException exception) {
            System.out.println("Hatalı Giriş Yaptınız..");
        }


    }

}









