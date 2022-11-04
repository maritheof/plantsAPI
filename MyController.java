package demo.controller;

import demo.model.Plant;
import demo.plantModelAssembler.PlantModelAssembler;
import demo.service.PlantService;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	private final PlantService servise;
	
	private final PlantModelAssembler assembler;

    public MyController(PlantService servise, PlantModelAssembler assembler) {
        this.servise = servise;
        this.assembler = assembler;
    }
    
    @GetMapping("/plants")
    public CollectionModel<EntityModel<Plant>> finAllPlants() {
      return CollectionModel.of(servise.findAllPlants(), linkTo(methodOn(MyController.class).finAllPlants()).withSelfRel());
    }

    @GetMapping("/plants/{id}")
    public EntityModel<Plant> findPlantById(@PathVariable Long id) {
    	return assembler.toModel(servise.findPlantsById(id));
    }
    
    @PostMapping("/plants")
    EntityModel<Plant> newPlant(@RequestBody Plant newPlant) {
      return assembler.toModel(servise.createNewPlant(newPlant));
    }
    
    @PutMapping("/plants/{id}")
    EntityModel<Plant> replasePlantById(@RequestBody Plant newPlant, @PathVariable Long id) {
    	return assembler.toModel(servise.replasePlantById(newPlant, id));
    }
    
    @DeleteMapping("/plants/{id}")
    void deletePlantById(@PathVariable Long id) {
    	servise.deletePlatnById(id);
    }
    
}
