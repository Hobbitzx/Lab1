import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Map.Entry;

public class GraphProcess {
	static ArrayList<String> BridgeWords(String word1,String word2,Graph graph)
	{
		HashMap<String,Vertex> G=graph.getGhashmap();
		ArrayList<String> StringArray= new ArrayList<String>();
		Vertex V=G.get(word1);
		if(G.get(word1)==null||G.get(word2)==null) return StringArray;
		Iterator<Entry<String, Edge>> iter =V.getEdgename().entrySet().iterator();//��v�ı߽��б���
		while(iter.hasNext())
		{
			Entry<String, Edge> entry=iter.next();
			Vertex _V=entry.getValue().getToNode();//_V����V�����Ķ���
			if(_V.getEdgename().get(word2)!=null)
			{
				StringArray.add(_V.text);
			}
		}
		return StringArray;
	}
	
	static String generateNewText(String inputText,Graph graph)
	{
		Random ran = new Random();
		String[] s=inputText.split(" ");
		StringBuilder S=new StringBuilder(inputText) ;
		String Insert;
		int num=0;
		ArrayList<String> A;
		//System.out.println(s.length);
		if(s.length>1) 
		{
			for(int i=0;i<s.length-1;i++)//��v�ı߽��б���
			{
				//queryBridgeWords(s[i],s[i+1]);
				//System.out.println(s[i+1]);
				A=BridgeWords(s[i],s[i+1],graph);
				num=num+s[i].length()+1;
				if(A.isEmpty()) continue;
				else
				{
					int m=A.size();
					//System.out.println(m);
					Insert=A.get(ran.nextInt(m))+" ";
					//System.out.println(Insert);
					S.insert(num, Insert);
					num=num+Insert.length();
				}
			}
		}
		System.out.println(S.toString());
		return S.toString();
	}
	
	static String  queryBridgeWords(String word1,String word2,Graph graph)
	{
		HashMap<String, Vertex> G = graph.getGhashmap();
		ArrayList<String> StringArray;
		String ret=new String ();
		if(G.get(word1)!=null & G.get(word2)!=null )
		{
			StringArray=BridgeWords(word1, word2,graph);
			if(StringArray.isEmpty())
			{
				ret="No bridge words from \"" + word1 + "\" to \"" + word2 + "\"";
			}
			else if(StringArray.size()==1)
			{
				ret="The bridge word from \""+ word1+ "\" to \"" +word2 +"\" is: ";
				ret=ret+StringArray.get(0);
			}
			else
			{
				//��v�ı߽��б���
				ret="The bridge words from \""+ word1+ "\" to \"" +word2 +"\" are: ";
				for(int i=0;i<StringArray.size();i++)
				{
					ret=ret+StringArray.get(i);
					if(i==StringArray.size()-2) ret=ret+" and ";
					else if(i!=StringArray.size()-1) ret=ret+",";
				}
				ret=ret+".";
			}
			
		}
		else if(G.get(word1)==null & G.get(word2)==null)
		{
			ret="No \"" + word1 + "\" and \"" + word2 + "\" in the graph";
			
		}
		else if(G.get(word1)==null)
		{
			ret="No \"" + word1 + "\" in the graph";
			
		}
		else if(G.get(word2)==null)
		{
			ret="No \"" + word2 +"\" in the graph";
			
		}
		else
		{
			return null;
		}
		return ret;
	}

	String calcShortestPath(String word,Graph graph)
	{
		StringBuilder M=new StringBuilder();
		String ret=new String();
		HashMap<String, Vertex> G = graph.getGhashmap();
		graph.init();
		if (G.get(word) == null) {
			ret="δ���뵥�ʣ�������ѡ����\n";
		}
		else {
			graph.Dijkstra(G.get(word));
			Iterator<Entry<String, Vertex>> iter =G.entrySet().iterator();//��v�ı߽��б���
			while(iter.hasNext())
			{
				Entry<String,Vertex> entry=iter.next();
				if(entry.getValue().getDist()==-1)
				{
					continue;
				}
				else if(entry.getKey().equals(word))
				{
					continue;
				}
				M.append(print(entry.getValue(),ret));
				M.append("\n");
			}
			ret=M.toString();
		}
		return ret;
		
		
	}

