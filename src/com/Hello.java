package com;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map.Entry;


/***/
public final class Hello{
    private Hello()
    {
    }
	public static void main(final String[] args) throws IOException {
		String word1;
		String word2;
		final Graph graph = new Graph();
		String filepath = null;

		boolean flag = true;
		while (flag) {
			try {
				System.out.println("请输入文本文件所在位置:");
final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				filepath = reader.readLine(); // 读取输入的文件路径
				final File isfile = new File(filepath);
				if (isfile.exists()) {
					flag = false;
				} else {
					System.out.println("无效的文件路径");
				}

			} catch (Exception e1) {
				// e1.printStackTrace();
				flag = true;
				System.out.println("Invalid input");
			} // 读取输入的文件路径

		}

		final File file = new File(filepath);
		final String result = textProcess(file); // result即为处理后的字符串
		final String[] string = result.split(" ");

		final Vertex vnew = new Vertex(string[0]);
		graph.getGhashmap().put(string[0], vnew);
		for (int i = 0; i < string.length - 1; i++) {
			graph.put(string[i], string[i + 1]); // 存入所有边
		}
		showDirectedGraph(graph);// 显示图

		while (true) {
			System.out.println("请选择后续功能（输入对应序号）");
			System.out.println("1代表查找桥接词");
			System.out.println("2代表根据桥接词生成新文本");
			System.out.println("3代表单源最短路径");
			System.out.println("4代表两点间最短路径");
			System.out.println("5代表随机游走");
			System.out.println("6代表退出程序");
			try {
final BufferedReader input =
new BufferedReader(new InputStreamReader(System.in));
				final String path = input.readLine(); // 读取输入的文件路径
				final int pathInt = Integer.parseInt(String.valueOf(path));
				switch (pathInt) {
				case 1:
					word1 = input();
					word2 = input();
graph.queryBridgeWords(word1, word2);
				// 查找桥接词
					break;
				case 2:
					word1 = input();
					word1 = graph.generateNewText(word1);
					break;
				case 3:
					word1 = input();// 最短路径1
					graph.calcShortestPath(word1);
					break;
				case 4:
					word1 = input();
					word2 = input();
					graph.calcShortestPath(word1, word2);
				// 最短路径2
					break;
				case 5:
					graph.randomWalk(); // 随机游走
					break;
				case 6:
					System.exit(-1);
					break;
				default:
					System.out.println("Invalid Input");
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	/***/
	public static String handleString(final String string) {
		final String notLetter = "[^a-zA-Z]"; // 负值字符集合，匹配非字母字符
		String snew=null;
		snew = string.replaceAll(notLetter, " "); // 将s中所有非字母字符换成空格
		snew = snew.trim(); // 去掉首尾空格
		snew += " "; // 每行最后加一个空格
snew = snew.replaceAll("\\string{1,}", " ");
// 其中\s代表不可见字符（空格，制表符，换页符），\\s匹配\string，{1,}表示至少匹配1次。代表将多余的空格替换成一个空格
		snew = snew.toLowerCase(); // 将大写字母全部换成小写字母
		return snew;
	}

	/***/
	public static String textProcess(final File filepath){
		final StringBuilder result = new StringBuilder();
// StringBuilder类解决了在对字符串进行重复修改的过程中创建大量对象的问题
		try {
final BufferedReader brdr =
new BufferedReader(new FileReader(filepath));
// FileReader:把文件转换为字符流读入，BufferedReader:提供通用的缓冲方式文本读取，针对Reader，提供readline分行读取
			String string = null;
			while ((string = brdr.readLine()) != null) // 当文本没读完时
			{
				string = handleString(string);
				if (!"".equals(string.trim())) // 去掉空行
				{
					result.append(string); // 字符拼接到末尾
				}
			}
			result.deleteCharAt(result.length() - 1);// 删除最后一个空格
			brdr.close(); // 关闭流
		} catch (Exception e) { // 异常处理
			e.printStackTrace();
		}
		return result.toString(); // 返回处理完毕的字符串
	}

	static void showDirectedGraph(final Graph graph){
		Iterator<Entry<String, Vertex>> iter =
graph.getGhashmap().entrySet().iterator();
// 对v的边进行遍历
		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());
		while (iter.hasNext()) {
			Entry<String, Vertex> entry = iter.next();
			if (entry.getValue().getEdgename().isEmpty())
				continue;
Iterator<Entry<String, EdgeNode>> it =
entry.getValue().getEdgename().entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, EdgeNode> en = it.next();
				gv.add(entry.getKey() + "->" + en.getKey());
gv.addln("[label=" + en.getValue().getWight()
+ "]");
			}
		}
		gv.addln(gv.end_graph());
		System.out.println(gv.getDotSource());
		String type = "png";
		String repesentationType = "dot";
		File out = new File("D:/test/out." + type); // Windows
gv.writeGraphToFile(gv.getGraph(gv.getDotSource(),
type, repesentationType), out);
	}

	public static String input() {

		String input = null;
		try {
BufferedReader in =
new BufferedReader(new InputStreamReader(System.in));
			input = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}
}
