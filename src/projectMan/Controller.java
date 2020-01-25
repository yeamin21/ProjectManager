package projectMan;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class Controller extends Application {
  @FXML
  Button btn_b1;
  @FXML
  GridPane gridpane_p1;
  @FXML
  AnchorPane anc_pan_addnewproject;
  @FXML
  BorderPane borderPane_p1;
  @FXML
  Pane pane_p1;

  @Override
  public void start(Stage primaryStage) throws Exception {
  }

  @FXML
  void AddNewProjectPanel()
  {
    Parent root=null;
    try {
      root = FXMLLoader.load(getClass().getResource("NewProject.fxml"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    pane_p1.getChildren().setAll(root);
  }
  @FXML
  void xx()
  {
    Parent root=null;
    try {
      root = FXMLLoader.load(getClass().getResource("projectInfo.fxml"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    gridpane_p1.add(root,0,0);
  }
}
