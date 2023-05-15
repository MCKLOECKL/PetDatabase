import java.util.ArrayList;
import java.util.Scanner;

public class PetDatabase {
private ArrayList<Pet> pets;

public PetDatabase() {
this.pets = new ArrayList<>();
}

public ArrayList<Pet> getPets() {
return pets;
}

public void viewAllPets()
{
if(this.pets.isEmpty())
{
System.out.println("\nSorry, no pets to show!\n");
return;
}

System.out.printf("\n%3s %10s %4s\n", "ID", "Name", "Age");
for (Pet pet : this.pets) {
System.out.printf("%3d %10s %4d\n", pet.getId(), pet.getName(), pet.getAge());
}
System.out.println();
}

public void addMorePets()
{
Scanner sc = new Scanner(System.in);
String line;
String name;
int age;

int count = 0;

System.out.println();
do
{
System.out.print("Add pet (name, age): ");
line = sc.nextLine().trim();
if(line.equalsIgnoreCase("done"))
break;
else
{
String[] data = line.split(" ");
name = data[0];
age = Integer.parseInt(data[1]);

this.pets.add(new Pet(name, age));
count++;
}
}while(!line.equalsIgnoreCase("done"));
System.out.println(count + " pets added.\n");
}

public void updatePet()
{
viewAllPets();

Scanner sc = new Scanner(System.in);
System.out.print("Enter the pet ID you can update: ");
int petId = Integer.parseInt(sc.nextLine().trim());

while(petId < 0 || petId > this.pets.size())
{
System.out.println("Please enter a valid et Id: ");
petId = Integer.parseInt(sc.nextLine().trim());
}
String oldName = this.pets.get(petId).getName();
int oldAge = this.pets.get(petId).getAge();

System.out.print("\nEnter new name and new age: ");
String line = sc.nextLine().trim();
String[] data = line.split(" ");
String name = data[0];
int age = Integer.parseInt(data[1]);

this.pets.get(petId).setName(name);
this.pets.get(petId).setAge(age);

System.out.println("\n" + oldName + " " + oldAge + " changed to "
+ this.pets.get(petId).getName() + " " + this.pets.get(petId).getAge() + "\n");
}

public void removePet()
{
viewAllPets();

Scanner sc = new Scanner(System.in);
System.out.print("Enter the pet ID to remove: ");
int petId = Integer.parseInt(sc.nextLine().trim());

while(petId < 0 || petId > this.pets.size())
{
System.out.println("Please enter a valid et Id: ");
petId = Integer.parseInt(sc.nextLine().trim());
}
String oldName = this.pets.get(petId).getName();
int oldAge = this.pets.get(petId).getAge();

this.pets.remove(petId);
System.out.println("\n" + oldName + " " + oldAge + " is removed.\n");
}

public void searchPetsByName()
{
Scanner sc = new Scanner(System.in);
System.out.print("\nEnter a name to search: ");
String nameSearch = sc.nextLine().trim();
ArrayList<Pet> tempPets = new ArrayList<>();

for(int i = 0; i < this.pets.size(); i++)
{
if(this.pets.get(i).getName().equalsIgnoreCase(nameSearch))
tempPets.add(this.pets.get(i));
}
if(tempPets.isEmpty())
System.out.println("\nNo pets with name " + nameSearch + " was found!\n");
else
{
System.out.printf("\n%3s %10s %4s\n", "ID", "Name", "Age");
for (Pet pet : tempPets) {
System.out.printf("%3d %10s %4d\n", pet.getId(), pet.getName(), pet.getAge());
}
System.out.println();
}
}

public void searchPetsByAge()
{
Scanner sc = new Scanner(System.in);
System.out.print("\nEnter age to search: ");
int ageSearch = Integer.parseInt(sc.nextLine().trim());
ArrayList<Pet> tempPets = new ArrayList<>();

for(int i = 0; i < this.pets.size(); i++)
{
if(this.pets.get(i).getAge() == ageSearch)
tempPets.add(this.pets.get(i));
}
if(tempPets.isEmpty())
System.out.println("\nNo pets with age " + ageSearch + " was found!\n");
else
{
System.out.printf("\n%3s %10s %4s\n", "ID", "Name", "Age");
for (Pet pet : tempPets) {
System.out.printf("%3d %10s %4d\n", pet.getId(), pet.getName(), pet.getAge());
}
System.out.println();
}
}
}