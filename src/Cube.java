import java.awt.*;
import java.util.ArrayList;

public class Cube {
    private String steps;
    private Piece[] pieces;

    public Cube(){
        steps = "";
        //Starting Cube
        //Corners
        pieces = new Piece[26];
        pieces[0] = new Corner(Color.green, Color.orange, Color.white, 'l', 'b', 'u', 0);
        pieces[1] = new Corner(Color.orange, Color.blue, Color.white, 'b', 'r', 'u', 2);
        pieces[2] = new Corner(Color.green, Color.red, Color.white, 'l', 'f', 'u', 6);
        pieces[3] = new Corner(Color.red, Color.blue, Color.white, 'f', 'r', 'u', 8);
        pieces[4] = new Corner(Color.green, Color.orange, Color.yellow, 'l', 'b', 'd', 18);
        pieces[5] = new Corner(Color.orange, Color.blue, Color.yellow, 'b', 'r', 'd', 20);
        pieces[6] = new Corner(Color.green, Color.red, Color.yellow, 'l', 'f', 'd', 24);
        pieces[7] = new Corner(Color.red, Color.blue, Color.yellow, 'f', 'r', 'd', 26);

        //Edges
        pieces[8] = new Edge(Color.orange, Color.white,'b', 'u', 1);
        pieces[9] = new Edge(Color.green, Color.white,'l', 'u', 3);
        pieces[10] = new Edge(Color.blue, Color.white, 'r', 'u', 5);
        pieces[11] = new Edge(Color.red, Color.white, 'f', 'u', 7);
        pieces[12] = new Edge(Color.green, Color.orange, 'l', 'b', 9);
        pieces[13] = new Edge(Color.orange, Color.blue, 'b', 'r', 11);
        pieces[14] = new Edge(Color.green, Color.red, 'l', 'f', 15);
        pieces[15] = new Edge(Color.blue, Color.red, 'r', 'f',  17);
        pieces[16] = new Edge(Color.orange, Color.yellow, 'b', 'd',  19);
        pieces[17] = new Edge(Color.green, Color.yellow, 'l', 'd', 21);
        pieces[18] = new Edge(Color.blue, Color.yellow, 'r', 'd',  23);
        pieces[19] = new Edge(Color.red, Color.yellow, 'f', 'd',  25);

        //Centers
        pieces[20] = new Center(Color.red, 'f', 16);
        pieces[21] = new Center(Color.blue, 'r', 14);
        pieces[22] = new Center(Color.white, 'u', 4);
        pieces[23] = new Center(Color.green, 'l', 12);
        pieces[24] = new Center(Color.orange, 'b', 10);
        pieces[25] = new Center(Color.yellow, 'd', 22);

    }

