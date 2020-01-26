package projectMan;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.ArrayList;

public class AddTask {
    int i = 1;
    @FXML
    Button btn_addMoreTask;
    @FXML
    GridPane gridpane_tasks;

    @FXML
    void setBtn_addMoreTask() {

        if(i!=5){
            Parent root=null;
            try {
                root = FXMLLoader.load(getClass().getResource("Task.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            gridpane_tasks.add(root,0,i);
            i++;
        }
    }
}
