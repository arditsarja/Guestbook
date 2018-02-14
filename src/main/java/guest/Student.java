package guest;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

	@Id@GeneratedValue
	Long id;

	@Column(nullable = false)
	private String name;


	protected Student() {
	}

	public Student(String name) {
		this.name = name;
	}




	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Student id: "+id+" name: "+name;
	}
}