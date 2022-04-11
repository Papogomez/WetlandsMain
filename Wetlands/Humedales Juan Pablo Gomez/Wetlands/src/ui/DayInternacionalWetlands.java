package ui;
import java.util.Scanner;

import model.Wetlands;
import model.Event;
import model.WetlandsMain;

import model.Date;
import model.Specie;
public class DayInternacionalWetlands{

    private WetlandsMain wet;
    private Wetlands[] wetlands;
	private Wetlands we;
	private static final int MAX_WETLANDS=80;
	private int positionLastWetland; 

    private Scanner sc;
    
    public DayInternacionalWetlands() {
		sc= new Scanner(System.in);
		wet = new WetlandsMain();
		wetlands= new Wetlands[MAX_WETLANDS];
	}
	
	/**
	 * The methodo this Main
	 * @param a
	 */

	public static void main (String[] a){
		// creating an object of the main class
		DayInternacionalWetlands obPpal = new DayInternacionalWetlands();
		
		//Calling the method that initializes the wetland requesting data from the user
		obPpal.initDayInternationalWetland();
		
		// variable to read input
		int option= 0;
		
		// loop to execute the menu while the user does not choose the option to exit (0)
		do {
		    option = obPpal.showMenu();
		    obPpal.answerOption(option);
		}while (option !=0);


	}


	/**
	 * Method that is responsible for calling the methods that resolve each of the requirements of the application
	 * @param userOption, int is the number entered by the user (has not been validated)
	 */
	public void answerOption(int userOption) {
		switch(userOption) {
		case 0: 
	 	    break;
		case 1:
            registerWetlands();
			break;
		case 2:
            registerSpecie();
			break;
		case 3: 
			registerEvent();
			break;
		case 4: 
			mantenances();
			break;
        case 5: 
			speciesFlora();
			break;
    	case 6: 
			speciesWetlands();
			break;
        case 7: 
			getInformationWetlands();
			break;
        case 8: 
			speciesFauna();
			break;    
		}
		
		
	}

	/**
	 * Method registerWetlands, allows the user to enter the respective data of the wetland.
	 * 
	 */
	public void registerWetlands(){

        String name="", locationZone="";
		String location="";
        String typeZone="";
        double area=0;
        String url=""; 
        int pa=0;
		boolean protecArea=false;
		int amountManagement=0;

		System.out.println("\nEnter the name of the wetland is:");
		name=sc.nextLine();

		System.out.println("\nEnter the location of the area: "+"\n"+
                            "1) urban"+"\n"+
                            "2) Rural");
		locationZone=sc.nextLine();

        if(locationZone.equals("1")){
            System.out.println("\nEnter the name of the neighborhood:");
        }else if(locationZone.equals("2")){
            System.out.println("\nEnter the name of the district:");
        }
        location = sc.nextLine();

        System.out.println("\nEnter the zone type:"+"\n"+
    		                "1) Public"+"\n"+
                            "2) Private");
        typeZone=sc.nextLine();

		System.out.println("\nEnter the area of the wetlands ");
		area=sc.nextInt();

		System.out.println("\nEnter if the wetland is in a protected area:"+"\n"+
                            "1) Yes"+"\n"+
                            "2) No");
		pa = sc.nextInt();

		if (pa == 1){
			protecArea = true;
		}
		else if (pa == 2){
			protecArea = false;
		}

		System.out.println("\nEnter the url of the wetland photo:");
		sc.nextLine();
		url = sc.nextLine();

        addWetlands(name, locationZone, location, typeZone, area, url, protecArea, amountManagement);

	}

	/**
	 * The wetlands method is responsible for searching for a wetland within the range the 80.
	 * @param name, Name with which the location will be found within a range of wetland.
	 * @return index, If no wetland is found, index will be false, if wetland is found, index will be true.
	 */
    public boolean searchWetlands(String name){
        boolean index = false;
        for(int i=0; i<MAX_WETLANDS && !index;i++){
            if(wetlands[i]!= null && wetlands[i].getName().equals(name));
            index= true;
        }

        return index;
    }

