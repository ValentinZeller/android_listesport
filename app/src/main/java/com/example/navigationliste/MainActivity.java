package com.example.navigationliste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView liste;
    final String EXTRA_ITEM = "item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_NavigationListe);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        liste = (ListView)findViewById(R.id.liste);

        Resources res = getResources();
        String[] valeurs = res.getStringArray(R.array.sport);

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,valeurs);
        liste.setAdapter(adapter);

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("ITEM","Index : "+position+"\nValeur : "+parent.getItemAtPosition(position).toString());
                Intent intent = new Intent(MainActivity.this,ItemContent.class);
                intent.putExtra(EXTRA_ITEM,position);
                startActivity(intent);
            }
        });
    }
}