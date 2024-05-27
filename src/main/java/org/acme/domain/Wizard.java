package org.acme.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="t_wizards")
public class Wizard extends PanacheEntityBase {

    @Id
    @Column(name = "wizard_name")
    public String nombreWizard = "";

    @Column(name = "wizard_dexterity")
    public int destrezaWizarda = 0;

    @Column(name = "wizard_person")
    public Razas razaMago = "";

}