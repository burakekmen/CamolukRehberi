package com.burakekmen.camolukrehberi;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.*;


public class Tarih extends Fragment implements View.OnClickListener{

    Activity titleChange;
    View view;
    AdView adView;

    ImageView imvTarih;
    TextView txtTarihIcerik;
    Button btnYaziBuyut, btnYaziKucult;
    ImageView imgCamoluk;

    String icerik = "İlçemiz Çamoluk Giresun İlinden 180 km uzaklıkta olup Erzincan ve Sivas illeri hudutlarında Kelkit çayı vadisinde kurulmuştur. " +
            "Çamoluk İlçesinin Karadeniz Bölgesiyle bağlantısı 1933 yılında (Giresun Vilayetine) bağlanmasıyla başlamıştır. Çamoluk, Kelkit vadisinde kurulmuş olması bakımından tarihi birçok seferin geçiş yolu üzerinde bulunmaktadır. " +
            "Fatih Sultan Mehmet’in Şebinkarahisar’ı fethettiği yıllarda bu yöreden geçtiği bilinmektedir.\n\n" +
            "Yapılan araştırmalarda Çamoluk tarihi Hititler dönemine kadar uzanmaktadır. M.Ö 1341 yıllarında Hititlerin Kaçkarlarla savaşı kazanarak Erzurum’a kadar ilerledikleri sanılmaktadır. Yunan tarihçisi Heredot’a göre Amazon adı verilen kadın savaşçılar bu bölgede bir koloni devleti kurmuşlardır. Daha sonra bölgeye Kimmerler  gelmiş, bölge bir süre de onların elinde kalmıştır. Bir müddet sonra bölge Romalıların eline geçmiştir. M.S 381 yılında Romalı Komutan Lucallus bölgeye gelmiş bu seferinden kısa bir süre sonra Roma İmparatorluğu ikiye bölününce, bölge Bizanslıların hâkimiyetine girmiştir. 778 yılında Arapların bölgeye yaptıkları akınlar sonucu bölge onların eline geçmiştir. Oğuz Türkleri Çamoluk çevresine 8.yüzyıl sonlarında kabileler halinde gelerek Türk yerleşim merkezinin temellerini atmışlardır.\n\n" +
            "Bizans orduları ile Abbasi ordularının yaptıkları savaşlar sona erince 1054 yılında Selçuklu orduları harekete geçmiş; Van, Kars ve Bayburt yörelerini ele geçirmişlerdir. 1058 yılında Tuğrul Bey’in yeğeni Verkiti, orduları ile Çamoluk, Şebinkarahisar, Erzincan, Kemah ve Niksar’a kadar gelmiş ve buraların idaresini Tuğrul Bey’in kardeşi İbrahim Yenal’a bırakmıştır. Alparslan’ın 1071 Malazgirt savaşını kazanmasından sonra bölge tamamen Selçuklular’ın hâkimiyetine girmiştir. Anadolu Selçuklu Devleti ile Danişmentlilerin arası açılınca Bizans İmparatoru Ammen büyük bir ordu ile Trabzon üzerine yürümüş, bu sefer sonrasında Çamoluk tekrar Bizanslıların eline geçmiştir. 1204 yılında; Rum İmparatorluğuna karşı Muzafferüddin Mehmet, Kaledere mevkiindeki kaleyi yaptırmıştır. Bu kale tepeden yer altına doğru 120 metre kadar derinlikte olup dağ yamacından açılan iki kapıya sahiptir.  Ancak yapılan incelemede surların tamamen yıkıldığı kalenin tanınmaz halde bulunduğu görülmüştür.\n\n" +
            "İran’da kurulan Akkoyunlu devleti sınırlarını genişletince bölge bu devletin eline geçmiştir. Akkoyunlu Devleti Osmanlıların güvenliği için tehlike oluşturmaya başlayınca Fatih Sultan Mehmet bu devletin üzerine yürümüş, 14 Ağustos 1473 yılında iki ordu Otlukbeli savaşında karşı karşıya gelmiştir. İşte bu savaşın yapıldığı yer tarihi kaynakların bazılarında Erzincan ili Tercan ilçesi yakınlarında gösterilmektedir. Ancak yapılan araştırmalarda Otlukbeli denilen yerin ilçemiz sınırları içerisinde kalan Kaledere köyünün kuzeydoğu istikametinde olduğu iddia edilmiştir. Bu bölgedeki şehitlik mevkii de bu iddiayı doğrular niteliktedir. Bu bölgenin Kaledere ve Karadikmen köylerinin sınırları içerisinde olduğu tespit edilmiştir.  \n\n" +
            "Çamoluk ve çevresi 1464 yılında Fatih Sultan Mehmet tarafından Osmanlı ülkesine katılınca Şebinkarahisar’a bağlı bir bölge olarak kaldı. Şebinkarahisar bu arada değişik eyaletlere bağlandı. Önce Sivas eyaletine; 1515 yılında Erzincan, 1535 yılında Erzurum, 1840 yılında tekrar Sivas eyaletine bağlandı. Tabi bu bağlanmalarla Çamoluk’ta bu eyaletlere bağlanmıştır.\n\n" +
            "1933 yılında Şebinkarahisar’ın vilayet statüsü kaldırılıp Giresun vilayetine bağlanınca, Çamoluk Alucra ilçesine bağlanmıştır. Çamoluk’un nahiye oluşu çok eskilere dayanır. Osmanlının son dönemi ve Cumhuriyetin ilk yıllarında nahiye niteliğinde olan Çamoluk’un idaresi mahallen güçlü yöneticilere bırakılmış; ilçenin nahiye merkezi zaman zaman köyler arasında değişmiştir. Belediye teşkilatı 1987 yılında kurulmuştur.\n\n" +
            "Çamoluk 20.05.1990 gün ve 20523 sayılı resmi gazetede yayınlanan 2644 sayılı kanunla ilçe oldu. İlçenin ilk kaymakamı 26.08.1991 tarihinde göreve başladı. Çamoluk’ta 15.07.1990 tarihinde yapılan referandum sonucu Çamoluklular, Giresun iline bağlı kalmayı kabul ettiler.";

