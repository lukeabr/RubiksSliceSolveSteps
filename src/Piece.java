import java.awt.*;

public class Piece {
    private int x;
    private int y;
    private int z;
    public Piece(int pos){
        if(pos < 9){
            if(pos < 3){
                z = 1;
            }
            else if(pos < 6){
                z = 0;
            }
            else{
                z = -1;
            }
            y = 1;
        }
        else if(pos < 18){
            if(pos < 12){
                z = 1;
            }
            else if(pos < 15){
                z = 0;
            }
            else{
                z = -1;
            }
            y = 0;
        }
        else{
            if(pos < 21){
                z = 1;
            }
            else if(pos < 24){
                z = 0;
            }
            else{
                z = -1;
            }
            y = -1;
        }
        if(pos % 3 == 0){
            x = -1;
        }
        else if((pos - 1) % 3 == 0){
            x = 0;
        }
        else{
            x = 1;
        }
    }
//    public int getPos(){
//
//    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getZ(){
        return z;
    }
    public void r(){}
    public void u(){}
    public void d(){}
    public void l(){}
    public void f(){}
    public void e(){}
    public void b(){}
    public void m(){}
    public boolean isCorner(){return false;}


    public void setX(int xpos){
        x = xpos;
    }
    public void setY(int ypos){
        y = ypos;
    }
    public void setZ(int zpos){
        z = zpos;
    }
    public String toString(){
        return "";
    }
    public boolean contains(String c){return false;}
    public char getColorDir(String c){return ' ';}
    public String getDirColor(char d){return "";}
    public String getColor(){return "";}
    public int getPos(){
        return x + y + z;
    }
}
