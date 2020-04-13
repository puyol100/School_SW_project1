package p1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class AlphabetBST {
   private AlphabetNode root;
   private int WordCnt; // for count the node

   public AlphabetBST()   // constructor of the class 
   {
      root = null;
      WordCnt = 0;
      
      
      char[] alpha = { 'P', 'H', 'X', 'D', 'L', 'T', 'Z', 'B', 'F', 'J', 'N', 'R', 'V', 'Y', 'A', 'C', 'E', 'G', 'I', 'K',
         'M', 'O', 'Q', 'S', 'U', 'W' };//insert alphabet 
      
      for (int i = 0; i < 26; i++) //26 ( number of alphabet ) 
      {
         AlphabetNode pnew = new AlphabetNode();
         pnew.SetAlphabet(alpha[i]);    // put the alphabet which is declared in line 18
         pnew.SetBST(new WordBST());   // generate the WordBST and put into node
         Insert(pnew);               // insert the AlphabetBST
      }
   }
      
   public void Insert(AlphabetNode node)
   {
      AlphabetNode p = root, pp=null;
      while(p!=null) {            // if p isn`t null, then repeat
      pp=p;
      if(node.GetAlphabet()<p.GetAlphabet()) p=p.GetLeft();      // if node`s alphabet is smaller than p`s alphabet, move p to left child node
      else if(node.GetAlphabet()>p.GetAlphabet()) p=p.GetRight();   // if node`s alphabet is bigger than p`s alphabet, move p to right child node
      else return ;   // in case of exception, shut the method
   }
   
   p=new AlphabetNode();
   if(root!=null)               // if root isn`t null
      if(node.GetAlphabet()<pp.GetAlphabet())pp.SetLeft(node);   // if node`s alphabet is smaller than pp`s alphabet, move pp to left child node
      else pp.SetRight(node);   // if node`s alphabet is bigger than pp`s alphabet, move pp to right child node
   else root = node;      // if root is null, then make input node as a root
     }
   
   public boolean Print() throws IOException///////////////////////////////////////////////
   {
      AlphabetNode a = root;      // make a point out the root
      char[] alpha = { 'P', 'H', 'X', 'D', 'L', 'T', 'Z', 'B', 'F', 'J', 'N', 'R', 'V', 'Y', 'A', 'C', 'E', 'G', 'I', 'K',
                'M', 'O', 'Q', 'S', 'U', 'W' };//insert alphabet 
             
             for (int i = 0; i < 26; i++) //26 ( number of alphabet ) 
             {
               if(Search(alpha[i]).GetBST().root ==null) {
                  if(i==25) { return false;} 
                  continue;}
               else if(Search(alpha[i]).GetBST().root !=null) {break;}
             }
      
      boolean bo;
      bo=Preorder_for_alpha_Print(a);      // use Preorder_for_alpha_Print method for print all nodes
      return bo;
   }
   
   public AlphabetNode Search(char alphabet)
   {
     
      AlphabetNode p = root;      // make a point out the root
         while(p!=null){         // if p isn`t null, then repeat
       if(alphabet>96 && alphabet<123) {   // if alphabet is small letter
          if(alphabet<(char)(p.GetAlphabet()+32)) {p=p.GetLeft();}      // if input variable alphabet is smaller than p`s alphabet in Dictionary order then move pointer p to p`s left child
          else if(alphabet>(char)(p.GetAlphabet()+32)) {p=p.GetRight();}   // if input variable alphabet is bigger than p`s alphabet in Dictionary order then move pointer p to p`s right child
          else return p;   // return class p
       }
       else if(alphabet>64 && alphabet<91) {// if alphabet is capital letter
          if(alphabet<(char)(p.GetAlphabet())) {p=p.GetLeft();}// if input variable alphabet is smaller than p`s alphabet in Dictionary order then move pointer p to p`s left child
          else if(alphabet > (char)(p.GetAlphabet())) {p=p.GetRight();}// if input variable alphabet is bigger than p`s alphabet in Dictionary order then move pointer p to p`s right child
          else return p;// return class p
       }
       }
         return p;
   }
   
   public boolean Save() throws IOException
   {
      BufferedWriter fout = new BufferedWriter(new FileWriter("memorizing_word.txt"));
      fout.close();
      AlphabetNode a = root;   // make a point out the root
      Preorder_for_alpha_save(a);   // use Preorder_for_alpha_save method for save all nodes
      return true;
   }
   public void   Preorder(AlphabetNode node) throws IOException
   {
     if(node!=null) {   // if node isn`t null
         node.GetAlphabet();
         Preorder(node.GetLeft());
         Preorder(node.GetRight());   // recursive method for make all nodes preoreder
       }
    }
   public boolean Preorder_for_alpha_Print(AlphabetNode node) throws IOException////////////////////////////////
   {
     boolean j;
     if(node!=null) {      // if node isn`t null
         node.GetAlphabet();
         j=node.GetBST().Print();   // print the BST
        
         Preorder_for_alpha_Print(node.GetLeft());
         Preorder_for_alpha_Print(node.GetRight());         // recursive method for print all nodes
     }
     return true;
   }
  
   public boolean Preorder_for_alpha_save(AlphabetNode node) throws IOException////////////////////////////////////
   {
     if(node!=null) {   // if node isn`t null
         node.GetAlphabet();
        node.GetBST().Save();   // print the BST
         Preorder_for_alpha_save(node.GetLeft());
         Preorder_for_alpha_save(node.GetRight());   // recursive method for print all nodes
       }

     return true;
   }
   public int getCnt()
     {
        return WordCnt;      // return the number of nodes
     }
    public void setCnt(int cnt)
      {
         WordCnt = cnt;   // reset the Wordcnt as input variable cnt
         return ;
      }
}