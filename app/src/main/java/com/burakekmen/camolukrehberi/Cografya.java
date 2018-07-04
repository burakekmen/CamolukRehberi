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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.*;

public class Cografya extends Fragment implements View.OnClickListener{

    Activity titleChange;
    View view;
    AdView adView;

    ImageView imgCografya;
    TextView txtCografyaIcerik;
    Button btnYaziBuyut, btnYaziKucult;
    String icerik = "İlçemiz Doğu Anadolu’nun kuzeybatı, İç Anadolu'nun kuzeydoğu ve Karadeniz Bölgesi’nin güneyinde olup, geçit bölgesi özelliğini göstermektedir. " +
            "Batısında Şebinkarahisar, kuzeyinde Alucra, doğusunda Şiran (Gümüşhane), güneydoğusunda Refahiye (Erzincan) ve güneyinde Gölova (Sivas) ilçeleri yer almaktadır.\n\n" +
            "İlçemize bağlı 8 mahalle ve 27 köy vardır. Yerleşim şekli merkez hariç kırsaldır. İlçenin deniz seviyesinden yüksekliği 1050 metredir.  Kelkit ırmağının ikiye böldüğü vadide kurulmuştur. " +
            "\n\nİlçemizde yarı kurak iklim ile nemli Doğu Karadeniz iklimi arasında bir iklim mevcuttur. Sıcaklık ve karasallık karakterleri açısından iç bölgeye; buharlaşma, nem ve yağış şartları açısından Karadeniz iklimine yakınlaşan bir geçiş iklimi yaşanmaktadır. " +
            "\n\nYılın en soğuk ayı ocak, en sıcak ayı temmuzdur. Yıllık sıcaklık ortalaması 13 C derecedir. Ocak ayı sıcaklık ortalaması -10 derecedir. Temmuz ortalama sıcaklık 20 derecedir. Yıllık yağış miktarı 500–800 mm arasıdır. Ortalama nispi nem %65’tir.";


    public Cografya() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.cografya, container, false);
        titleChange.setTitle("Coğrafya");

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
        txtCografyaIcerik = (TextView) view.findViewById(R.id.txtCografyaIcerik);
        btnYaziBuyut = (Button) view.findViewById(R.id.btnYaziBuyult);
        btnYaziKucult = (Button) view.findViewById(R.id.btnYaziKucult);
        imgCografya = (ImageView) view.findViewById(R.id.imvCografya);

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

        float yaziBoyutu = txtCografyaIcerik.getTextSize();

        switch (v.getId())
        {
            case R.id.btnYaziBuyult:
                txtCografyaIcerik.setTextSize(TypedValue.COMPLEX_UNIT_PX, yaziBoyutu +2);
                break;

            case R.id.btnYaziKucult:
                txtCografyaIcerik.setTextSize(TypedValue.COMPLEX_UNIT_PX, yaziBoyutu -2);
                break;
            default:
                break;
        }
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
            resimGenislik  = 1300;
            resimYukseklik =  812;
        }
        else if( width >= 1300 && width < 1400)
        {
            resimGenislik  = 1200;
            resimYukseklik =  750;
        }
        else if( width >= 1200 && width < 1300)
        {
            resimGenislik  = 1100;
            resimYukseklik =  687;
        }
        else if( width >= 1100 && width < 1200)
        {
            resimGenislik  = 1000;
            resimYukseklik =  625;
        }
        else if( width >= 1000 && width < 1100)
        {
            resimGenislik  = 900;
            resimYukseklik =  562;
        }
        else if( width >= 900 && width < 1000)
        {
            resimGenislik  = 800;
            resimYukseklik =  500;
        }
        else if( width >= 800 && width < 900)
        {
            resimGenislik  = 700;
            resimYukseklik =  437;
        }
        else if( width >= 700 && width < 800)
        {
            resimGenislik  = 600;
            resimYukseklik =  375;
        }
        else if( width >= 600 && width < 700)
        {
            resimGenislik  = 500;
            resimYukseklik =  312;
        }
        else if( width >= 500 && width < 600)
        {
            resimGenislik  = 400;
            resimYukseklik =  250;
        }
        else if( width >= 400 && width < 500)
        {
            resimGenislik  = 300;
            resimYukseklik =  187;
        }
        else if( width >= 300 && width < 400)
        {
            resimGenislik  = 250;
            resimYukseklik =  156;
        }
        else if(width < 300)
        {
            resimGenislik  = 250;
            resimYukseklik =  156;
        }


        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(resimGenislik, resimYukseklik);
        parms.gravity= Gravity.CENTER;
        imgCografya.setLayoutParams(parms);
    }

    public  void yaziIcerigiAl()
    {
        txtCografyaIcerik.setText(icerik);
    }
}
