package algo;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class pr {

    // --- Algorithm 5 (4.1): Heap Sort ---
    public static void heapSortAlgo(Scanner scanner) {
        System.out.println("\n==========================================");
        System.out.println("      >>> 4.1 HEAP SORT ALGORITHM <<<     ");
        System.out.println("==========================================");
        try {
            System.out.print(" Enter the number of elements (n): ");
            int n = Integer.parseInt(scanner.nextLine().trim());
            if (n <= 0) {
                System.out.println(" [!] Number of elements must be greater than 0.");
                return;
            }

            int[] heap = new int[n];
            System.out.println(" Enter " + n + " numbers:");
            for (int i = 0; i < n; i++) {
                System.out.print("   - Number " + (i + 1) + ": ");
                heap[i] = Integer.parseInt(scanner.nextLine().trim());
                siftUp(heap, i); 
            }

            System.out.print("\n [✓] Max-Heap array: ");
            printArray(heap, n);

            for (int i = n - 1; i > 0; i--) {
                int temp = heap[0];
                heap[0] = heap[i];
                heap[i] = temp;
                siftDown(heap, 0, i);
            }

            System.out.print(" [✓] Sorted array (Ascending): ");
            printArray(heap, n);
            System.out.println("------------------------------------------");

        } catch (NumberFormatException e) {
            System.out.println(" [X] Invalid input! Please enter valid integers.");
        }
    }

    private static void siftUp(int[] heap, int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap[parent] < heap[i]) {
                int temp = heap[parent];
                heap[parent] = heap[i];
                heap[i] = temp;
                i = parent;
            } else {
                break;
            }
        }
    }

    private static void siftDown(int[] heap, int i, int size) {
        int largest = i;
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < size && heap[left] > heap[largest]) {
                largest = left;
            }
            if (right < size && heap[right] > heap[largest]) {
                largest = right;
            }

            if (largest != i) {
                int temp = heap[i];
                heap[i] = heap[largest];
                heap[largest] = temp;
                i = largest;
            } else {
                break;
            }
        }
    }

    private static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // --- Algorithm 8 (5.7): Majority Element ---
    public static void majorityElementAlgo(Scanner scanner) {
        System.out.println("\n==========================================");
        System.out.println("   >>> 5.7 FINDING THE MAJORITY ELEMENT <<<");
        System.out.println("==========================================");
        try {
            System.out.print(" Enter the number of elements (n): ");
            int n = Integer.parseInt(scanner.nextLine().trim());
            if (n <= 0) {
                System.out.println(" [!] The number of elements must be greater than 0.");
                return;
            }

            int[] arr = new int[n];
            System.out.println(" Enter " + n + " numbers:");
            for (int i = 0; i < n; i++) {
                System.out.print("   - Number " + (i + 1) + ": ");
                arr[i] = Integer.parseInt(scanner.nextLine().trim());
            }

            Integer candidate = null;
            int count = 0;

            for (int num : arr) {
                if (count == 0) {
                    candidate = num;
                    count = 1;
                } else if (candidate != null && num == candidate) {
                    count++;
                } else {
                    count--;
                }
            }

            int verifyCount = 0;
            for (int num : arr) {
                if (candidate != null && num == candidate) {
                    verifyCount++;
                }
            }

            System.out.println("\n------------------------------------------");
            if (verifyCount > n / 2) {
                System.out.println(" [✓] Result -> Majority number: " + candidate);
            } else {
                System.out.println(" [✓] Result -> none");
            }
            System.out.println("------------------------------------------");

        } catch (NumberFormatException e) {
            System.out.println(" [X] Invalid input! Please enter valid integers.");
        }
    }

    // --- Algorithm 13 (7.5): Floyd's Algorithm ---
    public static void floydsAlgorithm(Scanner scanner) {
        System.out.println("\n==========================================");
        System.out.println("   >>> 7.5 FLOYD'S SHORTEST PATHS <<<     ");
        System.out.println("==========================================");
        try {
            System.out.print(" Enter the number of nodes (n): ");
            int n = Integer.parseInt(scanner.nextLine().trim());
            if (n <= 0) {
                System.out.println(" [!] Number of nodes must be greater than 0.");
                return;
            }

            int[][] dist = new int[n][n];
            int[][] next = new int[n][n];
            int INF = 99999; 

            System.out.println(" Enter the " + n + "x" + n + " matrix of weights.");
            System.out.println(" (Type 99999 to represent Infinity / No path)");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print("   - Weight from node " + (i + 1) + " to " + (j + 1) + ": ");
                    dist[i][j] = Integer.parseInt(scanner.nextLine().trim());
                    if (dist[i][j] != INF && i != j) {
                        next[i][j] = j;
                    } else {
                        next[i][j] = -1;
                    }
                }
            }

            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                            next[i][j] = next[i][k];
                        }
                    }
                }
            }

            System.out.println("\n [✓] Total Costs/Distances Matrix:");
            for (int i = 0; i < n; i++) {
                System.out.print("     ");
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] == INF) {
                        System.out.print("INF\t");
                    } else {
                        System.out.print(dist[i][j] + "\t");
                    }
                }
                System.out.println();
            }

            System.out.println("\n [✓] Shortest Paths Details:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        System.out.print("     * Path " + (i + 1) + " -> " + (j + 1) + ": ");
                        if (next[i][j] == -1) {
                            System.out.println("No path exists.");
                        } else {
                            List<Integer> path = new ArrayList<>();
                            path.add(i + 1);
                            int u = i;
                            while (u != j) {
                                u = next[u][j];
                                path.add(u + 1);
                            }
                            for (int p = 0; p < path.size(); p++) {
                                System.out.print(path.get(p));
                                if (p < path.size() - 1) System.out.print(" -> ");
                            }
                            System.out.println(" (Cost: " + dist[i][j] + ")");
                        }
                    }
                }
            }
            System.out.println("------------------------------------------");

        } catch (NumberFormatException e) {
            System.out.println(" [X] Invalid input! Please enter valid integers.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n╔══════════════════════════════════════════╗");
            System.out.println("║       ALGORITHMS PROJECT - GROUP 5       ║");
            System.out.println("╠══════════════════════════════════════════╣");
            System.out.println("║ [1] Algorithm 5  : Heap Sort             ║");
            System.out.println("║ [2] Algorithm 8  : Majority Element      ║");
            System.out.println("║ [3] Algorithm 13 : Floyd's Algorithm     ║");
            System.out.println("║ [4] exit         : Close the program     ║");
            System.out.println("╚══════════════════════════════════════════╝");
            System.out.print(" => Please select an option: ");

            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("1")) {
                heapSortAlgo(scanner);
            } else if (choice.equals("2")) {
                majorityElementAlgo(scanner);
            } else if (choice.equals("3")) {
                floydsAlgorithm(scanner);
            } else if (choice.equals("4") || choice.equals("4")) {
                System.out.println("\nExiting program. Thank you! Goodbye.");
                break;
            } else {
                System.out.println("\n [X] Invalid option! Please enter 1, 2, 3, or 4.");
            }
        }
        scanner.close();
    }
}
