package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {

    public static void main(String[] args) {

        try {
            System.out.println("Current saved animals file:");
            Pets.readPetsFromFile();

            int petIndex = Pets.choosePet();

            String chosenPet = Pets.retrievePet(petIndex);

            Pets.writePetToFile(chosenPet);

            System.out.println("New saved animals file:");
            Pets.readPetsFromFile();

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please choose an available pet.");
        } catch (FileNotFoundException e) {
            System.out.println("The following file does not seem to exist: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Something went wrong while writing your file.");
        } finally {
            System.out.println("Have a nice day!");
        }
    }
}
