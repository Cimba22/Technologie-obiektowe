package vector;

public class Vector3DInheritance extends Vector2D{
    private final double z;

    public Vector3DInheritance(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public double abs() {
        double[] components = super.getComponents();
        double x = components[0];
        double y = components[1];
        return Math.sqrt(x * x + y * y + this.z * this.z);
    }

    @Override
    public double cdot(IVector iVector) {
        double x = iVector.getComponents()[0];
        double y = iVector.getComponents()[1];
        double z = iVector.getComponents()[2];
        return this.getComponents()[0] * x + this.getComponents()[1] * y + this.getComponents()[2] * z;
    }

    @Override
    public double[] getComponents() {
        double[] components = super.getComponents();
        double x = components[0];
        double y = components[1];
        return new double[]{x, y, this.z};
    }

    public Vector3DInheritance cross(IVector iVector) {
        double x = this.getY() * iVector.getComponents()[2] - this.z * iVector.getComponents()[1];
        double y = this.z * iVector.getComponents()[0] - this.getX() * iVector.getComponents()[2];
        double z = this.getX() * iVector.getComponents()[1] - this.getY() * iVector.getComponents()[0];

        return new Vector3DInheritance(x, y, z);
    }


    public IVector getSrcV() {
        return new Vector3DInheritance(getComponents()[0], getComponents()[1], this.z);
    }

    @Override
    public String toString() {
        return "Vector3DInheritance kartesjanski {" +
                "x = " + getComponents()[0] +
                ", y = " + getComponents()[1] +
                ", z = " + z +
                "}";
    }
}
