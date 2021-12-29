package lk.ijse.royalinstitute.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.royalinstitute.model.Course;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddCourseController implements Initializable {

    @FXML
    private JFXTextField lblCid;

    @FXML
    private JFXTextField lblCDur;

    @FXML
    private JFXTextField lblCtype;

    @FXML
    private JFXTextField lblCname;

    @FXML
    private JFXButton btnSave;

    @FXML
    private TableView<Course> tblCourse;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblCourse.getColumns().get(0).setCellValueFactory(new PropertyValueFactory("code"));
        tblCourse.getColumns().get(1).setCellValueFactory(new PropertyValueFactory("courseName"));
        tblCourse.getColumns().get(2).setCellValueFactory(new PropertyValueFactory("courseType"));
        tblCourse.getColumns().get(3).setCellValueFactory(new PropertyValueFactory("duration"));

        loadCourses();

    }

    private void loadCourses() {
        List<Course> courses = new HibernateAddCourseController().getAllCourse();
        tblCourse.setItems(FXCollections.observableArrayList(courses));

    }

    public void AddCourse(ActionEvent event) {
        String cid = lblCid.getText();
        String cname = lblCname.getText();
        String ctype = lblCtype.getText();
        String cdu = lblCDur.getText();

        Course c = new Course(cid,cname,ctype,cdu);

        new HibernateAddCourseController().saveCourse(c);
        loadCourses();
    }
}
