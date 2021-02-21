import java.util.ArrayList;
import java.util.List;

public class District {
    private String name;
    private List<Incident> incidents;

    public District(String name) {
        this.name = name;
        incidents = new ArrayList<>();
    }

    public District(String name, List<Incident> incidents) {
        this.name = name;
        this.incidents = incidents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(List<Incident> incidents) {
        this.incidents = incidents;
    }

    public Incident highestval() {
        double lastval = 0.0;
        Incident tmp = null;

        for (Incident incident: incidents) {
            if (incident.getValue() > lastval) {
                lastval = incident.getValue();
                tmp = incident;

            }
        }
        return tmp;
    }

    public double averVal(int year1) {
        double sum = 0.0;
        int i = 0;

        for (Incident incident: incidents) {
            if (incident.getYear() == year1){
                sum += incident.getValue();
                i++;
            }
        }
        return sum/i;
    }

    @Override
    public String toString() {
        return "District{" +
                "name='" + name + '\'' +
                ", incidents=" + incidents +
                '}';
    }
}

