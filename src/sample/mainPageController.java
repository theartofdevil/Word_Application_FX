package sample;
import db_connectivity.ConnectionClass;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import static db_connectivity.ConnectionClass.myConn;

public class mainPageController {

    @FXML
    private Button submitButton;

    @FXML
    private Button nextButton;

    @FXML
    private Label wordLabel;

    @FXML
    private TextField answerField;

    @FXML
    private Button verbButton;

    @FXML
    private Button substantivButton;

    @FXML
    private Label testLabel ;

    int noun=0 , verb=0 ,nounClick = 0 , verbClick = 0;
    Noun dbNoun = new Noun();
    Verb dbVerb = new Verb();
    public void Noun(int count){
        try{
            ConnectionClass connectionClass = new ConnectionClass();
            boolean control = ConnectionClass.makeConnection();
            if (control){
                String sql = "select * from noun where idnoun = ?";
                PreparedStatement stmt1 = myConn.prepareStatement(sql);
                stmt1.setInt(1,count);
                ResultSet rs1 = stmt1.executeQuery();
                while(rs1.next()){
                    dbNoun.setArticleNoun(rs1.getString("article"));
                    dbNoun.setId(noun);
                    dbNoun.setWordNoun(rs1.getString("word"));
                    dbNoun.setPluralNoun(rs1.getString("plural"));
                    dbNoun.setMeaningNoun(rs1.getString("meaning"));

                }
                wordLabel.setText(dbNoun.getArticleNoun()+" , "+dbNoun.getWordNoun()+" , "+dbNoun.getPluralNoun()+" ");

            }
        }catch(Exception e){
            System.out.println(e);
        }
        noun++;
    }

    public void Verb(int count){
        try{
            ConnectionClass connectionClass = new ConnectionClass();
            boolean control = ConnectionClass.makeConnection();
            if (control){
                String sql = "select * from verb where idverb = ?";
                PreparedStatement stmt = myConn.prepareStatement(sql);
                stmt.setInt(1,count);
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    dbVerb.setIdVerb(count);
                    dbVerb.setWordVerb(rs.getString("word"));
                    dbVerb.setPerfectWord(rs.getString("perfect"));
                    dbVerb.setMeaningVerb(rs.getString("meaning"));
                }
                wordLabel.setText(dbVerb.getWordVerb()+" ,"+dbVerb.getPerfectWord());
            }
        }catch (Exception e){
            System.out.println(e);
        }
        verb++;
    }
    @FXML
    private void substantivButtonAction(javafx.event.ActionEvent actionEvent) {
        noun++;
        nounClick++;
        verbClick = 0;
        Noun(noun);

    }
    @FXML
    private void verbButtonAction(javafx.event.ActionEvent actionEvent){
        nounClick = 0;
        verbClick ++;
        verb ++;
        Verb(verb);
    }
   @FXML
    private void submitButtonAction(javafx.event.ActionEvent actionEvent){
       if (nounClick > verbClick){
           if (answerField.getText().equals(dbNoun.getMeaningNoun()))
               testLabel.setText("Richtig :)");
           else{
               testLabel.setText("Falsch :(");
               answerField.setText(dbNoun.getMeaningNoun());
           }
       }

       if (verbClick > nounClick){
           if (answerField.getText().equals(dbVerb.getMeaningVerb())){
               testLabel.setText("Richtig :)");
           }
           else{
               testLabel.setText("Falsch :(");
               answerField.setText(dbVerb.getMeaningVerb());
           }
       }



   }
   @FXML
    private void nextButtonAction(javafx.event.ActionEvent actionEvent){
        if (nounClick > verbClick)
            Noun(noun);
        if (verbClick > nounClick)
            Verb(verb);

        answerField.setText("");
        testLabel.setText("");
   }



}
