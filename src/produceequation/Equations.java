package produceequation;

import bean.Formula;

public class Equations {
    public static Formula getrandomnumber(){
        int a, b, op;
        op=(int)(Math.random()*2+1);
        if(op==1){                   //a[0]存储操作数，1代表加号，2代表减号，a[1]和a[2]存储数值
            a=(int)(Math.random()*101);
            b=(int)(Math.random()*(101-a));
        }
        else {
            a=(int)(Math.random()*101);
            b=(int)(Math.random()*(a+1));
        }
        return new Formula(op, a, b);
    }
}
