#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv){

    if(argc <= 0){
        printf("Input must be a positive integer");
        exit(1);
    }

    int instance;
    int numElements;
    scanf("%d\n", &instance);
    scanf("%d\n", &numElements);

    for(int i = 0; i < instance; i++){
        int elements[numElements];
        for(int j = 0; j < numElements; j++){
            elements[j] = malloc(sizeof(int));
            scanf("%i", elements[j]), stdin;
            //elements[j] = stdin;
            //fgets(elements[j], sizeof(int)+1, stdin);
            
        }
        for(int j = 0; j < numElements; j++){
            printf("Index: %d Value: %d\n", j, elements[i]);
        }
    }
}