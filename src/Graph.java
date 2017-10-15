import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;



//This is my second modify of Second Scene
//This is my second modify of Second Scene
//This is my second modify of Second Scene

//This is my first modify of Second Scene
//This is my first modify of Second Scene ,too



printf("Hello World");

public class Graph {
	HashMap<String,vertex> G;

	String [] T;
	int number;
	public void put(String S1,String S2)
	{
		vertex v2;
		if(G.get(S2)==null) 
		{
			v2=new vertex(S2);//创建V2
			T[number]=S2;
			number++;
			G.put(S2, v2);
		}
		else 
		{
			v2=G.get(S2);//S2与V2建立映射存入hashMap
		}
		G.get(S1).put(S2, v2);//在S1对应顶点中存入对应边
	}
	public Graph()
	{
		G= new HashMap<String,vertex>();
		//Bridge=new HashMap<String[],ArrayList<String>>(50);
		T=new String[1500];
		number=0;
	}
	
	
	void init()
	{
		Iterator<Entry<String, vertex>> iter =G.entrySet().iterator();//对v的边进行遍历
		while(iter.hasNext())
		{
			Entry<String,vertex> entry=iter.next();
			entry.getValue().Init();
		}
	}

	
	ArrayList<String> BridgeWords(String word1,String word2)
	{
		ArrayList<String> StringArray= new ArrayList<String>();
		vertex V=G.get(word1);
		if(G.get(word1)==null||G.get(word2)==null) return StringArray;
		Iterator<Entry<String, Edge>> iter =V.E.entrySet().iterator();//对v的边进行遍历
		while(iter.hasNext())
		{
			Entry<String, Edge> entry=iter.next();
			vertex _V=entry.getValue().to;//_V是于V相连的顶点
			if(_V.E.get(word2)!=null)
			{
				StringArray.add(_V.text);
			}
		}
		return StringArray;
	}
	
	void Dijkstra(vertex V)
	{
		V.Dist=0;
		vertex Small;
		for(;;)
		{
			Small=Findsmall();
			if(Small==null) break;
			Small.Know=1;
			Iterator<Entry<String,Edge>> Iter= Small.E.entrySet().iterator();
			while(Iter.hasNext())
			{
				Entry<String, Edge> entry=Iter.next();
				if(entry.getValue().to.Know==0)
				{
					if(Small.Dist+entry.getValue().wight<entry.getValue().to.Dist|entry.getValue().to.Dist==-1)
					{
						entry.getValue().to.Dist=Small.Dist+entry.getValue().wight;
						entry.getValue().to.P=Small;
					}
				}
			}	
		}
	}
	
	private vertex Findsmall()
	{
		Iterator<Entry<String, vertex>> iter =G.entrySet().iterator();//对v的边进行遍历
		vertex Small=null;
		int dist =-1;
		while(iter.hasNext())
		{
			Entry<String, vertex> entry=iter.next();
			if(entry.getValue().Dist!=-1 & (dist==-1 | entry.getValue().Dist<dist) & entry.getValue().Know==0)
			{
				Small=entry.getValue();
				dist=entry.getValue().Dist;
			}
		}
		return Small;
	}
	
