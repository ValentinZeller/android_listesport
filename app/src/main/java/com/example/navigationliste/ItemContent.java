package com.example.navigationliste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

public class ItemContent extends AppCompatActivity {

    ImageView image;
    TextView text;

    //Tableau contenant les contenus textuels des jeux
    String[] contenu;
    //Tableau contenant les id des images des jeux
    TypedArray imgPath;

    Integer[] colorArrayList;

    View view;

    final String EXTRA_ITEM = "item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_NavigationListe);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_content);

        image = (ImageView)findViewById(R.id.imageView);
        text = (TextView)findViewById(R.id.textView);
        view = (View)findViewById(R.id.layoutItem);

        //Initialisation des tableaux
        contenu = getResources().getStringArray(R.array.sport_detail);
        imgPath = getResources().obtainTypedArray(R.array.path);
        colorArrayList = new Integer[]{
                getResources().getColor(R.color.foot),
                getResources().getColor(R.color.basket),
                getResources().getColor(R.color.tennis),
                getResources().getColor(R.color.rugby),
                getResources().getColor(R.color.golf),
                getResources().getColor(R.color.boxe)};

        //Récupération de l'item sélectionné
        Intent intent = getIntent();
        int pos = intent.getIntExtra(EXTRA_ITEM,0);

        //Mise en place du contenu en fonction de l'item sélectionné
        text.setText(contenu[pos]);
        image.setImageResource(imgPath.getResourceId(pos,0));

        view.setBackgroundColor(colorArrayList[pos]);
    }
}