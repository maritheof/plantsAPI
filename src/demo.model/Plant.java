package demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="plants")
public class Plant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="plant_ID")
	private  Long plantID;
	//@NotEmpty
	@Column(name="plant_name")
	private String plantName;
	private String description;

    public Plant() {
    }
    
    public Plant(Long plantID, String plantName, String description) {
        this.plantID = plantID;
        this.plantName = plantName;
        this.description = description;
    }

    public Long getPlantId() {
        return plantID;
    }
    
    public void setPlantId(Long plantID) {
    	this.plantID = plantID;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}