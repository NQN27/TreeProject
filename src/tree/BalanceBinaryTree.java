package tree;

import node.Node;

public class BalanceBinaryTree extends BalanceTree{

	public BalanceBinaryTree(Node node, int maxDiff) {
		super(node, maxDiff);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void insert(int parentNodeValue, int childNodeValue) {
		Node parentNode;
			parentNode = search(parentNodeValue);
	        if(parentNode.getChildNode().size() >= 2) return;
			super.insert(parentNodeValue, childNodeValue);

		
	}

}
