package Point;

import java.util.HashMap;

/**
 * Created by khuang on 9/14/14.
 */
public class MaxPointOnLine {

    public int maxPoints(Point[] points) {
        if (points.length <= 2) return points.length;

        HashMap<Double, Integer> map;
        int max = 2;
        for (int i = 0; i < points.length-1; i++) {
            map = new HashMap<>();
            int tempMax = 1;
            int samePoint = 0;
            for (int j = i+1; j < points.length; j++) {
                int xdiff = points[j].x - points[i].x;
                int ydiff = points[j].y - points[i].y;

                double slope = 0;

                if (xdiff == 0 && ydiff == 0) {
                    samePoint++;
                    continue;
                }

                if (xdiff == 0)
                    slope = Double.MAX_VALUE;
                else
                    slope = ydiff*1.0/xdiff;

                System.out.println(slope);
                if (map.containsKey(slope)) {
                    int val = map.get(slope) + 1;
                    map.put(slope, val);
                    if (val > tempMax) {
                        tempMax = val;
                    }
                } else {
                    map.put(slope, 2);
                    if (2 > tempMax)
                        tempMax = 2;
                }
            }
            tempMax += samePoint;

            if (tempMax > max)
                max = tempMax;
        }
        return max;
    }

    public static void main(String args[]) {

//        [(84,250),(0,0),(1,0),(0,-70),(0,-70),(1,-1),(21,10),(42,90),(-42,-230)]
        Point[] array = new Point[]{new Point(84,250), new Point(0, 0), new Point(1,0),
                new Point(0,-70), new Point(0,-70), new Point(1, -1), new Point(21,10),
                new Point(42,90), new Point(-42, -230)};
        System.out.println(new MaxPointOnLine().maxPoints(array));
    }
}
