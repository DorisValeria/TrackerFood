import java.util.Scanner;

import java.util.Scanner;

public class Main {
    private static FoodRepository foodRepository = new FoodRepositoryImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Adaugă mâncare");
            System.out.println("2. Afișează toată mâncarea");
            System.out.println("3. Caută mâncare după ID");
            System.out.println("4. Șterge mâncare după ID");
            System.out.println("5. Modifică mâncare după ID");
            System.out.println("6. Ieșire");

            System.out.print("Alege o opțiune: ");
            int optiune = scanner.nextInt();
            scanner.nextLine();

            switch (optiune) {
                case 1:
                    adaugaMancare(scanner);
                    break;
                case 2:
                    afiseazaMancare();
                    break;
                case 3:
                    cautaMancare(scanner);
                    break;
                case 4:
                    stergeMancare(scanner);
                    break;
                case 5:
                    modificaMancare(scanner);
                    break;
                case 6:
                    System.out.println("La revedere!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opțiune invalidă!");
                    break;
            }
        }
    }

    private static void adaugaMancare(Scanner scanner) {
        System.out.print("Introduceți ID-ul mâncării: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introduceți numele mâncării: ");
        String nume = scanner.nextLine();
        System.out.print("Introduceți descrierea mâncării: ");
        String descriere = scanner.nextLine();

        Food food = new Food(id, nume, descriere);
        foodRepository.save(food);
        System.out.println("Mâncare adăugată cu succes!");
    }

    private static void afiseazaMancare() {
        System.out.println("Lista de mâncare:");
        foodRepository.findAll().forEach(food -> System.out.println(food.getId() + ". " + food.getName() + " - " + food.getDescription()));
    }

    private static void cautaMancare(Scanner scanner) {
        System.out.print("Introduceți ID-ul mâncării: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Food food = foodRepository.findById(id);
        if (food != null) {
            System.out.println("Mâncarea cu ID-ul " + id + " este: " + food.getName() + " - " + food.getDescription());
        } else {
            System.out.println("Nu a fost găsită nicio mâncare cu ID-ul " + id);
        }
    }

    private static void stergeMancare(Scanner scanner) {
        System.out.print("Introduceți ID-ul mâncării de șters: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        foodRepository.delete(id);
        System.out.println("Mâncare ștearsă cu succes!");
    }

    private static void modificaMancare(Scanner scanner) {
        System.out.print("Introduceți ID-ul mâncării de modificat: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Food existingFood = foodRepository.findById(id);
        if (existingFood != null) {
            System.out.print("Introduceți noul nume: ");
            String newNume = scanner.nextLine();
            System.out.print("Introduceți noua descriere: ");
            String newDescriere = scanner.nextLine();

            Food updatedFood = new Food(id, newNume, newDescriere);
            foodRepository.save(updatedFood);
            System.out.println("Mâncare modificată cu succes!");
        } else {
            System.out.println("Nu a fost găsită nicio mâncare cu ID-ul " + id);
        }
    }
}
