import java.util.*;

class Pair {

    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

   @Override
   public String toString(){
        return "(" + x + "," + y +")";
   }

}

class SortPairs{
    static void sortX(ArrayList<Pair> arr){

        Comparator<Pair> comp = new Comparator<>(){

            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.getX()-o2.getX();
            }
        };

        arr.sort(comp);
    }
}

public class LineInter {
    private static long intersections;
    
    public LineInter() {
        intersections = 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> top = new ArrayList<>();
        ArrayList<Integer> bottom = new ArrayList<>();
        ArrayList<Pair> pairs = new ArrayList<>();
        ArrayList<Integer> yVals = new ArrayList<>();

        long instances = 0;
        long n = 0;

        instances = scan.nextLong();

        for(long i = 0; i < instances; i++){
            n = scan.nextLong();
            for(long j = 0; j < n; j++){
                top.add(scan.nextInt());
            }
            for(long j = 0; j < n; j++){
                bottom.add(scan.nextInt());
            }

            for(int j = 0; j < top.size(); j++){
                Pair p = new Pair(top.get(j), bottom.get(j));
                pairs.add(p);
            }
            SortPairs.sortX(pairs);

            for(int j = 0; j < pairs.size(); j++){
                yVals.add(pairs.get(j).getY());
            }
            
            mergeSort(yVals);
            System.out.println(intersections);

            top.clear();
            bottom.clear();
            pairs.clear();
            yVals.clear();
            intersections = 0;
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
        

        return findIntersections(firstHalf, secondHalf);
    }

    /**
     * Counts intersections the same way you count inversions
     * @param top
     * @param bottom
     */
    public static ArrayList<Integer> findIntersections(ArrayList<Integer> arr1, ArrayList<Integer> arr2){

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
                    intersections += arr1.size();
                }
            }
        }        
       return sorted;
    }
}
