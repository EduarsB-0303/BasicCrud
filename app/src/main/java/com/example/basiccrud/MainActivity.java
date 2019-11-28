package com.example.basiccrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.basiccrud.dal.SerieDAL;
import com.example.basiccrud.dto.Serie;

public class MainActivity extends AppCompatActivity {
    private SerieDAL serieDAL;

    private TextView txtName1;
    private TextView txtName2;
    private TextView txtName3;
    private EditText editNombre;
    private EditText editCategoria;
    private EditText editCapitulos;
    private Button btnInsertar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.serieDAL = new SerieDAL(getApplicationContext(), new Serie());
        this.editNombre = (EditText) findViewById(R.id.editNombre);
        this.editCategoria = (EditText) findViewById(R.id.editCategoria);
        this.editCapitulos = (EditText) findViewById(R.id.editCapitulos);
        this.txtName1 = (TextView) findViewById(R.id.txtName1);
        this.txtName2 = (TextView) findViewById(R.id.txtName2);
        this.txtName3 = (TextView) findViewById(R.id.txtName3);
        this.btnInsertar = (Button) findViewById(R.id.btnInsertar);

        btnInsertar.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                int cap = Integer.parseInt(editCapitulos.getText().toString());
                Serie s = new Serie(editNombre.getText().toString(),editCategoria.getText().toString(),cap);
                serieDAL = new SerieDAL(getApplicationContext(), s);
                if(serieDAL.insertar()) {
                    Toast.makeText(getApplicationContext(), "OK! Insertó", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "MAL! NO Insertó", Toast.LENGTH_LONG).show();
                }
            }
        });


        // Testing (No lo hagan en casa)
/*
        // TEST DE ELIMINAR
        if(serieDAL.eliminar(1)) {
            Toast.makeText(
                    getApplicationContext(),
                    "Se eliminó!",
                    Toast.LENGTH_LONG
            ).show();
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "NO se eliminó!",
                    Toast.LENGTH_LONG
            ).show();
        }*/

/*
        // TEST INSERTAR
        Serie s = new Serie("The boys", "Sci-Fi", 8);
        this.serieDAL = new SerieDAL(getApplicationContext(), s);
        if(serieDAL.insertar()) {
            Toast.makeText(getApplicationContext(), "OK! Insertó", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "MAL! NO Insertó", Toast.LENGTH_LONG).show();
        }*/

    }
}