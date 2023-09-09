import java.util.Scanner;

public class FCFS {
    static final int MAX = 10;

    public static void fcfs(int n, int[] at, int[] bt) {
        int[] waitingTime = new int[MAX];
        int[] turnAroundTime = new int[MAX];
        int[] temp = new int[MAX];
        temp[0] = 0;
        double awt = 0, atat = 0;

        System.out.println("Processes\tArrivalTime\tBurstTime\tWaitingTime\tTAT");
        for (int i = 0; i < n; i++) {
            waitingTime[i] = 0;
            turnAroundTime[i] = 0;
            temp[i + 1] = temp[i] + bt[i];
            waitingTime[i] = temp[i] - at[i];
            turnAroundTime[i] = waitingTime[i] + bt[i];
            System.out.println((i + 1) + "\t\t" + at[i] + "\t\t" + bt[i] + "\t\t" + waitingTime[i] + "\t\t" + turnAroundTime[i]);
            awt = awt + waitingTime[i];
            atat = atat + turnAroundTime[i];
        }
        System.out.println("\nAverage waiting time = " + awt / n);
        System.out.println("Average Turn Around time = " + atat / n);
    }

    public static void main(String[] args) {
        int n;
        int[] arrivalTime = new int[MAX];
        int[] burstTime = new int[MAX];

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number of processes: ");
        n = sc.nextInt();

        System.out.print("Enter the arrival Time of all processes: ");
        for (int i = 0; i < n; i++) {
            arrivalTime[i] = sc.nextInt();
        }

        System.out.print("Enter the burst time of all processes: ");
        for (int i = 0; i < n; i++) {
            burstTime[i] = sc.nextInt();
        }

        fcfs(n, arrivalTime, burstTime);
    }
}
