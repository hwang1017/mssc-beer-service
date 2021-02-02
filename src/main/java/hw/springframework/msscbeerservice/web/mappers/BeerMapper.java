package hw.springframework.msscbeerservice.web.mappers;


import hw.springframework.msscbeerservice.domain.Beer;
import hw.springframework.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto dto);
}
