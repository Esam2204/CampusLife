public class PlanItem {

    private String title;
    private int estimatedHours;
    private int daysUntil;
    private boolean completed;

    public PlanItem(String title, int estimatedHours, int daysUntil) {
        this.title = title;
        this.estimatedHours = estimatedHours;
        this.daysUntil = daysUntil;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }

    public int getDaysUntil() {
        return daysUntil;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        completed = true;
    }

    // Базовая логика срочности
    public boolean isUrgent() {
        return daysUntil <= 2 && !completed;
    }

    public String getCategory() {
        return "General";
    }

    @Override
    public String toString() {
        return getCategory() +
                "{title='" + title +
                "', estHours=" + estimatedHours +
                ", dueIn=" + daysUntil +
                ", completed=" + completed + "}";
    }
}
