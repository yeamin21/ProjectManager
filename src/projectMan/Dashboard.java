package projectMan;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Dashboard extends Application implements Initializable {
    @FXML
    Button btn_b1;
    @FXML
    AnchorPane borderPane_p1;
    @FXML
    Pane ppp1;
    @FXML
    Label lbl_l1;
    int i = 1;
    ArrayList<Projects> p = new ArrayList<>();
    ArrayList<Label> lbl = new ArrayList<>();
    @FXML
    GridPane gridpane_p1;

    @Override
    public void start(Stage primaryStage) throws Exception {
    }

    void getProjects() {
        String sql = "select * from projects";
        Connection con = ConnectDB.connect();
        try {
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            while (rs.next()) {

                Projects x = new Projects();
                x.setProject_name(rs.getString("project_name"));
                p.add(x);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    @FXML
    void AddNewProjectPanel() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("AddNewProject.fxml"));
        } catch (Exception e) {
            System.out.println(e);
        }
        ppp1.getChildren().setAll(root);

  }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getProjects();

        for (Projects project : p) {

            Label l1 = new Label();
            l1.setText(project.getProject_name());
            lbl.add(l1);

        }
        for (Label l1 : lbl) {
            gridpane_p1.add(l1, 0, i);
            i++;
        }
    }
}
