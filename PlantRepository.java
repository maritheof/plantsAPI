package demo.repository;

import demo.model.Plant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlantRepository extends JpaRepository<Plant, Long> {

}
