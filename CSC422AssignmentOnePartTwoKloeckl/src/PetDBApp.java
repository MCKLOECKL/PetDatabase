import java.util.Scanner;

public class PetDBApp {

public static void main(String[] args)
{
System.out.println("Pet Database Program.");

Scanner sc = new Scanner(System.in);
PetDatabase petDB = new PetDatabase();

int choice;
do
{
printMenu();;
choice = Integer.parseInt(sc.nextLine().trim());
switch(choice)
{
case 1:
{
petDB.viewAllPets();
break;
}
case 2:
{
petDB.addMorePets();
break;
}
case 3:
{
petDB.updatePet();
break;
}
case 4:
{
petDB.removePet();
break;
}
case 5:
{
petDB.searchPetsByName();
break;
}
case 6:
{
petDB.searchPetsByAge();
break;
}
case 7:
{
System.out.println("Goodbye!");
System.exit(0);
}
default:
System.out.println("Invalid choice!");
}
}while(choice != 7);
}

private static void printMenu()
{
System.out.print("What would you like to do?\n"
+ "1. View all pets\n"
+ "2. Add more pets\n"
+ "3. Update an existing pet\n"
+ "4. Remove an existing pet\n"
+ "5. Search pets by name\n"
+ "6. Search pet by age\n"
+ "7. Exit\n"
+ "Your choice: ");
}
}

