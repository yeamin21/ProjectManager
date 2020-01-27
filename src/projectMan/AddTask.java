package projectMan;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class AddTask {
    ArrayList<String>task;
    int i = 0;
    @FXML
    Button btn_done;
    @FXML
    Button btn_addMoreTask;
    @FXML
    GridPane gridpane_tasks;

    @FXML
    void setBtn_addMoreTask() {

        if(i!=5){

            TextField t=new TextField();
            t.setMaxSize(216,32);
            gridpane_tasks.add(t,0,i);
            gridpane_tasks.setPadding(new Insets(10, 10, 10, 10));
            i++;
        }
    }

    @FXML
    void setBtn_done(){
        for(i=0;i<5;i++)
        {
            System.out.println(task.get(i));
        }
    }
}
