package com.Try;

public class BST {
     private BT_Node root;

     public BST(){
     }

     public BST(int data){
         this.root = new BT_Node(data);
     }

     public BT_Node getRoot(){
         return this.root;
     }

     public void setRoot(BT_Node Node){
         this.root = Node;
     }

     public boolean empty(){
         return this.getRoot() == null;
     }

     public int Find_Node(int data){
         BT_Node current = root;
         while(current != null) {
             if(current.getData()==data)return data;
             if (data > current.getData())current=current.getRightChild();
             else if (data < current.getData())current=current.getLeftChild();
         }
         return -1;
     }

     public BT_Node Find_Node(int data,BT_Node root){
         if(root == null || data==root.getData())return root;
         BT_Node Left = null,Right = null;
         if(data>root.getData())Right = Find_Node(data,root.getRightChild());
         else if(data<root.getData())Left = Find_Node(data,root.getLeftChild());
         return (Left == null)? Right : Left;
     }

     public BT_Node Find_Parent(int data,BT_Node current){
         if(current == null || (current.getLeftChild()!= null && current.getLeftChild().getData() == data))return current;
         if(current == null || (current.getRightChild() != null &&current.getRightChild().getData() == data))return current;
         BT_Node Left = null,Right = null;
         if(current != null && current.getData() > data)Left = Find_Parent(data,current.getLeftChild());
         else if(current != null && current.getData() < data)Right = Find_Parent(data,current.getRightChild());
         return (Left == null)?Right:Left;
     }

     public void Insert_Node(int data){
         if(this.root == null){
             root = new BT_Node(data);
             return;
         }
         BT_Node current = root;
         while( current != null ){
             if(current.getData()<data){
                 if(current.getRightChild()==null) {
                     current.setRightChild(new BT_Node(data));
                     return;
                 }
                 current=current.getRightChild();
             }
             else if(current.getData()>data){
                 if(current.getLeftChild()==null){
                     current.setLeftChild(new BT_Node(data));
                     return;
                 }
                 current=current.getLeftChild();
             }
         }
     }

     public void Insert_Node(BT_Node Node,BT_Node current){
         if(current.getData()>Node.getData()){
             if(current.getLeftChild() == null){
                 current.setLeftChild(Node);
                 return;
             }
             Insert_Node(Node,current.getLeftChild());
         }
         else if(current.getData()<Node.getData()){
             if(current.getRightChild() == null){
                 current.setRightChild(Node);
                 return;
             }
             Insert_Node(Node,current.getRightChild());
         }
     }

     public void display_Inorder(BT_Node Node){//displays the left child then the node then the right one and the nodes displayed sorted
         if(Node == null)return;
         display_Inorder(Node.getLeftChild());
         System.out.println(Node.getData());
         display_Inorder(Node.getRightChild());
     }

     public void display_Preorder(BT_Node Node){//displays the node then the left child then the right one and it feels as dfs(depth first search) algorithm
         if(Node == null)return;
         System.out.println(Node.getData());
         display_Preorder(Node.getLeftChild());
         display_Preorder(Node.getRightChild());
     }

     public void display_Postorder(BT_Node Node){//displays the left child then the right one then the node you may say the children the the parents
         if(Node == null)return;
         display_Postorder(Node.getLeftChild());
         display_Postorder(Node.getRightChild());
         System.out.println(Node.getData());
     }

     public int Max(BT_Node Node){
         if(Node.getRightChild() == null)return Node.getData();
         return Max(Node.getRightChild());
     }

     public int Mini(BT_Node Node){
         if(Node.getLeftChild() == null)return Node.getData();
         return Mini(Node.getLeftChild());
     }

     public BT_Node getSuccessor(BT_Node Node){
          Node = Node.getRightChild();
          if(Node == null)return null;
          while(Node.getLeftChild() != null)Node = Node.getLeftChild();
          this.Delete(Node.getData());
          return Node;
     }

     public void Delete(int data){

         BT_Node Node = this.Find_Node(data,this.getRoot());

         // In Case is being Deleted
         if(Node == this.getRoot()){
             BT_Node Successor = getSuccessor(Node);
             if(Successor == null){
                 this.setRoot(Node.getLeftChild());
                 return;
             }
             this.setRoot(Successor);
             Successor.setRightChild(Node.getRightChild());
             Successor.setLeftChild(Node.getLeftChild());
             return;
         }

         BT_Node Parent = this.Find_Parent(data,this.getRoot());

         if(Node == null)return;

         // In Case there is no children
         if(Node.getLeftChild() == null && Node.getRightChild() == null && Node.getData() > Parent.getData())Parent.setRightChild(null);
         else if(Node.getLeftChild() == null && Node.getRightChild() == null && Node.getData() < Parent.getData())Parent.setLeftChild(null);

         // In Case the Right Child only exists
         if(Node.getRightChild() != null && Node.getLeftChild() == null && Parent.getData() > Node.getData())Parent.setLeftChild(Node.getRightChild());
         else if(Node.getRightChild() != null && Node.getLeftChild() == null && Parent.getData() < Node.getData())Parent.setRightChild(Node.getRightChild());

         // In Case the Left Child only exists
         if(Node.getRightChild() == null && Node.getLeftChild() != null && Parent.getData() > Node.getData())Parent.setLeftChild(Node.getLeftChild());
         else if(Node.getRightChild() == null && Node.getLeftChild() != null && Parent.getData() < Node.getData())Parent.setRightChild(Node.getLeftChild());

         // In Case the Node has two Children
         else if(Node.getLeftChild() != null && Node.getRightChild() != null){
             BT_Node Successor = this.getSuccessor(Node);
             if(Successor == null){
                 Node = Node.getLeftChild();
                 return;
             }
             if(Node.getData() < Parent.getData())Parent.setLeftChild(Successor);
             else if(Node.getData() > Parent.getData())Parent.setRightChild(Successor);
             Successor.setLeftChild(Node.getLeftChild());
             Successor.setRightChild(Node.getRightChild());
         }
     }
     public int depth(int cnt,BT_Node Node){
         if(Node == null)return cnt;
         return Math.max(depth(cnt+1,Node.getLeftChild()),depth(cnt+1,Node.getRightChild()));
     }
     public void removeLeaf(BT_Node root){
         if(root == null)return;
         if(root.getLeftChild() != null && root.getLeftChild().getLeftChild() == null && root.getLeftChild().getRightChild() == null){
             root.setLeftChild(null);
         }
         if(root.getRightChild() != null && root.getRightChild().getLeftChild() == null && root.getRightChild().getRightChild() == null){
             root.setRightChild(null);
         }
         removeLeaf(root.getLeftChild());
         removeLeaf(root.getRightChild());
     }
}