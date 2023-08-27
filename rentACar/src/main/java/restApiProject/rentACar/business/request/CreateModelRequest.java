package restApiProject.rentACar.business.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequest {
    @NotNull(message = "Name null olamaz")
    @NotBlank(message = "Bos olamaz")
    @Size(min = 3,max = 20)
    private String name;

   // @NotEmpty
    private int brandId;
}
