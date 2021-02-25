import java.util.*;
/**
 *This is a class for representing a Map with all District Names and its values.
 * It has methods to set
 *
 * @author Dimitris Poulimenos
 *
 */
public class Reporting {
    Map<String, District> districts;
    /**
     *Initializing the Map districts.
     */
    public Reporting(){
        districts = new HashMap<>();
    }

    public Map<String, District> getDistricts() {
        return districts;
    }

    /**
     * This is the constructor of Reporting class.It creates a map with Districts and its Incidents.
     * @param districts Represents the District List.
     */
    public Reporting(Map<String, District> districts) {
        this.districts = districts;
    }

    /**
     * This is a method which adds an Incident to a District from District List.
     * @param district Is the name of the District.
     * @param incident Is the Incident to add in the list of Incidents in District.
     */
    public void addIncident(String district, Incident incident){
        districts.get(district).getIncidents().add(incident);
    }

    /**
     * This method adds a District with its Incidents to Map districts.
     * @param name Represents the name of the District.
     * @param district Is the District with its Incidents.
     */
    public void distToMap(String name, District district) {
        districts.put(name,district);
    }

    /**
     *This method prints the average value for a given year from the user.
     */
    public void largestAv(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the year: ");
        int year = sc.nextInt();
        double sum = 0.0;
        int i = 0;
        for (Map.Entry<String, District> districtMap : districts.entrySet() ) {
            for (Incident incident : districtMap.getValue().getIncidents()) {
                if (incident.getYear() == year) {
                    sum += incident.getValue();
                    i++;
                }
            }
        }
        System.out.println("The average value for the year " + year + " is " + sum/i);
    }

    /**
     *This method prints the largest Incident value from the Map districts.
     */
    public void largestValInc(){
        double lastVal = 0.0;
        Incident tmp = null;
        for (Map.Entry<String, District> districtMap : districts.entrySet() ) {
            for (Incident incident: districtMap.getValue().getIncidents()) {
                if (incident.getValue() > lastVal){
                    lastVal = incident.getValue();
                    tmp = incident;
                }
            }
        }
        System.out.println(tmp);
    }

    /**
     *This method prints the List with Incidents greater than a given amount of money from the user.
     */
    public void listAllIncGreater(){
        List<Incident> listIncMoney = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the amount of money to check: ");
        double ammoney = sc.nextDouble();
        for (Map.Entry<String, District> districtMap : districts.entrySet() ) {
            for (Incident incident : districtMap.getValue().getIncidents()) {
                if (incident.getValue() > ammoney) {
                    listIncMoney.add(incident);
                }
            }
        }
        System.out.println("Below is the list which contains incidents with values greater than " + ammoney + '\n');
        System.out.println(listIncMoney);
    }

    /**
     *This returns a human readable version of our object (Reporting)
     * @return string representation of a List of Districts.
     */
    @Override
    public String toString() {
        return "Reporting{" +
                "districts=" + districts +
                '}';
    }
}
