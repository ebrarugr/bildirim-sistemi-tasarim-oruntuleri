
public class LoglamaBildirim extends BildirimDecorator {

    public LoglamaBildirim(BildirimKanali sarmalananKanal) {
        super(sarmalananKanal);
    }

    @Override
    public void bildirimGonder(String kullaniciAdi, String mesaj) {
        System.out.println("[LOG] Bildirim gönderiliyor...");
        System.out.println("[LOG] Kullanıcı: " + kullaniciAdi);
        System.out.println("[LOG] Zaman: " + java.time.LocalDateTime.now());

        
        sarmalananKanal.bildirimGonder(kullaniciAdi, mesaj);

        System.out.println("[LOG] Bildirim başarıyla gönderildi.");
        System.out.println();
    }
}
