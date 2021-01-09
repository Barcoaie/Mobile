package ubb.barcoaie.lab5_ma.model;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Vegetable")
public class Vegetable implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private Long id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "price")
    private int price;

    @ColumnInfo(name = "onServer")
    private int onServer;

    public Vegetable(String name, int price, int onServer) {
        this.name = name;
        this.price = price;
        this.onServer = onServer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    @Override
    public String toString() {
        return "Vegetable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", onServer=" + onServer +
                '}';
    }

    public int getOnServer() {
        return onServer;
    }

    public void setOnServer(int onServer) {
        this.onServer = onServer;
    }
}
