public class Main {

    public static void main(String[] args) {

        
        BildirimServisi bildirimServisi = new BildirimServisi();

        bildirimServisi.bildirimGonder("EMAIL", "Ebrar", "Hesabınıza yeni bir giriş yapıldı.");
        System.out.println("-----------------------------");
        bildirimServisi.bildirimGonder("SMS", "Ebrar", "Doğrulama kodunuz: 4821");
        System.out.println("-----------------------------");

       
        BildirimKanali emailKanali = new EmailBildirim();
        BildirimKanali loglananEmail = new LoglamaBildirim(emailKanali);

        System.out.println("=== Loglamalı E-posta Bildirimi ===");
        loglananEmail.bildirimGonder("Ebrar", "Şifreniz başarıyla değiştirildi.");

      
        BildirimKanali smsKanali = new SmsBildirim();
        BildirimKanali loglananSms = new LoglamaBildirim(smsKanali);

        System.out.println("=== Loglamalı SMS Bildirimi ===");
        loglananSms.bildirimGonder("Ebrar", "Doğrulama kodunuz: 9934");
    }
}
