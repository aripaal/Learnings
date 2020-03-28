package com.mylearnings.trees;

/**
 * Created by ronnie on 3/19/17.
 */
public class BinaryTree {
    private Integer value;
    private BinaryTree left;
    private BinaryTree right;

    public BinaryTree(Integer value, BinaryTree left, BinaryTree right) {

        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BinaryTree(Integer value) {
        this.value = value;
    }

    public void addNode(Integer value){
      if(value <this.value){
          if(this.left!=null){
              this.left.addNode(value);
          }
          else this.left=new BinaryTree(value);
      }else{
          if(this.right!=null){
              this.right.addNode(value);
          }
          else this.right=new BinaryTree(value);

      }


  }
//  public boolean search(Integer value)
//  {
//      if(this.value==value)
//        return true;
//      if(value < this.value){
//          if(this.left!=null)
//              return this.left.search(value);
//      }
//      else
//  }
  public void traveresePreorder(){

      System.out.println(this.value);
        if(this.left!=null) this.left.traveresePreorder();
        else if(this.right!=null) this.right.traveresePreorder();
  }
    public static void main(String args[]){
        int[] vals={1,4,2,3,56,3};
        BinaryTree binaryTree=new BinaryTree(vals[0]);
        for(int x=1;x<vals.length;x++)
            binaryTree.addNode(vals[x]);

        binaryTree.traveresePreorder();


    }
}
