package taskConfig;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Task {

    private int id;
    private static int counter = 1;
    private String name;
    private String description;
    private TaskType typeOfTask;
    private LocalDate date;
    private LocalTime time;
    private Repeatability repeatability;
    private boolean isItDeleted = false;

    public Task(String title, String description, String typeOfTask, int year, int month, int day,
                int hour, int minutes, String repeatability) {
        this.id = counter++;
        if (title != null && !title.isEmpty() && !title.isBlank()) {
            this.name = title;
        }  else {
            throw new IllegalArgumentException("Заголовок задачи введен некорректно");
        }
        if (description != null && !description.isEmpty() && !description.isBlank()) {
            this.description = description;
        }  else {
            throw new IllegalArgumentException("Описание задачи введено некорректно");
        }
        try {
            this.typeOfTask = TaskType.findTypeOfTaskByTitle(typeOfTask.toLowerCase());
        } catch (IllegalArgumentException e){
            System.out.println("Неправильно указан тип");;
        }
        this.date = LocalDate.of(year, month, day);
        this.time = LocalTime.of(hour, minutes);
        try {
            this.repeatability =  Repeatability.findRepeatability(repeatability.toLowerCase());
        } catch (IllegalArgumentException e){
            System.out.println("Неправильно указан тип");;
        }
    }


    @Override
    public String toString() {
        return "----------\n"
                + id +
                ". " + name +
                ". " + description +
                ". " + typeOfTask.getTitle() +
                ". " + date +
                ". " + time +
                ". " + repeatability.getTitle() + ".\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(name, task.name) && Objects.equals(description, task.description) && Objects.equals(typeOfTask, task.typeOfTask) && Objects.equals(date, task.date) && Objects.equals(time, task.time) && repeatability == task.repeatability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, typeOfTask, date, time, repeatability);
    }

    public boolean isItDeleted() {
        return isItDeleted;
    }

    public void setItDeleted(boolean itDeleted) {
        this.isItDeleted = itDeleted;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskType getTypeOfTask() {
        return typeOfTask;
    }

    public void setTypeOfTask(TaskType typeOfTask) {
        this.typeOfTask = typeOfTask;
    }

    public Repeatability getRepeatability() {
        return repeatability;
    }

    public void setRepeatability(Repeatability repeatability) {
        this.repeatability = repeatability;
    }



}
