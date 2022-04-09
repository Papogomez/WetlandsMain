package model;

public class WetlandsMain{


    private static final int MAX_WETLANDS=80;
    private Wetlands [] wetlands;                                                  
    
    public WetlandsMain(){
        wetlands= new Wetlands[MAX_WETLANDS];
    }

    
    public boolean hasSpaceWetlands(){
		boolean emptyPositionWetlands = false;
		for(int i=0; i < MAX_WETLANDS && !emptyPositionWetlands;i++){
			if(wetlands[i]== null){
				emptyPositionWetlands = true;

			}
		}
		return emptyPositionWetlands;
	}
	
	
	public int getEmptyPositionWetlands(){
		boolean emptyPosWetlands = false;
		int positioWetlands= -1;

		for(int i=0;i < MAX_WETLANDS && !emptyPosWetlands; i++){
			if(wetlands[i]==null){
				emptyPosWetlands = true;
				positioWetlands = i;
			}
		}
		return positioWetlands;
	}
    public boolean searchWetlands(String id){
		boolean index = false;
		for(int i=0; i<MAX_WETLANDS && !index;i++){
			if(wetlands[i]!= null && wetlands[i].getName().equals(id));
			index= true;
		}

		return index;
	}

	/**
	 * The addWetlands method is for registering a wetland.
	 * @param name
	 * @param locationZone
	 * @param location
	 * @param typeZone
	 * @param area
	 * @param url
	 * @param protectArea
	 * @param amountManagement
	 */
	public String addWetlands(String name,String locationZone, String location, String typeZone, 
	                          double area,String url,boolean protecArea, int amountManagement){
		String out="";
		int emptyPosWetlands= getEmptyPositionWetlands();

		if(emptyPosWetlands==-1){
			out="El wetland no se agrego";
		}else{
			wetlands[emptyPosWetlands]= new Wetlands(name, locationZone, location, typeZone, area, url, protecArea, amountManagement);
			out= "Se registro un wetland con el nombre de "+name;
		}
	
		return out;
	}

	/**
	 * Method for returning the informations of the wetlangs as Strings
	 */
	public void getWetlands(){
		for(int i =0 ; i <MAX_WETLANDS; i++){
			if(wetlands[i] != null){
				System.out.println(wetlands[i].toString());
			}
		}
	}

	public int findIndexWetlands(String name){
		boolean flag=false;
		int foundWetlands=-1;
		for(int i=0; i < wetlands.length && !flag;i++){
			if(wetlands[i]!=null && wetlands[i].getName().equals(name)){
			flag = true;
			foundWetlands= i;
			}	
		}
		return foundWetlands;
	}

}