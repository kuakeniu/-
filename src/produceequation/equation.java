package produceequation;

public class equation {
    public static int[] getrandomnumber(){
        int a[]=new int[3];
        a[0]=(int)(Math.random()*2+1);
        if(a[0]==1){                   //a[0]存储操作数，1代表加号，2代表减号，a[1]和a[2]存储数值
            a[1]=(int)(Math.random()*101);
            a[2]=(int)(Math.random()*(101-a[1]));
            return a;
        }
        else {
            a[1]=(int)(Math.random()*101);
            a[2]=(int)(Math.random()*(a[0]+1));
            return a;
        }
    }
}
