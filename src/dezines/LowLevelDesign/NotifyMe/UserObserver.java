package dezines.LowLevelDesign.NotifyMe;

import dezines.LowLevelDesign.NotifyMe.dto.ProductUserObserver;


public interface UserObserver {
    void update(ProductUserObserver product);
}
