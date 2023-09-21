import java.awt.*;
import java.util.Scanner;

public class muralDriver {

    static Color[][] colorMatrix;


    public static void imageToArray(String fn){
        PixelParser parser = new PixelParser();
        parser.loadImage(fn);

        colorMatrix = parser.getMatrix(getInt("# cubes along width: "), getInt("# cubes along height: "));
    }
    public static int getInt(String prompt){
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        return sc.nextInt();
    }
    public static void solveCube(Color[][] cubeMatrix){
        Scanner sc = new Scanner(System.in);
        Cube t = new Cube(cubeMatrix);
        Cube c = new Cube();
        System.out.println("Ready for first steps? (press enter)");
        sc.nextLine();
        Steps.solveCenter(t, c);
        System.out.println("Center: ");
        System.out.println(c.toString());
        c.clearSteps();
        System.out.println("Ready for next steps? (press enter)");
        sc.nextLine();
        Steps.solveEdges(t, c);
        System.out.println("Edges: ");
        System.out.println(c.toString());
        c.clearSteps();
        System.out.println("Ready for final steps?");
        sc.nextLine();
        Steps.solveCorners(t, c);
        System.out.println("Corner: ");
        System.out.println(c.toString());
        c.clearSteps();
        System.out.println("hello world");
    }

    public static Color[][] getCubeArr(int cubeNum){
        int row = cubeNum / (colorMatrix.length / 3);
        int col = cubeNum % (colorMatrix.length / 3);
        Color[][] cubeMatrix = new Color[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cubeMatrix[i][j] = colorMatrix[row + i][col + j];
            }

        }
        return cubeMatrix;
    }


    public static void driver(){
        Scanner sc = new Scanner(System.in);
        System.out.println(colorMatrix);
        int numofCubes = colorMatrix.length / 3 * colorMatrix[0].length / 3;
        for (int i = 0; i < numofCubes; i++) {
            System.out.println();
            System.out.println("Ready for cube #" + i + "/" + numofCubes + "? (press enter)");
            sc.nextLine();
            solveCube(getCubeArr(i));
        }
    }

    public static void main(String[] args){
        System.out.println("\n" +
                "  ___      _    _ _         __  __               _   __  __      _           \n" +
                " | _ \\_  _| |__(_) |__ ___ |  \\/  |_  _ _ _ __ _| | |  \\/  |__ _| |_____ _ _ \n" +
                " |   / || | '_ \\ | / /(_-< | |\\/| | || | '_/ _` | | | |\\/| / _` | / / -_) '_|\n" +
                " |_|_\\\\_,_|_.__/_|_\\_\\/__/ |_|  |_|\\_,_|_| \\__,_|_| |_|  |_\\__,_|_\\_\\___|_|  \n" +
                "                                                                             \n");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter image file name: ");
        imageToArray(sc.nextLine());
        driver();


    }

}
