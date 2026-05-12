
public class SistemGuncellemeBildirim implements BildirimKanali {

    @Override
    public void bildirimGonder(String kullaniciAdi, String mesaj) {

        System.out.println("Sistem güncelleme bildirimi gönderildi.");
        System.out.println("Kullanıcı: " + kullaniciAdi);
        System.out.println("Mesaj: " + mesaj);
    }
}