package BOJ_2573;

import java.util.*;
import java.io.*;
public class BOJ_2573 {
    static int N,M,Map[][],result,count,future[][];
    static boolean Visited[][];
    static Queue<Point> queue;
    static int next[][] ={{-1,0},{1,0},{0,1},{0,-1}} ;
    public static class Point {
        int x,y;
        Point(int x,int y){
            this.x = x ; this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken()); Map = new int[N][M];
        result = 0 ; count = 0; Visited = new boolean[N][M]; queue = new LinkedList<>(); future = new int[N][M];
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<M ; j++){
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(true){
            result = result+1;
            count = 0;
            Visited = new boolean[N][M]; future = new int[N][M];
            melt();
            PutQueue();
            /*for(int i=0 ; i<N ; i++){
                for(int j=0 ; j<M ; j++){
                    System.out.print(Map[i][j]+" ");
                }
                System.out.println();
            }*/
            if(count == 0 || count>=2){
//                System.out.println("count :"+count);
                break;
            }
        }
        if(count == 0){
            System.out.println(0);
        }
        else{
            System.out.println(result);
        }
    }

    public static void melt() {
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                if(Map[i][j]!=0){
                    if(i-1>=0){
                        if(Map[i-1][j]==0){
                            future[i][j]++;
                            if(Map[i][j] == 0){
                                continue;
                            }
                        }
                    }
                    if(j-1>=0){
                        if(Map[i][j-1]==0){
                            future[i][j]++;
                            if(Map[i][j] == 0){
                                continue;
                            }
                        }
                    }
                    if(i+1<N){
                        if(Map[i+1][j]==0){
                            future[i][j]++;
                            if(Map[i][j] == 0){
                                continue;
                            }
                        }
                    }
                    if(j+1<M){
                        if(Map[i][j+1]==0){
                            future[i][j]++;
                            if(Map[i][j] == 0){
                                continue;
                            }
                        }
                    }
                }
            }
        }
        for(int i=0 ;i<N ; i++){
            for(int j=0 ;j<M ; j++){
                Map[i][j] = Map[i][j] - future[i][j];
                if(Map[i][j]<0){
                    Map[i][j] = 0;
                }
            }
        }
    }

    public static void PutQueue () {
        boolean flag = false;
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                if(!Visited[i][j] && Map[i][j]!=0){
                    queue.add(new Point(i,j));
                    Visited[i][j] = true;
                    flag = true;
                    //System.out.println("I am here");
                    Search();
                }
            }
        }
        //return flag;
    }

    public static void Search(){
        while(!queue.isEmpty()){
            Point now = queue.poll();
            for(int i=0 ; i<4 ; i++){
                if(now.x+next[i][0]<0 || now.x+next[i][0]>=N || now.y+next[i][1]<0 || now.y+next[i][1]>=M){
                    continue;
                }
                if(Map[now.x+next[i][0]][now.y+next[i][1]]!=0 && !Visited[now.x+next[i][0]][now.y+next[i][1]]){
                    queue.add(new Point(now.x+next[i][0],now.y+next[i][1]));
                    Visited[now.x+next[i][0]][now.y+next[i][1]] = true;
                }
            }
        }
        count = count+1;
    }

   /*     for(int i=0 ; i<4 ; i++){
            if(x+next[i][0]<0 || x+next[i][0]>N || y+next[i][1]<0 || y+next[i][1]>M){
                return false;
            }
        }
        return true;
    }*/
}
