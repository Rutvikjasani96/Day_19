import java.util.HashMap;
import java.util.HashSet;

public class Question_2 {
//    given n array elements calculate no. of distinct elements in every subarray of size k
    public static void main(String[] args) {
        int[] array = {2, 4, 3, 8, 3, 9, 4, 9, 4, 10};
        int k=4;
//        distinctSubarrayUsingHashset(array,k);
        distinctSubarrayUsingHashmap(array,k);
    }
    static void distinctSubarrayUsingHashset(int[] array, int k){
        for(int i=0;i<= array.length-k;i++){
            HashSet<Integer> hs = new HashSet<>();
            for(int j=i;j<i+k;j++){
                hs.add(array[j]);
            }
            System.out.println("distinct element between array["+i+"..."+(i+k-1)+"] : "+hs.size());
        }
    }
    static void distinctSubarrayUsingHashmap(int[] array, int k){
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<k;i++){
            if(hm.containsKey(array[i])){
                hm.put(array[i], hm.get(array[i])+1);
            }else {
                hm.put(array[i], 1);
            }
        }
        System.out.println("distinct element between array[0...3] : "+hm.size());
        for(int i=k;i< array.length;i++){
            hm.put(array[i-k], hm.get(array[i-k])-1);
            if(hm.get(array[i-k])==0){
                hm.remove(array[i-k]);
            }
            if(hm.containsKey(array[i])){
                hm.put(array[i], hm.get(array[i])+1);
            }else{
                hm.put(array[i], 1);
            }
            System.out.println("distinct element between array["+(i-k+1)+"..."+i+"] : "+hm.size());
        }
    }
}
