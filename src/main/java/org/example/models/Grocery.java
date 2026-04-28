package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n0 - Çıkış");
            System.out.println("1 - Ürün Ekle");
            System.out.println("2 - Ürün Sil");
            System.out.print("Seçiminiz: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // buffer temizleme

            switch (choice) {
                case 0:
                    System.out.println("Uygulama kapatıldı.");
                    running = false;
                    break;

                case 1:
                    System.out.print("Eklemek istediğiniz ürün(ler): ");
                    String addInput = scanner.nextLine();
                    addItems(addInput);
                    break;

                case 2:
                    System.out.print("Silmek istediğiniz ürün(ler): ");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    break;

                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }
    public static void addItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String cleanedItem = item.trim().toLowerCase();

            if (!checkItemIsInList(cleanedItem)) {
                groceryList.add(cleanedItem);
                System.out.println(cleanedItem + " eklendi.");
            } else {
                System.out.println(cleanedItem + " zaten listede var!");
            }
        }

        printSorted();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String cleanedItem = item.trim().toLowerCase();

            if (checkItemIsInList(cleanedItem)) {
                groceryList.remove(cleanedItem);
                System.out.println(cleanedItem + " silindi.");
            } else {
                System.out.println(cleanedItem + " listede bulunamadı!");
            }
        }

        printSorted();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);

        System.out.println("\nGüncel Liste:");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }
}
