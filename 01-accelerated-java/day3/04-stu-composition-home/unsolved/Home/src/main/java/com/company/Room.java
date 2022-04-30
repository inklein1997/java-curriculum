package com.company;

public class Room {
    private String roomName;
    private double size;

    private Furniture[] furnitures;

    public Room(String roomName, double size) {
        this.roomName = roomName;
        this.size = size;
    }

    public Room() {}

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Furniture[] getFurnitures() {
        return furnitures;
    }

    public void setFurnitures(Furniture[] furnitures) {
        this.furnitures = furnitures;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomName='" + roomName + '\'' +
                ", size=" + size +
                '}';
    }
}
