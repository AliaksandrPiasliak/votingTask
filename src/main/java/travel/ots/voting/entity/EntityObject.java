package travel.ots.voting.entity;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class EntityObject<T extends Serializable>  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private T id;

    public EntityObject(){}

    public EntityObject(T id){
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EntityObject<?> that = (EntityObject<?>) o;

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;

    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "EntityObject{" +
                "id=" + id +
                '}';
    }
}
