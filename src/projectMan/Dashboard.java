package projectMan;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
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
    GridPane gridpane_p1;
    @FXML
    AnchorPane borderPane_p1;
    @FXML
    Pane ppp1;
    int i = 1;
    ArrayList<Projects> p = new ArrayList<>();

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
  @FXML
  void xx() {
      Parent root = null;
      try {
          root = FXMLLoader.load(getClass().getResource("projectInfo.fxml"));
      } catch (IOException e) {
          e.printStackTrace();
      }
      gridpane_p1.add(root, 0, 0);
  }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getProjects();
        gridpane_p1.addRow(2);
        gridpane_p1.add(new Text("XXP"), 0, 2);
    }
}
