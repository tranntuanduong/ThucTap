import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) throws IOException {
		List<Student> list = new ArrayList<>();
//		list.add(new Student("A", "nam"));
//		list.add(new Student("B", "nam1"));
//		list.add(new Student("C", "nam2"));
//
//		ObjectOutputStream objectOutputStream = null;
//		FileOutputStream fileOutputStream = null;
//		try {
//			fileOutputStream = new FileOutputStream("student1.obj");
//			objectOutputStream = new ObjectOutputStream(fileOutputStream);
//			
//			objectOutputStream.writeObject(list);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(fileOutputStream != null) {
//				fileOutputStream.close();
//			}
//			if(objectOutputStream != null) {
//				fileOutputStream.close();
//			}
//
//		}
		
		FileInputStream in = null;
		ObjectInputStream inputStream = null;
		try {
			in = new FileInputStream("student1.obj");
			inputStream = new ObjectInputStream(in);
			
			list = (List<Student>) inputStream.readObject();
			for(Student student : list) {
				student.display();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				in.close();
			}
			if(inputStream != null) {
				inputStream.close();
			}
		}
	}
}
















