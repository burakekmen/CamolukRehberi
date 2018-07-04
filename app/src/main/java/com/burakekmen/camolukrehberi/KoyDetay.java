package com.burakekmen.camolukrehberi;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import com.google.android.gms.ads.*;
import com.google.android.gms.ads.formats.NativeAd;
import com.squareup.picasso.Picasso;

/**
 * Created by Burak on 9.09.2016.
 */
public class KoyDetay extends AppCompatActivity implements View.OnClickListener{

    AdView adView;

    int koySirasi;
    String koyAdi, resimUrl;
    TextView txtKoyAdi,txtKoyDetayIcerik, txtKoyMuhtar, txtKoyNufus;
    Button btnYaziBuyut, btnYaziKucult, btnKonumaGit;
    ImageView imgKoyDetay;

    ArrayList<String> koyIcerik;
    String[][] koyMuhtarveNufusu;
    String[] koyAdlari;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.koydetay);

        Bundle extras = getIntent().getExtras();
        koyAdi = extras.getString("send_string");
        koySirasi = extras.getInt("send_koySirasi");

        elemanlariTanimla();
        onclickTanimla();
        resimCek();
        internetVarmı();
        ekranBoyutuCek();

        yaziIcerigiDoldur();
        yaziIcerigiAl();

    }

    public void elemanlariTanimla()
    {
        txtKoyDetayIcerik = (TextView) findViewById(R.id.txtKoyDetayIcerik);
        txtKoyAdi = (TextView) findViewById(R.id.txtKoyAdi);
        txtKoyMuhtar = (TextView) findViewById(R.id.txtKoyMuhtari);
        txtKoyNufus = (TextView) findViewById(R.id.txtKoyNufus);
        btnYaziBuyut = (Button) findViewById(R.id.btnYaziBuyult);
        btnYaziKucult = (Button) findViewById(R.id.btnYaziKucult);
        btnKonumaGit = (Button) findViewById(R.id.btnKonumaGit);

        adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        imgKoyDetay = (ImageView) findViewById(R.id.imgKoyDetay);

        koyIcerik = new ArrayList<>();
        koyMuhtarveNufusu = new String[27][2];
        koyAdlari = new String[27];
    }


    public void onclickTanimla() {
        btnYaziBuyut.setOnClickListener(this);
        btnYaziKucult.setOnClickListener(this);
        btnKonumaGit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        float yaziBoyutu = txtKoyDetayIcerik.getTextSize();
        Intent i;

        switch (v.getId())
        {
            case R.id.btnYaziBuyult:
                txtKoyDetayIcerik.setTextSize(TypedValue.COMPLEX_UNIT_PX, yaziBoyutu +2);
                txtKoyMuhtar.setTextSize(TypedValue.COMPLEX_UNIT_PX, yaziBoyutu +2);
                txtKoyNufus.setTextSize(TypedValue.COMPLEX_UNIT_PX, yaziBoyutu +2);
                break;

            case R.id.btnYaziKucult:
                txtKoyDetayIcerik.setTextSize(TypedValue.COMPLEX_UNIT_PX, yaziBoyutu -2);
                txtKoyMuhtar.setTextSize(TypedValue.COMPLEX_UNIT_PX, yaziBoyutu -2);
                txtKoyNufus.setTextSize(TypedValue.COMPLEX_UNIT_PX, yaziBoyutu -2);
                break;
            case R.id.btnKonumaGit:
                String s = koyAdi;
                i = new Intent(KoyDetay.this, MapsActivity.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            default:
                break;
        }
    }


    public void yaziIcerigiDoldur()
    {
        koyIcerik.add("Akyapı köyü İlçe merkezine 8 km uzaklıktadır. \n\n Eski adı panlu olup, Kelkit vadisinin kuzeyinde bulunan Berdiya Dağları’nın eteğinde yer almaktadır.\n\n Köyün doğusunda Yeniköy toprakları, batısında Köroğlu Mahallesi, güneyinde Kelkit Çayı, kuzeyinde Alucra İlçe sınırları ve Berdiya Dağları mevcuttur. Berdiya dağları üzerinde iki adet yaylası bulunmaktadır. Engebeli bir araziye sahip olan köyün tarım sahası olarak kullanılabilen tarım arazisi azdır.\n\n Akyapı köyü merkez olarak Bayramlı, Aydınlı, Çarşılı, Göğüşgil ve Ellezli mahallelerinden oluşmaktadır.");
        koyMuhtarveNufusu[0][0] = "Şenel BAŞKAN";
        koyMuhtarveNufusu[0][1] = "138";

        koyIcerik.add("Bayır Köyü İlçe merkezine 17 km. uzaklıkta olan Bayır Köyü, Kelkit Çayı’nın hemen kenarında yerleşmiştir. Kuruluşunun yaklaşık 300 yıl öncesi bulunmaktadır.\n\n Bayır köyünde Akdere, Aynacı, Aydın, Ceviz, Coşkun, Kaynak, Caniklioğlu, Çatal, Çevik, Coştu, Değirmenci, Demir, Demirhan, Demirkaya, Dikmen, Elönü, Emiroğlu, Gencer, Göç, Gönültaş, Hdıroğlu, İşcan, Kabaktepe, Kaçamaz, Karahasanoğlu, Karakaya, Kasap, Kelmehmetoğlu, Kuruçay, Kuşçul, Macaroğlu; Mıhçı, Özdemir, Recepoğlu, Rıdvanoğlu, Soğukpınar, Şaban, Şiman, Solak, Tarlacı, Temircioğlu, Temizkan, Tezel, Topal, Üzümcü, Yaylıcak gibi soy isim ve sülaleler bulunmuktadır.");
        koyMuhtarveNufusu[1][0] = "Ahmet ELÖNÜ";
        koyMuhtarveNufusu[1][1] = "187";

        koyIcerik.add("Çakılkaya Köyü ilçe merkezine 15 km. mesafede olup ilçenin kuzey doğusunda yerleşmiştir.İlçenin eski köylerinden birisidir. Çamoluk-Alucra Karayolu üzerinde olup, yol üzerindeki en son köyümüzdür.\n\n" +
                "Çakılkaya köyü; Kömürcü, Setbaşı, Yeni armut mahallerinden oluşmaktadır. Köyde yerleşik 80 civarında hane mevcuttur\n\n" +
                "Yaz aylarında İstanbul’dan köye akın görülür. Kış aylarında ise nüfus biraz daha azdır. \n\nKöyde, Bentürk, Beysal, Birol, Caniklioğlu, Dizdar, Fenerci, Safi, Gülen, Gür, Karayılan, Kasımoğlu, Kabeddinoğlu, Kulaoğlu, Küpücü, Lortoğlu, Mühürcü, Nalcıoğlu, Rızvanoğlu, Sarıkaya, Serttufan, Suşehrili, Tamzaralı, Tektaş, Türen, Vural, Yetimova gibi soyadı ve kabileler yaşamaktadır.\n\n" +
                "Çakılkaya Köyü’ %80’e alanı orman, yaylalar ve kırsal alanlardır. Çevresinde doğuda Karadikmen ve Köklüce köyleri, batısında Kayacık ve Taşçılar köyleri, güneyinde Hacıören Köyü ve kuzeyinde Alucra ilçesine bağlı Arda Köyü vardır.\n\n Ormanları, yaylaları ve piknik yerleri gezilip görülmeye değer olan Çakılkaya Köyü ‘nün ayrıca camisinin iç süsleme, fayans ve çinicilik sanatı yönünden de bölgede iddialıdır.");
        koyMuhtarveNufusu[2][0] = "Yılmaz TAMZARALI";
        koyMuhtarveNufusu[2][1] = "118";

        koyIcerik.add("Kuruluşu 1950'li yıllara dayanan Daldibi Köyü, Çamoluk ilçe merkezine 17 km. mesafede bulunmaktadır. İlçenin doğu kesiminde yer almaktadır.\n\n 1950 li yılların öncesinde Pınarlı Köyüne bağlı bir mahalle iken , buradan ayrılarak köy statüsü kazanmıştır. Coğrafi bakımdan küçük gözüken köy topraklarının düzlük alanları geniştir.\n\n Köyün doğusunda Usluca Köyü, Bakısında Gücer,kuzeyinde Kelkit Çayı ve güneyinde Pınarlı Köyü toprakları vardır. \n\nDaldibi köyünde ; Ahurcu, Akçin, Çalıkaner, Çubuğuuzun, Derebaşı, Feraset, Gürbüz, Özveri, Sütçü, Şahbaz gibi soyadlı sülaleler kayıtlı olup, bunların bir çoğu köyü terketmişlerdir. \n\nKöyün Çimen Dağında yaylası ve ormanı bulunmaktadır. Toprakları tarımsal alana elverişli olup, genelde susuz olduğundan buğday, arpa ve fiğ üretimi yapılmaktadır.");
        koyMuhtarveNufusu[3][0] = "Kamil AKÇİN";
        koyMuhtarveNufusu[3][1] = "22";

        koyIcerik.add("Eğnir köyü ilçe merkezinin batısında yer alıyor. İlçe merkezine 13 km. mesafededir. Kelkit Çayı’nın kuzey kısmından itibaren sınırları başlayıp, Alucra İlçe sınırlarına kadar uzanır. Köyün doğusunda Hacıahmetoğlu Köyü. Batısında Ozan Köyü, güneyinde Kelkit Çayı Kuzeyinde Alucra ilçe sınırları ve yaylalarla çevrilidir. Coğrafi yönden şirin bir köydür. Köy Yesirli ve Habilli mahallelerinden oluşmaktadır. \n\n Köyün kuruluşu eskilere dayanmaktadır. Gümgüm mağarası (Gümgüm deresi) Sülüklü, Göl, Görpe Dede isminde ziyaret mevcuttur. Gümgüm mağarasında define olduğu sölentileri yaygındır.\n\nEğnir köyünde , Yesir, Alkan, Sandıkçı, Yalnızoğlu, Sapan, Arıcan, Sunar ve Olkun sülale ve soyadlarında haneler bulunmaktadır. Ayrıca Ağırtap, Ceylanoğlu, Gürel, İnç, Özcan gibi soy isim taşıyan hanelerin tamamı köyde oturmaktadır Köyde yerleşik nüfus tarım ve hayvancılıkla geçimini sürdürmektedir.  Toprakları olursak zıraate oldukça elverişlidir. \n\nKöyün kuzeyinde bulunan dağlık kısmı bir kenera bırakacak olursak, merkez ve güney kısmında Kelkit Çayı’na kadar olan arazide sulu ve susuz tarım yapılmaktadır.\n\n Susuz tarım alalarında başta buğday olmak üzere arpa ve fiğ tarımı yapılır. Sulu arazilerde ise sebzelerin hemen hemen her çeşidi üretilmekte olup, ticari değere sahip olanları domates, salatalık, fasulye, biber, patlıcan olarak sınıflandırılabilir. Meyve türlerinden ceviz, elma, kayısı, şeftali, vişne, dut gibi meyveler bulunmaktadır. Ayrıca kavak dikimi ve üretimi alanında önemli bir yere sahiptir. Köyün konumu,suyu ve toprağı seracılığa ve turfanda sebzeciliğe müsaittir.");
        koyMuhtarveNufusu[4][0] = "Ekrem SAPAN";
        koyMuhtarveNufusu[4][1] = "115";

        koyIcerik.add("Fındıklı Köyü ilçe merkezinin batısında yer alır. İlçeye 8 km. Mesafede bulunmaktadır. Kelkit Çayı’nın güneyinde yer almakta olup, köyün kurulusu çok eskilere dayanır. Fakat son yıllarda eski yerleşim yerine heyelan vurması nedeniyle 1 km. batısında Kelkit Çayı kenarındaki yeni yerleşim yerine taşınmıştır.\n" +
                "\n" +
                "Köyün kuruluş yerinin bati kısmında eski Rum mezarlığı olduğu, buranın eskiden yerleşim yeri oldu söylenmektedir. \n" +
                "\n" +
                "Fındıklı Köyünde Arabul, Aracı, Binici, Aykırı, Kasar, Yıkın, ve Zorbacı soy isim ve sülaleleri mevcut olup, Binici ailesinin Yusufeli Köyünden geldiği söylenir.\n" +
                "\n" +
                " Engebeli bir arazi yapısına sahiptir. Köyün yeni kurulmuş olduğu alan kısmen düzlüktür. Köyün doğusunda Yusufeli Köyü, güneyinde kısmen Yusufeli ve Koçak Köyü sınırları ve kuzeyinde Kelkit Çayı ile çevrilidir. \n" +
                "\n" +
                "Toprak bakımından Çamoluk’un en küçük arazi alanlarından birini teşkil etmesine rağmen tahıl cinsinden tarıma oldukça elverişlidir. Fındıklı Köyü yeni yerleşim yeri ve göller mahallesinden ibarettir. \n" +
                "\n" +
                "Köyde yasayan yerli halkın geçim kaynağı tarım ve hayvancılığa dayanır. Toprakları tahıl üretimine çok elverişlidir. Toprak buğday ve arpa için oldukça verimlidir. Ayrıca sulu tarım alanlarında domates, fasulye, biber, patates, salatalık, patlıcan üretimi yapılarak ilçe pazarında pazarlanmaktadır. \n" +
                "\n" +
                "Hayvancılıkta yapılan köyde son yıllarda modern hayvan bakimi için anırlar yapılmıştır. Genelde kurbanlık için hayvan beslenmektedir. Fındıklı’da elma, kayısı ve ceviz meyveleri de yetiştirilmektedir.");
        koyMuhtarveNufusu[5][0] = "Halit ARABUL";
        koyMuhtarveNufusu[5][1] = "49";

        koyIcerik.add("Pınarlı Köyüne bağlı iken İçişleri Bakanlığının 11.09.1993 tarihli oluru ile bu köyden ayrılarak bağımsız bir köy haline gelen Gücer Köyü, ilçenin en yeni köyüdür. \n\n" +
                "Muhtarlık seçimleri 27.3.1997 tarihinde yapılmış ve köy idaresine bu tarihten itibaren geçirilmiştir. Köyün kuruluşu ile ilgili yapılan referandumda kullanılan 99 oyun 88 i evet şeklinde gerçekleşmiştir. \n\n" +
                "Yeni kurulan bu köyümüz Çamoluk-Gölova karayolu üzerinde bulunmakta olup, İlçe Merkezine Uzaklığı 11 km uzaklıktadır.  \n\n" +
                "Kelkit Çayının kolları arasında, Seme deresinin hemen doğu kenarında kurulmuştur. Köyün doğusunda Daldibi ve Usluca köy sınırları, batısında Seme deresi Çayı, güneyinde Pınarlı ve Kaynar köyleri, kuzeyinde Kelkit Çayı ile çevrilidir. \n\n" +
                "Köyün yerleşim yeri Gücer Köyü içerisinden geçen dere kenarında olup, son yıllarda Kelkit Çayı ve Seme deresi havzalarında yerleşim yapılmaktadır. Karayolu boyunca yapılaşma ve kümeleşme gün geçtikçe yaygınlaşmaktadır. \n\n" +
                "Köyde Çalakel, Kalebaşı ve Akmaz aileleri yaşamakta olup, Çubuğuuzun soy ismini taşıyan haneler göç etmişlerdir. \n\n" +
                "Gücerde dereden akan kaynak suyun yanı sıra Kelkit ve Seme deresi çaylarından da az miktarda faydalanmaktadır.\n\n" +
                "Köy Karabudaklı, Sucalı ve Merkez mahallelerinden oluşmaktadır.");
        koyMuhtarveNufusu[6][0] = "Celal ÇOLAKEL";
        koyMuhtarveNufusu[6][1] = "124";

        koyIcerik.add("Gürçalı Köyü, Çamoluk sınırlarının batısında bulunmaktadır. İlçe merkezine 24 km. mesafededir. \n\n" +
                "Köyün kuruluşu çok eskilere dayanmaktadır. \n\n" +
                "Coğrafi bakımdan engebeli bir araziye sahiptir. \n\n" +
                "Köyün doğusunda Ozan ve kısmen Eğnir köyü sınırları, batısında Şebinkarahisar ilçesi Ocakbaşı köyü, güneyinde Sarpkaya ve Bayır köyleri, kuzeyinde Alucra ilçesi Kabaktepe Köyü bulunmaktadır. \n\n" +
                "Gürçalı Köyünü Orta, Karabaşolu, Osmanlı, Dilenci, Fazlıoğulları, Hacıözü, İbacoğulları mahallesi oluşturur. \n\n" +
                "Mevcut arazinin ancak % 20'si tarım alanında kullanılabilmektedir.");
        koyMuhtarveNufusu[7][0] = "Veli DÜZTAŞ";
        koyMuhtarveNufusu[7][1] = "156";

        koyIcerik.add(" Adını kurucusu bulunan Hacıahmet’ten alan köy, Çamoluk ilçe merkezinin batı kısmında bulunmakta ve ilçe merkezine 12 km. mesafededir. \n" +
                "\n" +
                "Engebeli bir arazi yapısına sahip olan köyün doğusunda Köroğlu Mahallesi, batısında Eğnir Köyü, güneyinde Kelkit çayı ve kuzeyinde Berdiya Dağları’na kadar uzanmaktadır. Köy merkezi Berdiya dağı eteklerinde kurulmuştur.  \n" +
                "\n" +
                "Hacıahmetoğlu köyünde Ayan, Beyaz, Bulutçu, Çulhaoğlu, Cebecioğlu, Ekinci,Kelleci, Keskinel, Kırkgöz, Koyuk, Keflioğlu,Mest, Mesüm, Oyuk, Tekoğlu, Türkmenoğlu, Uyartı, Yardımcı, Yenici, Çaputlu,Keleş, Cem, soy isim ve kabileleri mevcut olup, bu sülalelerin birçoğu köyü terk etmiştir. \n" +
                "\n" +
                "Köyde Avarah Kalesi adıyla tarihi bir kale bulunmakta olup, Kalenin Avarlar zamanında yapıldığı söylenmektedir.\n" +
                "\n" +
                "Ayrıca köyde Kaledede ve Koçudede adıyla bilinen yatırlar bulunmaktadır. İlçenin her köyünden buralara çeşitli amaçlarla ziyaretler yapılmaktadır. Köyde 230 senelik bir cami de vardır.");
        koyMuhtarveNufusu[8][0] = "Dursun EKİNCİ";
        koyMuhtarveNufusu[8][1] = "154";

        koyIcerik.add("1950’li yıllarda Kaledere Köyü’ne bağlı bir mahalle iken buradan ayrılarak bağımsız köy haline gelen Hacıören Köyü, Çamoluk ilçe merkezine 8 km uzaklıktadır. \n" +
                "\n" +
                "Hacıören Köyü Çamoluk-Alucra yolu üzerinde bulunan sağlı sollu iki dereye yerleşmiştir. Merkezi Kaledere Köyü üzerindeki dere içerisinde olup, yolun solunda kalan Alısızlar mahallesiyle Hacıören köyünü oluşturmuştur.\n" +
                "\n" +
                "Köyde Cebeci, Demirci, Kürkçü, Dindar, Maraşlı, Nazlı, Türkmenli soy isim ve sülaleler yaşamaktadır. \n" +
                "\n" +
                "Hacıören Köyü, doğsunda Kaledere ve Karadikmen köyleri, bakısında Kutluca köyü, güneyinde Kılıçtutan ve kuzeyinde Taşçılar ve Çakılkaya köyleri ile çevrilidir. Köy engebeli bir araziye sahiptir. Köyde elma, armut, dut ve kayısı ağaçları da bulunmaktadır.\n" +
                "\n" +
                "Ayrıca kavak ağacı bol miktarda yetiştirilmektedir.");
        koyMuhtarveNufusu[9][0] = "Yaşar NAZLI";
        koyMuhtarveNufusu[9][1] = "56";

        koyIcerik.add("Kaledere köyü ilçe merkezinin doğusunda yer almakta olup, ilçe merkezine 10 km uzaklıktadır. \n" +
                "\n" +
                "Adını bu köyde bulunan tarihi kale ve yerleşim yeri itibariyle de dere içerisinde bulunmasından almıştır. Köyün kuruluş tarihi eskilere dayanmaktadır. \n" +
                "\n" +
                "Bilindiği gibi dere içerisinde yerleşmiş köyün, doğusunda Karadikmen ve Usluca köyü sınırları, batısında Kutluca ve Kılıçtutan köyü sınırları güneyinde Kelkit Çayı, kuzeyinde Hacıören Köyü bulunmaktadır. \n" +
                "\n" +
                "Köy tek merkezde olup, mahallelere bölünmemiştir.  Kelkit Çayı kenarında bulunan Sürmebükü adıyla meşhur bir mesire yeri bulunmaktadır. \n" +
                "\n" +
                "İlçe pazarına sebze türlerinin hemen hemen hepsi bu köylüler tarafından getirilerek ticareti yapılmaktadır. Köyde meyve ağacı da bol miktarda bulunmaktadır. Bunları elma, armut, kayısı, dut gibi meyve teşkil eder.");
        koyMuhtarveNufusu[10][0] = "Zafer KALELİ";
        koyMuhtarveNufusu[10][1] = "156";

        koyIcerik.add("  Karadikmen Köyü ilçe merkezine 15 km uzaklıkta olup, ilçenin kuzey doğusunda yer almaktadır. \n" +
                "\n" +
                "Dört tarafı dağlarla çevrili köy toplu halde bir yerleşim biriminden ibarettir. Köy sınırlarının doğusunda ve kuzeyinde Şiran İlçe sınırları mevcuttur. Güneyin Yenice Beldesi, Usluca ve Kaledere köy sınırları, batısında Kaledere, Hacıören ve Çakılkaya köyleri’nin sınırları bulunmaktadır. \n" +
                "\n" +
                "Köyün kuruluş tarihi eskilere dayanır. Köyün adını hemen kuzey tarafında bulunan dikmen tepesinden aldığı söylenir.\n" +
                "\n" +
                "Karadikmen’nin önceleri Erzurum sancağına bağlı olduğu, tarihi Otlukbeli Savaşı’nın savaş alanı içerisinde kaldığı söylenir. \n" +
                "\n" +
                "Karadikmen ilçenin toplu ve en kalabalık köylerinden biridir. \n" +
                "\n" +
                "Köyde Şapaloğlu, Alioğlu,Cingöz, Gödek, Müminoğlu, Tonbul, Yetimova, Zorbay soy isim ve sülaleleri yaşamaktadır. \n" +
                "\n" +
                "Köyde hayvancılık ferdi üretimi karşılamak amacıyla yapılmaktadır. Genelde süt sığırcılığı yapılır. Buna rağmen yerli ırk 1500 kadar sığır koyun beslenmektedir. Ayrıca arıcılıkla da iştigal edenler bulunmaktadır. Köyün ormanı ve yaylası bulunmaktadır. \n" +
                "\n" +
                "Diğer köylerimizde hemen hemen terk edilmiş olan yaylacılık burada etkinliğini korumaktadır. Karadikmen Köyü’nde Anadolu kültürü hâkimdir. Köy halkı misafirperver olup, adetlere, gelenek ve göreneklere tavizsiz bağlılığı burada görmek mümkündür.");
        koyMuhtarveNufusu[11][0] = "Abdullah ŞAPALOĞLU";
        koyMuhtarveNufusu[11][1] = "265";

        koyIcerik.add("Kayacık yerleşik nüfus bakımından ilçenin en küçük köyüdür. İlçe merkezine 18 km uzaklıkta olan Kayacık Köyü Berdiya Dağları eteklerine kurulmuş olup, yayla görünümündedir. Engebeli arazi yapısına sahiptir. \n" +
                "\n" +
                "Kayacık Köyü’nün doğusunda Çakılkaya köyü sınırları, batısında ve güneyinde Taşçılar Köyü sınırları,kuzeyinde ise Alucra İlçe sınırları bulunmaktadır.\n" +
                "\n" +
                "Köyün arazisi tarım için elverişli değildir. Rakımın yüksek oluşu nedeniyle sebze üretimi yok denecek kadar azdır. Ancak susuz tarım yapılabilmektedir. Bunlardan buğday ve arpa yetiştirilmektedir. \n" +
                "\n" +
                "Köyde nüfus kütüğünde kayıtlı Abdal, Bakar, Budal, Çapraz, Çayoğlu, Deliboran, Kelketli, Özçelik, Pirdal, Senemoğlu, Türkavcı sülaleleri bulunmakta olup, bunların çoğu köyü terk etmiştir. Köyde yıkık bir tarihi kilise mevcuttur.");
        koyMuhtarveNufusu[12][0] = "Kadir TÜRKAVCI";
        koyMuhtarveNufusu[12][1] = "44";

        koyIcerik.add(" Kuruluşu eskilere dayanan ve ilçemizin güney doğusunda yer alan Kaynar Köyü’nün ilçe merkezine uzaklığı  14 km’dir. \n" +
                "\n" +
                "Kaynar Köyü’nün doğusunda Pınarlı, batısında Seme Deresi, güneyinde Erzincan’ın Refahiye İlçe sınırı, kuzeyinde ise Gücer Köyü yer almaktadır.");
        koyMuhtarveNufusu[13][0] = "Yalçın MÜNÜKLÜ";
        koyMuhtarveNufusu[13][1] = "126";

        koyIcerik.add(" Kılıçtutan Köyü ilçenin kuzeydoğusunda yer almakta olup, ilçenin merkezine 7 km mesafede bulunmaktadır. \n" +
                "\n" +
                "Köyün kuruluş tarihi eskilere dayanmaktadır. \n" +
                "\n" +
                "Yerleşim alanı meyilli arazi üzerine oturtulmuştur. Kılıçtutan Köyü merkez ve Hüseyinağa Deresi mahallesinden oluşmaktadır. Köyün doğusunda Kaledere Köyü, batısında Dulundas Köyü, güneyinde Kelkit Çayı ve kuzeyinde Kutluca ve Dulundas köy sınırları bulunmaktadır. Köy arazisinin 1/3 ü ormanla kaplıdır.\n" +
                "\n" +
                "Ormanlarda genellikle meşe ağacı bulunmaktadır. Geri kalan arazisi tarıma elverişlidir. \n" +
                "\n" +
                "Köy nüfus kütüğüne kayıtlı Ağzıkuru, Aydın, Değirmencioğlu, Duvarbaşı, Karacaoğlu, Karamub, Kop, Köycü, Melikoğlu, Nazlı, Nemli, Sözver, Şanlı, Türkmen, Varıcı, Yılkın, Lafçı soy isimleri bulunmakta olup, köyde çoğunlukla Varıcı kabilesi, ayrıca Ağzıkuru, Duvarbaşı, Köycü ve Yılkın sülaleleri oturmaktadır.\n" +
                "\n" +
                "Yerleşik nüfus başta hayvancılık olmak üzere tarım işlerinde uğraşmaktadır. Köyde hayvan besiciliği yapan 5 adet modern ahır bulunmaktadır. Bunun dışında her aile küçük çaplı da olsa hayvan besiciliği yapmaktadır. \n" +
                "\n" +
                "Kılıçtutan köyünün geçim kaynağı sığır besiciliğine dayanmaktadır. Köyde meyve türlerinden elma ve dut ağacı bol miktarda bulunmaktadır. Ancak ticari değeri bulunmamaktadır.");
        koyMuhtarveNufusu[14][0] = "Ahmet VARICI";
        koyMuhtarveNufusu[14][1] = "142";

        koyIcerik.add("Eski yerleşim birimi Kelkit Çayı’nın güneyinden başlayan dik yamaçların eteğinde kurulan Koçak Köyü, İlçe merkezine uzaklığı  10 km’dir.\n" +
                "\n" +
                "Çamoluk İlçe merkezinin güneybatısında yer almakta iken heyelan olayı nedeniyle bu yerleşim yeri terk edilerek Kelkit Çayı’nın kıyısında bulunan bağlara taşınmıştır. \n" +
                "\n" +
                "Nüfus kütüğüne kayıtlı Ağırlıklı olarak Yalçınkaya, Çifci soy isimleri mevcuttur.\n" +
                "\n" +
                "Kuruluşu eski tarihlere dayanan bu köyün yeni yerleşim yeri çok yenidir.");
        koyMuhtarveNufusu[15][0] = "Lokman YALÇINKAYA";
        koyMuhtarveNufusu[15][1] = "101";

        koyIcerik.add("İlçe merkezine 9 km uzaklıkta olan Kutluca köyü Kelkit vadisinin kuzey yamaçlarında kurulmuş olup köyün yerleşim alanı meyilli bir arazi üzerindedir. \n" +
                "\n" +
                "Batısı, Kuzeyi ve Doğusu olmak üzere üç tarafı tepelerle çevrili olup güneyi açıktır. Birbirine yakın yapılmış binalarla toplu bir yerleşim yeridir. \n" +
                "\n" +
                "Köyümüz, doğuda Kayacık ve Taşcılar, Kaledere, Hacıören; güney-güneybatsında Kılıçtutan; batıda Dulundas, Yeniköy; kuzeyinde ise Alucra ilçesine bağlı Çamlıyayla köyleri ile çevrilidir. \n" +
                "\n" +
                "Kuruluş tarihi, tam olarak bilinmemekle beraber, köyün çevresindeki yatırların menkıbelerinden anlaşıldığı kadarıyla Fatih Sultan Mehmet dönemine kadar gitmektedir. \n" +
                "\n" +
                "Yöremizin, Fatih Sultan Mehmet’in 1461 Trabzon seferiyle Osmanlı sınırlarına katıldığını düşünecek olursak kuruluş tarihini XV. asrın ikinci yarısına kadar götürebiliriz. \n" +
                "\n" +
                "Köyün ilk kurulduğu yer bugün “Pasman” diye adlandırılan mevkiidir. Köy daha sonraları buradan “Çukurtarla” mevkiine taşınmıştır.");
        koyMuhtarveNufusu[16][0] = "Raşit DUVARBAŞI";
        koyMuhtarveNufusu[16][1] = "226";

        koyIcerik.add("İlçe merkezine 26 km uzaklıkta olan Okçaören köyü İlçenin doğusunda bulunmaktadır olup, Gümüşhane ve Erzincan illeri ile sınırdır.");
        koyMuhtarveNufusu[17][0] = "Hasan MALLI ";
        koyMuhtarveNufusu[17][1] = "49";

        koyIcerik.add(" İlçe merkezine 15 km uzaklıkta olan Ozan Köyünün kuruluşu eskilere dayanan köylerimizden biridir. Adını nereden aldığı bilinmemektedir.\n" +
                "\n" +
                "Coğrafi olarak engebeli bir arazi yapısına sahiptir. Kelkit Çayı’nın kuzey kısmından itibaren sınırları başlar ve berdiya dağı yamaçlarına kadar devam eder.\n" +
                "\n" +
                "Ozan Köyü’nün doğusunda; Eğnir Köyü, batısında Gürçalı ve Bayır köyleri, güneyinde Kelkit Çayı, kuzeyinde Berdiya Dağları’nın yayla sınırları bulunmaktadır.\n" +
                "\n" +
                "Ozan Köyü nüfus kütüğünde Altun, Arapbeşiroğlu, Aykut, Bulutçu, Çolak, Karkaşoğlu, Kürtoğlu, Sipahi, Tan, Tülleoğlu, Yılmazoğlu, Yucatur gibi soy isim ve kabileler kayıtlıdır. \n" +
                "\n" +
                "Köyün tarımsal alanı az olmakla birlikte mevcut ekilebilir alanları tarıma elverişlidir. Suyu boldur. Buna rağmen sulu tarım arazisinin azlığı nedeniyle ticari değere sahip pek önemli gelir elde edilmemektedir. \n" +
                "\n" +
                "Sulu tarım arazilerinde domates, fasulye, biber, salatalık ve diğer sebze türlerinin hemen tamamı yetiştirilir. Susuz tarım alanlarında ise buğday, arpa ve fiğ gibi tahıl cinsi bitkiler ekilmektedir. \n" +
                "\n" +
                "Köyün arazisi kavak ağacı yetiştiriciliğine elverişlidir. Bunun dışında köyde her türlü meyve yetiştirilmektedir. \n" +
                "\n" +
                "Ozan’ın görülmeye değer şelalesi, efsanelerle anlatılan Gelinkaya’sı, Berdiya Dağları’nın oluşturduğu dik kayalıklar ilgi çekicidir.");
        koyMuhtarveNufusu[18][0] = "Turan ÇOLAK";
        koyMuhtarveNufusu[18][1] = "70";

        koyIcerik.add(" İlçe Merkezine 14 km uzaklıkta olan pınarlı köyü, Çamoluk ilçe merkezinin güneydoğusunda yer almaktadır. \n" +
                "\n" +
                "Genelde engebeli arazi yapısına sahip olan köyün yerleşim alanı nisbeten düzgündür.\n" +
                "\n" +
                " Köyün doğusunda Usluca köyü, batısında Kaynar köyü, güneyinde Erzincan ili Refahiye ilçe sınırları, kuzeyinde ise Gücer ve Daldibi köyleri bulunmaktadır.\n" +
                "\n" +
                " Merkez ve Hotar mahallesinden oluşan Pınarlı Köyü iki mahalleden ibarettir. Daha önceleri Gücer Köyü’nün de bağlı bulunduğu sıralarda nüfusu hayli kalabalık olan köyün Gücer’in 1993 yılında ayrılmasıyla nüfusu da bu oranla azalmıştır. \n" +
                "\n" +
                "Köy Hotar mahallesi ile birlikte 80 haneden ibarettir. 1990 nüfus sayımına göre köyün nüfusu 270’dir. Yaz aylarında nüfus hareketi artar. \n" +
                "\n" +
                "Çamoluk merkezine 15 km uzaklıkta bulunan köyün ulaşım problemi bulunmamaktadır. Ancak Hotar mahallesinin kış aylarında zaman zaman yollarının kapandığı görülmektedir. \n" +
                "\n" +
                "Köyde Canik, Söğüt, Şerbetçi, Kalebaşı, Çombaş, Harap, Kurt, Ağbulut, Örmeci, Çambel, Ağaç, Aybar. Aydın, Ayvalıoğlu, Bekiroğlu, Bozkurt, Bozyüz, Çekmez, Gevrek, Gülpınar, Kasımoğlu, Katrancı, Kekeç, Koşucu, Kumcu, Kuş, Küçükaslan, Özlem, Tayyar, Yılmaz gibi soy isim ve kabileleri nüfusa kayıtlıdır. \n" +
                "\n" +
                "Hotar mahallesinde tarihi kale kalıntısı vardır. Ancak harabe olmuştur.");
        koyMuhtarveNufusu[19][0] = "Kadir ŞERBETÇİ";
        koyMuhtarveNufusu[19][1] = "117";

        koyIcerik.add(" Adından da anlaşılacağı gibi sarp kayalar üzerine kurulan ve ilçemize 20 km uzaklıkta olan  Sarpkaya Köyü, ilçe merkezinin batısında ve en uç köydür. \n" +
                "\n" +
                "Köyün tarihi gelişimi ile çeşitli söylentiler olmasına rağmen, köyün tarihi ile ilgili kesin bilgiler bulunmamaktadır. Ancak köyde bulunan tarihi Bektaş Bey Camii ile ilgili geniş açıklama ilçenin tarihçesi bölümünde yer almıştır.\n" +
                "\n" +
                " Köyde ayrıca eski dönemlerden kalma darphane kalıntısı olduğu söylenmektedir.");
        koyMuhtarveNufusu[20][0] = "Adil GÜNGÖR";
        koyMuhtarveNufusu[20][1] = "229";

        koyIcerik.add(" Taşçılar köyü ilçe merkezinin kuzey doğusunda ve Hüseyinağa deresi mevkiinden geçen derenin uç noktalarında yerleşmiş bulunmaktadır. \n" +
                "\n" +
                "Köyün ilçeye uzaklığı 11 km’dir. Köyün kuruluşu eskilere dayanmasına rağmen, bugün elde kesin bilgi bulunmamaktadır. \n" +
                "\n" +
                "Taşçılar Köyü’nün doğusunda Çakılkaya köyü sınırları, batısında Kutluca Köyü, kuzeyinde Kayacık Köyü ve güneyinde Hacıören Köyü sınırları bulunmaktadır.\n" +
                "\n" +
                "Köyün coğrafi yapısı engebeli bir araziye sahiptir. \n" +
                "\n" +
                "Tek merkezden oluşan köyde 40 civarında hane bulunmakta olup, köy nüfusuna kayıtlı Taşçı, Ayvazoğlu, Emeksiz, Feraşetoğlu, Kesecek, Susuz, Yakupoğlu, soy isim ve kabileleri kayıtlıdır. Bu sülalelerin birçoğu başka bölgelerde ikamet etmektedir.\n" +
                "\n" +
                "Köyün yaylaları ve ormanlık alanları yaz aylarında mesire yapmak için İstanbul’dan gelenleri cezbetmektedir.");
        koyMuhtarveNufusu[21][0] = "Şaban EMEKSİZ";
        koyMuhtarveNufusu[21][1] = "90";

        koyIcerik.add("Çamoluk İlçe merkezinin güney doğusunda yer alan Taştemür Köyü, İlçe merkezine 7 km mesafededir. \n" +
                "\n" +
                "Köyün kuruluş merkezi Seme Deresinin hemen güneyinden başlar ve yamaçlara doğru uzanır. \n" +
                "\n" +
                "Köyün yerleşim alanı engebeli arazi yapısına sahiptir. Köyün sulu ve susuz tarım yapılabilir arazisi yamaçlar üzerinde bulunan düzlüklerden oluşmaktadır.\n" +
                "\n" +
                " Nüfusuna Kuzkaya, Çetükkaya, Bakan, Köprübaşı, Akşahin, Karabulut, Gürlek, Çakıcı, Akın ve Çambel kabileleri kayıtlıdır. İstanbul’da 300 hane Taşdemirlinin yaşadığı tahmin edilmektedir. \n" +
                "\n" +
                "Köyün doğusunda Seme Deresi, batısında Çamoluk Belediyesi mücavir alanları, güneyinde Sivas ili Gölova ilçe sınırlaırı ve kuzeyinde Çamoluk Belediyesi mücavir alanları ile Kelkit Çayı bulunmaktadır. \n" +
                "\n" +
                "Köy Çetikkaya, Tenvirler, Köprübaşılılar ve Karabulutlar mahallelerinden oluşmaktadır. \n" +
                "\n" +
                "Köyün kuruluşu çok eskilere dayanmakla beraber tarihi hakkında kesin bir bilgi mevcut değildir. Taşdemir köyünün hemen güney kısımlarında bulunan dağlardan itibaren ormanlık alanlar başlamaktadır. Kesime elverişli ağaçlar yetişmiştir.");
        koyMuhtarveNufusu[22][0] = "İbrahim ÇAKICI";
        koyMuhtarveNufusu[22][1] = "180";

        koyIcerik.add("Usluca Köyü Çamoluk ilçesinin en kalabalık köylerinden olup, ilçeye mesafesi 16 km’dir. \n" +
                "\n" +
                "Kelkit Çayı’nın hemen güney kenarından baslar ve yerleşim olarak Güngören mahallesi ile son bulur. Kelkit çayının kuzeyinde de siniri olup, burada henüz yerleşim sağlanmamıştır. \n" +
                "\n" +
                "Köyün kuzeyinde Karadikmen ve Kaledere, güneyinde Erzincan’ın Refahiye ilçe sınırları, doğusunda Yenice Beldesi, batısında Pınarlı, Daldibi ve Gücer köyleri bulunmaktadır. \n" +
                "\n" +
                "Köyün kurulusu çok eskilere dayanmaktadır.\n" +
                "\n" +
                "Araştırmalara göre Fatih Sultan Mehmet’in Trabzon’u fethinden sonra Rumların buradan yavaş yavaş çekilmeleri ve doğudan gelen Türk ailelerinin yerleşmesiyle köyün kurulduğu anlaşılmaktadır.\n" +
                "\n" +
                "Güngören, Yeni, Çevrik, Seki, İlyasoğlu mahallelerinden oluşur. Köyde sağlık evi bulunmaktadır. \n" +
                "\n" +
                "Usluca Köyü toprakları tarım için çok elverişli olup, sebzelerden domates biber, patlıcan, salatalık, kabak, fasulye, patates yetiştirilir. Usluca fasulyesi çok meşhurdur. \n" +
                "\n" +
                "Meyvelerden ceviz, elma, armut, kayısı, şeftali, dut, kiraz, vişne, ayva gibi çeşitli meyveler yetişmektedir. Ancak Usluca’nin cevizi standartların üzerindedir. Yüksek randımanlıdır. \n" +
                "\n" +
                "Köyün iki tane yaylası bulunmaktadır. Son yıllarda bu yaylalara göç yapılmamaktadır. \n" +
                "\n" +
                "Usluca isminin köyün en eski kabilelerinden olan Uslu kabilesinin soyadını almıştır. Usluca’da tarihi kale kalinisi, tarihi çeşme ile Kırbaş ve Yartıkulağı adlı yatırlar bulunmaktadır.");
        koyMuhtarveNufusu[23][0] = "Yılmaz KÜTÜK";
        koyMuhtarveNufusu[23][1] = "330";

        koyIcerik.add(" İlçe merkezine 18 km uzaklıkta bulunan Yenice köyü ilçenin doğusunda bulunmaktadır. \n" +
                "\n" +
                "1999-2014 Yılları arasında Çamoluk İlçemize bağlı Belde Belediyesi de olan Köyün Tarihi Selçuklulara kadar dayanmaktadır. Köy hakkındaki en eski bilgiyi Osmanlı dönemindeki tarih defterlerinden almaktayız. Bu köyümüze Karadeniz sahili kesiminden göç etmiş Çepni Türkmenleri yerleşmiştir. Beldede Osmanlılardan kalan mezarlık bulunmaktadır. Fatih Sultan Mehmet zamanında Osmanlılara katılmıştır. Tarihinde Mindaval ve Alucra nahiyelerine bağlanmıştır.\n" +
                "\n" +
                "Gümüşhane il sınırında yer alır. Yaklaşık 800 hanenin üzerinde hane sayısı nüfus olarak ilçenin en kalabalık köyüdür. \n" +
                "\n" +
                "Coğrafi konumu itibariyle Giresun'un güneydoğusunda; Erzincan ve Gümüşhane illerinin mülki sınırlarına komşu olan bir alanda yer almaktadır. Rakımı ortalama 850–1200 m arası olup Kelkit Çayı Vadisi'nde yer almaktadır. Kelkit Çayı, köyün içerisinden geçmektedir\n" +
                "\n" +
                "Köyün her tarafında bol miktarda ceviz ağacı yetiştirilmiştir. Kaliteli ceviz veren bu ağaçlar, ilçe ekonomisine katkı sağlamaktadır. Ayrıca yöreye has bir fasulye (kuru fasulye) çeşidi yetiştirilip satılır.\n" +
                "\n" +
                "Yenice köyünde bulunan şelale de güzelliğe sahiptir. Köy doğal güzellikleri bakımından oldukça zengindir. Köye hayat veren Pınarbaşı, en önemli doğal güzelliklerimizden biridir. Köyün üst kısmından, dağ eteklerinden kaynak halinde yeryüzüne çıkan buz gibi suyuyla başta Yeniceliler olmak üzere daha birçok yöre insanının gönlünde taht kurmuştur. \n" +
                "     \n" +
                "Belde topraklarının büyük bir kısmı düz, sulanabilir ve verimli arazilerden oluşmaktadır. \n" +
                "\n" +
                "Tarım ve hayvancılık beldemizdeki başlıca geçim kaynaklarındandır. Arıcılık son zamanlarda yaygınlaşmaya başlamakla birlikte her yıl Çamoluk ilçemizde bal festivali düzenlenmektedir. \n" +
                "\n" +
                "Beldemizin balı, cevizi, dutu, dut pekmezi, armudu, kuru fasulyesi meşhurdur.");
        koyMuhtarveNufusu[24][0] = "Mecit DERTLİ";
        koyMuhtarveNufusu[24][1] = "677";

        koyIcerik.add(" İlçe merkezine 12 km uzaklıkta bulunan Yeniköy, Kelkit vadisinin kuzey kısmında bulunan Berdiya Dağlarının eteğinde kurulmuştur. \n" +
                "\n" +
                "Berdiya Dağlarının dibinde bulunan Yeniköy yüksekliği bakımından diğer köylerimizden yüksektedir. Çamoluğun rakım olarak en yüksek ve yayla köyüdür. \n" +
                "\n" +
                "Köyün doğusunda Dulundas Köyü sınırları, batısında Akyapı Köyü sınırları, güneyinde Dulundas ve Akyapı köyleri sınırları, kuzeyinde Alucra ilçe sınırları bulunmaktadır. \n" +
                "\n" +
                "Köyümüz \"Köyiçi, Karayatak ve Hacıgil\" isimli üç ana mahalleden oluşmaktadır.\n" +
                "\n" +
                "Yeniköy uzun yıllar Çamoluk’a nahiye merkezliği yapmıştır. \n" +
                "\n" +
                "Kuruluşu eski tarihlere dayanan köyün tarihi hakkında kesin bir bilgi bulunmamaktadır. Ancak Hacıgil Mahallesi oluşturan Ekmen sülalesinin 450 yıl önce Konya’dan göç ettiği bilinmektedir. \n" +
                "\n" +
                "Köyde şu soy isim ve sülaleler yaşamaktadır: Bayındır, Birdiğa, Çağlar, Çağdaş, Dereli, Dereçayır, Domruk,  Domur, Ekmen, Engel, Gölve, İlme, Kamburoğlu, Kamış, Kayabaşı, Kuloğlu, Kule, Melikoğlu, Pelit, Rıdvanoğlu, Şakkaloğlu, Şimalıoğlu, Takmaz, Tombulel, Yanıkova, Yanıkoğlu, Yılmazlar, Yenel, Yıkmaç. \n" +
                "\n" +
                "İstanbul’da 3.000 civarında Yeniköylü yaşamaktadır. Köyde yaşayan halk geçimini hayvancılık, arıcılık ve tarımla sürdürmektedir.\n" +
                "\n" +
                "Köyün yüksekliği nedeniyle yayla görünümünde olması ve Berdiya Dağlarına yakın olmasından dolayı hayvancılığa ve arıcılığa müsaittir. \n" +
                "\n" +
                "Yeniköy’de iki adet camii ve bunlara ait lojman bulunmaktadır. Eski cami yaklaşık 250 yıl önce yapılmıştır.");
        koyMuhtarveNufusu[25][0] = "Recep BAYINDIR";
        koyMuhtarveNufusu[25][1] = "101";

        koyIcerik.add("Çamoluk ilçe merkezinin güneybatı kısmında yer alan Yusufeli Köyü Kelkit vadisinin güney kısmında bulunan yamaçlar üzerinde kurulmuş olup, engebeli bir arazi yapısına sahiptir. \n" +
                "\n" +
                "Yusufeli Köyü Çamoluk ilçe merkezine 8 km mesafede bulunmaktadır.  Büyükdüz, Kabakbaşı ve Kaşhamam mahallelerinden oluşmaktadır. \n" +
                "\n" +
                "Hamamcı, Aracı, Yalcınkaya, Akpınar, Çotul gibi bazı soy isimler mevcuttur.");
        koyMuhtarveNufusu[26][0] = "Erol KAPUCU";
        koyMuhtarveNufusu[26][1] = "97";

    }


    public void internetVarmı()
    {
        ConnectivityManager conMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        if ( conMgr.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED
                || conMgr.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING ) {

            Toast.makeText(this,"Resim yükleniyor!",Toast.LENGTH_LONG).show();

        }
        else if ( conMgr.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED
                || conMgr.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED) {

            imgKoyDetay.setImageResource(R.drawable.rsmuyari);
            Toast.makeText(this,"Resim yüklenemedi!\nİnternet Bağlantısı Yok!",Toast.LENGTH_LONG).show();
        }
    }


    public void ekranBoyutuCek()
    {
        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();  // deprecated
        int height = display.getHeight();

        int resimGenislik  = 0;
        int resimYukseklik = 0;


        if(width >= 1400)
        {
            resimGenislik  = 1200;
            resimYukseklik =  738;
        }
        else if( width >= 1300 && width < 1400)
        {
            resimGenislik  = 1200;
            resimYukseklik =  738;
        }
        else if( width >= 1200 && width < 1300)
        {
            resimGenislik  = 1100;
            resimYukseklik =  676;
        }
        else if( width >= 1100 && width < 1200)
        {
            resimGenislik  = 1000;
            resimYukseklik =  615;
        }
        else if( width >= 1000 && width < 1100)
        {
            resimGenislik  = 900;
            resimYukseklik =  553;
        }
        else if( width >= 900 && width < 1000)
        {
            resimGenislik  = 800;
            resimYukseklik =  492;
        }
        else if( width >= 800 && width < 900)
        {
            resimGenislik  = 700;
            resimYukseklik =  430;
        }
        else if( width >= 700 && width < 800)
        {
            resimGenislik  = 600;
            resimYukseklik =  369;
        }
        else if( width >= 600 && width < 700)
        {
            resimGenislik  = 500;
            resimYukseklik =  307;
        }
        else if( width >= 500 && width < 600)
        {
            resimGenislik  = 400;
            resimYukseklik =  246;
        }
        else if( width >= 400 && width < 500)
        {
            resimGenislik  = 300;
            resimYukseklik =  184;
        }
        else if( width >= 300 && width < 400)
        {
            resimGenislik  = 250;
            resimYukseklik =  153;
        }
        else if(width < 300)
        {
            resimGenislik  = 250;
            resimYukseklik =  153;
        }


        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(resimGenislik, resimYukseklik);
        parms.gravity= Gravity.CENTER;
        imgKoyDetay.setLayoutParams(parms);


    }

    public void resimCek()
    {
        switch (koyAdi)
        {
            case "AKYAPI KÖYÜ"  :
                resimUrl = "https://2.bp.blogspot.com/-XwZF8it7yAo/V9f5_0D9WUI/AAAAAAAAAAo/JqZ7qzJ3C9gIteRm56pLkD7WkCHPj5_qwCLcB/s1600/akyapi.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "BAYIR KÖYÜ":
                resimUrl = "https://4.bp.blogspot.com/-UdS_Uj8vFyU/V9f5_KpHAaI/AAAAAAAAAAg/BxMOHopZ67QCQT-RFA0oWq1BplVLnGJwwCLcB/s1600/bayir.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "ÇAKILKAYA KÖYÜ":
                resimUrl = "https://4.bp.blogspot.com/-D-hefvPibS4/V9f5_vtOKxI/AAAAAAAAAAk/lG-BlEAyAmovPYunZLB8A0ebkjSg2A3RQCLcB/s1600/cakilkaya.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "DALDİBİ KÖYÜ":
                resimUrl = "https://2.bp.blogspot.com/-cJQN5rz4KKo/V9f6FhdMo8I/AAAAAAAAAAs/NU7OgpOkPvQXCy19nNdIzF4UCFwjQmALgCLcB/s1600/daldibi.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "EĞNİR KÖYÜ":
                resimUrl = "https://2.bp.blogspot.com/-Ojyo3W6CjcM/V9f6GKrtq8I/AAAAAAAAAA0/uVf59cQcAM8sm1H4aB1WC5PcYVxbs2apQCLcB/s1600/egnir.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "FINDIKLI KÖYÜ":
                resimUrl = "https://3.bp.blogspot.com/-w9in_wg266Q/V9f6GBRBt7I/AAAAAAAAAAw/lhzK3HrJHKU5oSHLeBQCQg6UOKii3VJkgCLcB/s1600/findikli.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "GÜCER KÖYÜ":
                resimUrl = "https://4.bp.blogspot.com/-y131smNstZs/V9f6K5wC8yI/AAAAAAAAAA4/rFnL8fAioC41zJ62hOUa6RsUyDdjxyr9ACLcB/s1600/gucer.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "GÜRÇALI KÖYÜ":
                resimUrl = "https://1.bp.blogspot.com/-MjFWodOXwL4/V9f6M0pLVwI/AAAAAAAAAA8/UQIaD6aJ5UQpczEvnnlCMr-Hp6dkw8k7gCLcB/s1600/gurcali.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "HACIAHMETOĞLU KÖYÜ":
                resimUrl = "https://3.bp.blogspot.com/-tmV9SrIBsiw/V9f6NDuks7I/AAAAAAAAABA/3DbJZBErZls6h0K8AZ6SaW_Rgi9GsfaUgCLcB/s1600/haciahmet.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "HACIÖREN KÖYÜ":
                resimUrl = "https://4.bp.blogspot.com/-Iy_cBTtyYN8/V9f6P3JZpdI/AAAAAAAAABE/bHWYmUZ7frI2K3RnuBhEZWymdOgr99ngwCLcB/s1600/hacioren.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "KALEDERE KÖYÜ":
                resimUrl = "https://3.bp.blogspot.com/-WVpcX3Rd7XI/V9f6QhkTLUI/AAAAAAAAABI/KTwEzgWv_HwtNd4dlsXppUfOzBmEW87DwCLcB/s1600/kaledere.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "KARADİKMEN KÖYÜ":
                resimUrl = "https://3.bp.blogspot.com/-DNZcPjl0prI/V9gH3RfKjYI/AAAAAAAAABg/HYBj_tNuVmsBlphHgpRXPbBxcHjmTZN2wCLcB/s1600/karadikmen.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "KAYACIK KÖYÜ":
                resimUrl = "https://4.bp.blogspot.com/-lVYMcZ0RAns/V9gH3XotdDI/AAAAAAAAABo/9GccSTYBEsMz9-zMpl2e65FS-YtTHgDOgCLcB/s320/kayacik.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "KAYNAR KÖYÜ":
                resimUrl = "https://1.bp.blogspot.com/-HfZx7JKlk6M/V9gH3cAaSVI/AAAAAAAAABk/Ff1bOUFnT9YWAFsxYErj-W3J_8gvJZbLwCLcB/s320/kaynar.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "KILIÇTUTAN KÖYÜ":
                resimUrl = "https://3.bp.blogspot.com/-olAOMrYCVFg/V9gH95v9NmI/AAAAAAAAABw/F0_Fqseq8r0aI6ozTCUTl0ep2rB-aixwwCLcB/s320/kilictutan.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "KOÇAK KÖYÜ":
                resimUrl = "https://2.bp.blogspot.com/-9EIytnYawGQ/V9gH92QZGFI/AAAAAAAAAB0/FtQJ6TyH6oAcujgBvnCUcOh5Yae8dstQgCLcB/s320/kocak.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "KUTLUCA KÖYÜ":
                resimUrl = "https://4.bp.blogspot.com/-_paLgk33xxU/V9gH9bqhwDI/AAAAAAAAABs/PBKKraIfc9UdkRxqh0I6GMedDFOqJzQ2ACLcB/s320/kutluca.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "OKÇAÖREN KÖYÜ":
                resimUrl = "https://2.bp.blogspot.com/-vN2CWZ6hXtg/V9gIB8uEVSI/AAAAAAAAAB4/RHWilUa_pq4CbePv_HdFZl0Rsh78hemLgCLcB/s320/okcaoren.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "OZAN KÖYÜ":
                resimUrl = "https://4.bp.blogspot.com/-jc7wOp-wvrg/V9gIDoynxyI/AAAAAAAAAB8/JspRju6Guxot-5TxevEtiq36-8_aqNFqQCLcB/s320/ozan.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "PINARLI KÖYÜ":
                resimUrl = "https://2.bp.blogspot.com/-bSxnDezm27Q/V9gIDzOkJxI/AAAAAAAAACA/GvwxE4j8gPoBK9eYQYlyfqxq0DNd7Q14QCLcB/s320/pinarli.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "SARPKAYA KÖYÜ":
                resimUrl = "https://1.bp.blogspot.com/-1e0X6SuUGLg/V9gIF6Fe6lI/AAAAAAAAACE/yS80WLl3S882E-Dg_DQ9aTYT1dxD0DkgwCLcB/s320/sarpkaya.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "TAŞÇILAR KÖYÜ":
                resimUrl = "https://3.bp.blogspot.com/-R8-ebmy6tuA/V9gIJm_y03I/AAAAAAAAACI/X_ki5dzYVE48EyQ6z4fkIdmpNjtObbFlQCLcB/s320/tascilar.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "TAŞDEMİR KÖYÜ":
                resimUrl = "https://1.bp.blogspot.com/-82njMJvzEac/V9gIJy2qYHI/AAAAAAAAACM/xS1at6b3Jps0K5zTO_FD-lEjCSc8vzLzQCLcB/s320/tasdemir.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "USLUCA KÖYÜ":
                resimUrl = "https://4.bp.blogspot.com/-gjZSUbgisjI/V9gILKLHjKI/AAAAAAAAACQ/MTHp4Z2meZkrtp3-Ld9NY6bvkONuJkafgCLcB/s320/usluca.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "YENİCE KÖYÜ":
                resimUrl = "https://1.bp.blogspot.com/-ggZv5Bd_yNI/V9gIOqpoHfI/AAAAAAAAACU/ASc9_N7HwfINdeFXUiEWQiIx42P9nmeOwCLcB/s320/yenice.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "YENİKÖY KÖYÜ":
                resimUrl = "https://2.bp.blogspot.com/-xhqthyFGgo0/V9gIP86Tn6I/AAAAAAAAACc/qrvYWTBF6r0X3xb4BKgj1uIgn5IaFIoOACLcB/s320/yenikoy.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            case "YUSUFELİ KÖYÜ":
                resimUrl = "https://3.bp.blogspot.com/-_KzaI6xJxRI/V9gIP9OvGZI/AAAAAAAAACY/v0vgzfBjUAsNz1ehwJsQ5vYKhyBEYlyNACLcB/s320/yusufeli.png";
                Picasso.with(this).load(resimUrl).into(imgKoyDetay);
                break;
            default:
                break;
        }

    }

    public  void yaziIcerigiAl()
    {
        txtKoyAdi.setText(koyAdi);
        txtKoyDetayIcerik.setText(koyIcerik.get(koySirasi));
        txtKoyMuhtar.setText("Köy Muhtarı : " + koyMuhtarveNufusu[koySirasi][0]);
        txtKoyNufus.setText("Köy Nüfusu : " + koyMuhtarveNufusu[koySirasi][1]);
    }
}