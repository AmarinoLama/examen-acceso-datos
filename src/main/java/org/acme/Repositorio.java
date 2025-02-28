package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.domain.MagicalItem;
import org.acme.domain.Order;
import org.acme.domain.Wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static org.acme.domain.Razas.MUDBLOOD;

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

    public Optional<MagicalItem> loadItem(MagicalItem item) {
        List<MagicalItem> listaItems = MagicalItem.listAll();
        List<MagicalItem> listaFiltrada = listaItems.stream()
                                                    .filter(newItem -> newItem.getName().equals(item.getName()) && newItem.getQuality() == item.getQuality() && newItem.getType().equals(item.getType()))
                                                    .toList();
        return !listaFiltrada.isEmpty() ? MagicalItem.findByIdOptional(listaFiltrada.get(0).getId()) : Optional.empty();
    }

    /* he intentado de todo pero por algún motivo este método me devuelve entidades repetidas */

    public List<MagicalItem> loadItems(String nombreItem) {
        List<MagicalItem> listaItems = MagicalItem.listAll();
        List<MagicalItem> listaFiltrada = listaItems.stream()
                .filter(item -> item.getName().equals(nombreItem))
                .distinct()
                .collect(Collectors.toList());
        return listaFiltrada;
    }

    public Optional<Order> placeOrder(String nombreWizard, String nombreItem) {
        Optional<Wizard> wizard = Wizard.findByIdOptional(nombreWizard);
        Optional<MagicalItem> item = loadItem(nombreItem);
        if (wizard.isPresent() && item.isPresent() && !wizard.get().getRazaMago().equals(MUDBLOOD)) {
            Order order = new Order(wizard.get(), item.get());
            order.persist();
            return Optional.of(order);
        }
        return Optional.empty();
    }

    public void createItem(String nombreItem, int quality, String tipoItem) {
        MagicalItem item = new MagicalItem(nombreItem, quality, tipoItem);
        item.persist();
    }

    public void createItems(List<MagicalItem> items) {
        for (MagicalItem item : items) {
            createItem(item.getName(), item.getQuality(), item.getType());
            item.persist();
        }
    }

    public void deleteItem (MagicalItem item) {
        List<MagicalItem> listaItems = MagicalItem.listAll();
        List<MagicalItem> listaFiltrada = listaItems.stream()
                                                    .filter(newItem -> newItem.getName().equals(item.getName()) && newItem.getQuality() == item.getQuality() && newItem.getType().equals(item.getType()))
                                                    .toList();
        if (!listaFiltrada.isEmpty()) {
            MagicalItem itemBorrar = listaFiltrada.get(0);
            itemBorrar.delete();
        }
    }
}
