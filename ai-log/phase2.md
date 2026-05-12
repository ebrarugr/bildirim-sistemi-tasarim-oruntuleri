# Phase 2 - Kötü Tasarımın Oluşturulması

Bu aşamada projenin ilk çalışan hali kötü tasarım örneği olarak oluşturulmuştur.

Kötü tasarım için `BildirimYoneticisi` sınıfı yazılmıştır.

Bu sınıfta bütün bildirim türleri `if-else` blokları ile kontrol edilmiştir.

Kullanılan bildirim türleri:

- EMAIL
- SMS
- PUSH
- SISTEM_GUNCELLEME

Bu yapı çalışmaktadır ancak tasarım açısından zayıftır.

Başlıca problemler:

- Bütün sorumluluk tek sınıfta toplanmıştır.
- Yeni bildirim türü eklemek için mevcut kod değiştirilmelidir.
- Kod büyüdükçe okunması zorlaşır.
- Open/Closed Principle ihlal edilmektedir.
- Single Responsibility Principle ihlal edilmektedir.

Bu nedenle bir sonraki aşamada tasarım örüntüleri kullanılarak kod iyileştirilmiştir.
