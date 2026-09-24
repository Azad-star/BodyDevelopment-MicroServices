# BODY DEVELOPMENT

Kullanıcıların fiziksel hedeflerine ulaşmalarını sağlamak amacıyla tasarlanmış, yapay zeka destekli ve mikroservis mimarisine dayalı kapsamlı bir backend projesidir. Sistem; kişiye özel egzersiz, beslenme planlaması ve motivasyon odaklı görselleştirme sunar.

## 🏗️ Mikroservis Mimarisi ve İşlevleri

Proje, her biri tek bir amaca odaklanmış ve birbiriyle senkronize çalışan aşağıdaki mikroservislerden oluşmaktadır:

*   🔐 **AuthService (Güvenlik Servisi):** 
    *   Sistemin ana güvenlik kapısıdır.
    *   Kullanıcı kimlik doğrulama (authentication) işlemlerini yürütür.
    *   Ürettiği Access Token'lar (JWT) ile tüm servislerin API güvenliğini sağlar.

*   ⚙️ **ConfigServer (Yapılandırma Merkezi):** 
    *   Merkezi ayar sunucusudur.
    *   Mikroservislerin ihtiyaç duyduğu tüm yapılandırma dosyalarını (şifreler, portlar, URL'ler) server olarak kullanılan GitHub deposundan çeker.
    *   Servislerin en güncel ve ortak ayarlarla sorunsuz şekilde ayağa kalkmasını yönetir.

*   🏋️ **WorkOutNutritionService (Egzersiz ve Makro Planlama):**
    *   Kullanıcının güncel fiziksel durumunu, hedefini (zayıflama, kilo alma, fit kalma) ve odaklanmak istediği kas gruplarını alır.
    *   Kullanıcının günlük spora ayırabileceği zamanı analiz eder.
    *   Bu verilere göre kişiye özel günlük egzersiz planı oluşturur ve alması gereken makro besin değerlerini (karbonhidrat, yağ, protein miktarlarını) net olarak hesaplar.

*   🥗 **MealService (Beslenme ve Öğün Önerisi):**
    *   Kullanıcının bireysel damak zevkini ve yemek tercihlerini tespit eder.
    *   Feign Client üzerinden `UserService` ile haberleşerek kullanıcının fiziksel hedeflerini ve günlük alması gereken makro değerleri çeker.
    *   Hem hedefe hem de kullanıcının damak zevkine uygun, kişiselleştirilmiş günlük yemek listeleri sunar.

*   🤖 **AI Visualization Service (Yapay Zeka Motivasyon):**
    *   Kullanıcıyı motive etmek için tasarlanmış yapay zeka servisidir.
    *   Kullanıcının egzersize başlamadan önceki mevcut fotoğrafını alır.
    *   Gerekli servislerden kullanıcının vücut hedeflerini çeker.
    *   Verilen egzersiz ve diyet planına sadık kalındığında kişinin ulaşacağı fiziksel görünümü yapay zeka ile oluşturur ve kullanıcıya sunar.

## 🚀 Kullanılan Teknolojiler

*   **Backend & Altyapı:** Java, Spring Boot
*   **Mikroservis Mimarisi:** Spring Cloud, Config Server, OpenFeign (Servisler arası iletişim)
*   **Güvenlik:** Spring Security, JWT (JSON Web Token)
*   **Veritabanı & ORM:** PostgreSQL, Spring Data JPA, Hibernate
*   **Yapay Zeka:** Replicate API (Görsel prompt işleme)
*   **Konfigürasyon Yönetimi:** GitHub

---
👨‍💻 **Geliştirici:** Yusuf Ay
