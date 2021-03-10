package exam.ah;

public class ShowMeBug {
    public static void main(String[] args) {

    }
    public static char[][] help(int n) {
        char[][] arrs = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrs[i][j] = '.';
            }
        }
        for (int i = 0; i < n; i++) {
            int num = (int) (Math.random() * 100);
            while (arrs[num % 10][num / 10] == 'x') {
                num = (int) (Math.random() * 100);
            }
            arrs[num % 10][num / 10] = 'x';
        }
        return arrs;
    }
}
