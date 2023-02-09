package app.controller;

import app.model.Address;
import app.services.impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pethotel/address")
public class AddressController {

    @Autowired
    private AddressServiceImpl addressService;

    @GetMapping
    public List<Address> findAll() {
        return addressService.findAll();
    }

}
