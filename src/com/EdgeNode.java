package com;
/**
 * @author hujingwen
 *
 */
public class EdgeNode {
	/**
	 * EdgeNode ��
	 */
	private Vertex toNode;
	/**
	 * Vertex 
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


    /**���캯��*/
	public EdgeNode(final Vertex realto) {//���캯��
		wight = 0;
		this.toNode= realto;
	}
	/***/
	public void addWight()
	{
		wight++;
	}
}

// This my first modify of First Scene
