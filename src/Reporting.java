import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<Incident> incidentsList(){
        List<Incident> allIncidents = new ArrayList<>();

        for(District district : districts.values()) {
            allIncidents.addAll(district.getIncidents());
        }
        return allIncidents;
    }

    @Override
    public String toString() {
        return "Reporting{" +
                "districts=" + districts +
                '}';
    }
}
