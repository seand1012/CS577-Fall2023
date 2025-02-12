#include <stdlib.h>
#include <stdio.h>

/**
 * Recursive function that searches the graph
 * Using DFS
 * @param n: size of graph
 * */
void dfs(int n){
    char** visited;
    for(int i = 0; i < n; i++){
        visited[i] = malloc(256 * sizeof(char));
    }
    
}

int main(int argc, char** argv){
    int t; // # of instances
    int n; // # of nodes per instance

    if(argc <= 0){
        printf("Input must be a positive integer");
        exit(1);
    }
    
    // get # of instances
    scanf("%d\n", &t);

    //pointer to a pointer of chars (instances)
    char *instances[t];

    for(int i = 0; i < t; i++){
        instances[i] = malloc(256 * sizeof(char));
        scanf("%c\n", instances[i]);
        //printf("%s and %d\n", instances[i], i);
    }




}