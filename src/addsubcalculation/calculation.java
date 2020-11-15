package addsubcalculation;

import java.util.List;

public class calculation {
    public static int[][] cal(int a[][], int n, List<Integer> userlist) {
        int num=0;
        int i = 0;
        for (Integer ul : userlist) {
            if (ul == a[i][3]) {
                a[i][4] = 1;
                num++;
                i++;
            }
            else {
                a[i][4] = 0;
                i++;
            }
        }
        return a;
    }
}
