package com.example.apmedecinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=(Button)findViewById(R.id.button_connexion);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // avant tout, il faudra vérifier le login et le mot de passe


                // Puis ouvrir la vue PanelActivity
                Intent intent = new Intent(MainActivity.this, PanelActivity.class);
                intent.putExtra("send", "Joran");
                startActivity(intent);
            }
        });

    }
}