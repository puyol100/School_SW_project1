package p1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.File;



public class Manager {
   
   public CircularLinkedList cll;   // MEMORIZED Circular Linked List
   public AlphabetBST bst;         // MEMORIZING BST
   public Queue queue;//=new Queue();            // TO_MEMORIZE Queue
   public String cmd;            // command 
   boolean bool;

   String[] split;
   
   public Manager() // constructor of class Manager
   {
     cll= new CircularLinkedList();
      bst = new AlphabetBST();
      queue = new Queue();
   }
   public void run(String command) throws IOException
   {
      FileReader fin = new FileReader(command);
      BufferedReader bf = new BufferedReader(fin);
      String s;
      while((s=bf.readLine())!=null) {   // read a line which is in the command
         split=s.split("\\s+");
         
         switch(split[0]) {   // case of command
         case "LOAD":
           bool= LOAD();
            logtxt(bool);
            break;
         case "ADD":
            bool=ADD();
            logtxt(bool);
            break;
         case "MOVE":
            bool=MOVE();
            logtxt(bool);
            break;
         case "SAVE":
            bool=SAVE();
            logtxt(bool);
            break;
         case "TEST":
            bool=TEST();
            logtxt(bool);
            break;
         case "SEARCH":
            bool=SEARCH();
            logtxt(bool);
            break;
         case "PRINT":
            bool=PRINT();
            logtxt(bool);
            break;
         case "UPDATE":
            bool=UPDATE();
            logtxt(bool);
            break;
         case "EXIT":
            bool = true;
            logtxt(bool);
            return ;
         default: 
         }
       }
      fin.close();   // shut down file stream
    }
   public void logtxt(boolean logbool) throws IOException  {
      BufferedWriter A;
      A = new BufferedWriter(new FileWriter("log.txt",true));
      if(logbool == false) {   // if parameter is false, handling the error
      A.write("========"+"ERROR"+"========");
      A.newLine();
      switch(split[0]) {
       case "LOAD":
          A.write("100");
          A.newLine();
          break;
       case "ADD":
          A.write("200");
          A.newLine();
          break;
       case "MOVE":
          A.write("300");
          A.newLine();
          break;
       case "SAVE":
          A.write("400");
          A.newLine();
          break;
       case "TEST":
          A.write("500");
          A.newLine();
          break;
       case "SEARCH":
          A.write("600");
          A.newLine();
          break;
       case "PRINT":
          A.write("700");
          A.newLine();
          break;
       case "UPDATE":
          A.write("800");
          A.newLine();
          break;
       default:
       }
     }
      else if(logbool == true) {   // if parameter is true which success the command
      switch(split[0]) {
       case "LOAD":
          A.write("========"+split[0]+"========");
          A.newLine();
          A.write("Success");
          A.newLine();
          break;
       case "ADD":
          A.write("========"+split[0]+"========");
          A.newLine();
          A.write("Success");
          A.newLine();
          break;
       case "MOVE":
          A.write("========"+split[0]+"========");
          A.newLine();
          A.write("Success");
          A.newLine();
          break;
       case "SAVE":
          A.write("========"+split[0]+"========");
          A.newLine();
          A.write("Success");
          A.newLine();
          break;
       case "TEST":
          A.write("========"+split[0]+"========");
          A.newLine();
          A.write("Pass");
          A.newLine();
          break;
       case   "EXIT":
          A.write("========"+split[0]+"========");
          A.newLine();
          A.write("Success");
          A.newLine();
          break;
       default:
        }
      }
      A.write("========================");
      A.newLine();
      A.newLine();
      A.newLine();
      A.close();
   }
   public boolean LOAD() throws IOException   // Instruction to load wordbook information
   {
     
      if(split[1].compareTo("to_memorize_word.txt")==0) {
       try {      // check the exception
         FileReader fin1 = new FileReader(split[1]);
          BufferedReader bf1 = new BufferedReader(fin1);
         String s0;
         if((s0=bf1.readLine())==null) {fin1.close(); bf1.close();   return false;}   // if file is end, then shut down the stream
         else {
            String[] split = s0.split("\\s+");
              WordNode n = new WordNode();
             n.SetWord(split[0]);
             n.SetMean(split[1]);
             queue.Push(n);
          while((s0=bf1.readLine())!=null) {   // repeat as file end
             split = s0.split("\\s+");
             n = new WordNode();
             n.SetWord(split[0]);
             n.SetMean(split[1]);
             queue.Push(n);
          }
          fin1.close();
          bf1.close();
         }
       }catch(FileNotFoundException f) {   // if exception occur then return falses
            return false;
        }
      }
      else if(split[1].compareTo("memorizing_word.txt")==0) {   // check the word is in the memorizing_word.txt
        try {      // check the exception
         FileReader fin2 = new FileReader(split[1]);
         BufferedReader bf2 = new BufferedReader(fin2);
         String s;
         if((s=bf2.readLine())==null) {fin2.close(); bf2.close();   return false;}   // if file is end, then shut down the stream
         else {
            String[] split1;
             split1=s.split("\\s+");
             WordNode LoadNode = new WordNode();
             LoadNode.SetWord(split1[0]);
             LoadNode.SetMean(split1[1]);
             char alphabet;
             alphabet=split1[0].charAt(0);
             if(bst.Search(alphabet).GetBST()==null)
                {
                   WordBST Wbst= new WordBST();
                   bst.Search(alphabet).SetBST(Wbst);
                }
                bst.Search(alphabet).GetBST().Insert(LoadNode);
         while((s=bf2.readLine())!=null) {   // repeat as file end
           split1=s.split("\\s+");
            LoadNode = new WordNode();
            LoadNode.SetWord(split1[0]);
            LoadNode.SetMean(split1[1]);
            alphabet=split1[0].charAt(0);
            if(bst.Search(alphabet).GetBST()==null)   // if alphabet has no BST
               {
                  WordBST Wbst= new WordBST();
                  bst.Search(alphabet).SetBST(Wbst);
               }
               bst.Search(alphabet).GetBST().Insert(LoadNode);
             }
         BufferedWriter fout2 = new BufferedWriter(new FileWriter(split[1]));
         fout2.close();
         fin2.close();
         bf2.close();
         }
        }catch(FileNotFoundException f) {   // if exception occur then return false
             return false;
         }
         }
      else if(split[1].compareTo("memorized_word.txt")==0) {   // check the word is in the memorized_word.txt
         try {   // check the exception
         FileReader fin3 = new FileReader(split[1]);
         BufferedReader bf3 = new BufferedReader(fin3);
         String s;
         if((s=bf3.readLine())==null) { // if file is end, then shut down the stream
            fin3.close();
             bf3.close();
             return false;}
         else {
            String[] split2=s.split("\\s+");
             WordNode LoadNode = new WordNode();
             LoadNode.SetWord(split2[0]);
             LoadNode.SetMean(split2[1]);
             cll.Insert(LoadNode);
         while((s=bf3.readLine())!=null) {// repeat file isn`t end
            split2=s.split("\\s+");
            LoadNode = new WordNode();
            LoadNode.SetWord(split2[0]);
            LoadNode.SetMean(split2[1]);
            cll.Insert(LoadNode);
         }
         fin3.close();
         bf3.close();
         }
         }catch(FileNotFoundException f) {   // if exception occur then return false
              return false;
          }
      }
      else {
        return false;
      } 
      return true;
   }
   public boolean ADD() throws IOException   // add the word into the txt file
   {
      try {
     FileReader fin1 = new FileReader("word.txt");
     BufferedReader bf1 = new BufferedReader(fin1);
      String s1;
      if((s1=bf1.readLine())==null) { fin1.close(); bf1.close(); return false;}// if file end shut down the stream
      else {
         String[] split=s1.split("\\s+");
         WordNode n = new WordNode();
          n.SetWord(split[0]);
          n.SetMean(split[1]);
          queue.Push(n);
      while((s1=bf1.readLine())!=null) {   // repeat if file isn`t end
         split=s1.split("\\s+");
        n = new WordNode();
         n.SetWord(split[0]);
         n.SetMean(split[1]);
         queue.Push(n);
         }
      fin1.close();}
      return true;
     }catch(FileNotFoundException f) {   // if exception occur then return false
         return false;
      }
      
   }
   public boolean MOVE()   // move the word between txt files
   {
      if(queue.pHead == null) return false;
      else {
      for(int i = 0; i<Integer.parseInt(split[1]);i++)   // count the number of node
      {
        bst.setCnt(i);
        if(bst.getCnt()>99) {
           return false;
        }
        WordNode node = queue.Pop();   // reset the node with the word of queue
        char alphabet;
         alphabet=node.GetWord().charAt(0);
         if(bst.Search(alphabet).GetBST()==null)   // if there is no BST of alphabet
         {
            WordBST Wbst= new WordBST();
            bst.Search(alphabet).SetBST(Wbst);
         }
         bst.Search(alphabet).GetBST().Insert(node);   // insert the data into BST of alphabet
       }
       return true;
      }
   }
   