    public Cube(String v){
        if(v.equals("solve")){
            //Final Cube
            pieces = new Piece[26];
            pieces[0] = new Corner(Color.green, Color.orange, Color.white, 'l', 'b', 'u', 0);
            pieces[1] = new Corner(Color.orange, Color.blue, Color.white, 'b', 'r', 'u', 2);
            pieces[2] = new Corner(Color.green, Color.red, Color.white, 'l', 'f', 'u', 6);
            pieces[3] = new Corner(Color.red, Color.blue, Color.white, 'f', 'r', 'u', 8);
            pieces[4] = new Corner(Color.green, Color.orange, Color.yellow, 'l', 'b', 'd', 18);
            pieces[5] = new Corner(Color.orange, Color.blue, Color.yellow, 'b', 'r', 'd', 20);
            pieces[6] = new Corner(Color.green, Color.red, Color.yellow, 'l', 'f', 'd', 24);
            pieces[7] = new Corner(Color.red, Color.blue, Color.yellow, 'f', 'r', 'd', 26);
            pieces[20] = new Center(Color.red, 'f', 16);
            pieces[21] = new Center(Color.blue, 'r', 14);
            pieces[22] = new Center(Color.green, 'u', 4);
            pieces[23] = new Center(Color.green, 'l', 12);
            pieces[24] = new Center(Color.orange, 'b', 10);
            pieces[25] = new Center(Color.yellow, 'd', 22);
            pieces[8] = new Edge(Color.blue, Color.green,'b', 'u', 1);
            pieces[9] = new Edge(Color.green, Color.white,'l', 'u', 3);
            pieces[10] = new Edge(Color.blue, Color.white, 'r', 'u', 5);
            pieces[11] = new Edge(Color.red, Color.white, 'f', 'u', 7);
            pieces[12] = new Edge(Color.green, Color.orange, 'l', 'b', 9);
            pieces[13] = new Edge(Color.orange, Color.blue, 'b', 'r', 11);
            pieces[14] = new Edge(Color.green, Color.red, 'l', 'f', 15);
            pieces[15] = new Edge(Color.blue, Color.red, 'r', 'f',  17);
            pieces[16] = new Edge(Color.orange, Color.yellow, 'b', 'd',  19);
            pieces[17] = new Edge(Color.green, Color.yellow, 'l', 'd', 21);
            pieces[18] = new Edge(Color.blue, Color.yellow, 'r', 'd',  23);
            pieces[19] = new Edge(Color.red, Color.yellow, 'f', 'd',  25);
        }
    }
    public Cube(Color[][] colorMatrix){
        //Custom Final Cube
        pieces = new Piece[26];
        pieces[0] = new Corner(Color.green, Color.orange, colorMatrix[0][0], 'l', 'b', 'u', 0);
        pieces[1] = new Corner(Color.orange, Color.blue, colorMatrix[0][2], 'b', 'r', 'u', 2);
        pieces[2] = new Corner(Color.green, Color.red, colorMatrix[2][0], 'l', 'f', 'u', 6);
        pieces[3] = new Corner(Color.red, Color.blue, colorMatrix[2][2], 'f', 'r', 'u', 8);
        pieces[4] = new Corner(Color.green, Color.orange, Color.yellow, 'l', 'b', 'd', 18);
        pieces[5] = new Corner(Color.orange, Color.blue, Color.yellow, 'b', 'r', 'd', 20);
        pieces[6] = new Corner(Color.green, Color.red, Color.yellow, 'l', 'f', 'd', 24);
        pieces[7] = new Corner(Color.red, Color.blue, Color.yellow, 'f', 'r', 'd', 26);
        pieces[20] = new Center(Color.red, 'f', 16);
        pieces[21] = new Center(Color.blue, 'r', 14);
        pieces[22] = new Center(colorMatrix[1][1], 'u', 4);
        pieces[23] = new Center(Color.green, 'l', 12);
        pieces[24] = new Center(Color.orange, 'b', 10);
        pieces[25] = new Center(Color.yellow, 'd', 22);
        pieces[8] = new Edge(Color.blue, colorMatrix[0][1],'b', 'u', 1);
        pieces[9] = new Edge(Color.green, colorMatrix[1][0],'l', 'u', 3);
        pieces[10] = new Edge(Color.blue, colorMatrix[1][2], 'r', 'u', 5);
        pieces[11] = new Edge(Color.red, colorMatrix[2][1], 'f', 'u', 7);
        pieces[12] = new Edge(Color.green, Color.orange, 'l', 'b', 9);
        pieces[13] = new Edge(Color.orange, Color.blue, 'b', 'r', 11);
        pieces[14] = new Edge(Color.green, Color.red, 'l', 'f', 15);
        pieces[15] = new Edge(Color.blue, Color.red, 'r', 'f',  17);
        pieces[16] = new Edge(Color.orange, Color.yellow, 'b', 'd',  19);
        pieces[17] = new Edge(Color.green, Color.yellow, 'l', 'd', 21);
        pieces[18] = new Edge(Color.blue, Color.yellow, 'r', 'd',  23);
        pieces[19] = new Edge(Color.red, Color.yellow, 'f', 'd',  25);
    }
    public Piece getPiece(int i){
        return pieces[i];

    }
    public int posToX(int pos){
        if(pos % 3 == 0){
            return -1;
        }
        else if((pos - 1) % 3 == 0){
            return 0;
        }
        else{
            return 1;
        }
    }
    public int posToY(int pos){
        if(pos < 9){
            return 1;
        }
        else if(pos < 18){
            return 0;
        }
        else{
            return -1;
        }

    }
    public int xyzToPos(int x, int y, int z){
        if(y == 1){
            if(x == -1){
                if(z == -1){
                    return 6;
                }
                else if(z == 1){
                    return 0;
                }
                else{
                    return 3;
                }
            }
            else if(x == 0){
                if(z == -1){
                    return 7;
                }
                else if(z == 1){
                    return 1;
                }
                else return 4;
            }
            else if(x == 1){
                if(z == -1){
                    return 8;
                }
                else if(z == 1){
                    return 2;
                }
                else return 5;
            }
        }
        else if(y == 0){
            if(x == -1){
                if(z == -1){
                    return 15;
                }
                else if(z == 1){
                    return 9;
                }
                else{
                    return 12;
                }
            }
            else if(x == 0){
                if(z == -1){
                    return 16;
                }
                else if(z == 1){
                    return 10;
                }
                else return 13;
            }
            else if(x == 1){
                if(z == -1){
                    return 17;
                }
                else if(z == 1){
                    return 11;
                }
                else return 14;
            }
        }
        else if(y == -1){
            if(x == -1){
                if(z == -1){
                    return 24;
                }
                else if(z == 1){
                    return 18;
                }
                else{
                    return 21;
                }
            }
            else if(x == 0){
                if(z == -1){
                    return 25;
                }
                else if(z == 1){
                    return 19;
                }
                else return 22;
            }
            else if(x == 1){
                if(z == -1){
                    return 26;
                }
                else if(z == 1){
                    return 20;
                }
                else return 23;
            }
        }
        return 0;
    }
    public Piece getPosPiece(int i){
        for(int j = 0; j < pieces.length; j++){
            if(pieces[j].getPos() == i)
                return pieces[j];
        }
        return pieces[0];
    }
    public Piece getPiece(int x, int y, int z){
        for(int i = 0; i < 26; i++){
            if(pieces[i].getX() == x && pieces[i].getY() == y && pieces[i].getZ() == z){
                return pieces[i];
            }
        }
        return pieces[0];
    }
    public Piece[] getPieces(){
        return pieces;
    }


