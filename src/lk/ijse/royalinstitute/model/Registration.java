package lk.ijse.royalinstitute.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int regNo;
    private Date date;
    private double regFee;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cID",referencedColumnName = "code",nullable = false)
    private Course course;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sID",referencedColumnName = "id",nullable = false)
    private Student student;

    public Registration(Date date, double regFee, Course course, Student student) {
        this.date = date;
        this.regFee = regFee;
        this.course = course;
        this.student = student;
    }

    public Registration() {
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getRegFee() {
        return regFee;
    }

    public void setRegFee(double regFee) {
        this.regFee = regFee;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "regNo=" + regNo +
                ", date=" + date +
                ", regFee=" + regFee +
                ", course=" + course +
                ", student=" + student +
                '}';
    }
}
