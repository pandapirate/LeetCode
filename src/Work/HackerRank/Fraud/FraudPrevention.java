package HackerRank.Fraud;

import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class FraudPrevention {

    public static int[] fraudList;

    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(new FileReader("src/HackerRank.Fraud/text3"));

        int n = Integer.parseInt(in.nextLine());

        HashMap<String, HashSet<Integer>> emailList = new HashMap<String, HashSet<Integer>>();
        HashMap<String, HashSet<Integer>> addressList = new HashMap<String, HashSet<Integer>>();
        HashMap<Integer, String> idList = new HashMap<Integer, String>();

        HashSet<Integer> fraudID = new HashSet<Integer>();

        for(int i = 0; i < n; i++) {
            String[] split = in.nextLine().toLowerCase().split(",");
            int orderID = Integer.parseInt(split[0]);
            String dealID = split[1];
            String email = stripEmail(split[2]);
            String address = stripAddress(split);
            String cardNumber = split[7];

            idList.put(orderID, cardNumber);

            String eKey = email + " " + dealID;
            String aKey = address + " " + dealID;
            boolean found = false;

            if (emailList.containsKey(eKey)) {
                HashSet<Integer> list = emailList.get(eKey);
                for (int x : list) {
                    if (idList.get(x).equals(cardNumber))
                        continue;
                    else {
                        fraudID.add(x);
                        fraudID.add(orderID);
                    }
                }
                list.add(orderID);
                emailList.put(eKey, list);
            } else {
                HashSet<Integer> values = new HashSet<Integer>();
                values.add(orderID);
                emailList.put(eKey, values);
            }

            if (addressList.containsKey(aKey)) {
                HashSet<Integer> list = addressList.get(aKey);
                for (int x : list) {
                    if (idList.get(x).equals(cardNumber))
                        continue;
                    else {
                        fraudID.add(x);
                        fraudID.add(orderID);
                    }
                }
                list.add(orderID);
                addressList.put(eKey, list);
            } else {
                HashSet<Integer> values = new HashSet<Integer>();
                values.add(orderID);
                addressList.put(aKey, values);
            }
        }

        fraudList = new int[fraudID.size()];
        int i = 0;
        for (int x : fraudID) {
            fraudList[i++] = x;
        }
        quickSort(0, fraudList.length-1);

        for (int j = 0; j < fraudList.length; j++) {
            if (j == 0)
                System.out.print(fraudList[j]);
            else
                System.out.print("," + fraudList[j]);
        }
    }

    private static String stripEmail(String email) {
        int at = email.indexOf("@");
        String forward = email.substring(0, at);
        forward = forward.replaceAll("[.]", "");
        int plus = forward.indexOf("+");
        if (plus >= 0) {
            forward = forward.substring(0, plus);
        }

        String result = forward + email.substring(at);
        return result;
    }

    private static String stripAddress(String[] list) {
        String street = list[3];
        String city = list[4];
        String state = list[5];
        String zip = list[6];

        street = street.replace("street", "st.");
        street = street.replace("road", "rd.");
        if (state.equals("illinois")) {
            state = "IL";
        } else if (state.equals("california")) {
            state = "CA";
        } else if (state.equals("new york")) {
            state = "NY";
        }

        zip = zip.replaceAll("-", "");

        return street + ", " + city + ", " + state + " " + zip;
    }

    public static void quickSort(int start, int end) {
        if (end <= start)
            return;

        int pivot = start + (end - start)/2;
        int result = sortAndSplit(start, end, pivot);

        quickSort(start, result-1);
        quickSort(result + 1, end);
    }

    public static int sortAndSplit(int start, int end, int split) {
        int pivot = fraudList[split];
        swap(end, split);

        int front = start;
        for (int i = start; i < end; i++) {
            if (fraudList[i] < pivot) {
                swap(i, front);
                front++;
            }
        }
        swap (front, end);
        return front;
    }

    public static void swap (int x, int y) {
        int a = fraudList[x];
        fraudList[x] = fraudList[y];
        fraudList[y] = a;
    }
}
