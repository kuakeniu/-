package bean;

import java.util.Objects;

public class Formula {
    //存储操作数，1代表加号，2代表减号
    private char op;
    // 数
    private int a;
    private int b;
    //对错
    private boolean userCheck;
    //答案
    private int ans;
    private int userAns;
    public Formula(int op, int a, int b) {
        setOp(op);
        this.a = a;
        this.b = b;
    }

    public int getOp() {
        if (op == '+') {
            return 1;
        } else {
            return 2;
        }
    }

    public void setOp(int op) {
        if (op == 1) {
            this.op = '+';
        } else {
            this.op = '-';
        }
    }

    public int getUserAns(){
        return userAns;
    }

    public void setUserAns(int userAns) {
        this.userAns = userAns;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public boolean isUserCheck() {
        return userCheck;
    }

    public void setUserCheck(boolean userCheck) {
        this.userCheck = userCheck;
    }

    public int getAns() {
        return ans;
    }

    public void setAns(int ans) {
        this.ans = ans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formula formula = (Formula) o;
        return op == formula.op &&
                a == formula.a &&
                b == formula.b &&
                userCheck == formula.userCheck &&
                ans == formula.ans;
    }

    @Override
    public int hashCode() {
        return Objects.hash(op, a, b, userCheck, ans);
    }
}
