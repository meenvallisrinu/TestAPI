import java.io.*;
import java.nio.file.*;
import java.util.*;

public class XMLComparer {

    public static void main(String[] args) {
        // Replace these with your XML file paths
        String file1Path = "file1.xml";
        String file2Path = "file2.xml";

        compareXMLFiles(file1Path, file2Path);
    }

    public static void compareXMLFiles(String file1Path, String file2Path) {
        try (BufferedReader br1 = Files.newBufferedReader(Paths.get(file1Path));
             BufferedReader br2 = Files.newBufferedReader(Paths.get(file2Path))) {

            String line1;
            String line2;
            int lineNumber = 1;
            boolean areEqual = true;

            while ((line1 = br1.readLine()) != null || (line2 = br2.readLine()) != null) {
                // If lines are different lengths (i.e., one file has more lines than the other)
                if (line1 == null || line2 == null) {
                    areEqual = false;
                    System.out.println("Files differ at line " + lineNumber + ": One file is longer than the other.");
                    break;
                }

                // Trim leading/trailing whitespaces for better comparison
                line1 = line1.trim();
                line2 = line2.trim();

                if (!line1.equals(line2)) {
                    areEqual = false;
                    System.out.println("Difference at line " + lineNumber + ":");
                    System.out.println("File 1: " + line1);
                    System.out.println("File 2: " + line2);
                    break;
                }
                lineNumber++;
            }

            if (areEqual) {
                System.out.println("The XML files are identical.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}