    public void r(){
        steps += "R, ";
        for(int i = 0; i < pieces.length; i++){
            if(pieces[i].getX() == 1){
                pieces[i].r();
            }
        }
    }
    public void r2(){
        steps += "R2, ";
        for(int i = 0; i < pieces.length; i++){
            if(pieces[i].getX() == 1){
                pieces[i].r();
                pieces[i].r();
            }
        }
    }
    public void rp(){
        steps += "R', ";
        for(int j = 0; j < 3; j++){
            for(int i = 0; i < pieces.length; i++){
                if(pieces[i].getX() == 1){
                    pieces[i].r();
                }
            }
        }
    }
    public void u(){
        steps += "U, ";
        for(int i = 0; i < pieces.length; i++){
            if(pieces[i].getY() == 1){
                pieces[i].u();
            }
        }
    }
    public void u2(){
        steps += "U2, ";
        for(int i = 0; i < pieces.length; i++){
            if(pieces[i].getY() == 1){
                pieces[i].u();
                pieces[i].u();
            }
        }
    }
    public void up(){
        steps += "U', ";
        for(int j = 0; j < 3; j++){
            for(int i = 0; i < pieces.length; i++){
                if(pieces[i].getY() == 1){
                    pieces[i].u();
                }
            }
        }
    }
    public void d(){
        steps += "D, ";
        for(int i = 0; i < pieces.length; i++){
            if(pieces[i].getY() == -1){
                pieces[i].d();
            }
        }
    }
    public void d2(){
        steps += "D2, ";
        for(int i = 0; i < pieces.length; i++){
            if(pieces[i].getY() == -1){
                pieces[i].d();
                pieces[i].d();
            }
        }
    }
    public void dp(){
        steps += "D', ";
        for(int j = 0; j < 3; j++){
            for(int i = 0; i < pieces.length; i++){
                if(pieces[i].getY() == -1){
                    pieces[i].d();
                }
            }
        }
    }
    public void f(){
        steps += "F, ";
        for(int i = 0; i < pieces.length; i++){
            if(pieces[i].getZ() == -1){
                pieces[i].f();
            }
        }
    }
    public void f2(){
        steps += "F2, ";
        for(int i = 0; i < pieces.length; i++){
            if(pieces[i].getZ() == -1){
                pieces[i].f();
                pieces[i].f();
            }
        }
    }
    public void fp(){
        steps += "F', ";
        for(int j = 0; j < 3; j++) {
            for (int i = 0; i < pieces.length; i++) {
                if (pieces[i].getZ() == -1) {
                    pieces[i].f();
                }
            }
        }
    }
    public void e(){
        steps += "E, ";
        for(int i = 0; i < pieces.length; i++){
            if(pieces[i].getY() == 0){
                pieces[i].e();
            }
        }
    }
    public void e2(){
        steps += "E2, ";
        for(int i = 0; i < pieces.length; i++){
            if(pieces[i].getY() == 0){
                pieces[i].e();
                pieces[i].e();
            }
        }
    }
    public void ep(){
        steps += "E', ";
        for(int j = 0; j < 3; j++){
            for(int i = 0; i < pieces.length; i++){
                if(pieces[i].getY() == 0){
                    pieces[i].e();
                }
            }
        }
    }
    public void l(){
        steps += "L, ";
        for(int i = 0; i < pieces.length; i++){
            if(pieces[i].getX() == -1){
                pieces[i].l();
            }
        }
    }
    public void lp(){
        steps += "L', ";
        for(int j = 0; j < 3; j++) {
            for (int i = 0; i < pieces.length; i++) {
                if (pieces[i].getX() == -1) {
                    pieces[i].l();
                }
            }
        }
    }
    public void l2(){
        steps += "L2, ";
        for(int i = 0; i < pieces.length; i++){
            if(pieces[i].getX() == -1){
                pieces[i].l();
                pieces[i].l();
            }
        }
    }
    public void b(){
        steps += "B, ";
        for(int i = 0; i < pieces.length; i++){
            if(pieces[i].getZ() == 1){
                pieces[i].b();
            }
        }
    }
    public void bp(){
        steps += "B', ";
        for(int j = 0; j < 3; j++){
            for(int i = 0; i < pieces.length; i++){
                if (pieces[i].getZ() == 1) {
                    pieces[i].b();
                }
            }
        }
    }
    public void b2(){
        steps += "B2, ";
        for(int i = 0; i < pieces.length; i++){
            if(pieces[i].getZ() == 1){
                pieces[i].b();
                pieces[i].b();
            }
        }
    }
    public void mp(){
        steps += "M', ";
        for(int i = 0; i < pieces.length; i++){
            if(pieces[i].getX() == 0){
                pieces[i].m();
                pieces[i].m();
                pieces[i].m();
            }
        }
    }


    public String toString(){
//        System.out.println("Moves so far: " + steps);
        String result = "";
        for(int i = 0; i < pieces.length; i++){
            result += pieces[i].toString();
        }
        return "Moves so far: " + steps;
    }
    public void addStep(String step){
        steps = steps + step;
    }
    public void clearSteps(){
        steps = "";
    }

}
