package name;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.google.gson.JsonParseException;


public class CSVParser {
    private String fileName = "";
    private List<Assignment> assignments;
   
    CSVParser(String fileName){
    	 this.fileName = fileName;
         this.assignments = new ArrayList<>();
    }
    public void parse() {
			try {
				File file = new File(fileName);
			    Scanner sc = new Scanner(file);
			    
			    while(sc.hasNextLine()) {
			    	String line = sc.nextLine();
			    	String[] parts = line.split(",");
		            
		            if (parts.length >= 5) {
		                assignments.add(new Assignment(parts[0], parts[1], parts[2], parts[3], parts[4]));
		                //cast if needed
		            } else {
		                System.out.println("Invalid line (not enough fields): " + line);
		            } 
			    	/*assignments.add(new Assignment(line));*/

		        }
			    System.out.println("The file has been properly read\n");
			    sc.close();
			}catch(FileNotFoundException e) {
				System.out.println("The file " + fileName +" could not be found.\n");
			}catch(JsonParseException e) {
				System.out.println("The file " + fileName +" is not formatted properly.");
			}catch (IOException e) {
				System.out.println("Error: An error occurred while reading the file.");
			}catch(NumberFormatException e) {
				System.out.println("The file " + fileName +" is not formatted properly.");
			}catch(IllegalArgumentException e) {
				System.out.println("The file " + fileName +" is not csv file.");
			}
		}
	

}
