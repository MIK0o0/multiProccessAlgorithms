package Comparators;

import com.company.Call;

import java.util.Comparator;

public class arrivalComparator implements Comparator<Call> {
    @Override
    public int compare(Call p1, Call p2) {
        int tym = p1.getArrivalTime() - p2.getArrivalTime();
        if (tym == 0){
            return 0;
        }else if (tym > 0){
            return 1;
        }else {
            return -1;
        }
    }
}
