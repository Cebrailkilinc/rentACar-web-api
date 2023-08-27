package restApiProject.rentACar.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restApiProject.rentACar.business.abstracts.IModelService;
import restApiProject.rentACar.business.request.CreateModelRequest;
import restApiProject.rentACar.business.response.GetAllModelsResponse;
import restApiProject.rentACar.dataAccess.abstracts.IModelRepository;
import restApiProject.rentACar.entities.concretes.Model;
import restApiProject.rentACar.core.utilities.mapper.IModelMapperService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements IModelService {
 @Autowired
 private IModelRepository modelRepository;
 private  IModelMapperService modelMapperService;
    @Override
    public List<GetAllModelsResponse> getModel() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelsResponse> getAllModelsResponse = models.stream()
                .map(model -> this.modelMapperService.forResponse()
                        .map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
        return getAllModelsResponse;
    }

    @Override
    public void add(CreateModelRequest createRequest) {
        Model model = this.modelMapperService.forRequest().map(createRequest, Model.class);
        this.modelRepository.save(model);
    }
}
