package br.com.fsferreira.utils.mapper;

import br.com.fsferreira.dto.PersonDTO;
import br.com.fsferreira.model.Person;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDTO personToPersonDto(Person person);

    @InheritInverseConfiguration
    Person personDtoToPerson(PersonDTO person);

    @IterableMapping(elementTargetType = PersonDTO.class)
    List<PersonDTO> personsToPersonDtos(List<Person> people);
}
