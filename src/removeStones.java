public class removeStones {

    public void main(String[] args) {
        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        int result = removeStones(stones);
        System.out.println("Çıktı: " + result); // Beklenen çıktı: 5
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] visited = new boolean[n];// her taşın kontrol durumunu kontrol ediyoruz.
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(stones, visited, i);
            }
        }

        return n - components;
    }

    private void dfs(int[][] stones, boolean[] visited, int i) {
        visited[i] = true;
        for (int j = 0; j < stones.length; j++) {
            // If stones[i] and stones[j] are in the same row or column, and j is not visited
            if (!visited[j] && (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])) {
                dfs(stones, visited, j);
            }
        }
    }
    }
