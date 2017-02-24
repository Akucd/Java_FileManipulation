import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] number = new int [20];
		int [] input = {1,2,4,5,1,4};
		
		int [] pair = new int [20];
		
		ArrayList<Integer> fileArray = new ArrayList<Integer>();
		
		ArrayList<String> fileArr = new ArrayList<String>();
		for(int i = 0; i<input.length;i++){
			fileArray.add(input[i]);
		}
		System.out.println(fileArray);
		
		fileArray.sort(null);
		int j=0;
		for (int i=0; i<fileArray.size()-1;i++){
			if (fileArray.get(i)==fileArray.get(i+1)){
				fileArray.remove(i);
			}
		}
		
		System.out.println(fileArray);
		
		String filename =" ";
		FileReader getFile;
		try {
			getFile = new FileReader(filename);
			Scanner readFile = new Scanner(getFile);
			
			while (readFile.hasNext()){
				fileArr.add(readFile.next());
			}
			ArrayList<Integer> bra = new ArrayList<Integer>();
			ArrayList<Integer> rbra = new ArrayList<Integer>();
			
			String [] opbrackets={"{","[","(","<"};
			String [] ropbrackets={"}","]",")",">"};
			
			for (int w=0; w<fileArr.size();w++){
				for (int p=0;p<opbrackets.length;p++){
				if (fileArr.get(w).equals(opbrackets[p])){
				    	bra.add(p);
			}
				if (fileArr.get(w).equals(ropbrackets[p])){
			    	rbra.add(p);
			}
				int count =0;
				if (bra.size()!= rbra.size()){
					System.out.println("no");
				}
				
				else {
					
					for (int e=0;e<bra.size();e++){
						if (bra.get(e)==rbra.get(e)){
							count++;
						}
					}
				}
				if (count==bra.size()){
					System.out.println("Yes");
				}
				
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
