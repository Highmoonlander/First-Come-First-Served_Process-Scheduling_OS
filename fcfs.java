#include <stdio.h>

void sort(int* at, int* bt, int* p,int n) {
    int temp;
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (at[i] > at[j]) {
                temp = at[i];
                at[i] = at[j];
                at[j] = temp;

                temp = bt[i];
                bt[i] = bt[j];
                bt[j] = temp;

                temp = p[i];
                p[i] = p[j];
                p[j] = temp;
            }
        }
    }
}

int main() {
    int n, i;
    float avg_tat = 0, avg_wt = 0;
    printf("Enter the number of processes: ");
    scanf("%d", &n);
    int at[n], bt[n], ct[n], tat[n], wt[n];
    for (i = 0; i < n; i++) {
        printf("Enter arrival time and burst time for process %d: ", i + 1);
        scanf("%d %d", &at[i], &bt[i]);
    }
    int currentTime = 0;
    int p[n];
    for (i = 0; i < n; i++) {
        p[i] = i + 1;
    }
    sort(at, bt, p,n);
    for (i = 0; i < n; i++) {
        if (at[i] <= currentTime) {
            wt[i] = currentTime - at[i];
            currentTime += bt[i];
            ct[i] = currentTime;
            tat[i] = ct[i] - at[i];
        } else {
            currentTime++;
            i--;
        }
    }
    printf("\nProcess\tArrival Time\tBurst Time\tCompletion Time\tTurnaround Time\tWaiting Time\n");
    for (i = 0; i < n; i++) {
        printf("%d\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n", p[i], at[i], bt[i], ct[i], tat[i], wt[i]);
        avg_tat += tat[i];
        avg_wt += wt[i];
    }
    avg_tat /= n;
    avg_wt /= n;
    printf("Average Turnaround Time: %.2f\n", avg_tat);
    printf("Average Waiting Time: %.2f\n", avg_wt);
    return 0;
}
