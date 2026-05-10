public class Product {
    private String urunAdi;
    private double fiyat;
    private int adet;

    public Product(String urunAdi, double fiyat, int adet) {
        this.urunAdi = urunAdi;
        this.fiyat = fiyat;
        this.adet = adet;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public double getFiyat() {
        return fiyat;
    }

    public int getAdet() {
        return adet;
    }

    public double getToplamFiyat() {
        return fiyat * adet;
    }
}