	static String print(Vertex V,String Ret)
	{
		StringBuilder M=new StringBuilder();
		if(V.P!=null)
		{
			M=M.append(print(V.P,Ret));
			M=M.append("->");
		}
		M=M.append(V.getText());
		return M.toString();
	}

	String calcShortestPath(String word1,String word2,Graph graph)
	{
		String ret=new String();
		HashMap<String, Vertex> G = graph.getGhashmap();
		graph.init();
		if(G.get(word1)!=null & G.get(word2)!=null )
		{
			graph.Dijkstra(G.get(word1));
			if(G.get(word2).getDist()==-1)
			{
			ret="���ɴ�";
			}
			else
			{
				ret = print(G.get(word2),"");
			}
		}
		else if(G.get(word1)==null & G.get(word2)==null)
		{
			ret="No \"" + word1 + "\" and \"" + word2 + "\" in the graph";
			
		}
		else if(G.get(word1)==null)
		{
			ret="No \"" + word1 + "\" in the graph";
			
		}
		else if(G.get(word2)==null)
		{
			ret="No \"" + word2 +"\" in the graph";
			
		}
		else
		{
			return null;
		}
		return ret;
	}
	
	
	static String randomWalk(Graph graph) throws IOException
	{
		int number=graph.getNumber();
		HashMap<String,Vertex> G=graph.getGhashmap();
		String[] T = graph.getTstring(); 
		
		Random ran = new Random();//�����
		StringBuilder M = new StringBuilder();
		String[] S =new String[2];
		HashMap<Edge,Integer> H=new HashMap<Edge,Integer>();//һ���ߵ�������hashmap
		if(number==0) return null;//ͼ�е������Ϊ0ֱ�ӷ��أ��ƺ����Լ�һ�仰��
		int r=ran.nextInt(100)%number;//rΪ0��������-1֮���һ����
		Vertex V= G.get(T[r]);
		M.append(V.getText());
		if(V.getNumber()==0) //��ѡ���бߵ�����Ϊ0
		{
//			System.out.println(V.getText());
			M.append(V.getText());
			return M.toString();
		}
		r=ran.nextInt(100)%V.number;//0������-1��ѡ��һ����
		Edge E=V.getEdgename().get(V.getTmap()[r]);//EΪ��ѡ��
		while(H.get(E)==null&V.number!=0&number!=0)//ѭ������Ϊ Eû��ѡ�� ����ѡ��ı�������Ϊ0
		{S[0]=V.text;//E�������ַ���
			S[1]=E.getToNode().getText();//E�յ���ַ���
			M.append(" "+S[1]);
			H.put(E,1);
			V=E.getToNode();
			if(V.number==0)
			{String m = M.toString();
				m=m.trim();//ȥ����β�ո�
//				System.out.println(m);
				FileWriter fw = new FileWriter("C:/users/cheng/desktop/randomwalk.txt",true);
				fw.write(m+"\r\n");
				fw.flush();
				fw.close();
				return m;
			}
			r=ran.nextInt(100)%V.number;
			E=V.getEdgename().get(V.getTmap()[r]);
		}
		M.append(" " +E.getToNode().getText());
		String m = M.toString();
		m=m.trim();//ȥ����β�ո�
//		System.out.println(m);
		FileWriter fw = new FileWriter("C:/users/cheng/desktop/randomwalk.txt",true);
		fw.write(m+"\r\n");
		fw.flush();
		fw.close();
		return m;
	}
	static void showDirectedGraph(Graph graph)
	{
		Iterator<Entry<String, Vertex>> iter =graph.getGhashmap().entrySet().iterator();//��v�ı߽��б���
		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());
		while(iter.hasNext())
		{
			Entry<String, Vertex> entry=iter.next();
			if(entry.getValue().getEdgename().isEmpty()) continue;
			Iterator<Entry<String, Edge>> it =entry.getValue().getEdgename().entrySet().iterator();
				while(it.hasNext())
				{
				Entry<String, Edge> en=it.next();
				gv.add(entry.getKey()+"->"+en.getKey());
				gv.addln("[label="+en.getValue().getWight()+"]");
				}
		}
		gv.addln(gv.end_graph());
		System.out.println(gv.getDotSource());
 		String type = "png";
 		String repesentationType= "dot";
 		File out = new File("C:/users/hgdzx/desktop/test/out." + type);    // Windows
 		gv.writeGraphToFile( gv.getGraph(gv.getDotSource(), type, repesentationType), out );
	}
	
}
