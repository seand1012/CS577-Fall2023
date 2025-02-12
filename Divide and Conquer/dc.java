import java.util.*;

public class dc {
    private static int instances;
    private static int numEles;
    private static long inversions;

    public dc() {
        instances = 0;
        numEles = 0;
        inversions = 0;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        instances = scan.nextInt();
        
        for(int i = 0; i < instances; i++){
            numEles = scan.nextInt();
            for(int j = 0; j < numEles; j++){
                if(scan.hasNext()){
                    list.add(scan.nextInt());
                }
            }
            mergeSort(list);
            System.out.println(inversions);
            inversions = 0;
            list.clear();
        }
        scan.close();
    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> arr){
        // 
        int mid = arr.size()/2;
        ArrayList<Integer> firstHalf = new ArrayList<>();
        ArrayList<Integer> secondHalf = new ArrayList<>();
        if(arr.size() == 1)
            return arr;
        for(int i = 0; i < mid; i++){
            firstHalf.add(arr.get(i));
        }
        
        for(int i = mid; i < arr.size(); i++){
            secondHalf.add(arr.get(i));
        }
      
        firstHalf = mergeSort(firstHalf);
        secondHalf = mergeSort(secondHalf);
        

        return merge(firstHalf, secondHalf);
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
        ArrayList<Integer> sorted = new ArrayList<>();
        while(!arr1.isEmpty() || !arr2.isEmpty()){
            if(arr1.isEmpty()){
                sorted.addAll(arr2);
                arr2.clear();
            }
            else if(arr2.isEmpty()){
                sorted.addAll(arr1);
                arr1.clear();
            }
            else{
                int a = Math.min(arr1.get(0), arr2.get(0));
                sorted.add(a);
                // if min is from the first half, in order
                // if min is from the second half, inversion
                if(a == arr1.get(0)){
                    arr1.remove(0);
                }
                else{
                    arr2.remove(0);
                    inversions += arr1.size();
                }
            }
            
        }

        //System.out.println(sorted.toString());
        
        return sorted;
    }

    
}
