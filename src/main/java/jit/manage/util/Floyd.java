package jit.manage.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sunlotus on 2019/4/1.
 */
public class Floyd {

    private static int INF = Integer.MAX_VALUE;
    private int[][] dist;
    //顶点i 到 j的最短路径长度，初值是i到j的边的权重
    private int[][] path;
    private List<Integer> result = new ArrayList<Integer>();

    public static HashMap<String,Object> test(int[][] distances,int begin,int end){
        Floyd floyd = new Floyd(13);
        floyd.findCheapestPath(begin,end,distances);
        List<Integer> list=floyd.result;
        HashMap<String,Object> map= new HashMap<String ,Object>();
        map.put("path",list);
        map.put("length",floyd.dist[begin][end]);
        return map;
    }

    public  void findCheapestPath(int begin,int end,int[][] matrix){
        floyd(matrix);
        result.add(begin);
        findPath(begin,end);
        result.add(end);
    }

    public void findPath(int i,int j){
        // 找到路由节点
        int k=path[i][j];
        if(k==-1)
            return;
        // 从i到路由节点进行递归寻找中间节点
        findPath(i,k);
        result.add(k);
        // 从j到路由节点进行递归寻找中间节点
        findPath(k,j);
    }

    public  void floyd(int[][] matrix){
        int size=matrix.length;
        for(int i=0;i< size;i++){
            for(int j=0;j< size;j++){
                path[i][j]=-1;
                dist[i][j]=matrix[i][j];
            }
        }
        for(int k=0;k< size;k++){
            for(int i=0;i< size;i++){
                for(int j=0;j< size;j++){
                    if(dist[i][k]!=INF&&
                            dist[k][j]!=INF&&
                            dist[i][k]+dist[k][j]< dist[i][j]){
                        // 更新i和j两点间的距离
                        dist[i][j]=dist[i][k]+dist[k][j];
                        // 更新i和j两点间的路由信息
                        path[i][j]=k;
                    }
                }
            }
        }
    }

    public Floyd(int size){
        this.path=new int[size][size];
        this.dist=new int[size][size];
    }
}
