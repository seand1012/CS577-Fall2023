#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv){

    if(argc <= 0){
        printf("Input must be a positive integer");
        exit(1);
    }

    int instances;
    int numPages; // number of pages in cache
    int numReqs; // number of requests per page
    int numPageFaults;
    int pageFaults; // counts number of page faults for each instance
    

    // loop through and find the indices for each number in the instande
    // store indices for each number in their own pq
    // hashmap, key = number in the cache, value = priority queue

    scanf("%d\n", &instances);

    for(int i = 0; i < instances; i++){
        scanf("%d\n", &numPages);
        scanf("%d\n", &numReqs);
        int *reqSequence[numReqs];
        int* pages[numPages];

        for(int j = 0; j < numReqs; j++){
            reqSequence[j] = malloc(256*sizeof(int));
            scanf("%d", reqSequence[j]);
           //TESTING PURPOSES printf("%d at index %i, ",  *reqSequence[j], j);
        }
        //TESTING PURPOSES printf("\n");

        for(int j = 0; j < numReqs; j++){
            // create a cache
            pages[j] = malloc(256 * sizeof(int));
            if(pages[j] == NULL){
                pages[j] = reqSequence[j];
                pageFaults++;
            }
            // 
            else{

            }
        }
        printf("%i\n", pageFaults);
        free(reqSequence);
        free(pages);
    }

}