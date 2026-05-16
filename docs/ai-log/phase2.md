# Faz 2 — Kötü Tasarımın Oluşturulması ve Analizi

## Bu Fazda Ne Yaptım?

Projenin ilk çalışan halini kötü tasarım örneği olarak yazdım. Tüm bildirim türleri `BildirimYoneticisi` sınıfında `if-else` blokları ile kontrol edildi. Ardından bu kodu AI'a analiz ettirdim.

---

## AI'a Sorduğum Prompt

> "Aşağıdaki Java kodunu incele. Bu kodda hangi tasarım sorunlarını görüyorsun? Hangi SOLID prensipleri ihlal ediliyor? Hangi tasarım örüntüleri bu sorunları çözebilir? Her sorun için kısa bir açıklama yaz."

Kodu da birlikte yapıştırdım:

```java
public class BildirimYoneticisi {
    public void bildirimGonder(String bildirimTuru, String kullaniciAdi, String mesaj) {
        if (bildirimTuru.equals("EMAIL")) {
            System.out.println("E-posta bildirimi gönderildi.");
            System.out.println("Kullanıcı: " + kullaniciAdi);
            System.out.println("Mesaj: " + mesaj);
        } else if (bildirimTuru.equals("SMS")) {
            ...
        }
    }
}
```

---

## AI'ın Yanıtı (Özet)

AI şu sorunları tespit etti:

- **SRP ihlali:** Sınıf hem tür belirleme hem de gönderme işini yapıyor.
- **OCP ihlali:** Yeni tür eklemek için mevcut kodu değiştirmek gerekiyor.
- **Magic string kullanımı:** `"EMAIL"`, `"SMS"` gibi ham stringler hata riskini artırıyor.
- **Öneri:** Strategy Pattern ile her bildirim türünü ayrı sınıfa taşı, Factory Pattern ile nesne üretimini merkeze al.

---

## Benim Değerlendirmem

AI'ın tespitleri doğruydu, ancak eksik kaldığı noktalar oldu:

| Sorun | AI Tespit Etti mi? | Benim Yorumum |
|---|---|---|
| SRP ihlali | ✅ | Doğru |
| OCP ihlali | ✅ | Doğru |
| Magic string | ✅ | Doğru |
| Kod tekrarı (her dalda aynı println) | ❌ | AI bunu atlıyordu, ben fark ettim |
| Test edilebilirlik zorluğu | ❌ | AI yüzeysel geçti |
| Scalability (10+ tür eklenirse ne olur) | ❌ | AI hiç bahsetmedi |

AI genel prensip ihlallerini iyi yakaladı. Ancak kod kalitesi detaylarını (tekrar, test edilebilirlik) kendim ekledim. Bu nedenle PROBLEMS.md'deki 4, 5 ve 6. problemler tamamen benim analizimdir.
