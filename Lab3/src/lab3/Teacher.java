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
public class Teacher extends Person {
	
    private String courseName;

    public Teacher(String firstName, String lastName, String email, String courseName) {
	super(firstName, lastName, email);
	this.courseName = courseName;
    }

    public String getGroupId() {
        return courseName;
    }

    public void setGroupId(String groupId) {
	this.courseName = courseName;
    }
}