	void randomWalk() throws IOException
	{
		Random ran = new Random();//随机数
		StringBuilder M = new StringBuilder();
		String[] S =new String[2];
		HashMap<Edge,Integer> H=new HashMap<Edge,Integer>();//一个边到整数的hashmap
		if(number==0) return;//图中点的数量为0直接返回（似乎可以加一句话）
		int r=ran.nextInt(100)%number;//r为0到顶点数-1之间的一个数
		vertex V= G.get(T[r]);
		M.append(V.text);
		if(V.number==0) //所选点中边的数量为0
		{
			System.out.println(V.text);
			M.append(V.text);
			return;
		}
		r=ran.nextInt(100)%V.number;//0到边数-1中选择一个数
		Edge E=V.E.get(V.T[r]);//E为所选边
		while(H.get(E)==null&V.number!=0&number!=0)//循环条件为 E没被选到 且所选点的边数都不为0
		{S[0]=V.text;//E中起点的字符串
			S[1]=E.to.text;//E终点的字符串
			M.append(" "+S[1]);
			H.put(E,1);
			V=E.to;
			if(V.number==0)
			{String m = M.toString();
				m=m.trim();//去掉首尾空格
				System.out.println(m);
				FileWriter fw = new FileWriter("D:/test/text1.txt",true);
				fw.write(m+"\r\n");
				fw.flush();
				fw.close();
				return;
			}
			r=ran.nextInt(100)%V.number;
			E=V.E.get(V.T[r]);
		}
		M.append(" " +E.to.text);
		String m = M.toString();
		m=m.trim();//去掉首尾空格
		System.out.println(m);
		FileWriter fw = new FileWriter("D:/test/text1.txt",true);
		fw.write(m+"\r\n");
		fw.flush();
		fw.close();
		
	}
	void calcShortestPath(String word1,String word2)
	{
		init();
		Dijkstra(G.get(word1));
		if(G.get(word2).Dist==-1)
		{
			System.out.println("不可达");
			return;
		}
		print(G.get(word2));
		System.out.println();
	}
	void print(vertex V)
	{
		if(V.P!=null)
		{
			print(V.P);
			System.out.print("->");
		}
		System.out.print(V.text);
	}
	void calcShortestPath(String word)
	{
		init();
		Dijkstra(G.get(word));
		Iterator<Entry<String, vertex>> iter =G.entrySet().iterator();//对v的边进行遍历
		while(iter.hasNext())
		{
			Entry<String,vertex> entry=iter.next();
			if(entry.getValue().Dist==-1)
			{
				continue;
			}
			else if(entry.getKey().equals(word))
			{
				continue;
			}
			print(entry.getValue());
			System.out.println();
		}
		
	}
	void queryBridgeWords(String word1,String word2)
	{
		ArrayList<String> StringArray;
		if(G.get(word1)!=null & G.get(word2)!=null )
		{
			StringArray=BridgeWords(word1, word2);
			if(StringArray.isEmpty())
			{
				System.out.println("No bridge words from \"" + word1 + "\" to \"" + word2 + "\"");
			}
			else if(StringArray.size()==1)
			{
				System.out.print("The bridge word from \""+ word1+ "\" to \"" +word2 +"\" is: ");
				System.out.println(StringArray.get(0));
			}
			else
			{
				//对v的边进行遍历
				System.out.print("The bridge words from \""+ word1+ "\" to \"" +word2 +"\" are: ");
				for(int i=0;i<StringArray.size();i++)
				{
					System.out.print(StringArray.get(i));
					if(i==StringArray.size()-2) System.out.print(",");
					else if(i!=StringArray.size()-1) System.out.print(",");
				}
				System.out.println(".");
			}
			
		}
		else if(G.get(word1)==null & G.get(word2)==null)
		{
			System.out.println("No \"" + word1 + "\" and \"" + word2 + "\" in the graph");
			return;
		}
		else if(G.get(word1)==null)
		{
			System.out.println("No \"" + word1 + "\" in the graph");
			return;
		}
		else if(G.get(word2)==null)
		{
			System.out.println("No \"" + word2 +"\" in the graph");
			return;
		}
		else
		{
			return;
		}
	}
	String generateNewText(String inputText)
	{
		Random ran = new Random();
		inputText = HandleString(inputText);
		String[] s=inputText.split(" ");
		StringBuilder S=new StringBuilder(inputText) ;
		String Insert;
		int num=0;
		ArrayList<String> A;
		//System.out.println(s.length);
		if(s.length>1) 
		{
			for(int i=0;i<s.length-1;i++)//对v的边进行遍历
			{
				//queryBridgeWords(s[i],s[i+1]);
				//System.out.println(s[i+1]);
				A=BridgeWords(s[i],s[i+1]);
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
	public static String HandleString(String s) 
	{
		String NotLetter = "[^a-zA-Z]";        //负值字符集合，匹配非字母字符
		s=s.replaceAll(NotLetter," ");     //将s中所有非字母字符换成空格
		s=s.trim();                        //去掉首尾空格
		s=s+" ";                           //每行最后加一个空格
		s=s.replaceAll("\\s{1,}", " ");    //其中\s代表不可见字符（空格，制表符，换页符），\\s匹配\s，{1,}表示至少匹配1次。代表将多余的空格替换成一个空格
		
		return s;
	}


}

