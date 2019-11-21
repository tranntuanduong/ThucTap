package main;

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

public class ReadXmlFile {
	public synchronized static List<Map<String, Object>> readFile(String fileName) {
		try {
			   
		    List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
			File fXmlFile = new File(fileName);
			//"G:/file//config.xml"
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
				
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
					System.out.println();
					
				}
			}
			return result;
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		return null;
	}
}