   public boolean SAVE() throws IOException   // save the data
   {
      if(queue.Save()==true) {
         if(bst.Save()==true) {
            if(cll.Save()==true) {
               return true;   // all saving sequence is success then return true
            }
            else return false;
         }
         else return false;
      }
      else return false;   // in other case, return false
   }

  
   
   public boolean TEST()   // check the word is memorized
   {
      WordNode node = new WordNode();
      node.SetWord(split[1]);
      char alphabet;
      alphabet=node.GetWord().charAt(0);
      if(bst.Search(alphabet).GetBST().Search(split[1])!=null) { // if BST is not null
         if(bst.Search(alphabet).GetBST().Search(split[1]).GetMean().compareToIgnoreCase(split[2]) == 0) {// check the word
            cll.Insert(bst.Search(alphabet).GetBST().Delete(split[1]));
         }
         else if(bst.Search(alphabet).GetBST().Search(split[1]).GetMean().compareToIgnoreCase(split[2]) != 0) {// if meaning is not equal
            return false;
         }
     }
     else if(bst.Search(alphabet).GetBST().Search(split[1])==null) {   
        return false;
     }
     return true;
   }
   public boolean SEARCH() throws IOException   // Search command, compare with the txt file and word
   {
      BufferedWriter fout = new BufferedWriter(new FileWriter("log.txt",true));
      if(queue.Search(split[1])==null && bst.Search(split[1].charAt(0)).GetBST().Search(split[1])==null &&cll.Search(split[1])== null) 
      {  fout.close();   //  no word node is in the log.txt
         return false;
      }
      else {   // there is word node in txt file
         if(queue.Search(split[1])!=null) {   // find the word in Queue
            fout.newLine();
            fout.newLine();
            fout.write("========"+"SEARCH"+"========");
            fout.newLine();
            fout.write(queue.Search(split[1]).GetWord()+"   "+queue.Search(split[1]).GetMean());
            fout.newLine();
            }
         else if(bst.Search(split[1].charAt(0)).GetBST().Search(split[1])!=null) {   // find the word in BST
            fout.newLine();
            fout.newLine();
            fout.write("========"+"SEARCH"+"========");
            fout.newLine();
            fout.write(bst.Search(split[1].charAt(0)).GetBST().Search(split[1]).GetWord()+"   "+bst.Search(split[1].charAt(0)).GetBST().Search(split[1]).GetMean());
            fout.newLine();
         }
         else if(cll.Search(split[1]) != null)      //  find the word in Circular Linked List
         {
            fout.newLine();
            fout.newLine();
            fout.write("========"+"SEARCH"+"========");
            fout.newLine();
            fout.write(cll.Search(split[1]).GetWord()+"   "+cll.Search(split[1]).GetMean());
            fout.newLine();
         }
         }
      fout.close();
      return true;
   }//에러 잡음
   public boolean PRINT() throws IOException
   {
      if(split[1].compareToIgnoreCase("TO_MEMORIZE")==0) {   // if TO_MEMORIZE has a same word with split[1]
         return queue.Print();
       }//word.compareToIgnoreCase(p.GetWord())
      else if(split[1].compareToIgnoreCase("MEMORIZING")==0) {   // if MEMORIZING has a same word with split[1]
         return bst.Print();
         }
      else if(split[1].compareToIgnoreCase("MEMORIZED")==0) {   // if MEMORIZED has a same word with split[1]
        return cll.Print();
         }
      else {
         return false;
      }
    }
   public boolean UPDATE() throws IOException   // change the meaning of the word
   {
      BufferedWriter fout = new BufferedWriter(new FileWriter("log.txt",true));
      try {
     if(queue.Search(split[1])!=null) {   // if word is in the queue
       fout.write("========"+"UPDATE"+"========");
       fout.newLine();
        fout.write(split[1]+" "+ queue.Search(split[1]).GetMean()+"->");
        queue.Search(split[1]).SetMean(split[2]);   // change the meaning of the word
        fout.write(queue.Search(split[1]).GetMean());
        fout.newLine();
        fout.close();
        return true;
     }
     else if(bst.Search(split[1].charAt(0)).GetBST().Search(split[1])!=null) {   //  if word is in the BST   
        fout.write("========"+"UPDATE"+"========");
        fout.newLine();
        fout.write(split[1]+" "+bst.Search(split[1].charAt(0)).GetBST().Search(split[1]).GetMean()+"->");
       bst.Search(split[1].charAt(0)).GetBST().Search(split[1]).SetMean(split[2]);   // change the meaning of the word
        fout.write(bst.Search(split[1].charAt(0)).GetBST().Search(split[1]).GetMean());
        fout.newLine();
        fout.close();
        return true;
     }
     else if(cll.Search(split[1]) !=null) {   //  if word is in the Circular linked list
        fout.write("========"+"UPDATE"+"========");
        fout.newLine();
        fout.write(split[1]+" "+cll.Search(split[1]).GetMean()+"->");
        cll.Search(split[1]).SetMean(split[2]);   // change the meaning of the word
        fout.write(cll.Search(split[1]).GetMean());
        fout.newLine();
        fout.close();
        return true;
     }
     else {
        fout.close();
        return false;
     }
   }catch(FileNotFoundException f) {
       return false;
   }
   }
   public boolean EXIT() throws IOException{
         cll = null;
         bst = null;
         queue = null;
         return true;
      }
}