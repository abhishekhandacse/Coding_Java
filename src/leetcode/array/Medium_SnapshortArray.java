package leetcode.array;

import java.util.HashMap;
import java.util.TreeMap;

public class Medium_SnapshortArray {
    TreeMap<Integer,Integer> [] tm;
    int snap_id;
    public Medium_SnapshortArray(int length){
        tm=new TreeMap[length];
        snap_id=0;
        for(int i=0;i<length;i++){
            tm[i]=new TreeMap<>();
            tm[i].put(snap_id,0);
        }
    }
    public void set(int index, int val){
        tm[index].put(snap_id,val);//old value would be replaced
    }
    public int snap(){
        snap_id++;
        return snap_id-1;
    }
    public int get(int index, int snap_id){
        return tm[index].floorEntry(snap_id).getValue();
    }
}

   /* final int ROWS=50001,COLS=50001;
    int[][] Matrix;
    int snap_id_global;
    int col;
    public Medium_SnapshortArray(int length) {
        col=length;
        Matrix=new int[ROWS][col];
        snap_id_global=0;
    }
    public void set(int index, int val) {
        Matrix[snap_id_global][index]=val;
    }
    // O(N) Operation
    public int snap() {
        for(int i=0;i<col;i++){
            Matrix[snap_id_global+1][i]=Matrix[snap_id_global][i];
        }
        snap_id_global++;
        return snap_id_global-1;
    }
    public int get(int index, int snap_id) {
        return Matrix[snap_id][index];
    }*/

