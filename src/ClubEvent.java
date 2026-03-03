public class ClubEvent extends PlanItem {

    public ClubEvent(String title, int estimatedHours, int daysUntil) {
        super(title, estimatedHours, daysUntil);
    }

    @Override
    public boolean isUrgent() {
        return getDaysUntil() == 0 && !isCompleted();
    }

    @Override
    public String getCategory() {
        return "ClubEvent";
    }
}
