// This is day 2 of the GCR DSA problems homework. Maximum Volume of Water that can be trapped between bars.

package DSA_GCR.Week1.Day2;

class Maximum {
    public int maxVolume(int[] heights) {
        int max_volume = 0;
        int volume = 0;
        for (int height = 0; height < heights.length; height++) {
            for (int pair = height + 1; pair < heights.length; pair++) {
                volume = (pair - height) * (heights[height] < heights[pair] ? heights[height] : heights[pair]);
            }
            if (volume > max_volume) {
                max_volume = volume;
            }
        }
        return max_volume;
    }
}

public class RA2311003010836 {
    public static void main(String[] args) {
        int[] heights = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        Maximum mv = new Maximum();
        System.out.println("The maximum volume of water that can be trapped is: " + mv.maxVolume(heights));
    }
}
