package modelo;

public class persona {
    private int id;
    private String nombre;
    private String apellidopa;
    private String apellidoma;
    private String email;
    private Double sueldo;

    public persona() {
    }

    public persona(int id, String nombre, String apellidopa, String apellidoma, String email, Double sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidopa = apellidopa;
        this.apellidoma = apellidoma;
        this.email = email;
        this.sueldo = sueldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidopa() {
        return apellidopa;
    }

    public void setApellidopa(String apellidopa) {
        this.apellidopa = apellidopa;
    }

    public String getApellidoma() {
        return apellidoma;
    }

    public void setApellidoma(String apellidoma) {
        this.apellidoma = apellidoma;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidopa='" + apellidopa + '\'' +
                ", apellidoma='" + apellidoma + '\'' +
                ", email='" + email + '\'' +
                ", sueldo=" + sueldo +
                '}';
    }
}
