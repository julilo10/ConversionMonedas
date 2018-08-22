package com.example.usuario.practica_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eCantidad;
    TextView tConversion;
    Spinner Spinner1, Spinner2;
    Button bConvertir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eCantidad = (EditText) findViewById(R.id.eCantidad);
        tConversion = (TextView) findViewById(R.id.tConversion);
        Spinner1 = (Spinner) findViewById(R.id.spi1);
        Spinner2 = (Spinner) findViewById(R.id.spi2);
        bConvertir = (Button) findViewById(R.id.bConvertir);

        String[] opciones = {"Dolar", "Euro", "Peso Colombiano"};
        String[] opciones1 = {"Dolar", "Euro", "Peso Colombiano"};


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones1);
        Spinner1.setAdapter(adapter);
        Spinner2.setAdapter(adapter1);

    }

    //Metodo del boton
    public void Calcular(View view) {
        double valor;

        valor = Double.parseDouble(eCantidad.getText().toString());
        String valorini = eCantidad.getText().toString();

        int valorini1 = Integer.parseInt(valorini);

        String seleccion = Spinner1.getSelectedItem().toString();
        String seleccion1 = Spinner2.getSelectedItem().toString();

        if (seleccion.equals("Dolar") && seleccion1.equals("Dolar")) {
            String resultado = String.valueOf(valor);
            tConversion.setText(resultado);

        } else if (seleccion.equals("Dolar") && seleccion1.equals("Euro")) {
            Double DolEuro = valor * 0.86;
            String resultado = String.valueOf(DolEuro);
            tConversion.setText(resultado);

        } else if (seleccion.equals("Dolar") && seleccion1.equals("Peso Colombiano")) {
            Double DolPeso = valor * 2979.65;
            String resultado = String.valueOf(DolPeso);
            tConversion.setText(resultado);

        } else if (seleccion.equals("Euro") && seleccion1.equals("Euro")) {
            String resultado = String.valueOf(valor);
            tConversion.setText(resultado);

        } else if (seleccion.equals("Euro") && seleccion1.equals("Dolar")) {
            Double EuroDol = valor * 1.16;
            String resultado = String.valueOf(EuroDol);
            tConversion.setText(resultado);

        } else if (seleccion.equals("Euro") && seleccion1.equals("Peso Colombiano")) {
            Double EuroPeso = valor * 3454.65;
            String resultado = String.valueOf(EuroPeso);
            tConversion.setText(resultado);

        } else if (seleccion.equals("Peso Colombiano") && seleccion1.equals("Peso Colombiano")) {
            String resultado = String.valueOf(valor);
            tConversion.setText(resultado);

        } else if (seleccion.equals("Peso Colombiano") && seleccion1.equals("Dolar")) {
            Double PesoDol = valor * 0.00033;
            String resultado = String.valueOf(PesoDol);
            tConversion.setText(resultado);

        } else if (seleccion.equals("Peso Colombiano") && seleccion1.equals("Euro")) {
            Double PesoEuro = valor * 0.00029;
            String resultado = String.valueOf(PesoEuro);
            tConversion.setText(resultado);

        }
        if (valorini1 < 0) {
            System.out.println("No se permite el ingreso de numeros negativos");

        }


    }


}
