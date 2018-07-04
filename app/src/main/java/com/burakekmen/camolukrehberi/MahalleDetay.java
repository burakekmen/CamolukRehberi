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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class MahalleDetay extends AppCompatActivity implements View.OnClickListener {

    AdView adView;

    String mahalleAdi, resimUrl;
    int mahalleSirasi;

    TextView txtmahalleAdi, txtMahalleDetayIcerik;
    Button btnYaziBuyut, btnYaziKucult, btnKonumaGit;
    ImageView imgMahalleDetay;

    ArrayList<String> mahalleYaziIcerik;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mahalledetay);

        Bundle extras = getIntent().getExtras();
        mahalleAdi = extras.getString("send_string");
        mahalleSirasi = extras.getInt("send_mahalleSirasi");

        elemanlariTanimla();
        yaziIceriginiDoldur();
        yaziIcerigiAl();
        ekranBoyutuCek();
        resimCek();
        internetVarmı();

        txtmahalleAdi.setText(mahalleAdi);
    }


    public void elemanlariTanimla()
    {
        txtmahalleAdi = (TextView) findViewById(R.id.txtMahalleAdi);
        txtMahalleDetayIcerik = (TextView) findViewById(R.id.txtMahalleDetayIcerik);
        btnYaziBuyut = (Button) findViewById(R.id.btnYaziBuyult);
        btnYaziKucult = (Button) findViewById(R.id.btnYaziKucult);
        btnKonumaGit = (Button) findViewById(R.id.btnKonumaGit);
        imgMahalleDetay = (ImageView) findViewById(R.id.imgMahalleDetay);

        mahalleYaziIcerik = new ArrayList<>();

        adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        btnYaziBuyut.setOnClickListener(this);
        btnYaziKucult.setOnClickListener(this);
        btnKonumaGit.setOnClickListener(this);

    }

    public void yaziIceriginiDoldur()
    {
        mahalleYaziIcerik.add("Dulundas mahallesi, Çamoluk Belediyesi sınırları içerisine alınarak mahalle statüsüne geçmiştir.\n" +
                "\n" +
                "Kelkit Çayı’nın Kuzey kısmından itibaren sınırları başlayan Dulundas mahallesi ilçeye 10 km uzaklıktadır. Kuruluşunun 300 yıl öncesine kadar uzandığı söylenmektedir. \n" +
                "\n" +
                "Coğrafi bakımından engebeli arazi yapısına sahip ve susuz tarım alanları fazladır. Mahallenin doğusunda Kılıçtutan ve Kutluca köyleri, batısında Yeniköy ve Akyapı köyleri, güneyinde Kelkit çayı, kuzeyinde Alucra İlçesi bulunmaktadır. \n" +
                "\n" +
                "Yerleşik nüfus, geçimini tarım ve hayvancılıkla sürdürür. Tarım alanları genelde susuz olduğundan buğday,arpa ve fiğ üretimi yapılmaktadır. Sulu sayılabilecek tarım alanlarında ise patates, fasulye, soğan gibi sebze türleri ferdi ihtiyaçları karşılayacak şekilde üretilmektedir. \n" +
                "\n" +
                "Mahallenin ayrıca görülmeye değer yaylası bulunmaktadır.\n" +
                "\n" +
                "Mahallede Akarçeşme, Alkan, Bakırhan, Bakdemli, Çoraksu, Köse, Sevindik, Söylemez, Üçtaş, Zorkayagibi soy isim ve sülaleleri mevcuttur. \n" +
                "\n" +
                "Mahallede sağlık evi de bulunmaktadır. Köyde modern yapılar her geçen gün artmakta olup, yol, su ve diğer hizmet alanlarında imkânlar elverişlidir");

        mahalleYaziIcerik.add("İlçenin en yeni yerleşim birimi ve mahallesi olan Hürriyet Mahallesi, Kılıçtutan Köyü bağlısı iken 21 Nisan 1994 ve 21921 sayılı Resmi Gazete’de yayınlanan 94/43073 sayılı kararla Çamoluk Belediyesi sınırları içerisine alındı. \n" +
                "Belediye sınırları içerisine alınan Komlar Mahallesi’nin “Hürriyet” adıyla yeni bir mahalle kurulduğu ve tescil edildiği İçişleri Bakanlığı İller İdaresi Genel Müdürlüğü’nün 8.9.1994 tarih ve 5598 sayılı yazıları ile sildirildi. \n" +
                "Hürriyet mahallesi ilçe merkezinin doğu kısmında Kurtuluş Mahallesi’ne 1 km mesafede kurulmuştur. \n" +
                "Mahalle Kelkit Çayı’nın kuzey kısmında hemen çay kenarında bulunmaktadır. Mahallede yapılan tespitlere göre 30 civarında hane bulunmaktadır. \n" +
                "Çamoluk-Alucra kara yolu üzerinde bulunan Hürriyet Mahallesi’nin ulaşım yönünden problemi bulunmamaktadır. Yeni kurulan mahallede nüfus hareketlerinin artacağı imar yönünden düzenli bir yapılaşma olacağı bekleniyor. \n" +
                "Hürriyet mahallesinde sosyal ve kültürel alanda henüz bir yapılaşma bulunmamakta olup, mahalle bulunduğu konum itibariyle şehir planına uygun sosyal ve kültürel tesislerin Kurulmasına elverişlidir. \n" +
                "Hürriyet Mahallesi Camii Yaptırma ve Yaşatma Derneği kurulmuş ve bu alanda faaliyete geçmiştir. \n" +
                "Bu mahalle ilçenin en yeni ve en küçük mahallesidir. Hürriyet Mahallesinde Düz, Düzyurt, Saka, İhtiyar, Duvarbaşı gibi soy ismi sahih aileler yaşamakta olup, bu aileler Köroğlu, Kılıçtutan köyleri ile Yazılar Mahallesinden gelerek yerleşmişlerdir. \n" +
                "Mahallede Şerif saka ve Zekeriya İhtiyar’a ait örnek bahçe vardır. Mahallede modern bir yapılaşma mevcut olup belediye imar planı uygulanmaktadır. Hürriyet mahallesine modern bir camii yapılmıştır.");

        mahalleYaziIcerik.add("2000 yılında kurulan Karşıyaka Mahallesi nüfusu genellikle Dulundas Mah. Çakılkaya köyü, Kılıçtutan köyü ve Köroğlu Mahallelerinden oluşmaktadır. \n" +
                "\n" +
                "Karşıyaka Mahallesi, Yeniköy – Dulundas Mah. Köroğlu Mah. –Akyapı köyü yolu üzerinde kurulmuştur. \n" +
                "\n" +
                "Karşıyaka Mahallesi, kuzeyden Dulundas Mahallesi, kuzeybatıdan Köroğlu Mahallesi, güneyden de Kurtuluş Mahallesi ve Kelkit Irmağı ile çevrilidir. Karşıyaka Mahallesi, Kelkit çayı üzerinde kurulmuştur.  \n" +
                "\n" +
                "Ortalama 400 hane olan Karşıyaka Mahallesinde, aile ihtiyacını karşılayacak kadar bağ-bahçe işleri ile uğraşılmaktadır. Karşıyaka Mahallesinde, büyükbaş hayvancılıkta yapılmaktadır. \n" +
                "\n" +
                "Mahalle'de Çamoluk’ta görev alan memurlar yoğun olarak ikamet etmektedir. \n" +
                "\n" +
                "Karşıyaka Mahallesi, Alkan, Akarçeşme, Üçtaş, Bakırhan, Sivrikaya, Kızılhan, Ekinci, Çukuryurt, Varıcı, Lambacı, Bayramoğlu, Sevindik, Köse, Bakırtaş, Gür, Yetimova, Karakuş, Akmaz, Çoraksu, Aydın, Tepeyurt, Kürkçü, İhtiyar, Özkan, Özveri, Var ve Aras, soy isimlerinden oluşmaktadır. \n" +
                "\n" +
                "Mahalle, Yenicami - Aksu - Tepeüstü Çeşme- Dereyolu – Hebiloğlu - Değirmendere - Bakır ve Bahçe sokaklarının yanı sıra, Şehit Pilot Üst Teğmen İsmail Düz Caddesi ve Dulundas caddelerinden oluşmaktadır.\n" +
                "\n" +
                "İlk muhtar Mehmet Akarçeşme, ikinci muhtar Hidayet Akarçeşme ve halen görevi sürden Rıdvan Alkan görev yapmaktadır.\n" +
                "\n" +
                "Karşıyaka Mahalle Muhtarı Rıdvan Alkan, Türkiye'nin en genç muhtarları arasında yer almaktadır. Genç muhtar Rıdvan Alkan, henüz 29 yaşındadır.");

        mahalleYaziIcerik.add("Eski adı Vartana olan Köroğlu Mahallesi, 1992 yılına kadar köy iken, 23.12.1992 tarih ve 92/41160 sayılı kararla Çamoluk Belediyesi sınırları içerisine alınarak mahalle statüsüne geçmiştir. \n" +
                "Kuruluşu çok eski yallara kadar dayanmaktadır. \n" +
                "İlçe merkezine 3.5 km uzaklıkta olan mahallenin merkezi Kelkit Çayının kuzeyinde 500 m uzağında bulunmaktadır. \n" +
                "İki yamaç üzerine kurulmuş bulunan mahallenin doğu sınırında Akyapı Köyü, batısında Hacıahmetoğlu Köyü, kuzeyinde Alucra İlçesi, güneyinde Kelkit Çayı ile çevrilidir. \n" +
                "Mahalle dağınık yapılaşmaya sahip olmakla beraber, merkez mahalle köyleri, İmamgil, Cennetgil, Çukur, Yazıtarla ve Mürselli hümelesinden oluşmaktadır. \n" +
                "Mahalle 1990 yılında köy iken yapılan genel nüfus sayımından sonra nüfusu mahalle olmasıyla beraber 500’e yaklaşmış, son yıllarda İstanbul’dan ilçeye gelen mahalle halkı büyük yekün teşkil etmektedir.");

        mahalleYaziIcerik.add("Çamoluk ilçe merkezini oluşturan Kurtuluş Mahallesi, tarihi çok eskilere dayanan ve Çamoluk merkez mahallesi olarak bilinirken 7.4.1993 tarihinde valilik onayı ile Kurtuluş Mahallesi adını almıştır. \n" +
                "\n" +
                "Daha önceleri Yazılar Mahallesi ile birlikte tek mahalle iken belirtilen tarihte Yazılar Mahallesinden ayrılmıştır. Eski adıyla Bağlar Mahallesi olarak bilinen yerleşim kısmı da Kurtuluş Mahallesi sınırları içinde kalmıştır. \n" +
                "\n" +
                "Kurtuluş Mahallesi Çamoluk idare teşkilatlarının hepsini içinde barındırmaktadır.\n" +
                "\n" +
                "Kurtuluş Mahallesi Kelkit Çayının hemen güney kenarında bulunmaktadır. \n" +
                "\n" +
                "Çamoluk İlçesi köy ve mahallelerinin bütün ticari ve sosyal faaliyetlerinin merkezi durumundadır. Mahallenin imar planı çizilmiş ve onanmıştır. Belediye merkezi durumundadır.\n" +
                "\n" +
                " Mahalleden ilçe merkezi her pazartesi, Perşembe ve Cumartesi günleri İstanbul’a direkt otobüs seferi düzenlenmektedir. Her pazartesi günü ilçe pazarı kurulmaktadır. Kurulan pazardan Çamoluk ilçe merkez mahalle ve köyleri ihtiyaçlarını karşılar. Ayrıca burada altmışın üzerinde dükkân ve atölye bulunmaktadır. \n" +
                "\n" +
                "Mahalle halkının % 80’ini esnaf ve memurlar oluşturmaktadır. Burada tarım ve hayvancılıkla uğraşanların sayısı azdır. Genelde gelir ticari alanlardan oluşturulmuştur. \n" +
                "\n" +
                "Kurtuluş mahallesinin batı kısmında bulunan Değirmen çeliği mevkii şehirleşme açısından oldukça elverişlidir. Mahallede belediye su şebeke sistemi, kanalizasyon ve diğer altyapı hizmetleri mevcuttur. \n" +
                "\n" +
                "Çamoluk Merkez Camii, Çamoluk ve çevresinde ihtişam bakımından en iddialı camidir. İlçenin tek un değirmeni bu mahallededir. \n" +
                "\n" +
                "1987 yılında belediye teşkilatı, 1991 yılında ilçe teşkilatı bu merkezde kurulmuştur. Önceleri köy görünümünde olan Kurtuluş Mahallesi son yıllarda imar ve yapılaşma alanında çok katlı binalarla dikkati çekmektedir. \n" +
                "\n" +
                "Kurtuluş mahallesinde ikamet eden yerli halkın % 80’ini diğer köy ve mahallelerden gelerek yerleşen esnaflar oluşturmaktadır. İlçe merkezini oluşturan bu mahalle adeta her köyden birer temsilcinin toplandığı bir merkez olmuştur.");

        mahalleYaziIcerik.add("Kurukol 1987 yılına kadar bir köy iken belediyenin 1987 yılında kurulmasıyla birlikte bu tarihten itibaren Merkez Mahalle statüsüne geçirilmiştir. \n" +
                "Kurukol mahallesinin köy olarak kuruluşu çok eskilere dayanmaktadır. \n" +
                "Bazı rivayetlere göre Çamoluk, nahiyeliği sırasında bir ara nahiye merkezi olduğu ve burada nahiye müdürünün kaldığı söylenegelmektedir.");

        mahalleYaziIcerik.add("Çamoluk ilçesi merkez mahallelerinden biridir. \n" +
                "Yazılar Mahallesi 1993 yılına kadar Çamoluk merkez mahallesine bağlı bir yerleşim birimi iken 7.4.1993 tarihinde Valilik onayı ile merkez mahalleden ayrılarak yazılar adını almıştır. \n" +
                "Yazılar mahallesinin nüfusunun tamamı yerli nüfus olup, 80-100 haneden ibarettir.");

        mahalleYaziIcerik.add("Çamoluk merkez mahallelerinden birisi olan Yuvacık Mahallesi kuruluşu eskilere dayanan köy iken, 1987 yılında belediyeye geçmesiyle mahalle statüsüne kavuşmuştur. \n" +
                "Yuvacık Mahallesi coğrafi konum itibariyle Çamoluk İlçe merkezinin güneybatı kısmında ve ilçe merkezine 5 km mesafede bulunmaktadır. \n" +
                "Mahallenin doğusunda Kurtuluş Mahallesi, batısında Kurukol Mahallesi, güneyde Sivas İli Gölova ilçe sınırları ve kuzeyinde Kelkit Çayı ile çevrilidir. \n" +
                "Kuruluşu itibariyle Kelkit Çayının güney kenarında yükselen dağın eteğindedir.");


    }

    @Override
    public void onClick(View v) {

        float yaziBoyutu = txtMahalleDetayIcerik.getTextSize();
        Intent i;

        switch (v.getId()) {
            case R.id.btnYaziBuyult:
                txtMahalleDetayIcerik.setTextSize(TypedValue.COMPLEX_UNIT_PX, yaziBoyutu + 2);
                break;
            case R.id.btnYaziKucult:
                txtMahalleDetayIcerik.setTextSize(TypedValue.COMPLEX_UNIT_PX, yaziBoyutu - 2);
                break;
            case R.id.btnKonumaGit:
                String s = mahalleAdi;
                i = new Intent(MahalleDetay.this, MapsActivity.class);
                i.putExtra("send_string", s);
                i.putExtra("send_mahalleSirasi", mahalleSirasi);
                startActivity(i);
                break;
            default:
                break;
        }
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

            imgMahalleDetay.setImageResource(R.drawable.rsmuyari);
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
        imgMahalleDetay.setLayoutParams(parms);

    }

    public void yaziIcerigiAl()
    {
        txtmahalleAdi.setText(mahalleAdi);
        txtMahalleDetayIcerik.setText(mahalleYaziIcerik.get(mahalleSirasi));
    }

    public void resimCek()
    {
        switch (mahalleAdi)
        {
            case "DULUNDAS MAHALLESİ":
                resimUrl = "https://4.bp.blogspot.com/-cobg1ln8wgE/V-wbbXbC59I/AAAAAAAABpE/M0_DlJZ6FlUTyLNUTZyO9LzqEbJ0u6C6QCLcB/s320/rsmdulundas.png";
                Picasso.with(this).load(resimUrl).into(imgMahalleDetay);
                break;
            case "HÜRRİYET MAHALLESİ":
                resimUrl = "https://2.bp.blogspot.com/-JeursSdeen4/V-wbcqLzB5I/AAAAAAAABpI/1FSpoObKq8cBCNZZIJM2sOjf-nAhpvc2gCLcB/s320/rsmhurriyet.png";
                Picasso.with(this).load(resimUrl).into(imgMahalleDetay);
                break;
            case "KARŞIYAKA MAHALLESİ":
                resimUrl = "https://4.bp.blogspot.com/-POUwWafkabo/V-wbc8vtvwI/AAAAAAAABpM/n6jkwdnrY6Q_8O5wgmmGKVT8nJ731WcFQCLcB/s320/rsmkarsiyaka.png";
                Picasso.with(this).load(resimUrl).into(imgMahalleDetay);
                break;
            case "KÖROĞLU MAHALLESİ":
                resimUrl = "https://3.bp.blogspot.com/-zCzMpgqa5mc/V-wbeK9_yOI/AAAAAAAABpQ/4eYa3mqENRYgTqCLt8FKxbAgBeS8D-orgCLcB/s320/rsmkoroglu.png";
                Picasso.with(this).load(resimUrl).into(imgMahalleDetay);
                break;
            case "KURTULUŞ MAHALLESİ":
                resimUrl = "https://4.bp.blogspot.com/-6LDaF31rGps/V-wbgwHyW5I/AAAAAAAABpU/X21fNMt0u5kCsOpX7rwnJrhPI2928iG7QCLcB/s320/rsmkurtulus.png";
                Picasso.with(this).load(resimUrl).into(imgMahalleDetay);
                break;
            case "KURUKOL MAHALLESİ":
                resimUrl = "https://1.bp.blogspot.com/-KJYAM6ekI5o/V-wbhCKHUjI/AAAAAAAABpY/vwkusR7V-ygDjBHLy0J67S_9mUnNcmQhwCLcB/s320/rsmkurukol.png";
                Picasso.with(this).load(resimUrl).into(imgMahalleDetay);
                break;
            case "YAZILAR MAHALLESİ":
                resimUrl = "https://2.bp.blogspot.com/-EC3Lh3Wo4tg/V-wbi2jOY7I/AAAAAAAABpc/rtZpyqCfeK4xzrM-f2LOmcPBl9EGwAnjgCLcB/s320/rsmyazilar.png";
                Picasso.with(this).load(resimUrl).into(imgMahalleDetay);
                break;
            case "YUVACIK MAHALLESİ":
                resimUrl = "https://1.bp.blogspot.com/-OkZB6xowzH4/V-wbj0y4rEI/AAAAAAAABpg/ucfjVQpodZAnAxq7pv1w6q_SnndGHOoGQCLcB/s320/rsmyuvacik.png";
                Picasso.with(this).load(resimUrl).into(imgMahalleDetay);
                break;
            default:
                break;
        }
    }


}
