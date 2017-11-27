
public class Edge {
	private Vertex toNode;
	/**
	 * vertex
	 */
	private int wight;
    /**get method*/
	public Vertex getToNode(){//get
		return toNode;
	}

	/**set method*/
	public void setToNode(final Vertex realto) {//set
		this.toNode = realto;
	}


    /**get method*/
	public int getWight() {//get
		return wight;
	}


	/**set method*/
	public void setWight(final int realwight) {//set
		this.wight = realwight;
	}


    /**构造函数*/
	public Edge(final Vertex realto) {//构造函数
		wight = 0;
		this.toNode= realto;
	}
	/***/
	public void addWight()
	{
		wight++;
	}
}
