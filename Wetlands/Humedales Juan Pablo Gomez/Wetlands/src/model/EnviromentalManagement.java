package model;

public class EnviromentalManagement{
    private double porcentage;

    //Metodo Constructor
    public EnviromentalManagement(double porcentage) {
        this.porcentage = porcentage;
    }

    /**
     * @return double return the porcentage
     */
    public double getPorcentage() {
        return porcentage;
    }

    /**
     * @param porcentage the porcentage to set
     */
    public void setPorcentage(double porcentage) {
        this.porcentage = porcentage;
    }

    public String toString(){
        return "Porcentage: "+porcentage+"\n";
    }

}