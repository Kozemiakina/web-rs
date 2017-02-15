package com.kazhamiakina.model.entity.Product.Characteristic;

/**
 * Created by alisa on 09.01.2017.
 */
public class CharacteristicByLens extends ModelCharacteristic {

    private String mount;
    private int focalLength;
    private double ratio;
    private boolean autoFocus;
    private int filter;

    public int getFilter() {
        return filter;
    }

    public void setFilter(int filter) {
        this.filter = filter;
    }

    public String getMount() {
        return mount;
    }

    public void setMount(String mount) {
        this.mount = mount;
    }

    public int getFocalLength() {
        return focalLength;
    }

    public void setFocalLength(int focalLength) {
        this.focalLength = focalLength;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public boolean isAutoFocus() {
        return autoFocus;
    }

    public void setAutoFocus(boolean autoFocus) {
        this.autoFocus = autoFocus;
    }

    @Override
    public String toString() {
        return "CharacteristicByLens{" +
                ", mount='" + mount + '\'' +
                ", focalLength=" + focalLength +
                ", ratio=" + ratio +
                ", autoFocus=" + autoFocus +
                ", filter=" + filter +
                '}';
    }
}
