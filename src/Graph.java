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




public class Graph {
	HashMap<String,vertex> G;

	String [] T;
	int number;
	public void put(String S1,String S2)
	{
		vertex v2;
		if(G.get(S2)==null) 
		{
			v2=new vertex(S2);//����V2
			T[number]=S2;
			number++;
			G.put(S2, v2);
		}
		else 
		{
			v2=G.get(S2);//S2��V2����ӳ�����hashMap
		}
		G.get(S1).put(S2, v2);//��S1��Ӧ�����д����Ӧ��
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
		Iterator<Entry<String, vertex>> iter =G.entrySet().iterator();//��v�ı߽��б���
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
		Iterator<Entry<String, Edge>> iter =V.E.entrySet().iterator();//��v�ı߽��б���
		while(iter.hasNext())
		{
			Entry<String, Edge> entry=iter.next();
			vertex _V=entry.getValue().to;//_V����V�����Ķ���
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
		Iterator<Entry<String, vertex>> iter =G.entrySet().iterator();//��v�ı߽��б���
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
		Random ran = new Random();//�����
		StringBuilder M = new StringBuilder();
		String[] S =new String[2];
		HashMap<Edge,Integer> H=new HashMap<Edge,Integer>();//һ���ߵ�������hashmap
		if(number==0) return;//ͼ�е������Ϊ0ֱ�ӷ��أ��ƺ����Լ�һ�仰��
		int r=ran.nextInt(100)%number;//rΪ0��������-1֮���һ����
		vertex V= G.get(T[r]);
		M.append(V.text);
		if(V.number==0) //��ѡ���бߵ�����Ϊ0
		{
			System.out.println(V.text);
			M.append(V.text);
			return;
		}
		r=ran.nextInt(100)%V.number;//0������-1��ѡ��һ����
		Edge E=V.E.get(V.T[r]);//EΪ��ѡ��
		while(H.get(E)==null&V.number!=0&number!=0)//ѭ������Ϊ Eû��ѡ�� ����ѡ��ı�������Ϊ0
		{S[0]=V.text;//E�������ַ���
			S[1]=E.to.text;//E�յ���ַ���
			M.append(" "+S[1]);
			H.put(E,1);
			V=E.to;
			if(V.number==0)
			{String m = M.toString();
				m=m.trim();//ȥ����β�ո�
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
		m=m.trim();//ȥ����β�ո�
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
				System.out.print("���ɴ�");
				return;
			}
			print(G.get(word2));
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
		if (G.get(word) == null) {
			System.out.print("δ���뵥�ʣ�������ѡ����\n");
		}
		else {
			Dijkstra(G.get(word));
			Iterator<Entry<String, vertex>> iter =G.entrySet().iterator();//��v�ı߽��б���
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
				//��v�ı߽��б���
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
			for(int i=0;i<s.length-1;i++)//��v�ı߽��б���
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
		String NotLetter = "[^a-zA-Z]";        //��ֵ�ַ����ϣ�ƥ�����ĸ�ַ�
		s=s.replaceAll(NotLetter," ");     //��s�����з���ĸ�ַ����ɿո�
		s=s.trim();                        //ȥ����β�ո�
		s=s+" ";                           //ÿ������һ���ո�
		s=s.replaceAll("\\s{1,}", " ");    //����\s�����ɼ��ַ����ո��Ʊ������ҳ������\\sƥ��\s��{1,}��ʾ����ƥ��1�Ρ���������Ŀո��滻��һ���ո�
		
		return s;
	}


}

