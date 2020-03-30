/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;
/**
 *
 * @author Student
 */
import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private String groupId;
	
    private List<Double> grades = new ArrayList<>();
	
    private Double srednia;
        
    public List<Double> getGrades() {
        return grades;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }
    
    public Double getGradesAverage() {
        double suma = grades.stream().mapToDouble(Double::doubleValue).sum();
        double ilosc_ocen = grades.size() * 1.0;
        srednia = suma / ilosc_ocen;
        return srednia;
    }
	
    public Student(String firstName, String lastName, String email, String groupId) {
	super(firstName, lastName, email);
	this.groupId = groupId;
    }
	
    public String getGroupId() {
	return groupId;
    }

    public void setGroupId(String groupId) {
	this.groupId = groupId;
    }
       
}

