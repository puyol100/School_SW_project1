package p1;

public class AlphabetNode {
   private char alphabet;
   private WordBST bst;
   private AlphabetNode pLeft;      // BST Left Pointer
   private AlphabetNode pRight;   // BST Right Pointer

   public AlphabetNode()
   { 
      alphabet=0;
      bst=null;
      pLeft=null;
      pRight=null;
   }                  // constructor of the AlphabetNode
   
   public char GetAlphabet()
   {
      
      return alphabet;      // return alphabet
   }
   
   public WordBST GetBST()
   {
      return bst;         // return WordBST
   }
   
   public AlphabetNode GetLeft()
   {
      return pLeft;         // return left child node
   }
   
   public AlphabetNode GetRight()
   {
      return pRight;      // return right child node
   }
   
   public void   SetAlphabet(char alphabet)
   {
      this.alphabet=alphabet;   // take alphabet and save it into node`s variable alphabet
   }
   
   public void   SetLeft(AlphabetNode node)
   {
      this.pLeft=node;   // take node and point it out node with pLeft
   }
   
   public void   SetRight(AlphabetNode node)
   {
      this.pRight=node;   // take node and point it out node with pRight
   }
   
   public void SetBST(WordBST node)
   {
      this.bst=node;   // take WordBST and point it out node`s  bst
   }

}