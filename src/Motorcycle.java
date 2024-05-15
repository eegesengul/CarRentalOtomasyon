public class Motorcycle extends Vehicle{

    public static int motorcycleSayac=200;
    private int motorcycleID;

    public Motorcycle(){
        this.motorcycleID=motorcycleSayac;
        motorcycleSayac+=1;
    }

    public int getMotorcycleID() {
        return motorcycleID;
    }

    public void setMotorcycleID(int motorcycleID) {
        this.motorcycleID = motorcycleID;
    }
}
