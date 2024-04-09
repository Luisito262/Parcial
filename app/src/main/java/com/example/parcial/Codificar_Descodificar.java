package com.example.parcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Codificar_Descodificar extends AppCompatActivity {

    EditText Texto;

    Button Codificar, Descodificar;

    Toolbar Parcial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codificar_descodificar);
        Texto = (EditText) findViewById(R.id.edtexto);
        Codificar = (Button) findViewById(R.id.btncodificar);
        Descodificar = (Button) findViewById(R.id.btndescodificar);

        Parcial = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(Parcial);
        setSupportActionBar(Parcial);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        Codificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = Texto.getText().toString();
                String encodedText = encodeText(text);
                Texto.setText(encodedText);
            }
        });

        Descodificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = Texto.getText().toString();
                String decodedText = decodeText(text);
                Texto.setText(decodedText);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private String encodeText(String text) {
        text = text.replaceAll("a", "@");
        text = text.replaceAll("e", "3");
        text = text.replaceAll("i", "1");
        text = text.replaceAll("o", "8");
        text = text.replaceAll("u", "5");
        text = text.replaceAll("m", "&");
        text = text.replaceAll("n", "(");
        text = text.replaceAll("p", ")");
        text = text.replaceAll("r", "#");
        return text;
    }

    private String decodeText(String text) {
        text = text.replaceAll("@", "a");
        text = text.replaceAll("3", "e");
        text = text.replaceAll("1", "i");
        text = text.replaceAll("8", "o");
        text = text.replaceAll("5", "u");
        text = text.replaceAll("&", "m");
        text = text.replaceAll("\\(", "n");
        text = text.replaceAll("\\)", "p");
        text = text.replaceAll("#", "r");
        return text;
    }



    }
