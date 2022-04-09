package model;

public class Wetlands{
    private String name;
    private String locationZone;
	private String location;
    private String typeZone;
    private double area;
    private String url;
    private boolean protecArea;
    private int amountManagement;
    
    private static final int MAX_SPECIE=80;
    private Specie [] species;   
    
    private static final int MAX_EVENT=4;
    private Event [] events;

    public Wetlands(String name, String locationZone, String location, String typeZone, double area, String url, 
	                boolean protecArea, int amountManagement) {
        this.name = name;
        this.locationZone = locationZone;
		this.location = location;
        this.typeZone = typeZone;
        this.area = area;
        this.url = url;
        this.protecArea = protecArea;
        this.amountManagement=amountManagement;
        species=new Specie[MAX_SPECIE];
        events = new Event[MAX_EVENT];

    }

    public boolean hasSpaceEvent(){
		boolean emptyPositionEvent = false;
		for(int i=0; i < MAX_EVENT && !emptyPositionEvent;i++){
			if(events[i]== null){
				emptyPositionEvent = true;
			}
		}
		return emptyPositionEvent;
	}
	
	public int getEmptyPositionEvent(){
		boolean emptyPositionEvent = false;
		int positioEvent= -1;

		for(int i=0;i < MAX_EVENT && !emptyPositionEvent; i++){
			if(events[i]==null){
				emptyPositionEvent = true;
				positioEvent = i;
			}
		}
		return positioEvent;
	}

	/**
	 * The addEvent method is for registering a Event.
	 * @param typeEvent
	 * @param description
	 * @param idClient
	 * @param value
	 * @param dateEvent
	 */
	public String addEvent(Event event){
		String out="";
		int emptyPositionEvent= getEmptyPositionEvent();

		if(emptyPositionEvent==-1){
			out="El evento no se agrego";
		}else{
			events[emptyPositionEvent]= event;
			out= "Se registro un evento con el nombre de: "+name;
		}
	
		return out;
	}

	/**
	 * Method for returning the informations of the events as Strings
	 */
	public void getEvent(){
		for(int i =0 ; i <MAX_EVENT; i++){
			if(events[i] != null){
				System.out.println(events[i].toString());
			}
		}
	}

	public int findIndexEvent(String id){
		boolean flag=false;
		int foundEvent=-1;
		for(int i=0; i < events.length && !flag;i++){
			if(events[i]!=null && events[i].getIdClient().equals(id)){
			flag = true;
			foundEvent= i;
			}	
		}
		return foundEvent;
	}

    public boolean searchEvent(String id){
		boolean index = false;
		for(int i=0; i<MAX_EVENT && !index;i++){
			if(events[i]!= null && events[i].getIdClient().equals(id));
			index= true;
		}

		return index;
	}
    
    public boolean hasSpaceSpecie(){
		boolean emptyPositionSpecie = false;
		for(int i=0; i < MAX_SPECIE && !emptyPositionSpecie;i++){
			if(species[i]== null){
				emptyPositionSpecie = true;

			}
		}
		return emptyPositionSpecie;
	}
	
	public int getEmptyPositionSpecie(){
		boolean emptyPositionSpecie = false;
		int positioSpecie= -1;

		for(int i=0;i < MAX_SPECIE && !emptyPositionSpecie; i++){
			if(species[i]==null){
				emptyPositionSpecie = true;
				positioSpecie = i;
			}
		}
		return positioSpecie;
	}

	/**
	 * The addSpecie method is for registering a specie.
	 * @param specie
	 */
	public String addSpecie(Specie specie){
		String out="";
		int emptyPosSpecie= getEmptyPositionSpecie();

		if(emptyPosSpecie==-1){
			out="La especie no se agrego";
		}else{
			species[emptyPosSpecie]= specie;
			out= "Se registro una especie con el nombre de: "+name;
		}
	
		return out;
	}

	/**
	 * Method for returning the informations of the figures in the manager as Strings
	 */
	public void getSpecie(){
		for(int i =0 ; i <MAX_SPECIE; i++){
			if(species[i] != null){
				System.out.println(species[i].toString());
			}
		}
	}

	public int findIndexSpecie(String name){
		boolean flag=false;
		int foundSpecie=-1;
		for(int i=0; i < species.length && !flag;i++){
			if(species[i]!=null && species[i].getName().equals(name)){
			flag = true;
			foundSpecie= i;
			}	
		}
		return foundSpecie;
	}

    public boolean searchSpecie(String name){
		boolean index = false;
		for(int i=0; i<MAX_SPECIE&& !index;i++){
			if(species[i]!= null && species[i].getName().equals(name));
			index= true;
		}

		return index;
	}

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the locationZone
     */
    public String getLocationZone() {
        return locationZone;
    }

    /**
     * @param locationZone the locationZone to set
     */
    public void setLocationZone(String locationZone) {
        this.locationZone = locationZone;
    }

    /**
     * @return String return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return String return the typeZone
     */
    public String getTypeZone() {
        return typeZone;
    }

    /**
     * @param typeZone the typeZone to set
     */
    public void setTypeZone(String typeZone) {
        this.typeZone = typeZone;
    }

    /**
     * @return double return the area
     */
    public double getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(double area) {
        this.area = area;
    }

    /**
     * @return String return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return boolean return the protecArea
     */
    public boolean isProtecArea() {
        return protecArea;
    }

    /**
     * @param protecArea the protecArea to set
     */
    public void setProtecArea(boolean protecArea) {
        this.protecArea = protecArea;
    }

    public void setAmountManagement(int amountManagement){
        this.amountManagement = amountManagement;
    }

    public int getAmountManagement(){
        return amountManagement;
    }

    /**
     * @return Specie[] return the especies
     */
    public Specie[] getSpecies() {
        return species;
    }

    /**
     * @return Event[] return the events
     */
    public Event[] getEvents() {
        return events;
    }

    public String toString(){
        return  "Nombre del humedal: "+name+"\n"+
                "Ubicacion de la zona"+locationZone+"\n"+
                "Tipo de zona: "+typeZone+"\n"+
                "Area: "+area+"\n"+
                "Foto: "+url+"\n"+
                "Area protegida: "+protecArea;
    }

}