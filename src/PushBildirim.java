public class PushBildirim implements BildirimKanali {

    @Override
    public void bildirimGonder(String kullaniciAdi, String mesaj) {

        System.out.println("Push bildirimi gönderildi.");
        System.out.println("Kullanıcı: " + kullaniciAdi);
        System.out.println("Mesaj: " + mesaj);
        System.out.println("Örnek: WhatsApp veya mobil uygulama bildirimi");
    }
}