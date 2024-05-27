package org.acme.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name="t_orders")
public class Order extends PanacheEntityBase {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ord_id")
    public long idOrden = 0L;

    @OneToOne
    @JoinColumn(name="ord_wizard")
    public Wizard wizard = null;

    @OneToOne
    @JoinColumn(name="ord_item")
    public MagicalItem item = null;

    public Order() {
    }

    public long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(long idOrden) {
        this.idOrden = idOrden;
    }

    public Wizard getWizard() {
        return wizard;
    }

    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }

    public MagicalItem getItem() {
        return item;
    }

    public void setItem(MagicalItem item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrden=" + idOrden +
                ", wizard=" + wizard +
                ", item=" + item +
                '}';
    }
}
