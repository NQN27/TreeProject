package tree;
import exception.MinusValueNode;
import node.Node;

public class BinaryTree extends GenericTree {
    public BinaryTree(Node node) {
        super(node);
    }

    @Override
    public void insert(int parentNodeValue, int childNodeValue){
        Node childNode;
		try {
	        Node parentNode = search(parentNodeValue);
	        if(parentNode.getChildNode().size() >= 2) return;
			childNode = new Node(childNodeValue);
			childNode.setParentNode(parentNode);
	        nodes.add(childNode);
	        parentNode.addChild(childNode);
		} catch (MinusValueNode e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

        //try catch
    }
}
