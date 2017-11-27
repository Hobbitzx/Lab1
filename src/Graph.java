
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;



//This is my second modify of Second Scene
//This is my second modify of Second Scene
//This is my second modify of Second Scene

//This is my first modify of Second Scene
//This is my first modify of Second Scene ,too




public class Graph {
	HashMap<String,Vertex> ghashmap;
	String [] tstring;
	int number;
	
	public HashMap<String, Vertex> getGhashmap() {
		return ghashmap;
	}
	public void setGhashmap(final HashMap<String, Vertex> realghashmap) {
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

	public void put(String S1,String S2)
	{
		Vertex v2;
		if(ghashmap.get(S2)==null) 
		{
			v2=new Vertex(S2);//创建V2
			tstring[number]=S2;
			number++;
			ghashmap.put(S2, v2);
		}
		else 
		{
			v2=ghashmap.get(S2);//S2与V2建立映射存入hashMap
		}
		ghashmap.get(S1).put(S2, v2);//在S1对应顶点中存入对应边
	}
	public Graph()
	{
		ghashmap= new HashMap<String,Vertex>();
		//Bridge=new HashMap<String[],ArrayList<String>>(50);
		tstring=new String[1500];
		number=0;
	}
	
	void InitGraph(String result)
	{
		String[] s = result.split(" ");
		
		
		Vertex V=new Vertex(s[0]);
		ghashmap.put(s[0], V);
		for(int i=0;i<s.length-1;i++)
		{
			put(s[i], s[i+1]);     //存入所有边
		}
	}
	void init()
	{
		Iterator<Entry<String, Vertex>> iter =ghashmap.entrySet().iterator();//对v的边进行遍历
		while(iter.hasNext())
		{
			Entry<String,Vertex> entry=iter.next();
			entry.getValue().Init();
		}
	}

	
	
	
	void Dijkstra(Vertex V)
	{
		V.setDist(0);
		Vertex Small;
		for(;;)
		{
			Small=Findsmall();
			if(Small==null) break;
			Small.setKnow(1);
			Iterator<Entry<String,Edge>> Iter= Small.getEdgename().entrySet().iterator();
			while(Iter.hasNext())
			{
				Entry<String, Edge> entry=Iter.next();
				if(entry.getValue().getToNode().getKnow()==0)
				{
					if(Small.getDist()+entry.getValue().getWight()<entry.getValue().getToNode().getDist()   |  entry.getValue().getToNode().getDist()==-1)
					{
						entry.getValue().getToNode().setDist(Small.getDist()+entry.getValue().getWight());
						entry.getValue().getToNode().P=Small;
					}
				}
			}	
		}
	}
	
	private Vertex Findsmall()
	{
		Iterator<Entry<String, Vertex>> iter =ghashmap.entrySet().iterator();//对v的边进行遍历
		Vertex Small=null;
		int dist =-1;
		while(iter.hasNext())
		{
			Entry<String, Vertex> entry=iter.next();
			if(entry.getValue().getDist()!=-1 & (dist==-1 | entry.getValue().getDist()<dist) & entry.getValue().getKnow()==0)
			{
				Small=entry.getValue();
				dist=entry.getValue().getDist();
			}
		}
		return Small;
	}
	


			
		
	




		
	



}

