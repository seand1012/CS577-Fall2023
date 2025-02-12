//package CS 577.Greedy;
import java.util.*;
//import java.util.Comparator;


class CustomComparator implements Comparator<int[]>{
    @Override
    public int compare(int[] obj1, int[] obj2){
        // if end time of the first row is less than
        // end time of the second row
        if(obj1[1] < obj2[1]){
            return -1;
        }
        // if end time of the first row is greater than
        // end time of the second row
        else if(obj1[1] > obj2[1]){
            return 1;
        }

        return 0;
    }
}

public class Greedy {
   // private static ArrayList<Integer> start = new ArrayList<>();
    //private static ArrayList<Integer> end = new ArrayList<>();

   
     
    public static void main (String[] args){
        
        Scanner scan = new Scanner(System.in);
        
        int numInstances = 0;
        
        // get the number of instances
        if(scan.hasNextInt()){
            numInstances = Integer.parseInt(scan.nextLine());
        }
        else{
            System.out.println("Invalid input");
            System.exit(1);
        }


        // for each instance...
        for(int i = 0; i < numInstances; i++){
            // Holds jobs with index 0 = start time, index 1 = finish time
            ArrayList<int[]> jobs = new ArrayList<>();
            // number of jobs done, will be printed
            int output = 0;
            // gets number of jobs
            int numJobs = scan.nextInt();
            // updating variable of latest job completion
            int latest = -10000;
            // 2D array, n # of rows, 2 columns
            int arr [][] = new int[numJobs][2];
            

            for(int j = 0; j < numJobs; j++){
                // add start time
                arr[j][0] = scan.nextInt();
                // add finish time
                arr[j][1] = scan.nextInt();
                jobs.add(arr[j]);   
            }
            
            // sort list of jobs by finish time
            Collections.sort(jobs, new CustomComparator());
            for(int k = 0; k < jobs.size(); k++){
                // if this job's start time is later
                // than the most recently updated finish time
                if(jobs.get(k)[0] >= latest){
                    // update latest with this job's finish time
                    latest = jobs.get(k)[1];
                    output++;
                }
            }
            // print output for each line
            System.out.println(output);
        }

        scan.close();
    }

   
}
