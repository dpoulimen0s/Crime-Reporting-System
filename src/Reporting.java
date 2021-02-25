import java.util.*;

public class Reporting {
    Map<String, District> districts;

    public Reporting(){
        districts = new HashMap<>();
    }

    public Map<String, District> getDistricts() {
        return districts;
    }

    public Reporting(Map<String, District> districts) {
        this.districts = districts;
    }

    public void addIncident(String district, Incident incident){
        districts.get(district).getIncidents().add(incident);
    }

    public void distToMap(String name, District district) {
        districts.put(name,district);
    }

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

    @Override
    public String toString() {
        return "Reporting{" +
                "districts=" + districts +
                '}';
    }
}
