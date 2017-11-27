import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class Rgt_white_box_test6 {

	@Test
	void testQueryBridgeWords() {
        Graph spGraph10 = new Graph();
		GraphProcess gp10 = new GraphProcess();
		String file = "C:\\users\\hgdzx\\desktop\\test\\test_white_box.txt";
		File filepath = new File(file);
		StringBuilder result = new StringBuilder();
		try{
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			String s = null;
			while((s=br.readLine())!=null)         
			{
				String NotLetter = "[^a-zA-Z]";       
			    s=s.replaceAll(NotLetter," ");     
			    s=s.trim();                        
			    s=s+" ";                           
			    s=s.replaceAll("\\s{1,}", " ");    
			    s=s.toLowerCase();                 
				if(!"".equals(s.trim()))           
				{
					result.append(s);                  
				}
			}
			result.deleteCharAt(result.length()-1);
			br.close();                            
		}catch(Exception e){                       
			e.printStackTrace();
		}
		String processed=result.toString();       
		String[] s1 = processed.split(" ");
		Vertex V=new Vertex(s1[0]);
		spGraph10.ghashmap.put(s1[0], V);
		for(int i=0;i<s1.length-1;i++)
		{
			spGraph10.put(s1[i], s1[i+1]);    
		}		
		String Actual = gp10.queryBridgeWords("to","out",spGraph10);
		String Expected = new String("The bridge words from \"to\" to \"out\" are: zx and seek."); 
		assertEquals(Expected,Actual);
	}

}
