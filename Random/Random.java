import java.util.*;

public class Random {
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int numVars = scan.nextInt();
        int clauses = scan.nextInt();
        String output = "";

        for(int i = 0; i < clauses; i++){
            int x1 = scan.nextInt();
            int x2 = scan.nextInt();
            int x3 = scan.nextInt();

            if(x1 < 0 && x2 < 0 && x3 < 0){
                output += "-1 ";
            }
            else
                output += "1 ";
        }
        output = output.strip();
        System.out.println(output + " " + output);
        scan.close();
    }
}
