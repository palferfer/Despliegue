package proyecto.api.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_actividad")
public class Tipo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    public Tipo() {
    }

    //Relación Tipo-Actividad
    @OneToMany(mappedBy = "tipo_actividad", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Actividad> actividades = new HashSet<>();

    //Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(Set<Actividad> actividades) {
        this.actividades = actividades;
    }

    //Helpers
    public void addActividad(Actividad actividad){
        this.actividades.add(actividad);
        actividad.setTipo(this);
    }

    public void removeActividad(Actividad actividad){
        this.actividades.remove(actividad);
        actividad.setTipo(null);
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", actividades=" + actividades +
                '}';
    }
}
