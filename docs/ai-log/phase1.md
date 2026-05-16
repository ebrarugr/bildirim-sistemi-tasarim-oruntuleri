# Faz 1 — Proje Konusunun Belirlenmesi

## Bu Fazda Ne Yaptım?

Proje konusunu belirledim. İlk olarak e-ticaret sistemi üzerinde çalışmayı düşündüm. Ancak sınıfta birçok kişinin aynı konuyu seçtiğini öğrenince konu değiştirmeye karar verdim. Yeni konu olarak çok kanallı bildirim sistemi seçildi.

---

## AI'a Sorduğum Prompt

> "Yazılım tasarım örüntüleri ödevi için proje konusu arıyorum. Creational, Structural ve Behavioral örüntüleri birlikte uygulayabileceğim, gerçek hayata yakın ama karmaşık olmayan bir sistem önerir misin?"

---

## AI'ın Yanıtı (Özet)

AI birkaç öneri sundu:

- **Ödeme sistemi** — Strategy (ödeme yöntemi), Factory (ödeme nesnesi), Decorator (indirim ekleme)
- **Bildirim sistemi** — Strategy (kanal seçimi), Factory (nesne üretimi), Decorator (loglama)
- **Dosya dışa aktarma sistemi** — Strategy (format), Factory (exporter), Decorator (sıkıştırma)

AI, bildirim sistemini özellikle önerdi; çünkü gerçek hayatta (e-posta, SMS, push) yaygın kullanılan ve örüntülerin doğal oturduğu bir senaryo olduğunu belirtti.

---

## Benim Kararım ve Gerekçem

AI'ın önerisi ile kendi tercihim örtüştü — bildirim sistemini seçtim.

**AI'dan farklı düşündüğüm nokta:** AI WhatsApp bildirimini ayrı bir kanal olarak modellemeyi önerdi. Ben bunu gereksiz buldum; WhatsApp da temelde bir push bildirimidir. Bu nedenle ayrı bir sınıf yazmadım, push bildirimi kapsamına dahil ettim.

**Belirlenen bildirim türleri:**
- E-posta bildirimi
- SMS bildirimi
- Push bildirimi (WhatsApp dahil)
- Sistem güncelleme bildirimi
