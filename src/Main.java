public class Main {
    public static void main(String[] args) {


    }

    public String mostProfitable(Hotel[] hotels) {
        String mostProfitable = "";
        int mostProfitMoney = 0;
        for (int i = 0; i < hotels.length; i++) {
            if (hotels[i].income() > mostProfitMoney) {
                mostProfitable = hotels[i].getName();
                mostProfitMoney = hotels[i].income();
            }
        }
        return mostProfitable;
    }
}