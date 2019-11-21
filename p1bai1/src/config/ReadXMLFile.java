package config;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLFile {

	public static void main(String argv[]) {

		try {

			List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
			File fXmlFile = new File("config.xml");
			//  khoi tao DucumentBuilder
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			//  tao Document tu file hoac stream
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			// cha ve 1 danh sach cac phan tu con
			NodeList nList = doc.getElementsByTagName("staff");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Map<String, Object> map = new HashMap<String, Object>();
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					map.put("staff", eElement.getAttribute("id"));
					map.put("firstname", eElement.getElementsByTagName("firstname").item(0).getTextContent());
					map.put("lastname", eElement.getElementsByTagName("lastname").item(0).getTextContent());
					map.put("nickname", eElement.getElementsByTagName("nickname").item(0).getTextContent());
					map.put("salary", eElement.getElementsByTagName("salary").item(0).getTextContent());
					result.add(map);
					System.out.println(map);

				}
			}
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}