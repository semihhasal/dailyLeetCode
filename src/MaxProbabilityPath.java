// Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
// Output: ,0.30000


public class MaxProbabilityPath {

    public static void main(String[] args) {
        MaxProbabilityPath solver = new MaxProbabilityPath();
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = {0.5, 0.5, 0.2};
        int start = 0;
        int end = 2;

        double result = solver.maxProbability(n, edges, succProb, start, end);
        System.out.println(result);  // Output: 0.25
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] max_prob = new double[n];
        max_prob[start] = 1.0;

        for (int i = 0; i < n; i++) {
            boolean isConnected = false;
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double p = succProb[j];

                if (max_prob[u] * p > max_prob[v]) {
                    max_prob[v] = max_prob[u] * p;
                    isConnected = true;
                }
                if (max_prob[v] * p > max_prob[u]) {
                    max_prob[u] = max_prob[v] * p;
                    isConnected = true;
                }
            }
            if (!isConnected) break;
        }
        return max_prob[end];
    }
}
