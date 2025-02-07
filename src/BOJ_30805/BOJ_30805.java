package BOJ_30805;

import java.io.*;
import java.util.*;

public class BOJ_30805 {
    static int N,M,A[],B[],index_A,index_B,result;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); st = new StringTokenizer(br.readLine()); A = new int[N];
        for(int i=0 ; i<N ; i++){A[i] = Integer.parseInt(st.nextToken());}//A input

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); st = new StringTokenizer(br.readLine()); B = new int[M];
        for(int i=0 ; i<M ; i++){B[i] = Integer.parseInt(st.nextToken());}//B input

        index_A = 0 ; index_B = 0; result = 0;
        while(index_A<N && index_B<M){
            int max = -1; int next_A = -1; int next_B = -1;

            for(int i=index_A ; i<N ; i++){
                for(int j=index_B ; j<M ; j++){
                    if(A[i]==B[j] && A[i]>max){
                        max = Math.max(max,A[i]);
                        next_A = i; next_B = j;
                        //System.out.println("nextin :"+next_A+" "+next_B);
                    }//equal if
                }//B searching
            }//A searching

            if(max != -1){
                sb.append(max).append(" ");
                result++;
                index_A = next_A+1 ; index_B = next_B+1;
                //System.out.println("next :"+index_A+" "+index_B);

            } //append sb
            else{
                index_A = N; index_B = M ;
                break;
            }//else

        }//while
        System.out.println(result);
        System.out.println(sb);
    } //main
} //class
