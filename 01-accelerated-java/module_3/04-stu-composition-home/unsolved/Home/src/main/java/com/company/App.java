package com.company;

public class App {
    public static void main(String[] args) {
        Furniture chair1 = new Furniture();
        chair1.setFurnitureName("chair");
        chair1.setMaterial("wood");
        chair1.setColor("brown");

        Furniture chair2 = new Furniture();
        chair2.setFurnitureName("chair");
        chair2.setMaterial("wood");
        chair2.setColor("brown");

        Furniture table = new Furniture();
        table.setFurnitureName("dining table");
        table.setMaterial("wood");
        table.setColor("dark brown");

        Room diningRoom = new Room();
        diningRoom.setRoomName("Dining room");
        Furniture[] diningRoomFurniture = {table, chair2, chair1};
        diningRoom.setFurnitures(diningRoomFurniture);
        diningRoom.setSize(450);

        Home home = new Home();
        home.setStreetAddress("12345 Bigoak St.");
        home.setCity("Monterrey Bay");
        home.setState("California");
        Room[]homeRooms = {diningRoom};
        home.setRooms(homeRooms);

        System.out.println(home);
    }
}
