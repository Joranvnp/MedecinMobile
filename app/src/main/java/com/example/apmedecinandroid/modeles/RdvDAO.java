package com.example.apmedecinandroid.modeles;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.example.apmedecinandroid.utilitaire.AccesHTTP;
import com.example.apmedecinandroid.utilitaire.EventAsyncRdv;


public abstract class RdvDAO implements EventAsyncRdv {
    private static final String serveur="172.19.0.14/";
    private static final String chemin="MVC/";

    public RdvDAO(){
    }

    public void getRdv(){
        AccesHTTP objAsyncTask = new AccesHTTP("GET"){
            @Override
            protected void onPostExecute(Long result) {
                Log.d("log","onPostExecute RdvDAO2");
                onTacheTerminee(jsonStringToRdvArrayList(this.ret));
            }
        };
        objAsyncTask.execute("http://"+serveur+chemin+"index.php?action=rdv");
    }

    public void getRdvById(String idMedecin, String selectedDate){
        AccesHTTP requeteHttp = new AccesHTTP("GET"){
            @Override
            protected void onPostExecute(Long result) {
                Log.d("log","onPostExecute RdvDAO2");
                onTacheTerminee(jsonStringToRdvArrayList(this.ret));
            }
        };
        requeteHttp.requestType="GET";
        //requeteHttp.addParam("Rdv", idMedecin.toString());
//        String url = "http://"+serveur+chemin+"index.php?action=rdv&idMedecin="+idMedecin+"&date="+selectedDate;
        String url = "http://172.19.0.14/MVC/index.php?action=rdv&idMedecin=16e3cbd02663ea1d89c06efeca5bbdb1d683f490&date=2023-04-12";
        //String url= "http://172.19.0.16/TP%20ANDROID/PHP/getViticulteurs.php";
        //String url = "http://172.19.0.14/MVC/testDebug.php?idMedecin=16e3cbd02663ea1d89c06efeca5bbdb1d683f490&date=2023-04-28";
        requeteHttp.execute(url); //////
    }


    private ArrayList<Rdv> jsonStringToRdvArrayList(String jsonString){
        Log.d("log","conversion jsonToRdvArray : "+jsonString); ////////

        ArrayList<Rdv> listeRdv = new ArrayList<Rdv>();
        long idRdv;
        String nomJ;
        String prenomJ;
        String dateHeureRdv;
        long idPatient;
        long idMedecin;
        String compteRendu;

        try {
            JSONArray tabJson = new JSONArray(jsonString);
            for(int i=0;i<tabJson.length();i++){
                //idRdv = Long.parseLong(tabJson.getJSONObject(i).getString("idRdv"));
                //dateHeureRdv = tabJson.getJSONObject(i).getString("dateHeureRdv");
                //idPatient = Long.parseLong(tabJson.getJSONObject(i).getString("idPatient"));
                //idMedecin = Long.parseLong(tabJson.getJSONObject(i).getString("idMedecin"));
                //compteRendu = tabJson.getJSONObject(i).getString("compteRendu");

                idRdv = Long.parseLong(tabJson.getJSONObject(i).getString("idRdv"));
                nomJ = tabJson.getJSONObject(i).getString("nom");
                prenomJ = tabJson.getJSONObject(i).getString("prenom");
                dateHeureRdv = tabJson.getJSONObject(i).getString("dateHeureRdv");

                listeRdv.add(new Rdv(idRdv,nomJ,prenomJ,dateHeureRdv));
                //listeRdv.add(new Rdv(idRdv,dateHeureRdv,idPatient, idMedecin, compteRendu));
            }
        }
        catch (JSONException e){
            e.printStackTrace();
            Log.d("Erreur : ", e.getMessage());
            Log.d("log","pb decodage JSON");
        }
        return listeRdv;
    }

    private Rdv jsonStringToRdv(String jsonString){
        Log.d("log","conversion jsonToRdv : "+jsonString);

        Rdv unRdv=null;
        long idRdv;
        String dateHeureRdv;
        long idPatient;
        long idMedecin;
        String compteRendu;

        try {
            JSONObject objJson = new JSONObject(jsonString);
            idRdv = Long.parseLong(objJson.getString("idRdv"));
            dateHeureRdv = objJson.getString("dateHeureRdv");
            idPatient = Long.parseLong(objJson.getString("idPatient"));
            idMedecin = Long.parseLong(objJson.getString("idMedecin"));
            compteRendu = objJson.getString("compteRendu");

            unRdv = new Rdv(idRdv,dateHeureRdv,idPatient, idMedecin, compteRendu);
        }
        catch (JSONException e){
            Log.d("log","pb decodage JSON");
        }
        return unRdv;
    }

}