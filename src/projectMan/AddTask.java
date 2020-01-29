package projectMan;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddTask {

    ArrayList<TextField> TxT = new ArrayList<>();
    Connection con = ConnectDB.connect();
    PreparedStatement statement;

    int i = 0;
    @FXML
    Button btn_done;
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
        int s = 0;

        for (TextField x : TxT) {
            String sql = "insert into projectman.tasks (code,project_code,status) values(" + s + "," + s + ",'ssd')";
            try {
                statement = con.prepareStatement(sql);
                statement.execute();
                s++;
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
    }
}
