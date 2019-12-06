package Json;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ClassRoom {
	private String className;
	private String classAdress;
	
	List<Student> studentList = new ArrayList<>();

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassAdress() {
		return classAdress;
	}

	public void setClassAdress(String classAdress) {
		this.classAdress = classAdress;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	@Override
	public String toString() {
		return "ClassRoom [className=" + className + ", classAdress=" + classAdress + ", studentList=" + studentList
				+ "]";
	}
	
	public void display() {
		System.out.println(toString());
	}
	
	public void parse(JSONObject obj) {
		JSONObject infomationObj = obj.getJSONObject("infomation");
		JSONArray studentListObj = obj.getJSONArray("studentList");
		
		className = infomationObj.getString("name");
		classAdress = infomationObj.getString("address");
		
		for(int i = 0; i < studentListObj.length(); i++) {
			JSONObject stdObj = studentListObj.getJSONObject(i);
			
			Student student = new Student();
			student.parse(stdObj);
			studentList.add(student);
		}
	}
}
