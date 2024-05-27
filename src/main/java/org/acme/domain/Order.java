package org.acme.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="t_orders")
public class Order extends PanacheEntityBase {

    @Id
    @Column(name="ord_id")
    public long idOrden = 0L;
}
