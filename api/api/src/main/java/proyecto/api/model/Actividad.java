package proyecto.api.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "actividad")
public class Actividad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    @Column(nullable = false)
    private String ubicacion;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private int plazas;

    @Column(nullable = false)
    private int dificultad;

    @Column(nullable = false)
    @Temporal(TemporalType.TIME) //revisar antes de insertar actividad
    @DateTimeFormat(pattern = "HH:MM:SS")
    private Time hora;

    @Column(nullable = false)
    private String duracion;

    @Column
    private String foto;

    @Column(nullable = false)
    private int cancelacion;

    @Column
    private String informacion_adicional;

    @Column
    private String incluido;

    @Column
    private String no_incluido;

    //Relación Actividad-Ofertante (OneToMany)

    //Relación Actividad-Tipo (OneToMany)
    @ManyToOne
    @JoinColumn(name="id_tipo")
    Tipo tipo;

    //Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getCancelacion() {
        return cancelacion;
    }

    public void setCancelacion(int cancelacion) {
        this.cancelacion = cancelacion;
    }

    public String getInformacion_adicional() {
        return informacion_adicional;
    }

    public void setInformacion_adicional(String informacion_adicional) {
        this.informacion_adicional = informacion_adicional;
    }

    public String getIncluido() {
        return incluido;
    }

    public void setIncluido(String incluido) {
        this.incluido = incluido;
    }

    public String getNo_incluido() {
        return no_incluido;
    }

    public void setNo_incluido(String no_incluido) {
        this.no_incluido = no_incluido;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
