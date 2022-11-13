/** 
  * 
  * @author Ryan Mello
  * @version 1.0.0
  */

class Car { public String factory; public int stop; public String material; Car next;
  
  public Car(){
    // default constructor
    this("", 0, "", null);
    
  }
  
  public Car(String fact, int s, String m){
    // regular constructor sets next to null
    this(fact, s, m, null);
  }

  public Car(String fact, int s, String m, Car next){
    // regular constructor sets   this.next=next;
    this.factory = fact;
    this.stop = s;
    this.material = m;
    this.next = next;
  }
}
