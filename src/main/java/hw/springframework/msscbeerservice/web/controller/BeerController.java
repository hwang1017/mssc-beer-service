package hw.springframework.msscbeerservice.web.controller;


import hw.springframework.msscbeerservice.services.BeerService;
import hw.springframework.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;


@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;


    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeerById(@PathVariable("beerId") UUID beerId) {

        return new ResponseEntity<>(beerService.getById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDto> saveNewBeer(@Valid @RequestBody BeerDto beerDto) {

        return new ResponseEntity<>(beerService.saveNewBeer(beerDto), HttpStatus.ACCEPTED.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<BeerDto> updateBeerById(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDto beerDto) {

        return new ResponseEntity<>(beerService.updateBeerById(beerId, beerDto),HttpStatus.NO_CONTENT);
    }
}
