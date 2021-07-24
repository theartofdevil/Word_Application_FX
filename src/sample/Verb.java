package sample;

import db_connectivity.ConnectionClass;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static db_connectivity.ConnectionClass.myConn;

public class Verb {
 /*   ResultSet rs;
    public String dbVerb(int count){
        try{
            ConnectionClass connectionClass = new ConnectionClass();
            boolean control = ConnectionClass.makeConnection();
            if (control){
                String sql1 = "select * from verb where idverb = ?";
                PreparedStatement stmt1 = myConn.prepareStatement(sql1);
                stmt1.setString(1, String.valueOf(count));
                stmt1.execute();

                ConnectionClass.myStat = ConnectionClass.myConn.createStatement();
                rs = ConnectionClass.myStat.executeQuery("select * from verb");




            }
            else{
                System.out.println("can not connected to db");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return "hey";
    }
    public void dbNoun(int count){
        try{
            ConnectionClass connectionClass = new ConnectionClass();
            boolean control = ConnectionClass.makeConnection();
            if (control){

            }
            else{
                System.out.println("can not connected to db");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }*/
    int idVerb;
    String wordVerb , perfectWord , meaningVerb ;

    public Verb(){

    }

    public int getIdVerb() {
        return idVerb;
    }

    public void setIdVerb(int idVerb) {
        this.idVerb = idVerb;
    }

    public String getWordVerb() {
        return wordVerb;
    }

    public void setWordVerb(String wordVerb) {
        this.wordVerb = wordVerb;
    }

    public String getPerfectWord() {
        return perfectWord;
    }

    public void setPerfectWord(String perfectWord) {
        this.perfectWord = perfectWord;
    }

    public String getMeaningVerb() {
        return meaningVerb;
    }

    public void setMeaningVerb(String meaningVerb) {
        this.meaningVerb = meaningVerb;
    }
}
