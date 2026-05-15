
public abstract class BildirimDecorator implements BildirimKanali {

    protected BildirimKanali sarmalananKanal;

    public BildirimDecorator(BildirimKanali sarmalananKanal) {
        this.sarmalananKanal = sarmalananKanal;
    }

    @Override
    public void bildirimGonder(String kullaniciAdi, String mesaj) {
        sarmalananKanal.bildirimGonder(kullaniciAdi, mesaj);
    }
}
