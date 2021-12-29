package lk.ijse.royalinstitute.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private JFXButton btnregStudent;

    @FXML
    private BorderPane boarderpane;

    @FXML
    private JFXButton btnAddCourse;

    @FXML
    private JFXButton btnshowStudent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    public void showRegStudent(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/royalinstitute/views/RegisterStudentForm.fxml"));
            boarderpane.setCenter(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCourse(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/royalinstitute/views/AddCourseForm.fxml"));
            boarderpane.setCenter(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStudent(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/royalinstitute/views/ViewStudentForm.fxml"));
            boarderpane.setCenter(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
