#include <stdio.h>
#define INFINITY 9999
#define MAX 10
void dijkstra(int graph[MAX][MAX], int num_vertices, int start_node) {
    int cost[MAX][MAX];        
    int distance[MAX];        
    int pred[MAX];             
    int visited[MAX];          
    int count, mindistance, next_node, i, j;
    for (i = 0; i < num_vertices; i++) {
        for (j = 0; j < num_vertices; j++) {
            if (graph[i][j] == 0 && i != j)
                cost[i][j] = INFINITY;
            else
                cost[i][j] = graph[i][j];}}
    for (i = 0; i < num_vertices; i++) {
        distance[i] = cost[start_node][i];
        pred[i] = start_node;
        visited[i] = 0;}
    distance[start_node] = 0;  
    visited[start_node] = 1;  
    count = 1;                
    while (count < num_vertices - 1) {
        mindistance = INFINITY;
        for (i = 0; i < num_vertices; i++) {
            if (distance[i] < mindistance && !visited[i]) {
                mindistance = distance[i];
                next_node = i;}}
        visited[next_node] = 1; 
        for (i = 0; i < num_vertices; i++) {
            if (!visited[i]) {
                if (mindistance + cost[next_node][i] < distance[i]) {
                    distance[i] = mindistance + cost[next_node][i];
                    pred[i] = next_node;}}}
        count++;}
    for (i = 0; i < num_vertices; i++) {
        if (i != start_node) {
            printf("\nDistance from node %d to node %d = %d", start_node, i, distance[i]);
            printf("\nPath = %d", i);
            j = i;
            while (j != start_node) {
                j = pred[j];
                printf(" <- %d", j);}
            printf("\n");}}}
int main() {
    int graph[MAX][MAX], num_vertices, start_node, i, j;
    printf("Enter the number of vertices: ");
    scanf("%d", &num_vertices);
    printf("Enter the adjacency matrix (use 0 for no direct path):\n");
    for (i = 0; i < num_vertices; i++) {
        for (j = 0; j < num_vertices; j++) {
            scanf("%d", &graph[i][j]);}}
    printf("Enter the starting node: ");
    scanf("%d", &start_node);
    dijkstra(graph, num_vertices, start_node);
    return 0;}
