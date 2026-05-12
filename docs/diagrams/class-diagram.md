# UML Sınıf Diyagramı

Aşağıdaki diyagram çok kanallı bildirim sistemi için oluşturulan sınıf yapısını göstermektedir.

```mermaid
classDiagram

class Main {
    +main(String[] args)
}

class BildirimServisi {
    +bildirimGonder(String bildirimTuru, String kullaniciAdi, String mesaj)
}

class BildirimFactory {
    +bildirimKanaliOlustur(String bildirimTuru) BildirimKanali
}

class BildirimKanali {
    <<interface>>
    +bildirimGonder(String kullaniciAdi, String mesaj)
}

class EmailBildirim {
    +bildirimGonder(String kullaniciAdi, String mesaj)
}

class SmsBildirim {
    +bildirimGonder(String kullaniciAdi, String mesaj)
}

class PushBildirim {
    +bildirimGonder(String kullaniciAdi, String mesaj)
}

class SistemGuncellemeBildirim {
    +bildirimGonder(String kullaniciAdi, String mesaj)
}

class BildirimYoneticisi {
    +bildirimGonder(String bildirimTuru, String kullaniciAdi, String mesaj)
}

Main --> BildirimServisi
BildirimServisi --> BildirimFactory
BildirimFactory --> BildirimKanali
BildirimKanali <|.. EmailBildirim
BildirimKanali <|.. SmsBildirim
BildirimKanali <|.. PushBildirim
BildirimKanali <|.. SistemGuncellemeBildirim
