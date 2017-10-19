package com;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.Random;
import java.util.Set;

/**Graph*/
public class Graph {
	/**
	 * 
	 */
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
	/**
	 * 
	 */
	private int tempint;
	/**
	 *
	 */
	private int countint;
	/**
	 * ghashmap
	 */
	private Map<String, Vertex> ghashmap;
	/**
	 * tstring
	 */
	private String[] tstring;
	/**
	 * number
	 */
	private int number;
	/**vertex*/
	private Vertex tempnode;
	/**tempedge*/
	private EdgeNode tempedge;
	/**tempset键值对*/
	private Set<Map.Entry<String, Vertex>> tempset;
	/**tempentry*/
	private Entry<String, Vertex> tempentry;
	/**tempmap*/
	private Map<String, Vertex> tempmap;
	/**tempiter*/
	private Iterator<Entry<String, Vertex>> tempiter;
	/**tempset2*/
	private Set<Map.Entry<String, EdgeNode>> tempset2;
	/**tempentry2*/
	private Entry<String, EdgeNode> tempentry2;
	/**tempmap2*/
	private Map<String, EdgeNode> tempmap2;
	/**tempiter2*/
	private Iterator<Entry<String, EdgeNode>> tempiter2;
	/**temps*/
	private String temps;
	/**temps2*/
	private String temps2;
	/**tempsa*/
	private String[] tempsa;
	/**templist*/
private List<String> templist;

	/**
	 * @return the tempint
	 */
	public final int getTempint() {
		return tempint;
	}
	/**
	 * @param tempint the tempint to set
	 */
	public final void setTempint(final int realtempint) {
		this.tempint = realtempint;
	}
	/**
	 * @return the countint
	 */
	public final int getCountint() {
		return countint;
	}
	/**
	 * @param countint the countint to set
	 */
	public final void setCountint(final int realcountint) {
		this.countint = realcountint;
	}
	/**
	 * @return the temps2
	 */
	public String getTemps2() {
		return temps2;
	}
	/**
	 * @param temps2 the temps2 to set
	 */
	public void setTemps2(final String realtemps2) {
		this.temps2 = realtemps2;
	}
	/**
	 * @return the templist
	 */
	public List<String> getTemplist() {
		return templist;
	}
	/**
	 * @param templist the templist to set
	 */
	public void setTemplist(final List<String> realtemplist) {
		this.templist = realtemplist;
	}
	/**
	 * @return the tempsa
	 */
	public String[] getTempsa() {
		return tempsa.clone();
	}
	/**
	 * @param tempsa the tempsa to set
	 */
	public void setTempsa(final String... realtempsa) {
		this.tempsa = realtempsa;
	}
	/**
	 * @return the temps
	 */
	public String getTemps() {
		return temps;
	}
	/**
	 * @param temps the temps to set
	 */
	public void setTemps(final String realtemps) {
		this.temps = realtemps;
	}
	/**
	 * @return the tempiter
	 */
	public Iterator<Entry<String, Vertex>> getTempiter() {
		return tempiter;
	}
	/**
	 * @param tempiter the tempiter to set
	 */
public void setTempiter(final Iterator<Entry<String, Vertex>> realtempiter){
		this.tempiter = realtempiter;
	}
	/**
	 * @return the tempiter2
	 */
	public Iterator<Entry<String, EdgeNode>> getTempiter2() {
		return tempiter2;
	}
	/**
	 * @param tempiter2 the tempiter2 to set
	 */
public void setTempiter2(final Iterator<Entry<String, EdgeNode>> realtempiter2){
		this.tempiter2 = realtempiter2;
	}
	/**
	 * @return the tempentry2
	 */
	public Entry<String, EdgeNode> getTempentry2() {
		return tempentry2;
	}
	/**
	 * @param tempentry2 the tempentry2 to set
	 */
public void setTempentry2(final Entry<String, EdgeNode> realtempentry2){
		this.tempentry2 = realtempentry2;
	}
	/**
	 * @return the tempmap2
	 */
	public Map<String, EdgeNode> getTempmap2() {
		return tempmap2;
	}
	/**
	 * @param tempmap2 the tempmap2 to set
	 */
	public void setTempmap2(final Map<String, EdgeNode> realtempmap2) {
		this.tempmap2 = realtempmap2;
	}
	/**
	 * @return the tempset2
	 */
	public Set<Map.Entry<String, EdgeNode>> getTempset2() {
		return tempset2;
	}
	/**
	 * @param tempset2 the tempset2 to set
	 */
public void setTempset2(final Set<Map.Entry<String, EdgeNode>> realtempset2){
		this.tempset2 = realtempset2;
	}
	/***/
	public Map<String, Vertex> getTempmap() {
		return tempmap;
	}
	/***/
	public void setTempmap(final Map<String, Vertex> realtempmap) {
		this.tempmap = realtempmap;
	}
	/***/
	public Entry<String, Vertex> getTempentry() {
		return tempentry;
	}
	/***/
	public void setTempentry(final Entry<String, Vertex> realtempentry) {
		this.tempentry = realtempentry;
	}
	/***/
	public Set<Map.Entry<String, Vertex>> getTempset() {
		return tempset;
	}
	/***/
public void setTempset(final Set<Map.Entry<String, Vertex>> realtempset){
		this.tempset = realtempset;
	}

