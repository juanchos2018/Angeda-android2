package com.example.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtno;
    private EditText txtdatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtno=(EditText)findViewById(R.id.txtnombre);
        txtdatos=(EditText)findViewById(R.id.txtdatos);

    }
    public  void Guardar(View view){
    String nombre=txtno.getText().toString();
    String da=txtdatos.getText().toString();
        SharedPreferences pre=getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor objEdit=pre.edit();
        objEdit.putString(nombre,da);
        objEdit.commit();
        Toast.makeText(this, "se almaceno", Toast.LENGTH_SHORT).show();
    }
    public  void Buscar(View view){
    String nombre =txtno.getText().toString();
    SharedPreferences pre=getSharedPreferences("agenda",Context.MODE_PRIVATE);
    String datos =pre.getString(nombre,"");
    if (datos.length()==0){
        Toast.makeText(this, "No existe", Toast.LENGTH_SHORT).show();
    }else{
        txtdatos.setText(datos);

    }
    }
}
