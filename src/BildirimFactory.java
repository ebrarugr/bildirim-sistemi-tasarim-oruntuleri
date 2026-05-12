
public class BildirimFactory {

    public static BildirimKanali bildirimKanaliOlustur(String bildirimTuru) {

        if (bildirimTuru.equals("EMAIL")) {

            return new EmailBildirim();

        } else if (bildirimTuru.equals("SMS")) {

            return new SmsBildirim();

        } else if (bildirimTuru.equals("PUSH")) {

            return new PushBildirim();

        } else if (bildirimTuru.equals("SISTEM_GUNCELLEME")) {

            return new SistemGuncellemeBildirim();

        } else {

            return null;
        }
    }
}