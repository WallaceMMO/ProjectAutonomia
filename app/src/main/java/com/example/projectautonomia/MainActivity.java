/*
 *@author:<Wallace Moura Machado de Oliveira;1110482413004>
 */
package com.example.projectautonomia;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtConsumo;
    private EditText txtCombustivel;
    private Button btnCalcular;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtConsumo = findViewById(R.id.txtConsumo);
        txtCombustivel = findViewById(R.id.txtCombustivel);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAutonomy();
            }
        });
    }

    private void calculateAutonomy() {
        String consumptionStr = txtConsumo.getText().toString();
        String fuelStr = txtCombustivel.getText().toString();

        if (consumptionStr.isEmpty() || fuelStr.isEmpty()) {
            txtResultado.setText("Por favor, preencha todos os campos.");
            return;
        }

        try {
            double consumption = Double.parseDouble(consumptionStr);
            double fuel = Double.parseDouble(fuelStr);

            double autonomyInKm = consumption * fuel;
            double autonomyInMeters = autonomyInKm * 1000;

            txtResultado.setText(String.format("Autonomia: %.2f metros", autonomyInMeters));

        } catch (NumberFormatException e) {
            txtResultado.setText("Entrada inválida. Por favor, insira números válidos.");
        }
    }
}