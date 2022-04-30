package com.company;

public class Furniture {
    private String furnitureName;
    private String material;
    private String color;

    public Furniture(String furnitureName, String material, String color) {
        this.furnitureName = furnitureName;
        this.material = material;
        this.color = color;
    }

    public Furniture() {
    }

    public String getFurnitureName() {
        return furnitureName;
    }

    public void setFurnitureName(String furnitureName) {
        this.furnitureName = furnitureName;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "furnitureName='" + furnitureName + '\'' +
                ", material='" + material + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
