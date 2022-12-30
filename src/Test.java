import taskConfig.TaskUtils;
import taskConfig.TasksScanner;

import java.util.Scanner;

import static taskConfig.TasksScanner.*;

public class Test {

    public static TaskUtils taskList = new TaskUtils();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                TasksScanner.printMenu();
                System.out.print("Выберите действие: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner, taskList);
                            break;
                        case 2:
                            deleteTask(scanner, taskList);
                            break;
                        case 3:
                            printTasksByDate(scanner, taskList);
                            break;
                        case 4:
                            printTasksByPeriod(scanner, taskList);
                            break;
                        case 5:
                            editTasksTitleAndDescription(scanner, taskList);
                            break;
                        case 6:
                            taskList.showDeletedTasks();
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Неизвестное действие");
                }
            }
        }
    }
}