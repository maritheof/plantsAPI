package demo.service;

import demo.model.Plant;
import java.util.List;

import org.springframework.hateoas.EntityModel;

public interface IPlantService {
    
	List<EntityModel<Plant>> findAllPlants();

	Plant findPlantsById(Long id);

	Plant createNewPlant(Plant newPlant);
	
	Plant replasePlantById(Plant newPlant, Long id);
	
	void deletePlatnById(Long di);
    
}
