package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//购物车类
public class Cart {
    private HashMap<Items,Integer> goods;

    private Double totalPrice;
    public Cart(){
        goods = new HashMap<Items,Integer>();
        totalPrice = 0.0;
    }

    public HashMap<Items, Integer> getGoods() {
        return goods;
    }

    public void setGoods(HashMap<Items, Integer> goods) {
        this.goods = goods;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean addGoodsInCart(Items item,int number){
        if(goods.containsKey(item)){
            goods.put(item,goods.get(item)+number);
        }else {
            goods.put(item,number);
        }
        calTocalPrice();
        return true;
    }

    public boolean removeGoodsFromCart(Items item){
        goods.remove(item);
        return true;
    }

    public double calTocalPrice(){
        double sum=0.0;
        Set<Items> keys=goods.keySet();
        Iterator<Items> it =keys.iterator();
        while(it.hasNext()){
            Items i = it.next();
            sum+=i.getPrice() * goods.get(i);
        }
        this.setTotalPrice(sum);
        return this.getTotalPrice();
    }

    public static void main(String[] args) {
        Items i1 = new Items(1,"沃特篮球鞋","温州",200,500,"001.jpg");
        Items i2 = new Items(2,"李宁运动鞋","广州",300,500,"002.jpg");
        Items i3 = new Items(1,"沃特篮球鞋","温州",200,500,"001.jpg");

        Cart c = new Cart();
        c.addGoodsInCart(i1,1);
        c.addGoodsInCart(i2,2);
        c.addGoodsInCart(i3,3);

        Set<Map.Entry<Items,Integer>> items= c.getGoods().entrySet();
        for(Map.Entry<Items,Integer> obj:items){
            System.out.println(obj);
        }

        System.out.println("购物车金额:"+c.getTotalPrice());
    }
}
