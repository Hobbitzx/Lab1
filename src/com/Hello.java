package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/***/
public final class Hello {
	/***/
	static private Logger logger;

	static {
		try {
			logger = Logger.getLogger("log");
			final FileHandler fileHandler = new FileHandler("D:\\log.txt");
			fileHandler.setFormatter(new SimpleFormatter());
			logger.addHandler(fileHandler);
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
	}

	private Hello() {
	}

	/***/
	public static void main(final String[] args) throws IOException {
		String word1;
		String word2;
		final Graph graph = new Graph();
		String filepath = null;

		boolean flag = true;
		while (flag) {
			try {
				logger.info("请输入文本文件所在位置:");
				final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				filepath = reader.readLine(); // 读取输入的文件路径
				if (filepath == null) {
					flag = false;
					break;
				}
				final File isfile = new File(filepath);
				if (isfile != null && isfile.exists()) {
					flag = false;
				} else {
					logger.info("无效的文件路径");
				}

			} catch (Exception e1) {
				// e1.printStackTrace();
				flag = true;
				logger.info("Invalid input");
			} // 读取输入的文件路径

		}

		if (filepath == null) {
			flag = false;
			return;
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
			logger.info("请选择后续功能（输入对应序号）");
			logger.info("1代表查找桥接词");
			logger.info("2代表根据桥接词生成新文本");
			logger.info("3代表单源最短路径");
			logger.info("4代表两点间最短路径");
			logger.info("5代表随机游走");
			logger.info("6代表退出程序");
			try {
				final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
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
					logger.info("Invalid Input");
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	/***/
	public static String handleString(String string) {
		String NotLetter = "[^a-zA-Z]";        //负值字符集合，匹配非字母字符
		string=string.replaceAll(NotLetter," ");     //将s中所有非字母字符换成空格
		string=string.trim();                        //去掉首尾空格
		string=string+" ";                           //每行最后加一个空格
		string=string.replaceAll("\\s{1,}", " ");    //其中\s代表不可见字符（空格，制表符，换页符），\\s匹配\string，{1,}表示至少匹配1次。代表将多余的空格替换成一个空格
		string=string.toLowerCase();                 //将大写字母全部换成小写字母
		return string;
	}

	/***/
	public static String textProcess(final File filepath) {
		final StringBuilder result = new StringBuilder();
		// StringBuilder类解决了在对字符串进行重复修改的过程中创建大量对象的问题
		try {
			final BufferedReader brdr = new BufferedReader(new FileReader(filepath));
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

	static void showDirectedGraph(final Graph graph) {
		Iterator<Entry<String, Vertex>> iter = graph.getGhashmap().entrySet().iterator();
		// 对v的边进行遍历
		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());
		while (iter.hasNext()) {
			Entry<String, Vertex> entry = iter.next();
			if (entry.getValue().getEdgename().isEmpty())
				continue;
			Iterator<Entry<String, EdgeNode>> it = entry.getValue().getEdgename().entrySet().iterator();
			while (it.hasNext()) {
				Entry<String, EdgeNode> en = it.next();
				gv.add(entry.getKey() + "->" + en.getKey());
				gv.addln("[label=" + en.getValue().getWight() + "]");
			}
		}
		gv.addln(gv.end_graph());
		logger.info(gv.getDotSource());
		String type = "png";
		String repesentationType = "dot";
		File out = new File("E:\\out." + type); // Windows
		gv.writeGraphToFile(gv.getGraph(gv.getDotSource(), type, repesentationType), out);
	}

	public static String input() {

		String input = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			input = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}
}
