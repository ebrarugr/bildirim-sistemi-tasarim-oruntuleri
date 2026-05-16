# Yazılım Tasarım Örüntüleri Ödevi

## Proje Konusu: Çok Kanallı Bildirim Sistemi

Bu projede kullanıcıya farklı kanallar üzerinden bildirim gönderen bir bildirim sistemi tasarlanmıştır. Proje, kötü tasarımdan başlayarak tasarım örüntüleri ile adım adım iyileştirilmiştir.

Sistemde kullanılan bildirim türleri:

- E-posta bildirimi
- SMS bildirimi
- Push bildirimi (WhatsApp ve mobil uygulama bildirimleri bu kapsama dahildir)
- Sistem güncelleme bildirimi

---

## Proje Yapısı

```
bildirim-sistemi-tasarim-oruntuleri/
├── src/
│   ├── BildirimKanali.java          # Strategy interface
│   ├── EmailBildirim.java
│   ├── SmsBildirim.java
│   ├── PushBildirim.java
│   ├── SistemGuncellemeBildirim.java
│   ├── BildirimFactory.java         # Factory
│   ├── BildirimServisi.java
│   ├── BildirimDecorator.java       # Decorator (soyut)
│   ├── LoglamaBildirim.java         # Decorator (somut)
│   ├── BildirimYoneticisi.java      # Kötü tasarım örneği
│   └── Main.java
├── docs/
│   ├── diagrams/
│   │   └── class-diagram.md
│   └── ai-log/
│       ├── phase1.md
│       ├── phase2.md
│       └── phase3.md
├── .github/
│   └── workflows/
│       └── ci.yml
├── PROBLEMS.md
├── PATTERNS.md
└── README.md
```

---

## Nasıl Çalıştırılır

**Gereksinim:** Java 17 veya üzeri

```bash
# 1. Derleme
javac src/*.java

# 2. Çalıştırma
java -cp src Main
```

**Beklenen çıktı:**
```
E-posta bildirimi gönderildi.
Kullanıcı: Ebrar
Mesaj: Hesabınıza yeni bir giriş yapıldı.
-----------------------------
SMS bildirimi gönderildi.
Kullanıcı: Ebrar
Mesaj: Doğrulama kodunuz: 4821
-----------------------------
=== Loglamalı E-posta Bildirimi ===
[LOG] Bildirim gönderiliyor...
[LOG] Kullanıcı: Ebrar
[LOG] Zaman: 2026-05-16T...
E-posta bildirimi gönderildi.
Kullanıcı: Ebrar
Mesaj: Şifreniz başarıyla değiştirildi.
[LOG] Bildirim başarıyla gönderildi.
```

---

## Kullanılan Tasarım Örüntüleri

| Örüntü | Kategori | Kullanım Yeri |
|---|---|---|
| Factory Pattern | Creational | `BildirimFactory` — bildirim nesnesi üretimi |
| Strategy Pattern | Behavioral | `BildirimKanali` interface + 4 somut sınıf |
| Decorator Pattern | Structural | `BildirimDecorator` + `LoglamaBildirim` |

Detaylı açıklama için: [PATTERNS.md](PATTERNS.md)

---

## Kötü Tasarım

İlk tasarımda tüm bildirim gönderme işlemleri `BildirimYoneticisi` sınıfında `if-else` blokları ile yönetilmiştir. Bu yapı SRP ve OCP ihlali başta olmak üzere 6 tasarım problemine yol açmaktadır.

Detaylı analiz için: [PROBLEMS.md](PROBLEMS.md)
