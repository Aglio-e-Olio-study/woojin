package org.woojin.impl;

import java.util.*;

public class IPv6 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String str_input = sc.nextLine();

        //:를 기준으로 스플릿 처리 함수
        ArrayList<String> str_lst = new ArrayList<>();
        String tmp = "";
        for(int i=0; i<str_input.length(); i++){
            if(str_input.charAt(i) == ':'){
                str_lst.add(tmp);
                tmp = "";
            } else {
                tmp = tmp + str_input.charAt(i);
            }
        }
        str_lst.add(tmp);

        //System.out.println(str_lst.toString());

        StringBuilder sb = new StringBuilder();

        //::처리
        int diff = 8 - str_lst.size();

        for(int s=0; s<str_lst.size(); s++) {
            String str = str_lst.get(s);
            tmp = "";

            for (int i = 0; i < 4 - str.length(); i++) {
                tmp += "0";
            }
            sb.append(tmp + str).append(":");

            //생략된 그룹 만큼 반복
            if(str.equals("") && diff > 0){
                s--;
                diff--;
            }

            //예외처리: 맨왼쪽 or 맨오른쪽에 그룹한개가 ::처리 된 경우 배열 사이즈가 9가 되는 경우 처리
            if(str.equals("") && diff == -1 ){
                s++;
                diff++;
            }
        }

        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);

    }
}
