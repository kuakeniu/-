package addsubcalculation;

import bean.Formula;

import java.util.List;

public class Calculations {
    public static Formula[] cal(Formula[] a, int n, int[] userlist) {
        int i = 0;
        for (var ul : userlist) {
            if (ul == a[i].getAns()) {
                a[i].setUserCheck(true);
                i++;
            }
            else {
                a[i].setUserCheck(false);
                i++;
            }
        }
        return a;
    }
}
