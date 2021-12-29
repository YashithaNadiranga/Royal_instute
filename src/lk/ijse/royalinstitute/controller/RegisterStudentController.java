package lk.ijse.royalinstitute.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import lk.ijse.royalinstitute.model.Course;
import lk.ijse.royalinstitute.model.Registration;
import lk.ijse.royalinstitute.model.Student;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class RegisterStudentController implements Initializable {

    @FXML
    private JFXTextField txtsid;

    @FXML
    private JFXTextField txtsname;

    @FXML
    private JFXTextField txtsAddress;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXComboBox<?> cmbGender;

    @FXML
    private DatePicker dpDob;

    @FXML
    private JFXTextField txtregfee;

    @FXML
    private DatePicker dpregDate;


    @FXML
    private JFXComboBox cmbCourse;

    @FXML
    private JFXComboBox<?> cmbBatch;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loadCid();

    }

    private void loadCid() {

        List list = new HibernateAddStudentController().loadCid();

        ObservableList <String> olist = FXCollections.observableArrayList();
        olist.addAll(list);
        cmbCourse.getItems().addAll(olist);

    }

    public void saveStudent(ActionEvent event) {
        try {
        LocalDate localDate = dpDob.getValue();
        String d = DateTimeFormatter.ofPattern("YYYY-MM-dd").format(localDate);
        Date date = new SimpleDateFormat("YYYY-MM-dd").parse(d);

            LocalDate l = dpregDate.getValue();
            String c = DateTimeFormatter.ofPattern("YYYY-MM-dd").format(localDate);
            Date rd = new SimpleDateFormat("YYYY-MM-dd").parse(c);

            String sid = txtsid.getText();
            String sname = txtsname.getText();
            String saddress = txtsAddress.getText();
            String contact = txtContact.getText();
            Date dob = date;
            String gender = (String) cmbGender.getSelectionModel().getSelectedItem();


            Date rdate = rd;
            double regfee = Double.valueOf( txtregfee.getText());
            String course = (String) cmbCourse.getSelectionModel().getSelectedItem();
            Student s = new Student(sid,sname,saddress,contact,dob,gender);
            System.out.println(course);
            Student student =new Student("S001","Pasindu","Kaluthara","12345",new Date(2000,5,6),"");
            Course course1=new Course("C001","","","");

            Registration r = new Registration(rdate,regfee,course1,s);
            new HibernateAddStudentController().saveStudent(s);
            new HibernateAddStudentController().registretion(r,course);


        } catch (ParseException e) {
            e.printStackTrace();
        }





    }
}
