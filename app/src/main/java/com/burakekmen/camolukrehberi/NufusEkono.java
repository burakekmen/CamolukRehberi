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

public class NufusEkono extends Fragment implements View.OnClickListener{

    Activity titleChange;
    View view;
    AdView adView;

    ImageView imvEkonomi;
    TextView txtEkonomiIcerik;
    Button btnYaziBuyut, btnYaziKucult;

    String icerik ="2015 yılı nüfus verilerine göre Çamoluk nüfusu şehir merkezi 2.421, köyler 4.121 olmak üzere toplamda 6.542 olarak belirlenmiştir. \n\n Şehir merkezinde nüfusun 1.333’ü erkek, 1.088’i ise kadındır. Köylerde ise 1.978 erkek 2.143 kadın bulunmaktadır.\n" +
            "\nİlçemiz ekonomisinin temel taşları tarım ve hayvancılık üzerine kurulmuştur. Ayrıca arıcılık oldukça yaygındır. İlçemizde her yıl Çamoluk Bal Festivali düzenlenmektedir. \n\nİlçemizin diğer bir ekonomik yönünü ise turizm oluşturur, yayla turizmi oldukça yaygındır.";

    public NufusEkono() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.nufusekono, container, false);
        titleChange.setTitle("Nüfus ve Ekonomi");

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
        txtEkonomiIcerik = (TextView) view.findViewById(R.id.txtEkonomiIcerik);
        btnYaziBuyut = (Button) view.findViewById(R.id.btnYaziBuyult);
        btnYaziKucult = (Button) view.findViewById(R.id.btnYaziKucult);
        imvEkonomi = (ImageView) view.findViewById(R.id.imvEkonomi);

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

        float yaziBoyutu = txtEkonomiIcerik.getTextSize();

        switch (v.getId())
        {
            case R.id.btnYaziBuyult:
                txtEkonomiIcerik.setTextSize(TypedValue.COMPLEX_UNIT_PX, yaziBoyutu +2);
                break;

            case R.id.btnYaziKucult:
                txtEkonomiIcerik.setTextSize(TypedValue.COMPLEX_UNIT_PX, yaziBoyutu -2);
                break;
            default:
                break;
        }
    }


    public  void yaziIcerigiAl()
    {
        txtEkonomiIcerik.setText(icerik);
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
            resimYukseklik =  819;
        }
        else if( width >= 1300 && width < 1400)
        {
            resimGenislik  = 1200;
            resimYukseklik =  756;
        }
        else if( width >= 1200 && width < 1300)
        {
            resimGenislik  = 1100;
            resimYukseklik =  693;
        }
        else if( width >= 1100 && width < 1200)
        {
            resimGenislik  = 1000;
            resimYukseklik =  630;
        }
        else if( width >= 1000 && width < 1100)
        {
            resimGenislik  = 900;
            resimYukseklik =  567;
        }
        else if( width >= 900 && width < 1000)
        {
            resimGenislik  = 800;
            resimYukseklik =  504;
        }
        else if( width >= 800 && width < 900)
        {
            resimGenislik  = 700;
            resimYukseklik =  441;
        }
        else if( width >= 700 && width < 800)
        {
            resimGenislik  = 600;
            resimYukseklik =  378;
        }
        else if( width >= 600 && width < 700)
        {
            resimGenislik  = 500;
            resimYukseklik =  315;
        }
        else if( width >= 500 && width < 600)
        {
            resimGenislik  = 400;
            resimYukseklik =  252;
        }
        else if( width >= 400 && width < 500)
        {
            resimGenislik  = 300;
            resimYukseklik =  189;
        }
        else if( width >= 300 && width < 400)
        {
            resimGenislik  = 250;
            resimYukseklik =  157;
        }
        else if(width < 300)
        {
            resimGenislik  = 250;
            resimYukseklik =  157;
        }


        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(resimGenislik, resimYukseklik);
        parms.gravity= Gravity.CENTER;
        imvEkonomi.setLayoutParams(parms);
    }
}

