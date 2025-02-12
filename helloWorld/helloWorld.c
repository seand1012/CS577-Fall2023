#include <stdio.h>
#include <stdlib.h>
//#include "Makefile"

int main(int argc, char **argv){

    if(argc <= 0){
        printf("Input must be a positive integer");
        exit(1);
    }

    int amt;
    scanf("%d\n", &amt);
    
    // pointer to an array of chars
    char *str[amt];

    for(int i = 0; i < amt; i++){
        //malloc array 
        str[i] = malloc(256 * sizeof(char));
        //read input into array at each index
        fgets(str[i], sizeof(str)+1, stdin);
    }

    for(int i = 0; i < amt; i++){
        printf("Hello, %s!\n", str[i]);
    }
    return 0;
}