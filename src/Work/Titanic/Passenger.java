package Titanic;

public class Passenger {

  int ID;
  int[] parameters = new int[9];

  public Passenger (String s, boolean training) {
    String[] split = s.split(",");

    ID = Integer.parseInt(split[0]);
    parameters[0] = Integer.parseInt(split[1]);
    parameters[1] = Integer.parseInt(split[2]);
    parameters[2] = split[4].equals("female") ? 0 : 1;
    parameters[3] = Integer.parseInt(split[5]);
    parameters[4] = Integer.parseInt(split[6]);
    parameters[5] = Integer.parseInt(split[7]);

    parameters[6] = Integer.parseInt(split[9]);

    String x = split[10];
    if (x.contains("A"))

    parameters[8] = Integer.parseInt(split[11]);
  }
}
