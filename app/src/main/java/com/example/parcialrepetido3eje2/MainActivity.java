package com.example.parcialrepetido3eje2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.parcialrepetido3eje2.adapters.userList;
import com.example.parcialrepetido3eje2.api.API;
import com.example.parcialrepetido3eje2.api.Connect;
import com.example.parcialrepetido3eje2.models.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<User>lista = new ArrayList<>();
    RecyclerView listUsuarios;
    userList adapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listUsuarios = findViewById(R.id.listUsuarios);
        listUsuarios.setLayoutManager(new LinearLayoutManager(this));
        adapter = new userList(lista);
        listUsuarios.setAdapter(adapter);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cargando...");
        progressDialog.show();
        load();

    }

    public void load(){
        API api = Connect.getConnection().create(API.class);
        Call<List<User>> call = api.listaUsuarios();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> lista2 = response.body();
                for (User x:lista2){
                    lista.add(x);
                    Log.i("Usuario: ",x.getId());
                }
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}