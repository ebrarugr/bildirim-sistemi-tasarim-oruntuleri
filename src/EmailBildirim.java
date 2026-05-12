
public class EmailBildirim implements BildirimKanali {

    @Override
    public void bildirimGonder(String kullaniciAdi, String mesaj) {

        System.out.println("E-posta bildirimi gönderildi.");
        System.out.println("Kullanıcı: " + kullaniciAdi);
        System.out.println("Mesaj: " + mesaj);
    }
}