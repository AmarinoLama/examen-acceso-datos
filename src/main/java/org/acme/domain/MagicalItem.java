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

    public MagicalItem() {
    }

    public long getIdItem() {
        return idItem;
    }

    public void setIdItem(long idItem) {
        this.idItem = idItem;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public int getCalidadItem() {
        return calidadItem;
    }

    public void setCalidadItem(int calidadItem) {
        this.calidadItem = calidadItem;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }
}
