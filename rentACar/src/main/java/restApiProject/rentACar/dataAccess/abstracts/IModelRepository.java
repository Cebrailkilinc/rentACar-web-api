package restApiProject.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restApiProject.rentACar.entities.concretes.Model;

@Repository
public interface IModelRepository extends JpaRepository<Model, Integer> {

}
