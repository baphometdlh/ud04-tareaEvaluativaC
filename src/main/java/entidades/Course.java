package entidades;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table (name="course")
public class Course {

	//Atributos
	private int id;
	private String name;
	private int credits;
	private Set<Student> students = new HashSet<>();	
	
	//constructores
	public Course() {
		
	}
	
	public Course(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	//ToString
	
	//getters y setters
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="credits")
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	@ManyToMany (mappedBy="courses")
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}
