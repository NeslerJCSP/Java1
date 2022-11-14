/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;   
import java.io.IOException;
import java.io.ObjectOutputStream;
/**
 *
 * @author Jake Nesler 
 * csc 422 Release 4
 * 
 */
public class JavaApplication2 {
 /** The pets. */
static ArrayList<Pet> pets;

/**
* The main method.
*
* @param args the arguments
*/
public static void main(String[] args) throws FileNotFoundException, IOException   {
    
pets = new ArrayList<>();
syncPetData();
    
Scanner cin = new Scanner(System.in);
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
        removeExistingPet(cin);
    break;
    case 4:
        System.out.println("Thank you for using PDBMS :)");
        saveFile();
    break;
    default:
        System.out.println("Invalid choice!");
    break;
}

} while (option != 4);

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


private static void saveFile() throws IOException {
 try {
// open a file to write
    FileWriter file = new FileWriter("C:\\Users\\Mobile Gaming\\Desktop\\javaPets.txt");
for(int i=0;i<pets.size();i++) {
file.write(String.format("%s %d\n", pets.get(i).getName(), pets.get(i).getAge()));
}
// close the file
file.close();
} catch (IOException e) {
// print error message
System.err.println("Can not save Data!");
e.printStackTrace();
}
}

//Adds pets.
private static void addMorePets(Scanner cin) {
int count = 0;
String petString = "";
do {

System.out.print("add pet (name, age): ");
petString = cin.nextLine();
if (petString.equalsIgnoreCase("done")) {

break;
}
String name = petString.split("\\s+")[0];
int age = Integer.parseInt(petString.split("\\s+")[1]);
if(petString.split(" ").length != 2)
{
    System.out.println("Invalid input");
}
else if (age < 1 || age > 20)
{
    System.out.println("Pet is an invalid age.");
}
else
{
    if(pets.size()<5) {
        pets.add(new Pet(name, age));
        count++;
    }
    else
    {
        System.out.println("Database is full! ");
        petString = "done";
    }
}
 

} while (!petString.equalsIgnoreCase("done"));
System.out.println(count + " pets added.");
}

//Read in file, update pet
private static void syncPetData(  ) throws FileNotFoundException {
    File file = new File("C:\\Users\\Mobile Gaming\\Desktop\\javaPets.txt");
 
    Scanner fin = new Scanner(file);

    String petString = "";
    int count = 0;
    
    while (fin.hasNextLine())
    {
        petString = fin.nextLine();
     
    String name = petString.split("\\s+")[0];
    int age = Integer.parseInt(petString.split("\\s+")[1]);

    pets.add(new Pet(name, age));
    count++;

    } 
}
 
  
// Update pet.
private static void updateExistingPet(Scanner cin) {
viewAllPets();
System.out.print("Enter the pet ID you want to update: ");
int id = cin.nextInt();
cin.nextLine();
System.out.print("Enter new name and new age: ");
String petString = cin.nextLine();
String name = petString.split("\\s+")[0];
int age = Integer.parseInt(petString.split("\\s+")[1]);
String oldName = pets.get(id).getName();
int oldAge = pets.get(id).getAge();
pets.get(id).setName(name);
pets.get(id).setAge(age);
System.out.println(oldName + " " + oldAge + " changed to " + name + " " + age);
}

// Removes the pet.
private static void removeExistingPet(Scanner cin) {
viewAllPets();
System.out.print("Enter the pet ID to remove: ");
int id = cin.nextInt();
cin.nextLine();
if(id < pets.size() && id > 0)
{
String name = pets.get(id).getName();
int age = pets.get(id).getAge();
pets.remove(id);
System.out.println(name + " " + age + " is removed.");
}
else 
{
    System.out.println("Out of bounds, The array has a minimum index of 0 and maximum of " + pets.size());
}
}



/*
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
*/
public static void menu() {

System.out.println("What would like to do?");
System.out.println(" 1) View all pets  ");
System.out.println(" 2) Add more pets");
System.out.println(" 3) Remove an existing pet");
System.out.println(" 4) Exit Program");
 

}
}