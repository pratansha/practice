package dezines.LowLevelDesign.NotifyMe.dto;

public class Product {
    private Long id;
    private String productName;
    private double productPrice;
    private String productCode;
    private boolean isProductInStock;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public boolean isProductInStock() {
        return isProductInStock;
    }

    public void setProductInStock(boolean productInStock) {
        isProductInStock = productInStock;
    }
}
