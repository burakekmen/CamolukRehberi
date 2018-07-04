package com.burakekmen.camolukrehberi;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Hakkinda extends Fragment implements View.OnClickListener{

    Activity titleChange;
    View view;

    ImageView imvHakkinda;
    TextView txtBiografi;
    Button btnMail, btnLinkedin, btnInstagram, btnFacebook, btnTwitter;

    public Hakkinda() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.hakkinda, container, false);
        titleChange.setTitle("Yapımcı Hakkında");

        elemanlariTanimla();
        onclickTanimla();
        biyografiOlustur();
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
        txtBiografi = (TextView) view.findViewById(R.id.txtBiografi);

        btnMail = (Button) view.findViewById(R.id.btnmail);
        btnLinkedin = (Button) view.findViewById(R.id.btnLinkedin);
        btnInstagram = (Button) view.findViewById(R.id.btnInstagram);
        btnFacebook = (Button) view.findViewById(R.id.btnFacebook);
        btnTwitter = (Button) view.findViewById(R.id.btnTwitter);
        imvHakkinda = (ImageView) view.findViewById(R.id.imvHakkinda);
    }


    public void onclickTanimla()
    {
        btnMail.setOnClickListener(this);
        btnLinkedin.setOnClickListener(this);
        btnInstagram.setOnClickListener(this);
        btnFacebook.setOnClickListener(this);
        btnTwitter.setOnClickListener(this);

    }

    @Override
    public void onClick(View v)
    {
        Intent i;

        switch (v.getId())
        {
            case R.id.btnmail:
                Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Konu");
                intent.putExtra(Intent.EXTRA_TEXT, "İçerik");
                intent.setData(Uri.parse("mailto:ekmen.burak@hotmail.com")); // or just "mailto:" for blank
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
                startActivity(intent);
                break;
            case R.id.btnLinkedin:
                i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.addCategory(Intent.CATEGORY_BROWSABLE);
                i.setData(Uri.parse("https://www.linkedin.com/in/ekmenburak"));
                startActivity(i);
                break;
            case R.id.btnInstagram:
                i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.addCategory(Intent.CATEGORY_BROWSABLE);
                i.setData(Uri.parse("https://www.instagram.com/brkekmen/"));
                startActivity(i);
                break;
            case R.id.btnFacebook:
                i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.addCategory(Intent.CATEGORY_BROWSABLE);
                i.setData(Uri.parse("https://www.facebook.com/ekmen.burak"));
                startActivity(i);
                break;
            case R.id.btnTwitter:
                i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.addCategory(Intent.CATEGORY_BROWSABLE);
                i.setData(Uri.parse("https://twitter.com/brkekmn"));
                startActivity(i);
                break;
            default:
                break;
        }
    }

    public void biyografiOlustur()
    {
        String bio = "1995 yılı Mersin doğumluyum. Aslen Çamoluk-Yeniköylüyüm.\n\nLise öğrenimimi Haydarpaşa Anadolu Teknik Lisesi-Veri Tabanı Programcılığı bölümü okuyarak 2013 yılında tamamladım ve\n" +
                "aynı yıl içerisinde Manisa Celal Bayar Üniversitesi-Yazılım Mühendisliği bölümünü kazandım.\n\n" +
                "Şu anda Manisa Celal Bayar Üniversitesi'nde 3.sınıf mühendislik öğrencisiyim.\n\n" +
                "Kendimi geliştirmek için böyle çalışmalar yapmaktayım. Yapmışken de hemşehrilerime de faydam " +
                "olsun diye böyle bir uygulama yapıp sizlerin hizmetine sunmaktan gurur duyarım.\n\n" +
                "İyi Bir Hayat Dilerim.\n\n\nBurak EKMEN\nekmen.burak@hotmail.com\n";

        txtBiografi.setText(bio);
    }


    public void ekranBoyutuCek()
    {
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        int width = display.getWidth();  // deprecated
        int height = display.getHeight();

        int resimGenislik  = 0;
        int resimYukseklik = 0;

        int mailGenislik = 0;
        int mailYukseklik = 0;

        int linkedinGenislik = 0;
        int linkedinYukseklik = 0;

        int instagramGenislik = 0;
        int instagramYukseklik = 0;

        int facebookGenislik = 0;
        int facebookYukseklik = 0;

        int twitterGenislik = 0;
        int twitterYukseklik = 0;



        if(width >= 1400)
        {
            resimGenislik  = 800;
            resimYukseklik =  1109;

            mailGenislik  = 250;
            mailYukseklik = mailGenislik;

            linkedinGenislik = 250;
            linkedinYukseklik = linkedinGenislik;

            instagramGenislik = 250;
            instagramYukseklik = instagramGenislik;

            facebookGenislik = 250;
            facebookYukseklik = facebookGenislik;

            twitterGenislik = 250;
            twitterYukseklik = twitterGenislik;
        }
        else if( width >= 1300 && width < 1400)
        {
            resimGenislik  = 800;
            resimYukseklik =  1109;

            mailGenislik  = 250;
            mailYukseklik = mailGenislik;

            linkedinGenislik = 250;
            linkedinYukseklik = linkedinGenislik;

            instagramGenislik = 250;
            instagramYukseklik = instagramGenislik;

            facebookGenislik = 250;
            facebookYukseklik = facebookGenislik;

            twitterGenislik = 250;
            twitterYukseklik = twitterGenislik;
        }
        else if( width >= 1200 && width < 1300)
        {
            resimGenislik  = 750;
            resimYukseklik =  1040;

            mailGenislik  = 250;
            mailYukseklik = mailGenislik;

            linkedinGenislik = 250;
            linkedinYukseklik = linkedinGenislik;

            instagramGenislik = 250;
            instagramYukseklik = instagramGenislik;

            facebookGenislik = 250;
            facebookYukseklik = facebookGenislik;

            twitterGenislik = 250;
            twitterYukseklik = twitterGenislik;
        }
        else if( width >= 1100 && width < 1200)
        {
            resimGenislik  = 750;
            resimYukseklik =  1040;

            mailGenislik  = 225;
            mailYukseklik = mailGenislik;

            linkedinGenislik = 225;
            linkedinYukseklik = linkedinGenislik;

            instagramGenislik = 225;
            instagramYukseklik = instagramGenislik;

            facebookGenislik = 225;
            facebookYukseklik = facebookGenislik;

            twitterGenislik = 225;
            twitterYukseklik = twitterGenislik;
        }
        else if( width >= 1000 && width < 1100)
        {
            resimGenislik  = 650;
            resimYukseklik =  901;

            mailGenislik  = 210;
            mailYukseklik = mailGenislik;

            linkedinGenislik = 210;
            linkedinYukseklik = linkedinGenislik;

            instagramGenislik = 210;
            instagramYukseklik = instagramGenislik;

            facebookGenislik = 210;
            facebookYukseklik = facebookGenislik;

            twitterGenislik = 210;
            twitterYukseklik = twitterGenislik;
        }
        else if( width >= 900 && width < 1000)
        {
            resimGenislik  = 600;
            resimYukseklik =  832;

            mailGenislik  = 200;
            mailYukseklik = mailGenislik;

            linkedinGenislik = 200;
            linkedinYukseklik = linkedinGenislik;

            instagramGenislik = 200;
            instagramYukseklik = instagramGenislik;

            facebookGenislik = 200;
            facebookYukseklik = facebookGenislik;

            twitterGenislik = 200;
            twitterYukseklik = twitterGenislik;
        }
        else if( width >= 800 && width < 900)
        {
            resimGenislik  = 500;
            resimYukseklik =  693;

            mailGenislik  = 200;
            mailYukseklik = mailGenislik;

            linkedinGenislik = 200;
            linkedinYukseklik = linkedinGenislik;

            instagramGenislik = 200;
            instagramYukseklik = instagramGenislik;

            facebookGenislik = 200;
            facebookYukseklik = facebookGenislik;

            twitterGenislik = 200;
            twitterYukseklik = twitterGenislik;
        }
        else if( width >= 700 && width < 800)
        {
            resimGenislik  = 450;
            resimYukseklik =  624;

            mailGenislik  = 175;
            mailYukseklik = mailGenislik;

            linkedinGenislik = 175;
            linkedinYukseklik = linkedinGenislik;

            instagramGenislik = 175;
            instagramYukseklik = instagramGenislik;

            facebookGenislik = 175;
            facebookYukseklik = facebookGenislik;

            twitterGenislik = 175;
            twitterYukseklik = twitterGenislik;
        }
        else if( width >= 600 && width < 700)
        {
            resimGenislik  = 350;
            resimYukseklik =  485;

            mailGenislik  = 150;
            mailYukseklik = mailGenislik;

            linkedinGenislik = 150;
            linkedinYukseklik = linkedinGenislik;

            instagramGenislik = 150;
            instagramYukseklik = instagramGenislik;

            facebookGenislik = 150;
            facebookYukseklik = facebookGenislik;

            twitterGenislik = 150;
            twitterYukseklik = twitterGenislik;
        }
        else if( width >= 500 && width < 600)
        {
            resimGenislik  = 250;
            resimYukseklik =  346;

            mailGenislik  = 100;
            mailYukseklik = mailGenislik;

            linkedinGenislik = 100;
            linkedinYukseklik = linkedinGenislik;

            instagramGenislik = 100;
            instagramYukseklik = instagramGenislik;

            facebookGenislik = 100;
            facebookYukseklik = facebookGenislik;

            twitterGenislik = 100;
            twitterYukseklik = twitterGenislik;
        }
        else if( width >= 400 && width < 500)
        {
            resimGenislik  = 200;
            resimYukseklik =  277;

            mailGenislik  = 85;
            mailYukseklik = mailGenislik;

            linkedinGenislik = 85;
            linkedinYukseklik = linkedinGenislik;

            instagramGenislik = 85;
            instagramYukseklik = instagramGenislik;

            facebookGenislik = 85;
            facebookYukseklik = facebookGenislik;

            twitterGenislik = 85;
            twitterYukseklik = twitterGenislik;
        }
        else if( width >= 300 && width < 400)
        {
            resimGenislik  = 150;
            resimYukseklik =  208;

            mailGenislik  = 65;
            mailYukseklik = mailGenislik;

            linkedinGenislik = 65;
            linkedinYukseklik = linkedinGenislik;

            instagramGenislik = 65;
            instagramYukseklik = instagramGenislik;

            facebookGenislik = 65;
            facebookYukseklik = facebookGenislik;

            twitterGenislik = 65;
            twitterYukseklik = twitterGenislik;
        }
        else if(width < 300)
        {
            resimGenislik  = 150;
            resimYukseklik =  208;

            mailGenislik  = 50;
            mailYukseklik = mailGenislik;

            linkedinGenislik = 50;
            linkedinYukseklik = linkedinGenislik;

            instagramGenislik = 50;
            instagramYukseklik = instagramGenislik;

            facebookGenislik = 50;
            facebookYukseklik = facebookGenislik;

            twitterGenislik = 50;
            twitterYukseklik = twitterGenislik;
        }


        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(resimGenislik, resimYukseklik);
        parms.gravity= Gravity.CENTER;
        imvHakkinda.setLayoutParams(parms);

        LinearLayout.LayoutParams parmsMail = new LinearLayout.LayoutParams(mailGenislik, mailYukseklik);
        parmsMail.gravity= Gravity.CENTER;
        btnMail.setLayoutParams(parmsMail);

        LinearLayout.LayoutParams parmsLinkedin = new LinearLayout.LayoutParams(linkedinGenislik, linkedinYukseklik);
        parmsLinkedin.gravity= Gravity.CENTER;
        btnLinkedin.setLayoutParams(parmsLinkedin);

        LinearLayout.LayoutParams parmsInstagram = new LinearLayout.LayoutParams(instagramGenislik, instagramYukseklik);
        parmsInstagram.gravity= Gravity.CENTER;
        btnInstagram.setLayoutParams(parmsInstagram);

        LinearLayout.LayoutParams parmsFacebook = new LinearLayout.LayoutParams(facebookGenislik, facebookYukseklik);
        parmsFacebook.gravity= Gravity.CENTER;
        btnFacebook.setLayoutParams(parmsFacebook);

        LinearLayout.LayoutParams parmsTwitter = new LinearLayout.LayoutParams(twitterGenislik, twitterYukseklik);
        parmsTwitter.gravity= Gravity.CENTER;
        btnTwitter.setLayoutParams(parmsTwitter);


    }
}