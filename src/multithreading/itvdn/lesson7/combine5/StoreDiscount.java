package multithreading.itvdn.lesson7.combine5;

public class StoreDiscount {

    private Integer storeNumber;
    private Integer discount;

    public Integer getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(Integer storeNumber) {
        this.storeNumber = storeNumber;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "StoreDiscount{" +
                "storeNumber=" + storeNumber +
                ", discount=" + discount +
                '}';
    }
}
