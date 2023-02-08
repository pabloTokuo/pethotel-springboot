package app.services.impl;

import app.model.Owner;
import app.repositories.OwnerRepository;
import app.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    @Override
    public Optional<Owner> findById(Long id) {
        return ownerRepository.findById(id);
    }

    @Override
    public Owner insertOwner(Owner obj) {
        return ownerRepository.save(obj);
    }

    @Override
    public void deleteOwnerById(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Owner updateOwnerById(Long id, Owner owner) {
        Owner entity = ownerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        updateOwner(entity, owner);
        return ownerRepository.save(entity);
    }

    @Override
    public void updateOwner(Owner entity, Owner obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setAnimals(obj.getAnimals());
        entity.setAddress(obj.getAddress());
    }
}
