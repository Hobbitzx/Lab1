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
				System.out.println("�������ı��ļ�����λ��:");
final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				filepath = reader.readLine(); // ��ȡ������ļ�·��
				final File isfile = new File(filepath);
				if (isfile.exists()) {
					flag = false;
				} else {
					System.out.println("��Ч���ļ�·��");
				}

			} catch (Exception e1) {
				// e1.printStackTrace();
				flag = true;
				System.out.println("Invalid input");
			} // ��ȡ������ļ�·��

		}

		final File file = new File(filepath);
		final String result = textProcess(file); // result��Ϊ�������ַ���
		final String[] string = result.split(" ");

		final Vertex vnew = new Vertex(string[0]);
		graph.getGhashmap().put(string[0], vnew);
		for (int i = 0; i < string.length - 1; i++) {
			graph.put(string[i], string[i + 1]); // �������б�
		}
		showDirectedGraph(graph);// ��ʾͼ

		while (true) {
			System.out.println("��ѡ��������ܣ������Ӧ��ţ�");
			System.out.println("1��������ŽӴ�");
			System.out.println("2��������ŽӴ��������ı�");
			System.out.println("3����Դ���·��");
			System.out.println("4������������·��");
			System.out.println("5�����������");
			System.out.println("6�����˳�����");
			try {
final BufferedReader input =
new BufferedReader(new InputStreamReader(System.in));
				final String path = input.readLine(); // ��ȡ������ļ�·��
				final int pathInt = Integer.parseInt(String.valueOf(path));
				switch (pathInt) {
				case 1:
					word1 = input();
					word2 = input();
graph.queryBridgeWords(word1, word2);
				// �����ŽӴ�
					break;
				case 2:
					word1 = input();
					word1 = graph.generateNewText(word1);
					break;
				case 3:
					word1 = input();// ���·��1
					graph.calcShortestPath(word1);
					break;
				case 4:
					word1 = input();
					word2 = input();
					graph.calcShortestPath(word1, word2);
				// ���·��2
					break;
				case 5:
					graph.randomWalk(); // �������
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
		final String notLetter = "[^a-zA-Z]"; // ��ֵ�ַ����ϣ�ƥ�����ĸ�ַ�
		String snew=null;
		snew = string.replaceAll(notLetter, " "); // ��s�����з���ĸ�ַ����ɿո�
		snew = snew.trim(); // ȥ����β�ո�
		snew += " "; // ÿ������һ���ո�
snew = snew.replaceAll("\\string{1,}", " ");
// ����\s�����ɼ��ַ����ո��Ʊ������ҳ������\\sƥ��\string��{1,}��ʾ����ƥ��1�Ρ���������Ŀո��滻��һ���ո�
		snew = snew.toLowerCase(); // ����д��ĸȫ������Сд��ĸ
		return snew;
	}

	/***/
	public static String textProcess(final File filepath){
		final StringBuilder result = new StringBuilder();
// StringBuilder�������ڶ��ַ��������ظ��޸ĵĹ����д����������������
		try {
final BufferedReader brdr =
new BufferedReader(new FileReader(filepath));
// FileReader:���ļ�ת��Ϊ�ַ������룬BufferedReader:�ṩͨ�õĻ��巽ʽ�ı���ȡ�����Reader���ṩreadline���ж�ȡ
			String string = null;
			while ((string = brdr.readLine()) != null) // ���ı�û����ʱ
			{
				string = handleString(string);
				if (!"".equals(string.trim())) // ȥ������
				{
					result.append(string); // �ַ�ƴ�ӵ�ĩβ
				}
			}
			result.deleteCharAt(result.length() - 1);// ɾ�����һ���ո�
			brdr.close(); // �ر���
		} catch (Exception e) { // �쳣����
			e.printStackTrace();
		}
		return result.toString(); // ���ش�����ϵ��ַ���
	}

	static void showDirectedGraph(final Graph graph){
		Iterator<Entry<String, Vertex>> iter =
graph.getGhashmap().entrySet().iterator();
// ��v�ı߽��б���
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
