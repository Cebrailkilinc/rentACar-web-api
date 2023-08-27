package restApiProject.rentACar.webApi.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import restApiProject.rentACar.business.abstracts.IModelService;
import restApiProject.rentACar.business.request.CreateModelRequest;
import restApiProject.rentACar.business.response.GetAllModelsResponse;

import java.util.List;

@RestController
@RequestMapping("/api/models")
public class ModelsController {
    private final IModelService modelService;
    public ModelsController(IModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/all")
    public List<GetAllModelsResponse> getAll(){
        return modelService.getModel();
    }

    @PostMapping("/addModel")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid() CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }
}
