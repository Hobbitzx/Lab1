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
				System.out.println("请输入文本文件所在位置:");
				BufferedReader in = new BufferedReader(
						new InputStreamReader(System.in ));
				filepath = in.readLine();              //读取输入的文件路径
				File isfile = new File(filepath);
				if(isfile.exists())
				{
					flag = false;
				}
				else
				{
					System.out.println("无效的文件路径");
				}
				
			}catch (Exception e1) {

				flag = true;
				System.out.println("Invalid input");
			}              //读取输入的文件路径
			
		}
		
		
		File file = new File(filepath);
		String result=TextProcess.textProcess(file);       //result即为处理后的字符串
		graph.InitGraph(result);
		
		GraphProcess.showDirectedGraph( graph);//显示图
		
		while(true)
		{
		System.out.println("请选择后续功能（输入对应序号）");
		System.out.println("1代表查找桥接词");
		System.out.println("2代表根据桥接词生成新文本");
		System.out.println("3代表单源最短路径");
		System.out.println("4代表两点间最短路径");
		System.out.println("5代表随机游走");
		System.out.println("6代表退出程序");
		try{
			BufferedReader input = new BufferedReader(
					new InputStreamReader(System.in ));
			String i = input.readLine();              //读取输入的文件路径
			int j = Integer.parseInt(String.valueOf(i));
			switch(j)
			{
			case 1:
				word1=TextProcess.Input();
				word2=TextProcess.Input();
				ret=GraphProcess.queryBridgeWords(word1,word2,graph);  //查找桥接词
				System.out.println(ret);
				break;
			case 2:
				word1=TextProcess.Input();
				word1=TextProcess.HandleString(word1);
				ret=GraphProcess.generateNewText(word1,graph);
				System.out.println(ret);
				break;
			case 3:
				word1=TextProcess.Input();//最短路径1
				ret=graphprocess.calcShortestPath(word1,graph);
				System.out.print(ret);
				break;
			case 4:
				word1=TextProcess.Input();
				word2=TextProcess.Input();
				ret=graphprocess.calcShortestPath(word1, word2,graph);//最短路径2
				System.out.println(ret);
				break;
			case 5:
				ret=GraphProcess.randomWalk(graph);                  //随机游走
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