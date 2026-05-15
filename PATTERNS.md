# Kullanılan Tasarım Örüntüleri

Bu projede çok kanallı bildirim sistemi için üç tasarım örüntüsü kullanılmıştır:

- Factory Pattern (Faz 1 — Creational)
- Strategy Pattern (Faz 3 — Behavioral)
- Decorator Pattern (Faz 2 — Structural)

---

## 1. Factory Pattern (Creational)

### Kullanım Amacı

Nesne yaratma sorumluluğunu merkezi bir yere taşımak için kullanılmıştır.

### Projede Nerede Kullanıldı?

`BildirimFactory` sınıfı, gelen bildirim türüne göre uygun nesneyi üretmektedir.

```java
public class BildirimFactory {
    public static BildirimKanali bildirimKanaliOlustur(String bildirimTuru) {
        if (bildirimTuru.equals("EMAIL")) return new EmailBildirim();
        if (bildirimTuru.equals("SMS"))   return new SmsBildirim();
        // ...
    }
}
```

### Ne Kazandırdı?

`BildirimServisi` sınıfı artık hangi nesnenin üretildiğini bilmek zorunda değildir. Nesne yaratma mantığı tek bir yerde toplanmıştır.

---

## 2. Strategy Pattern (Behavioral)

### Kullanım Amacı

Aynı işi (bildirim göndermek) farklı şekillerde yapan sınıfları ortak bir interface altında toplamak için kullanılmıştır.

### Projede Nerede Kullanıldı?

`BildirimKanali` interface'i tanımlanmıştır. Bu interface'i implemente eden sınıflar:

- `EmailBildirim`
- `SmsBildirim`
- `PushBildirim`
- `SistemGuncellemeBildirim`

```java
public interface BildirimKanali {
    void bildirimGonder(String kullaniciAdi, String mesaj);
}
```

### Ne Kazandırdı?

Her bildirim türü kendi sınıfında yönetilmektedir. Yeni bir tür eklemek için mevcut kod değiştirilmez, sadece yeni bir sınıf eklenir.

---

## 3. Decorator Pattern (Structural)

### Kullanım Amacı

Mevcut bildirim sınıflarını değiştirmeden üzerlerine yeni davranış (loglama) eklemek için kullanılmıştır.

### Projede Nerede Kullanıldı?

`BildirimDecorator` soyut sınıfı `BildirimKanali` interface'ini implemente eder ve bir `BildirimKanali` nesnesini sarar.

`LoglamaBildirim` bu sınıftan türeyerek herhangi bir bildirim kanalına loglama davranışı ekler:

```java
BildirimKanali kanal = new LoglamaBildirim(new EmailBildirim());
kanal.bildirimGonder("Ebrar", "Mesaj");
// Önce log yazar, sonra e-postayı gönderir
```

### Neden Bu Örüntü Seçildi?

**Alternatif — Inheritance (Kalıtım):** Her bildirim türü için ayrı bir loglayan alt sınıf yazılabilirdi (`LoglayanEmailBildirim`, `LoglayanSmsBildirim` vb.). Ancak bu yaklaşım 4 yeni sınıf oluşturur ve kod tekrarına yol açar. Decorator ile tek bir sınıf tüm kanallar için çalışır.

**Alternatif — Facade:** Facade sistemi basitleştirmek için kullanılır, mevcut nesnelere davranış eklemek için değil. Bu nedenle uygun değildi.

### Ne Kazandırdı?

- `EmailBildirim`, `SmsBildirim` gibi mevcut sınıflar **hiç değiştirilmedi** — OCP korundu.
- Loglama davranışı tüm kanallara tek bir dekoratörle uygulanabilir hale geldi.
- İleride `SifrelemeBildirim` gibi yeni dekoratörler eklemek kolaylaşacak.
