/**
 * Decorator Pattern - Temel Sarmalayıcı Sınıf
 *
 * BildirimKanali interface'ini implemente eder ve bir BildirimKanali nesnesini sarar.
 * Alt sınıflar bu sınıftan türeyerek mevcut bildirimlere yeni davranış ekleyebilir.
 * Mevcut sınıflar (EmailBildirim, SmsBildirim vb.) hiç değiştirilmez — OCP sağlanır.
 */
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
