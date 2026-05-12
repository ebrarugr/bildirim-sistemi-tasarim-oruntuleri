public class SmsBildirim implements BildirimKanali {

    @Override
    public void bildirimGonder(String kullaniciAdi, String mesaj) {

        System.out.println("SMS bildirimi gönderildi.");
        System.out.println("Kullanıcı: " + kullaniciAdi);
        System.out.println("Mesaj: " + mesaj);
    }
}