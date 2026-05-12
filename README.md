# Yazılım Tasarım Örüntüleri Ödevi

## Proje Konusu: Çok Kanallı Bildirim Sistemi

Bu projede kullanıcıya farklı kanallar üzerinden bildirim gönderen basit bir bildirim sistemi tasarlanmıştır.

Sistemde kullanılan bildirim türleri:

- E-posta bildirimi
- SMS bildirimi
- Push bildirimi
- Sistem güncelleme bildirimi

Push bildirimi, kullanıcının telefonuna veya bilgisayarına uygulama üzerinden gelen anlık bildirimleri temsil eder. WhatsApp mesaj bildirimi, sosyal medya bildirimi veya mobil uygulama bildirimi bu kapsama örnek verilebilir.

---

## Kötü Tasarım

İlk tasarımda bütün bildirim gönderme işlemleri `BildirimYoneticisi` sınıfı içinde yapılmıştır.

Bu sınıfta bildirim türleri `if-else` blokları ile kontrol edilmiştir.

Örneğin:

```java
if (bildirimTuru.equals("EMAIL")) {
    // E-posta bildirimi gönder
} else if (bildirimTuru.equals("SMS")) {
    // SMS bildirimi gönder
} else if (bildirimTuru.equals("PUSH")) {
    // Push bildirimi gönder
}
