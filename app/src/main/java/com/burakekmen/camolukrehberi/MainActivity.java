package com.burakekmen.camolukrehberi;

import android.app.Activity;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    ListView lw_SlideMenu;
    com.burakekmen.camolukrehberi.SlideMenuAdapter adapter;

    List<com.burakekmen.camolukrehberi.SlideMenuItem> items;
    String[] titles;
    TypedArray icons;
    CharSequence actionBarTitle, appTitle;
    String fragment_name = "";

    @SuppressWarnings("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lw_SlideMenu = (ListView) findViewById(R.id.lw_Menu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        // Menü başlıklarını kaynak dosyasından çekiyor
        titles = getResources().getStringArray(R.array.slidemenu_item);

        // icons dizimizi kaynak dosyadan çekiyoruz
        icons = getResources().obtainTypedArray(R.array.icons);
        // Ram i şişirmemek için resimleri yeniden yükler
        //icons.recycle();

        items = new ArrayList<SlideMenuItem>();

        items.add(new SlideMenuItem(titles[0], icons.getResourceId(0, -1)));
        items.add(new SlideMenuItem(titles[1], icons.getResourceId(1, -1)));
        items.add(new SlideMenuItem(titles[2], icons.getResourceId(2, -1)));
        items.add(new SlideMenuItem(titles[3], icons.getResourceId(3, -1)));
        items.add(new SlideMenuItem(titles[4], icons.getResourceId(4, -1)));
        items.add(new SlideMenuItem(titles[5], icons.getResourceId(5, -1)));
        items.add(new SlideMenuItem(titles[6], icons.getResourceId(6, -1)));
        items.add(new SlideMenuItem(titles[7], icons.getResourceId(7, -1)));
        items.add(new SlideMenuItem(titles[8], icons.getResourceId(8, -1)));

        // Açılışta uygulama ismini alıyor
        appTitle = getSupportActionBar().getTitle();
        actionBarTitle = items.get(0).getTitle();

        // Menüdeki her list item a click veriyor
        lw_SlideMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                displayPage(i-1);

                // Her item a tıklanıldığında actionBar daki görünen başlığı değiştiriyor
                actionBarTitle = items.get(i-1).getTitle();

                // menü tıklamadan sonra kapanıyor
                drawerLayout.closeDrawer(lw_SlideMenu);
            }
        });



        adapter = new SlideMenuAdapter(items, getApplicationContext());
        lw_SlideMenu.setAdapter(adapter);

        View header=getLayoutInflater().inflate(R.layout.solmenu, null);
        ImageView profil=(ImageView)header.findViewById(R.id.solmenursm);
        TextView txtPrfl = (TextView)header.findViewById(R.id.prfladi);
        txtPrfl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "Yazıya Tıklandı", Toast.LENGTH_SHORT).show();
            }
        });
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                //Toast.makeText(getApplicationContext(), "Resme Tıklandı", Toast.LENGTH_SHORT).show();
            }
        });
        lw_SlideMenu.addHeaderView(header);

        // Toggle butonuna click veriyoruz, home butonu gibi davranmasını sağlıyor.
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // toggle nesnesi oluşturuyoruz.
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.opened, R.string.closed) {

            @Override
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(appTitle);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                getSupportActionBar().setTitle(actionBarTitle);

            }
        };

        // toggle açılıp kapanmasına göre, toggle iconu değiştiriyor.
        toggle.syncState();
        // menü açılıp kapanmasını dinliyoruz.
        drawerLayout.setDrawerListener(toggle);

        // Açılışta fragment başlatma
        displayPage(0);
    }

    private void displayPage(int position) {

        Fragment fragment = null;

        switch (position)
        {
            case 0:
                fragment = new Acilis();
                fragment_name = "Açılış";
                break;
            case 1:
                fragment = new Cografya();
                fragment_name = "Coğrafya";
                break;
            case 2:
                fragment = new NufusEkono();
                fragment_name = "NufusEkono";
                break;
            case 3:
                fragment = new Tarih();
                fragment_name = "Tarih";
                break;
            case 4:
                fragment = new DogalGuzellik();
                fragment_name = "DogalGuzellik";
                break;
            case 5:
                fragment = new Ulasim();
                fragment_name = "Ulasim";
                break;
            case 6:
                fragment = new Mahalleler();
                fragment_name = "Mahalleler";
                break;
            case 7:
                fragment = new Koyler();
                fragment_name = "Koyler";
                break;
            case 8:
                fragment = new Hakkinda();
                fragment_name = "Hakkinda";
                break;
            default:
                break;
        }

        if(fragment != null){

            // Fragment transaction nesnesi ile fragment ekranları arasında geçiş sağlıyor
            FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.container, fragment).addToBackStack(fragment_name).commit();

            // Stack te bulunan fragment sayısını alıyor
            int count = getSupportFragmentManager().getBackStackEntryCount();

            if(count!=0) {
                // Son fragment alınıyor
                FragmentManager.BackStackEntry backStackEntry = getSupportFragmentManager().getBackStackEntryAt(count - 1);

                // Son fragment ile seçilen fragment aynı ise eski fragment siliniyor
                if (backStackEntry.getName().contains(fragment_name)) {
                    getSupportFragmentManager().popBackStack();
                }
            }
        }
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Uygulama Kapansın mı?");
        alertDialogBuilder
                .setMessage("Kapatmak İçin EVET tuşuna basın!")
                .setCancelable(false)
                .setPositiveButton("EVET",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        })

                .setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void setTitle(CharSequence title) {

        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        // toggle icona tıklanıldığında menünün açılmasını sağlıyor
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        if (id == R.id.action_settings) {
            Toast.makeText(this, "Burak EKMEN\nYazılım Mühendisliği Öğrencisi\n\nMANİSA CELAL BAYAR ÜNİVERSİTESİ\n\nmail : ekmen.burak@hotmail.com", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

}
