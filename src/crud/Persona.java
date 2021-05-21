package crud;


import java.io.Serializable;

public class Persona implements Comparable, Serializable {
    private String nombre;
    private String apellido;
    private String dni;
    private String mail;
    private String telef1;
    private String telef2;
    public static int buscar;

    public Persona(String nombre,String apellido, String dni,String mail,String telef1,String telef2){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.mail = mail;
        this.telef1 = telef1;
        this.telef2 = telef2;
        buscar = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setTelef1(String telef1) {
        this.telef1 = telef1;
    }

    public void setTelef2(String telef2) {
        this.telef2 = telef2;
    }

    public static void setBuscar(int buscarPor) { buscar = buscarPor; }

    public String getMail() {
        return mail;
    }

    public String getTelef1() {
        return telef1;
    }

    public String getTelef2() {
        return telef2;
    }

    public static int getBuscar() { return buscar; }


    @Override
    public int compareTo(Object obj){
        if(obj instanceof Persona){
            if(buscar == 2){
                return  this.mail.compareTo(((Persona)obj).mail);
            }
            if(buscar == 1){
                return  this.nombre.compareTo(((Persona)obj).nombre);
            }else {
                return this.dni.compareTo(((Persona)obj).dni);
            }
        }else {
            throw new ClassCastException();
        }
    }

    @Override
    public boolean equals(Object p){
        if(p instanceof Persona ){
            if(Persona.buscar == 1){
                return this.nombre.equals(((Persona)p).nombre);
            }
            if (Persona.buscar == 2){
                return this.mail.equals(((Persona)p).mail);
            }
            return this.dni.equals(((Persona)p).dni);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return " Nombre: " + nombre + '\n' +
                " Apellido: " + apellido + '\n' +
                " Dni: " + dni + '\n'+
                " Mail: " + mail + '\n' +
                " Telef1: " + telef1 + '\n' +
                " Telef2: " + telef2 + '\n';
    }

}
