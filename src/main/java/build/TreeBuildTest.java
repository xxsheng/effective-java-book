package build;

import java.util.ArrayList;
import java.util.List;

public class TreeBuildTest {

    private static class Tree {
        private Node root;

        public Tree(Node root) {
            this.root = root;
        }

        public Node getRoot() {
            return root;
        }

        public void setRoot(Node root) {
            this.root = root;
        }
    }

    private static class Node {
        private String data;
        private List<Node> childNodes;

        public Node(String data) {
            this.data = data;
            this.childNodes = new ArrayList<>();
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public List<Node> getChildNodes() {
            return childNodes;
        }

        public void setChildNodes(List<Node> childNodes) {
            this.childNodes = childNodes;
        }

        public void addChild(Node node) {
            this.childNodes.add(node);
        }
    }

    private static class NodeBuilder implements Builder<Node> {

        private final String data;
        private List<Builder<? extends Node>> builders;

        public NodeBuilder(String data) {
            this.data = data;
            this.builders = new ArrayList<>();
        }

        public NodeBuilder(String data, List<Builder<? extends Node>> builders) {
            this.data = data;
            this.builders = builders;
        }

        public NodeBuilder addNodeBuilder(Builder<? extends Node> builder) {
            this.builders.add(builder);
            return this;
        }

        @Override
        public Node build() {
            Node root = new Node(data);
            for (Builder<? extends Node> builder : builders) {
                root.addChild(builder.build());
            }
            return root;
        }
    }

    private static class TreeBuilder {
        Tree build(Builder<? extends Node> nodeBuilder) {
            return new Tree(nodeBuilder.build());
        }
    }

    public static void main(String[] args) {
        NodeBuilder nodeBuilder = new NodeBuilder("A").addNodeBuilder(new NodeBuilder("B"))
                .addNodeBuilder(new NodeBuilder("C"))
                .addNodeBuilder(new NodeBuilder("D"));
        Tree tree = new TreeBuilder().build(nodeBuilder);

        printTree(tree.getRoot(), 0);
    }

    private static void printTree(Node node, int level) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < level; i++) {
            stringBuilder.append("  ");
        }
        System.out.println(stringBuilder.toString() + node.getData());

        for (Node childNode : node.childNodes) {
            printTree(childNode, level+1);
        }

    }
}
