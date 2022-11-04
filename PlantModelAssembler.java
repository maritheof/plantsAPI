package demo.plantModelAssembler;

import demo.controller.MyController;
import demo.model.Plant;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class PlantModelAssembler implements RepresentationModelAssembler<Plant, EntityModel<Plant>> {

	@Override
	public EntityModel<Plant> toModel(Plant plant) {

	return EntityModel.of(plant, 
	        linkTo(methodOn(MyController.class).findPlantById(plant.getPlantId())).withSelfRel(),
	        linkTo(methodOn(MyController.class).finAllPlants()).withRel("plants"));
	}
}