	/**
	 * @return the tempedge
	 */
	public EdgeNode getTempedge() {
		return tempedge;
	}
	/**
	 * @param tempedge the tempedge to set
	 */
	public void setTempedge(final EdgeNode realtempedge) {
		this.tempedge = realtempedge;
	}
	/***/
	public Vertex getTempnode() {
		return tempnode;
	}

	/***/
	public void setTempnode(final Vertex realtempnode) {
		this.tempnode = realtempnode;
	}

	/** get method */
	public Map<String, Vertex> getGhashmap() {
		return ghashmap;
	}

	/** set method */
	public void setGhashmap(final Map<String, Vertex> realghashmap) {
		this.ghashmap = realghashmap;
	}

	/** get method */
	public String[] getTstring() {
		return tstring.clone();
	}

	/** set method */
	public void setTstring(final String... realtstring) {
		this.tstring = realtstring;
	}

	/** get method */
	public int getNumber() {
		return number;
	}

	/** set method */
	public void setNumber(final int realnumber) {
		this.number = realnumber;
	}

	/***/
	public void put(final String s1temp, final String s2temp) {
		Vertex v2temp;
		if (ghashmap.get(s2temp) == null) {
			v2temp = new Vertex(s2temp);// 创建V2
			tstring[number] = s2temp;
			number++;
			ghashmap.put(s2temp, v2temp);
		} else {
			v2temp = ghashmap.get(s2temp);// S2与V2建立映射存入hashMap
		}
		tempnode = ghashmap.get(s1temp);
		tempnode.put(s2temp, v2temp);// 在S1对应顶点中存入对应边
	}

	/***/
	public Graph() {
		ghashmap = new HashMap<String, Vertex>();
		// Bridge=new HashMap<String[],ArrayList<String>>(50);
		tstring = new String[1500];
		number = 0;
	}

	/***/
	private void init() {
		tempset=ghashmap.entrySet();
final Iterator<Entry<String, Vertex>> iter = tempset.iterator();
// 对v的边进行遍历
		while (iter.hasNext()) {
			tempentry = iter.next();
			tempnode = tempentry.getValue();
			tempnode.setKnow(0);
			tempnode.setDist(-1);
			tempnode.setPnode(null);
		}
	}

	/***/
	public List<String> bridgeWords(final String word1, final String word2) {
		final ArrayList<String> stringArray = new ArrayList<String>();
		tempnode = ghashmap.get(word1);
if (ghashmap.get(word1) != null && ghashmap.get(word2) != null ){
			tempmap2 = tempnode.getEdgename();
			tempset2 = tempmap2.entrySet();
final Iterator<Entry<String, EdgeNode>> iter = tempset2.iterator();
// 对v的边进行遍历
			while (iter.hasNext()) {
				tempentry2 = iter.next();
				tempedge = tempentry2.getValue();
				tempnode = tempedge.getToNode();// newV是于V相连的顶点
				tempmap2 = tempnode.getEdgename();
				if (tempmap2.get(word2) != null) {
					stringArray.add(tempnode.getText());
				}
			}
		}
		return stringArray;
	}

