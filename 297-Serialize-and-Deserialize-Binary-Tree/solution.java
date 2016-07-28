/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private final String end = "#";
    private final String dilimiter = "!";

    // we can use queue to contruct a bfs of the tree
    // 1. add root into queue
    // 2. while queue not empty, pick one from queue and append it's value to string builder or append n if it's null
    // 3. if node is not null, add it's left and right  children into queue

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Deque<Object> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append(end);
            sb.append(dilimiter);
            return sb.toString();
        }
        queue.addLast(root);
        
        while(!queue.isEmpty()){
            if(queue.getFirst() instanceof TreeNode){
                TreeNode cur = (TreeNode)queue.removeFirst();
                if(cur.left!=null)
                    queue.addLast(cur.left);
                if(cur.right!=null)
                    queue.addLast(cur.right);
                sb.append(cur.val);
                
            } else {
                sb.append(end);
            }
            sb.append(dilimiter);
        }
        
        return sb.toString();
    }

    // Same as serialize, we use a queue to deserialize
    // 1. convert the string into string array
    // 2. get one from array to build root note, add root into queue
    // 3. while queue is not empty, pick two strings from array and build nodes l and r
    // remove node n from queue and set n.left = l, n.rght = r. Add l and r into queue.


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // System.out.println(data);
        String[] arr = data.split(dilimiter);
        if(arr[0].equals(end)){
            return null;
        }
            
            
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        int index = 1;
        while(!queue.isEmpty()){
            TreeNode cur = queue.removeFirst();
            String left = arr[index];
            String right = arr[index+1];
            index+=2;
            if(!left.equals(end)){
                TreeNode l = new TreeNode(Integer.parseInt(left));
                cur.left = l;
                queue.addLast(l);
            } else {
                cur.left = null;
            }
             
            if(!right.equals(end)){
                TreeNode r = new TreeNode(Integer.parseInt(right));
                cur.right = r;
                queue.addLast(r);
            } else {
                cur.right = null;
            }
            
            
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));