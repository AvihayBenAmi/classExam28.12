public class Room {
    private int number;
    private Integer type;
    private boolean available;
    private static final int STARTING_PRICE=2000,FLOOR_CHARGE=100,CLOSE_TO_ELEVATOR=200;
    private static final double EXTRA_ROOM_CHARGE=1.5, SUITE_CHARGE=2.5;

    public Room(int number, int type, boolean available) {
        this.number = number;
        this.type = type;
        this.available = available;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Integer getType() {
        return type;
    }

    public void setType(int type) {
        if(this.type==1||this.type==2||this.type==3) {
            this.type = type;
        }
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int floor(){
        int floorNumber=0;
        floorNumber=this.number/100;
        return floorNumber;
    }

    public int calculatePrice(){
        int price=STARTING_PRICE;
        int extraFee=0;
        if (floor()>10){
            extraFee=(floor()-10)*FLOOR_CHARGE;
            price+=extraFee;
        }
        if(closeToElevator()<=5){
            price+=CLOSE_TO_ELEVATOR;
        }
        if(this.type==2){
            price*=EXTRA_ROOM_CHARGE;
        }
        if(this.type==3){
            price*=SUITE_CHARGE;
        }
        return price;
    }

    public int closeToElevator(){
        int elevator;
        elevator=this.number%100;
        return elevator;
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", type=" + type +
                ", available=" + available +
                '}';
    }
}
