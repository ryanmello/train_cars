import java.util.*;

public class Main {
  private static String menu;
  private static Scanner scan;
  private static Train train;
  private static Boolean running = true;

  public static void main(String[] args){
    menu = "Train Depot Menu Option\n\nEnter A to Attach a train car\n" 
      + "Enter R to Detach car at factory\nEnter D to Display all"
      + " the train cars\nEnter S to Search a train car\nEnter M"
      + " to Merge two train cars\nEnter q to Quit\n";

    train = new Train("car.txt");
    scan = new Scanner(System.in);

    while(running){
      System.out.println(menu);
      System.out.print("Please enter your choice: ");
      String choice = scan.nextLine().toUpperCase();

      switch(choice) {
        case "A":
          createCar();
          break;
        case "R":
          delete();
          break;
        case "D":
          train.displayTrainCars();
          break;
        case "S":
          search();
          break;
        case "M":
          merge();
          break;
        case "Q":
          quit();
          break;
        default:
          throw new InputMismatchException("\nIncorrect Input\n");
      }
    }
  }

  public static void merge() {
    System.out.println("\nDisplaying the existing cars");
    train.displayTrainCars();
    System.out.println("\nDisplaying the new cars");
    train.merge("update.txt");
  }

  public static void search() {
    System.out.println("\nEnter the factory name you want to search: ");
    String facName = scan.nextLine();
    System.out.println();
    train.search(facName);
  }

  public static void delete(){
    System.out.println("\nPlease enter the factory name you wish to detach: ");
    String name = scan.nextLine();
    System.out.println();
    train.detach(name);
    
  }

  public static void createCar(){
    String factory, stop, material;

    System.out.println("\nPlease enter the factory name: ");
    factory = scan.nextLine();
    System.out.println("\nPlease enter the stop number: ");
    stop = scan.nextLine();
    int stopInt = Integer.parseInt(stop);
    System.out.println("\nPlease enter the material name: ");
    material = scan.nextLine();

    System.out.println("\nAdding a new car - " +factory+" "+stop+" "+material+"\n");
    train.attach(factory, stopInt, material);
    
  }

  public static void quit(){
    running = false;
    System.out.println("Good Bye!");
  }
}