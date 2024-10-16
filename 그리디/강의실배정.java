import java.util.*;

public class 강의실배정{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = Integer.valueOf(sc.nextLine());

        PriorityQueue<Node> class_lst = new PriorityQueue<>((c1, c2) -> {
            if(c1.s == c2.s){
                return c1.e - c2.e;
            } else {
                return c1.s - c2.s;
            }
        });

        StringTokenizer st;
        int s,e;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(sc.nextLine());
            s = Integer.valueOf(st.nextToken());
            e = Integer.valueOf(st.nextToken());

            class_lst.offer(new Node(s,e));
        }

        //각 강의실의 종료시간을 저장
        PriorityQueue<Integer> room = new PriorityQueue<>();
        room.offer(0);

        while(!class_lst.isEmpty()){
            Node now = class_lst.poll();

            //현재 강의가 강의실의 최대 종료 시간보다 크다면 강의실 추가 증축 필요x
            if(room.peek() <= now.s){
                room.poll();
            }

            room.offer(now.e);
        }

        System.out.println(room.size());

    }

    static class Node{
        int s;
        int e;

        public Node(int _s, int _e){
            s = _s;
            e = _e;
        }
    }

//    1. 오답: brute_force(N^2) -> 시간 초과
//    public static void old_fun1(){
//        Scanner sc = new Scanner(System.in);
//
//        int n = Integer.valueOf(sc.nextLine());
//
//        ArrayList<ArrayList<Node>> class_rooms = new ArrayList<>();
//        class_rooms.add(new ArrayList<>());
//
//        StringTokenizer st;
//        int s,e;
//        boolean notatall; //전체 강의실에 아무 자리도 없는 경우
//        for(int i=0; i<n; i++){
//            st = new StringTokenizer(sc.nextLine());
//            s = Integer.valueOf(st.nextToken());
//            e = Integer.valueOf(st.nextToken());
//
//            Node new_c = new Node(s,e);
//
//            notatall = true;
//            for(ArrayList<Node> class_room : class_rooms){
//                //해당 강의실에 자리가 있다면
//                if(!check_fun(class_room, new_c)){
//                    class_room.add(new_c);
//                    notatall = false;
//                    break;
//                }
//            }
//
//            //아무 강의실에도 못 들어갔다면 강의실 증축
//            if(notatall){
//                class_rooms.add(new ArrayList<>());
//                class_rooms.get(class_rooms.size() - 1).add(new_c);
//            }
//        }
//
//        System.out.println(class_rooms.size());
//    }
//
//    //해당 강의실에 충돌나면 true, 하나도 안겹치면 false
//    public static boolean check_fun(ArrayList<Node> class_room, Node new_c){
//        boolean isCol = false;
//
//        for(Node now : class_room){
//            if( !(now.e <= new_c.s || now.s >= new_c.e) ){
//                isCol = true;
//                break;
//            }
//        }
//        return isCol;
//    }
//
//
//    2.오답: 비트맵 활용 -> 메모리 초과
//    public static void old_fun2(){
//        Scanner sc = new Scanner(System.in);
//
//        int n = Integer.valueOf(sc.nextLine());
//
//        ArrayList<BitSet> class_rooms = new ArrayList<>();
//        class_rooms.add(new BitSet(1000000001));
//
//        StringTokenizer st;
//        int s,e;
//        boolean notatall; //전체 강의실에 아무 자리도 없는 경우
//        for(int i=0; i<n; i++){
//            st = new StringTokenizer(sc.nextLine());
//            s = Integer.valueOf(st.nextToken());
//            e = Integer.valueOf(st.nextToken());
//
//            notatall = true;
//            for(BitSet class_room : class_rooms){
//                //해당 강의실에 자리가 있다면
//                if( !(class_room.get(s + 1, e).cardinality() > 0)){
//                    class_room.set(s, e + 1);
//                    notatall = false;
//                    break;
//                }
//            }
//
//            //아무 강의실에도 못 들어갔다면 강의실 증축
//            if(notatall){
//                class_rooms.add(new BitSet(1000000001));
//                class_rooms.get(class_rooms.size() - 1).set(s, e + 1);;
//            }
//        }
//
//        System.out.println(class_rooms.size());
//    }
//

}