package com.burakekmen.camolukrehberi;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap map;
    String koyAdi;
    double lat, lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        Bundle extras = getIntent().getExtras();
        koyAdi = extras.getString("send_string");

        konumBelirle();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    private void addMarker(String title, double latitude, double longitude) {
        MarkerOptions m = new MarkerOptions();
        m.title(title);
        m.draggable(true);
        m.position(new LatLng(latitude, longitude));
        map.addMarker(m);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        map.setBuildingsEnabled(true);
        map.setTrafficEnabled(true);
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 14.5f));

        UiSettings uis = map.getUiSettings();
        uis.setCompassEnabled(true);
        uis.setZoomControlsEnabled(true);
        uis.setMyLocationButtonEnabled(true);

        addMarker(koyAdi, lat, lng);
    }


    public void konumBelirle()
    {
        switch (koyAdi)
        {
            case "AKYAPI KÖYÜ":
                lat = 40.1695053;
                lng = 38.7100829;
                break;
            case "BAYIR KÖYÜ":
                lat = 40.132662;
                lng = 38.562351;
                break;
            case "ÇAKILKAYA KÖYÜ":
                lat = 40.2097642;
                lng = 38.8127734;
                break;
            case "DALDİBİ KÖYÜ":
                lat = 40.1049859;
                lng = 38.8383973;
                break;
            case "EĞNİR KÖYÜ":
                lat = 40.1439489;
                lng = 38.5779564;
                break;
            case "FINDIKLI KÖYÜ":
                lat = 40.1342934;
                lng = 38.6480112;
                break;
            case "GÜCER KÖYÜ":
                lat = 40.1132361;
                lng = 38.8148782;
                break;
            case "GÜRÇALI KÖYÜ":
                lat = 40.1569103;
                lng = 38.5640259;
                break;
            case "HACIAHMETOĞLU KÖYÜ":
                lat = 40.1639427;
                lng = 38.6429371;
                break;
            case "HACIÖREN KÖYÜ":
                lat = 40.1749521;
                lng = 38.7993574;
                break;
            case "KALEDERE KÖYÜ":
                lat = 40.1459562;
                lng = 38.7821671;
                break;
            case "KARADİKMEN KÖYÜ":
                lat = 40.1459562;
                lng = 38.7821671;
                break;
            case "KAYACIK KÖYÜ":
                lat = 40.2077086;
                lng = 38.7732626;
                break;
            case "KAYNAR KÖYÜ":
                lat = 40.0871822;
                lng = 38.7755673;
                break;
            case "KILIÇTUTAN KÖYÜ":
                lat = 40.1533742;
                lng = 38.7498154;
                break;
            case "KOÇAK KÖYÜ":
                lat = 40.1156063;
                lng = 38.5799067;
                break;
            case "KUTLUCA KÖYÜ":
                lat = 40.1769983;
                lng = 38.7698184;
                break;
            case "OKÇAÖREN KÖYÜ":
                lat = 40.1053574;
                lng = 38.9279401;
                break;
            case "OZAN KÖYÜ":
                lat = 40.1452314;
                lng = 38.6009142;
                break;
            case "PINARLI KÖYÜ":
                lat = 40.0912861;
                lng = 38.7957834;
                break;
            case "SARPKAYA KÖYÜ":
                lat = 40.1418622;
                lng = 38.5007876;
                break;
            case "TAŞÇILAR KÖYÜ":
                lat = 40.1954873;
                lng = 38.7232611;
                break;
            case "TAŞDEMİR KÖYÜ":
                lat = 40.0989581;
                lng = 38.7657784;
                break;
            case "USLUCA KÖYÜ":
                lat = 40.1080676;
                lng = 38.8528923;
                break;
            case "YENİCE KÖYÜ":
                lat = 40.1105054;
                lng = 38.8213251;
                break;
            case "YENİKÖY KÖYÜ":
                lat = 40.1897993;
                lng = 38.7304079;
                break;
            case "YUSUFELİ KÖYÜ":
                lat = 40.1241225;
                lng = 38.6463664;
                break;
            case "DULUNDAS MAHALLESİ":
                lat = 40.1362027;
                lng = 38.7356351;
                break;
            case "HÜRRİYET MAHALLESİ":
                lat = 40.1360683;
                lng = 38.7359463;
                break;
            case "KARŞIYAKA MAHALLESİ":
                lat = 40.1371089;
                lng = 38.7334324;
                break;
            case "KÖROĞLU MAHALLESİ":
                lat = 40.135489;
                lng = 38.7346563;
                break;
            case "KURTULUŞ MAHALLESİ":
                lat = 40.1318084;
                lng = 38.7366896;
                break;
            case "KURUKOL MAHALLESİ":
                lat = 40.1052176;
                lng = 38.6535153;
                break;
            case "YAZILAR MAHALLESİ":
                lat = 40.1302668;
                lng = 38.7447358;
                break;
            case "YUVACIK MAHALLESİ":
                lat = 40.134046;
                lng = 38.734098;
                break;
            default:
                break;
        }
    }
}