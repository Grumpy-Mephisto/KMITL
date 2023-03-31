class Integrate {

  public interface FofX {
    double eval(double x);
  }

  static final int LEFT_POINT = 0;
  static final int MID_POINT = 1;
  static final int RIGHT_POINT = 2;

  static double integrate(FofX f, double a, double b, int interval, int point) {
    double sum = 0;
    double dx = (b - a) / interval;
    for (int i = 0; i < interval; i++) {
      switch (point) {
        case LEFT_POINT:
          sum += f.eval(a + i * dx) * dx;
          break;
        case MID_POINT:
          sum += f.eval(a + i * dx + dx / 2) * dx;
          break;
        case RIGHT_POINT:
          sum += f.eval(a + i * dx + dx) * dx;
          break;
      }
    }
    return sum;
  }

  static double integrate2(FofX f, double a, double b, int interval, String point) {
    double sum = 0;
    double d = b - a;
    double xi = 0;
    double factor = interval * (interval + 1) / 2;
    for (int i = 0; i < interval; i++) {
      double dxi = d * (interval - i) / factor;
      if(point == "left") {
        sum+=f.eval(xi)*dxi; // left point
      } else if(point == "right") {
        sum += f.eval(xi + dxi / 2) * dxi; // right point
      } else {
        sum+=f.eval(xi+dxi)*dxi; // mid point
      }
      xi += dxi;
    }
    return sum;
  }

  public static int FindIntegrateOne(FofX FUNCTION, int INTERVAL, int POINT, double INTEGRATE_VALUE, double LIMIT_ERROR) {
    try {
      double s = 0.0;
      for(; Math.abs(INTEGRATE_VALUE - s) > LIMIT_ERROR;) {
        s = integrate(FUNCTION, 0, 1, INTERVAL, POINT);
        INTERVAL += 1;
      }
      return INTERVAL;
    } catch (Exception e) {
      System.out.println(e);
      return -1;
    }
  }

  public static int FindIntegrateTwo(FofX FUNCTION, int INTERVAL, double INTEGRATE_VALUE, double LIMIT_ERROR, String POINT) {
    try {
      double s = 0.0;
      for(; Math.abs(INTEGRATE_VALUE - s) > LIMIT_ERROR;) {
        s = integrate2(FUNCTION, 0, 1, INTERVAL, POINT);
        INTERVAL += 1;
      }
      return INTERVAL;
    } catch (Exception e) {
      System.out.println(e);
      return -1;
    }
  }

  public static void main(String args[]) {
    // FofX f = (x) ->  x*x*x;
    FofX f1 = x -> x * x; // x^2
    FofX f2 = x -> Math.exp(x); // e^x
    int interval = args.length > 0 ? Integer.parseInt(args[0]) : 100;
    double limit_error = 0.001, integrate_value;
    
    System.out.println("f(x) = x^2");
    integrate_value = 1.0 / 3.0;
    System.out.println("----- Integrate 1 -----");
    System.out.println("LEFT: " + FindIntegrateOne(f1, interval, LEFT_POINT, integrate_value, limit_error));
    System.out.println("MIDDLE: " + FindIntegrateOne(f1, interval, MID_POINT, integrate_value, limit_error));
    System.out.println("RIGHT: " + FindIntegrateOne(f1, interval, RIGHT_POINT, integrate_value, limit_error));
    System.out.println("----- Integrate 2 -----");
    System.out.println("LEFT: " + FindIntegrateTwo(f1, interval, integrate_value, limit_error, "left"));
    System.out.println("MIDDLE: " + FindIntegrateTwo(f1, interval, integrate_value, limit_error, "mid"));
    System.out.println("RIGHT: " + FindIntegrateTwo(f1, interval, integrate_value, limit_error, "right"));
    
    System.out.println("==================================");

    System.out.println("f(x) = e^x");
    integrate_value = Math.exp(1) - 1; // e^1 - 1
    System.out.println("----- Integrate 1 -----");
    System.out.println("LEFT: " + FindIntegrateOne(f2, interval, LEFT_POINT, integrate_value, limit_error));
    System.out.println("MIDDLE: " + FindIntegrateOne(f2, interval, MID_POINT, integrate_value, limit_error));
    System.out.println("RIGHT: " + FindIntegrateOne(f2, interval, RIGHT_POINT, integrate_value, limit_error));
    System.out.println("----- Integrate 2 -----");
    System.out.println("LEFT: " + FindIntegrateTwo(f2, interval, integrate_value, limit_error, "left"));
    System.out.println("MIDDLE: " + FindIntegrateTwo(f2, interval, integrate_value, limit_error, "mid"));
    System.out.println("RIGHT: " + FindIntegrateTwo(f2, interval, integrate_value, limit_error, "right"));
  }
}