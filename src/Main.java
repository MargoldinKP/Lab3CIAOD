import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину стержня: ");
        int n = scanner.nextInt();
        int[] price = new int[n + 1];
        int[] s=new int[n+1];
        System.out.println("Введите стоимости длины от 1 до " + n + ": ");
        for (int i = 1; i <= n; i++) {
            price[i] = scanner.nextInt();
        }

        System.out.println("Максимальная выручка: " + Kernel(price, n,s));
        System.out.print("Нужно разрезать стержень на куски длиной: ");
        for (;n>0;){
            System.out.print(s[n] + " ");
            n =n-s[n];
        }
    }
    public static int Kernel(int[] price, int n,int []s) {
        int[] val = new int[n + 1];
        val[0] = 0;
        for (int i = 1; i <= n; i++) {
            int N = 0;
            for (int j = 1; j <= i; j++) {
//                N = Math.max(N, price[j] + val[i - j]);

                if (price[j] + val[i - j] >= N){
                    N = price[j] + val[i - j];
                    s[i]=j;
            }
            }
            val[i] = N;
        }
        return val[n];
    }
}