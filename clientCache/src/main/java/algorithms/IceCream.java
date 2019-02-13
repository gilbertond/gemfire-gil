package algorithms;

import java.util.Hashtable;
import java.util.Map;

public class IceCream {
    static int BILL_5 = 5;
    static int BILL_10 = 10;
    static int BILL_20 = 20;

    static Map<Integer, Integer> change = new Hashtable<>();

    static {
        change.put(BILL_5, 0);
        change.put(BILL_10, 0);
        change.put(BILL_20, 0);
    }

    public static void main(String[] a) {
        int[] clients = {5, 10, 10, 20};
        int cost = 5;


        System.out.println(serveClient(clients, cost));

    }

    static boolean serveClient(int[] clients, int cost) {
        if (clients == null || clients.length == 0) return false;

        if (cost == 0) return false;

        for (int index = 0; index < clients.length; index++) {
            if (change.isEmpty() && clients[index] > BILL_5) return false;

            //Add 5 change
            if (clients[index] == BILL_5) {
                change.put(BILL_5, change.get(BILL_5) + BILL_5);
                continue;
            }

            //If 10 bill but no 5 change
            if (clients[index] == BILL_10) {
                if (((change.get(BILL_5) - BILL_5) < 0)) {
                    return false;
                }

                change.put(BILL_5, change.get(BILL_5) - BILL_5);
                change.put(BILL_10, change.get(BILL_10) + BILL_10);

                continue;
            }

            if (clients[index] == BILL_20) {
                int change10s = change.get(BILL_10);
                int change5s = change.get(BILL_5);
                int balance = BILL_20 - change.get(BILL_5);

                balance = balance - change10s;
                if (balance > 0) {
                    balance = balance - change5s;
                }

                if (balance > 0) return false;

            }
        }

        return true;
    }
}
