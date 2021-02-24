import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        for (Incident incident: getIncidents()) {
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

    public List<Incident> valuechk(){
        Scanner sc = new Scanner(System.in);
        List<Incident> listIncMoney = new ArrayList<>();
        System.out.println("Please enter the amount of money to check: ");
        double ammoney = sc.nextDouble();
        for (Incident incident: incidents) {
            if (incident.getValue() > ammoney) {
                listIncMoney.add(incident);
            }
        }
        return listIncMoney;
    }

    @Override
    public String toString() {
        return "District: " + name + '\n' + "   Incidents: "+ '\n' + "  " + incidents + '\n';
    }
}

