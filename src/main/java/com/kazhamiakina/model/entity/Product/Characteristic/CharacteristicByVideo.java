package com.kazhamiakina.model.entity.Product.Characteristic;

/**
 * Created by alisa on 09.01.2017.
 */
public class CharacteristicByVideo extends ModelCharacteristic {
    private double screenSize;
    private int zoom;
    private String bodyColor;
    private double matrixPoint;
    private double matrixSize;
    private int batteryResources;

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public double getMatrixPoint() {
        return matrixPoint;
    }

    public void setMatrixPoint(double matrixPoint) {
        this.matrixPoint = matrixPoint;
    }

    public double getMatrixSize() {
        return matrixSize;
    }

    public void setMatrixSize(double matrixSize) {
        this.matrixSize = matrixSize;
    }

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public String getBodyColor() {
        return bodyColor;
    }

    public void setBodyColor(String bodyColor) {
        this.bodyColor = bodyColor;
    }

    public int getBatteryResources() {
        return batteryResources;
    }

    public void setBatteryResources(int batteryResources) {
        this.batteryResources = batteryResources;
    }

    @Override
    public String toString() {
        return "CharacteristicByVideo{" +
                "id=" + getId() +
                ", screenSize=" + screenSize +
                ", zoom='" + zoom + '\'' +
                ", bodyColor='" + bodyColor + '\'' +
                ", matrixPoint=" + matrixPoint +
                ", matrixSize=" + matrixSize +
                ", batteryResources=" + batteryResources +
                '}';
    }


}
