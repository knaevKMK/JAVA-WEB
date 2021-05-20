package spring_fundametals.mobilele.model.view;

import spring_fundametals.mobilele.model.entites.ModelEntity;
import spring_fundametals.mobilele.model.entites.enums.EngineEnum;
import spring_fundametals.mobilele.model.entites.enums.TransmissionEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

public class OfferViewModel {

    private ModelEntity model;

    public ModelEntity getModel() {
        return model;
    }

    public OfferViewModel setModel(ModelEntity model) {
        this.model = model;
        return this;
    }

    private EngineEnum engine;
    private String imageUrl;
    private int mileage;
    private BigDecimal price;
    private TransmissionEnum transmission;
    private int year;

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferViewModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getMileage() {
        return mileage;
    }

    public OfferViewModel setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferViewModel setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferViewModel setYear(int year) {
        this.year = year;
        return this;
    }

    @Override
    public String toString() {
        return "OfferViewModel{" +
                "engine=" + engine +
                ", imageUrl='" + imageUrl + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", transmission=" + transmission +
                ", year=" + year +
                '}';
    }
}
