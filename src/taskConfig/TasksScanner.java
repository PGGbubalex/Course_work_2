package taskConfig;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class TasksScanner {
    public static void inputTask(Scanner scanner, TaskUtils taskUtils) {
        System.out.print("Введите название задачи: ");
        String taskTitle = scanner.next();
        System.out.println("Введите описание задачи:");
        String taskDescription = scanner.next();
        System.out.println("Введите тип задачи:\nРабочая\nЛичная");
        String taskType = scanner.next();
        System.out.println("Введите дату выполнения задачи в следующем формате: ГГГГ-ММ-ДД");
        scanner.nextLine();
        LocalDate taskDate = null;
        while (taskDate == null) {
            try {
                taskDate = LocalDate.parse(scanner.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Некорретктная дата");
            }
        }
        System.out.println("Введите время выполнения задачи в следующем формате: ЧЧ:ММ");
        LocalTime taskTime = null;
        while (taskTime == null) {
            try {
                taskTime = LocalTime.parse(scanner.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Некорректное время");
            }
        }
        System.out.println("Введите переодичность выполнения задачи:\n" +
                "Однократная\nЕжедневная\nЕженедельная\nЕжемесячная\nЕжегодная");
        String taskRepeatability = scanner.next();
        Task task = new Task(taskTitle, taskDescription, taskType, taskDate.getYear(),
                taskDate.getMonthValue(), taskDate.getDayOfMonth(), taskTime.getHour(),
                taskTime.getMinute(), taskRepeatability);
        taskUtils.addTask(task);
        System.out.println("Задача добавлена");
    }

    public static void deleteTask(Scanner scanner, TaskUtils taskUtils) {
        System.out.println(taskUtils.toString());
        System.out.print("Введите ID задачи: ");
        int taskId = Integer.parseInt(scanner.next());
        taskUtils.deleteTaskById(taskId);
        System.out.println("Задача удалена");
    }

    public static void printTasksByDate(Scanner scanner, TaskUtils taskUtils) {
        System.out.print("Введите дату: ");
        LocalDate taskDate = LocalDate.parse(scanner.next());
        System.out.println("Задачи на " + taskDate + ":\n" + taskUtils.getTaskByDate(taskDate).toString());
    }

    public static void editTasksTitleAndDescription(Scanner scanner, TaskUtils taskUtils) {
        System.out.println(taskUtils.toString());
        System.out.print("Введите ID задачи");
        int taskId = Integer.parseInt(scanner.next());
        System.out.println("Изменить название?");
        if (scanner.next().toLowerCase().equals("да")) {
            System.out.println("Введите новое название: ");
            taskUtils.editOnlyTitle(taskId, scanner.next());
            System.out.println("Название изменено");
            System.out.println("Изменить описание?");
            if (scanner.next().toLowerCase().equals("да")) {
                System.out.println("Введите новое описание: ");
                taskUtils.editOnlyDescription(taskId, scanner.next());
                System.out.println("Описание изменено");
            }
        } else if (scanner.next().toLowerCase().equals("нет")) {
            System.out.println("Изменить описание?");
            if (scanner.next().toLowerCase().equals("да")) {
                System.out.println("Введите новое описание: ");
                taskUtils.editOnlyDescription(taskId, scanner.next());
                System.out.println("Описание изменено");
            }
        }
    }

    public static void printTasksByPeriod(Scanner scanner, TaskUtils taskUtils) {
        System.out.print("Введите начальную дату в следующем формате: ГГГГ-ММ-ДД:");
        LocalDate firstDate = LocalDate.parse(scanner.next());
        System.out.print("Введите конечную дату в следующем формате: ГГГГ-ММ-ДД:");
        LocalDate secondDate = LocalDate.parse(scanner.next());
        System.out.println("Задачи c " + firstDate + " по " + secondDate + ":\n"
                + taskUtils.tasksByPeriod(firstDate, secondDate, taskUtils));
    }

    public static void printMenu() {
        System.out.println(
                "1. Добавить задачу\n2. Удалить задачу\n3. Показать задачи по дате\n"
                        + "4. Показать задачи по периоду\n" + "5. Редактировать заголовок и описание\n"
                        + "6. Показать удаленные задачи\n" + "0. Выход");
    }

}
