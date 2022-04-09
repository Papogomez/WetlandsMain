package model;

public class Event{
    private String crearEvent;
    private String description;
    private String idClient;
    private double value;
    private Date dateEvent;   
    private int typeEvent;

    //Metodo constructor
    public Event(String description, String idClient, double value, Date dateEvent, int typeEvent){
        this.description = description;
        this.idClient = idClient;
        this.value = value;
        this.dateEvent = dateEvent;
        this.typeEvent = typeEvent;
    }

    /**
     * @return String return the descriptio
     */
    public String getDescriptio() {
        return description;
    }

    /**
     * @param descriptio the descriptio to set
     */
    public void setDescriptio(String descriptio) {
        this.description = descriptio;
    }

    /**
     * @return String return the crearEvent
     */
    public String getCrearEvent() {
        return crearEvent;
    }

    /**
     * @param crearEvent the crearEvent to set
     */
    public void setCrearEvent(String crearEvent) {
        this.crearEvent = crearEvent;
    }

    /**
     * @return String return the idClient
     */
    public String getIdClient() {
        return idClient;
    }

    /**
     * @param idClient the idClient to set
     */
    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    /**
     * @return double return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * @return Date return the dateEvent
     */
    public Date getDateEvent() {
        return dateEvent;
    }

    /**
     * @param dateEvent the dateEvent to set
     */
    public void setDateEvent(Date dateEvent) {
        this.dateEvent = dateEvent;
    }

    /**
     * @return int return the typeEvent
     */
    public int getTypeEvent() {
        return typeEvent;
    }

    /**
     * @param typeEvent the typeEvent to set
     */
    public void setTypeEvent(int dateEvent) {
        this.typeEvent = typeEvent;
    }

    public String toString(){
        return  "Descripcion del evento: "+description+"\n"+
                "Id del cliente: "+idClient+"\n"+
                "Costo: " + value +"\n"+
                "Fecha en el que se realizo el evento: "+dateEvent;
    }
}