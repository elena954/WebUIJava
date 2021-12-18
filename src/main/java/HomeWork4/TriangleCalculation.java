package HomeWork4;

public class TriangleCalculation {
    public static double triangleCalculation(double a, double b, double c) throws IncorectSideException {
        if (a <= 0 || b <= 0 | c <= 0) throw new IncorectSideException("Сторона не может быть меньше или равна нулю");
        if (a + b <= c || a + c <= b || b + c <= a)
            throw new IncorectSideException("Треугольник существует тогда и только тогда, когда сумма любых двух его сторон больше третьей стороны");
        double halfPerimeter = (a + b + c) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }
}