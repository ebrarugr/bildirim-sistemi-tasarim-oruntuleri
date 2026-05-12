# Başlangıç Kodunun Analizi - Faz 0

## Proje Konusu

Bu projede çok kanallı bir bildirim sistemi ele alınmıştır. Sistem; e-posta, SMS, push ve sistem güncelleme bildirimi gönderebilmektedir.

İlk aşamada sistem kötü tasarım örneği olarak tek bir sınıf içinde yazılmıştır. Bu sınıf `BildirimYoneticisi` sınıfıdır.

---

## Başlangıç Kodundaki Tasarım Problemi

Başlangıç tasarımında bütün bildirim türleri tek bir sınıf içinde kontrol edilmektedir.

`BildirimYoneticisi` sınıfında bildirim türleri şu şekilde `if-else` blokları ile ayrılmıştır:

```java
if (bildirimTuru.equals("EMAIL")) {
    // E-posta bildirimi gönder
} else if (bildirimTuru.equals("SMS")) {
    // SMS bildirimi gönder
} else if (bildirimTuru.equals("PUSH")) {
    // Push bildirimi gönder
} else if (bildirimTuru.equals("SISTEM_GUNCELLEME")) {
    // Sistem güncelleme bildirimi gönder
}
