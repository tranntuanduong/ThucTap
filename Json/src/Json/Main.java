package Json;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
	static List<ClassRoom> classList = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int choose;

		do {
			showMenu();
			choose = scanner.nextInt();
			switch (choose) {
			case 1:
				input();
				break;
			case 2:
				display();
				break;
			case 3:
				save();
				break;
			case 4:
				System.out.println("exit!!!");
				break;
			case 5:
				newJsonFile();
				break;
			default:
				System.out.println("input false");
				break;
			}

		} while (choose != 4);
	}

	static void input() {
		StringBuilder stringBuilder = new StringBuilder();
		FileInputStream fis = null;

		try {
			fis = new FileInputStream("vidu_xml_json.json");
			int code;
			while ((code = fis.read()) != -1) {
				stringBuilder.append((char) code);
			}
			JSONArray arr = new JSONArray(stringBuilder.toString());

			for (int i = 0; i < arr.length(); i++) {
				JSONObject obj = arr.getJSONObject(i);
				ClassRoom classRoom = new ClassRoom();
				classRoom.parse(obj);
				classList.add(classRoom);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static void display() {
		for (ClassRoom classRoom : classList) {
			classRoom.display();
		}
	}

	static void save() {
		for (ClassRoom classRoom : classList) {
			String className = classRoom.getClassName();

			FileOutputStream fos = null;
			ObjectOutputStream oos = null;
			try {
				classRoom.toString();
				fos = new FileOutputStream(className + ".obj");
				oos = new ObjectOutputStream(fos);

				oos.writeObject(classRoom.getStudentList());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (fos != null) {
					try {
						fos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (oos != null) {
					try {
						oos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	static void newJsonFile() {
		FileWriter writer = null;

		try {
			writer = new FileWriter("newJsonFile.txt");

			String json = classList.toString();
			writer.write(json);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static void showMenu() {
		System.out.println("1. nhap");
		System.out.println("2. hien thi");
		System.out.println("3. luu");
		System.out.println("4. thoat");
		System.out.println("5. newJsonFile");
		System.out.println("choose");
	}
}
