package restApiProject.rentACar.business.rules;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import restApiProject.rentACar.core.utilities.exception.BusinessException;
import restApiProject.rentACar.dataAccess.abstracts.IBrandRepository;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private IBrandRepository brandRepository;
  public void checkIfBrandNameExist(String name) throws RuntimeException {
        if (this.brandRepository.existsByName(name))
        {
              throw new BusinessException("Bu isim kullanılmakta. Lütfen başka bir isim seçin.");
        }
  }
}
