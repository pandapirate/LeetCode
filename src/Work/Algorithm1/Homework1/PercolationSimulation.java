package Algorithm1.Homework1;

import java.util.Random;

public class PercolationSimulation {
    static final int N = 20;
    static Percolation p;
    static Random rand;

    static double[] results;

    public PercolationSimulation(int N, int T) {
        rand = new Random();
        results = new double[T];

        for (int i = 0; i < T; i++) {
            p = new Percolation(N);
            while (!p.percolates()) {
                openSite();
            }
            results[i] = percentOpen();
        }


        double m = mean(T);
        double std = stddev(m, T);
        double lo = confidenceLo(m, std, T);
        double hi = confidenceHi(m, std, T);
        System.out.println("N: " + N + " T: " + T);
        System.out.println("Mean: " + m);
        System.out.println("Stddev: " + std);
        System.out.println("95% Confidence: " + lo + ", " + hi);
    }

    public void openSite() {
        while (true) {
            int i = rand.nextInt(N);
            int j = rand.nextInt(N);

            if (!p.isOpen(i, j)) {
                p.open(i, j);
                break;
            }
        }
    }

    public double percentOpen() {
        int open = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (p.isOpen(i,j)) {
                    open++;
                }
            }
        }

        return open * 1.0/(N*N);
    }

    public double mean(int T) {
        double result = 0;
        for (double x : results) {
            result += x/T;
        }
        return result;
    }

    public double stddev(double mean, int T) {
        double stdev = 0;
        for (double x : results) {
            stdev += (x - mean) * (x - mean);
        }
        return Math.sqrt(stdev/(T-1));
    }

    public double confidenceLo(double mean, double stdev, int T) {
        return mean - (1.96 * stdev)/Math.sqrt(T);
    }

    public double confidenceHi(double mean, double stdev, int T) {
        return mean + (1.96 * stdev)/Math.sqrt(T);
    }

}
