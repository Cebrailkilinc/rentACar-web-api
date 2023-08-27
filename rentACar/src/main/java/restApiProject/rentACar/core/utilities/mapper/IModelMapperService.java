package restApiProject.rentACar.core.utilities.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public interface IModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
}
