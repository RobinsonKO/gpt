package com.gpengtao;

/**
 * Created by gpengtao on 16/11/18.
 */
public class Node {

    private Object data;

    private Node parent;

    private Node left;

    private Node right;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void trasfter(Node node) {

    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void trans(Node node) {
        Node root = node;
        while (node.getParent() != null) {
            root = node.getParent();
        }

        doTrans(root);
    }

    private void doTrans(Node node) {
        if (node == null) {
            return;
        }

        // print
        System.out.println(node);

        Node left = node.getLeft();
        Node right = node.getRight();

        // left
        if (left != null) {
            doTrans(left);
        }

        // right
        if (right != null) {
            doTrans(right);
        }
    }
}
