package com.example.apmedecinandroid.modeles;

public class Rdv {
    private long idRdv;
    private String dateHeureRdv;

    private String nomJ;
    private String prenomJ;
    private long idPatient;
    private long idMedecin;
    private String compteRendu;

    public Rdv(long idRdv, String dateHeureRdv, long idPatient, long idMedecin, String compteRendu) {
        this.idRdv = idRdv;
        this.dateHeureRdv = dateHeureRdv;
        this.idPatient = idPatient;
        this.idMedecin = idMedecin;
        this.compteRendu = compteRendu;
    }

    public Rdv(long idRdv, String nomJ, String prenomJ, String dateHeureRdv) {
        this.idRdv = idRdv;
        this.nomJ = nomJ;
        this.prenomJ = prenomJ;
        this.dateHeureRdv = dateHeureRdv;
    }

//    public Rdv(String nomJ,String prenomJ) {
//        this.idRdv = -1;
//        this.nomJ = nomJ;
//        this.prenomJ = prenomJ;
//    }

    public long getidRdv() {
        return idRdv;
    }

    public void setidRdv(long idRdv) {
        this.idRdv = idRdv;
    }

    public String getdateHeureRdv() {
        return dateHeureRdv;
    }

    public void setdateHeureRdv(String dateHeureRdv) {
        this.dateHeureRdv = dateHeureRdv;
    }

    public long getidPatient() {
        return idPatient;
    }

    public void setidPatient(Long idPatient) {
        this.idPatient = idPatient;
    }

    public String getnomJ() {
        return nomJ;
    }

    public void setnomJ(String nomJ) {
        this.nomJ = nomJ;
    }

    public String getprenomJ() {
        return prenomJ;
    }

    public void setprenomJ(String prenomJ) {
        this.prenomJ = prenomJ;
    }
    public long getidMedecin() {
        return idMedecin;
    }

    public void setidMedecin(Long idMedecin) {
        this.idMedecin = idMedecin;
    }

    public String getcompteRendu() {
        return compteRendu;
    }

    public void setcompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
    }

    public String toString(){
//        return "idRdv="+idRdv+",dateHeureRdv="+dateHeureRdv+",idPatient="+idPatient+",idMedecin="+idMedecin+",compteRendu="+compteRendu;

        return "nomJ="+nomJ+"prenomJ="+prenomJ+"dateHeureRdv="+dateHeureRdv;
    }
}
