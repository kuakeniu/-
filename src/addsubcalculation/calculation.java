package addsubcalculation;

import java.util.List;

public class calculation {
    public static int[][] cal(int[][] a, int n, int[] userlist) {
        int i = 0;
        for (var ul : userlist) {
            if (ul == a[i][3]) {
                a[i][4] = 1;
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
