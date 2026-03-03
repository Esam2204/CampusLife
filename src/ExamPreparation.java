public class ExamPreparation extends PlanItem {

    private Course course;

    public ExamPreparation(String title, Course course, int estimatedHours, int daysUntil) {
        super(title, estimatedHours, daysUntil);
        this.course = course;
    }

    @Override
    public boolean isUrgent() {
        return getDaysUntil() <= 5 && !isCompleted();
    }

    @Override
    public String getCategory() {
        return "ExamPrep (" + course.getName() + ")";
    }
}
