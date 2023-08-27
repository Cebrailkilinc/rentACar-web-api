package restApiProject.rentACar.webApi.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import restApiProject.rentACar.business.abstracts.IBrandService;
import restApiProject.rentACar.business.request.CreateBrandRequest;
import restApiProject.rentACar.business.request.UpdateBrandRequest;
import restApiProject.rentACar.business.response.GetAllBrandsResponse;
import restApiProject.rentACar.business.response.GetBrandByIdResponse;
import restApiProject.rentACar.entities.concretes.Brand;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
    private final IBrandService brandService;

    public BrandsController(IBrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetBrandByIdResponse getBrandById(@PathVariable int id){
        return brandService.getById(id);
    }

    @PostMapping("/addCar")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addCar(@RequestBody() @Valid() CreateBrandRequest request){
        brandService.add(request);
        System.out.println(request.getName());
    }
    @PutMapping("/update")
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest)
    {
        brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        brandService.delete(id);
    }
 }
