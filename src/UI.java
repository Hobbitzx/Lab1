	import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map.Entry;
public class UI {
	public static void main(String[] args) throws IOException
	{
		String word1,word2;
		Graph graph=new Graph();
		String filepath=null;
		TextProcess textProcess=new TextProcess();
		GraphProcess graphprocess=new GraphProcess();
		boolean flag = true;
		String ret=new String();
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
		String result=TextProcess.textProcess(file);       //result��Ϊ�������ַ���
		graph.InitGraph(result);
		
		GraphProcess.showDirectedGraph( graph);//��ʾͼ
		
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
				word1=TextProcess.Input();
				word2=TextProcess.Input();
				ret=GraphProcess.queryBridgeWords(word1,word2,graph);  //�����ŽӴ�
				System.out.println(ret);
				break;
			case 2:
				word1=TextProcess.Input();
				word1=TextProcess.HandleString(word1);
				ret=GraphProcess.generateNewText(word1,graph);
				System.out.println(ret);
				break;
			case 3:
				word1=TextProcess.Input();//���·��1
				ret=graphprocess.calcShortestPath(word1,graph);
				System.out.print(ret);
				break;
			case 4:
				word1=TextProcess.Input();
				word2=TextProcess.Input();
				ret=graphprocess.calcShortestPath(word1, word2,graph);//���·��2
				System.out.println(ret);
				break;
			case 5:
				ret=GraphProcess.randomWalk(graph);                  //�������
				System.out.println(ret);
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
}