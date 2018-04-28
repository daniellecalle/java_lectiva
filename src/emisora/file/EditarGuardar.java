/*
    Clase que tendría como comportamiento similar a la herencia
    Esta clase contiene los atributos que serán almacenados directamente
    en el arhivo usuarios.txt definido en FileDAO.java
 */
package emisora.file;

import java.util.Calendar;

public class EditarGuardar {

    private String nombre;
    private String nombre2;
    private String apellido;
    private String apellido2;
    private String tipoDocu;
    private String documento;
    private String pass;
    private String correo;
   // private Calendar nacimiento;
    private String fecha;

    public String getTipoDocu() {
        return tipoDocu;
    }

    public void setTipoDocu(String tipoDocu) {
        this.tipoDocu = tipoDocu;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

   /* public Calendar getNacimiento() {
        return nacimiento;
    }*/

    /*public void setNacimiento(Calendar nacimiento) {
        this.nacimiento = nacimiento;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    //Método para transformar el Calendar a String
   /* public String convertirFecha() {
        String dia, mes, year;
        dia = Integer.toString(Calendar.DATE);
        mes = Integer.toString(Calendar.MONTH);
        year = Integer.toString(Calendar.YEAR);
        return fecha = dia + "/" + mes + "/" + year;
    }*/
}