	/***/
	public void dijkstra(final Vertex vtemp) {
		vtemp.setDist(0);
		for (;;) {
			Vertex small = findsmall();
			if (small == null) {
				break;
			}
			small.setKnow(1);
			tempmap2 = small.getEdgename();
			tempset2 = tempmap2.entrySet();
			tempiter2 = tempset2.iterator();
			while (tempiter2.hasNext()) {
				tempentry2 = tempiter2.next();
				tempedge = tempentry2.getValue();
				tempnode = tempedge.getToNode();
				if (tempnode.getKnow() == 0
&& (small.getDist() + tempedge.getWight() < tempnode.getDist()
					|| tempnode.getDist() == -1)) {
tempnode.setDist(small.getDist() + tempedge.getWight());
					tempnode.setPnode(small);
				}
			}
		}
	}

	private Vertex findsmall() {
		tempset = ghashmap.entrySet();
		tempiter = tempset.iterator();// 对v的边进行遍历
		Vertex small = null;
		int intdist = -1;
		while (tempiter.hasNext()) {
			tempentry = tempiter.next();
			tempnode = tempentry.getValue();
			if (tempnode.getDist() != -1 && (intdist == -1 || tempnode.getDist() < intdist)
					&& tempnode.getKnow() == 0) {
				small = tempnode;
				intdist = tempnode.getDist();
			}
		}
		return small;
	}

	/***/
	public void randomWalk() throws IOException {
		final Random ran = new Random();
		final StringBuilder builder = new StringBuilder();
		String[] string = new String[2];
		final HashMap<EdgeNode, Integer> hashMap = new HashMap<EdgeNode, Integer>();// 一个边到整数的hashmap
		if (number == 0) {
			return;
		} // 图中点的数量为0直接返回（似乎可以加一句话）
		int rndint = ran.nextInt(100) % number;// r为0到顶点数-1之间的一个数
		temps = tstring[rndint];
		tempnode = ghashmap.get(temps);
		builder.append(tempnode.getText());
		if (tempnode.getNumber() == 0) // 所选点中边的数量为0
		{
			logger.info(tempnode.getText());
			builder.append(tempnode.getText());
		}
		else
		{
			rndint = ran.nextInt(100) % tempnode.getNumber();// 0到边数-1中选择一个数
			tempmap2 = tempnode.getEdgename();
			tempsa = tempnode.getTmap();
			temps = tempsa[rndint];
			tempedge = tempmap2.get(temps);// E为所选边
			while (hashMap.get(tempedge) == null & tempnode.getNumber() != 0 & number != 0)
			// 循环条件为 E没被选到 且所选点的边数都不为0
			{
				string[0] = tempnode.getText();// E中起点的字符串
				tempnode = tempedge.getToNode();
				string[1] = tempnode.getText();// E终点的字符串
				builder.append(" " + string[1]);
				hashMap.put(tempedge, 1);
				tempnode = tempedge.getToNode();
				if (tempnode.getNumber() == 0) {
					temps = builder.toString();
					temps = temps.trim();// 去掉首尾空格
					logger.info(temps);
					final FileWriter fwr = new FileWriter("E:\\text1.txt", true);
					fwr.write(temps + "\rndint\n");
					fwr.flush();
					fwr.close();
					return;
				}
				rndint = ran.nextInt(100) % tempnode.getNumber();
				temps = tempsa[rndint];
				tempedge = tempmap2.get(temps);
			}
			tempnode = tempedge.getToNode();
			temps = " "+builder.toString();
			temps = temps.trim();// 去掉首尾空格
			logger.info(temps);
			final FileWriter fwr = new FileWriter("E:\\text1.txt", true);
			fwr.write(builder + "\r\n");
			fwr.flush();
			fwr.close();
		}
	}

