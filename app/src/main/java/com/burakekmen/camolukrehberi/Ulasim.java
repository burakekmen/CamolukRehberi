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


public class Ulasim extends Fragment implements View.OnClickListener{

    Activity titleChange;
    View view;
    AdView adView;

    ImageView imvUlasim;
    TextView txtUlasimIcerik;
    Button btnYaziBuyut, btnYaziKucult;
    String icerik = "İlçemiz Giresun il merkezine 187 km, Alucra’ya 39 km, Şiran’a 45 km, Erzincan’a ise 112 km’dir. İlçemizden haftanın belirli günlerinde İstanbul’a karşılıklı otobüs seferleri düzenlenmektedir. Ayrıca Erzincan havaalanından ulaşım da mümkündür." +
            "\n\n Bayburt güzergâhını kullanan otobüsler de ilçemize yakın bir noktadan geçmektedir. \n\nİlçemizden belirli günlerde Giresun, Erzincan, Alucra, Şebinkarahisar ve Suşehri’ne ulaşım imkânları mevcuttur. ";

    public Ulasim() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.ulasim, container, false);
        titleChange.setTitle("Ulaşım");

        elemanlariTanimla();
        onclickTanimla();
        yaziIcerigiAl();
        ekranBoyutuCek();

        return view;

    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        titleChange = (MainActivity) activity;
    }


    public void elemanlariTanimla()
    {
        txtUlasimIcerik = (TextView) view.findViewById(R.id.txtUlasimIcerik);
        btnYaziBuyut = (Button) view.findViewById(R.id.btnYaziBuyult);
        btnYaziKucult = (Button) view.findViewById(R.id.btnYaziKucult);
        imvUlasim = (ImageView) view.findViewById(R.id.imvUlasim);

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

        float yaziBoyutu = txtUlasimIcerik.getTextSize();

        switch (v.getId())
        {
            case R.id.btnYaziBuyult:
                txtUlasimIcerik.setTextSize(TypedValue.COMPLEX_UNIT_PX, yaziBoyutu +2);
                break;

            case R.id.btnYaziKucult:
                txtUlasimIcerik.setTextSize(TypedValue.COMPLEX_UNIT_PX, yaziBoyutu -2);
                break;
            default:
                break;
        }
    }


    public  void yaziIcerigiAl()
    {
        txtUlasimIcerik.setText(icerik);
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
            resimYukseklik =  893;
        }
        else if( width >= 1300 && width < 1400)
        {
            resimGenislik  = 1200;
            resimYukseklik =  893;
        }
        else if( width >= 1200 && width < 1300)
        {
            resimGenislik  = 1100;
            resimYukseklik =  818;
        }
        else if( width >= 1100 && width < 1200)
        {
            resimGenislik  = 1000;
            resimYukseklik =  744;
        }
        else if( width >= 1000 && width < 1100)
        {
            resimGenislik  = 900;
            resimYukseklik =  669;
        }
        else if( width >= 900 && width < 1000)
        {
            resimGenislik  = 800;
            resimYukseklik =  595;
        }
        else if( width >= 800 && width < 900)
        {
            resimGenislik  = 700;
            resimYukseklik =  521;
        }
        else if( width >= 700 && width < 800)
        {
            resimGenislik  = 600;
            resimYukseklik =  446;
        }
        else if( width >= 600 && width < 700)
        {
            resimGenislik  = 500;
            resimYukseklik =  372;
        }
        else if( width >= 500 && width < 600)
        {
            resimGenislik  = 400;
            resimYukseklik =  297;
        }
        else if( width >= 400 && width < 500)
        {
            resimGenislik  = 300;
            resimYukseklik =  223;
        }
        else if( width >= 300 && width < 400)
        {
            resimGenislik  = 250;
            resimYukseklik =  186;
        }
        else if(width < 300)
        {
            resimGenislik  = 250;
            resimYukseklik =  186;
        }


        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(resimGenislik, resimYukseklik);
        parms.gravity= Gravity.CENTER;
        imvUlasim.setLayoutParams(parms);


    }
}