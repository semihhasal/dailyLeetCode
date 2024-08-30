public class CountSubIslands {

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                // Hem grid1 hem de grid2'de 1 olan hücreleri kontrol et
                if (grid1[i][j] == 1 && grid2[i][j] == 1) {
                    // Eğer DFS tüm hücreler için true döndürürse, bu bir sub-island'dır
                    if (dfs(grid1, grid2, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        // Matris sınırlarının dışında mı kontrolü
        if (i < 0 || i >= grid1.length || j < 0 || j >= grid1[0].length) {
            return true;  // Matris sınırlarını aşarsak, bu doğru bir yoldan gitmişiz demektir
        }

        // Eğer suya ulaşıldıysa veya ziyaret edilmişse
        if (grid2[i][j] == 0) {
            return true;
        }

        // Eğer grid1'de bu hücre su ise, false döndür ve durdur
        if (grid1[i][j] == 0) {
            return false;
        }

        // Mevcut hücreyi işaretle (0 yaparak ziyaret edildiğini belirtiyoruz)
        grid2[i][j] = 0;

        // 4 yöne doğru derinlemesine arama yapıyoruz
        boolean up = dfs(grid1, grid2, i - 1, j);
        boolean down = dfs(grid1, grid2, i + 1, j);
        boolean left = dfs(grid1, grid2, i, j - 1);
        boolean right = dfs(grid1, grid2, i, j + 1);

        // Eğer tüm yönler sub-island olarak kalabiliyorsa true döndür
        return up && down && left && right;
    }
}
