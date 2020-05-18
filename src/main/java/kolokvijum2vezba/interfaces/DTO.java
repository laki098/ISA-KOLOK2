package kolokvijum2vezba.interfaces;

import java.io.Serializable;

public interface DTO<ID> extends Serializable {

    public ID getId();

    public void setId(ID id);

}