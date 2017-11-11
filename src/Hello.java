//This is my second modify of Second Scene
import java.io 
.BufferedReader;
import java.io 
//This is my second modify of Second Scene
.IOException;
import java.io 
.InputStreamReader;
import java.io 
//This is my second modify of Second Scene
.File;
import java.io.FileNotFoundException;
//This is my second modify of Second Scene
//This is my second modify of Second Scene
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Hello {

	
	public static void main(String[] args) throws IOException
	{
		String word1,word2;
		Graph GT=new Graph();
		String filepath=null;
		
		boolean flag = true;
		while(flag)
		{			
			try {
				System.out.println("�������ı��ļ�����λ��:");
				BufferedReader in = new BufferedReader(
						new InputStreamReader(System.in ));
				filepath = in.readLine();              //��ȡ������ļ�·��
				File isfile = new File(filepath);
				if(isfile.exists())
				{
					flag = false;
				}
				else
				{
					System.out.println("��Ч���ļ�·��");
				}
				
			}catch (Exception e1) {

				flag = true;
				System.out.println("Invalid input");
			}              //��ȡ������ļ�·��
			
		}
		
		
		File file = new File(filepath);
		String result=TextProcess(file);       //result��Ϊ�������ַ���
		String[] s = result.split(" ");
		
		
		vertex V=new vertex(s[0]);
		GT.G.put(s[0], V);
		for(int i=0;i<s.length-1;i++)
		{
			GT.put(s[i], s[i+1]);     //�������б�
		}
		showDirectedGraph( GT);//��ʾͼ
		
		while(true)
		{
		System.out.println("��ѡ��������ܣ������Ӧ��ţ�");
		System.out.println("1��������ŽӴ�");
		System.out.println("2��������ŽӴ��������ı�");
		System.out.println("3����Դ���·��");
		System.out.println("4������������·��");
		System.out.println("5�����������");
		System.out.println("6�����˳�����");
		try{
			BufferedReader input = new BufferedReader(
					new InputStreamReader(System.in ));
			String i = input.readLine();              //��ȡ������ļ�·��
			int j = Integer.parseInt(String.valueOf(i));
			switch(j)
			{
			case 1:
				word1=Input();
				word2=Input();
				GT.queryBridgeWords(word1,word2);  //�����ŽӴ�
				break;
			case 2:
				word1=Input();
				word1=GT.generateNewText(word1);
				break;
			case 3:
				word1=Input();//���·��1
				GT.calcShortestPath(word1);
				break;
			case 4:
				word1=Input();
				word2=Input();
				GT.calcShortestPath(word1, word2);//���·��2
				break;
			case 5:
				GT.randomWalk();                  //�������
				break;
			case 6:
				System.exit(-1);
				break;
			default:
				System.out.println("Invalid Input");
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
		}
		
		
	}
	public static String HandleString(String s) 
	{
		String NotLetter = "[^a-zA-Z]";        //��ֵ�ַ����ϣ�ƥ�����ĸ�ַ�
		s=s.replaceAll(NotLetter," ");     //��s�����з���ĸ�ַ����ɿո�
		s=s.trim();                        //ȥ����β�ո�
		s=s+" ";                           //ÿ������һ���ո�
		s=s.replaceAll("\\s{1,}", " ");    //����\s�����ɼ��ַ����ո��Ʊ������ҳ������\\sƥ��\s��{1,}��ʾ����ƥ��1�Ρ���������Ŀո��滻��һ���ո�
		s=s.toLowerCase();                 //����д��ĸȫ������Сд��ĸ
		return s;
	}
 	public static String TextProcess(File filepath)
	{
		StringBuilder result = new StringBuilder();//StringBuilder�������ڶ��ַ��������ظ��޸ĵĹ����д����������������
		try{
			BufferedReader br = new BufferedReader(new FileReader(filepath));//FileReader:���ļ�ת��Ϊ�ַ������룬BufferedReader:�ṩͨ�õĻ��巽ʽ�ı���ȡ�����Reader���ṩreadline���ж�ȡ
			String s = null;
			while((s=br.readLine())!=null)         //���ı�û����ʱ
			{
				s=HandleString(s);
				if(!"".equals(s.trim()))           //ȥ������
				{
					result.append(s);                  //�ַ�ƴ�ӵ�ĩβ
				}
			}
			result.deleteCharAt(result.length()-1);//ɾ�����һ���ո�
			br.close();                            //�ر���
		}catch(Exception e){                       //�쳣����
			e.printStackTrace();
		}
		return result.toString();                  //���ش�����ϵ��ַ���
	}

	


	static void showDirectedGraph(Graph GT)
	{
		Iterator<Entry<String, vertex>> iter =GT.G.entrySet().iterator();//��v�ı߽��б���
		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());
		while(iter.hasNext())
		{
			Entry<String, vertex> entry=iter.next();
			if(entry.getValue().E.isEmpty()) continue;
			Iterator<Entry<String, Edge>> it =entry.getValue().E.entrySet().iterator();
				while(it.hasNext())
				{
				Entry<String, Edge> en=it.next();
				gv.add(entry.getKey()+"->"+en.getKey());
				gv.addln("[label="+en.getValue().wight+"]");
				}
		}
		gv.addln(gv.end_graph());
		System.out.println(gv.getDotSource());
		String type = "png";
		String repesentationType= "dot";
		File out = new File("C:/users/hgdzx/desktop/test/out." + type);    // Windows
		gv.writeGraphToFile( gv.getGraph(gv.getDotSource(), type, repesentationType), out );
	}

	public static String Input()
	{
	    
			String input = null;
			try{
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				input = in.readLine();
			}catch(IOException e){
				e.printStackTrace();
			}
			return input;
	}
}





