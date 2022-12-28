public class Hotel {
    private String name;
    private Room[] rooms;

    public String available(int type, int budget){
        String list = "";
        for(int i = 0; i< rooms.length;i++){
            if(rooms[i].isAvailable()&&rooms[i].getType()!=null&&budget<=rooms[i].calculatePrice()){
                list +=rooms[i].toString();
            }
        }return list;

    }
    public int income(){
        int amount = 0;
        for(int i = 0;i< rooms.length;i++){
            if(!rooms[i].isAvailable()){
                amount+=rooms[i].calculatePrice();
            }
        }return amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }
}
