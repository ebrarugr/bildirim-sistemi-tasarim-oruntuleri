# Faz 3 — Tasarım Örüntüleri ile İyileştirme

## Bu Fazda Ne Yaptım?

Kötü tasarımı üç tasarım örüntüsü ile iyileştirdim: Factory Pattern, Strategy Pattern ve Decorator Pattern. Her adımda AI ile birlikte çalıştım.

---

## Adım 1 — Strategy + Factory Pattern

### AI'a Sorduğum Prompt

> "BildirimYoneticisi sınıfındaki if-else yapısını Strategy Pattern kullanarak nasıl yeniden tasarlayabilirim? BildirimKanali interface'ini ve somut sınıfları nasıl yazmalıyım?"

### AI'ın Yanıtı (Özet)

AI şu yapıyı önerdi:

```java
public interface BildirimKanali {
    void bildirimGonder(String kullaniciAdi, String mesaj);
}
```

Her bildirim türü için ayrı sınıf yaz: `EmailBildirim`, `SmsBildirim` vb.  
Nesne üretimi için `BildirimFactory` sınıfı oluştur.  
`BildirimServisi` sınıfı factory'yi çağırarak doğru nesneyi kullansın.

### Benim Uyguladığım

AI'ın önerisini birebir uyguladım. Farklı olarak `BildirimServisi`'nin null kontrolünü kendim ekledim:

```java
if (bildirimKanali != null) {
    bildirimKanali.bildirimGonder(kullaniciAdi, mesaj);
} else {
    System.out.println("Geçersiz bildirim türü girildi.");
}
```

AI bunu önerdi ama nasıl yazılacağını yazmadı — kendim tamamladım.

---

## Adım 2 — Decorator Pattern (Structural)

### AI'a Sorduğum Prompt

> "Mevcut bildirim sınıflarını değiştirmeden loglama eklemek istiyorum. Hangi Structural tasarım örüntüsünü kullanmalıyım ve nasıl uygularım?"

### AI'ın Yanıtı (Özet)

AI Decorator Pattern önerdi. Şu yapıyı açıkladı:

- `BildirimDecorator` soyut sınıfı `BildirimKanali`'ni implemente etmeli
- İçinde bir `BildirimKanali` referansı tutmalı
- `LoglamaBildirim` bu sınıftan türeyerek önce log yazmalı, sonra asıl bildirimi gönderecek nesneye delege etmeli

### Benim Uyguladığım

AI'ın anlattığı yapıyı uyguladım. Kendi katkım:

- Log mesajlarını `[LOG]` etiketi ile düzenledim
- `java.time.LocalDateTime.now()` ile zaman damgası ekledim — AI bunu önermemişti
- `Main.java`'da hem email hem SMS için dekoratörün nasıl kullanıldığını gösterdim

### Neden Inheritance Değil Decorator?

AI bu soruyu da cevapladı: Kalıtım kullansaydık her kanal için ayrı loglayan alt sınıf yazmak gerekirdi (`LoglayanEmailBildirim`, `LoglayanSmsBildirim` vb.) — bu 4 ekstra sınıf demek. Decorator ile tek sınıf tüm kanallar için çalışıyor.

---

## Genel Değerlendirme

AI, örüntü yapılarını doğru anlattı ve iyi bir başlangıç noktası sundu. Ancak:

- Bazı implementasyon detaylarını (null kontrolü, zaman damgası) kendim ekledim
- WhatsApp kararı (push kapsamında değerlendirme) tamamen benim kararım
- `Product.java` gibi alakasız dosyaların temizlenmesi gerektiğini AI değil ben fark ettim

AI'ı bir "danışman" olarak kullandım — kararları ben verdim, kodu ben yazdım.
