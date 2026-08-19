package Babylon;

public class GasStation {

    static void main() {
        GasStation s = new GasStation();
        System.out.println(s.canCompleteCircuit(new int [] {1,2,3,4,5}, new int [] {3,4,5,1,2}));
//        System.out.println(s.canCompleteCircuit(new int [] {2,3,4}, new int [] {3,4,3}));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            tank += gas[i] - cost[i];

            if (tank < 0) {
                tank = 0;
                start = i + 1;
            }
        }
        return total >=0 ? start : -1;
    }
}
