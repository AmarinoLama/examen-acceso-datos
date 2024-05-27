package org.acme.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table (name="t_items")
public class MagicalItem extends PanacheEntityBase {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    public long idItem = 0L;

    @Column(name="item_name")
    public String nombreItem = "";

    @Column(name="item_quality")
    public int calidadItem = 0;

    @Column(name="item_type")
    public String tipoItem = "";
}
