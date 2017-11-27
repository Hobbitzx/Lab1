import java.util.HashMap;
import java.util.Map;

public class Vertex {
	HashMap<String,Edge> edgename;
	String text;
	String [] tmap;
	
	int number;
	int know;
	int dist;
	Vertex P;
	
    public HashMap<String, Edge> getEdgename(){
		return edgename;
	}
	/**set method*/
	public void setEdgename(final HashMap<String, Edge> realedgename) {
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
	
	public  String [] getTmap()
	{
		return tmap;
	}
	void Init()
	{
		know=0;
		dist=-1;
		P=null;
	}
	public   void put(String S,Vertex to)
	{
		if(edgename.get(S)==null)
		{
			Edge e= new Edge(to);
			edgename.put(S, e);
			tmap[number]=S;
			number++;
			
		} 
		edgename.get(S).addWight();;
		
	}
	
	
	public  Vertex(String S)
	{
		text =S;
		edgename=new HashMap<String,Edge>(100);
		number=0;
		tmap=new String[50];
	}
	
	/*public static  void ErgodicE()
	{
		Iterator<Entry<String, Edge>> iter =E.entrySet().iterator();
		while(iter.hasNext())
		{
			Entry<String, Edge> entry=iter.next();
			entry.getKey();
			entry.getValue();
		}
	}*/
}
