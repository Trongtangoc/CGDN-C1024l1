public class demoArray {
    public static void main(String[] args) {
        //Khai bao Array elementType[] arrayName
        // or elementType arrayName[]
        double[] myList;
        double myList2[];
        /* Khoi tao Array
           arrayName = new elementType[arraySize];*/
        double[] myList3 = new double[10];
        double myList4[] = new double[10];
        //Duyet Mang
        int[] myList5 = {1,3,5,7,9};
        for(int i = 0; i<myList5.length; i++) {
            System.out.println(myList5[i]);
        }
        for(int a:myList5) {
            System.out.println(a);
        }
        //Arrray two way

    }
}
