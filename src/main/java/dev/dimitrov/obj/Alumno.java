package dev.dimitrov;


public class Alumno {
    private String expediente;
    private String nombre;
    private Integer edad;
    
    public Alumno(String e, String n, Integer ed){
        expediente = e;
        nombre = n;
        edad = ed;
    }
    
    public String getExpediente() {
        return expediente;
    }
    
    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
      
    @Override
    public String toString() {
        return "Alumno [expediente=" + expediente + ", nombre=" + nombre + ", edad=" + edad + "]";
    }
    
}