package PE_26_to_50;

public class TreeNode {
    private TreeNode leftChild, rightChild, leftParent, rightParent;
    private int nodeValue;
    private boolean isRoot, isLeaf;

    public TreeNode(TreeNode lChild, TreeNode rChild, TreeNode lParent, TreeNode rParent, int x){
        this.leftChild=lChild;
        this.rightChild=rChild;
        this.leftParent=lParent;
        this.rightParent=rParent;
        this.nodeValue=x;

        this.isRoot = ( ((this.leftParent==null)&&(this.rightParent==null)) ? true : false );
        this.isLeaf = ( ((this.leftChild==null)&&(this.rightChild==null)) ? true : false );
    }

    public int getValue(){
        return nodeValue;
    }
    public void setValue(int x){
        this.nodeValue = x;
    }
    public TreeNode getLeftChild(){
        return leftChild;
    }
    public TreeNode getRightChild(){
        return rightChild;
    }
    public TreeNode getLeftParent(){
        return leftParent;
    }
    public TreeNode getRightParent(){
        return rightParent;
    }
    public boolean isRoot(){
        return this.isRoot;
    }
    public boolean isLeaf(){
        return this.isLeaf;
    }

}

