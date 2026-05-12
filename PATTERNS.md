# Kullanılan Tasarım Örüntüleri

Bu projede çok kanallı bildirim sistemi için iki temel tasarım örüntüsü kullanılmıştır:

- Strategy Pattern
- Factory Pattern

---

## 1. Strategy Pattern

### Kullanım Amacı

Strategy Pattern, aynı işi farklı şekillerde yapan sınıfları ortak bir yapı altında toplamayı sağlar.

Bu projede bütün bildirim türleri aslında aynı görevi yapmaktadır:

> Kullanıcıya bildirim göndermek.

Ancak her bildirim türünün gönderilme şekli farklıdır.

Örneğin:

- E-posta bildirimi
- SMS bildirimi
- Push bildirimi
- Sistem güncelleme bildirimi

Bu nedenle her bildirim türü ayrı bir sınıf olarak tasarlanmıştır.

---

## Projede Strategy Pattern Yapısı

Ortak interface:

```java
public interface BildirimKanali {
    void bildirimGonder(String kullaniciAdi, String mesaj);
}
