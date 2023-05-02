package com.example.apmedecinandroid.utilitaire;

import com.example.apmedecinandroid.modeles.Rdv;

import java.util.ArrayList;
// Force la classe qui l'implemente a avoir les methodes indiquees ci-dessous
// Cette methode sera appelee lorsque la tache asynchrone sera terminee
public interface EventAsyncRdv {
	public void onTacheTerminee(String value);
	public void onTacheTerminee(ArrayList<Rdv> listeRdv);
	public void onTacheTerminee(Rdv resultat);

}


