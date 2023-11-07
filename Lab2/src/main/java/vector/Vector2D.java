package vector;

public class Vector2D implements IVector{
    private final double x;
    private final double y;

    public double getX()
    {
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double abs() {
        return Math.sqrt(getX() * getX() + getY() * getY());
    }

    @Override
    public double cdot(IVector iVector) {
        return this.getX() * iVector.getComponents()[0] + this.getY() * iVector.getComponents()[1];
    }

    @Override
    public double[] getComponents() {
        return new double[]{getX(), getY()};
    }

    @Override
    public String toString() {
        return "Vector2D kartesjanski {" +
                "x = " + getComponents()[0] +
                ", y = " + getComponents()[1] +
                "}";
    }

}
