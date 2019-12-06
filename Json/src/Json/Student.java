package Json;

import java.io.Serializable;

import org.json.JSONObject;

public class Student implements Serializable{
	String fullName;
	String birthday;
	String email;
	String address;
	String gender;
	
	public Student(String fullName, String birthday, String email, String address, String render) {
		super();
		this.fullName = fullName;
		this.birthday = birthday;
		this.email = email;
		this.address = address;
		this.gender = render;
	}
	
	
	
	public Student() {
		super();
	}



	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}



	@Override
	public String toString() {
		return "Student [fullName=" + fullName + ", birthday=" + birthday + ", email=" + email + ", address=" + address
				+ ", gender=" + gender + "]";
	}
	
	public void display() {
		System.out.println(toString());
	}
	
	public void parse(JSONObject obj) {
		fullName = obj.getString("fullName");
		birthday = obj.getString("birthday");
		email = obj.getString("email");
		address = obj.getString("address");
		gender = obj.getString("gender");
	}
}
