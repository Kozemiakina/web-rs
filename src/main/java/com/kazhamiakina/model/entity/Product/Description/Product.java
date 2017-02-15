package com.kazhamiakina.model.entity.Product.Description;

/**
 * Created by alisa on 22.01.2017.
 */
public class Product {
    private int id;
    private String type;
    private String name;
    private String model;
    private int characteristic;
    private String description;

    public int getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(int characteristic) {
        this.characteristic = characteristic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", characteristic=" + characteristic +
                ", description='" + description + '\'' +
                '}';
    }
}
