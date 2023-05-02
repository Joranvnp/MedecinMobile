package com.example.apmedecinandroid;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.apmedecinandroid.modeles.Rdv;
import com.example.apmedecinandroid.modeles.RdvDAO;

import java.util.ArrayList;

public class PanelActivity extends AppCompatActivity {

    private DatePicker datePicker;
    private ScrollView scrollViewPatients;
    private LinearLayout linearLayoutPatients;
    private Button buttonAfficherValider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);

        datePicker = findViewById(R.id.datePicker);
        scrollViewPatients = findViewById(R.id.scollViewPatients);
        linearLayoutPatients = findViewById(R.id.linearLayoutPatients);
        buttonAfficherValider = findViewById(R.id.buttonAfficherValider);

        //Clotilde GUIBE
        String idMedecin = "16e3cbd02663ea1d89c06efeca5bbdb1d683f490";

        // Charger une liste de patients

        // Charger une liste de rendez-vous

        //sélectionner une date et charger les rendez-vous de cette date

        buttonAfficherValider.setOnClickListener(v -> {
            int day = datePicker.getDayOfMonth();
            int month = datePicker.getMonth() + 1;
            int year = datePicker.getYear();
            String selectedDate = String.format("%04d-%02d-%02d", year, month, day);

            RdvDAO rdvDAO = new RdvDAO() {
                @Override
                public void onTacheTerminee(String value) {

                }

                @Override
                public void onTacheTerminee(ArrayList<Rdv> listeRdv) {
                    linearLayoutPatients.removeAllViews();

                    for (Rdv rdv : listeRdv) {
                        TextView textView = new TextView(PanelActivity.this);
//                        textView.setText(String.format("Rdv %d - Patient %d - Medecin %d - %s",
//                                rdv.getidRdv(), rdv.getidPatient(), rdv.getidMedecin(), rdv.getdateHeureRdv()));
                        textView.setText(String.format("Rdv %d - Patient %d - Medecin %d - %"));
                        linearLayoutPatients.addView(textView);
                    }
                }

                @Override
                public void onTacheTerminee(Rdv resultat) {

                }
            };
//            rdvDAO.getRdvByDate(selectedDate);
            rdvDAO.getRdvById(idMedecin, selectedDate);
        });
    }
}
