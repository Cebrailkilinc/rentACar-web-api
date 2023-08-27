package restApiProject.rentACar.business.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandsResponse {  //Son kullanıcıya vereceğimiz class
    private int id;
    private String name;
}
