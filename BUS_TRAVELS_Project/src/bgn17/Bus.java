package bgn17;
import java.util.Map;
import java.util.HashMap;
public class Bus {
	private String busNumber;
	private String sourceStation;
	private String destStation;
	private String busType;
	private String category;
	private int vacancies;
	Map<String,Integer> stationsMap =new HashMap<>();
	
	public Bus(String busNumber,String sourceStation,String destStation,
			String busType,String category,int vacancies,Map<String,Integer> stationMap) {
		this.busNumber=busNumber;
		this.sourceStation=sourceStation;
		this.destStation=destStation;
		this.busType=busType;
		this.category=category;
		this.vacancies=vacancies;
		this.stationsMap=stationMap;
	}
	
	public String getBusNumber() {
		return busNumber; 
	}
	public void setBusNumber(String busNumber) {
		this.busNumber=busNumber;
	}
	
	public String getSourceStation() {
		return sourceStation;
	}
	public void setSourceStation(String sourceStation) {
		this.sourceStation=sourceStation;
	}
	
	public String getDestStation() {
		return destStation;
	}
	public void setDestStation(String destStation) {
		this.destStation =destStation;
	}
	
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType=busType;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category=category;
	}
	
	public int getVacancies() {
		return vacancies;
	}
	public void setVacancies(int vacancies) {
		this.vacancies=vacancies;
	}
	
	public Map<String,Integer> getStationsMap(){
		return stationsMap;
	}
	public void setStationsMap (Map<String,Integer> stationsMap) {
		this.stationsMap=stationsMap;
	}
	
	@Override
	public String toString() {
		return "Bus Details \n\n[Bus Number = "+busNumber+" Boarding Station = "+sourceStation+
				" Destination Station = "+destStation+" Bus Type = "+busType+
				" Category = "+category+" Vacancies = "+vacancies+" Stations Map = "+stationsMap+"]\n";
	}
}
