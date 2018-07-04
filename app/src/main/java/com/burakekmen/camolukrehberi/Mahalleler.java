package com.burakekmen.camolukrehberi;

import android.app.Activity;
import android.content.Intent;
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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class Mahalleler  extends Fragment implements View.OnClickListener{

    Activity titleChange;
    View view;

    Button btnDulundas, btnHurriyet, btnKarsiyaka, btnKoroglu, btnKurtulus, btnKurukol, btnYazilar, btnYuvacik;

    public Mahalleler() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.mahalleler, container, false);
        titleChange.setTitle("Mahalleler");

        elemanlariTanimla();
        onclickTanimla();

        return  view;

    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        titleChange = (MainActivity) activity;
    }


    public void elemanlariTanimla()
    {
        btnDulundas = (Button) view.findViewById(R.id.btnDulundas);
        btnHurriyet = (Button) view.findViewById(R.id.btnHurriyet);
        btnKarsiyaka = (Button) view.findViewById(R.id.btnKarsiyaka);
        btnKoroglu = (Button) view.findViewById(R.id.btnKoroglu);
        btnKurtulus = (Button) view.findViewById(R.id.btnKurtulus);
        btnKurukol = (Button) view.findViewById(R.id.btnKurukol);
        btnYazilar = (Button) view.findViewById(R.id.btnYazilar);
        btnYuvacik = (Button) view.findViewById(R.id.btnYuvacik);

    }


    public void onclickTanimla()
    {
        btnDulundas.setOnClickListener(this);
        btnHurriyet.setOnClickListener(this);
        btnKarsiyaka.setOnClickListener(this);
        btnKoroglu.setOnClickListener(this);
        btnKurtulus.setOnClickListener(this);
        btnKurukol.setOnClickListener(this);
        btnYazilar.setOnClickListener(this);
        btnYuvacik.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int mahalleSirasi;
        String s;
        Intent i;
        switch (v.getId())
        {
            case R.id.btnDulundas:
                mahalleSirasi = 0;
                s = "DULUNDAS MAHALLESİ";
                i = new Intent(getActivity(), MahalleDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_mahalleSirasi",mahalleSirasi);
                startActivity(i);
                break;
            case R.id.btnHurriyet:
                mahalleSirasi = 1;
                s = "HÜRRİYET MAHALLESİ";
                i = new Intent(getActivity(), MahalleDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_mahalleSirasi",mahalleSirasi);
                startActivity(i);
                break;
            case R.id.btnKarsiyaka:
                mahalleSirasi = 2;
                s = "KARŞIYAKA MAHALLESİ";
                i = new Intent(getActivity(), MahalleDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_mahalleSirasi",mahalleSirasi);
                startActivity(i);
                break;
            case R.id.btnKoroglu:
                mahalleSirasi = 3;
                s = "KÖROĞLU MAHALLESİ";
                i = new Intent(getActivity(), MahalleDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_mahalleSirasi",mahalleSirasi);
                startActivity(i);
                break;
            case R.id.btnKurtulus:
                mahalleSirasi = 4;
                s = "KURTULUŞ MAHALLESİ";
                i = new Intent(getActivity(), MahalleDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_mahalleSirasi",mahalleSirasi);
                startActivity(i);
                break;
            case R.id.btnKurukol:
                mahalleSirasi = 5;
                s = "KURUKOL MAHALLESİ";
                i = new Intent(getActivity(), MahalleDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_mahalleSirasi",mahalleSirasi);
                startActivity(i);
                break;
            case R.id.btnYazilar:
                mahalleSirasi = 6;
                s = "YAZILAR MAHALLESİ";
                i = new Intent(getActivity(), MahalleDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_mahalleSirasi",mahalleSirasi);
                startActivity(i);
                break;
            case R.id.btnYuvacik:
                mahalleSirasi = 7;
                s = "YUVACIK MAHALLESİ";
                i = new Intent(getActivity(), MahalleDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_mahalleSirasi",mahalleSirasi);
                startActivity(i);
                break;
            default:
                break;
        }

    }
}