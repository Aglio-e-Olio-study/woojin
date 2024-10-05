import java.util.*;

public class 색종이{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = Integer.valueOf(sc.nextLine());

        int[][] S = new int[101][101];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(sc.nextLine());
            int x = Integer.valueOf(st.nextToken());
            int y = Integer.valueOf(st.nextToken());

            for(int k=y; k<y+10; k++){
                for(int q = x; q<x+10; q++){
                    S[k][q] = 1;
                }
            }
        }

        int result = 0;
        for(int i=1; i<=100; i++){
            for(int j=1; j<=100; j++){
                if(S[i][j] == 1){
                    result += 1;
                }
            }
        }

        System.out.println(result);

    }
}