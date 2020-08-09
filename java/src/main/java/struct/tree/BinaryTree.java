package struct.tree;

public class BinaryTree<Key extends Comparable<Key>, Value> {

    private Node root;
    private int N;

    public BinaryTree() {
    }

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }


    //树的大小
    public int size() {
        return N;
    }

    //向树中添加元素
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    //向指定的树中添加元素
    public Node put(Node x, Key key, Value value) {
        if (x == null) {
            ++N;
            return new Node(key, value, null, null);
        }
        int cmp = key.compareTo(x.key);

        if (cmp > 0) {
            //继续找右子树
            x.right = put(x.right, key, value);
        } else if (cmp < 0) {
            //继续找左子树
            x.left = put(x.left, key, value);
        } else {
            //直接替换值
            x.value = value;
        }
        return x;
    }

    //获取树中的节点
    public Value get(Key key) {
        return get(root, key);
    }

    //从指定的树中获取节点
    public Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);

        if (cmp > 0) {
            //继续找右子树
            return get(x.right, key);
        } else if (cmp < 0) {
            //继续找左子树
            return get(x.left, key);
        } else {
            //直接返回值
            return x.value;
        }
    }

    //从树中删除节点
    public void delete(Key key) {
        delete(root, key);
    }

    //从指定的树x删除节点
    public Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);

        if (cmp > 0) {
            //继续找右子树
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            //继续找左子树
            x.left = delete(x.left, key);
        } else {
            //如果key等于x的键，完成删除动作，删除节点x
            //找到一个节点来替换当前节点,右子树中的最小节点
            --N;
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            Node midNode = x.right;

            while (midNode.left != null) {
                midNode = midNode.left;
            }

            //删除右子树中最小的节点

            Node n = x.right;
            while (n.left != null) {
                if (n.left.left == null) {
                    n.left = null;
                    break;
                }
                n = n.left;
            }
            //让x的左子树成为midNode的左子树
            midNode.left = x.left;
            //让x的右子树成为midNode的右子树
            midNode.right = x.right;
            //让x的父节点指向midNode
            x = midNode;
        }
        return x;
    }


}
