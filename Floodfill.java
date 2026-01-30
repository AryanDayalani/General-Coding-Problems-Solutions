//dfs approach for the Flood Fill problem

class FloodFillSolver {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image; // if new color is the same as the current color, we simply don't need to do
                          // anything

        fill(image, sr, sc, image[sr][sc], newColor); // if not, we can give first call to fill function

        return image;
    }

    private void fill(int[][] image, int sr, int sc, int iniColor, int newColor) {
        // first we need to check for the base case, if the current pixel is out of
        // bounds [invalid] or if its color is different from the initial color [not
        // connected], we return
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != iniColor)
            return;

        // if the current pixel is valid and connected, we change its color to the new
        // color
        image[sr][sc] = newColor;

        // then we make recursive calls in all four directions
        fill(image, sr + 1, sc, iniColor, newColor);
        fill(image, sr - 1, sc, iniColor, newColor);
        fill(image, sr, sc + 1, iniColor, newColor);
        fill(image, sr, sc - 1, iniColor, newColor);
    }
}

public class Floodfill {
    public static void main(String[] args) {
        FloodFillSolver solver = new FloodFillSolver();
        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1, sc = 1, newColor = 2;

        int[][] result = solver.floodFill(image, sr, sc, newColor);

        // Print the modified image
        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}