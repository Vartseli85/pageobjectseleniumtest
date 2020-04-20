import java.util.ArrayList;
import java.util.List;

public class Result {

    public static List<Integer> OddNumbers(int a, int b) {
        List<Integer> array1 = new ArrayList<>();
        List<Integer> array2 = new ArrayList<>();
        for (int i = a; i < b+1; i++) {  //Initialization array1 All digits from a to b
            array1.add(i);
        }
        for(int t:array1){
            if(t%2!=0){
                array2.add(t);            //Initialization array2 Only ODD digits
            }
        }
        return array2;
    }

    public static void main(String[] args) {
       List<Integer> list = OddNumbers(3, 13);



                for(int r:list){
                    System.out.println(r);
                }

    }
}