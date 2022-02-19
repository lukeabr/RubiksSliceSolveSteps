import javax.management.ConstructorParameters;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Steps {

    public static void main(String[] args){
//        System.out.println(testTwo());
//        fullTest();
        Cube t = new Cube("solve");
        System.out.println(solve(t));


    }


    public static void fullTest(){
        Cube rubiks = new Cube();
        System.out.println(rubiks.toString());
        rubiks.r();
        System.out.println(" ");
        System.out.println(rubiks.toString());
        rubiks.rp();
        System.out.println(" ");
        System.out.println(rubiks.toString());
        rubiks.u();
        System.out.println();
        System.out.println(rubiks.toString());
        rubiks.up();
        System.out.println();
        System.out.println(rubiks.toString());
        rubiks.d();
        System.out.println();
        System.out.println(rubiks.toString());
        rubiks.dp();
        System.out.println();
        System.out.println(rubiks.toString());
        rubiks.f();
        System.out.println();
        System.out.println(rubiks.toString());
        rubiks.fp();
        System.out.println();
        System.out.println(rubiks.toString());
        rubiks.e();
        System.out.println();
        System.out.println(rubiks.toString());
        rubiks.ep();
        System.out.println();
        System.out.println(rubiks.toString());
        rubiks.l();
        System.out.println();
        System.out.println(rubiks.toString());
        rubiks.lp();
        System.out.println();
        System.out.println(rubiks.toString());
        rubiks.b();
        System.out.println();
        System.out.println(rubiks.toString());
        rubiks.bp();
        System.out.println();
        System.out.println(rubiks.toString());
    }

    public static boolean testTwo(){
        Cube rubiks = new Cube();
        String original = rubiks.toString();
        rubiks.r();
        rubiks.l();
        rubiks.u();
        rubiks.d();
        rubiks.e();
        rubiks.f();
        rubiks.b();
        String method = rubiks.toString();
        rubiks.bp();
        rubiks.fp();
        rubiks.ep();
        rubiks.dp();
        rubiks.up();
        rubiks.lp();
        rubiks.rp();
        String methodp = rubiks.toString();
        if(methodp.equals(original) && !(methodp.equals(method))){
            return true;
        }
        return false;
    }

    public static String solve(Cube t){
        Cube c = new Cube();
//        solveCenter(t, c);
        solveEdges(t,c);
        c.addStep(" Finished Edges ");
        solveCorners(t,c);
        return c.toString();
    }

    public String allignEdges(){
        return "";
    }


    public static void moveEdgeDown(Cube c, int x, int y, int z){
        if(y == 1){
            if(x == -1){
                c.l2();
                c.d();
                c.l2();
            }
            else if(x == 1){
                c.r2();
                c.d();
                c.r2();
            }
            else if(z == -1){
                c.f2();
                c.d();
                c.f2();
            }
            else if(z == 1){
                c.b2();
                c.d();
                c.b2();
            }
        }
        else if(y == 0){
            if(x == -1 && z == -1){
                c.l();
                c.d();
                c.lp();
            }
            else if(x == -1 && z == 1){
                c.lp();
                c.d();
                c.l();
            }
            else if(z == -1 && x == 1){
                c.rp();
                c.d();
                c.r();
            }
            else if(z == 1 && x == 1){
                c.r();
                c.d();
                c.rp();
            }

        }
    }

    public static void moveEdgeFinal(Cube c, Cube t, int edgeID, int i, String col){
        if(c.getPiece(edgeID).getColorDir(col) == 'l'){
            c.lp();
            c.ep();
            c.l();
        }
        else if(c.getPiece(edgeID).getColorDir(col) == 'r'){
            c.rp();
            c.ep();
            c.r();
        }
        else if(c.getPiece(edgeID).getColorDir(col) == 'b'){
            c.b();
            c.e();
            c.bp();
        }
        else if(c.getPiece(edgeID).getColorDir(col) == 'f'){
            c.f();
            c.e();
            c.fp();
        }
        else if(c.getPiece(edgeID).getColorDir(col) == 'd'){
            if(c.getPiece(edgeID).getZ() == 1){
                c.b2();
            }
            else if(c.getPiece(edgeID).getZ() == -1){
                c.f2();
            }
            else if(c.getPiece(edgeID).getX() == -1){
                c.l2();
            }
            else if(c.getPiece(edgeID).getX() == 1){
                c.r2();
            }
        }
    }

//    public static String solveCenter(Cube t, Cube c){
//        if(!t.getPosPiece(4).getColor().equals("White") && !t.getPosPiece(4).getColor().equals("Yellow")){
//            while(!(c.getPiece(0,0, -1).contains(t.getPosPiece(4).getColor()))){
//                c.e();
//            }
//            c.mp();
//        }
//        return c.toString();
//    }

    /**
     * Moves corner into target spot
     * @param t target cube - stores all info for final configuration of corners
     * @param c current cube - stores all info for current configuration of corners
     * @param i target position of corner
     */
    public static void moveCorner(Cube t, Cube c, int i){
        int cornerID;
        for(int j = i; j < 26; j += 2){
            if(c.getPosPiece(j).contains(t.getPosPiece(i).getDirColor('u')) && c.getPosPiece(j).isCorner()) {
                if (c.getPosPiece(j).getY() == 1) {
                    moveCornerDown(c.getPosPiece(j).getX(), c.getPosPiece(j).getY(), c.getPosPiece(j).getZ(), t, c);
                }
                while(c.getPosPiece(j).getX() != t.getPosPiece(i).getX() || c.getPosPiece(j).getZ() != t.getPosPiece(i).getZ()){
                    c.d();
                }
                cornerID = java.util.Arrays.asList(c.getPieces()).indexOf(c.getPiece(c.getPosPiece(j).getX(), c.getPosPiece(j).getY(), c.getPosPiece(j).getZ()));
                moveCornerFinal(cornerID, c, t.getPosPiece(i).getDirColor('u'));
                break;
            }
        }

    }
//    int cornerID;
//    for(int x = -1; x < 2; x++){
//        for(int y = -1; y < 2; y++){
//            for(int z = -1; z < 2; z++){
//                if(c.xyzToPos(x, y, z) >= i){
//                    moveCornerDown(x, y, z, t, c);
//                    cornerID = java.util.Arrays.asList(c.getPieces()).indexOf(c.getPiece(x, y, z));
//                    while(c.getPiece(cornerID).getX() != t.getPosPiece(i).getX() || c.getPiece(cornerID).getZ() != t.getPosPiece(i).getZ()){
//                        c.d();
//                    }
//                    moveCornerFinal(cornerID, c, t.getPosPiece(i).getDirColor('u'));
//                }
//            }
//        }
//    }
    public static void moveCornerFinal(int cornerID, Cube c, String col){
        if(c.getPieces()[cornerID].getColorDir(col) == 'l'){
            if(c.getPiece(cornerID).getZ() == 1){
              c.lp();
              c.dp();
              c.l();
              c.d();
            }
            else {
                c.dp();
                c.fp();
                c.d();
                c.f();
            }
        }
        else if(c.getPieces()[cornerID].getColorDir(col) == 'r'){
            if(c.getPiece(cornerID).getZ() == 1){
                c.r();
                c.d();
                c.rp();
                c.dp();
            }
            else {
                c.rp();
                c.dp();
                c.r();
                c.d();
            }
        }
        else if(c.getPieces()[cornerID].getColorDir(col) == 'b'){
            if(c.getPiece(cornerID).getX() == -1){
                c.dp();
                c.lp();
                c.d();
                c.l();
            }
            else{
                c.d();
                c.r();
                c.dp();
                c.rp();
            }
        }
        else if(c.getPieces()[cornerID].getColorDir(col) == 'f'){
            if(c.getPiece(cornerID).getX() == -1){
                c.d();
                c.l();
                c.dp();
                c.lp();
            }
            else{
                c.dp();
                c.rp();
                c.d();
                c.r();
            }
        }
        else if(c.getPieces()[cornerID].getColorDir(col) == 'd'){
            if(c.getPiece(cornerID).getX() == -1){
                if(c.getPieces()[cornerID].getZ() == 1){
                    c.lp();
                    c.d();
                    c.l();
                    c.b();
                    c.d2();
                    c.bp();
                }
                else{
                    c.fp();
                    c.d();
                    c.f();
                    c.l();
                    c.d2();
                    c.lp();
                }
            }
            else{
                if(c.getPieces()[cornerID].getZ() == 1){
                    c.r();
                    c.dp();
                    c.rp();
                    c.bp();
                    c.d2();
                    c.b();
                }
                else{
                    c.rp();
                    c.d2();
                    c.r();
                    c.d();
                    c.rp();
                    c.dp();
                    c.r();
                }
            }
        }
    }

    public static void moveCornerDown(int x,int y, int z, Cube t, Cube c){
        if(y == 1) {
            if (x == -1) {
                if (z == 1) {
                    c.lp();
                    c.dp();
                    c.l();
                    c.d();
                }
                else if (z == -1) {
                    c.l();
                    c.d();
                    c.lp();
                    c.dp();
                }
            }
            else if(x == 1){
                if (z == 1) {
                    c.r();
                    c.d();
                    c.rp();
                    c.dp();
                }
                else if (z == -1) {
                    c.rp();
                    c.dp();
                    c.r();
                    c.d();
                }
            }
        }
    }

    public static void solveCorners(Cube t, Cube c){
        for(int i = 0; i < 9; i += 2){
             if(i != 4){
                 moveCorner(t, c, i);
             }
        }
    }


    public static void solveEdges(Cube t, Cube c){
        int edgeID;
        for(int i = 1; i < 8; i+= 2) {
            moveEdge(t, c, i);
        }
    }

    public static String moveEdge(Cube t, Cube c, int i){
        //c.addStep("Positioning " + t.getPosPiece(i).getDirColor('u') + ": ");
        int edgeID;
        //for the edges in all x positions
        for (int x = -1; x < 2; x++) {
            //for the edges in the lower two thirds of the cube
            for (int y = -1; y < 1; y++) {
                //for the edges in all depths of the cube
                for (int z = -1; z < 2; z++) {
                    //if the piece at the current location contains the color at the target location's up position, and the piece is an edge...
                    if (c.getPiece(x, y, z).contains(t.getPosPiece(i).getDirColor('u')) && c.getPiece(x, y, z).getClass() == Edge.class) {
                        //assign edgeID to the index of the piece in pieces
                        edgeID = java.util.Arrays.asList(c.getPieces()).indexOf(c.getPiece(x, y, z));
                        //move the edge down
                        moveEdgeDown(c, x, y, z);
                        //now the edge is in the bottom layer,
                        //while the pieces x or y position is wrong, move the bottom layer
                        System.out.println("Piece with " + t.getPosPiece(i).getDirColor('u') + " pointing " + c.getPiece(edgeID).getColorDir(t.getPosPiece(i).getDirColor('u')) + " at position: " + c.getPiece(edgeID).getX() + ", " + c.getPiece(edgeID).getY());
                        while(c.getPiece(edgeID).getX() != t.getPosPiece(i).getX() || c.getPiece(edgeID).getZ() != t.getPosPiece(i).getZ()){
                            //c.addStep("moving piece on bottom ");

                            c.d();
                            System.out.println(t.getPosPiece(i).getDirColor('u') + " pointing " + c.getPiece(edgeID).getColorDir(t.getPosPiece(i).getDirColor('u')) + " at position: " + c.getPiece(edgeID).getX() + ", " + c.getPiece(edgeID).getY());
                        }
                        System.out.println("Piece arrived at target location");
                        //now move the piece up
                        moveEdgeFinal(c, t, edgeID, i, t.getPosPiece(i).getDirColor('u'));
                        return "";
                    }
                }
            }
        }
        return "";
    }

}
