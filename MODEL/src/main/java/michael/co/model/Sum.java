package michael.co.model;

import android.widget.Toast;

import java.util.ArrayList;

public class Sum {
    private final ArrayList<Integer> arrayListNumbers;

    public Sum(){
        /*empty space*/
        arrayListNumbers = new ArrayList<Integer>();
    }

    public void insert(int number){
        arrayListNumbers.add(number);
    }

    public void deletePrevious(){
        if (!arrayListNumbers.isEmpty())
            arrayListNumbers.remove(arrayListNumbers.size() - 1);
    }

    public boolean isEmpty(){
        return arrayListNumbers.isEmpty();
    }

    public int getSum(){
        int sum = 0;
        for (int number:
             arrayListNumbers) {
            sum += number;
        }
        return sum;
    }
}