    public Tarih() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.tarih, container, false);
        titleChange.setTitle("Tarih");

        elemanlariTanimla();
        onclickTanimla();
        yaziIcerigiAl();
        ekranBoyutuCek();

        return  view;

    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        titleChange = (MainActivity) activity;
    }


    public void elemanlariTanimla()
    {
        txtTarihIcerik = (TextView) view.findViewById(R.id.txtTarihIcerik);
        btnYaziBuyut = (Button) view.findViewById(R.id.btnYaziBuyult);
        btnYaziKucult = (Button) view.findViewById(R.id.btnYaziKucult);
        imvTarih = (ImageView) view.findViewById(R.id.imvTarih);

        adView = (AdView) view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }


    public void onclickTanimla() {
        btnYaziBuyut.setOnClickListener(this);
        btnYaziKucult.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        float yaziBoyutu = txtTarihIcerik.getTextSize();

        switch (v.getId())
        {
            case R.id.btnYaziBuyult:
                txtTarihIcerik.setTextSize(TypedValue.COMPLEX_UNIT_PX, yaziBoyutu +2);
                break;

            case R.id.btnYaziKucult:
                txtTarihIcerik.setTextSize(TypedValue.COMPLEX_UNIT_PX, yaziBoyutu -2);
                break;
            default:
                break;
        }
    }


    public  void yaziIcerigiAl()
    {
        txtTarihIcerik.setText(icerik);
    }


    public void ekranBoyutuCek()
    {
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        int width = display.getWidth();  // deprecated
        int height = display.getHeight();

        int resimGenislik  = 0;
        int resimYukseklik = 0;


        if(width >= 1400)
        {
            resimGenislik  = 1200;
            resimYukseklik =  735;
        }
        else if( width >= 1300 && width < 1400)
        {
            resimGenislik  = 1200;
            resimYukseklik =  735;
        }
        else if( width >= 1200 && width < 1300)
        {
            resimGenislik  = 1100;
            resimYukseklik =  673;
        }
        else if( width >= 1100 && width < 1200)
        {
            resimGenislik  = 1000;
            resimYukseklik =  612;
        }
        else if( width >= 1000 && width < 1100)
        {
            resimGenislik  = 900;
            resimYukseklik =  551;
        }
        else if( width >= 900 && width < 1000)
        {
            resimGenislik  = 800;
            resimYukseklik =  490;
        }
        else if( width >= 800 && width < 900)
        {
            resimGenislik  = 700;
            resimYukseklik =  428;
        }
        else if( width >= 700 && width < 800)
        {
            resimGenislik  = 600;
            resimYukseklik =  367;
        }
        else if( width >= 600 && width < 700)
        {
            resimGenislik  = 500;
            resimYukseklik =  306;
        }
        else if( width >= 500 && width < 600)
        {
            resimGenislik  = 400;
            resimYukseklik =  245;
        }
        else if( width >= 400 && width < 500)
        {
            resimGenislik  = 300;
            resimYukseklik =  183;
        }
        else if( width >= 300 && width < 400)
        {
            resimGenislik  = 250;
            resimYukseklik =  152;
        }
        else if(width < 300)
        {
            resimGenislik  = 250;
            resimYukseklik =  152;
        }


        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(resimGenislik, resimYukseklik);
        parms.gravity= Gravity.CENTER;
        imvTarih.setLayoutParams(parms);


    }
}
