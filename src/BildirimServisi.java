
public class BildirimServisi {

    public void bildirimGonder(String bildirimTuru, String kullaniciAdi, String mesaj) {

        BildirimKanali bildirimKanali = BildirimFactory.bildirimKanaliOlustur(bildirimTuru);

        if (bildirimKanali != null) {

            bildirimKanali.bildirimGonder(kullaniciAdi, mesaj);

        } else {

            System.out.println("Geçersiz bildirim türü girildi.");
        }
    }
}