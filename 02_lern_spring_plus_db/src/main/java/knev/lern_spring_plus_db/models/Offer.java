package knev.lern_spring_plus_db.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


public class Offer extends BaseEntity {


    private VehicleCategory category;

    private Model model;

    private Integer year;

    private Integer mileage;

    private EngineType engine;

    private TransmissionType transmission;

    private String description;

    private Double price;

    private String imageUrl;

    private User seller;

    private Long sellerId;


}
