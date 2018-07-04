package com.burakekmen.camolukrehberi;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Acilis extends Fragment {

    Activity titleChange;
    View view;

    ImageView imvAcilis;
    TextView txtIcerik,txtNasilKullanilir, txtGuncellenecekler, txtKatkiYap;
    public Acilis() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.acilis, container, false);
        titleChange.setTitle("Menü");

        elemanlariTanimla();
        yazilariDoldur();
        ekranBoyutuCek();

        return  view;
    }

    // Activity metodunu fragment içinde kullanmak içi attach işlemi yapıyoruz
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        titleChange = (MainActivity) activity;
    }

    public void elemanlariTanimla()
    {
        txtIcerik = (TextView) view.findViewById(R.id.txtIcerik);
        txtNasilKullanilir = (TextView) view.findViewById(R.id.txtNasilKullanilir);
        txtKatkiYap = (TextView) view.findViewById(R.id.txtKatkıYap);
        imvAcilis = (ImageView) view.findViewById(R.id.imvAcilis);

    }

    public void yazilariDoldur()
    {
        String icerik = "Çamoluk Rehberi uygulaması tamamen Çamoluk ilçemizi tanıtım amaçlı içeriklerden oluşmaktadır.\n\n" +
                "Coğrafya, Nüfus ve Ekonomi, Tarih, Doğal Güzellikler, Ulaşım, Köyler konuları ile tüm Çamolukluların ve Çamoluğu merak " +
                "edenlerin hizmetindedir.";

        String nasilKullanilir = "Tasarım ve kullanım açısından çok iyi bir deneyim sunan uygulamanın kullanımı;\n\n" +
                "Ekranın sol kenarından tutup ekranın sağ tarafına doğru kaydırdığınızda açılır menü karşına gelecetir.\n" +
                "Menüden de istediğiniz konu başlığını seçip kullanmaya başlayabilirsiniz.";

        String katkıYap = "Uygulamaya içerik olarak destek olmak isterseniz bana iletişim kanallarından ulaşabilirsiniz.\n\n" +
                "Hep birlikte uygulamamızı güzelleştirelim.";


        txtIcerik.setText(icerik);
        txtNasilKullanilir.setText(nasilKullanilir);
        txtKatkiYap.setText(katkıYap);
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
            resimGenislik  = 750;
            resimYukseklik =  resimGenislik;
        }
        else if( width >= 1300 && width < 1400)
        {
            resimGenislik  = 700;
            resimYukseklik =  resimGenislik;
        }
        else if( width >= 1200 && width < 1300)
        {
            resimGenislik  = 650;
            resimYukseklik =  resimGenislik;
        }
        else if( width >= 1100 && width < 1200)
        {
            resimGenislik  = 600;
            resimYukseklik =  resimGenislik;
        }
        else if( width >= 1000 && width < 1100)
        {
            resimGenislik  = 550;
            resimYukseklik =  resimGenislik;
        }
        else if( width >= 900 && width < 1000)
        {
            resimGenislik  = 500;
            resimYukseklik =  resimGenislik;
        }
        else if( width >= 800 && width < 900)
        {
            resimGenislik  = 450;
            resimYukseklik =  resimGenislik;
        }
        else if( width >= 700 && width < 800)
        {
            resimGenislik  = 400;
            resimYukseklik =  resimGenislik;
        }
        else if( width >= 600 && width < 700)
        {
            resimGenislik  = 350;
            resimYukseklik =  resimGenislik;
        }
        else if( width >= 500 && width < 600)
        {
            resimGenislik  = 300;
            resimYukseklik =  resimGenislik;
        }
        else if( width >= 400 && width < 500)
        {
            resimGenislik  = 250;
            resimYukseklik =  resimGenislik;
        }
        else if( width >= 300 && width < 400)
        {
            resimGenislik  = 250;
            resimYukseklik =  resimGenislik;
        }
        else if(width < 300)
        {
            resimGenislik  = 250;
            resimYukseklik =  resimGenislik;
        }


        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(resimGenislik, resimYukseklik);
        parms.gravity= Gravity.CENTER;
        imvAcilis.setLayoutParams(parms);


    }

}
