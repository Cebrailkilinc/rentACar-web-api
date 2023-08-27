package restApiProject.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restApiProject.rentACar.entities.concretes.Brand;

import java.util.List;
import java.util.Optional;

@Repository
public interface IBrandRepository extends JpaRepository<Brand, Integer> {
    Optional<Brand> findByName(String name);
    boolean existsByName(String name); //Spring jpa keywords
}
// SPRING DATA JPA ISIMLE QUERY OLUŞTURMA
