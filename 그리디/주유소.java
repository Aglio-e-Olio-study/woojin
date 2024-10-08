import java.util.*;

public class 주유소 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = Integer.valueOf(sc.nextLine());

        long[] dists = Arrays.stream(sc.nextLine().split(" "))
                .mapToLong(Long::valueOf)
                .toArray();

        long[] cost = Arrays.stream(sc.nextLine().split(" "))
                .mapToLong(Long::valueOf)
                .toArray();

        // i번째 비용보다 작은 곳(j)까지만 이동
        int i = 0, j = 1;

        long result = 0;
        while(j < n){
            result += cost[i] * dists[j-1];

            //다음 주유소가 비싸면 그냥 이동
            if(cost[i] <= cost[j]){
                j++;
            }
            // 다음 주유소가 더 싸면 거기까지만 이동
            else{
                i = j;
                j++;
            }
        }
        System.out.println(result);
    }
}