//Input: commands = [4,-1,3], obstacles = []
//Output: 25
//Explanation: The robot starts at (0, 0):
//        1. Move north 4 units to (0, 4).
//        2. Turn right.
//        3. Move east 3 units to (3, 4).
//The furthest point the robot ever gets from the origin is (3, 4), which squared is 32 + 42 = 25 units away.

//eğer bir engele takılırsa onun önüne kadar gelecek
//eğer gidip geri gelirse gittiği en uzak mesafe

import java.util.HashSet;
import java.util.Set;

public class robotSIM {
    int right = -1;
    int left = -2;
    int[] coordinate = {0, 0}; // Başlangıç koordinatları
    int direction = 0; // 0 north, 1 east, 2 south, 3 west
    int[] dx = {0, 1, 0, -1}; // X ekseni için hareketler
    int[] dy = {1, 0, -1, 0}; // Y ekseni için hareketler
    int maxDistanceSquared = 0;

    public static void main(String[] args) {
        robotSIM robotSim = new robotSIM();
        int[] commands = {-2, 8, 3, 7, -1}; // Komut dizisi
        int[][] obstacles = {{-4, -1}, {1, -1}, {1, 4}, {5, 0}, {4, 5}, {-2, -1}, {2, -5}, {5, 1}, {-3, -1}, {5, -3}}; // Engel dizisi

        System.out.println(robotSim.robotSim(commands, obstacles)); // Sonucu yazdır
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        // Engelleri HashSet'e ekleyerek hızlı arama sağlıyoruz
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        // Komutlar üzerinde döngü
        for (int command : commands) {
            if (command == right) {
                direction = (direction + 1) % 4; // Sağa dön
            } else if (command == left) {
                direction = (direction + 3) % 4; // Sola dön
            } else {
                // İleri git komutu
                for (int step = 0; step < command; step++) {
                    int nextX = coordinate[0] + dx[direction];
                    int nextY = coordinate[1] + dy[direction];

                    // Eğer önümüzde bir engel yoksa hareket ediyoruz
                    if (!obstacleSet.contains(nextX + "," + nextY)) {
                        coordinate[0] = nextX;
                        coordinate[1] = nextY;
                        // Şu anki mesafeyi güncelliyoruz
                        maxDistanceSquared = Math.max(maxDistanceSquared, coordinate[0] * coordinate[0] + coordinate[1] * coordinate[1]);
                    }
                }
            }
        }

        // Uzaklığın karesini döndür
        return maxDistanceSquared;
    }
    }

