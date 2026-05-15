Başlangıç Kodunun Analizi - Faz 0
Proje Konusu
Bu projede çok kanallı bir bildirim sistemi ele alınmıştır. Sistem; e-posta, SMS, push ve sistem güncelleme bildirimi gönderebilmektedir.
İlk aşamada sistem kötü tasarım örneği olarak tek bir sınıf içinde yazılmıştır. Bu sınıf BildirimYoneticisi sınıfıdır.

Başlangıç Kodundaki Tasarım Problemleri
Problem 1 — Tek Sınıfta Aşırı Sorumluluk (Single Responsibility Principle İhlali)
BildirimYoneticisi sınıfı hem bildirim türünü belirlemekte hem de her türün gönderme işlemini gerçekleştirmektedir. Bir sınıfın yalnızca tek bir değişme sebebi olmalıdır; bu sınıfın ise birden fazla sebebi vardır.
javapublic void bildirimGonder(String bildirimTuru, String kullaniciAdi, String mesaj) {
    if (bildirimTuru.equals("EMAIL")) {
        // e-posta gönder
    } else if (bildirimTuru.equals("SMS")) {
        // sms gönder
    }
    // ...
}
Problem 2 — Açık/Kapalı Prensibinin İhlali (Open/Closed Principle)
Yeni bir bildirim türü eklemek için BildirimYoneticisi sınıfının içine girip mevcut kodu değiştirmek gerekmektedir. Oysa sınıflar genişlemeye açık, değişime kapalı olmalıdır. Örneğin "WhatsApp bildirimi" eklemek için mevcut if-else zincirine yeni bir dal eklemek zorundasınız.
Problem 3 — if-else Zinciriyle Tip Kontrolü (Magic String Kullanımı)
Bildirim türleri "EMAIL", "SMS" gibi ham string değerlerle kontrol edilmektedir. Bu yaklaşım yazım hatalarına (örn. "EMAİL" vs "EMAIL") açıktır ve derleme zamanında hata yakalanamamaktadır. Enum veya ayrı sınıf yapısı kullanılmalıdır.
javaif (bildirimTuru.equals("EMAIL")) { ... }   // Yazım hatası derlenmez ama çalışmaz
Problem 4 — Kodun Tekrarlanması (Code Duplication)
Her bildirim türü için aynı System.out.println yapısı tekrar tekrar yazılmaktadır. Kullanıcı adı ve mesajı yazdırma kodu her if-else dalında kopyalanmıştır. Bu durum, herhangi bir değişikliği tüm dallarda ayrı ayrı yapmayı zorunlu kılar.
javaSystem.out.println("Kullanıcı: " + kullaniciAdi);
System.out.println("Mesaj: " + mesaj);
// Bu blok her if-else dalında aynen tekrarlanıyor
Problem 5 — Test Edilebilirlik Zorluğu
BildirimYoneticisi sınıfı monolitik yapısı nedeniyle birim testi yazmayı güçleştirmektedir. Yalnızca e-posta bildirimini test etmek istesek bile sınıfın tamamını ayağa kaldırmak gerekmektedir. Sorumluluklar ayrı sınıflara bölünmüş olsaydı her biri bağımsız test edilebilirdi.
Problem 6 — Genişleme Maliyeti Artar (Scalability Sorunu)
Sistem büyüdükçe if-else zinciri de uzar. 10 farklı bildirim türü olduğunda tek bir metot içinde 10 dal oluşur. Bu durum kodun okunmasını, bakımını ve hata ayıklamasını ciddi ölçüde zorlaştırır.

AI Karşılaştırması
AI'a gösterilen prompt:

"Bu kodda hangi tasarım sorunlarını görüyorsun? Hangi tasarım örüntüleri bu sorunları çözebilir? Her sorun için kısa bir açıklama yaz."

AI'ın tespit ettikleri:

SRP ihlali (tek sınıfta çok sorumluluk)
OCP ihlali (değişime açık yapı)
Magic string kullanımı
Strategy Pattern ve Factory Pattern önerisi

Benim tespitlerimin farkı:
AI genel prensip ihlallerini doğru tespit etti. Ancak kod tekrarı (Problem 4) ve test edilebilirlik sorunu (Problem 5) konularında daha yüzeysel kaldı. Scalability sorununu (Problem 6) ise hiç açıklamadı. Bu eksikleri kendi analizimde tamamladım.
