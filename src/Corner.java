import java.awt.*;

public class Corner extends Piece {
    private int pos;
    private Face[] faces;

    public Corner(Color c1, Color c2, Color c3, char d1, char d2, char d3, int pos){
        super(pos);
        this.pos = pos;
        faces = new Face[3];
        faces[0] = new Face(c1, d1);
        faces[1] = new Face(c2, d2);
        faces[2] = new Face(c3, d3);
    }
    public Corner(int pos, char d1, char d2, char d3){
        super(pos);
        faces[0] = new Face(null, d1);
        faces[1] = new Face(null, d2);
        faces[2] = new Face(null, d3);
    }
    public void setFaceColor(Color c, char d){
        int i = 0;
        while(faces[i].getDir() != d){
            i++;
        }
        faces[i].setColor(c);
    }

    public String toString(){
        return pos + "(x: " + getX() + ", y: " + getY() + ", " + " z: " + getZ() + ", " + faces[0].getColor() + " " + faces[0].getDir() + ", " + faces[1].getColor() + " " + faces[1].getDir() + ", " + faces[2].getColor() + " " + faces[2].getDir() + ") ";
    }
    public int getPos(){
        return pos;
    }
    public void r(){
        if(getY() == 1){
            if (getZ() == 1) {
                setY(-1);
            }
            else{
                setZ(1);
            }
        }
        else{
            if(getZ() == -1){
                setY(1);
            }
            else{
                setZ(-1);
            }
        }
        faces[0].r();
        faces[1].r();
        faces[2].r();
    }

    public void u(){
        if(getZ() == 1){
            if (getX() == 1) {
                setZ(-1);
            }
            else{
                setX(1);

            }
        }
        else{
            if(getX() == 1){
                setX(-1);
            }
            else{
                setZ(1);
            }
        }
        faces[0].u();
        faces[1].u();
        faces[2].u();
    }

    public void d(){
        if(getZ() == 1){
            if (getX() == 1) {
                setX(-1);
            }
            else{
                setZ(-1);

            }
        }
        else{
            if(getX() == 1){
                setZ(1);
            }
            else{
                setX(1);
            }
        }
        faces[0].d();
        faces[1].d();
        faces[2].d();
    }

    public void f(){
        if(getY() == 1){
            if(getX() == -1){
                setX(1);
            }
            else{
                setY(-1);
            }
        }
        else{
            if(getX() == -1){
                setY(1);
            }
            else{
                setX(-1);
            }
        }
        faces[0].f();
        faces[1].f();
        faces[2].f();
    }
    public void b(){
        if(getY() == 1){
            if(getX() == -1){
                setY(-1);
            }
            else{
                setX(-1);
            }
        }
        else{
            if(getX() == -1){
                setX(1);
            }
            else{
                setY(1);
            }
        }
    }

    public boolean contains(String c){
        if(faces[0].getColor().equals(c) || faces[1].getColor().equals(c) || faces[2].getColor().equals(c)){
            return true;
        }
        return false;
    }

    public boolean isCorner(){
        return true;
    }

    public char getColorDir(String c){
        if(faces[0].getColor().equals(c)){
            return faces[0].getDir();
        }
        else if(faces[1].getColor().equals(c)){
            return faces[1].getDir();
        }
        else if(faces[2].getColor().equals(c)){
            return faces[2].getDir();
        }
        else{
            return 'n';
        }
    }
    public String getDirColor(char dir){
        for(int i = 0; i < 3; i++){
            if(faces[i].getDir() == dir){
                return faces[i].getColor();
            }
        }
        return "";
    }

    public void l(){
        if(getY() == 1){
            if(getZ() == -1){
                setY(-1);
            }
            else{
                setZ(-1);
            }
        }
        else{
            if(getZ() == 1){
                setY(1);
            }
            else{
                setZ(1);
            }
        }
        faces[0].l();
        faces[1].l();
        faces[2].l();
    }

}
