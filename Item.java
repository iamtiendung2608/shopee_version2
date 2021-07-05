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
        ListBuy.add("Apple");
    }
    public void getBanana(){
        count++;
        Price+=24000;
        ListBuy.add("Banana");
    }
    public void getCherry(){
        count++;
        Price+=50000;
        ListBuy.add("Cherry");
    }
    public void getStrawBerry(){
        count++;
        Price+=70000;
        ListBuy.add("StrawBerry");
    }
    public void getVocado(){
        count++;
        Price+=30000;
        ListBuy.add("StrawBerry");
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