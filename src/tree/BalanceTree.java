package tree;

import exception.ImBalance;
import node.Node;

public class BalanceTree extends GenericTree{

    private int maxDiff;
    public BalanceTree(Node node, int maxDiff) {
        super(node);
        this.maxDiff = maxDiff;
    }

    @Override
    public void insert(int parentNodeValue, int childNodeValue) {

			super.insert(parentNodeValue, childNodeValue);

        try {
			checkDiff();
		} catch (ImBalance e) {
			super.delete(childNodeValue);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        //try catch
    }

    @Override
    public void delete(int nodeValue) {

    	if(nodeValue == rootNode.getValue()) {
            this.nodes.clear();
            return;
        }

        Node currentNode = search(nodeValue);
        
        if(currentNode == null) return;
        System.out.println("Found "+currentNode.getValue());
        nodes.remove(currentNode);
        Node parentNode = currentNode.getParentNode();
	    parentNode.removeChild(currentNode);
	    if(parentNode.getChildNode().isEmpty()) parentNode.setLeaf(true);
        try {
			if(checkDiff()) {

			    for(Node childNode : currentNode.getChildNode()) {
			        nodes.remove(childNode);
			    }
			}
			else {
			    nodes.add(currentNode);
			}
		} catch (ImBalance e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // try catch
    }

    public boolean checkDiff() throws ImBalance{
        int	highestLeaf  = -1;
        int lowestLeaf = Integer.MAX_VALUE;
        for(Node currentNode : nodes) {
            if(currentNode.getLeaf()) {
            	lowestLeaf = Math.min(lowestLeaf, currentNode.getDepth());
                highestLeaf = Math.max(highestLeaf, currentNode.getDepth());
            }
        }

        return highestLeaf - lowestLeaf <= maxDiff;
    }

    public int getMaxDiff() {
        return maxDiff;
    }
}
