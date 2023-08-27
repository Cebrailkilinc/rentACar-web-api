package restApiProject.rentACar.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import restApiProject.rentACar.business.abstracts.IBrandService;
import restApiProject.rentACar.business.request.CreateBrandRequest;
import restApiProject.rentACar.business.request.UpdateBrandRequest;
import restApiProject.rentACar.business.response.GetAllBrandsResponse;
import restApiProject.rentACar.business.response.GetBrandByIdResponse;
import restApiProject.rentACar.business.rules.BrandBusinessRules;
import restApiProject.rentACar.core.utilities.mapper.IModelMapperService;
import restApiProject.rentACar.dataAccess.abstracts.IBrandRepository;
import restApiProject.rentACar.entities.concretes.Brand;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements IBrandService {
    private final IBrandRepository brandRepository;
    private final IModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;
    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> getAllBrandsResponses = brands.stream()
                .map(brand -> modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
        return getAllBrandsResponses;
    }

    @Override
    public GetBrandByIdResponse getById(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();
        GetBrandByIdResponse getBrandByIdResponse = modelMapperService.forResponse().map(brand, GetBrandByIdResponse.class);
        return getBrandByIdResponse;
    }

    @Override
    public void add(CreateBrandRequest request) {
        this.brandBusinessRules.checkIfBrandNameExist(request.getName()); //Aynı isimde olup olmadığı kontrol edildi
        Brand brand = modelMapperService.forRequest().map(request, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateRequest) {
        Brand brand = modelMapperService.forRequest().map(updateRequest, Brand.class);
        brandRepository.save(brand);
    }
    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
