package com.example.lab.vector;

import java.util.Arrays;

public class Vector3DDecorator implements IVector{

    private final IVector srcVector;
    private final double z;

    public Vector3DDecorator(IVector srcVector, double z) {
        this.srcVector = srcVector;
        this.z = z;
    }

    @Override
    public double abs() {
        double x = getComponents()[0];
        double y = getComponents()[1];
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

        double x = srcVector.getComponents()[0];
        double y = srcVector.getComponents()[1];
        return new double[]{x, y, this.z};
    }

    public Vector3DDecorator cross(IVector iVector) {
        double[] srcComponents = this.srcVector.getComponents();
        double[] iVectorComponents = iVector.getComponents();

        double x = srcComponents[1] * iVectorComponents[2] - this.z * iVectorComponents[1];
        double y = this.z * iVectorComponents[0] - srcComponents[0] * iVectorComponents[2];
        double z = srcComponents[0] * iVectorComponents[1] - srcComponents[1] * iVectorComponents[0];

        return new Vector3DDecorator(new Vector2D(x, y), z);
    }


    public IVector getSrcV(){
        return srcVector;
    }

    @Override
    public String toString() {
        return "Vector3DDecorator kartesjanski {" +
                "srcVector = " + Arrays.toString(srcVector.getComponents()) +
                ", z = " + z +
                '}';
    }

}
