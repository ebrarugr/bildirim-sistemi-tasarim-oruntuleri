public class Main {

    public static void main(String[] args) {

        BildirimServisi bildirimServisi = new BildirimServisi();

        bildirimServisi.bildirimGonder(
                "EMAIL",
                "Ebrar",
                "Hesabınıza yeni bir giriş yapıldı."
        );

        System.out.println("-----------------------------");

        bildirimServisi.bildirimGonder(
                "SMS",
                "Ebrar",
                "Doğrulama kodunuz: 4821"
        );

        System.out.println("-----------------------------");

        bildirimServisi.bildirimGonder(
                "PUSH",
                "Ebrar",
                "Yeni bir mesajınız var."
        );

        System.out.println("-----------------------------");

        bildirimServisi.bildirimGonder(
                "SISTEM_GUNCELLEME",
                "Ebrar",
                "Sistem bakımı bu gece 02.00'de yapılacaktır."
        );
    }
}