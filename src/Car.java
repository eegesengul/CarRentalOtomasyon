public class Car extends Vehicle {

    public static int carSayac=100;
    private int carID;

    public Car(){
        this.carID=carSayac;
        carSayac+=1;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }
}
