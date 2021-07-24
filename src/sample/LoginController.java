package sample;
import db_connectivity.ConnectionClass;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class LoginController {

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    public PreparedStatement preparedStatement;
    public ResultSet rs;

    String idDb ,passwordDb;

    public void initialize(URL location, ResourceBundle resources) {
        loginButton.setOnAction(this::handleButtonClick);
    }

    @FXML
    private void handleButtonClick(javafx.event.ActionEvent actionEvent) {
        String id = loginField.getText();
        String password = passwordField.getText();
        System.out.println(id+" "+password);

        try{
            ConnectionClass connectionClass = new ConnectionClass();
            boolean control = ConnectionClass.makeConnection();
            if (control){
                System.out.println("successfully connected to db ");
                ConnectionClass.myStat = ConnectionClass.myConn.createStatement();
                rs = ConnectionClass.myStat.executeQuery("select * from user");
            }
            else{
                System.out.println("can not connected to db");
            }

            while(rs.next()){
                idDb = rs.getString("user_id");
                passwordDb = rs.getString("user_password");
                if (idDb.equals(id) && passwordDb.equals(password)){
                    System.out.println("successful login :P ");
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainPage.fxml"));
                        Parent root1 = fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.setTitle("WILLKOMMEN");
                        stage.setScene(new Scene(root1));
                        stage.show();
                        ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(e);
                    }
                }
                else{
                    System.out.println("Unsuccessful login :( ");
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

    }

}
