/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author baoquoc
 */
public class CinemaConfig {

    public int getLocationIdByCinemaName(String cinemaName) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("cinemas.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputStream);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("cinema");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (eElement.getAttribute("name").equals(cinemaName)) {
                        return Integer.parseInt(eElement.getAttribute("locationID"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0; // Default or error case
    }

    // Phương thức mới để lấy số hàng và số cột
    public int[] getRowsAndColumns(String cinemaName, int theaterNumber) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("cinemas.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputStream);
            doc.getDocumentElement().normalize();

            NodeList cinemaList = doc.getElementsByTagName("cinema");
            for (int i = 0; i < cinemaList.getLength(); i++) {
                Node cinemaNode = cinemaList.item(i);
                if (cinemaNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element cinemaElement = (Element) cinemaNode;
                    if (cinemaElement.getAttribute("name").equals(cinemaName)) {
                        NodeList theaterList = cinemaElement.getElementsByTagName("theater");
                        for (int j = 0; j < theaterList.getLength(); j++) {
                            Node theaterNode = theaterList.item(j);
                            if (theaterNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element theaterElement = (Element) theaterNode;
                                if (Integer.parseInt(theaterElement.getAttribute("room")) == theaterNumber) {
                                    int rows = Integer.parseInt(theaterElement.getAttribute("rows"));
                                    int columns = Integer.parseInt(theaterElement.getAttribute("columns"));
                                    return new int[]{rows, columns};
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new int[]{0, 0}; // Return default values in case of error
    }

    public int[] getVIPDetails(String cinemaName, int theaterNumber) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("cinemas.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputStream);
            doc.getDocumentElement().normalize();

            NodeList cinemaList = doc.getElementsByTagName("cinema");
            for (int i = 0; i < cinemaList.getLength(); i++) {
                Node cinemaNode = cinemaList.item(i);
                if (cinemaNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element cinemaElement = (Element) cinemaNode;
                    if (cinemaElement.getAttribute("name").equals(cinemaName)) {
                        NodeList theaterList = cinemaElement.getElementsByTagName("theater");
                        for (int j = 0; j < theaterList.getLength(); j++) {
                            Node theaterNode = theaterList.item(j);
                            if (theaterNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element theaterElement = (Element) theaterNode;
                                if (Integer.parseInt(theaterElement.getAttribute("room")) == theaterNumber) {
                                    int vipStartCol = Integer.parseInt(theaterElement.getAttribute("vipStartCol"));
                                    int vipEndCol = Integer.parseInt(theaterElement.getAttribute("vipEndCol"));
                                    int vipStartRow = Integer.parseInt(theaterElement.getAttribute("vipStartRow"));
                                    int vipEndRow = Integer.parseInt(theaterElement.getAttribute("vipEndRow"));
                                    return new int[]{vipStartCol, vipEndCol, vipStartRow, vipEndRow};
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new int[]{0, 0, 0, 0}; // Return default values in case of error
    }

    public List<String> getDamagedSeats(String cinemaName, int theaterNumber) {
        List<String> damagedSeats = new ArrayList<>();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("cinemas.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputStream);
            doc.getDocumentElement().normalize();

            NodeList cinemaList = doc.getElementsByTagName("cinema");
            for (int i = 0; i < cinemaList.getLength(); i++) {
                Node cinemaNode = cinemaList.item(i);
                if (cinemaNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element cinemaElement = (Element) cinemaNode;
                    if (cinemaElement.getAttribute("name").equals(cinemaName)) {
                        NodeList theaterList = cinemaElement.getElementsByTagName("theater");
                        for (int j = 0; j < theaterList.getLength(); j++) {
                            Node theaterNode = theaterList.item(j);
                            if (theaterNode.getNodeType() == Node.ELEMENT_NODE) {
                                Element theaterElement = (Element) theaterNode;
                                if (Integer.parseInt(theaterElement.getAttribute("room")) == theaterNumber) {
                                    NodeList seatList = theaterElement.getElementsByTagName("seat");
                                    for (int k = 0; k < seatList.getLength(); k++) {
                                        Node seatNode = seatList.item(k);
                                        if (seatNode.getNodeType() == Node.ELEMENT_NODE) {
                                            Element seatElement = (Element) seatNode;
                                            damagedSeats.add(seatElement.getTextContent());
                                        }
                                    }
                                    return damagedSeats;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return damagedSeats; // Return empty list in case of error or no damaged seats
    }

    public static void main(String[] args){
        //test get dameged seats
        CinemaConfig cinemaConfig = new CinemaConfig();
        List<String> damagedSeats = cinemaConfig.getDamagedSeats("BANNY Hùng Vương Plaza", 1);
        for (String seat : damagedSeats) {
            System.out.println(seat);
        }
    }

}
