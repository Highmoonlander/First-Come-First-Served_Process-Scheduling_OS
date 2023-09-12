import java.util.Scanner;

public class Main {
    public static void sort(int[] s_at, int[] s_bt, int n) {
        int temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (s_at[i] > s_at[j]) {
                    temp = s_at[i];
                    s_at[i] = s_at[j];
                    s_at[j] = temp;

                    temp = s_bt[i];
                    s_bt[i] = s_bt[j];
                    s_bt[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, i;
        float avg_tat = 0, avg_wt = 0;
        System.out.print("Enter the number of processes: ");
        n = scanner.nextInt();
        int[] at = new int[n];
        int[] bt = new int[n];
        int[] ct = new int[n];
        int[] tat = new int[n];
        int[] wt = new int[n];
        for (i = 0; i < n; i++) {
            System.out.printf("Enter arrival time and burst time for process %d: ", i + 1);
            at[i] = scanner.nextInt();
            bt[i] = scanner.nextInt();
        }
        int currentTime = 0;
        int[] s_at = new int[n];
        int[] s_bt = new int[n];
        for (i = 0; i < n; i++) {
            s_at[i] = at[i];
            s_bt[i] = bt[i];
        }
        sort(s_at, s_bt, n);
        for (i = 0; i < n; i++) {
            if (s_at[i] <= currentTime) {
                wt[i] = currentTime - s_at[i];
                currentTime += s_bt[i];
                ct[i] = currentTime;
                tat[i] = ct[i] - at[i];
            } else {
                currentTime++;
                i--;
            }
        }
        System.out.println("\nProcess\tArrival Time\tBurst Time\tCompletion Time\tTurnaround Time\tWaiting Time");
        for (i = 0; i < n; i++) {
            System.out.printf("%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n", i + 1, at[i], bt[i], ct[i], tat[i], wt[i]);
            avg_tat += tat[i];
            avg_wt += wt[i];
        }
        avg_tat /= n;
        avg_wt /= n;
        System.out.printf("Average Turnaround Time: %.2f\n", avg_tat);
        System.out.printf("Average Waiting Time: %.2f\n", avg_wt);
    }
}
