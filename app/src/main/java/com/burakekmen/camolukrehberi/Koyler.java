package com.burakekmen.camolukrehberi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Koyler extends Fragment implements View.OnClickListener {

    View view;
    Activity titleChange;
    Button btnAkyapi, btnBayir, btnCakilkaya, btnDaldibi, btnEgnir, btnFindikli, btnGucer, btnGurcali,
            btnHaciahmet, btnHacioren, btnKaledere, btnKaradikmen, btnKayacik, btnKaynar, btnKilictutan,
            btnKocak, btnKutluca, btnOkcaoren, btnOzan, btnPinarli, btnSarpkaya, btnTascilar, btnTasdemir,
            btnUsluca, btnYenice, btnYenikoy, btnYusufeli;

    public Koyler() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.koyler, container, false);
        titleChange.setTitle("Köyler");
        elemanlariTanimla();
        onclickTanimla();

        return view;

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        titleChange = (MainActivity) activity;

    }


    public void elemanlariTanimla()
    {
        btnAkyapi = (Button) view.findViewById(R.id.btnAkyapi);
        btnBayir = (Button) view.findViewById(R.id.btnBayir);
        btnCakilkaya = (Button) view.findViewById(R.id.btnCakilkaya);
        btnDaldibi = (Button) view.findViewById(R.id.btnDaldibi);
        btnEgnir = (Button) view.findViewById(R.id.btnEgnir);
        btnFindikli = (Button) view.findViewById(R.id.btnFindikli);
        btnGucer = (Button) view.findViewById(R.id.btnGucer);
        btnGurcali = (Button) view.findViewById(R.id.btnGürcali);
        btnHaciahmet = (Button) view.findViewById(R.id.btnHaciAhmet);
        btnHacioren = (Button) view.findViewById(R.id.btnHacioren);
        btnKaledere = (Button) view.findViewById(R.id.btnKaledere);
        btnKaradikmen = (Button) view.findViewById(R.id.btnKaradikmen);
        btnKayacik = (Button) view.findViewById(R.id.btnKayacik);
        btnKaynar = (Button) view.findViewById(R.id.btnKaynar);
        btnKilictutan = (Button) view.findViewById(R.id.btnKilictutan);
        btnKocak = (Button) view.findViewById(R.id.btnKocak);
        btnKutluca = (Button) view.findViewById(R.id.btnKutluca);
        btnOkcaoren = (Button) view.findViewById(R.id.btnOkcaoren);
        btnOzan = (Button) view.findViewById(R.id.btnOzan);
        btnPinarli = (Button) view.findViewById(R.id.btnPinarli);
        btnSarpkaya = (Button) view.findViewById(R.id.btnSarpkaya);
        btnTascilar = (Button) view.findViewById(R.id.btnTascilar);
        btnTasdemir = (Button) view.findViewById(R.id.btnTasdemir);
        btnUsluca = (Button) view.findViewById(R.id.btnUsluca);
        btnYenice = (Button) view.findViewById(R.id.btnYenice);
        btnYenikoy = (Button) view.findViewById(R.id.btnYenikoy);
        btnYusufeli = (Button) view.findViewById(R.id.btnYusufeli);

    }


    public void onclickTanimla()
    {
        btnAkyapi.setOnClickListener(this);
        btnBayir.setOnClickListener(this);
        btnCakilkaya.setOnClickListener(this);
        btnDaldibi.setOnClickListener(this);
        btnEgnir.setOnClickListener(this);
        btnFindikli.setOnClickListener(this);
        btnGucer.setOnClickListener(this);
        btnGurcali.setOnClickListener(this);
        btnHaciahmet.setOnClickListener(this);
        btnHacioren.setOnClickListener(this);
        btnKaledere.setOnClickListener(this);
        btnKaradikmen.setOnClickListener(this);
        btnKayacik.setOnClickListener(this);
        btnKaynar.setOnClickListener(this);
        btnKilictutan.setOnClickListener(this);
        btnKocak.setOnClickListener(this);
        btnKutluca.setOnClickListener(this);
        btnOkcaoren.setOnClickListener(this);
        btnOzan.setOnClickListener(this);
        btnPinarli.setOnClickListener(this);
        btnSarpkaya.setOnClickListener(this);
        btnTascilar.setOnClickListener(this);
        btnTasdemir.setOnClickListener(this);
        btnUsluca.setOnClickListener(this);
        btnYenice.setOnClickListener(this);
        btnYenikoy.setOnClickListener(this);
        btnYusufeli.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        int koySirasi;
        String s;
        Intent i;
        switch (v.getId()) {
            case R.id.btnAkyapi:
                s = btnAkyapi.getText().toString();
                koySirasi = 0;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnBayir:
                s = btnBayir.getText().toString();
                koySirasi = 1;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnCakilkaya:
                s = btnCakilkaya.getText().toString();
                koySirasi = 2;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnDaldibi:
                s = btnDaldibi.getText().toString();
                koySirasi = 3;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnEgnir:
                s = btnEgnir.getText().toString();
                koySirasi = 4;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnFindikli:
                s = btnFindikli.getText().toString();
                koySirasi = 5;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnGucer:
                s = btnGucer.getText().toString();
                koySirasi = 6;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnGürcali:
                s = btnGurcali.getText().toString();
                koySirasi = 7;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnHaciAhmet:
                s = btnHaciahmet.getText().toString();
                koySirasi = 8;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnHacioren:
                s = btnHacioren.getText().toString();
                koySirasi = 9;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnKaledere:
                s = btnKaledere.getText().toString();
                koySirasi = 10;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnKaradikmen:
                s = btnKaradikmen.getText().toString();
                koySirasi = 11;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnKayacik:
                s = btnKayacik.getText().toString();
                koySirasi = 12;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnKaynar:
                s = btnKaynar.getText().toString();
                koySirasi = 13;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnKilictutan:
                s = btnKilictutan.getText().toString();
                koySirasi = 14;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnKocak:
                s = btnKocak.getText().toString();
                koySirasi = 15;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnKutluca:
                s = btnKutluca.getText().toString();
                koySirasi = 16;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnOkcaoren:
                s = btnOkcaoren.getText().toString();
                koySirasi = 17;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnOzan:
                s = btnOzan.getText().toString();
                koySirasi = 18;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnPinarli:
                s = btnPinarli.getText().toString();
                koySirasi = 19;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnSarpkaya:
                s = btnSarpkaya.getText().toString();
                koySirasi = 20;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnTascilar:
                s = btnTascilar.getText().toString();
                koySirasi = 21;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnTasdemir:
                s = btnTasdemir.getText().toString();
                koySirasi = 22;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnUsluca:
                s = btnUsluca.getText().toString();
                koySirasi = 23;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnYenice:
                s = btnYenice.getText().toString();
                koySirasi = 24;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnYenikoy:
                s = btnYenikoy.getText().toString();
                koySirasi = 25;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            case R.id.btnYusufeli:
                s = btnYusufeli.getText().toString();
                koySirasi = 26;
                i = new Intent(getActivity(), KoyDetay.class);
                i.putExtra("send_string",s);
                i.putExtra("send_koySirasi",koySirasi);
                startActivity(i);
                break;
            default:
                break;
        }

    }

}
