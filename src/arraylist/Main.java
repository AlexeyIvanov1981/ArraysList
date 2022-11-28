package arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> userOperations = new ArrayList<>();
        ArrayList<String> sails = new ArrayList<>();
        sails.add("test");
        userOperations.add("Add");
        userOperations.add("Show");
        userOperations.add("Delete");
        Scanner scanner = new Scanner(System.in);

        Iterator<String> iter = userOperations.iterator();

        while (iter.hasNext()) {
            System.out.println("Choose operation: ");
            for (int i = 0; i < userOperations.size(); i++) {
                System.out.println((i + 1) + ". " + userOperations.get(i));
            }

            int userInput = scanner.nextInt();

            if (userInput == 1) {
                System.out.println("Какую покупку хотите добавить? ");
                String addSails = scanner.next();
                sails.add(addSails);
                System.out.println("Итого в списке покупок: " + sails.size());
                System.out.println();
            }

            if (userInput == 2) {
                getSails(sails);
                System.out.println();
            }
            if (userInput == 3) {
                getSails(sails);
                System.out.println("Какую хотите удалить? Введите номер или название ");
                String inputSails = scanner.next();

                int tmp;

                try {
                    tmp = Integer.parseInt(inputSails) - 1;
                    System.out.println("You are enter ToDo index. We will delete it.");
                } catch (NumberFormatException exception) {
                    tmp = sails.indexOf(inputSails);
                    System.out.println("You are enter ToDo name instead of ToDo number. We will delete it by value.");
                }

                if (tmp < sails.size()) {
                    sails.remove(tmp);
                    System.out.print("Покупка " + (tmp + 1) + " удалена! ");
                    getSails(sails);
                    System.out.println();
                } else {
                    System.out.println("You are enter an index greater than ToDo list length!");
                    String m = String.format("You have %d element(s)!", sails.size());
                    System.out.println(m);
                }
            }
        }
    }

    public static void getSails(ArrayList<String> sails) {
        System.out.println("Список покупок: ");
        for (int i = 0; i < sails.size(); i++) {
            System.out.println((i + 1) + ". " + sails.get(i));
        }
    }
}