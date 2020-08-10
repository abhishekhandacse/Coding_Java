package hackerrank.medium;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Move{
    int X,Y;
    int Turns;
    Character Direction;
    public Move(int x, int y, int turns, Character direction){
        X = x;
        Y = y;
        Turns = turns;
        Direction = direction;
    }
}
class CoOrdinate{
    int X,Y;
    CoOrdinate(int X,int Y){
        this.X=X;
        this.Y=Y;
    }
}
public class CastleOnTheGrid {
    static boolean isValid(StringBuilder[] grid, int x, int y){
            int N=grid.length;
            if( x<0 || x>=N  || y<0 || y>=N || grid[x].charAt(y) == 'X' || grid[x].charAt(y) == 'Q' )return false;
            return true;
    }

    static int minimumMoves(String[] mat, int startX, int startY, int goalX, int goalY){
                StringBuilder[] grid=new StringBuilder[mat.length];
                for(int i=0;i<mat.length;i++){
                    grid[i]=new StringBuilder(mat[i]);
                }
                Queue<Move> q=new LinkedList<>();
                Set<CoOrdinate> set=new HashSet<>();
                set.add(new CoOrdinate(0,0));
                q.add(new Move(startX,startY,0,'N'));   // N is Not Defined :)
                grid[startX].setCharAt(startY,'Q');
                int x,y,turns;
                Character d;
                int MinTurns=Integer.MAX_VALUE;
                while(q.isEmpty()==false){
                     Move m=q.poll();
                     x=m.X;
                     y=m.Y;
                     grid[x].setCharAt(y,'Q');
                     turns=m.Turns;
                    if( x==goalX  && y==goalY ){
                        if(MinTurns > turns)
                            MinTurns=turns;// Don't break here... otherwise min no of turns condition would remain pending
                    }
                     d=m.Direction;
                     int x1,y1,x2,y2,x3,y3,x4,y4;
                     x1=x-1;  y1=y;//up
                     x2=x+1;  y2=y;//down
                     x3=x;    y3=y-1;//left
                     x4=x;    y4=y+1;//right
                     if(isValid(grid,x1,y1)){
                         if(d!='U' && d!='N'){
                             if(set.contains(new CoOrdinate(x1,y1))==false)
                                q.add(new Move(x1,y1,turns+1,'U'));
                         }else{
                             if(set.contains(new CoOrdinate(x1,y1))==false)
                                q.add(new Move(x1,y1,turns,'U'));
                         }
                         set.add(new CoOrdinate(x1,y1));
                     }
                     if(isValid(grid,x2,y2)){
                         if(d!='D' && d!='N'){
                             if(set.contains(new CoOrdinate(x2,y2))==false)
                                q.add(new Move(x2,y2,turns+1,'D'));
                         }else{
                             if(set.contains(new CoOrdinate(x2,y2))==false)
                                q.add(new Move(x2,y2,turns,'D'));
                         }
                         set.add(new CoOrdinate(x2,y2));
                     }
                     if(isValid(grid,x3,y3)){
                         if(d!='L' && d!='N'){
                             if(set.contains(new CoOrdinate(x3,y3))==false)
                                q.add(new Move(x3,y3,turns+1,'L'));
                         }else{
                             if(set.contains(new CoOrdinate(x3,y3))==false)
                                q.add(new Move(x3,y3,turns,'L'));
                         }
                         set.add(new CoOrdinate(x3,y3));
                     }
                     if(isValid(grid,x4,y4)){
                         if(d!='R'&& d!='N'){
                             if(set.contains(new CoOrdinate(x4,y4))==false)
                                q.add(new Move(x4,y4,turns+1,'R'));
                         }else{
                             if(set.contains(new CoOrdinate(x4,y4))==false)
                                q.add(new Move(x4,y4,turns,'R'));
                         }
                         set.add(new CoOrdinate(x4,y4));
                     }
                }
                return MinTurns+1;//    Not possible to reach the destination
    }

    public static void main(String[] args) {
        int ans=minimumMoves(new String[]{
                ".X..",
                "....",
                ".XX.",
                "..X."
        },0,0,3,3);
        System.out.println(ans);
    }
}
