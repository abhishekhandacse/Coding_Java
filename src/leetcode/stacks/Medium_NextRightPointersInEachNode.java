package leetcode.stacks;

class TreeNodenew {
    public int val;
    public TreeNodenew left;
    public TreeNodenew right;
    public TreeNodenew next;

    public TreeNodenew() {}

    public TreeNodenew(int _val) {
        val = _val;
    }

    public TreeNodenew(int _val, TreeNodenew _left, TreeNodenew _right, TreeNodenew _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
/*
* Lets try the recursive implementation using Tree
* Its given that tree is Perfect Binary Tree so it should be easier to handle some cases
* */
public class Medium_NextRightPointersInEachNode {
    public void Recur(TreeNodenew root){
                if(root==null)return;

                if(root.left!=null && root.right!=null){
                    root.left.next=root.right;
                }

                if(root.right!=null && root.next!=null){
                    root.right.next=root.next.left;
                }

                Recur(root.left);
                Recur(root.right);


    }
    public TreeNodenew connect(TreeNodenew root) {

        if(root==null)return null;
        if(root.left==null && root.right==null)return root;

        Recur(root);

        return root;
    }

}


// This is Iterative Implementation of the problem using queue
/*
public class Medium_NextRightPointersInEachNode {

    public TreeNodenew connect(TreeNodenew root) {

        if(root==null)return null;
        if(root.left==null && root.right==null)return root;

        Queue<TreeNodenew> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNodenew temp=q.poll();
            if(temp!=null){
                temp.next=q.peek();
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);

            }else{
                if(q.isEmpty())
                    break;
                q.add(null);
            }
        }
        return root;

    }

}
*/

