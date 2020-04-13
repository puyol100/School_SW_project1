package p1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WordBST {
   
   public WordNode root;   // Word BST Root
      
   public WordBST()      // constructor of the WordBST class
   {
    
      root = null;
   }
   public void Insert(WordNode node)
   {
      WordNode p=root, pp=null;
     while( p!=null) {   // repeat if p doesn`t point out null
         pp=p;
         if(node.GetWord().compareTo(p.GetWord()) <0) p=p.GetLeft();   // The word p is lexically larger than the node. Move p to the left subtree.
         else if (node.GetWord().compareTo(p.GetWord()) > 0) p = p.GetRight();   // If the word of p is lexically smaller than node, move p to the right tree
         else break; 
      }
      if(root !=null) {
         if(node.GetWord().compareTo(pp.GetWord()) < 0)  pp.SetLeft(node);   //  If the word of pp is prominently large, set the node to the left subtree of pp
         else  pp.SetRight(node);      // In the opposite case, pp is set to the right subtree
         
       }
     else root=node;      // If there is no node, root the first node.
   }
   public WordNode Delete(String word)
   {   
      WordNode p=root, pp=null;
      while(word.compareToIgnoreCase(p.GetWord()) != 0) {   // Repeat until the word Node is equal to the word in the notepad, and escape the loop if it matches.
         pp=p;
         if(word.compareToIgnoreCase(p.GetWord()) < 0) p=p.GetLeft();   // If the word to be removed is lower in the dictionary sort than the word p, move p to the left node
         else if (word.compareToIgnoreCase(p.GetWord()) > 0) p = p.GetRight(); // If the word to be removed is higher in dictionary sort than p words, move p to the right node
      }
      
      if (p.GetLeft()==null && p.GetRight()==null) { // node p has no child node
         if(pp==null)root=null;         // in this case, word is only root or no word is in BST
         else if(pp.GetLeft()==p) pp.SetLeft(null);      // if pp`s left child node is target, delete the point
         else pp.SetRight(null);         // if pp`s right child node is target, delete the point
         WordNode newNode0 = new WordNode();
         newNode0.SetWord(p.GetWord());
         newNode0.SetMean(p.GetMean());
         p=null;
         return newNode0;      //return newNode0 which has the data of deleted node
      }
      else if(p.GetLeft()==null && p.GetRight()!=null) {   // p has only right child
         if(pp==null) root=p.GetRight();         // if pp is null then set p`s right child node as a root
         else if(pp.GetLeft()==p)pp.SetLeft(p.GetRight());      // if pp`s left child node is target, then set target`s right child node as a pp`s left child node
         else pp.SetRight(p.GetRight());            // if pp`s right child node is target, then set target`s right child node as a pp`s right child node
         WordNode newNode1 = new WordNode();
         newNode1.SetWord(p.GetWord());
         newNode1.SetMean(p.GetMean());
         p=null;
         return newNode1;         // return newNode1 which has a data of deleted node
      }
      else if(p.GetRight()==null && p.GetLeft()!=null) {      // if p only has a left child node
         if(pp==null) root=p.GetLeft();                  //   if pp is null then set p`s left child as a root
         else if(pp.GetLeft()==p)pp.SetLeft(p.GetLeft());   //   if pp`s left child node is target, then set target`s left child node as a pp`s left child node
         else pp.SetRight(p.GetLeft());            //   if pp`s right child node is target, then set target`s left child node as a pp`s right child node
         WordNode newNode2 = new WordNode();
         newNode2.SetWord(p.GetWord());
         newNode2.SetMean(p.GetMean());
         p=null;
         return newNode2;         // return newNode2 which has a data of deleted node
      }
      else  {         // p has both side of child node
         WordNode prevprev=p, prev=p.GetLeft(), curr=p.GetLeft().GetRight();
      // initialize prevprev, prev, and curr to the p and, left child of p and the right child of prev, respectively.
         while(curr!=null) {   // repeat if curr isn`t null
            prevprev=prev;
            prev=curr;
            curr=curr.GetRight();
         }
         WordNode newNode3 = new WordNode();
         newNode3.SetWord(p.GetWord());
         newNode3.SetMean(p.GetMean());      // take a data of target into the newNode3
         p.SetWord(prev.GetWord());
         p.SetMean(prev.GetMean());         // Replace the information of node p to be deleted with the information of prev.
         if(prevprev==p) prevprev.SetLeft(prev.GetLeft());   // Specify the left child of prev as the left child of prevprev.
         else prevprev.SetRight(prev.GetLeft());   // If prevprev is not p, specify the left child of prev as the right child of prevprev.
         prev=null;            // Since prev has moved to the position of the existing p, delete the node of prev.
         return newNode3;      // return newNode3 which has a data of deleted node
      }
   }
   public WordNode Search(String word)
   {
      WordNode p = root;
      while(p!=null){            // repeat if p isn`t null
      if(word.compareToIgnoreCase(p.GetWord()) <0 ) p=p.GetLeft();   // If node is lexically smaller than p, make p point to the left child of the existing p.
      else if (word.compareToIgnoreCase(p.GetWord()) > 0) p = p.GetRight();   // If node is lexically bigger than p, make p point to the right child of the existing p.
      else return p;
      }
      return p;      // if p is null return p
   }
   public boolean Print() throws IOException
   {
     
      WordNode   Wsave = root;
      WordBST a = new WordBST();
      a.Preorder_for_Print_word(Wsave);      // print the contents of WordBST
      return true;
    }
   
   public boolean Save() throws IOException
   {
      
      WordNode   Wsave = root;
      WordBST a = new WordBST();
     return a.Preorder_for_Save_word(Wsave);      // input the WordBST`s contents into file
     
   }
   public void   Preorder(WordNode node) throws IOException
   {
            
            if(node!=null) {      // if input node isn`t null
               
              Preorder(node.GetLeft());
            Preorder(node.GetRight());
      }
      return ;
   }
   public boolean Preorder_for_Save_word(WordNode node) throws IOException
   {
      BufferedWriter fout = new BufferedWriter(new FileWriter("memorizing_word.txt",true)); // Give fout permission to access memorizing_word.txt.
      if(node!=null) {                  // if input node isn`t null
             fout.write(node.GetWord()+"   "+node.GetMean());   // write the information which has a node into the file
           fout.newLine();   
           fout.close();
           Preorder_for_Save_word(node.GetLeft());      // Sort the left nodes recursively.
           Preorder_for_Save_word(node.GetRight());      // Sort the right nodes recursively.
      }
      else if(node == null) { fout.close(); return false;}
      return true;
   }
   public void Preorder_for_Print_word(WordNode node) throws IOException
   {
      BufferedWriter fout = new BufferedWriter(new FileWriter("log.txt",true));   // Give fout permission to access log.txt.
      if(node!=null) {         // if input node isn`t null
             fout.write(node.GetWord()+"   "+node.GetMean());      // write the information which has a node into the file
           fout.newLine();
           fout.close();
           Preorder_for_Print_word(node.GetLeft());
           Preorder_for_Print_word(node.GetRight());            // Use recursive to print all the left and right nodes.
      }
      else if(node == null) fout.close();                     // If all nodes are printed and node is null, then the file is closed.
   }
}