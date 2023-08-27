package restApiProject.rentACar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import restApiProject.rentACar.core.utilities.exception.BusinessException;
import restApiProject.rentACar.core.utilities.exception.ProblemDetails;

@SpringBootApplication
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);
	}

	/*
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException){
		ProblemDetails problemDetails = new ProblemDetails();
		System.out.println(businessException.getMessage());
		problemDetails.setMessage("Oğuz escortu hatalı geldi.");

        return problemDetails;
    }
	*/
	@Bean
	public ModelMapper getModelMapper(){
		return  new ModelMapper();
	}

}
