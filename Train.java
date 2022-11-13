import java.io.*;
import java.util.*;

public class Train{
  private Car front;

  public Train(){
    this.front = null;
  }

  public Train(String carFile) {
    Scanner fileReader = null;

    try {
      fileReader = new Scanner(new File(carFile));
    } catch (FileNotFoundException e){
      System.out.println("/nFile was not found!\n");
    }

    String[] info;
    String line;
    
    while(fileReader.hasNextLine()){
      line = fileReader.nextLine();
      info = line.split(",");

      attach(info[0], Integer.valueOf(info[1]), info[2]);
    }
    fileReader.close();
  }

  public void detach(String factoryName){
    if(this.front == null){
      return;   
    }
    Car current = this.front, prev = null;

    if(current != null && current.factory.equalsIgnoreCase(factoryName)){
      prev = front.next;
      current = prev;
    }

    while(current != null && current.factory != factoryName){
      current = current.next;
    }

    // if(){
      
    // }

    //prev.next = current.next;
    detach(factoryName);
  }

  // Attach Method
  public void attach(String factoryName, int stopNumber, String materialName){
    if(this.front == null){
      this.front = new Car(factoryName, stopNumber, materialName);
    } else {
      Car current = this.front;
      while(current.next != null){
        current = current.next;
      }
      current.next = new Car(factoryName, stopNumber, materialName);
    } 
    sort();
  }

  public void search(String factoryName){
    Car current = this.front;
    if(current == null){
      return;
    }
    while(current != null){
      if(current.factory.equalsIgnoreCase(factoryName)){
        System.out.println("The material in the car is " + current.material);
      }
      current = current.next;
    }
  }

  public List<String> getCars(String factoryName){
    List<String> materials = new LinkedList<>();
    Car current = this.front;
    while(current.next != null){
      if(current.next.factory.equalsIgnoreCase(factoryName)){
        
        
      }
      current = current.next;
    }
    return materials;
  }

  public void displayTrainCars(){
    sort();
    Car current = this.front;
    if(this.front == null){
      System.out.println("\nThe train is empty!\n");
      return;
    }
    while(current != null){
      System.out.println(current.factory + " " + current.stop + " " + current.material);
      current = current.next;
    }
  }

  public void merge(String update){
    Scanner fileReader = null;
    String[] info = null;
    try {
      fileReader = new Scanner(new File(update));
    } catch (FileNotFoundException e){
      System.out.println("File was not found");
    }
    while(fileReader.hasNextLine()){
      info = fileReader.nextLine().split(",");
      attach(info[0], Integer.valueOf(info[1]), info[2]);
    }
    System.out.println();
    sort();
  }

  public void sort(){
    Car current = this.front, index = null;
    int temp;
    String tempFactory, tempMaterial;
    if(this.front == null){
      return;
    } else {
      while(current != null){
        index = current.next;
        while(index != null){
          if(current.stop > index.stop){
            temp = current.stop;
            tempFactory = current.factory;
            tempMaterial = current.material;

            current.stop = index.stop;
            current.factory = index.factory;
            current.material = index.material;

            index.stop = temp;
            index.factory = tempFactory;
            index.material = tempMaterial;
          }
          index = index.next;
        }
        current = current.next;
      }
    }
  }
}