	/**
	 * The method is in charge of registering a event inside the wetland.
	 */
    public void registerEvent(){

    	String description, idClient, eventDate; 
        double value;
        int typeEvent=0, year, month, day;
		Date dateEvent=null;

        System.out.println("\nEnter the name of the person in charge of the event:");
		idClient=sc.nextLine();

        System.out.println("\nEnter the date on which the event will take place (YYYYMMDD):");
		eventDate=sc.nextLine();
		year = Integer.valueOf(eventDate.substring(0, 4));
		month = Integer.valueOf(eventDate.substring(4, 6));
		day = Integer.valueOf(eventDate.substring(6, 8));
		dateEvent = new Date(day, month, year);

        System.out.println("\nEnter the event to be held:"+"\n"+
                            "1)	Maintenance"+"\n"+
                            "2) School visits"+"\n"+
                            "3) Improvement activities");
        typeEvent= sc.nextInt();

        System.out.println("\nEnter the value of the event: ");
        value =sc.nextDouble();

        System.out.println("\nEnter the description of the event:");
		sc.nextLine();
		description=sc.nextLine();
        
		Event event = new Event(description, idClient, value, dateEvent, typeEvent);
        wetlands[positionLastWetland].addEvent(event);
		
	}

	/**
	 * The method is in charge of registering a specie inside the wetland.
	 */
    public void registerSpecie(){

        String name,scientificName,typeSpecie;
        boolean migrate=false;
		int m=0;
		
        System.out.println("\nType the name of the species:		");
		name=sc.nextLine();
		
        System.out.println("\nEnter the scientific name of: "+name);
		scientificName=sc.nextLine();

        System.out.println("\nEnter the type of species: "+"\n"+
                            "1) Fauna "+"\n"+
                            "2) Flora");
		typeSpecie=sc.nextLine();

        System.out.println("\nEnter if the species is migratory:"+"\n"+
                            "1) Yes"+"\n"+
                            "2) No");
        m = sc.nextInt();

		if (m == 1){
			migrate = true;
		} else if (m == 2){
			migrate = false;
		}

		Specie specie = new Specie( name, scientificName,  migrate, typeSpecie);
        wetlands[positionLastWetland].addSpecie(specie);
     
	}

	/**
	 * This method is used to display a message when the application starts.
	 */
	public void initDayInternationalWetland() {
		String nit;
		System.out.println("Welcome to wetland monitoring software");
		wet = new WetlandsMain();
	}

	/**
	 * Method that shows the application menu
	 * @return input, int is the option chosen by the user.
	 */
	public int showMenu() {
		int input;
		System.out.println("\n\nWetland control application menu, type an option:\n\n"+ 
		                    "(1) Create a wetland\n" +
		                    "(2) Register a new species in the wetland\n" +
		                    "(3) Register an event in the wetland\n"+
		                    "(4) Inform for each wetland, the amount of maintenance in a year given by the user.\n"+
		                    "(5) Display the name of the wetland with fewer species of flora.\n"+
                            "(6) Dado el nombre de una especie, desplegar los humedales donde se encuentre\n"+
                            "(7) Display the information of all our wetlands, including the total number of species by type (do not include information on events).\n"+
                            "(8) Display the name of the wetland with the largest number of animals (birds, mammals and aquatic)\n"+
		                    "(0) To go out\n\n" +
							"Option: "
	
		);
		input = sc.nextInt();
		sc.nextLine();
		return input;
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
			out= "A wetland was registered under the name of"+name;
			positionLastWetland = emptyPosWetlands;
		}
	
		return out;
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

	/**
	 * The method this is in charge of the maintenance of the wetland

	 */
	public void mantenances(){

        int year=0;

        System.out.println("\nEnter the year for which you want to know the maintenance:");
		year=sc.nextInt();

		System.out.println(getEnviromentsManagement(year));	

	}

	/**
	 * The method it is responsible for finding the species with the least flora

	 */
	public void speciesFlora(){

        String specieF="";
		int totalFlora=999;
		int result=0;

		for(int i=0; i < wetlands.length; i++){
			if(wetlands[i]!=null){
				result = getNumSpecieFlora(wetlands[i]);
				if (result < totalFlora){
					specieF = wetlands[i].getName();
					totalFlora = result;
				}
			}
		}

		System.out.println("The wetland with fewer species of flora is: " + specieF);	

	}

	/**
	 * The method is in charge of finding all the maintenance carried out in an event taking the year in which a wetland was registered.
	 * @param year, Year the register event of the mantenance in the wetlands.
	 * @return exit, If a maintenance is found, 1 is added.
	 */
	public String getEnviromentsManagement(int year) {

		String exit="";
		int totalManagement=0;

		for(int i=0; i < wetlands.length; i++){
			if(wetlands[i]!=null){
				totalManagement = 0;
				Event[] events = wetlands[i].getEvents();
				for(int j=0; j < events.length; j++){
					Event event = events[j];
					if (event != null) {
						if (event.getDateEvent().getYear() == year && event.getTypeEvent() == 1) {
							totalManagement = totalManagement + 1;
						}
					}
				}
				exit = exit + "Humedal " + wetlands[i].getName() + ": " + totalManagement + "\n";
			}	
		}

		return exit;

	}

