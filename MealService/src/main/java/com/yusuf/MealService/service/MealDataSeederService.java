package com.yusuf.MealService.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.yusuf.MealService.entity.MealCatalog;
import com.yusuf.MealService.enums.FitnessGoal;
import com.yusuf.MealService.enums.MealStyle;
import com.yusuf.MealService.enums.ProteinType;
import com.yusuf.MealService.repository.MealCatalogRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MealDataSeederService implements CommandLineRunner {

    private final MealCatalogRepository mealCatalogRepository;

    @Override
    public void run(String... args) throws Exception {
        
        if (mealCatalogRepository.count() == 0) {
            System.out.println("Veritabanı boş. 150 Çeşitlik dev yemek havuzu yükleniyor...");

            List<MealCatalog> initialMeals = Arrays.asList(

                // ==========================================
                // 1. KAS KAZANIMI (Yüksek Kalori: 600-900 kcal)
                // ==========================================
                
                // KAS KAZANIMI - PRATIK
                new MealCatalog(null, "Fıstık Ezmeli Yulaf Lapası", "Muz ve protein tozu ile zenginleştirilmiş hızlı kahvaltı.", 680.0, 35.0, 90.0, 20.0, FitnessGoal.KAS_KAZANIMI, ProteinType.VEGAN, MealStyle.PRATIK),
                new MealCatalog(null, "Ton Balıklı & Kaşarlı Sandviç", "Spor sonrası hızlı karbonhidrat ve protein kaynağı.", 650.0, 45.0, 70.0, 21.0, FitnessGoal.KAS_KAZANIMI, ProteinType.BALIK, MealStyle.PRATIK),
                new MealCatalog(null, "Kavurmalı Dürüm", "Lavaş arası bol etli, kalorili pratik Türk işi öğün.", 720.0, 40.0, 60.0, 35.5, FitnessGoal.KAS_KAZANIMI, ProteinType.KIRMIZI_ET, MealStyle.PRATIK),
                new MealCatalog(null, "Çift Yumurtalı Hindi Füme Wrap", "Antrenman öncesi enerji patlaması yaratan pratik dürüm.", 610.0, 42.0, 55.0, 24.0, FitnessGoal.KAS_KAZANIMI, ProteinType.BEYAZ_ET, MealStyle.PRATIK),
                new MealCatalog(null, "Cevizli Muzlu Protein Smoothie", "Sıvı formda devasa kalori ve protein.", 600.0, 40.0, 65.0, 20.0, FitnessGoal.KAS_KAZANIMI, ProteinType.VEGAN, MealStyle.PRATIK),
                new MealCatalog(null, "Izgara Somonlu Bagel", "Krem peynirli ve somonlu doyurucu sandviç.", 750.0, 45.0, 75.0, 30.0, FitnessGoal.KAS_KAZANIMI, ProteinType.BALIK, MealStyle.PRATIK),
                new MealCatalog(null, "Dana Rosto Soğuk Sandviç", "Hazır dana rosto ile saniyeler içinde dev öğün.", 700.0, 50.0, 65.0, 26.6, FitnessGoal.KAS_KAZANIMI, ProteinType.KIRMIZI_ET, MealStyle.PRATIK),
                new MealCatalog(null, "Tavuklu Humus Kasesi", "Nohut ve tavuğun muazzam makro birleşimi.", 680.0, 55.0, 60.0, 24.4, FitnessGoal.KAS_KAZANIMI, ProteinType.BEYAZ_ET, MealStyle.PRATIK),
                new MealCatalog(null, "Soya Kıymalı Taco", "Vegan kas inşası için bol karbonhidratlı Meksika lezzeti.", 640.0, 35.0, 80.0, 20.0, FitnessGoal.KAS_KAZANIMI, ProteinType.VEGAN, MealStyle.PRATIK),
                new MealCatalog(null, "Karidesli Noodle Kasesi", "Hızlı pişen noodle ve karidesin yüksek kalorili uyumu.", 710.0, 40.0, 95.0, 18.8, FitnessGoal.KAS_KAZANIMI, ProteinType.BALIK, MealStyle.PRATIK),
                new MealCatalog(null, "Füme Kaburga Ciabatta", "Ekmek arası yüksek yağlı ve proteinli gurme öğün.", 800.0, 45.0, 75.0, 35.5, FitnessGoal.KAS_KAZANIMI, ProteinType.KIRMIZI_ET, MealStyle.PRATIK),
                new MealCatalog(null, "Hindili Makarnalı Salata", "Bol zeytinyağlı, dolaptan direkt yenebilen karbonhidrat.", 670.0, 45.0, 70.0, 23.3, FitnessGoal.KAS_KAZANIMI, ProteinType.BEYAZ_ET, MealStyle.PRATIK),
                new MealCatalog(null, "Fıstık Ezmeli Pilav Köftesi", "Pirinç patlağı ve fıstık ezmesi ile yapılan enerji topları.", 620.0, 20.0, 90.0, 20.0, FitnessGoal.KAS_KAZANIMI, ProteinType.VEGAN, MealStyle.PRATIK),
                new MealCatalog(null, "Uskumru Konserveli Dürüm", "Ton balığına alternatif yüksek omega-3 deposu pratik dürüm.", 690.0, 40.0, 65.0, 30.0, FitnessGoal.KAS_KAZANIMI, ProteinType.BALIK, MealStyle.PRATIK),
                new MealCatalog(null, "Pastırmalı Yumurtalı Tost", "Sabahın efsanevi kalorili ve bol proteinli kurtarıcısı.", 730.0, 45.0, 60.0, 34.4, FitnessGoal.KAS_KAZANIMI, ProteinType.KIRMIZI_ET, MealStyle.PRATIK),
                new MealCatalog(null, "Tavuk Şiş Dürüm", "Hazır lavaş arası dışarıdan da kolay bulunabilen öğün.", 650.0, 45.0, 70.0, 21.1, FitnessGoal.KAS_KAZANIMI, ProteinType.BEYAZ_ET, MealStyle.PRATIK),
                new MealCatalog(null, "Tahinli Pekmezli Yulaf", "Bulking döneminin en temiz ve en yüksek kalorili tatlısı.", 820.0, 25.0, 110.0, 31.1, FitnessGoal.KAS_KAZANIMI, ProteinType.VEGAN, MealStyle.PRATIK),

                // KAS KAZANIMI - IZGARA_KURU
                new MealCatalog(null, "Izgara Tavuk ve Basmati Pirinç", "Klasik vücut geliştirme menüsü.", 650.0, 55.0, 80.0, 12.2, FitnessGoal.KAS_KAZANIMI, ProteinType.BEYAZ_ET, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Fırın Somon ve Tatlı Patates", "Kompleks karb ve kaliteli balık yağı.", 780.0, 45.0, 75.0, 33.3, FitnessGoal.KAS_KAZANIMI, ProteinType.BALIK, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Dana Antrikot ve Fırın Patates", "Kreatin deposu, kas hacmini artıran dev öğün.", 850.0, 55.0, 70.0, 44.4, FitnessGoal.KAS_KAZANIMI, ProteinType.KIRMIZI_ET, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Izgara Tofu ve Kinoa Püresi", "Bitkisel proteinin en doyurucu ızgara hali.", 600.0, 35.0, 75.0, 17.7, FitnessGoal.KAS_KAZANIMI, ProteinType.VEGAN, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Izgara Köfte ve Bulgur Pilavı", "Ev usulü kuru menünün vazgeçilmezi.", 720.0, 45.0, 70.0, 28.8, FitnessGoal.KAS_KAZANIMI, ProteinType.KIRMIZI_ET, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Fırında Bütün Tavuk Baget ve Sebze", "Kemikli etin lezzeti ve bol patatesli karb desteği.", 740.0, 50.0, 65.0, 31.1, FitnessGoal.KAS_KAZANIMI, ProteinType.BEYAZ_ET, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Izgara Levrek ve Mısır Koçanı", "Hem balık proteini hem de tatlı mısır karbonhidratı.", 690.0, 45.0, 80.0, 21.1, FitnessGoal.KAS_KAZANIMI, ProteinType.BALIK, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Seitan Izgara ve Esmer Pirinç", "Buğday gluteni ile yapılan efsanevi vegan ızgara et.", 660.0, 55.0, 85.0, 11.1, FitnessGoal.KAS_KAZANIMI, ProteinType.VEGAN, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Dana Şiş ve Lavaş", "Közlenmiş domates ve bol lavaşla ızgara ziyafeti.", 810.0, 55.0, 80.0, 30.0, FitnessGoal.KAS_KAZANIMI, ProteinType.KIRMIZI_ET, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Hindi Sote Izgara ve Karabuğday", "Tavuğa alternatif beyaz et ve düşük glisemik indeksli karb.", 630.0, 50.0, 75.0, 14.4, FitnessGoal.KAS_KAZANIMI, ProteinType.BEYAZ_ET, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Izgara Karides ve Sebzeli Makarna", "Makarna ve deniz ürününün yüksek kalorili buluşması.", 760.0, 45.0, 100.0, 20.0, FitnessGoal.KAS_KAZANIMI, ProteinType.BALIK, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Soya Soslu Mantar ve Fırın Nohut", "Aşırı doyurucu, etsiz ama protein dolu bir tepsi yemeği.", 620.0, 30.0, 95.0, 13.3, FitnessGoal.KAS_KAZANIMI, ProteinType.VEGAN, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Kuzu Pirzola ve Fırın Sebzeler", "Yüksek hayvansal yağ içeren muazzam bir bulking öğünü.", 890.0, 50.0, 60.0, 50.0, FitnessGoal.KAS_KAZANIMI, ProteinType.KIRMIZI_ET, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Tavuk Bonfile Izgara ve Kuskus", "Kuskus sayesinde çok hızlı tüketilebilen bol karb öğünü.", 680.0, 55.0, 85.0, 13.3, FitnessGoal.KAS_KAZANIMI, ProteinType.BEYAZ_ET, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Fırın Uskumru ve Patates Salatası", "Kilo almak isteyenler için balık yağlı mükemmel seçenek.", 770.0, 45.0, 70.0, 34.4, FitnessGoal.KAS_KAZANIMI, ProteinType.BALIK, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Vegan Burger Menü", "Fırın patates ve bitkisel köfte ile yapılan yüksek kalorili öğün.", 740.0, 35.0, 90.0, 26.6, FitnessGoal.KAS_KAZANIMI, ProteinType.VEGAN, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Biftek Izgara ve Tereyağlı Pirinç", "Eski okul vücut geliştirmecilerin favori güç öğünü.", 830.0, 55.0, 75.0, 35.5, FitnessGoal.KAS_KAZANIMI, ProteinType.KIRMIZI_ET, MealStyle.IZGARA_KURU),

                // KAS KAZANIMI - SULU_YEMEK
                new MealCatalog(null, "Etli Kuru Fasulye ve Pilav", "Türk mutfağının kas yapan devasa klasiği.", 800.0, 45.0, 100.0, 24.4, FitnessGoal.KAS_KAZANIMI, ProteinType.KIRMIZI_ET, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Tavuklu Orman Kebabı", "Patates, havuç ve tavuğun sulu tencere buluşması.", 670.0, 45.0, 75.0, 21.1, FitnessGoal.KAS_KAZANIMI, ProteinType.BEYAZ_ET, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Somon Buğulama ve Ekmek", "Suyuyla beraber tüketilen, ekmek banmalık balık yemeği.", 720.0, 45.0, 65.0, 31.1, FitnessGoal.KAS_KAZANIMI, ProteinType.BALIK, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Bol Sebzeli Yeşil Mercimek Yemeği", "Demir ve karb deposu sulu vegan güveci.", 630.0, 35.0, 95.0, 12.2, FitnessGoal.KAS_KAZANIMI, ProteinType.VEGAN, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Kıymalı Patates Yemeği", "Sulu sulu karbonhidrat ve et proteini.", 710.0, 40.0, 85.0, 23.3, FitnessGoal.KAS_KAZANIMI, ProteinType.KIRMIZI_ET, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Sebzeli Tavuk Haşlama Çorbası", "Bütün tavuk suyuyla yapılmış bol şehriyeli kalori bombası.", 640.0, 45.0, 70.0, 20.0, FitnessGoal.KAS_KAZANIMI, ProteinType.BEYAZ_ET, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Karides Güveç", "Bol kaşarlı ve tereyağlı deniz ürünü güveci.", 760.0, 45.0, 60.0, 37.7, FitnessGoal.KAS_KAZANIMI, ProteinType.BALIK, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Zeytinyağlı Barbunya ve Pilav", "Etsiz olmasına rağmen kas gelişimi için harika bir sulu yemek.", 680.0, 30.0, 100.0, 17.7, FitnessGoal.KAS_KAZANIMI, ProteinType.VEGAN, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Kuzu İncik ve Şehriye", "Ağızda dağılan et ve bol karbonhidrat.", 880.0, 50.0, 70.0, 44.4, FitnessGoal.KAS_KAZANIMI, ProteinType.KIRMIZI_ET, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Hindi Sote ve Erişte", "Kremalı ve mantarlı bol kalorili sulu beyaz et.", 730.0, 45.0, 80.0, 25.5, FitnessGoal.KAS_KAZANIMI, ProteinType.BEYAZ_ET, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Balık Çorbası ve Kızarmış Ekmek", "İlikli kemik suyu tadında ağır ve besleyici çorba.", 650.0, 40.0, 75.0, 21.1, FitnessGoal.KAS_KAZANIMI, ProteinType.BALIK, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Etli Nohut Yemeği", "Kuru fasulyeye alternatif devasa karbonhidrat kaynağı.", 780.0, 45.0, 95.0, 24.4, FitnessGoal.KAS_KAZANIMI, ProteinType.KIRMIZI_ET, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Fasulye Yahnisi", "Bol zeytinyağlı ve salçalı dev porsiyon vegan yahni.", 610.0, 25.0, 90.0, 16.6, FitnessGoal.KAS_KAZANIMI, ProteinType.VEGAN, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Tavuklu Bamya Yemeği", "Sindirimi kolay, bulking döneminde mide rahatlatan yemek.", 600.0, 40.0, 65.0, 20.0, FitnessGoal.KAS_KAZANIMI, ProteinType.BEYAZ_ET, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Fırın Köfte Patates Sulu Yemek", "Tepside bol soslu pişen, pilavla harika giden Türk yemeği.", 820.0, 45.0, 85.0, 33.3, FitnessGoal.KAS_KAZANIMI, ProteinType.KIRMIZI_ET, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Kalamar Yahni", "Sarımsak ve domates soslu deniz ürünü yahnisi.", 690.0, 40.0, 70.0, 27.7, FitnessGoal.KAS_KAZANIMI, ProteinType.BALIK, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Soya Etli Bezelye Yemeği", "Patates ve havuçlu ev yemeğinin vegan adaptasyonu.", 640.0, 35.0, 85.0, 17.7, FitnessGoal.KAS_KAZANIMI, ProteinType.VEGAN, MealStyle.SULU_YEMEK),

                // ==========================================
                // 2. KİLO VERME (Düşük Kalori, Düşük Karb: 200-400 kcal)
                // ==========================================

                // KİLO VERME - PRATIK
                new MealCatalog(null, "Haşlanmış Tavuklu Göbek Salata", "Sıfır karb, bol yeşillik ve hazır protein.", 250.0, 40.0, 8.0, 6.4, FitnessGoal.KILO_VERME, ProteinType.BEYAZ_ET, MealStyle.PRATIK),
                new MealCatalog(null, "Light Ton Balıklı Roka", "Yağı süzülmüş, limonlu hızlı öğün.", 240.0, 35.0, 10.0, 6.6, FitnessGoal.KILO_VERME, ProteinType.BALIK, MealStyle.PRATIK),
                new MealCatalog(null, "Pastırmalı Şekersiz Wasa Atıştırmalığı", "Karbonhidratı sıfıra yakın, yüksek lif.", 280.0, 25.0, 18.0, 12.0, FitnessGoal.KILO_VERME, ProteinType.KIRMIZI_ET, MealStyle.PRATIK),
                new MealCatalog(null, "Tofulu Çörek Otlu Salata", "Sıfır ateş gerektiren, kalorisi çok düşük vegan kurtarıcı.", 220.0, 20.0, 10.0, 11.1, FitnessGoal.KILO_VERME, ProteinType.VEGAN, MealStyle.PRATIK),
                new MealCatalog(null, "Hindi Salamlı Lor Peyniri Kasesi", "Gece acıkmalarını kesen 2 dakikalık kase.", 210.0, 30.0, 5.0, 7.7, FitnessGoal.KILO_VERME, ProteinType.BEYAZ_ET, MealStyle.PRATIK),
                new MealCatalog(null, "Soğuk Karides Salatası", "Donuk karidesle anında hazır edilen lüks diyet yemeği.", 260.0, 30.0, 8.0, 12.0, FitnessGoal.KILO_VERME, ProteinType.BALIK, MealStyle.PRATIK),
                new MealCatalog(null, "Yağsız Dana Rosto ve Kereviz Sapı", "Dolaptan çıkarılıp direkt yenebilen ketojenik.", 310.0, 40.0, 5.0, 14.4, FitnessGoal.KILO_VERME, ProteinType.KIRMIZI_ET, MealStyle.PRATIK),
                new MealCatalog(null, "Chia Tohumlu Soya Yoğurdu", "Bitkisel, doyurucu ve bağırsak çalıştıran diyet öğün.", 230.0, 15.0, 12.0, 13.5, FitnessGoal.KILO_VERME, ProteinType.VEGAN, MealStyle.PRATIK),
                new MealCatalog(null, "Tavuk Jambonlu Marul Dürüm", "Ekmek yerine marul yaprağı kullanılan dürüm.", 180.0, 25.0, 4.0, 7.1, FitnessGoal.KILO_VERME, ProteinType.BEYAZ_ET, MealStyle.PRATIK),
                new MealCatalog(null, "Sashimi ve Soya Sosu", "Pirinçsiz, sadece çiğ balık dilimleri.", 290.0, 35.0, 2.0, 15.7, FitnessGoal.KILO_VERME, ProteinType.BALIK, MealStyle.PRATIK),
                new MealCatalog(null, "Kuru Etli (Jerky) Ara Öğün", "Protein oranı maksimum, karb oranı sıfır.", 250.0, 35.0, 3.0, 10.8, FitnessGoal.KILO_VERME, ProteinType.KIRMIZI_ET, MealStyle.PRATIK),
                new MealCatalog(null, "Avokado ve Kenevir Tohumu", "Veganlar için sağlıklı yağ ve protein atıştırmalığı.", 270.0, 10.0, 8.0, 22.0, FitnessGoal.KILO_VERME, ProteinType.VEGAN, MealStyle.PRATIK),
                new MealCatalog(null, "Haşlanmış Yumurta ve Hindi Füme", "Sporcuların diyet kahvaltısı vazgeçilmezi.", 240.0, 28.0, 2.0, 13.3, FitnessGoal.KILO_VERME, ProteinType.BEYAZ_ET, MealStyle.PRATIK),
                new MealCatalog(null, "Ton Balıklı Salatalık Sandalları", "Salatalığın içi oyularak yapılan ekmeksiz sandviç.", 200.0, 25.0, 5.0, 8.8, FitnessGoal.KILO_VERME, ProteinType.BALIK, MealStyle.PRATIK),
                new MealCatalog(null, "Çiğ Köfte (Etsiz, Lavaşsız)", "Marul arası pratik, bol limonlu bulgur.", 260.0, 8.0, 45.0, 5.3, FitnessGoal.KILO_VERME, ProteinType.VEGAN, MealStyle.PRATIK),
                new MealCatalog(null, "Dana Kavurma (Yağı Süzülmüş) ve Yeşillik", "Buzdolabından hızlıca tüketilen protein.", 320.0, 38.0, 4.0, 16.8, FitnessGoal.KILO_VERME, ProteinType.KIRMIZI_ET, MealStyle.PRATIK),
                new MealCatalog(null, "Soya Fasulyesi (Edamame) Çerezi", "Hızlı, vegan, tuzlu ve bol proteinli çerez.", 190.0, 18.0, 14.0, 6.8, FitnessGoal.KILO_VERME, ProteinType.VEGAN, MealStyle.PRATIK),

                // KİLO VERME - IZGARA_KURU
                new MealCatalog(null, "Yağsız Dana Bonfile ve Kuşkonmaz", "Ketojenik ve çok lüks bir akşam yemeği.", 360.0, 45.0, 5.0, 17.7, FitnessGoal.KILO_VERME, ProteinType.KIRMIZI_ET, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Izgara Somon ve Brokoli", "Karbonhidratsız, sağlıklı yağlı klasik diyet tabağı.", 380.0, 35.0, 10.0, 22.2, FitnessGoal.KILO_VERME, ProteinType.BALIK, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Yağsız Tavuk Şiş ve Izgara Kabak", "Sıfır yağ ile fırınlanmış tertemiz beyaz et.", 290.0, 40.0, 12.0, 9.1, FitnessGoal.KILO_VERME, ProteinType.BEYAZ_ET, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Izgara Tofu ve Mantar", "Vegan ketojenik diyet için fırınlanmış ikili.", 240.0, 25.0, 10.0, 11.1, FitnessGoal.KILO_VERME, ProteinType.VEGAN, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Köfte Izgara (Ekmeksiz) ve Biber", "Kasaptan alınmış, ekmeksiz yoğrulmuş saf et.", 340.0, 35.0, 5.0, 20.0, FitnessGoal.KILO_VERME, ProteinType.KIRMIZI_ET, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Hindi Göğüs Izgara ve Brüksel Lahanası", "Tavuğa göre daha az yağlı alternatif.", 270.0, 38.0, 14.0, 6.8, FitnessGoal.KILO_VERME, ProteinType.BEYAZ_ET, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Levrek Fileto ve Izgara Domates", "Çok hafif, sindirimi çok kolay beyaz balık.", 310.0, 35.0, 8.0, 15.3, FitnessGoal.KILO_VERME, ProteinType.BALIK, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Soya Soslu Seitan Dilimleri", "Düşük karbonhidratlı yapay vegan et ızgarası.", 260.0, 40.0, 15.0, 4.4, FitnessGoal.KILO_VERME, ProteinType.VEGAN, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Dana Külbastı ve Izgara Patlıcan", "Diyette et krizini çözen yağsız ızgara.", 350.0, 42.0, 8.0, 16.6, FitnessGoal.KILO_VERME, ProteinType.KIRMIZI_ET, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Tavuk Burger (Ekmeksiz, Göbek Arası)", "Izgara tavuk köftesinin diyet hali.", 280.0, 35.0, 6.0, 12.8, FitnessGoal.KILO_VERME, ProteinType.BEYAZ_ET, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Izgara Kalamar ve Roka", "Yağda kızartılmamış temiz deniz ürünü.", 290.0, 30.0, 5.0, 16.6, FitnessGoal.KILO_VERME, ProteinType.BALIK, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Izgara Sebze Tabağı ve Keten Tohumu", "Tamamen kalorisiz sebzelerin diyet ızgarası.", 180.0, 8.0, 25.0, 5.3, FitnessGoal.KILO_VERME, ProteinType.VEGAN, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Biftek Izgara ve Izgara Soğan", "Ağır idman günlerinde diyeti bozmayan güç yemeği.", 370.0, 45.0, 10.0, 16.6, FitnessGoal.KILO_VERME, ProteinType.KIRMIZI_ET, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Hindi Şiş Izgara", "Kırmızı et görünümünde beyaz et hafifliği.", 260.0, 35.0, 5.0, 11.1, FitnessGoal.KILO_VERME, ProteinType.BEYAZ_ET, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Uskumru Izgara", "Yağlı balık ama karbonhidrat sıfır, tam diyet işi.", 390.0, 35.0, 0.0, 27.7, FitnessGoal.KILO_VERME, ProteinType.BALIK, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Karnabahar Mantısı (Soya Kıymalı)", "Hamur yerine karnabahar kullanılan zekice diyet yemeği.", 220.0, 20.0, 15.0, 8.8, FitnessGoal.KILO_VERME, ProteinType.VEGAN, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Kuzu Şiş (Yağsız Tarafından)", "Diyette kuzu eti yemenin nadir yollarından biri.", 380.0, 40.0, 2.0, 23.5, FitnessGoal.KILO_VERME, ProteinType.KIRMIZI_ET, MealStyle.IZGARA_KURU),

                // KİLO VERME - SULU_YEMEK
                new MealCatalog(null, "Sebzeli Tavuk Haşlama Çorbası", "Şehriyesiz, patatessiz sadece et ve su.", 220.0, 35.0, 5.0, 6.6, FitnessGoal.KILO_VERME, ProteinType.BEYAZ_ET, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Kıymalı Ispanak Yemeği", "Düşük karbonhidratlı, tok tutan demir deposu.", 280.0, 25.0, 12.0, 14.6, FitnessGoal.KILO_VERME, ProteinType.KIRMIZI_ET, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Sade Balık Çorbası", "Kremasız, unsuz tamamen berrak diyet çorbası.", 250.0, 30.0, 8.0, 10.8, FitnessGoal.KILO_VERME, ProteinType.BALIK, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Zeytinyağlı Kereviz (Şekersiz)", "Porsiyonu kocaman, kalorisi küçücük.", 180.0, 5.0, 25.0, 6.6, FitnessGoal.KILO_VERME, ProteinType.VEGAN, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Etli Lahana Sarması (Bulgursuz)", "İçine sadece kıyma ve baharat konulmuş ketojenik sarma.", 310.0, 30.0, 10.0, 16.6, FitnessGoal.KILO_VERME, ProteinType.KIRMIZI_ET, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Hindi Sulu Köfte", "Tavuk/Hindi kıymasından yağı alınmış sulu yemek.", 270.0, 32.0, 15.0, 9.1, FitnessGoal.KILO_VERME, ProteinType.BEYAZ_ET, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Karidesli Kabak Spagetti", "Makarna yerine kabak kullanılan sulu soslu yemek.", 260.0, 28.0, 12.0, 11.1, FitnessGoal.KILO_VERME, ProteinType.BALIK, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Zeytinyağlı Taze Fasulye", "Klasik diyet ev yemeği.", 200.0, 8.0, 25.0, 7.5, FitnessGoal.KILO_VERME, ProteinType.VEGAN, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Terbiyesiz Sulu Köfte", "Unsuz ve patatessiz direkt köfte haşlaması.", 320.0, 35.0, 8.0, 16.4, FitnessGoal.KILO_VERME, ProteinType.KIRMIZI_ET, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Tavuklu Mantar Sote", "Suyuyla yenen, sıfır yağlı protein deposu.", 240.0, 35.0, 10.0, 6.6, FitnessGoal.KILO_VERME, ProteinType.BEYAZ_ET, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Midye Yahni (Pilavsız)", "Sadece domates sosunda pişen diyet midye.", 280.0, 25.0, 15.0, 13.3, FitnessGoal.KILO_VERME, ProteinType.BALIK, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Börülce Salatası/Yemeği", "Bitkisel protein, diyet lifi, düşük kalori.", 210.0, 15.0, 25.0, 5.5, FitnessGoal.KILO_VERME, ProteinType.VEGAN, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Kemikli Et Suyu Çorbası", "Kolajen deposu, midesi küçülenlere şifa.", 290.0, 30.0, 2.0, 18.0, FitnessGoal.KILO_VERME, ProteinType.KIRMIZI_ET, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Hindi Boyun Haşlama", "Düdüklüde pişen yağsız ve doyurucu tencere yemeği.", 270.0, 38.0, 5.0, 10.8, FitnessGoal.KILO_VERME, ProteinType.BEYAZ_ET, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Somon Buğulama (Yağsız Tencere)", "Sadece balığın kendi yağı ve sebze suyuyla.", 330.0, 35.0, 10.0, 16.6, FitnessGoal.KILO_VERME, ProteinType.BALIK, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Kabak Yemeği", "Su oranı en yüksek, kalori oranı en düşük yemek.", 150.0, 4.0, 20.0, 6.0, FitnessGoal.KILO_VERME, ProteinType.VEGAN, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Kıymalı Karnabahar Yemeği", "Patates yemeğini aratmayan düşük kalorili versiyon.", 280.0, 25.0, 15.0, 13.3, FitnessGoal.KILO_VERME, ProteinType.KIRMIZI_ET, MealStyle.SULU_YEMEK),

                // ==========================================
                // 3. FİT KALMA (Orta Kalori, Dengeli Makro: 400-600 kcal)
                // ==========================================

                // FİT KALMA - PRATIK
                new MealCatalog(null, "Tavuklu Tam Buğday Dürüm", "İş yerinde dengeli ve tok tutan seçim.", 480.0, 35.0, 45.0, 17.7, FitnessGoal.FIT_KALMA, ProteinType.BEYAZ_ET, MealStyle.PRATIK),
                new MealCatalog(null, "Ton Balıklı Kepekli Makarna", "Haşla ve ye! Spor sonrası standart öğün.", 500.0, 35.0, 60.0, 13.3, FitnessGoal.FIT_KALMA, ProteinType.BALIK, MealStyle.PRATIK),
                new MealCatalog(null, "Izgara Köfteli Kepek Sandviç", "Öğle arası için dengeli karb ve protein.", 520.0, 35.0, 45.0, 22.2, FitnessGoal.FIT_KALMA, ProteinType.KIRMIZI_ET, MealStyle.PRATIK),
                new MealCatalog(null, "Falafel ve Kinoa Kasesi", "Veganlar için lifli ve dengeli ara/ana öğün.", 460.0, 20.0, 60.0, 15.5, FitnessGoal.FIT_KALMA, ProteinType.VEGAN, MealStyle.PRATIK),
                new MealCatalog(null, "Hindi Salamlı Fit Pizza", "Lavaş tabanlı, az kaşarlı suçsuz pizza.", 440.0, 30.0, 40.0, 17.7, FitnessGoal.FIT_KALMA, ProteinType.BEYAZ_ET, MealStyle.PRATIK),
                new MealCatalog(null, "Somonlu Poke Bowl", "Avokado ve esmer pirinçli modern kase.", 550.0, 35.0, 50.0, 23.3, FitnessGoal.FIT_KALMA, ProteinType.BALIK, MealStyle.PRATIK),
                new MealCatalog(null, "Kavurmalı Yumurtalı Yulaf", "Tuzlu yulaf sevenler için etli ve yumurtalı ilginç tarif.", 580.0, 35.0, 50.0, 26.6, FitnessGoal.FIT_KALMA, ProteinType.KIRMIZI_ET, MealStyle.PRATIK),
                new MealCatalog(null, "Fıstık Ezmeli Wasa ve Tofu", "Tatlı tuzlu dengesini sağlayan pratik atıştırmalık.", 420.0, 20.0, 45.0, 17.7, FitnessGoal.FIT_KALMA, ProteinType.VEGAN, MealStyle.PRATIK),
                new MealCatalog(null, "Tavuklu Sezar Salata", "Hafif soslu, krutonlu klasik fit salata.", 490.0, 40.0, 25.0, 25.5, FitnessGoal.FIT_KALMA, ProteinType.BEYAZ_ET, MealStyle.PRATIK),
                new MealCatalog(null, "Havyar ve Tam Buğday Kraker", "Lüks, omega-3 zengini ve pratik fit öğün.", 410.0, 25.0, 35.0, 18.8, FitnessGoal.FIT_KALMA, ProteinType.BALIK, MealStyle.PRATIK),
                new MealCatalog(null, "Jambonlu Peynirli Fit Tost", "Kepek ekmeğine yağ sürülmeden yapılan sabah klasiği.", 430.0, 30.0, 40.0, 16.6, FitnessGoal.FIT_KALMA, ProteinType.KIRMIZI_ET, MealStyle.PRATIK),
                new MealCatalog(null, "Soya Sütlü Granola", "Rafine şekersiz, meyveli fit kase.", 450.0, 15.0, 65.0, 14.4, FitnessGoal.FIT_KALMA, ProteinType.VEGAN, MealStyle.PRATIK),
                new MealCatalog(null, "Tavuk Ciğeri Sote (Pratik Dolap)", "Önceden yapılıp dolapta bekleyen bol demirli öğün.", 470.0, 40.0, 15.0, 27.7, FitnessGoal.FIT_KALMA, ProteinType.BEYAZ_ET, MealStyle.PRATIK),
                new MealCatalog(null, "Uskumru Fümeli Tam Buğday Ekmek", "Aç bitir pratikliğinde fit balık öğünü.", 480.0, 35.0, 40.0, 20.0, FitnessGoal.FIT_KALMA, ProteinType.BALIK, MealStyle.PRATIK),
                new MealCatalog(null, "Kıyma Kavurmalı Lavaş Dürüm", "Orta yağlı kıyma ve ince lavaş ile denge.", 540.0, 35.0, 45.0, 24.4, FitnessGoal.FIT_KALMA, ProteinType.KIRMIZI_ET, MealStyle.PRATIK),
                new MealCatalog(null, "Protein Tozlu Yulaf Krep", "Sadece su ve yulafla hazırlanan vegan krep.", 400.0, 30.0, 50.0, 8.8, FitnessGoal.FIT_KALMA, ProteinType.VEGAN, MealStyle.PRATIK),
                new MealCatalog(null, "Tavuklu Çiğ Köfte Dürüm", "Esnaf işi öğünün tavukla hafifletilmiş hali.", 510.0, 30.0, 65.0, 14.4, FitnessGoal.FIT_KALMA, ProteinType.BEYAZ_ET, MealStyle.PRATIK),

                // FİT KALMA - IZGARA_KURU
                new MealCatalog(null, "Fırın Tavuk Baget ve Sebze", "Fırında kendi suyuyla pişmiş dengeli ev yemeği.", 480.0, 40.0, 30.0, 22.2, FitnessGoal.FIT_KALMA, ProteinType.BEYAZ_ET, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Izgara Kasap Köfte ve Bulgur", "Kilo aldırmayan klasik porsiyon.", 530.0, 35.0, 45.0, 23.3, FitnessGoal.FIT_KALMA, ProteinType.KIRMIZI_ET, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Izgara Çipura ve Bol Salata", "Hafif, doyurucu ve standart balık menüsü.", 460.0, 45.0, 15.0, 24.4, FitnessGoal.FIT_KALMA, ProteinType.BALIK, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Fırın Falafel ve Yoğurt", "Kızartılmamış sağlıklı nohut köftesi.", 440.0, 20.0, 55.0, 15.5, FitnessGoal.FIT_KALMA, ProteinType.VEGAN, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Hindi Külbastı ve Fırın Patates", "Orta porsiyon karb ve yağsız et.", 490.0, 45.0, 40.0, 16.6, FitnessGoal.FIT_KALMA, ProteinType.BEYAZ_ET, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Dana Kavurma Izgara", "Döküm tavada mühürlenmiş sade et tabağı.", 550.0, 45.0, 10.0, 36.6, FitnessGoal.FIT_KALMA, ProteinType.KIRMIZI_ET, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Kalamar Izgara ve Tarator", "Hafif soslu sağlıklı ızgara.", 470.0, 30.0, 20.0, 30.0, FitnessGoal.FIT_KALMA, ProteinType.BALIK, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Soya Kıymalı Fırın Mücver", "Unsuz, yulaf unlu fırın mücver.", 380.0, 25.0, 40.0, 13.3, FitnessGoal.FIT_KALMA, ProteinType.VEGAN, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Tavuk Şinitzel (Fırınlanmış)", "Yağda kızarmadan çıtır yapılan fit tavuk.", 510.0, 40.0, 45.0, 18.8, FitnessGoal.FIT_KALMA, ProteinType.BEYAZ_ET, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Kuzu Şiş Izgara ve Lavaş", "2 şiş kuzu ve ince lavaş ile fit porsiyon.", 560.0, 35.0, 35.0, 31.1, FitnessGoal.FIT_KALMA, ProteinType.KIRMIZI_ET, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Mezgit Izgara ve Patates Ezmesi", "Hafif beyaz balık ve karbonhidrat.", 450.0, 35.0, 40.0, 16.6, FitnessGoal.FIT_KALMA, ProteinType.BALIK, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Kestane Kebap ve Tofu Izgara", "Kış aylarının fit ve vegan enerji kaynağı.", 480.0, 20.0, 70.0, 13.3, FitnessGoal.FIT_KALMA, ProteinType.VEGAN, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Tavuk Kanat Izgara (Derisiz)", "Evde mangal tadında ama derisiz fit porsiyon.", 520.0, 35.0, 15.0, 35.5, FitnessGoal.FIT_KALMA, ProteinType.BEYAZ_ET, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Dana Şiş ve Domates Izgara", "Ortalama bir restoranda bulunabilecek en fit seçenek.", 500.0, 45.0, 20.0, 26.6, FitnessGoal.FIT_KALMA, ProteinType.KIRMIZI_ET, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Karides Şiş Izgara", "Hızlı, düşük kalorili ama yüksek proteinli.", 410.0, 35.0, 10.0, 25.5, FitnessGoal.FIT_KALMA, ProteinType.BALIK, MealStyle.IZGARA_KURU),
                new MealCatalog(null, "Fırınlanmış Baharatlı Karnabahar Köftesi", "Vejetaryen ve fit beslenenler için fırın lezzeti.", 390.0, 15.0, 45.0, 16.6, FitnessGoal.FIT_KALMA, ProteinType.VEGAN, MealStyle.IZGARA_KURU),

                // FİT KALMA - SULU_YEMEK
                new MealCatalog(null, "Zeytinyağlı Nohut Yemeği", "Ortalama karbonhidrat, sağlıklı fit sulu ev yemeği.", 420.0, 20.0, 55.0, 13.3, FitnessGoal.FIT_KALMA, ProteinType.VEGAN, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Kıymalı Taze Fasulye", "Ağırlaştırmayan geleneksel anne yemeği.", 380.0, 25.0, 30.0, 17.7, FitnessGoal.FIT_KALMA, ProteinType.KIRMIZI_ET, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Tavuklu Mantar Sote (Orta Yağlı)", "Suyu ekmeğe banmalık fit sote.", 450.0, 40.0, 25.0, 21.1, FitnessGoal.FIT_KALMA, ProteinType.BEYAZ_ET, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Fırınlanmış Sebzeli Levrek Buğulama", "Hafif ve besleyici sulu balık.", 460.0, 40.0, 20.0, 24.4, FitnessGoal.FIT_KALMA, ProteinType.BALIK, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Mercimek Çorbası ve Köfte", "Standart, doyurucu esnaf lokantası fit menüsü.", 540.0, 35.0, 50.0, 22.2, FitnessGoal.FIT_KALMA, ProteinType.KIRMIZI_ET, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Hindi Etli Bezelye", "Tavuğa alternatif, havuç ve patatesli ev yemeği.", 480.0, 35.0, 45.0, 17.7, FitnessGoal.FIT_KALMA, ProteinType.BEYAZ_ET, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Karidesli Domates Çorbası", "Lüks, içimi kolay ve proteinli çorba.", 410.0, 25.0, 30.0, 21.1, FitnessGoal.FIT_KALMA, ProteinType.BALIK, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Soya Kıymalı Kapuska", "Lahana sevmeyenlere sevdirecek fit sulu vegan yemeği.", 370.0, 20.0, 35.0, 16.6, FitnessGoal.FIT_KALMA, ProteinType.VEGAN, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Etli Biber Dolması (Bulgurlu)", "Pirinci azaltılmış, eti bol geleneksel dolma.", 510.0, 30.0, 55.0, 18.8, FitnessGoal.FIT_KALMA, ProteinType.KIRMIZI_ET, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Tavuklu Enginar Yemeği", "Karaciğer dostu, sporcu beslenmesine çok uygun.", 430.0, 35.0, 30.0, 18.8, FitnessGoal.FIT_KALMA, ProteinType.BEYAZ_ET, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Ton Balıklı Domates Soslu Makarna", "Sulu İtalyan sosu ve balığın fit uyumu.", 530.0, 35.0, 65.0, 14.4, FitnessGoal.FIT_KALMA, ProteinType.BALIK, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Zeytinyağlı Pırasa ve Soya Küpleri", "Bağırsak dostu sulu sebze yemeğinin proteinli hali.", 390.0, 18.0, 40.0, 17.7, FitnessGoal.FIT_KALMA, ProteinType.VEGAN, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Dana Haşlama ve Patates", "Havuç ve patatesle pişen, lokum gibi sulu et.", 560.0, 45.0, 40.0, 24.4, FitnessGoal.FIT_KALMA, ProteinType.KIRMIZI_ET, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Sebzeli Hindi Güveç", "Fırında ağır ağır pişen hafif beyaz et güveci.", 470.0, 40.0, 35.0, 18.8, FitnessGoal.FIT_KALMA, ProteinType.BEYAZ_ET, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Palamut Pilaki", "Soğan ve havuçla fırında pişen sulu balık yemeği.", 520.0, 35.0, 30.0, 28.8, FitnessGoal.FIT_KALMA, ProteinType.BALIK, MealStyle.SULU_YEMEK),
                new MealCatalog(null, "Zeytinyağlı Semizotu", "Bulgurlu ve ekşi soslu, yaz aylarının fit sulu yemeği.", 360.0, 12.0, 45.0, 14.4, FitnessGoal.FIT_KALMA, ProteinType.VEGAN, MealStyle.SULU_YEMEK)
            );

            mealCatalogRepository.saveAll(initialMeals);
            
            System.out.println("BAŞARILI: Tam " + initialMeals.size() + " adet çeşitli yemek veritabanına eklendi! Algoritman artık sınır tanımayacak.");
        }
    }
}