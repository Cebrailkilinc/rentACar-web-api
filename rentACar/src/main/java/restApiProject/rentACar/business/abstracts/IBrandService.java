package restApiProject.rentACar.business.abstracts;

import org.springframework.stereotype.Service;
import restApiProject.rentACar.business.request.CreateBrandRequest;
import restApiProject.rentACar.business.request.UpdateBrandRequest;
import restApiProject.rentACar.business.response.GetAllBrandsResponse;
import restApiProject.rentACar.business.response.GetBrandByIdResponse;
import restApiProject.rentACar.entities.concretes.Brand;

import java.util.List;

@Service
public interface IBrandService {
  List<GetAllBrandsResponse> getAll();
  GetBrandByIdResponse getById(int id);
  void add(CreateBrandRequest createRequest);
  void update(UpdateBrandRequest updateRequest);
  void delete(int id);
}
