import java.util.Date;

public class Vehicle {

    private int passangerCapacity;
    private String model;
    private  String  color;
    private  int year;
    private String brand;
    private int km;
    private String isReserve = "false";
    private String vehicleType;
    private Date startDate;
    private Date endDate;
    private String vehiclePlate;



    public int getPassangerCapacity() {
        return passangerCapacity;
    }

    public void setPassangerCapacity(int passangerCapacity) {
        this.passangerCapacity = passangerCapacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }
    public String getIsReserve(){
        return this.isReserve;
    }
    public void setIsReserve(String isReserve){
        this.isReserve = isReserve;

    }
    public String getVehicleType(){
        return vehicleType.toLowerCase();
    }
    public void setVehicleType(String vehicleType){
        this.vehicleType = vehicleType;
    }
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

}
