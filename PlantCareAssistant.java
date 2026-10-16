package plantcare;

import java.util.Scanner;

class Plant {
String name;
String type;
int wateringFrequency;
int fertilizerFrequency;
int sunlightHours;

    // Constructor for Plant class 
Plant(String name, String type, int wateringFrequency, int fertilizerFrequency, int sunlightHours)
 {
   this.name = name;
  this.type = type;
  this.wateringFrequency = wateringFrequency;
  this.fertilizerFrequency = fertilizerFrequency;
 this.sunlightHours = sunlightHours;
 }

void displayInfo() {
 System.out.println("----------------------------------------");
 System.out.println("Plant Name        : " + name);
 System.out.println("Type              : " + type);
 System.out.println("Water every       : " + wateringFrequency + " days");
 System.out.println("Fertilize every   : " + fertilizerFrequency + " days");
 System.out.println("Sunlight required : " + sunlightHours + " hours/day");
 System.out.println("----------------------------------------");
 
}

void careReminder() {
System.out.println("Care Reminder for " + name + ":");
System.out.println("-> Water every " + wateringFrequency + " days.");
System.out.println("-> Fertilize every " + fertilizerFrequency + " days.");
System.out.println("-> Provide at least " + sunlightHours + " hours of sunlight daily.");
System.out.println("Take Care Of Your Plant");
    }
}

public class PlantCareAssistant {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Plant[] plants = new Plant[20];  // maximum 20 plants
        int count = 0;
        int choice;

        System.out.println("Welcome to Plant Care Assistant");
        System.out.println("Manage and monitor your plants effectively.\n");

        do {
            System.out.println("========= MENU =========");
            System.out.println("1. Add a New Plant");
            System.out.println("2. View All Plants");
            System.out.println("3. Search for a Plant by Name");
            System.out.println("4. Update Plant Details");
            System.out.println("5. Show Care Reminders");
            System.out.println("6. Delete a Plant");
            System.out.println("7. Clear All Plant Data");
            System.out.println("8. Exit");
            System.out.println("========================");
            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            scan.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    if (count >= plants.length) {
                        System.out.println("Cannot add more plants. Maximum limit reached.");
                        break;
                    }

                    System.out.print("Enter plant name: ");
                    String name = scan.nextLine();

                    System.out.print("Enter plant type (Indoor/Outdoor): ");
                    String type = scan.nextLine();

                    System.out.print("Enter watering frequency (in days): ");
                    int watering = scan.nextInt();

                    System.out.print("Enter fertilizer frequency (in days): ");
                    int fertilizer = scan.nextInt();

                    System.out.print("Enter sunlight hours required per day: ");
                    int sunlight = scan.nextInt();
                    scan.nextLine();

                    plants[count] = new Plant(name, type, watering, fertilizer, sunlight);
                    count++;
                    System.out.println("Plant added successfully.\n");
                }

                case 2 -> {
                    if (count == 0) {
                        System.out.println("No plants added yet.\n");
                    } else {
                        System.out.println("Your Plant List:");
                        for (int i = 0; i < count; i++) {
                            plants[i].displayInfo();
                        }
                    }
                }

                case 3 -> {
                    if (count == 0) {
                        System.out.println("No plants to search.\n");
                        break;
                    }
                    System.out.print("Enter the plant name to search: ");
                    String searchName = scan.nextLine();
                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (plants[i].name.equalsIgnoreCase(searchName)) {
                            plants[i].displayInfo();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Plant not found.\n");
                    }
                }

  case 4 -> {
 if (count == 0) {
 System.out.println("No plants to update.\n");
break;
            }
                    System.out.print("Enter the plant name to update: ");
                    String updateName = scan.nextLine();

                    boolean updated = false;
                    for (int i = 0; i < count; i++) {
                        if (plants[i].name.equalsIgnoreCase(updateName)) {

    System.out.println("Enter new watering frequency (days): ");
   plants[i].wateringFrequency = scan.nextInt();

    System.out.println("Enter new fertilizer frequency (days): ");
 plants[i].fertilizerFrequency = scan.nextInt();

   System.out.println("Enter new sunlight hours required per day: ");
 plants[i].sunlightHours = scan.nextInt();

     scan.nextLine();

  System.out.println("Plant details updated successfully.\n");
   updated = true;
    break;
                        }
                    }
                    if (!updated) {
                        System.out.println("Plant not found.\n");
                    }
                }

case 5 -> {
if (count == 0) {
System.out.println("No plants to show reminders.\n");
} else {
 for (int i = 0; i < count; i++) {
 plants[i].careReminder();
 }
   }
}

 case 6 -> {
 if (count == 0) {
System.out.println("No plants to delete.\n");
break;
  }
System.out.print("Enter the plant name to delete: ");
String deleteName = scan.nextLine();
boolean deleted = false;
for (int i = 0; i < count; i++) {
if (plants[i].name.equalsIgnoreCase(deleteName)) {
for (int j = i; j < count - 1; j++) {
 plants[j] = plants[j + 1];
                            }
                            count--;
                            System.out.println("Plant deleted successfully.\n");
                            deleted = true;
                            break;
                        }
                    }
                    if (!deleted) {
                        System.out.println("Plant not found.\n");
                    }
                }

   case 7 -> {
    count = 0;
   System.out.println("All plant data cleared.\n");
                }

    case 8 -> System.out.println("Exiting Plant Care Assistant. Goodbye!");

                default -> System.out.println("Invalid choice. Please try again.\n");
     }

    } while (choice != 8);

        scan.close();
    }
}


                    