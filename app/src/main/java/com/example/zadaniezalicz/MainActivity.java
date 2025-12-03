package com.example.zadaniezalicz;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Spinner spinner = findViewById(R.id.spinnerItems);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.spinnerItems, android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button btnGen = findViewById(R.id.btnGenerate);
        Button btnConf = findViewById(R.id.btnConfirm);
        EditText numQua = findViewById(R.id.numbersQuantity);
        EditText name = findViewById(R.id.name);
        EditText surname = findViewById(R.id.surname);
        CheckBox letters = findViewById(R.id.Letters);
        CheckBox numbers = findViewById(R.id.numbers);
        CheckBox spChar = findViewById(R.id.specialChar);

        String chars = "abcdefghijklmnopqrstuvwxyz";



        btnGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String qua = numQua.getText().toString();
                int lengths = Integer.parseInt(qua);
                String chars = "abcdefghijklmnopqrstuvwxyz";
                String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                String numbers = "0123456789";
                String spChar = "!@#$%^&*()_-+=<>?/{}~|";
                Random rn = new Random();
                StringBuilder sb = new StringBuilder(lengths);
                if(letters.isChecked()) {
                    chars += upperCase;
                    sb.append(upperCase.charAt(rn.nextInt(upperCase.length()-1)));

                }



                for(int i=sb.length();i < lengths;++i){
                    sb.append(chars.charAt(rn.nextInt(chars.length())));
                }






            }
        });
    }


}