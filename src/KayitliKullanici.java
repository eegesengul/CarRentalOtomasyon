import java.io.*;


public class KayitliKullanici extends User{
    public KayitliKullanici(String firstName, String lastName, String username, String password){
        super(firstName,lastName,username,password);
    }

    public void displayInfo(){
        System.out.println("Kullanıcı Bilgileri: ");
        System.out.println("Ad: "+getFirstName());
        System.out.println("Soyad: "+getLastName());
        System.out.println("Kullanıcı Adı: "+getUsername());
    }

    public void kullaniciKayit(){

        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length == 5 && parts[2].equalsIgnoreCase(username)) {
                    System.out.println("Hata: Bu kullanıcı adı zaten kullanımda.");
                    return;
                }
            }
        } catch (IOException e) {
            System.err.println("Hata: " + e.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt",true))) {
            writer.write(firstName+"-"+lastName+"-"+username+"-"+password+"-"+admin);
            writer.newLine();

            System.out.println("Kullanici basariyla kaydedildi");
        } catch (IOException e) {
            System.out.println("Kayıt yapılırken bir hata olustu" + e.getMessage());
        }

    }
    public static KayitliKullanici girisKullanici(String girilenKullaniciAdi, String girilenSifre)  {

            try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("-");
                    if (parts.length == 5 && parts[2].equals(girilenKullaniciAdi) && parts[3].equals(girilenSifre)) {
                        return new KayitliKullanici(parts[0], parts[1], parts[2], parts[3]);
                    }
                }
            } catch (IOException e) {
                System.err.println("Hata: " + e.getMessage());
            }
            return null;
    }

    public static boolean kullaniciSil(String silenKullaniciAdi, String silenSifre) {
        try {
            File inputFile = new File("users.txt");
            File tempFile = new File("tempUsers.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            boolean kullaniciSilindi = false;

            while ((currentLine = reader.readLine()) != null) {
                String[] parts = currentLine.split("-");
                if (parts.length == 5 && parts[2].equals(silenKullaniciAdi) && parts[3].equals(silenSifre)) {
                    kullaniciSilindi = true;
                    System.out.println("Eşleşen kullanıcı bulundu: " + parts[2]);
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }

            writer.close();
            reader.close();

            if (!kullaniciSilindi) {
                System.out.println("Hata: Kullanıcı bulunamadı veya şifre yanlış.");
                tempFile.delete();
                return false;
            }

            if (!inputFile.delete()) {
                System.out.println("Hata: Geçici dosya oluşturulurken bir sorun oluştu.");
                return false;
            }

            if (!tempFile.renameTo(inputFile)) {
                System.out.println("Hata: Dosya adı değiştirilirken bir sorun oluştu.");
                return false;
            }

            System.out.println("Kullanıcı başarıyla silindi.");
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Hata: " + e.getMessage());
            return false;
        }
    }

}
