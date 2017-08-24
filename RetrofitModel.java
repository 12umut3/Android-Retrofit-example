package umut;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetrofitModel {

    @SerializedName("bookId")
    @Expose
    private String bookId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("inStock")
    @Expose
    private String inStock;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {

        this.bookId = bookId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {

        this.price = price;
    }

    public String getInStock() {
        return inStock;
    }

    public void setInStock(String inStock) {
        this.inStock = inStock;
    }
}