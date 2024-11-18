import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.*;

public class XMLNodeComparer {

    public static void main(String[] args) {
        // Paths to XML files
        String file1Path = "file1.xml";
        String file2Path = "file2.xml";
        
        // The tag name of the node you want to compare
        String targetNodeTag = "targetNode"; // Replace with the actual tag name

        compareXMLNodes(file1Path, file2Path, targetNodeTag);
    }

    public static void compareXMLNodes(String file1Path, String file2Path, String targetNodeTag) {
        try {
            // Parse both XML files
            Document doc1 = parseXML(file1Path);
            Document doc2 = parseXML(file2Path);

            // Extract target nodes from both documents
            NodeList nodes1 = doc1.getElementsByTagName(targetNodeTag);
            NodeList nodes2 = doc2.getElementsByTagName(targetNodeTag);

            // Compare the number of nodes in both files
            if (nodes1.getLength() != nodes2.getLength()) {
                System.out.println("The number of nodes in '" + targetNodeTag + "' differs.");
                System.out.println("File 1 has " + nodes1.getLength() + " nodes.");
                System.out.println("File 2 has " + nodes2.getLength() + " nodes.");
            }

            // Compare the nodes line by line
            int nodeCount = Math.min(nodes1.getLength(), nodes2.getLength());
            for (int i = 0; i < nodeCount; i++) {
                Node node1 = nodes1.item(i);
                Node node2 = nodes2.item(i);
                compareNodeContent(node1, node2, i + 1);
            }

            if (nodes1.getLength() > nodes2.getLength()) {
                System.out.println("File 1 has extra nodes that are not in File 2.");
                for (int i = nodeCount; i < nodes1.getLength(); i++) {
                    Node node = nodes1.item(i);
                    System.out.println("Extra node in File 1 at index " + (i + 1) + ":");
                    printNodeContent(node);
                }
            } else if (nodes2.getLength() > nodes1.getLength()) {
                System.out.println("File 2 has extra nodes that are not in File 1.");
                for (int i = nodeCount; i < nodes2.getLength(); i++) {
                    Node node = nodes2.item(i);
                    System.out.println("Extra node in File 2 at index " + (i + 1) + ":");
                    printNodeContent(node);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Document parseXML(String filePath) throws Exception {
        // Set up the XML parser
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        // Parse the XML file and return the document object
        return builder.parse(new File(filePath));
    }

    private static void compareNodeContent(Node node1, Node node2, int nodeIndex) {
        // Get the text content of each node and trim whitespace
        String content1 = node1.getTextContent().trim();
        String content2 = node2.getTextContent().trim();

        // If the contents are not equal, print the difference
        if (!content1.equals(content2)) {
            System.out.println("Difference at node " + nodeIndex + ":");
            System.out.println("File 1: " + content1);
            System.out.println("File 2: " + content2);
        }
    }

    private static void printNodeContent(Node node) {
        // Print out the content of the node (can be adjusted for better formatting)
        System.out.println(node.getTextContent().trim());
    }
}