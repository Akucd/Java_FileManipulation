import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * The NumberSearch class finds all the instances of a number in the file and prints out immediate preceding
 * and immediate succeeding string along with the searched number.  
 * It takes file name and a number as input from user.
 * 
 * @author Akhilesh Sharma
 */

public class NumberSearch {
	// source stack overflow
	// defining a constant for double comparison
	final static double EPSILON = .00000001;
	
	public static void main(String[] args) {
		// Declaring all the required variables
		String fileName = new String();
		String errorMessage = new String();
		String resultText= "";
		Boolean match = false;
		Boolean error = false;
		double searchDouble;
		ArrayList<String> fileArray = new ArrayList<String>();
		// using JOption pane to take filename
		fileName = JOptionPane.showInputDialog(null,"Please input the File Name:");
		try {
			// reading from file
			FileReader getFile = new FileReader(fileName);
			Scanner readFile = new Scanner(getFile);
			try {
				// reading number to be searched for
				searchDouble = Double.parseDouble(JOptionPane.showInputDialog(null,"Please input the number you are looking for:"));
				// storing all strings of file in an array list if no exception occurs
				while (readFile.hasNext()){
					fileArray.add(readFile.next());
				}
				// iterating over the array list
				for (int i=0; i<fileArray.size();i++){
					// trying to parse each value to a double, if not possible then continuing with the loop
					try {
						//trying to parse value to double
						Double parsedValue = Double.parseDouble(fileArray.get(i));
						// checking for match
						if (Math.abs(parsedValue-searchDouble) < EPSILON)
						{
							// catering for start case, i.e. to say if the number happens to be the 
							// first word then we can not print the preceding word
							// Note: In case three words are a necessity to print, this could be used with continue
							if (i==0){
								resultText = resultText + fileArray.get(i)+" "+fileArray.get(++i) + "\n";
								// since increment operator changes the loop value of i
								// need to bring it back to the original loop value
								i--;
								// setting match to true for result check
								match = true;
							}
							// catering for another case, i.e. to say if the number happens to be the 
							// last word then we can not print the succeeding word
							// Note: In case three words are a necessity to print, this could be used with continue
							else if (i == fileArray.size()-1)
							{
							    resultText = resultText + fileArray.get(--i)+" "+fileArray.get(++i) + "\n";
							 // setting match to true for result check
							    match = true;
							}
							// loop case for all other except for start of the file and end of the file case
							else
							{
								resultText = resultText + fileArray.get(--i)+" "+fileArray.get(++i)+" "+fileArray.get(++i) + "\n";
								// since increment operator changes the loop value of i
								// need to bring it back to the original loop value
								i--;
								// setting match to true for result check
								match = true;
							}
						}
					}
					// if number can not be parsed, continuing with the loop
					catch (Exception e)
					{
						continue;
					}
					
				}
				
			}
			// if the user entered something that can not be parsed to number
			catch (NumberFormatException n)
				{
					errorMessage = "exception: "+ n.getMessage() + "\n" + " Only A number is expected" ;
					// setting error as true for result check 
					error = true;
		    }
		} 
		// if the file that user input is not found
		catch (FileNotFoundException e) 
		{
			error = true;
			errorMessage = "exception: "+ e.getMessage()+"\n";
			// to display path where the file is being looked for
			File filePath = new File("");
			errorMessage = errorMessage + "The file is being looked in " + filePath.getAbsolutePath() + " folder \n";
			errorMessage = errorMessage + "Make sure file type is mentioned correctly";
		}
		// if no error displaying the result
		if (!error){
		    if (fileArray.size()>0){
		        if (!match)
		    	    JOptionPane.showMessageDialog(null, "No matching instance");
		        else
		            JOptionPane.showMessageDialog(null, resultText);
		    }
		    else
			    JOptionPane.showMessageDialog(null, "It is an empty file");
		}
		else
			JOptionPane.showMessageDialog(null, errorMessage);
		
	System.exit(0);
	}

}