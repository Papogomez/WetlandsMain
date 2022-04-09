package model;

public class Specie{
    private String name;
    private String nameScientific;
    private boolean migrate;
    private String typeSpecie;

    //Metodo constructor

    public Specie(String name, String nameScientific, boolean migrate, String typeSpecie){
        this.name = name;
        this.nameScientific = nameScientific;
        this.migrate= migrate;
        this.typeSpecie = typeSpecie;
        
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
     * @return String return the nameScientific
     */
    public String getNameScientific() {
        return nameScientific;
    }

    /**
     * @param nameScientific the nameScientific to set
     */
    public void setNameScientific(String nameScientific) {
        this.nameScientific = nameScientific;
    }

    /**
     * @return boolean return the migrate
     */
    public boolean isMigrate() {
        return migrate;
    }

    /**
     * @param migrate the migrate to set
     */
    public void setMigrate(boolean migrate) {
        this.migrate = migrate;
    }

    /**
     * @return String return the type
     */
    public String getTypeSpecie() {
        return typeSpecie;
    }

    /**
     * @param type the type to set
     */
    public void setTypeSpecie(String typeSpecie) {
        this.typeSpecie = typeSpecie;
    }

    public String toString(){
        return "Especie: "+name+"\n"+
                "Nombre cientifico"+nameScientific+ "\n"+
                "La especie es migratoria"+migrate+"\n"+
                "Tipo de especie"+typeSpecie;
    }

}