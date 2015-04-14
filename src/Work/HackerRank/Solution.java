package HackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{

public static final int N = 100000;
public static int[] a = new int[N + 1];
public static int[] b = new int[N + 1];

public static double dist(double x, double y, int l, int r)
{
    double d = 0;
    for (int i = l; i <=r; i++)
        {
            double dx = (x > a[i])? x - a[i] : a[i] - x;
            double dy = (y > b[i])? y - b[i] : b[i] - y;
            d += (dx > dy)? dx : dy;
        }
    return d;
}

public static double minDist(int l, int r)
{
    int xmin = a[r], xmax = a[r];
    int ymin = b[r], ymax = b[r];
    double x0, y0, xd, yd, x1, y1, x2, y2;
    double d0, d1, d2, d3;
    int i;

    for (i = l; i < r; i++)
    {
        int xx = a[i], yy = b[i];
        if (xx < xmin)
            xmin = xx;
        else if (xx > xmax)
            xmax = xx;
        if (yy < ymin)
            ymin = yy;
        else if (yy > ymax)
            ymax = yy;
    }

    x0 = xmin;
    y0 = ymin;
    xd = xmax - xmin;
    yd = ymax - ymin;

    x1 = x0 + 0.382*xd;
    x2 = x0 + 0.618*xd;
    y1 = y0 + 0.382*yd;
    y2 = y0 + 0.618*yd;

    d0 = dist(x1, y1, l, r);
    d1 = dist(x2, y1, l, r);
    d2 = dist(x2, y2, l, r);
    d3 = dist(x1, y2, l, r);

    for(;;)
    {
        double dm1 = (d0 < d1)? d1 : d0;
        double dm2 = (d2 < d3)? d3 : d2;
        double dmax = (dm1 < dm2)? dm2 : dm1;

        xd = 0.618 * xd;
        yd = 0.618 * yd;

        if (d0 < d1 && d0 < d2 && d0 < d3)
        {
            if ((dmax - d0) < 0.0001)
                return d0;

            d2 = d0;

            x1 = x0 + 0.382*xd;
            x2 = x0 + 0.618*xd;
            y1 = y0 + 0.382*yd;
            y2 = y0 + 0.618*yd;

            d0 = dist(x1, y1, l, r);
            d1 = dist(x2, y1, l, r);
            d3 = dist(x1, y2, l, r);
        }
        else if (d1 < d2 && d1 < d3)
        {
            if ((dmax - d1) < 0.0001)
                return d1;

            d3 = d1;
            x0 = x0 + 0.618 * xd;

            x1 = x0 + 0.382*xd;
            x2 = x0 + 0.618*xd;
            y1 = y0 + 0.382*yd;
            y2 = y0 + 0.618*yd;

            d0 = dist(x1, y1, l, r);
            d1 = dist(x2, y1, l, r);
            d2 = dist(x2, y2, l, r);
        }
        else if (d2 < d3)
        {
            if ((dmax - d2) < 0.0001)
                return d2;

            d0 = d2;
            x0 = x0 + 0.618 * xd;
            y0 = y0 + 0.618 * yd;

            x1 = x0 + 0.382*xd;
            x2 = x0 + 0.618*xd;
            y1 = y0 + 0.382*yd;
            y2 = y0 + 0.618*yd;

            d1 = dist(x2, y1, l, r);
            d2 = dist(x2, y2, l, r);
            d3 = dist(x1, y2, l, r);
        }
        else
        {
            if ((dmax - d3) < 0.0001)
                return d3;

            d1 = d3;
            y0 = y0 + 0.618 * yd;

            x1 = x0 + 0.382*xd;
            x2 = x0 + 0.618*xd;
            y1 = y0 + 0.382*yd;
            y2 = y0 + 0.618*yd;

            d0 = dist(x1, y1, l, r);
            d2 = dist(x2, y2, l, r);
            d3 = dist(x1, y2, l, r);
        }
    }
}

public static void main(String args[] ) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("E:\\Temp\\src\\text"));//new InputStreamReader(System.in));

    String line = br.readLine();
    StringTokenizer st = new StringTokenizer(line);

    int N = Integer.parseInt(st.nextToken());
    int Q = Integer.parseInt(st.nextToken());

    line = br.readLine();
    st = new StringTokenizer(line);
    for (int i = 1; i <= N; i++) {
        a[i] = Integer.parseInt(st.nextToken());
    }

    line = br.readLine();
    st = new StringTokenizer(line);
    for (int i = 1; i <= N; i++) {
        b[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < Q; i++) {
        line = br.readLine();
        st = new StringTokenizer(line);
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        double result = minDist(l, r);
        System.out.printf("%.7f\n", result);
    }
}

}