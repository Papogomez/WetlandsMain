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
    
    /**
	 * The method takes care of finding an empty space
	 * @return, take an empty position
     */
    public boolean hasSpaceEvent(){
		boolean emptyPositionEvent = false;
		for(int i=0; i < MAX_EVENT && !emptyPositionEvent;i++){
			if(events[i]== null){
				emptyPositionEvent = true;
			}
		}
		return emptyPositionEvent;
	}
    
    /**
	 * the method this tomar una posicion del arreglo de event
	 * @return, if it finds a position the wetland is added
	 */
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
	 * The addEvent method is for add a Event.
     * @param event
	 */
	public String addEvent(Event event){
		String out="";
		int emptyPositionEvent= getEmptyPositionEvent();

		if(emptyPositionEvent==-1){
			out="The event was not added";
		}else{
			events[emptyPositionEvent]= event;
			out= "An event was recorded with the name of: "+name;
		}
	
		return out;
	}

	/**
	 * Method for returning the informations of the events.
	 */
	public void getEvent(){
		for(int i =0 ; i <MAX_EVENT; i++){
			if(events[i] != null){
				System.out.println(events[i].toString());
			}
		}
	}

    /**
	 * The method takes care of finding a event in the wetland.
	 * @param id, id the event.
	 * @return foundEvent,a event was found.
	 */
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

    /**
	 * The method is responsible for searching for a event with in the wetland.
	 * @param id, id with which the location will be found within a range of event.
	 * @return index, If no event is found, index will be false, if event is found, index will be true.
	 */
    public boolean searchEvent(String id){
		boolean index = false;
		for(int i=0; i<MAX_EVENT && !index;i++){
			if(events[i]!= null && events[i].getIdClient().equals(id));
			index= true;
		}

		return index;
	}
    
    /**
	 * The method takes care of finding an empty space
	 * @return, take an empty position
     */
    public boolean hasSpaceSpecie(){
		boolean emptyPositionSpecie = false;
		for(int i=0; i < MAX_SPECIE && !emptyPositionSpecie;i++){
			if(species[i]== null){
				emptyPositionSpecie = true;

			}
		}
		return emptyPositionSpecie;
	}
	
    
    /**
	 * the method this tomar una posicion del arreglo de specie
	 * @return, if it finds a position the wetland is added
	 */
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
			out="The species was not added";
		}else{
			species[emptyPosSpecie]= specie;
			out= "A species was recorded under the name of: "+name;
		}
	
		return out;
	}

	/**
	 * Method for returning the informations of the specie.
	 */
	public void getSpecie(){
		for(int i =0 ; i <MAX_SPECIE; i++){
			if(species[i] != null){
				System.out.println(species[i].toString());
			}
		}
	}

    /**
	 * The method takes care of finding a specie in the wetland.
	 * @param name, the name specie
	 * @return foundSpecie,a specie was found.
	 */
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

    /**
	 * The method is responsible for searching for a specie with in the wetland.
	 * @param name, name with which the location will be found within a range of specie
	 * @return index, If no specie is found, index will be false, if specie is found, index will be true.
	 */
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
        return  "Wetland name: "+name+"\n"+
                "Location of the area"+locationZone+"\n"+
                "Zone type: "+typeZone+"\n"+
                "Area: "+area+"\n"+
                "Photo: "+url+"\n"+
                "Area protect: "+protecArea;
    }

}