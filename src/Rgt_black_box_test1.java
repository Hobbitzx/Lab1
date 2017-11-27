import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class Rgt_black_box_test1 {

	@Test
	void testCalcShortestPathStringGraph() {
		Graph spGraph1 = new Graph();
		GraphProcess gp1 = new GraphProcess();
		String file = "C:\\users\\hgdzx\\desktop\\test\\test_black_box.txt";
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
		spGraph1.ghashmap.put(s1[0], V);
		for(int i=0;i<s1.length-1;i++)
		{
			spGraph1.put(s1[i], s1[i+1]);    
		}
		String Actual = gp1.calcShortestPath("to",spGraph1);
		System.out.print(Actual);
		String Expected = new String("to->explore->strange->new\n" + 
				"to->explore->strange->new->worlds\n" + 
				"to->explore\n" + 
				"to->explore->strange->new->life->and\n" + 
				"to->explore->strange->new->civilizations\n" + 
				"to->seek\n" + 
				"to->explore->strange\n" + 
				"to->explore->strange->new->life\n" + 
				"to->seek->out\n"
				+ ""); 
		assertEquals(Expected,Actual);
	}

}
