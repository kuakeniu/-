package check;

import bean.Formula;

public class CheckAns {
    public static Formula[] cal(Formula[] a, int n, int[] userlist) {
        int i = 0;
        for (int ul : userlist) {
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
