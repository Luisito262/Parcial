package com.example.parcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText num1;

    TextView resultado;

    Button Calcular, Generar;

    Spinner Operaciones;

    Toolbar Parcial;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = (EditText) findViewById(R.id.ednum1);
        resultado = (TextView) findViewById(R.id.edresultado);
        Calcular = (Button) findViewById(R.id.btncalcular);
        Generar = (Button) findViewById(R.id.btngenerar);
        Operaciones = findViewById(R.id.Operacions_Units);

        Parcial = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(Parcial);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.Operacions_units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Operaciones.setAdapter(adapter);

        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });

        Generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generar();
            }
        });
    }


    private void calcular() {
        String numerosInput = num1.getText().toString().trim();
        List<String> listaNumeros = Arrays.asList(numerosInput.split("\\s*,\\s*"));

        // Realizar la operación seleccionada
        String operacion = Operaciones.getSelectedItem().toString();
        switch (operacion) {
            case "Promedio":
                calcularPromedio(listaNumeros);
                break;
            case "Pares e Impares":
                clasificarParesImpares(listaNumeros);
                break;
            case "Ordenar números":
                ordenarNumeros(listaNumeros);
                break;
        }
    }

    private void calcularPromedio(List<String> listaNumeros) {
        double suma = 0;
        for (String numero : listaNumeros) {
            suma += Double.parseDouble(numero);
        }
        double promedio = suma / listaNumeros.size();
        resultado.setText("Promedio: " + promedio);
    }

    private void clasificarParesImpares(List<String> listaNumeros) {
        StringBuilder resultado1 = new StringBuilder();
        resultado1.append("Números Pares: ");
        for (String numero : listaNumeros) {
            int num = Integer.parseInt(numero);
            if (num % 2 == 0) {
                resultado1.append(numero).append(", ");
            }
        }
        resultado1.append("\nNúmeros Impares: ");
        for (String numero : listaNumeros) {
            int num = Integer.parseInt(numero);
            if (num % 2 != 0) {
                resultado1.append(numero).append(", ");
            }
        }
        resultado.setText(resultado1.toString());
    }

    private void ordenarNumeros(List<String> listaNumeros) {
        StringBuilder resultado2 = new StringBuilder();
        Integer[] arrayNumeros = new Integer[listaNumeros.size()];
        for (int i = 0; i < listaNumeros.size(); i++) {
            arrayNumeros[i] = Integer.parseInt(listaNumeros.get(i));
        }
        Arrays.sort(arrayNumeros);
        resultado2.append("Números Ordenados: ");
        for (int numero : arrayNumeros) {
            resultado2.append(numero).append(", ");
        }
        resultado.setText(resultado2.toString());
    }






    private void generar() {
        // Generar números aleatorios y mostrarlos en el EditText
        Random random = new Random();
        StringBuilder randomNumbers = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            randomNumbers.append(random.nextInt(100)).append(", ");
        }
        num1.setText(randomNumbers.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_casita,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_item_Codificar) {
            Intent e = new Intent(this, Codificar_Descodificar.class);
            startActivity(e);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
