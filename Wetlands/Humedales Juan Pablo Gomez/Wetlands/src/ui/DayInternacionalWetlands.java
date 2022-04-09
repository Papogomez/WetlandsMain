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
	

	public static void main (String[] a){
		// creando un objeto de la clase principal
		DayInternacionalWetlands obPpal = new DayInternacionalWetlands();
		
		//Llamando el método que inicializa el humedal pidiendo datos al usuario
		obPpal.initDayInternationalWetland();
		
		// variable para leer la entrada
		int option= 0;
		
		//ciclo para ejecutar el menu mientras que el usuario no
		// elija la opciOn para salir (0)
		do {
		    option = obPpal.showMenu();
		    obPpal.answerOption(option);
		}while (option !=0);


	}


	/**
	 * Metodo que se encarga de llamar a los mEtodos que resuelven cada uno de los 
	 * requerimientos de la aplicaciOn 
	 * @param userOption, int es el nUmero ingresado por el usuario (no ha sido validado) 
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

		System.out.println("\nDigite el nombre del humedal es: ");
		name=sc.nextLine();

		System.out.println("\nDigite la localizacion de la zona: "+"\n"+
                            "1) Urbana"+"\n"+
                            "2) Rural");
		locationZone=sc.nextLine();

        if(locationZone.equals("1")){
            System.out.println("\nDigite nombre del barrio:");
        }else if(locationZone.equals("2")){
            System.out.println("\nIngrese el nombre del corregimiento:");
        }
        location = sc.nextLine();

        System.out.println("\nDigite el tipo de zona:"+"\n"+
    		                "1) Publico"+"\n"+
                            "2) Privado");
        typeZone=sc.nextLine();

		System.out.println("\nDigite el area del humedal: ");
		area=sc.nextInt();

		System.out.println("\nDigite si el humedal se encuentra en un area protegida: "+"\n"+
                            "1) Si"+"\n"+
                            "2) No");
		pa = sc.nextInt();

		if (pa == 1){
			protecArea = true;
		}
		else if (pa == 2){
			protecArea = false;
		}

		System.out.println("\nDigite la url de la foto del humedal:");
		sc.nextLine();
		url = sc.nextLine();

        addWetlands(name, locationZone, location, typeZone, area, url, protecArea, amountManagement);

	}

    public boolean searchWetlands(String name){
        boolean index = false;
        for(int i=0; i<MAX_WETLANDS && !index;i++){
            if(wetlands[i]!= null && wetlands[i].getName().equals(name));
            index= true;
        }

        return index;
    }

    public void registerEvent(){

    	String description, idClient, eventDate; 
        double value;
        int typeEvent=0, year, month, day;
		Date dateEvent=null;

        System.out.println("\nDigite el nombre de la persona encargada del evento:");
		idClient=sc.nextLine();

        System.out.println("\nDigite la fecha en la cual se realizara el evento (AAAAMMDD):");
		eventDate=sc.nextLine();
		year = Integer.valueOf(eventDate.substring(0, 4));
		month = Integer.valueOf(eventDate.substring(4, 6));
		day = Integer.valueOf(eventDate.substring(6, 8));
		dateEvent = new Date(day, month, year);

        System.out.println("\nDigite el evento que se realizara:"+"\n"+
                            "1) Mantenimiento"+"\n"+
                            "2) Visitas del colegio"+"\n"+
                            "3) Actividades de mejoramiento");
        typeEvent= sc.nextInt();

        System.out.println("\nDigite el valor del evento: ");
        value =sc.nextDouble();

        System.out.println("\nDigite la descripcion del evento:");
		sc.nextLine();
		description=sc.nextLine();
        
		Event event = new Event(description, idClient, value, dateEvent, typeEvent);
        wetlands[positionLastWetland].addEvent(event);
		
	}

    public void registerSpecie(){

        String name,scientificName,typeSpecie;
        boolean migrate=false;
		int m=0;
		
        System.out.println("\nDigite el nombre de la especie:");
		name=sc.nextLine();
		
        System.out.println("\nDigite el nombre cientifico de: "+name);
		scientificName=sc.nextLine();

        System.out.println("\nDigite el tipo de especie: "+"\n"+
                            "1) Fauna "+"\n"+
                            "2) Flora");
		typeSpecie=sc.nextLine();

        System.out.println("\nDigite si la especie es migratoria:"+"\n"+
                            "1) Si"+"\n"+
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
	 * Metodo que permite crear instancias de los objetos con informaciOn ingresada
	 * por el usuario
	 */
	public void initDayInternationalWetland() {
		String nit;
		System.out.println("Bienvenido al software de control de humedales");
		wet = new WetlandsMain();
	}

	/**
	 * Metodo que muestra el menu de la aplicación
	 * @return input, int es la opciOn elegida por el usuario
	 */
	public int showMenu() {
		int input;
		System.out.println("\n\nMenu de la aplicación del control de humedales, digite una opción:\n\n"+ 
		                    "(1) Crear un humedal\n" +
		                    "(2) Registrar una nueva especie en el humedal\n" +
		                    "(3) Registrar un evento en el humedal\n"+
		                    "(4) Informar para cada humedal, la cantidad de mantenimientos en un año dado por el usuario.\n"+
		                    "(5) Desplegar el nombre del humedal con menos especies de flora.\n"+
                            "(6) Dado el nombre de una especie, desplegar los humedales donde se encuentre\n"+
                            "(7) Desplegar la información de todos nuestros humedales, incluyendo el total de especies por tipo (no incluya información de eventos).\n"+
                            "(8) Desplegar el nombre del humedal con mayor cantidad de animales (aves, mamíferos y acuáticos)\n"+
		                    "(0) Para salir\n\n" +
							"Opción: "
	
		);
		input = sc.nextInt();
		sc.nextLine();
		return input;
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
			positionLastWetland = emptyPosWetlands;
		}
	
		return out;
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

	public void mantenances(){

        int year=0;

        System.out.println("\nDigite el año del cual desea conocer los mantenimientos:");
		year=sc.nextInt();

		System.out.println(getEnviromentsManagement(year));	

	}

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

		System.out.println("El humedal con menos especies de flora es : " + specieF);	

	}

	public String getEnviromentsManagement(int year) {

		String salida="";
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
				salida = salida + "Humedal " + wetlands[i].getName() + ": " + totalManagement + "\n";
			}	
		}

		return salida;

	}

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

	public void getInformationWetlands() {

		String salida="";
		String infHumedal="";
		String infTotal="Total especies por Tipo:\n";
		String typeLocation="";
		String typeZone="";
		String protectedArea="";
		int totalFlora=0;
		int totalFauna=0;

		for(int i=0; i < wetlands.length; i++){

			if(wetlands[i]!=null){

				Wetlands wetland = wetlands[i];
				
				if (wetland.getLocationZone().equals("1")){
					typeLocation = "Urbana";
				}else if (wetland.getLocationZone().equals("2")){
					typeLocation = "Rural";
				}

				if (wetland.getTypeZone().equals("1")){
					typeZone = "Publico";
				}else if (wetland.getTypeZone().equals("2")){
					typeZone = "Privado";
				}				

				if (wetland.isProtecArea() == true){
					protectedArea = "Si";
				}else if (wetland.isProtecArea() == false){
					protectedArea = "No";
				}				

				infHumedal = infHumedal + "Humedal: " + wetland.getName() + "\n" +
				                          "Tipo Localización: " + typeLocation + ", " + 
										  "Localización: " + wetland.getLocation() + ", " +
										  "Tipo de zona: " + typeZone + ", " +
										  "Area: " + String.valueOf(wetland.getArea()) + ", " +
										  "Area protegida: " + protectedArea + ", " + 
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
				infTotal = infTotal + "Humedal " + wetlands[i].getName() + "   Fauna : " + totalFauna + "\n" +
															"                  Flora : " + totalFlora + "\n";
			}	
		}

		salida = infHumedal + infTotal;
		System.out.println(salida);

	}	

	public void speciesWetlands() {

		String specieName;

        System.out.println("\nDigite el nombre de la especie:");
		specieName=sc.nextLine();

		System.out.println(getSpeciesWetlands(specieName));	

	}	

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

		System.out.println("El humedal con mayor cantidad de animales es : " + specieF);	

	}

}