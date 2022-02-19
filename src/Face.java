import java.awt.*;

public class Face {
    private char dir;
    private Color color;
    Face(Color c, char d){
        dir = d;
        color = c;
    }

    public void setDir(char s){
        dir = s;
    }
    public char getDir(){
        return dir;
    }
    public void setColor(Color c){
        color = c;
    }
    public String toString(){
        return getColor() + ", " + dir + ". ";
    }
    public String getColor(){
        if(color.equals(Color.blue)){
            return "Blue";
        }
        if(color.equals(Color.red)){
            return "Red";
        }
        if(color.equals(Color.yellow)){
            return "Yellow";
        }
        if(color.equals(Color.white)){
            return "White";
        }
        if(color.equals(Color.orange)){
            return "Orange";
        }
        if(color.equals(Color.green)){
            return "Green";
        }
        return "null";
    }

    public void r(){
        if(dir == 'u'){
            dir = 'b';
        }
        else if(dir == 'b'){
            dir = 'd';
        }
        else if(dir == 'd'){
            dir = 'f';
        }
        else if(dir == 'f'){
            dir = 'u';
        }
    }

    public void u(){
        if(dir == 'b'){
            dir = 'r';
        }
        else if(dir == 'r'){
            dir = 'f';
        }
        else if(dir == 'f'){
            dir = 'l';
        }
        else if(dir == 'l'){
            dir = 'b';
        }
    }
    /** Used for both e and d Face methods (horizontal counterclockwise)*/

    public void d(){
        if(dir == 'l'){
            dir = 'f';
        }
        else if(dir == 'f'){
            dir = 'r';
        }
        else if(dir == 'r'){
            dir = 'b';
        }
        else if(dir == 'b'){
            dir = 'l';
        }
    }
    public void e(){
        if(dir == 'l'){
            dir = 'f';
        }
        else if(dir == 'f'){
            dir = 'r';
        }
        else if(dir == 'r'){
            dir = 'b';
        }
        else if(dir == 'b'){
            dir = 'l';
        }
    }
    public void f(){
        if(dir == 'u'){
            dir = 'r';
        }
        else if(dir == 'r'){
            dir = 'd';
        }
        else if(dir == 'd'){
            dir = 'l';
        }
        else if(dir == 'l'){
            dir = 'u';
        }
    }
    public void l(){
        if(dir == 'f'){
            dir = 'd';
        }
        else if(dir == 'd'){
            dir = 'b';
        }
        else if(dir == 'b'){
            dir = 'u';
        }
        else if(dir == 'u'){
            dir = 'f';
        }
    }
    public void b(){
        if(dir == 'l'){
            dir = 'd';
        }
        else if(dir == 'u'){
            dir = 'l';
        }
        else if(dir == 'r'){
            dir = 'u';
        }
        else if(dir == 'd'){
            dir = 'r';
        }
    }
    public void m(){
        if(dir == 'f'){
            dir = 'd';
        }
        else if(dir == 'd'){
            dir = 'b';
        }
        else if(dir == 'b'){
            dir = 'u';
        }
        else if(dir == 'u'){
            dir = 'f';
        }
    }


}
