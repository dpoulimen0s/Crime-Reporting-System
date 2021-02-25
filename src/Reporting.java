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

    @Override
    public String toString() {
        return "Reporting{" +
                "districts=" + districts +
                '}';
    }
}
