package p1;

public class Pair<F,S> {   // declare the class for save the word and meaning
    public F first;
    public S second;

    public Pair(F first, S second) // using parameter, take the word and meaning and reset the first and second
    {
      this.first = first;
      this.second = second;
    }
    public Pair()             // no parameter is given, reset the first, second as null
    {
        this.first = null;
        this.second = null;
    }

    static <F,S> Pair<F,S> of(F first, S second)
    {
        return new Pair<F,S>(first, second);   // return Pair class with assign the memory 
    }
  }