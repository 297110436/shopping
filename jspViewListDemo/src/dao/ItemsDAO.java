package dao;

import entity.Items;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemsDAO {
   public ArrayList<Items> getAllItems(){
       PreparedStatement stmt = null;
       ResultSet rs = null;
       ArrayList<Items> list = new ArrayList<>();

       try {
           Connection  conn = DBHelper.getConnection();
           String sql = "SELECT * from items;";
           stmt = conn.prepareStatement(sql);
           rs = stmt.executeQuery();
          while(rs.next()){
             Items items = new Items(1, "沃特篮球鞋", "温州", 200, 500, "001.jpg");
             items.setId(rs.getInt("id"));
             items.setName(rs.getString("name"));
             items.setCity(rs.getString("city"));
             items.setPrice(rs.getInt("price"));
             items.setNum(rs.getInt("number"));
             items.setPicture(rs.getString("picture"));
             list.add(items);
           }
           return list;
       } catch (SQLException e) {
           e.printStackTrace();
           return null;
       }
       finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
           if(stmt != null){
               try {
                  stmt.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
       }
   }
   public Items getItemById(int id){
       PreparedStatement stmt = null;
       ResultSet rs = null;

       try {
           Connection  conn = DBHelper.getConnection();
           String sql = "SELECT * from items where id=?";
           stmt = conn.prepareStatement(sql);
           stmt.setInt(1,id);
           rs = stmt.executeQuery();
           if(rs.next()){
               Items items = new Items(1, "沃特篮球鞋", "温州", 200, 500, "001.jpg");
               items.setId(rs.getInt("id"));
               items.setName(rs.getString("name"));
               items.setCity(rs.getString("city"));
               items.setPrice(rs.getInt("price"));
               items.setNum(rs.getInt("number"));
               items.setPicture(rs.getString("picture"));
               return items;
           }else{
               return null;
           }

       } catch (SQLException e) {
           e.printStackTrace();
           return null;
       }
       finally {
           if(rs != null){
               try {
                   rs.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
           if(stmt != null){
               try {
                   stmt.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
       }
   }
   public ArrayList<Items> getViewList(String list){
        ArrayList<Items> itemslist=new ArrayList<Items>();
        int iCount=5;
        if(list!=null && list.length()>0){
            String arr[]=list.split("/");
           if(arr.length>=5){
               for (int i = arr.length-1; i >=arr.length-iCount ; i--) {
                    itemslist.add(getItemById(Integer.parseInt(arr[i])));
               }
           }else {
               for (int i = arr.length-1; i>=0 ; i--) {
                   itemslist.add(getItemById(Integer.parseInt(arr[i])));
               }
           }
            return itemslist;
        }
        else {
            return null;
        }
   }
}
