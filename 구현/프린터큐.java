package org.woojin.impl;
import java.util.*;

public class 프린터큐{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

        int n = Integer.valueOf(sc.nextLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append(printQueue()).append("\n");
        }
        System.out.print(sb);

    }

    public static int printQueue(){

        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int n = Integer.valueOf(st.nextToken());
        int target = Integer.valueOf(st.nextToken());

        //중요도가 높지 않으면 뽑지 않고 뒤로 보낸다 -> 결국 뽑히는건 가장 우선순위가 높은 것 -> 우순순위큐 끼링~
        //헉 근데 1 1 9 1 1 1에서 앞에 2개가 뒤로 가야하니까 순서 조정을 해줘야함 -> 큐도 같이 사용~
        //그러면 우선순위큐는 최대값을 찾는데 활용하자~
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n2.v - n1.v);
        Queue<Node> q = new LinkedList<>();


        st = new StringTokenizer(sc.nextLine());
        for(int i=0; i<n; i++){
            int v = Integer.valueOf(st.nextToken());
            pq.offer(new Node(i, v));
            q.offer(new Node(i, v));
        }

        int count = 1;
        while(!q.isEmpty()){
            Node now = q.poll();
            Node max = pq.peek();

            if(now.v != max.v){
                q.offer(now);
            } else {
                if(now.i == target){
                    break;
                }
                count++;
                pq.poll();
            }

        }

        return count;
    }

    static class Node{
        int i;
        int v;

        public Node(int _i, int _v){
            i = _i;
            v = _v;
        }
    }
}