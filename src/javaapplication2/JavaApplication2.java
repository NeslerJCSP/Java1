/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Jake Nesler 
 */
public class JavaApplication2 {
 /** The pets. */
static ArrayList<Pet> pets;

/**
* The main method.
*
* @param args the arguments
*/
public static void main(String[] args) {

Scanner cin = new Scanner(System.in);
pets = new ArrayList<>();
int option;
do {
menu();
System.out.print("Your chioce: ");
option = cin.nextInt();
cin.nextLine();
switch (option) {
    case 1:
        viewAllPets();
    break;
    case 2:
        addMorePets(cin);
    break;
    case 3:
        updateExistingPet(cin);
    break;
    case 4:
        removeExistingPet(cin);
    break;
    case 5:
        searchByPetName(cin);
    break;
    case 6:
        searchByPetAge(cin);
    break;
    case 7:
        System.out.println("Thank you for using PDBMS :)");
    break;

    default:
System.out.println("Invalid choice!");
break;
}

} while (option != 7);

cin.close();
}

 
 // view pets.
 
private static void viewAllPets() {

System.out.println("+---------------------------------------+");
System.out.printf("|%5s%5s%10s%10s%5s%5s\n", "ID", "|", "NAME", "|", "AGE", "|");
System.out.println("+---------------------------------------+");
int i = 0;
for (Pet pet : pets) {

System.out.printf("|%5d%5s", i, pet.toString());

i++;
}
System.out.println("+---------------------------------------+");
System.out.println((i) + " rows in set.");
}

//Adds pets.

private static void addMorePets(Scanner scan) {
int count = 0;
String petString = "";
do {

System.out.print("add pet (name, age): ");
petString = scan.nextLine();
if (petString.equalsIgnoreCase("done")) {

break;
}
String name = petString.split("\\s+")[0];
int age = Integer.parseInt(petString.split("\\s+")[1]);

pets.add(new Pet(name, age));
count++;

} while (!petString.equalsIgnoreCase("done"));
System.out.println(count + " pets added.");
}

// Update pet.

private static void updateExistingPet(Scanner cin) {
System.out.print("Enter the pet ID you want to update: ");
}

// Removes the pet.

private static void removeExistingPet(Scanner cin) {

System.out.print("Enter the pet ID to remove: ");

}

// Search name.

private static void searchByPetName(Scanner cin) {

System.out.print("Enter name to search: ");
String name = cin.nextLine();

System.out.println("+---------------------------------------+");
System.out.printf("|%5s%5s%10s%10s%5s%5s\n", "ID", "|", "NAME", "|", "AGE", "|");
System.out.println("+---------------------------------------+");
int i = 0;
for (Pet pet : pets) {

if (pet.getName().equalsIgnoreCase(name)) {

System.out.printf("|%5d%5s", i, pet.toString());
i++;
}
}
System.out.println("+---------------------------------------+");
System.out.println((i) + "rows in set.");
}

// Search pet age.

private static void searchByPetAge(Scanner cin) {

System.out.print("Enter age to search: ");
int age = cin.nextInt();
cin.nextLine();
System.out.println("+---------------------------------------+");
System.out.printf("|%5s%5s%10s%10s%5s%5s\n", "ID", "|", "NAME", "|", "AGE", "|");
System.out.println("+---------------------------------------+");
int i = 0;
for (Pet pet : pets) {

if (pet.getAge() == age) {

System.out.printf("|%5d%5s", i, pet.toString());
i++;
}
}
System.out.println("+---------------------------------------+");
System.out.println((i) + "rows in set.");

}

// Menu.

public static void menu() {

System.out.println("What would like to do?");
System.out.println(" 1) View all pets  ");
System.out.println(" 2) Add more pets");
System.out.println(" 3) Update an existing pet");
System.out.println(" 4) Remove an existing pet");
System.out.println(" 5) Search pets by name");
System.out.println(" 6) Search pets by age");
System.out.println(" 7) Exit program");

        
        
 
}
}