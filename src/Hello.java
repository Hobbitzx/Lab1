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
		String result=TextProcess(file);       //result即为处理后的字符串
		String[] s = result.split(" ");
		
		
		vertex V=new vertex(s[0]);
		GT.G.put(s[0], V);
		for(int i=0;i<s.length-1;i++)
		{
			GT.put(s[i], s[i+1]);     //存入所有边
		}
		showDirectedGraph( GT);//显示图
		
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
				word1=Input();
				word2=Input();
				GT.queryBridgeWords(word1,word2);  //查找桥接词
				break;
			case 2:
				word1=Input();
				word1=GT.generateNewText(word1);
				break;
			case 3:
				word1=Input();//最短路径1
				GT.calcShortestPath(word1);
				break;
			case 4:
				word1=Input();
				word2=Input();
				GT.calcShortestPath(word1, word2);//最短路径2
				break;
			case 5:
				GT.randomWalk();                  //随机游走
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
		String NotLetter = "[^a-zA-Z]";        //负值字符集合，匹配非字母字符
		s=s.replaceAll(NotLetter," ");     //将s中所有非字母字符换成空格
		s=s.trim();                        //去掉首尾空格
		s=s+" ";                           //每行最后加一个空格
		s=s.replaceAll("\\s{1,}", " ");    //其中\s代表不可见字符（空格，制表符，换页符），\\s匹配\s，{1,}表示至少匹配1次。代表将多余的空格替换成一个空格
		s=s.toLowerCase();                 //将大写字母全部换成小写字母
		return s;
	}
 	public static String TextProcess(File filepath)
	{
		StringBuilder result = new StringBuilder();//StringBuilder类解决了在对字符串进行重复修改的过程中创建大量对象的问题
		try{
			BufferedReader br = new BufferedReader(new FileReader(filepath));//FileReader:把文件转换为字符流读入，BufferedReader:提供通用的缓冲方式文本读取，针对Reader，提供readline分行读取
			String s = null;
			while((s=br.readLine())!=null)         //当文本没读完时
			{
				s=HandleString(s);
				if(!"".equals(s.trim()))           //去掉空行
				{
					result.append(s);                  //字符拼接到末尾
				}
			}
			result.deleteCharAt(result.length()-1);//删除最后一个空格
			br.close();                            //关闭流
		}catch(Exception e){                       //异常处理
			e.printStackTrace();
		}
		return result.toString();                  //返回处理完毕的字符串
	}

	


	static void showDirectedGraph(Graph GT)
	{
		Iterator<Entry<String, vertex>> iter =GT.G.entrySet().iterator();//对v的边进行遍历
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
		File out = new File("D:/test/out." + type);    // Windows
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





