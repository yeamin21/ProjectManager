package projectMan;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddNewProject extends Application {
    static int key = 0;
    PreparedStatement ps;
    @FXML
    TextField txt_projectName, txt_projectEnv;
    Connection con = ConnectDB.connect();
    String dbname = ConnectDB.dbname;
    @FXML
    AnchorPane anc_pan_addnewproject;


    @FXML
    void ToTaskPane() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("AddTask.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        anc_pan_addnewproject.getChildren().setAll(root);
    }

    @FXML
    void AddNewProject() {
        String query = "insert into " + dbname + ".projects (project_name)values(?)";
        try {
            ps = con.prepareStatement(query, ps.RETURN_GENERATED_KEYS);
            ps.setString(1, txt_projectName.getText());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                this.key = rs.getInt(1);
            }
            ToTaskPane();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
