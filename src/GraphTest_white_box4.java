import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;

import org.junit.Test;

public class GraphTest_white_box4 {

	@Test
	public void testQueryBridgeWords() {
Graph spGraph = new Graph();
		
		String file = "C:\\users\\hgdzx\\desktop\\test\\test.txt";
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
		vertex V=new vertex(s1[0]);
		spGraph.G.put(s1[0], V);
		for(int i=0;i<s1.length-1;i++)
		{
			spGraph.put(s1[i], s1[i+1]);    
		}
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		spGraph.queryBridgeWords("seek","out");
		String Actual = output.toString();
		String Expected = new String("No bridge words from \"seek\" to \"out\""); 
		assertEquals(Expected,Actual);
		PrintStream originalOutputStream=System.out;
		System.setOut(originalOutputStream);
		System.out.print(Actual);
	}

}
