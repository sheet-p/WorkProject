public class CreateTree {
    static int counter = 0;
    public static void main(String[] args) {
        String str = "-20(22(33)(44))(6(5))";

        if(str==null || str.length()==0) {
            System.out.println("null");
        }
        else {
            Tree root = constructTree(str.toCharArray());
            preOrder(root);
        }
    }

    private static Tree constructTree(char[] s) {
        //base case
        if(counter == s.length)
            return null;

        //extract number
        StringBuilder num = new StringBuilder();
        while(counter<s.length && s[counter]!='(' && s[counter]!=')') {
            num.append(s[counter]);
            counter++;
        }

        Tree root = null;

        if(num.length() != 0) {
            root = new Tree(Integer.parseInt(num.toString()));
        }

        //check paranthesis
        //if its an opening braces, we create left child node
        if(counter<s.length && s[counter] == '(') {
            counter++;
            root.left = constructTree(s);
            counter++;

            //if there is again an opening braces means there is a right child node
            if(counter<s.length && s[counter]=='(') {
                counter++;
                root.right = constructTree(s);
                counter++;
            }
        }

        //if its closing braces, return the node
        return root;
    }

    private static void preOrder(Tree root) {
        if(root == null)
            return ;

        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
}
