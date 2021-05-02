package kg.megacom;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
    {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("http://www.geoplugin.net/xml.gp?base_currency=USD");
        document.getDocumentElement().normalize();
        Element root = document.getDocumentElement();
        System.out.println("Root element: "+ root.getNodeName());
        Node node = document.getFirstChild();
        NodeList childs = node.getChildNodes();
        printChildNodes(childs);
    }

    private static void printChildNodes(NodeList nList)
    {
        for (int temp = 0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                System.out.println(node.getNodeName() + ": " + node.getTextContent());
            }
        }
    }


}





