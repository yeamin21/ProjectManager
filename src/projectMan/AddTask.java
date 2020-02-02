package projectMan;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AddTask implements Initializable {

    ArrayList<TextField> TxT = new ArrayList<>();
    Connection con = ConnectDB.connect();
    PreparedStatement statement;

    int i = 1;
    @FXML
    Button btn_done;
    @FXML
    TextField txt_1;
    @FXML
    Button btn_addMoreTask;
    @FXML
    GridPane gridpane_tasks;

    @FXML
    void setBtn_addMoreTask() {
        TextField t = new TextField();
        if (i != 5) {
            gridpane_tasks.add(t, 0, i);
            gridpane_tasks.setPadding(new Insets(10, 10, 10, 10));
            i++;
        }
        TxT.add(t);
    }

    @FXML
    void setBtn_done() {

        for (TextField x : TxT) {
            String sql = "insert into projectman.tasks (project_code,task_name) values(?,?)";
            try {
                statement = con.prepareStatement(sql);
                statement.setInt(1, AddNewProject.key);
                statement.setString(2, x.getText());
                statement.execute();
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TxT.add(txt_1);
    }
}
