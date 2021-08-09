import jdk.swing.interop.SwingInterOpUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Hanoi {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(4,3));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(1));
        ArrayList<Integer> c = new ArrayList<>(Arrays.asList(2));
        towerHanoi(a,b,c);
    }
    public static void towerHanoi(ArrayList<Integer> a, ArrayList<Integer> b,ArrayList<Integer> c){
        // Print initial state
        towerPrint(a,b,c);
        // Instance varaibles
        int move1;
        int move2;
        int n = a.size() + b.size() + c.size();
        ArrayList<Integer> support1 = new ArrayList<>();
        ArrayList<Integer> support2 = new ArrayList<>();
        if (n % 2 == 0){
            support2 = c;
            support1 = b;
        }
        else {
            support2 = b;
            support1 = c;
        }
        int support1Size = support1.size()-1;
        int support2Size = support2.size()-1;

        // Base case
        if (c.size() == n){
            return;
        }

        // Begin scenario
        if (a.size() == n){
            move1 = a.remove(a.size()-1);
            move2 = a.remove(a.size()-1);
            support1.add(move1);
            support2.add(move2);
            towerPrint(a,b,c);
            return;
        }

        // Body code
        // Priority #1 - Move largest number to new base position
        if (a.get(a.size()-1) == n && support1Size == 0 || support2Size == 0){
            if (support1Size == 0){
                move1 = a.remove(a.size()-1);
                support1.add(move1);
            }
            else {
                move1 = a.remove(a.size()-1);
                support2.add(move1);
            }
        }
        // Priority #2 - Move smallest number to top of largest block



        return;
    }


    public static void towerPrint(ArrayList<Integer> a, ArrayList<Integer> b,ArrayList<Integer> c){
        String myString = "";
        String apos = " ";
        String bpos = " ";
        String cpos = " ";
        for (int i = 3; i >= 0;i--){
            if (a.size() > i){
                apos = Integer.toString(a.get(i));
            }
            if (b.size() > i){
                bpos = Integer.toString(b.get(i));
            }
            if (c.size() > i){
                cpos = Integer.toString(c.get(i));
            }
            myString += " " + apos + "    " + bpos + "    " + cpos + "\n";
        }
        myString += "---  ---  ---";
        myString += "\n";
        System.out.println(myString);
    }
}
