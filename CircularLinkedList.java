package p1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CircularLinkedList {
   public WordNode pHead;   // Circular Linked List Head Pointer

   public CircularLinkedList()// constructor of class CircularLinkedList
   {
      
   }
   
   public void Insert(WordNode node)
   {
      if(pHead==null) {   // if pHead node point out null
         pHead=node;   // set pHead as a input node
         node.SetNext(pHead);   // make the node to point out the node pHead
      }
      else {   // pHead node isn`t null
         WordNode current = pHead;      // syncronize the current as pHead
         while(current.GetNext()!=pHead)   // repeat if node current is not point out the pHead
            current=current.GetNext();   // move node current to next node
         current.SetNext(node);      // make current node to point out input node
         node.SetNext(pHead);      // make input node to point out pHead
      }
   }
   public WordNode Search(String word)//////////////////////////
     {
      
        WordNode CircularHead =pHead;   // synchronize the CircularHead as pHead
        if(CircularHead==null) {return null;}// repeat if CircularHead`s next node isn`t pHead
        while(CircularHead.GetNext()!=pHead) {
           if(word.compareToIgnoreCase(CircularHead.GetWord())!=0)CircularHead=CircularHead.GetNext();//if CircularHead`s word isn`t same with input node`s word, then move CircularHead to it`s next node
           else return CircularHead;// if CircularHead`s word is same with input node`s word then return node CircularHead
        } 
        return null;   // return node CircularHead
     }
   
   public boolean   Print() throws IOException
   {
      BufferedWriter fout = new BufferedWriter(new FileWriter("log.txt",true));   // give authority of write the log.txt
         WordNode HEAD=pHead;
        if(pHead == null) {fout.close(); return false;}   // if pHead is null then shut down the stream of fout
        else {
           fout.newLine();
          fout.newLine();
          fout.write("========"+"PRINT"+"========");
          fout.newLine();
         if(pHead.GetNext()==HEAD) {   // if pHead point out HEAD
            fout.write(HEAD.GetWord()+"   "+HEAD.GetMean());
            fout.newLine();
         }
         else {
         while(HEAD.GetNext()!=pHead) {   // repeat if HEAD does not point out the pHead
             fout.write(HEAD.GetWord()+"   "+HEAD.GetMean());   // write the word and meaning
             fout.newLine();
             HEAD=HEAD.GetNext();
             if(HEAD.GetNext()==pHead)
                 fout.write(HEAD.GetWord()+"   "+HEAD.GetMean());   // write the word and meaning
             }
         }
         fout.close();
        }
      return true;
   }
   
   public boolean   Save() throws IOException
   {
      BufferedWriter fout = new BufferedWriter(new FileWriter("memorized_word.txt")); // give authority of write the memorized_word.txt
      WordNode HEAD=pHead;
      if(pHead != null) {
      if(pHead.GetNext()==HEAD) 
         fout.write(pHead.GetWord()+"   "+pHead.GetMean());   // write the word and meaning
         fout.newLine();
      while(pHead.GetNext()!=HEAD) {   // repeat if pHead doesn`t point out the HEAD
          fout.write(pHead.GetWord()+"   "+pHead.GetMean());
          fout.newLine();
          pHead=pHead.GetNext();   
          if(pHead.GetNext()==HEAD) {   // move the node
              fout.write(pHead.GetWord()+"   "+pHead.GetMean());
              fout.newLine();}
          }
      }
      else if(pHead == null) {
         fout.close(); return false;
      }
      fout.close();
      return true;
   }
}