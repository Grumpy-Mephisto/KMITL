class Regression {
    static void LinearRegression() {
        // https://introcs.cs.princeton.edu/java/97data/LinearRegression.java.html
        double[] x = x_RadioAds();
        double[] y = y_Revenue();
        
        // first pass : compute xbar and ybar
        // sumxsqr is for other statistic param
        double sumx = 0.0, sumy = 0.0, sumxsqr = 0.0;
        for (int i = 0; i < x.length; i++) {
            sumx += x[i];
            // sumxsqr += (x[i] * x[i]);
            sumy += y[i];
        }
        double xbar = sumx / x.length;
        double ybar = sumy / y.length;

        double xxbar, yybar, xybar; // yybar for R2
        xxbar = yybar = xybar = 0.0;
        for (int i = 0; i < x.length; i++) {
            xxbar += (x[i] - xbar) * (x[i] - xbar);
            yybar += (y[i] - ybar) * (y[i] - ybar);
            xybar += (x[i] - xbar) * (y[i] - ybar);
        }
        double beta1 = xybar / xxbar;
        double beta0 = ybar - beta1 * xbar;
        System.out.printf("y = %.4f * x + %.4f%n", beta1, beta0);

        // third pass : R-squred determines the proportion of variance in the
        // dependent variable that can be explained by the independent variable.
        int df = x.length - 2;
        double rss = 0.0; // residual sum of squares
        double ssr = 0.0; // regression sum of squares

        for (int i = 0; i < x.length; i++) {
            double fit = beta1 * x[i] + beta0;
            rss += (fit - y[i]) * (fit - y[i]);
            ssr += (fit - ybar) * (fit - ybar);
        }
        double R2 = ssr / yybar;
        System.out.printf("R^2 = %.4f%n", R2);
    }

    static double[] x_RadioAds() {
        double[] x = { 21, 180, 50, 195, 96, 44, 171, 135, 120, 75, 106, 198 };
        return x;
    }

    static double[] y_Revenue() {
        double[] y = { 8_350, 22_775, 13_445, 21_100, 15_000, 12_500, 20_700, 19_722, 16_115, 13_100, 15_670, 25_300 };
        return y;
    }

    public static void main(String[] args) {
        LinearRegression();
    }
}

/*
Output:
    y = 78.1224 * x + 7925.7286
    R^2 = 0.9328
*/