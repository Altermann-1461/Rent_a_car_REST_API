package mehedintu.octavian.hwmehedintu_octavian_rentacarapp.data.models;




public class CarTypeAndNrContainer {
    String type;
    int nrOfIds;

    public CarTypeAndNrContainer(String type, int nrOfIds) {
        this.type = type;
        this.nrOfIds = nrOfIds;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNrOfIds() {
        return nrOfIds;
    }

    public void setNrOfIds(int nrOfIds) {
        this.nrOfIds = nrOfIds;
    }
}
