import java.util.*;
import java.util.Scanner;


public class paging {
    
    public static void main(String[] args){
        page();

    }

    private static void page(){
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> reqSeq = new ArrayList<>();
        
        
        int instances = scan.nextInt();
        int pages = 0;
        int numReqs = 0;
        int faults = 0;
        for(int i = 0; i < instances; i++){

            int indexOfVTE = 0; // index IN THE CACHE of the value to evict

            pages = scan.nextInt();
            numReqs = scan.nextInt();
            
            HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();

            // get all values of the request sequence
            for(int j = 0; j < numReqs; j++){
                reqSeq.add(scan.nextInt());
               // System.out.println(reqSeq.get(j));
            }

            for(int j = 0; j < reqSeq.size(); j++){
                // get each number in the cache
                int temp = reqSeq.get(j);
                LinkedList<Integer> indices = new LinkedList<>();

                // find each instance of each number
                for(int k = 1; k < reqSeq.size(); k++){
                    // if there is another instance of this number...
                    if(temp == reqSeq.get(k)){
                        // ...add this index to the LinkedList
                        indices.add(k);
                    }

                }
                
                map.put(temp, indices);
            }
            ArrayList<Integer> cache = new ArrayList<>();
            for(int j = 0; j < reqSeq.size(); j++){
                boolean found = false;
                int curr = reqSeq.get(j);
                if(!map.get(curr).isEmpty())
                    map.get(curr).removeFirst();
                int furthest = 0; // the index in req seq of the number we should evict from the cache
                
                
                // put elements in the cache
                // if there are still pages empty...
                if(cache.size() < pages){
                    if(!cache.contains(curr)){
                        // ...add to the cache
                       // System.out.println("Index: " + j + " Value: " + curr);
                        cache.add(curr);
                        
                        faults++; // inserting to empty cache is a page fault
                   }
                   
                }
                // otherwise, check if there's a page fault
                else{
                    // go through cache
                    // cache.get(k) = number in cache
                    // map.get(cache.get(k)) = LinkedList for that number in cache
                    
                    for(int k = 0; k < cache.size(); k++){
                        LinkedList<Integer> tempList = new LinkedList<>();
                        // if number is already in cache, no page fault
                        if(cache.contains(curr)){
                            //System.out.println("Curr: " + curr);
                            found = true;
                            
                            break;
                        }
                        else{
                            //indexOfVTE = k;
                            // store the k-th element's linked list
                            tempList = map.get(cache.get(k));
                           
                            if(tempList.size() == 0){
                                indexOfVTE = k;
                                furthest = -1;
                            }
                            else if(furthest >= 0 && furthest < tempList.getFirst()){
                                 // gets the furthest index of the numbjer
                                 //System.out.println(k); 
                                indexOfVTE = k;
                                 //System.out.println(indexOfVTE);
                                furthest = tempList.getFirst();
                                tempList.removeFirst();
                            }
                        }
                        
                        
                    }
                    
                    //System.out.println("Out of loop: " +indexOfVTE);
                    for(int p = 0; p < cache.size(); p++){
                       //System.out.println("Before. Index = " + p + " Value = " +cache.get(p));
                    }
                    if(found == false){
                       faults++;
                        cache.set(indexOfVTE, curr);
                    }

                    for(int p = 0; p < cache.size(); p++){
                       // System.out.println("After. Index = " + p + " Value = " +cache.get(p));
                    }
                    
                }
                
            }
            
            System.out.println(faults);
            cache.clear();
            faults = 0;
        }
        scan.close();
    }
}
