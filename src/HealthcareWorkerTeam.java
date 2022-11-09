import java.util.ArrayList;

public class HealthcareWorkerTeam implements HealthcareServiceable {

    private ArrayList<HealthcareWorker> healthcareWorkers;

    public HealthcareWorkerTeam() {
        this.healthcareWorkers = new ArrayList<>();
    }

    public void addMember(HealthcareWorker healthcareWorker) {
        this.healthcareWorkers.add(healthcareWorker);
    }

    public void addMember(HealthcareWorkerTeam healthcareWorkerTeam) {
        for (HealthcareWorker worker: healthcareWorkerTeam.getAllMember()) {
            this.healthcareWorkers.add(worker);
        }
    }

    public void removeMember(HealthcareWorker worker) {
        this.healthcareWorkers.remove(worker);
    }

    @Override
    public void service() {
        for (HealthcareWorker worker: this.healthcareWorkers) {
            worker.service();
        }
    }

    @Override
    public double getPrice() {
        return this.healthcareWorkers.stream().mapToDouble(HealthcareWorker::getPrice).sum();
    }

    public ArrayList<HealthcareWorker> getAllMember() {
        return this.healthcareWorkers;
    }
}
