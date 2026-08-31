class TreeMap {
    class TreeNode {
        int key;
        int value;
        TreeNode left;
        TreeNode right;
        TreeNode(int k, int v) {
            key = k;
            value = v;
        }
    }

    TreeNode root;
    public TreeMap() {}

    public void insert(int key, int val) {
        TreeNode node = new TreeNode(key, val);
        if (root == null) {
            root = node;
        } else {
            insertHelper(root, node);
        }
    }

    void insertHelper(TreeNode node, TreeNode nodeToInsert) {
        if (node == null)
            return;
        if (node.key < nodeToInsert.key) {
            if (node.right == null) {
                node.right = nodeToInsert;
                return;
            } else {
                insertHelper(node.right, nodeToInsert);
            }
        } else if (node.key > nodeToInsert.key) {
            if (node.left == null) {
                node.left = nodeToInsert;
                return;
            } else {
                insertHelper(node.left, nodeToInsert);
            }
        } else {
            node.value = nodeToInsert.value;
        }
    }

    public int get(int key) {
        if (root == null)
            return -1;

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        while (!dq.isEmpty()) {
            TreeNode node = dq.poll();
            if (node.key == key) {
                return node.value;
            } else if (node.key < key) {
                if (node.right != null) {
                    dq.add(node.right);
                } else {
                    return -1;
                }
            } else {
                if (node.left != null) {
                    dq.add(node.left);
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }

    public int getMin() {
        return root == null ? -1 : getMinHelper(root);
    }

    int getMinHelper(TreeNode node) {
        while(node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    public int getMax() {
        return root == null ? -1 : getMaxHelper(root);
    }

    int getMaxHelper(TreeNode node) {
        while(node.right != null) {
            node = node.right;
        }
        return node.value;
    }

    public void remove(int key) {
        root = remove(root, key);
    }

    TreeNode remove(TreeNode node, int key) {
        if(node == null) return null;
        if(key < node.key) {
            node.left = remove(node.left, key);
        } else if(node.key < key) {
            node.right = remove(node.right, key);
        } else {
            if(node.left == null) return node.right;
            if(node.right == null) return node.left;

            TreeNode successor = node.right;
            while(successor.left != null) {
                successor = successor.left;
            }
            node.key = successor.key;
            node.value = successor.value;

            node.right = remove(node.right, successor.key);
        }

        return node;

    }

    public List<Integer> getInorderKeys() {
        List<Integer> res = new ArrayList<>();
        TreeNode node = root;
        inorder(node, res);
        return res;
    }

    void inorder(TreeNode node, List<Integer> list) {
        if(node == null) return;

        if(node.left != null) {
            inorder(node.left, list);
        }

        list.add(node.key);
        if(node.right != null) {
            inorder(node.right, list);
        }
    }
}
