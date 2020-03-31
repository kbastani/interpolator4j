package io.kbastani.math.vector;

/**
 * A 3D vector library based on the JavaScript project "Victor.js" http://victorjs.org/
 *
 * @author Kenny Bastani
 */
public class Vector {
    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public Vector invertY() {
        this.y = y * -1;
        return this;
    }

    public Vector invertX() {
        this.x = x * -1;
        return this;
    }

    public Vector invertZ() {
        this.z = z * -1;
        return this;
    }

    public Vector invert() {
        return this.invertX().invertY().invertZ();
    }

    public double[] toArray() {
        return new double[]{x, y, z};
    }

    public static Vector fromArray(double[] arr) {
        if (arr.length != 3)
            throw new RuntimeException("Array must be equal to 3");

        return new Vector(arr[0], arr[1], arr[2]);
    }

    public double angle() {
        return Math.atan2(y, x);
    }

    public double verticalAngle() {
        return Math.atan2(x, y);
    }

    public Vector add(Vector v) {
        this.x += v.getX();
        this.y += v.getY();
        this.z += v.getZ();
        return this;
    }

    public Vector subtract(Vector v) {
        this.x -= v.getX();
        this.y -= v.getY();
        this.z -= v.getZ();
        return this;
    }

    public Vector multiply(Vector v) {
        this.x *= v.getX();
        this.y *= v.getY();
        this.z *= v.getZ();
        return this;
    }

    public Vector multiply(double v) {
        this.x *= v;
        this.y *= v;
        this.z *= v;
        return this;
    }

    public double length() {
        return Math.sqrt(this.lengthSq());
    }

    public double lengthSq() {
        return (this.x * this.x) + (this.y * this.y) + (this.z * this.z);
    }

    public Vector norm() {
        double length = this.length();

        if (length == 0) {
            this.x = 1.0;
            this.y = 0.0;
            this.y = 0.0;
        } else {
            this.divide(new Vector(length, length, length));
        }

        return this;
    }

    public Vector unit() {
        double length = this.length();
        return this.divide(length);
    }

    public double angle(Vector vector) {
        return Math.acos(this.dotProduct(vector) / (this.length() * vector.length()));
    }

    public static double similarity(Vector vector1, Vector vector2) {
        return vector1.dotProduct(vector2) / (vector1.length() * vector2.length());
    }

    public double dotProduct(Vector vector) {
        double result = 0;

        result += vector.x * this.x;
        result += vector.y * this.y;
        result += vector.z * this.z;

        return result;
    }

    public Vector divide(Vector v) {
        this.x /= v.x;
        this.y /= v.y;
        this.z /= v.z;
        return this;
    }

    public Vector divide(double v) {
        this.x /= v;
        this.y /= v;
        this.z /= v;
        return this;
    }

    @Override
    public Vector clone() {
        return new Vector(this.x, this.y, this.z);
    }

    @Override
    public String toString() {
        return "Victor{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
