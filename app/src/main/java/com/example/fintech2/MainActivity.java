package com.example.fintech2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextView inpt;
    TextView res;
    Button btn;
    Spinner spn;
    Outsidecalc calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inpt = findViewById(R.id.textinput);
        res = findViewById(R.id.resulttext);
        btn = findViewById(R.id.calculatebtn);
        spn = findViewById(R.id.selectspn);
        calc = new Outsidecalc();
        String[] arraySpinner = new String[] {
                getString(R.string.Words),
                getString(R.string.Characters),
                getString(R.string.CharactersWSpace),
                getString(R.string.Letters),
                getString(R.string.Numbers)
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spn.setAdapter(adapter);

        // 1,
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!Objects.equals(inpt.getText().toString(), "")) {
                    int CountResult = calc.Count(inpt.getText().toString(), spn.getSelectedItem().toString());
                    if (CountResult > 0) {
                        res.setText(Integer.toString(CountResult));
                    } else {
                        Toast.makeText(getApplicationContext(), getString(R.string.FalseInput), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), getString(R.string.FalseInput), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}