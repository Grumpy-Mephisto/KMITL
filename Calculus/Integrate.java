class Integrate {
    public interface FofX {
        double eval(double x);
    }

    static final int LEFT_POINT = 0;
    static final int MID_POINT = 1;
    static final int RIGHT_POINT = 2;

    static double integrate(FofX f, double a, double b, int interval, int point) {
        double sum=0;
        double dx=(b-a)/interval;
        for(int i=0; i<interval; i++) {
            switch(point) {
                case LEFT_POINT: sum+=f.eval(a+i*dx)*dx; break;
                case MID_POINT: sum+=f.eval(a+i*dx+dx/2)*dx; break;
                case RIGHT_POINT: sum+=f.eval(a+i*dx+dx)*dx; break;
            }
        }
        return sum;
    }

    static double integrate2(FofX f, double a, double b, int interval) {
        double sum=0;
        double d = b-a;
        double xi=0;
        double factor=interval*(interval+1)/2;
        for(int i=0; i<interval; i++) {
            double dxi = d*(interval-i)/factor;
            //sum+=f.eval(xi)*dxi;          // left point
            sum+=f.eval(xi+dxi/2)*dxi;      // right point
            //sum+=f.eval(xi+dxi)*dxi;      // mid point
            xi+=dxi;
        }
        return sum;
    }

    public static void main(String args[]) {
        FofX f = (x) ->  x*x*x;
        //FofX f = (x) ->  Math.exp(x);
        int interval = args.length>0?Integer.parseInt(args[0]):100;
        double s = integrate(f, 0, 1, interval, MID_POINT);
        System.out.println("S: "+s);
        double s2 = integrate2(f, 0, 1, interval);
        System.out.println("S2: "+s2);
    }
}