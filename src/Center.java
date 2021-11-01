import java.awt.*;

public class Center extends Piece{
    private Face face;
    private int pos;

    /**
     *
     * @param c Color of centerpiece
     * @param dir Starting direction of centerpiece
     * @param pos xyz position of centerpiece
     */
    public Center(Color c, char dir, int pos){
        super(pos);
        this.pos = pos;
        face = new Face(c, dir);
    }
    public String getColor(){
        return face.getColor();
    }
    public String toString(){
        return "(Center: " + face.toString() + ")";
    }
    public void m(){
        if(getY() == 1){
            setY(0);
            setZ(-1);
        }
        else if(getZ() == -1){
            setY(-1);
            setZ(0);
        }
        else if(getZ() == 1){
            setY(1);
            setZ(0);
        }
        else if(getY() == -1){
            setY(0);
            setZ(-1);
        }
        face.m();
    }
    public void e(){
        if(getZ() == -1){
            setZ(0);
            setX(1);
        }
        else if(getZ() == 1){
            setX(-1);
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
        face.d();
    }

    public boolean contains(String c){
        if(face.getColor().equals(c)){
            return true;
        }
        return false;
    }
    public int getPos(){
        return pos;
    }

}
