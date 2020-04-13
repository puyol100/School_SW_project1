package p1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import p1.WordNode;

public class Queue {      // declare the default constructor

   public WordNode pHead;
   public WordNode pTail;
   Queue()
   {
     
   }
   
    
   // LOAD, ADD
   public void Push(WordNode node){   
       if(pHead==null) {          // if pHead is null
          pHead=node;
          pTail=node;            // point out the node with pHead, pTail
       }
       else {
           pTail.SetNext(node);      // set the last node as a next node of pTail
           pTail=node;            // move the pTail to node
           }
       }
   
   // MOVE
   public WordNode   Pop()
   {
      WordNode p=new WordNode();
      p=pHead;
      pHead=pHead.GetNext(); // move pHead to next node
      return p;
   }
      
   // SEARCH, UPDATE
   public WordNode Search(String word)
   {
     WordNode a;
     a = pHead;
     while(a != null) {      // if a isn`t null
        if(word.compareToIgnoreCase(a.GetWord())==0) {      // if word node`s word is like a node`s word
           break; 
        }
       a = a.GetNext();         // move to next node of queue
     }
     return a;
   }
   // PRINT
   public boolean Print() throws IOException
   {
      BufferedWriter fout = new BufferedWriter(new FileWriter("log.txt",true));   // give a writing authority to fout which can access the log.txt
      try {
      WordNode crnode = pHead;
      if(pHead == null) {fout.close(); return false; }   // if pHead is null, shut down the stream and return
      fout.newLine();
      fout.newLine();
      fout.write("========"+"PRINT"+"========");
      fout.newLine();
      while( crnode.GetNext() != null) {            // repeat if crnode isn`t null
         fout.write(crnode.GetWord() +"   "+crnode.GetMean());
         fout.newLine();
         crnode = crnode.GetNext();               // move crnode to next node
      }
      fout.close();
      return true;
      }catch(FileNotFoundException a) {
           return false;
       }
   }
   
   // SAVE
   public boolean Save() throws IOException
   {
      BufferedWriter fout = new BufferedWriter(new FileWriter("to_memorize_word.txt",true)); // give a writing authority to fout which can access the to_memorize_word.txt
      if(pHead!=null) {            
       while(pHead!=null) {         // if pHead isn`t null
          fout.write(pHead.GetWord()+"   "+pHead.GetMean());
          fout.newLine();
          pHead=pHead.GetNext();      // move pHead to next node
         } 
       }
      else if(pHead == null) {
         fout.close(); return false;
      }
      fout.close();
      return true;
   }
   
}