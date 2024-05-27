package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.domain.Wizard;

import java.util.Optional;
import java.util.function.Supplier;

@ApplicationScoped
public class Repositorio {
    public Optional<Wizard> loadWizard(String nombreWizard) {
        Optional<Wizard> wizard = Wizard.findByIdOptional(nombreWizard);
        return wizard;
    }
}
