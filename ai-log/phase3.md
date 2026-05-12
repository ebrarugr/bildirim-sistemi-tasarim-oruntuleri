# Phase 3 - Tasarım Örüntüleri ile İyileştirme

Bu aşamada kötü tasarım tasarım örüntüleri kullanılarak iyileştirilmiştir.

Projede Strategy Pattern ve Factory Pattern kullanılmıştır.

## Strategy Pattern

Bildirim gönderme davranışları ayrı sınıflara ayrılmıştır.

Ortak yapı için `BildirimKanali` interface'i oluşturulmuştur.

Bu interface'i uygulayan sınıflar:

- `EmailBildirim`
- `SmsBildirim`
- `PushBildirim`
- `SistemGuncellemeBildirim`

Her sınıf kendi bildirim gönderme işlemini kendisi gerçekleştirmektedir.

## Factory Pattern

`BildirimFactory` sınıfı oluşturulmuştur.

Bu sınıf, gelen bildirim türüne göre uygun bildirim nesnesini üretmektedir.

Örneğin:

- EMAIL için `EmailBildirim`
- SMS için `SmsBildirim`
- PUSH için `PushBildirim`
- SISTEM_GUNCELLEME için `SistemGuncellemeBildirim`

## Sonuç

Kod daha düzenli, okunabilir ve geliştirilebilir hale getirilmiştir.

Yeni bir bildirim türü eklenmek istendiğinde sisteme yeni bir sınıf eklemek yeterli olur.

Bu aşamada Java kodları Eclipse üzerinde çalıştırılmış ve çıktı başarılı şekilde alınmıştır.
