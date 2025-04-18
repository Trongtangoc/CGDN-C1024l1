public class Method {
    public static void main(String[] args) {
        //Method in java
        System.out.println("Sum from 1 to 10 is " + sum(1, 10));
        System.out.println("Sum from 20 to 37 is " + sum(20, 37));
        System.out.println("Sum from 35 to 49 is " + sum(35, 49));
    }
    //sum la mot phuong thuc trong java giup cho code co the tai su dung
    public static int sum(int i1, int i2) {
        int result = 0;
        for (int i = i1; i <= i2; i++)
            result += i;
        return result;
    }
    //Dinh Nghia method
    //modifier returnValueType methodName(list of parameters) {
    //    Method body;
    //}
}
