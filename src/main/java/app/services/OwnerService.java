package app.services;

import app.model.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerService {

    /* All Owners */
    List<Owner> findAll();

    /* Id Owner */
    Optional<Owner> findById(Long id);

    /* Insert Owner */
    Owner insertOwner(Owner obj);
}
