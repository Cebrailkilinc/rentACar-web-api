package restApiProject.rentACar.business.abstracts;

import org.springframework.stereotype.Service;
import restApiProject.rentACar.business.request.CreateBrandRequest;
import restApiProject.rentACar.business.request.CreateModelRequest;
import restApiProject.rentACar.business.response.GetAllModelsResponse;

import java.util.List;

@Service
public interface IModelService {
    List<GetAllModelsResponse> getModel();
    void add(CreateModelRequest createModelRequest);
}
