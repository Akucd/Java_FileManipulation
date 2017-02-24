import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * The WordSearch class finds all the instances of a string in the file and prints out immediate preceding
 * and immediate succeeding string along with the searched string.  
 * It takes file name and a word as input from user.
 * Note : This is a case sensitive implementation.
 * 
 * @author Akhilesh Sharma
 */

public class WordSearch {

	public static void main(String[] args) {
		// Declaring all the required variables
		String fileName = new String();
		String errorMessage = new String();
		String searchWord = new String();
		String resultText= "";
		Boolean error = false;
		Boolean match = false;
		ArrayList<String> fileArray = new ArrayList<String>();
		
		// using JOption pane to take filename and word as input
		fileName = JOptionPane.showInputDialog(null,"Please input the File Name:");
		
		// trying to read the file
		try {
			FileReader getFile = new FileReader(fileName);
			Scanner readFile = new Scanner(getFile);
			// storing all the words in file in an array list
			while (readFile.hasNext()){
				fileArray.add(readFile.next());
			}
			searchWord = JOptionPane.showInputDialog(null,"Please input the word you are looking for:");
		} 
		
		// catching file-not-found exception 
		catch (FileNotFoundException e) 
		{
			// getting the error message
			errorMessage = "exception: "+ e.getMessage()+"\n";
            error = true;
			//used to display the path where the file is being looked for
			File filePath = new File("");
			errorMessage = errorMessage + "The file is being looked in " + filePath.getAbsolutePath() + " folder \n";
			errorMessage = errorMessage + "Make sure file type is mentioned correctly";
		}
		
		// iterating over the array list. The loop will not be executed if the file is not found.
		if (!error){
		for (int i=0; i<fileArray.size();i++){
			
			// looking for the word
			if (fileArray.get(i).equals(searchWord))
			{
				// catering for start case, i.e. to say if the word happens to be the 
				// first word then we can not print the preceding word
				// Note: In case three words are a necessity to print, this could be used with continue
				if (i==0){
					resultText = resultText + fileArray.get(i)+" "+fileArray.get(++i) + "\n";
					// since increment operator changes the loop value of i
					// need to bring it back to the original loop value
					i--;
					// setting match true for result check
					match =true;
				}
				// catering for another case, i.e. to say if the word happens to be the 
				// last word then we can not print the succeeding word
				// Note: In case three words are a necessity to print, this could be used with continue
				else if (i == fileArray.size()-1)
				{
				    resultText = resultText + fileArray.get(--i)+" "+fileArray.get(++i) + "\n";
				 // setting match true for result check
				    match = true;
				}
				// loop case for all other except for start of the file and end of the file case
				else
				{
					resultText = resultText + fileArray.get(--i)+" "+fileArray.get(++i)+" "+fileArray.get(++i) + "\n";
					// since increment operator changes the loop value of i
					// need to bring it back to the original loop value
					i--;
					// setting match true for result check
					match = true;
				}
			}
		}
		// Displaying the result in JOption pane
		if (fileArray.size()>0){
	        if (!match)
	    	    JOptionPane.showMessageDialog(null, "No matching instance");
	        else
	            JOptionPane.showMessageDialog(null, resultText);
	    }
	    else
		    JOptionPane.showMessageDialog(null, "It is an empty file");
			
	}
		else{
			// Displaying the error in JOption pane
			JOptionPane.showMessageDialog(null, errorMessage);
		}
	
	System.exit(0);
	}

}
