package p1;
import p1.Pair;

public class WordNode {
   
   private Pair<String,String> wordmean;   //wordmean Pair
   private WordNode pLeft;               // BST Left Pointer
   private WordNode pRight;            // BST Right Pointer
   private WordNode pNext;               // Queue Next Pointer
   
   
   public WordNode()               // constructor of Wordnode class
   { 
         wordmean = new Pair<String,String>();
         pLeft=null;
         pRight=null;
         pNext=null;
   }
   public String GetWord()
   {
      return wordmean.first;// take a word
   }
   public String GetMean()
   {
      return wordmean.second;// take a meaning
   }
   public WordNode GetLeft()
   {
      return pLeft;         // return the Pointer node of left child node
   }
   public WordNode GetRight()
   {
      return pRight;      // return the Pointer node of left child node
   }
   public WordNode GetNext()
   {
      return pNext;         // return the Pointer node of next node
   }
   public void   SetWord(String word)
   {
      wordmean.first = word;   // take the input and save the word into first
   }
   public void SetMean(String mean)
   {
      wordmean.second = mean;   // take the input and save the meaning into second
   }
   public void   SetLeft(WordNode node)
   {
      pLeft = node;      // make the input node as a left child node
   }
   public void   SetRight(WordNode node)
   {
      pRight = node;   // make the input node as a right child node
   }
   public void   SetNext(WordNode node)
   {
      pNext = node;      // make the input node as a next node
   }   
}