	/**
	 * the method takes the number of species of flora within a wetland.
	 * @param wetland, wetland.
	 * @return, total number of flora species.
	 */
	public int getNumSpecieFlora(Wetlands wetland) {

		int total=0;

		Specie[] species = wetland.getSpecies();
		for(int i=0; i < species.length; i++){
			Specie specie = species[i];
			if (specie != null) {
				if (specie.getTypeSpecie().equals("2")) {
					total = total + 1;
				}
			}
		}

		return total;
	}

	/**
	 * the method takes the number of species of fauna within a wetland.
	 * @param wetland, wetland.
	 * @return, total number of fauna species.
	 */
	public int getNumSpecieFauna(Wetlands wetland) {

		int total=0;

		Specie[] species = wetland.getSpecies();
		for(int i=0; i < species.length; i++){
			Specie specie = species[i];
			if (specie != null) {
				if (specie.getTypeSpecie().equals("1")) {
					total = total + 1;
				}
			}
		}

		return total;
	}

	/**
	 * The method is in charge of taking all the information of the wetlands.
	 */
	public void getInformationWetlands() {

		String salida="";
		String infHumedal="";
		String infTotal="Total species by Type:\n";
		String typeLocation="";
		String typeZone="";
		String protectedArea="";
		int totalFlora=0;
		int totalFauna=0;

		for(int i=0; i < wetlands.length; i++){

			if(wetlands[i]!=null){

				Wetlands wetland = wetlands[i];
				
				if (wetland.getLocationZone().equals("1")){
					typeLocation = "Urban";
				}else if (wetland.getLocationZone().equals("2")){
					typeLocation = "Rural";
				}

				if (wetland.getTypeZone().equals("1")){
					typeZone = "Public";
				}else if (wetland.getTypeZone().equals("2")){
					typeZone = "Private";
				}				

				if (wetland.isProtecArea() == true){
					protectedArea = "Yes";
				}else if (wetland.isProtecArea() == false){
					protectedArea = "No";
				}				

				infHumedal = infHumedal + "Wetland: " + wetland.getName() + "\n" +
				                          "Type the location: " + typeLocation + ", " + 
										  "Loation: " + wetland.getLocation() + ", " +
										  "Type the zone: " + typeZone + ", " +
										  "Area: " + String.valueOf(wetland.getArea()) + ", " +
										  "Area protect: " + protectedArea + ", " + 
										  "URL: " + wetland.getUrl() + "\n\n";

				totalFlora = 0;
				totalFauna = 0;
				Specie[] species = wetlands[i].getSpecies();

				for(int j=0; j < species.length; j++){
					Specie specie = species[j];
					if (specie != null) {
						if (specie.getTypeSpecie().equals("1")) {
							totalFauna = totalFauna + 1;
						} else if(specie.getTypeSpecie().equals("2")){
							totalFlora = totalFlora + 1;
						}
					}
				}
				infTotal = infTotal + "Wetlands " + wetlands[i].getName() + "  Fauna : " + totalFauna + "\n" +
															"                  Flora : " + totalFlora + "\n";
			}	
		}

		salida = infHumedal + infTotal;
		System.out.println(salida);

	}	

	/**
	 * Show species name.
	 */
	public void speciesWetlands() {

		String specieName;

        System.out.println("\nType the name of the species:");
		specieName=sc.nextLine();

		System.out.println(getSpeciesWetlands(specieName));	

	}	

	/**
	 * The method take the species from the wetlands
	 * @param specieName, Name the specie.
	 * @return namewetlands, the name of the species.
	 */
	public String getSpeciesWetlands(String specieName) {

		String namesWetlands="";

		namesWetlands="Especie " + specieName + ": ";
		for(int i=0; i < wetlands.length; i++){

			if(wetlands[i]!=null){

				Specie[] species = wetlands[i].getSpecies();
				for(int j=0; j < species.length; j++){
					Specie specie = species[j];
					if (specie != null) {
						if (specie.getName().equals(specieName)) {
							namesWetlands = namesWetlands + wetlands[i].getName() + ", ";
						}
					}
				}

			}	
		}

		return namesWetlands;
	}	

	/**
	 * the method calculate how many species of fauna are registered.
	 */
	public void speciesFauna(){

        String specieF="";
		int totalFauna=0;
		int result=0;

		for(int i=0; i < wetlands.length; i++){
			if(wetlands[i]!=null){
				result = getNumSpecieFauna(wetlands[i]);
				if (result > totalFauna){
					specieF = wetlands[i].getName();
					totalFauna = result;
				}
			}
		}

		System.out.println("The wetland with the largest number of animals is: " + specieF);	

	}

}