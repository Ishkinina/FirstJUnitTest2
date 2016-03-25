import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Testtriangle {

    private Rtriangle triangle;

    @Before
    public void setUp() {
        triangle = RtriangleProvider.getRtriangle();
    }

    @Test
    public void test() {
        //  Вычисление длины сторон
        double a = length(triangle.getApexX1(), triangle.getApexY1(), triangle.getApexX2(), triangle.getApexY2());
        double b = length(triangle.getApexX2(), triangle.getApexY2(), triangle.getApexX3(), triangle.getApexY3());
        double c = length(triangle.getApexX1(), triangle.getApexY1(), triangle.getApexX3(), triangle.getApexY3());

        // Проверка на вырожденный треугольник
        if (a > 0 && b > 0 && c > 0) {

            if (skalar(triangle.getApexX1(), triangle.getApexX2(), triangle.getApexX3(), triangle.getApexY1(), triangle.getApexY2(), triangle.getApexY3()) == 0) {
            } else if (skalar(triangle.getApexX2(), triangle.getApexX3(), triangle.getApexX1(), triangle.getApexY2(), triangle.getApexY3(), triangle.getApexY1()) == 0) {
            } else if (skalar(triangle.getApexX3(), triangle.getApexX1(), triangle.getApexX2(), triangle.getApexY3(), triangle.getApexY1(), triangle.getApexY2()) == 0) {
            } else {
                Assert.fail();
            }
        } else {
            Assert.fail();
        }
    }

    private static double length( int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(1.0 * x2 - x1, 2) + Math.pow(1.0 * y2 - y1, 2));
    }

    private static long skalar(int x1, int x2, int x3, int y1, int y2, int y3) {
        return ((long)x2 - x1)*((long)x3 - x2) + ((long)y2 - y1)*((long)y3 - y2);
    }

}