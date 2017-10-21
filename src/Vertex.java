package com;
import java.util.HashMap;
import java.util.Map;
/**
 * @author hujingwen
 *
 */

public class Vertex {
	/**
	 * 边类
	 */
	private Map<String, EdgeNode> edgename;
	/**
	 * 映射
	 */
	private String text;
	/**
	 * 字符串
	 */
	private String[] tmap;
	/**
	 * tmap
	 */
	private int number;
	/**
	 * number
	 */
	private int know;
	/**
	 * know
	 */
	private int dist;
	/**
	 * dist
	 */
	private Vertex pnode;
	/**
	 * pnode
	 */
	private EdgeNode tempnode;
	/**
	 * tempnode
	 */
	/**get method*/
    public EdgeNode getTempnode() {
		return tempnode;
	}
    /**set method*/
	public void setTempnode(final EdgeNode realtempnode) {
		this.tempnode = realtempnode;
	}
	/**get method*/
    public Map<String, EdgeNode> getEdgename(){
		return edgename;
	}
	/**set method*/
	public void setEdgename(final Map<String, EdgeNode> realedgename) {
		this.edgename = realedgename;
	}
	/**get method*/
	public String getText() {
		return text;
	}
	/**set method*/
	public void setText(final String realtext) {
		this.text = realtext;
	}
	/**get method*/
	public String[] getTmap() {
		return tmap.clone();
	}
	/**set method*/
	public void setTmap(final String... realtmap) {
		this.tmap = realtmap.clone();
	}
	/**get method*/
	public int getNumber() {
		return number;
	}
	/**set method*/
	public void setNumber(final int realnumber) {
		this.number = realnumber;
	}
	/**get method*/
	public int getKnow() {
		return know;
	}
	/**set method*/
	public void setKnow(final int realknow) {
		this.know =realknow;
	}
	/**get method*/
	public int getDist() {
		return dist;
	}
	/**set method*/
	public void setDist(final int realdist) {
		this.dist = realdist;
	}
	/**get method*/
	public Vertex getPnode() {
		return pnode;
	}
	/**set method*/
	public void setPnode(final Vertex realp) {
		this.pnode = realp;
	}
//    /**初始化*/
//	public void init(){
//		know = 0;
//		dist = -1;
//		pnode = null;
//	}
    /**put函数*/
	public void put(final String stemp, final Vertex totemp) {
		if (edgename.get(stemp) == null) {
			final EdgeNode etemp = new EdgeNode(totemp);
			edgename.put(stemp, etemp);
			tmap[number] = stemp;
			number++;

		}
		tempnode=edgename.get(stemp);
		tempnode.addWight();

	}
    /**构造函数*/
	public Vertex(final String stemp) {
		text = stemp;
		edgename =new HashMap<String, EdgeNode>(100);
		number = 0;
		tmap = new String[50];
	}

	/*
	 * public static void ErgodicE() { Iterator<Entry<String, EdgeNode>> iter
	 * =e.entrySet().iterator(); while(iter.hasNext()) { Entry<String, EdgeNode>
	 * entry=iter.next(); entry.getKey(); entry.getValue(); } }
	 */
}
