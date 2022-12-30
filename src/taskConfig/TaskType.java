package taskConfig;

public enum TaskType {

    WORKING_TASK("рабочая"),
    PRIVATE_TASK("личная");
    private String title;

    TaskType(String title) {
        this.title = title;
    }

    public static TaskType findTypeOfTaskByTitle(String title){
        for (TaskType typeOfTask : values()) {
            if (typeOfTask.getTitle().equals(title)){
                return typeOfTask;
            }
        }
        return null;
    }
    public String getTitle() {
        return title;
    }

}
