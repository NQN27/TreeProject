package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.JOptionPane;

import exception.MinusValueNode;
import node.Node;

public class GenericTree {

    protected Node rootNode;
    protected ArrayList<Node> nodes = new ArrayList<Node>();

    public GenericTree(Node node) {
        this.rootNode = node;
        nodes.add(node);
    }
    public void insert(int parentNodeValue, int childNodeValue) {
        Node parentNode = search(parentNodeValue);
        if (parentNode!= null && search(childNodeValue)==null) {
        Node childNode;
			try {
				childNode = new Node(childNodeValue);
		        childNode.setParentNode(parentNode);
		        nodes.add(childNode);
		        parentNode.addChild(childNode);
			} catch (MinusValueNode e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


        }
        return;
        //try catch
    }

    public void delete(int nodeValue) {

        if(nodeValue == rootNode.getValue()) {
            this.nodes.clear();
            return;
        }

        Node currentNode;
			currentNode = search(nodeValue);
	        if(currentNode == null) return;
	        else
	        {
	            for(Node childNode : currentNode.getChildNode()) {
	                nodes.remove(childNode);
	            }
	            Node parentNode = currentNode.getParentNode();
	            parentNode.removeChild(currentNode);
	            this.nodes.remove(currentNode);
	            System.out.print("remove successful");
	        }



        // try catch
    }

    public void update(int currentNodeValue, int newNodeValue) {
        Node currentNode;
			currentNode = search(currentNodeValue);
			if (currentNode != null) {
		        currentNode.setValue(newNodeValue);}


        //try catch
    }

    public LinkedList<Node> traverseBFS() {
        Queue<Node> queue = new LinkedList<Node>();
        LinkedList<Node> keeptrack = new LinkedList<Node>();
        queue.add(rootNode);
        keeptrack.add(rootNode);
        while(!queue.isEmpty()) {
            Node currentNode = queue.remove();
            keeptrack.add(currentNode);
            System.out.println(currentNode.getValue());
            for(Node childNode: currentNode.getChildNode()) {
                queue.add(childNode);
            }
        }
        return keeptrack;
    }

    public LinkedList<Node> traverseDFS() {
        Stack<Node> queue = new Stack<Node>();
        LinkedList<Node> keeptrack = new LinkedList<Node>();
        queue.push(rootNode);
        keeptrack.add(rootNode);
        while(!queue.isEmpty()) {
            Node currentNode = queue.pop();
            keeptrack.add(currentNode);
            for(Node childNode: currentNode.getChildNode()) {
                queue.push(childNode);
            }
        }
        return keeptrack;
    }

    public Node search(int nodeValue) {
        LinkedList<Node> searchedNodes = new LinkedList<Node>();
        if(this.rootNode.getValue() == nodeValue) {
            return this.rootNode;
    }
        else {
            searchedNodes.addFirst(rootNode);;
            while(!searchedNodes.isEmpty()) {
                Node node_check =searchedNodes.pop();
                if (node_check.getValue() == nodeValue){
                    return node_check;
                } 
                if (!node_check.getChildNode().isEmpty()){
                for (Node child : node_check.getChildNode()){
                    searchedNodes.addLast(child);
                }
            }
            }
            return null;
        }
    }
    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public Node getRootNode() {
        return rootNode;
    }
}