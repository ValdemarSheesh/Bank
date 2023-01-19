package com.example.Bank.controller;

import com.example.Bank.dto.CreditOfferDtoToClient;
import com.example.Bank.dto.CreditOfferDtoToFill;
import com.example.Bank.exceptions.InvalidValueException;
import com.example.Bank.mapper.impl.CreditOfferMapperImpl;
import com.example.Bank.model.Client;
import com.example.Bank.model.CreditOffer;
import com.example.Bank.service.impl.ClientServiceImpl;
import com.example.Bank.service.impl.CreditOfferServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("credit-offers")
public class CreditOfferController {

    @Autowired
    CreditOfferServiceImpl creditOfferService;
    @Autowired
    ClientServiceImpl clientService;
    @Autowired
    CreditOfferMapperImpl creditOfferMapper;

    @PostMapping
    public ResponseEntity<String> saveCreditOffer(@Validated @RequestBody CreditOfferDtoToFill creditOfferDtoToFill,
                                                  BindingResult bindingResult,
                                                  @RequestParam(value = "clientId") Long clientId) {
        if (bindingResult.hasErrors())
            throw new InvalidValueException(InvalidValueException.createMessage(bindingResult));

        if (creditOfferDtoToFill.getCreditSum() > creditOfferDtoToFill.getCreditDto().getCreditLimit())
            throw new InvalidValueException("Credit sum exceeds limit");

        CreditOffer creditOffer = creditOfferMapper.creditOfferDtoToFillToCreditOffer(creditOfferDtoToFill);
        Client client = clientService.getClientById(clientId);
        creditOffer.setClient(client);
        creditOfferService.addCreditOffer(creditOffer);

        return ResponseEntity.ok("Credit offer added");
    }

    @GetMapping("/{id}")
    public CreditOfferDtoToClient getCreditOffer(@PathVariable Long id) {
        CreditOffer creditOffer = creditOfferService.getCreditOfferById(id);
        return creditOfferMapper.creditOfferToCreditOfferDtoToClient(creditOffer);
    }

    @PutMapping
    public ResponseEntity<String> updateCreditOffer(@RequestParam(value = "creditOfferId") Long creditOfferId,
                                                    @RequestParam(value = "clientId") Long clientId,
                                                    @Validated @RequestBody CreditOfferDtoToFill creditOfferDtoToFill,
                                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            throw new InvalidValueException(InvalidValueException.createMessage(bindingResult));

        CreditOffer creditOffer = creditOfferMapper.creditOfferDtoToFillToCreditOffer(creditOfferDtoToFill);
        Client client = clientService.getClientById(clientId);

        creditOffer.setId(creditOfferId);
        creditOffer.setClient(client);
        creditOfferService.editCreditOffer(creditOffer);

        return ResponseEntity.ok("Credit offers updated");
    }

    @GetMapping
    public ResponseEntity<?> getAllCreditOffersByClient(@RequestParam(value = "clientId") Long clientId) {
        Client client = clientService.getClientById(clientId);
        List<CreditOffer> creditOffers = creditOfferService.getAllCreditOfferByClient(client);
        if (creditOffers.isEmpty())
            return ResponseEntity.ok("Credit offers is empty");
        else
            return ResponseEntity.ok(creditOfferMapper.creditOffersToCreditOffersDto(creditOffers));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCreditOffer(@RequestParam(value = "creditOfferId") Long creditOfferId) {
        creditOfferService.deleteCreditOffer(creditOfferId);
        return ResponseEntity.ok("Credit offer deleted");
    }

}










