package node;
import java.util.LinkedList;

import exception.MinusValueNode;

public class Node {
    private int value;
    private Node parentNode;
    private LinkedList<Node> childNodes = new LinkedList<Node>();
    private boolean isLeaf;
    private int depth;
    private int height;

    public Node(int value) throws MinusValueNode {
        this.value = value;
        this.parentNode = null;
        this.isLeaf = true;
        this.depth = 1;
        this.height = 0;
        if (this.value <=0){
        	throw new MinusValueNode();
        }
    }

    public void addChild(Node child) {
        childNodes.add(child);
        this.isLeaf = false;
        child.setDepth(this.getDepth() + 1);
    }

    public void removeChild(Node child) {
        childNodes.remove(child);
    }

    // SETTER GETTER

    public void setValue(int newValue) {
        this.value = newValue;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Node getParentNode() {
        return parentNode;
    }
    public void setParentNode(Node parent){
        this.parentNode = parent;
    }
    public LinkedList<Node> getChildNode() {
        return this.childNodes;
    }

    public boolean getLeaf() {
        return isLeaf;
    }
    public void setLeaf(boolean isLeaf) {
    	this.isLeaf=isLeaf;
    }

    public int getDepth() {
        return this.depth;
    }

    // DISPLAY

    public void displayChild() {
        System.out.print(value + " -> ");
        for(Node currentNode: childNodes) {
            System.out.print(currentNode.getValue() + ", ");
        }
        System.out.println("");
    }
}
