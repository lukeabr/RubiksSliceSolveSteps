import java.awt.*;

public class Edge extends Piece{
    private Face[] faces;
    private int pos;
    public Edge(Color c1, Color c2, char d1, char d2, int pos){
        super(pos);
        this.pos = pos;
        faces = new Face[2];
        faces[0] = new Face(c1, d1);
        faces[1] = new Face(c2, d2);
    }
    public String toString(){
        return pos + "(x: " + getX() + ", y: " + getY() + ", z: " + getZ() + ", " + faces[0].getColor() + " " + faces[0].getDir() + ", " + faces[1].getColor() + " " + faces[1].getDir() + ") ";
    }

    public int getPos(){
        return pos;
    }
    public void r(){
        if(getY() == 1){
            setY(0);
            setZ(1);
        }
        else if(getY() == -1){
            setY(0);
            setZ(-1);
        }
        else if(getZ() == -1){
            setY(1);
            setZ(0);
        }
        else if(getZ() == 1){
            setY(-1);
            setZ(0);
        }
        faces[0].r();
        faces[1].r();
    }
    public void u(){
        if(getZ() == 1){
            setZ(0);
            setX(1);
        }
        else if(getZ() == -1){
            setX(-1);
            setZ(0);
        }
        else if(getX() == -1){
            setX(0);
            setZ(1);
        }
        else if(getX() == 1){
            setX(0);
            setZ(-1);
        }
        faces[0].u();
        faces[1].u();
    }
    public void d(){
        if(getZ() == 1){
            setZ(0);
            setX(-1);
        }
        else if(getZ() == -1){
            setX(1);
            setZ(0);
        }
        else if(getX() == -1){
            setX(0);
            setZ(-1);
        }
        else if(getX() == 1){
            setX(0);
            setZ(1);
        }
        faces[0].d();
        faces[1].d();
    }
    public void f(){
        if(getY() == 1){
            setY(0);
            setX(1);
        }
        else if(getX() == 1){
            setX(0);
            setY(-1);
        }
        else if(getY() == -1){
            setX(-1);
            setY(0);
        }
        else if(getX() == -1){
            setX(0);
            setY(1);
        }
        faces[0].f();
        faces[1].f();
    }

    public void e(){
        if(getX() == 1){
            if(getZ() == 1){
                setX(-1);
            }
            else{
                setZ(1);
            }
        }
        else{
            if(getZ() == 1){
                setZ(-1);
            }
            else{
                setX(1);
            }
        }
        faces[0].e();
        faces[1].e();
    }
    public void l(){
        if(getY() == 1){
            setY(0);
            setZ(-1);

        }
        else if(getZ() == 1){
            setZ(0);
            setY(1);
        }
        else if(getZ() == -1){
            setZ(0);
            setY(-1);
        }
        else if(getY() == -1){
            setY(0);
            setZ(1);
        }
        faces[0].l();
        faces[1].l();
    }
    public void m(){
        if(getY() == 1){
            if(getZ() == -1){
                setY(-1);
            }
            else{
                setZ(-1);
            }
        }
        else if(getY() == -1){
            if(getZ() == -1){
                setZ(1);
            }
            else{
                setY(1);
            }

        }

        faces[0].m();
        faces[1].m();
    }
    public void b(){
        if(getX() == -1){
            setX(0);
            setY(-1);
        }
        else if(getX() == 1){
            setX(0);
            setY(1);
        }
        else if(getY() == 1){
            setX(-1);
            setY(0);
        }
        else if(getY() == -1){
            setX(1);
            setY(0);
        }
        faces[0].b();
        faces[1].b();
    }
    public boolean contains(String c){
        if(faces[0].getColor().equals(c) || faces[1].getColor().equals(c)){
            return true;
        }
        return false;
    }

    public char getColorDir(String c){
        if(faces[0].getColor().equals(c)){
            return faces[0].getDir();
        }
        else if(faces[1].getColor().equals(c)){
            return faces[1].getDir();
        }
        else{
            return 'n';
        }
    }

    public String getDirColor(char c){
        if(faces[0].getDir() == c){
            return faces[0].getColor();
        }
        else if(faces[1].getDir() == c){
            return faces[1].getColor();
        }
        else{
            return "n";
        }
    }

}
