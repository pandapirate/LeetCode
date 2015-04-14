package Titanic;


import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class GeneticTree {

  static ArrayList<Passenger> passengers = new ArrayList<Passenger>();

  public static void main(String[] args) throws Exception {
    // add data.json
    Scanner scanner = new Scanner(new FileReader("E:\\Temp\\src\\Titanic\\Data\\train.csv"));
    passengers.add(new Passenger(scanner.nextLine(), true));
    scanner.close();


  }
}
