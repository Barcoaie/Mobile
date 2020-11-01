package ubb.barcoaie.lab2_ma.Domain;

import java.io.Serializable;

public abstract class BaseEntity<ID extends Serializable> implements Serializable {
    private ID id;
}
