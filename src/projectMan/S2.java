package projectMan;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class S2 {
    PreparedStatement ps;
    @FXML
    TextField txt_projectName,txt_projectEnv;
    Connection con=ConnectDB.connect();
    String dbname=ConnectDB.dbname;
    @FXML
    void AddNewProject()
    {
      String query= "insert into "+dbname+".projects (id,project_name)values('"+txt_projectName.getText().trim()+"','"+txt_projectEnv.getText().trim()+"')";

        try {
            ps =con.prepareStatement(query);
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
