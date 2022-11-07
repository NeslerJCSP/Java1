/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
* The Class Pet.
*/
public class Pet {

/** The name. */
private String name;

/** The age. */
private int age;

// new pet

public Pet(String name, int age) {
super();
this.name = name;
this.age = age;
}

// Gets name.
 
public String getName() {
return name;
}

// Sets name.
 
public void setName(String name) {
this.name = name;
}

// Gets age.
 
public int getAge() {
return age;
}

// Sets age.
 
public void setAge(int age) {
this.age = age;
}


@Override
public String toString() {
String s = "";
s = String.format("%5s%10s%10s%5d%5s\n", "|", name, "|", age, "|");
return s;
}

}