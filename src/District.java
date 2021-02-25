import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *This is a class for representing a District object. This has methods
 * to set and get the values of it, also it has 3 methods to return the
 * highest value incident in a District, the largest average value in a
 * given year and Incident with value greater than a given amount of money.
 * @author Dimitris Poulimenos
 *
 */
public class District {
    private String name;
    private List<Incident> incidents;
    /**
     *This is the constructor which creates a District with a given name from the user.
     * It initializing the ArrayList incidents.
     * @param name This represents the name of the District.
     */
    public District(String name) {
        this.name = name;
        incidents = new ArrayList<>();
    }
    /**
     *This is the constructor which creates a District with a given name and an ArrayList with Incidents.
     * @param name This represents the name of the District.
     * @param incidents This represents the List of Incidents inside the District.
     */
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

    /**
     * This is a method to retrieve the higher value from all Incidents in Incident List of the District.
     * @return It returns the Incident with the higher value in a District.
     */
    public Incident highestval() {
        double lastval = 0.0;
        Incident tmp = null;
        for (Incident incident: incidents) {
            if (incident.getValue() > lastval) {
                lastval = incident.getValue();
                tmp = incident;
            }
        }
        return  tmp;
    }

    /**
     * This is a method to retrieve the average incident value recorded in the district in a given year
     * @return It returns the average incident value .
     */
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

    /**
     * This is a method to retrieve a list with Incidents greater than a given amount of money from the user.
     * @return It returns the List with Incidents.
     */
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

    /**
     *This returns a human readable version of our object (District)
     * @return string representation of a District.
     */
    @Override
    public String toString() {
        return "District: " + name + '\n' + "   Incidents: "+ '\n' + "  " + incidents + '\n';
    }
}

