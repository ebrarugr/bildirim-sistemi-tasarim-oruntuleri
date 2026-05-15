/**
 * Decorator Pattern - Somut Dekoratör: Loglama
 *
 * Herhangi bir BildirimKanali nesnesini sararak bildirim gönderimlerini loglar.
 * Hangi kullanıcıya, hangi saatte bildirim gönderildiğini kaydeder.
 * Mevcut bildirim sınıfları (Email, SMS, Push vb.) değiştirilmeden loglama eklenir.
 */
public class LoglamaBildirim extends BildirimDecorator {

    public LoglamaBildirim(BildirimKanali sarmalananKanal) {
        super(sarmalananKanal);
    }

    @Override
    public void bildirimGonder(String kullaniciAdi, String mesaj) {
        System.out.println("[LOG] Bildirim gönderiliyor...");
        System.out.println("[LOG] Kullanıcı: " + kullaniciAdi);
        System.out.println("[LOG] Zaman: " + java.time.LocalDateTime.now());

        // Asıl bildirimi gönder (sarmaladığı nesneye delege eder)
        sarmalananKanal.bildirimGonder(kullaniciAdi, mesaj);

        System.out.println("[LOG] Bildirim başarıyla gönderildi.");
        System.out.println();
    }
}
