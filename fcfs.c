#include<stdio.h>
#include<stdlib.h>
#define max 10

void fcfs(int,int[],int[]);

void fcfs(int n,int at[],int bt[]){
    int waitingTime[max],turnArroundTime[max],temp[max];
    temp[0] = 0;
    double awt = 0,atat = 0;
    system("clear");
    printf("Processes\tArrivalTime\tBurstTime\tWaitingTime\tTAT\n");
    for(int i = 0;i < n;i++){
        waitingTime[i] = 0;
        turnArroundTime[i] = 0;
        temp[i + 1] = temp[i] + bt[i];
        waitingTime[i] = temp[i] - at[i];
        turnArroundTime[i] = waitingTime[i] + bt[i];
        printf("%d\t\t%d\t\t%d\t\t%d\t\t%d\n",i + 1,at[i],bt[i],waitingTime[i],turnArroundTime[i]);
        awt = awt + waitingTime[i];
        atat = atat + turnArroundTime[i];
    }
    printf("\nAverage waiting time = %f",awt/n);
    printf("\nAverage Turn Around time = %f",atat/n);
}

int main(){
    int n,arrivalTime[max],burstTime[max];
    printf("Enter the Number of processes: ");
    scanf("%d",&n);
    printf("Enter the arrival Time of all processes: ");
    for(int i = 0;i < n;i++){
        scanf("%d",&arrivalTime[i]);
    }
    printf("Enter the burst time of all processes: ");
    for(int i = 0;i < n;i++){
        scanf("%d",&burstTime[i]);
    }
    fcfs(n,arrivalTime,burstTime);
    return 0;
}