	/***/
	public void calcShortestPath(final String word1, final String word2) {
		init();
		dijkstra(ghashmap.get(word1));
		tempnode = ghashmap.get(word2);
		if (tempnode.getDist() == -1) {
			logger.info("不可达");
			return;
		}
		print(ghashmap.get(word2));
		logger.info("");
	}

	/***/
	public void print(final Vertex vertex) {
		if (vertex.getPnode() != null) {
			print(vertex.getPnode());
			logger.info("->");
		}
		logger.info(vertex.getText());
	}

	/***/
	public void calcShortestPath(final String word) {
		init();
		dijkstra(ghashmap.get(word));
		tempset = ghashmap.entrySet();
		tempiter = tempset.iterator();// 对v的边进行遍历
		while (tempiter.hasNext()) {
			tempentry = tempiter.next();
			tempnode = tempentry.getValue();
			temps = tempentry.getKey();
			if (tempnode.getDist() == -1) {
				continue;
			} else if (temps.equals(word)) {
				continue;
			}
			print(tempnode);
			logger.info("");
		}

	}

	/***/
	public void queryBridgeWords(final String word1, final String word2) {
		if (ghashmap.get(word1) != null && ghashmap.get(word2) != null) {
			templist = bridgeWords(word1, word2);
			if (templist.isEmpty()) {
				logger.info("No bridge words from \"" + word1 + "\" to \"" + word2 + "\"");
			} else if (templist.size() == 1) {
				if (logger.isLoggable(Level.INFO)) {
					logger.info("The bridge word from \"" + word1 + "\" to \"" + word2 + "\" is: ");
				}
				logger.info(templist.get(0));
			} else {
				// 对v的边进行遍历
				logger.info("The bridge words from \"" + word1 + "\" to \"" + word2 + "\" are: ");
				for (int i = 0; i < templist.size(); i++) {
					logger.info(templist.get(i));
					if (i == templist.size() - 2) {
						logger.info(",");
					} else if (i != templist.size() - 1) {
						logger.info(",");
					}
				}
				logger.info(".");
			}

		} else if (ghashmap.get(word1) == null && ghashmap.get(word2) == null) {
			logger.info("No \"" + word1 + "\" and \"" + word2 + "\" in the graph");
			
		} else if (ghashmap.get(word1) == null) {
			logger.info("No \"" + word1 + "\" in the graph");
			
		} else if (ghashmap.get(word2) == null) {
			logger.info("No \"" + word2 + "\" in the graph");
			
		} 
	}

	/***/
	public String generateNewText(final String inputText) {
		tempint=1;
		final Random ran = new Random();
		temps = handleString(inputText);
		tempsa = temps.split(" ");
		final StringBuilder sbuild = new StringBuilder(temps);
		countint = 0;
		// logger.info(tempsa.length);
		if (tempsa.length > tempint) {
			for (int i = 0; i < tempsa.length - 1; i++)// 对v的边进行遍历
			{
				// queryBridgeWords(tempsa[i],tempsa[i+1]);
				// logger.info(tempsa[i+1]);
				temps = tempsa[i];
				temps2 = tempsa[i + 1];
				templist = bridgeWords(temps, temps2);
				countint += temps.length() + 1;
				if (templist.isEmpty()) {
					continue;
				} else {
					final int mmm = templist.size();
					// logger.info(mmm);
					temps = templist.get(ran.nextInt(mmm)) + " ";
					// logger.info(Insert);
					sbuild.insert(countint, temps);
					countint += temps.length();
				}
			}
		}
		logger.info(sbuild.toString());
		return sbuild.toString();

	}

	/***/
	public String handleString(final String string) {
		// 负值字符集合，匹配非字母字符
		temps = string.replaceAll("[^a-zA-Z]", " "); // 将s中所有非字母字符换成空格
		temps = temps.trim(); // 去掉首尾空格
		temps = temps + " "; // 每行最后加一个空格
		temps = temps.replaceAll("\\string{1,}", " ");
		// 其中\s代表不可见字符（空格，制表符，换页符），\\s匹配\string，{1,}表示至少匹配1次。代表将多余的空格替换成一个空格

		return temps;
	}

}
