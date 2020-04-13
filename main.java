package p1;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import p1.Pair;
import p1.WordNode;

public class main {

   public static void main(String[] args) throws IOException {
      BufferedWriter f = new BufferedWriter(new FileWriter("log.txt"));
       f.close();
      Manager manager = new Manager(); // Manager class manager is declare
      manager.run("command.txt");// open file command.txt as a parameter of manager.run
      return ;   // end of main
     }
 }