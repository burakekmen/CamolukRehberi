package com.burakekmen.camolukrehberi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.google.android.gms.ads.*;


/**
 * Created by Burak on 10.09.2016.
 */
public class ResimDetay extends AppCompatActivity{

    AdView adView;

    ImageView imgDetay;
    String resimAdi;
    String resimUrl;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resimdetay);

        Bundle extras = getIntent().getExtras();
        resimAdi = extras.getString("send_string");

        elemanTanimla();


        switch (resimAdi)
        {
            case "resim1":
                resimUrl = "http://www.camoluk.gov.tr/kurumlar/camoluk.gov.tr/Tarihi%20ve%20Do%C4%9Fal%20G%C3%BCzellikler/Bekta%C5%9Fbey%20Camii.jpg?width=1200&mode=max&quality=70&format=jpg";
                Picasso.with(this).load(resimUrl).into(imgDetay);
                break;
            case "resim2":
                resimUrl = "http://www.camoluk.gov.tr/kurumlar/camoluk.gov.tr/Tarihi%20ve%20Do%C4%9Fal%20G%C3%BCzellikler/Bekta%C5%9Fbey%20Camii%201.jpg?width=1200&mode=max&quality=70&format=jpg";
                Picasso.with(this).load(resimUrl).into(imgDetay);
                break;
            case "resim3":
                resimUrl = "http://www.camoluk.gov.tr/kurumlar/camoluk.gov.tr/Tarihi%20ve%20Do%C4%9Fal%20G%C3%BCzellikler/Bekta%C5%9Fbey%20Camii%202.jpg?width=1200&mode=max&quality=70&format=jpg";
                Picasso.with(this).load(resimUrl).into(imgDetay);
                break;
            case "resim4":
                resimUrl = "http://www.camoluk.gov.tr/kurumlar/camoluk.gov.tr/Tarihi%20ve%20Do%C4%9Fal%20G%C3%BCzellikler/Bekta%C5%9Fbey%20Camii%203.jpg?width=1200&mode=max&quality=70&format=jpg";
                Picasso.with(this).load(resimUrl).into(imgDetay);
                break;
            case "resim5":
                resimUrl = "http://www.camoluk.gov.tr/kurumlar/camoluk.gov.tr/Tarihi%20ve%20Do%C4%9Fal%20G%C3%BCzellikler/Bekta%C5%9Fbey%20Camii%204.jpg?width=1200&mode=max&quality=70&format=jpg";
                Picasso.with(this).load(resimUrl).into(imgDetay);
                break;
            case "resim6":
                resimUrl = "http://www.camoluk.gov.tr/kurumlar/camoluk.gov.tr/Tarihi%20ve%20Do%C4%9Fal%20G%C3%BCzellikler/Bekta%C5%9Fbey%20Camii%205.jpg?width=1200&mode=max&quality=70&format=jpg";
                Picasso.with(this).load(resimUrl).into(imgDetay);
                break;
            case "resim7":
                resimUrl = "http://www.camoluk.gov.tr/kurumlar/camoluk.gov.tr/Tarihi%20ve%20Do%C4%9Fal%20G%C3%BCzellikler/Bekta%C5%9Fbey%20Camii%206.jpg?width=1200&mode=max&quality=70&format=jpg";
                Picasso.with(this).load(resimUrl).into(imgDetay);
                break;
            case "resim8":
                resimUrl = "http://www.camoluk.gov.tr/kurumlar/camoluk.gov.tr/Tarihi%20ve%20Do%C4%9Fal%20G%C3%BCzellikler/Folbaba%20T%C3%BCrbesi.jpg?width=1200&mode=max&quality=70&format=jpg";
                Picasso.with(this).load(resimUrl).into(imgDetay);
                break;
            case "resim9":
                resimUrl = "http://www.camoluk.gov.tr/kurumlar/camoluk.gov.tr/Tarihi%20ve%20Do%C4%9Fal%20G%C3%BCzellikler/Hac%C4%B1ahmeto%C4%9Flu%20Kalesi2.JPG?width=1200&mode=max&quality=70&format=jpg";
                Picasso.with(this).load(resimUrl).into(imgDetay);
                break;
            case "resim10":
                resimUrl = "http://www.camoluk.gov.tr/kurumlar/camoluk.gov.tr/Tarihi%20ve%20Do%C4%9Fal%20G%C3%BCzellikler/Hac%C4%B1ahmeto%C4%9Flu%20Kalesi.jpg?width=1200&mode=max&quality=70&format=jpg";
                Picasso.with(this).load(resimUrl).into(imgDetay);
                break;
            case "resim11":
                resimUrl = "http://www.camoluk.gov.tr/kurumlar/camoluk.gov.tr/Tarihi%20ve%20Do%C4%9Fal%20G%C3%BCzellikler/Kaledere%20Kalesi.jpg?width=1200&mode=max&quality=70&format=jpg";
                Picasso.with(this).load(resimUrl).into(imgDetay);
                break;
            case "resim12":
                resimUrl = "http://www.camoluk.gov.tr/kurumlar/camoluk.gov.tr/Tarihi%20ve%20Do%C4%9Fal%20G%C3%BCzellikler/Kaledere%20Kalesi%201.jpg?width=1200&mode=max&quality=70&format=jpg";
                Picasso.with(this).load(resimUrl).into(imgDetay);
                break;
            case "resim13":
                resimUrl = "http://www.camoluk.gov.tr/kurumlar/camoluk.gov.tr/Tarihi%20ve%20Do%C4%9Fal%20G%C3%BCzellikler/Ozan%20K%C3%B6y%C3%BC%20%C5%9Eelalesi.jpg?width=1200&mode=max&quality=70&format=jpg";
                Picasso.with(this).load(resimUrl).into(imgDetay);
                break;
            case "resim14":
                resimUrl = "http://www.camoluk.gov.tr/kurumlar/camoluk.gov.tr/Tarihi%20ve%20Do%C4%9Fal%20G%C3%BCzellikler/Yenice%20%C5%9Eelaleleri%201.jpg?width=1200&mode=max&quality=70&format=jpg";
                Picasso.with(this).load(resimUrl).into(imgDetay);
                break;
            case "resim15":
                resimUrl = "http://www.camoluk.gov.tr/kurumlar/camoluk.gov.tr/Tarihi%20ve%20Do%C4%9Fal%20G%C3%BCzellikler/Yenice%20%C5%9Eelaleleri%201.jpg?width=1200&mode=max&quality=70&format=jpg";
                Picasso.with(this).load(resimUrl).into(imgDetay);
                break;
            case "resim16":
                resimUrl = "http://www.camoluk.gov.tr/kurumlar/camoluk.gov.tr/Tarihi%20ve%20Do%C4%9Fal%20G%C3%BCzellikler/Yenice%20%C5%9Eelaleleri%202.jpg?width=1200&mode=max&quality=70&format=jpg";
                Picasso.with(this).load(resimUrl).into(imgDetay);
                break;
            case "resim17":
                resimUrl = "http://www.camoluk.gov.tr/kurumlar/camoluk.gov.tr/Tarihi%20ve%20Do%C4%9Fal%20G%C3%BCzellikler/Yenice%20%C5%9Eelalesi.jpg?width=1200&mode=max&quality=70&format=jpg";
                Picasso.with(this).load(resimUrl).into(imgDetay);
                break;
            case "resim18":
                resimUrl = "http://www.camoluk.gov.tr/kurumlar/camoluk.gov.tr/Tarihi%20ve%20Do%C4%9Fal%20G%C3%BCzellikler/Yenice%20%C5%9Eelalesi%203.jpg?width=1200&mode=max&quality=70&format=jpg";
                Picasso.with(this).load(resimUrl).into(imgDetay);
                break;
            default:
                break;
        }

        internetVarmı();
    }


    public void elemanTanimla()
    {
        imgDetay = (ImageView) findViewById(R.id.imgDetay);

        adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
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

            imgDetay.setImageResource(R.drawable.rsmuyari);
            Toast.makeText(this,"Resim yüklenemedi!\nİnternet Bağlantısı Yok!",Toast.LENGTH_LONG).show();
        }
    }

}