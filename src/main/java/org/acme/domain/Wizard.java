package org.acme.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name="t_wizards")
public class Wizard extends PanacheEntityBase {

    @Id
    @Column(name = "wizard_name")
    public String nombreWizard = "";

    @Column(name = "wizard_dexterity")
    public int destrezaWizarda = 0;

    @Column(name = "wizard_person")
    @Enumerated(value = EnumType.STRING)
    public Razas razaMago = null;

    public Wizard() {
    }

    public String getName() {
        return nombreWizard;
    }

    public void setNombreWizard(String nombreWizard) {
        this.nombreWizard = nombreWizard;
    }

    public int getDestrezaWizarda() {
        return destrezaWizarda;
    }

    public void setDestrezaWizarda(int destrezaWizarda) {
        this.destrezaWizarda = destrezaWizarda;
    }

    public Razas getRazaMago() {
        return razaMago;
    }

    public void setRazaMago(Razas razaMago) {
        this.razaMago = razaMago;
    }

    @Override
    public String toString() {
        return "Wizard{" +
                "nombreWizard='" + nombreWizard + '\'' +
                ", destrezaWizarda=" + destrezaWizarda +
                ", razaMago=" + razaMago +
                '}';
    }
}