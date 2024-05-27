package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.domain.MagicalItem;
import org.acme.domain.Wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@ApplicationScoped
public class Repositorio {
    public Optional<Wizard> loadWizard(String nombreWizard) {
        Optional<Wizard> wizard = Wizard.findByIdOptional(nombreWizard);
        return wizard;
    }

    public Optional<MagicalItem> loadItem(String nombreItem) {
        List<MagicalItem> listaItems = MagicalItem.listAll();
        List<MagicalItem> listaFiltrada = listaItems.stream()
                                                    .filter(item -> item.getName().equals(nombreItem))
                                                    .toList();
        return !listaFiltrada.isEmpty() ? MagicalItem.findByIdOptional(listaFiltrada.get(0).getId()) : Optional.empty();
    }
}
