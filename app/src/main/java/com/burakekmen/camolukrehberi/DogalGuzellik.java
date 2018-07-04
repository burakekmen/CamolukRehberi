package com.burakekmen.camolukrehberi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DogalGuzellik extends Fragment implements View.OnClickListener{

    Activity titleChange;
    View view;
    Button btnResim1, btnResim2, btnResim3, btnResim4, btnResim5, btnResim6, btnResim7, btnResim8, btnResim9, btnResim10,
            btnResim11, btnResim12, btnResim13, btnResim14, btnResim15, btnResim16, btnResim17, btnResim18;

    public DogalGuzellik() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.dogalguzellik, container, false);
        titleChange.setTitle("Tarihi ve Doğal Güzellikler");

        elemanlariTanimla();
        onclickTanimla();

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
        btnResim1 = (Button) view.findViewById(R.id.btnResim1);
        btnResim2 = (Button) view.findViewById(R.id.btnResim2);
        btnResim3 = (Button) view.findViewById(R.id.btnResim3);
        btnResim4 = (Button) view.findViewById(R.id.btnResim4);
        btnResim5 = (Button) view.findViewById(R.id.btnResim5);
        btnResim6 = (Button) view.findViewById(R.id.btnResim6);
        btnResim7 = (Button) view.findViewById(R.id.btnResim7);
        btnResim8 = (Button) view.findViewById(R.id.btnResim8);
        btnResim9 = (Button) view.findViewById(R.id.btnResim9);
        btnResim10 = (Button) view.findViewById(R.id.btnResim10);
        btnResim11 = (Button) view.findViewById(R.id.btnResim11);
        btnResim12 = (Button) view.findViewById(R.id.btnResim12);
        btnResim13 = (Button) view.findViewById(R.id.btnResim13);
        btnResim14 = (Button) view.findViewById(R.id.btnResim14);
        btnResim15 = (Button) view.findViewById(R.id.btnResim15);
        btnResim16 = (Button) view.findViewById(R.id.btnResim16);
        btnResim17 = (Button) view.findViewById(R.id.btnResim17);
        btnResim18 = (Button) view.findViewById(R.id.btnResim18);
    }


    public void onclickTanimla()
    {
        btnResim1.setOnClickListener(this);
        btnResim2.setOnClickListener(this);
        btnResim3.setOnClickListener(this);
        btnResim4.setOnClickListener(this);
        btnResim5.setOnClickListener(this);
        btnResim6.setOnClickListener(this);
        btnResim7.setOnClickListener(this);
        btnResim8.setOnClickListener(this);
        btnResim9.setOnClickListener(this);
        btnResim10.setOnClickListener(this);
        btnResim11.setOnClickListener(this);
        btnResim12.setOnClickListener(this);
        btnResim13.setOnClickListener(this);
        btnResim14.setOnClickListener(this);
        btnResim15.setOnClickListener(this);
        btnResim16.setOnClickListener(this);
        btnResim17.setOnClickListener(this);
        btnResim18.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent i = null;
        String s;
        switch (v.getId())
        {
            case R.id.btnResim1:
                Toast.makeText(getActivity(), "Bektaşbey Camii", Toast.LENGTH_SHORT).show();
                s = "resim1";
                i = new Intent(getActivity(), ResimDetay.class);
                i.putExtra("send_string",s);
                startActivity(i);
                break;
            case R.id.btnResim2:
                Toast.makeText(getActivity(), "Bektaşbey Camii", Toast.LENGTH_SHORT).show();
                s = "resim2";
                i = new Intent(getActivity(), ResimDetay.class);
                i.putExtra("send_string",s);
                startActivity(i);
                break;
            case R.id.btnResim3:
                Toast.makeText(getActivity(), "Bektaşbey Camii", Toast.LENGTH_SHORT).show();
                s = "resim3";
                i = new Intent(getActivity(), ResimDetay.class);
                i.putExtra("send_string",s);
                startActivity(i);
                break;
            case R.id.btnResim4:
                Toast.makeText(getActivity(), "Bektaşbey Camii", Toast.LENGTH_SHORT).show();
                s = "resim4";
                i = new Intent(getActivity(), ResimDetay.class);
                i.putExtra("send_string",s);
                startActivity(i);
                break;
            case R.id.btnResim5:
                Toast.makeText(getActivity(), "Bektaşbey Camii", Toast.LENGTH_SHORT).show();
                s = "resim5";
                i = new Intent(getActivity(), ResimDetay.class);
                i.putExtra("send_string",s);
                startActivity(i);
                break;
            case R.id.btnResim6:
                Toast.makeText(getActivity(), "Bektaşbey Camii", Toast.LENGTH_SHORT).show();
                s = "resim6";
                i = new Intent(getActivity(), ResimDetay.class);
                i.putExtra("send_string",s);
                startActivity(i);
                break;
            case R.id.btnResim7:
                Toast.makeText(getActivity(), "Bektaşbey Camii", Toast.LENGTH_SHORT).show();
                s = "resim7";
                i = new Intent(getActivity(), ResimDetay.class);
                i.putExtra("send_string",s);
                startActivity(i);
                break;
            case R.id.btnResim8:
                Toast.makeText(getActivity(), "Folbaba Türbesi", Toast.LENGTH_SHORT).show();
                s = "resim8";
                i = new Intent(getActivity(), ResimDetay.class);
                i.putExtra("send_string",s);
                startActivity(i);
                break;
            case R.id.btnResim9:
                Toast.makeText(getActivity(), "Hacıahmetoğlu Kalesi", Toast.LENGTH_SHORT).show();
                s = "resim9";
                i = new Intent(getActivity(), ResimDetay.class);
                i.putExtra("send_string",s);
                startActivity(i);
                break;
            case R.id.btnResim10:
                Toast.makeText(getActivity(), "Hacıahmetoğlu Kalesi", Toast.LENGTH_SHORT).show();
                s = "resim10";
                i = new Intent(getActivity(), ResimDetay.class);
                i.putExtra("send_string",s);
                startActivity(i);
                break;
            case R.id.btnResim11:
                Toast.makeText(getActivity(), "Kaledere Kalesi", Toast.LENGTH_SHORT).show();
                s = "resim11";
                i = new Intent(getActivity(), ResimDetay.class);
                i.putExtra("send_string",s);
                startActivity(i);
                break;
            case R.id.btnResim12:
                Toast.makeText(getActivity(), "Kaledere Kalesi", Toast.LENGTH_SHORT).show();
                s = "resim12";
                i = new Intent(getActivity(), ResimDetay.class);
                i.putExtra("send_string",s);
                startActivity(i);
                break;
            case R.id.btnResim13:
                Toast.makeText(getActivity(), "Ozan Köyü Şelalesi", Toast.LENGTH_SHORT).show();
                s = "resim13";
                i = new Intent(getActivity(), ResimDetay.class);
                i.putExtra("send_string",s);
                startActivity(i);
                break;
            case R.id.btnResim14:
                Toast.makeText(getActivity(), "Ozan Köyü Şelalesi", Toast.LENGTH_SHORT).show();
                s = "resim14";
                i = new Intent(getActivity(), ResimDetay.class);
                i.putExtra("send_string",s);
                startActivity(i);
                break;
            case R.id.btnResim15:
                Toast.makeText(getActivity(), "Yenice Şelaleleri", Toast.LENGTH_SHORT).show();
                s = "resim15";
                i = new Intent(getActivity(), ResimDetay.class);
                i.putExtra("send_string",s);
                startActivity(i);
                break;
            case R.id.btnResim16:
                Toast.makeText(getActivity(), "Yenice Şelaleleri", Toast.LENGTH_SHORT).show();
                s = "resim16";
                i = new Intent(getActivity(), ResimDetay.class);
                i.putExtra("send_string",s);
                startActivity(i);
                break;
            case R.id.btnResim17:
                Toast.makeText(getActivity(), "Yenice Şelaleleri", Toast.LENGTH_SHORT).show();
                s = "resim17";
                i = new Intent(getActivity(), ResimDetay.class);
                i.putExtra("send_string",s);
                startActivity(i);
                break;
            case R.id.btnResim18:
                Toast.makeText(getActivity(), "Yenice Şelaleleri", Toast.LENGTH_SHORT).show();
                s = "resim18";
                i = new Intent(getActivity(), ResimDetay.class);
                i.putExtra("send_string",s);
                startActivity(i);
                break;
            default:
                break;
        }
    }
}
