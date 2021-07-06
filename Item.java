import java.util.ArrayList;
public class Item{
    ArrayList<String>ListBuy;
    static int count=0;
    static int Price=0;
    Item(){
        ListBuy=new ArrayList<>();
    }
    public void getApple(){
        count++;
        Price+=23000;
        ListBuy.add("Apple:    23.000vnd\n");
    }
    public void getBanana(){
        count++;
        Price+=24000;
        ListBuy.add("Banana:    24.000vnd\n");
    }
    public void getCherry(){
        count++;
        Price+=50000;
        ListBuy.add("Cherry:    50.000vnd\n");
    }
    public void getStrawBerry(){
        count++;
        Price+=70000;
        ListBuy.add("StrawBerry:    70.000vnd\n");
    }
    public void getVocado(){
        count++;
        Price+=30000;
        ListBuy.add("StrawBerry:    30.000vnd\n");
    }
    public void reset(){
        count=0;
        Price=0;
        ListBuy.clear();
    }
    public int getPrice(){return Price;}
    public int getCount(){return count;}
    public ArrayList<String> getList(){
        return ListBuy;
    }
}