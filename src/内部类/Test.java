package 内部类;

/**
 * Created by 宫成 on 2019/5/23.
 */
public class Test {
    @org.junit.Test
    public void main() {
        Outer.Inner oi = new Outer().new Inner();
        oi.show();

    }

}

class Outer {
    public int num = 10;

    class Inner {
        public int num = 20;

        public void show() {
            int num = 30;
            System.out.println(num);    //填入合适的代码
            System.out.println(this.num);
            System.out.println(Outer.this.num);
        }
    }
}

class SingleTon {
    private SingleTon() {
    }

    public static SingleTon getInstance() {
        return Holder.singleTon;
    }

    private static class Holder {
        public static SingleTon singleTon = new SingleTon();
    }

}