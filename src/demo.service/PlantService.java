package demo.service;

import demo.model.Plant;
import demo.plantModelAssembler.PlantModelAssembler;
import demo.repository.PlantRepository;
import demo.exceptions.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantService implements IPlantService{
	
	private final PlantRepository repository;
	
	private final PlantModelAssembler assembler;
		
	public PlantService(PlantRepository repository, PlantModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

	@Override
    public List<EntityModel<Plant>> findAllPlants() {
		 List<EntityModel<Plant>> employees = repository.findAll().stream()
			      .map(assembler::toModel)
			      .collect(Collectors.toList());
		 return employees;
    }
	
	@Override
	public Plant findPlantsById(Long id) {
		 return repository.findById(id)
				 .orElseThrow(() -> new PlantNotFoundException(id));
	}
	
	@Override
	public Plant createNewPlant(Plant newPlant) {
		if (newPlant.getPlantName() == null) {
			throw new PlantBadRequestException();
		} else {
		return repository.save(newPlant);
		}
	}
	
	@Override
	public Plant replasePlantById(Plant newPlant, Long id) {
		return repository.findById(id)
				.map(plant -> {
					plant.setPlantName(newPlant.getPlantName());
	    	    	plant.setDescription(newPlant.getDescription());
	    	    	return repository.save(plant);
	    	    	})
				.orElseThrow(() -> new PlantNotFoundException(id));
	}

	@Override
	public void deletePlatnById(Long id) {
		repository.findById(id)
		 .orElseThrow(() -> new PlantNotFoundException(id));
		repository.deleteById(id);				
	}
}
