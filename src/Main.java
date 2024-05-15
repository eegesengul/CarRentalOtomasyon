/*
* Java dilinde ekiple proje gelistirmek amaciyla yaptigimiz Car Rental Otomasyonu.
* Emrecan Gök - 22181617019
* Kerem Özbey - 22181616002
* */

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        AracGirisi aracGirisi = new AracGirisi();
        aracGirisi.aracCek();
        VehicleReservation vr = new VehicleReservation();
        Scanner scanner = new Scanner(System.in);
        int adminAracEkle,adminAracSilTur,adminAracListele,adminAracIade; //Admin Menü Seçim Değişkenleri
        int userKiralaTur,userRezerveTur,userAracListele;  //User Menü Seçim Değişkenleri
        int menuSecim=0;
        int adminMenuSecim=0;
        int userMenuSecim=0;
        boolean girisDurumu = false;
        KayitliKullanici mevcutKullanici = null;

        do {
            System.out.println("Car Rental Menu");
            System.out.println("1- Giriş yap");
            System.out.println("2- Kayıt ol");
            System.out.println("3- Kayıt sil");
            System.out.println("4- Çıkış");
            System.out.print("Seçiminizi yapın: ");

            try {
                menuSecim = scanner.nextInt();
                scanner.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Hata: Geçersiz giriş. Lütfen doğru bir değer girin.");
                scanner.nextLine();
            }


                switch (menuSecim) {
                    case 1:
                        // Giriş
                        if (!girisDurumu) {
                            System.out.println("Giriş Yap:");
                            System.out.print("Kullanıcı adınızı girin: ");
                            String girilenKullaniciAdi = scanner.nextLine();
                            System.out.print("Şifrenizi Girin: ");
                            String girilenSifre = scanner.nextLine();


                            mevcutKullanici = KayitliKullanici.girisKullanici(girilenKullaniciAdi, girilenSifre);

                            if (mevcutKullanici != null) {
                                System.out.println("Giriş başarılı. Hoş geldin, " + mevcutKullanici.getFirstName() + "!");
                                girisDurumu = true;

                                if (mevcutKullanici.getAdmin()) {
                                    do {
                                        System.out.println("Vehicle Rental Menu ADMIN PANEL");
                                        System.out.println("1- Araç Ekle");
                                        System.out.println("2- Araç Sil ");
                                        System.out.println("3- Araç İade");
                                        System.out.println("4- Araç Listele");
                                        System.out.println("5- Bilgilerim");
                                        System.out.println("6- Cikis");
                                        System.out.print("Seciminizi yapın: ");

                                        try{
                                        adminMenuSecim = scanner.nextInt();
                                        scanner.nextLine();
                                        } catch (java.util.InputMismatchException e) {
                                            System.out.println("Hata: Geçersiz giriş. Lütfen doğru bir değer girin.");
                                            scanner.nextLine();
                                        }

                                        switch (adminMenuSecim) {
                                            case 1:
                                                System.out.println("Hangi Türde Araç Eklemek İstersiniz: ");
                                                System.out.println("1-Sedan\n2-Suv\n3-Van\n4-Scooter\n5-Sport Bike\n6-Atv");
                                                adminAracEkle = scanner.nextInt();
                                                scanner.nextLine();

                                                switch (adminAracEkle) {
                                                    case 1:
                                                        aracGirisi.sedanEKle();
                                                        break;
                                                    case 2:
                                                        aracGirisi.suvEkle();
                                                        break;
                                                    case 3:
                                                        aracGirisi.vanEkle();
                                                        break;
                                                    case 4:
                                                        aracGirisi.scooterEkle();
                                                        break;
                                                    case 5:
                                                        aracGirisi.sportbikeEkle();
                                                        break;
                                                    case 6:
                                                        aracGirisi.atvEkle();
                                                        break;
                                                    default:
                                                        System.out.println("Geçersiz Bir Değer Girdiniz...");
                                                }
                                                break;

                                            case 2:
                                                System.out.println("Hangi Türde Araç Silmek İstersiniz: ");
                                                System.out.println("1-Sedan\n2-Suv\n3-Van\n4-Scooter\n5-Sport Bike\n6-Atv");
                                                adminAracSilTur = scanner.nextInt();
                                                scanner.nextLine();

                                                switch (adminAracSilTur) {
                                                    case 1:
                                                        aracGirisi.listVehiclesByType("sedan");
                                                        aracGirisi.aracSil("sedan");
                                                        break;
                                                    case 2:
                                                        aracGirisi.listVehiclesByType("suv");
                                                        aracGirisi.aracSil("suv");
                                                        break;
                                                    case 3:
                                                        aracGirisi.listVehiclesByType("van");
                                                        aracGirisi.aracSil("van");
                                                        break;
                                                    case 4:
                                                        aracGirisi.listVehiclesByType("scooter");
                                                        aracGirisi.aracSil("scooter");
                                                        break;
                                                    case 5:
                                                        aracGirisi.listVehiclesByType("sportbike");
                                                        aracGirisi.aracSil("sportbike");
                                                        break;
                                                    case 6:
                                                        aracGirisi.listVehiclesByType("atv");
                                                        aracGirisi.aracSil("atv");
                                                        break;
                                                    default:
                                                        System.out.println("Geçersiz Giriş..");
                                                }
                                                break;
                                            case 3: {
                                                System.out.println("Hani Araç Türünde İade Yapacaksınız: ");
                                                System.out.println("1.Sedan\n2.Suv\n3.Van\n4.Scooter\n5.Sport Bike\n6.Atv");
                                                adminAracIade = scanner.nextInt();
                                                scanner.nextLine();
                                                switch (adminAracIade) {
                                                    case 1:
                                                        aracGirisi.returnVehicle("sedan");
                                                        break;
                                                    case 2:
                                                        aracGirisi.returnVehicle("suv");
                                                        break;
                                                    case 3:
                                                        aracGirisi.returnVehicle("van");
                                                        break;
                                                    case 4:
                                                        aracGirisi.returnVehicle("scooter");
                                                        break;
                                                    case 5:
                                                        aracGirisi.returnVehicle("sportbike");
                                                        break;
                                                    case 6:
                                                        aracGirisi.returnVehicle("atv");
                                                        break;
                                                    default:
                                                        System.out.println("Geçersiz Giriş..");

                                                }
                                                break;

                                            }
                                            case 4:
                                                System.out.println("Hangi Araç Türünü Listelemek İstersiniz: ");
                                                System.out.println("1.Sedan\n2.Suv\n3.Van\n4.Scooter\n5.Sport Bike\n6.Atv");
                                                adminAracListele = scanner.nextInt();
                                                scanner.nextLine();

                                                switch (adminAracListele) {
                                                    case 1:
                                                        aracGirisi.listVehiclesByType("sedan");
                                                        break;
                                                    case 2:
                                                        aracGirisi.listVehiclesByType("suv");
                                                        break;
                                                    case 3:
                                                        aracGirisi.listVehiclesByType("van");
                                                        break;
                                                    case 4:
                                                        aracGirisi.listVehiclesByType("scooter");
                                                        break;
                                                    case 5:
                                                        aracGirisi.listVehiclesByType("sportbike");
                                                        break;
                                                    case 6:
                                                        aracGirisi.listVehiclesByType("atv");
                                                        break;
                                                    default:
                                                        System.out.println("Geçersiz Giriş..");

                                                }

                                                break;

                                            case 5:
                                                mevcutKullanici.displayInfo();
                                                break;

                                            case 6:
                                                System.out.println("Cikis yapiliyor...");
                                                aracGirisi.dosyalariGuncelle();
                                                System.out.println("Çıkış yapıldı. Güle güle, " + mevcutKullanici.getFirstName() + "!");
                                                girisDurumu = false;
                                                mevcutKullanici = null;
                                                break;

                                            default:

                                                System.out.println("Gecersiz secim.");
                                                break;
                                        }
                                    } while (adminMenuSecim != 6);

                                } else {  //Kullanıcı Menüsü
                                    do {
                                        System.out.println("Vehicle Rental Menu User PANEL");
                                        System.out.println("1- Araç Kirala");
                                        System.out.println("2- Araç Listele");
                                        System.out.println("3- Bilgilerim");
                                        System.out.println("4- Cikis");
                                        System.out.print("Seciminizi yapın: ");

                                        try{
                                        userMenuSecim = scanner.nextInt();
                                        scanner.nextLine();
                                        } catch (java.util.InputMismatchException e) {
                                            System.out.println("Hata: Geçersiz giriş. Lütfen doğru bir değer girin.");
                                            scanner.nextLine();
                                        }

                                        switch (userMenuSecim) {

                                            case 1:
                                                System.out.println("Araç Tipi Seçiniz:");
                                                System.out.println("1-Sedan\n2-Suv\n3-Van\n4-Scooter\n5-Sport Bike\n6-Atv");
                                                userKiralaTur = scanner.nextInt();

                                                switch (userKiralaTur) {
                                                    case 1: {
                                                        Date startDate, endDate;
                                                        Date[] times = new Date[2];
                                                        times = vr.SelectReservationStartAndEndDate();
                                                        startDate = times[0];
                                                        endDate = times[1];

                                                        Vehicle selectedVehicle = aracGirisi.vehicleSelect("sedan", "false");
                                                        vr.makeReservation(mevcutKullanici, selectedVehicle, startDate, endDate);
                                                        new FaturaYazdir(mevcutKullanici, selectedVehicle);
                                                        break;
                                                    }
                                                    case 2: {

                                                        Date startDate, endDate;
                                                        Date[] times = new Date[2];
                                                        times = vr.SelectReservationStartAndEndDate();
                                                        startDate = times[0];
                                                        endDate = times[1];

                                                        Vehicle selectedVehicle = aracGirisi.vehicleSelect("suv", "false");
                                                        vr.makeReservation(mevcutKullanici, selectedVehicle, startDate, endDate);
                                                        new FaturaYazdir(mevcutKullanici, selectedVehicle);


                                                        break;
                                                    }
                                                    case 3: {
                                                        Date startDate, endDate;
                                                        Date[] times = new Date[2];
                                                        times = vr.SelectReservationStartAndEndDate();
                                                        startDate = times[0];
                                                        endDate = times[1];

                                                        Vehicle selectedVehicle = aracGirisi.vehicleSelect("van", "false");
                                                        vr.makeReservation(mevcutKullanici, selectedVehicle, startDate, endDate);
                                                        new FaturaYazdir(mevcutKullanici, selectedVehicle);
                                                        break;
                                                    }
                                                    case 4: {
                                                        Date startDate, endDate;
                                                        Date[] times = new Date[2];
                                                        times = vr.SelectReservationStartAndEndDate();
                                                        startDate = times[0];
                                                        endDate = times[1];

                                                        Vehicle selectedVehicle = aracGirisi.vehicleSelect("scooter", "false");
                                                        vr.makeReservation(mevcutKullanici, selectedVehicle, startDate, endDate);
                                                        new FaturaYazdir(mevcutKullanici, selectedVehicle);
                                                        break;
                                                    }
                                                    case 5: {/*Sportbike Listele*/
                                                        Date startDate, endDate;
                                                        Date[] times = new Date[2];
                                                        times = vr.SelectReservationStartAndEndDate();
                                                        startDate = times[0];
                                                        endDate = times[1];

                                                        Vehicle selectedVehicle = aracGirisi.vehicleSelect("sportbike", "false");
                                                        vr.makeReservation(mevcutKullanici, selectedVehicle, startDate, endDate);
                                                        new FaturaYazdir(mevcutKullanici, selectedVehicle);
                                                        break;
                                                    }
                                                    case 6: {
                                                        /*Atv Listele*/
                                                        Date startDate, endDate;
                                                        Date[] times = new Date[2];
                                                        times = vr.SelectReservationStartAndEndDate();
                                                        startDate = times[0];
                                                        endDate = times[1];

                                                        Vehicle selectedVehicle = aracGirisi.vehicleSelect("atv", "false");
                                                        vr.makeReservation(mevcutKullanici, selectedVehicle, startDate, endDate);
                                                        new FaturaYazdir(mevcutKullanici, selectedVehicle);


                                                        break;
                                                    }
                                                    default:
                                                        System.out.println("Geçersiz Giriş..");
                                                }
                                                break;

                                            case 2:
                                                System.out.println("Araç Tipi Seçiniz:");
                                                System.out.println("1-Sedan\n2-Suv\n3-Van\n4-Scooter\n5-Sport Bike\n6-Atv");
                                                userAracListele = scanner.nextInt();

                                                switch (userAracListele) {
                                                    case 1:
                                                        aracGirisi.listVehiclesByType("sedan");
                                                        break;
                                                    case 2:
                                                        aracGirisi.listVehiclesByType("suv");
                                                        break;
                                                    case 3:
                                                        aracGirisi.listVehiclesByType("van");
                                                        break;
                                                    case 4:
                                                        aracGirisi.listVehiclesByType("scooter");
                                                        break;
                                                    case 5:
                                                        aracGirisi.listVehiclesByType("sportbike");
                                                        break;
                                                    case 6:
                                                        aracGirisi.listVehiclesByType("atv");
                                                        break;
                                                    default:
                                                        System.out.println("Geçersiz Giriş..");

                                                }
                                                break;

                                            case 3:
                                                mevcutKullanici.displayInfo();
                                                break;
                                            case 4:
                                                System.out.println("Cikis yapiliyor...");
                                                aracGirisi.dosyalariGuncelle();
                                                System.out.println("Çıkış yapıldı. Güle güle, " + mevcutKullanici.getFirstName() + "!");
                                                girisDurumu = false;
                                                mevcutKullanici = null;
                                                break;

                                            default:
                                                System.out.println("Gecersiz secim.");
                                                break;
                                        }


                                    } while (userMenuSecim != 4);
                                }
                            } else {
                                System.out.println("Geçersiz kullanıcı adı veya parola. Lütfen tekrar deneyin.");
                            }
                        }
                        break;

                    case 2:
                        // Kayıt olma
                        System.out.println("Yeni Kullanıcı Kayıt:");
                        System.out.print("Adınızı giriniz: ");
                        String firstName = scanner.nextLine();
                        System.out.print("Soyadınızı giriniz: ");
                        String lastName = scanner.nextLine();
                        System.out.print("Kullanıcı adınızı giriniz: ");
                        String username = scanner.nextLine();
                        System.out.print("Şifrenizi giriniz: ");
                        String password = scanner.nextLine();

                        KayitliKullanici yeniKullanici = new KayitliKullanici(firstName, lastName, username, password);
                        yeniKullanici.kullaniciKayit();
                        break;

                    case 3:
                        //Kayıt silme
                        System.out.println("Kayıt Sil:");
                        System.out.println("UYARI!: Kayıt silindiğinde bütün bilgileriniz gider.");
                        System.out.print("Kullanıcı adınızı girin: ");
                        String silenKullaniciAdi = scanner.nextLine();
                        System.out.print("Şifrenizi Girin: ");
                        String silenSifre = scanner.nextLine();

                        boolean silmeBasarili = KayitliKullanici.kullaniciSil(silenKullaniciAdi, silenSifre);
                        break;
                    case 4:
                        // Çıkış
                        System.out.println("Çıkış yapılıyor...");
                        break;

                    default:
                        System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                        break;
                }

        } while (menuSecim != 4);

        scanner.close();
    }
}