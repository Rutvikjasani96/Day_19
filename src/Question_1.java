import java.util.HashMap;
import java.util.HashSet;

public class Question_1 {
//    given n array elements, check if there exists a pair (i, j) such that
//    arr[i] + arr[j] = k & i != j. return true/false
    public static void main(String[] args) {
        int[] array = {8, 9, 1, -2, 4, 5, 11, -6, 7, 5};
        int k = 15;
//        boolean ans = isPairIndJUsingHashmap(array,k);
        boolean ans = isPairIndJUsingHashset(array,k);
        System.out.println("ans : "+ans);
    }
    static boolean isPairIndJUsingHashmap(int[] array, int k){
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i< array.length;i++){
            if(hm.containsKey(array[i])){
                hm.put(array[i], hm.get(array[i])+1);
            }else{
                hm.put(array[i], 1);
            }
        }
        for(int i=0;i<array.length;i++){
            int a = array[i];
            int b = k - a;
            if(a!=b && hm.containsKey(b)) {
                return true;
            }
            if(a==b && hm.get(array[i])>1){
                return true;
            }
        }
        return false;
    }
    static boolean isPairIndJUsingHashset(int[] array, int k){
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i< array.length;i++){
            int a = array[i];
            int b = k - a;
            if(hs.contains(b)){
                return true;
            }
            hs.add(array[i]);
        }
        return false;
    }
}
