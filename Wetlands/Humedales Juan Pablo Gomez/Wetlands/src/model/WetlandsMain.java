package model;

public class WetlandsMain{


    private static final int MAX_WETLANDS=80;
    private Wetlands [] wetlands;                                                  
    
    public WetlandsMain(){
        wetlands= new Wetlands[MAX_WETLANDS];
    }

    /**
	 * The method takes care of finding an empty space
	 * @return, take an empty position
	 */
    public boolean hasSpaceWetlands(){
		boolean emptyPositionWetlands = false;
		for(int i=0; i < MAX_WETLANDS && !emptyPositionWetlands;i++){
			if(wetlands[i]== null){
				emptyPositionWetlands = true;

			}
		}
		return emptyPositionWetlands;
	}
	
	/**
	 * the method this tomar una posicion del arreglo de wetland
	 * @return, if it finds a position the wetland is added
	 */
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
   
	/**
	 * The wetlands method is responsible for searching for a wetland within the range the 80.
	 * @param name, Name with which the location will be found within a range of wetland.
	 * @return index, If no wetland is found, index will be false, if wetland is found, index will be true.
	 */
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
	 * @param name, name wetland
	 * @param locationZone, location zone the wetland
	 * @param location, location the wetland
	 * @param typeZone, type zone the wetland
	 * @param area, area the wetland
	 * @param url, url the wetland
	 * @param protectArea, protect area the wetland
	 * @param amountManagement, amount management the wetland
	 * @return out,show an exit message.
	 */
	public String addWetlands(String name,String locationZone, String location, String typeZone, 
	                          double area,String url,boolean protecArea, int amountManagement){
		String out="";
		int emptyPosWetlands= getEmptyPositionWetlands();

		if(emptyPosWetlands==-1){
			out="The wetland was not added";
		}else{
			wetlands[emptyPosWetlands]= new Wetlands(name, locationZone, location, typeZone, area, url, protecArea, amountManagement);
			out= "A wetland was registered under the name of "+name;
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

	/**
	 * The method takes care of finding a space in the wetland.
	 * @param name, name the wetland.
	 * @return foundWetland,a wetland was found.
	 */
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