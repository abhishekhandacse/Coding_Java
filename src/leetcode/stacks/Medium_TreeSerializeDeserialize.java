package leetcode.stacks;

public class Medium_TreeSerializeDeserialize {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(5);
        root.left.right=new TreeNode(8);
//        root.right=new TreeNode(20);
//        root.right.left=new TreeNode(15);
//        root.right.right=new TreeNode(30);
        Codec c=new Codec();
        String str=c.serialize(root);
        System.out.println(str);
        TreeNode nroot=c.deserialize(str);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.left.right.val);
//        System.out.println(root.right.val);
//        System.out.println(root.right.left.val);
//        System.out.println(root.right.right.val);
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
class Codec {
    void PreOT(TreeNode root,StringBuilder str){
                    if(root==null){
                        str.append("$ ");
                        return;
                    }
                    str.append(Integer.toString(root.val));
                    str.append(" ");
                    PreOT(root.left,str);
                    PreOT(root.right,str);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
                    StringBuilder sb=new StringBuilder();
                    PreOT(root,sb);
                    return sb.toString();
    }
    int ParseString(String str,int[] index){
        int i;
        for(i=index[0];i<str.length();i++){
            if(str.charAt(i)==' '){
                break;
            }
        }
        int ans=Integer.parseInt(str.substring(index[0],i));
        index[0]=i+1;
        //System.out.println(ans);
        return ans;
    }
    TreeNode CT(String str,int[] index){
                    if(index[0]>=str.length() || str.charAt(index[0])=='$'  ){
                        index[0]+=2;
                        return null;
                    }
                    int val=ParseString(str,index);
                    TreeNode root=new TreeNode(val);
                    root.left=CT(str,index);

                    root.right=CT(str,index);

                    return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String str) {
                    if(str==null)return null;
                    if(str.equals("$")){
                        return null;
                    }
                    int[] index=new int[1];
                    index[0]=0;
                    return CT(str,index);
    }
}