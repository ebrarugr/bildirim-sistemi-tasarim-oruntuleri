public class BildirimYoneticisi {

    public void bildirimGonder(String bildirimTuru, String kullaniciAdi, String mesaj) {

        if (bildirimTuru.equals("EMAIL")) {

            System.out.println("E-posta bildirimi gönderildi.");
            System.out.println("Kullanıcı: " + kullaniciAdi);
            System.out.println("Mesaj: " + mesaj);

        } else if (bildirimTuru.equals("SMS")) {

            System.out.println("SMS bildirimi gönderildi.");
            System.out.println("Kullanıcı: " + kullaniciAdi);
            System.out.println("Mesaj: " + mesaj);

        } else if (bildirimTuru.equals("PUSH")) {

            System.out.println("Push bildirimi gönderildi.");
            System.out.println("Kullanıcı: " + kullaniciAdi);
            System.out.println("Mesaj: " + mesaj);
            System.out.println("Örnek: WhatsApp veya mobil uygulama bildirimi");

        } else if (bildirimTuru.equals("SISTEM_GUNCELLEME")) {

            System.out.println("Sistem güncelleme bildirimi gönderildi.");
            System.out.println("Kullanıcı: " + kullaniciAdi);
            System.out.println("Mesaj: " + mesaj);

        } else {

            System.out.println("Geçersiz bildirim türü girildi.");
        }
    }
}
















