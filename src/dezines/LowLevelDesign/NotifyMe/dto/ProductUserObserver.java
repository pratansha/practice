package dezines.LowLevelDesign.NotifyMe.dto;

import dezines.LowLevelDesign.NotifyMe.UserObserver;

import java.util.List;

public class ProductUserObserver {

    private List<UserObserver> userObserverList;
    private Product productInfo;

    public List<UserObserver> getUserObserverList() {
        return userObserverList;
    }

    public void setUserObserverList(List<UserObserver> userObserverList) {
        this.userObserverList = userObserverList;
    }

    public Product getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(Product productInfo) {
        this.productInfo = productInfo;
    }
}
