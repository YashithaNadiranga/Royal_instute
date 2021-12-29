package lk.ijse.royalinstitute.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.royalinstitute.model.Course;
import lk.ijse.royalinstitute.model.Student;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ViewStudentController implements Initializable {

    @FXML
    private TableView<Student> tblstudent;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tblstudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory("id"));
        tblstudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory("name"));
        tblstudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory("address"));
        tblstudent.getColumns().get(3).setCellValueFactory(new PropertyValueFactory("contact"));
        tblstudent.getColumns().get(4).setCellValueFactory(new PropertyValueFactory("date"));
        tblstudent.getColumns().get(5).setCellValueFactory(new PropertyValueFactory("gender"));

        loadStudent();


    }

    private void loadStudent() {
        List<Student> student = new HibernateViewStudentController().getStudents();
        tblstudent.setItems(FXCollections.observableArrayList(student));

    }
}
