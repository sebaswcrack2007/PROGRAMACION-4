public class Persona {

    String codigo;
    String nombre;
    String apellido;
    String sexo;
    String documento;          // Tipo de Documento
    String numeroDocumento;
    int edad;
    String ciudad;
    String correo;
    String activo;             // Activo / No Activo

    public Persona(String codigo, String nombre, String apellido, String sexo,
                   String documento, String numeroDocumento, int edad,
                   String ciudad, String correo, String activo) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.documento = documento;
        this.numeroDocumento = numeroDocumento;
        this.edad = edad;
        this.ciudad = ciudad;
        this.correo = correo;
        this.activo = activo;
    }

    public String toArchivo() {
        return codigo + "," + nombre + "," + apellido + "," + sexo + "," +
               documento + "," + numeroDocumento + "," + edad + "," +
               ciudad + "," + correo + "," + activo;
    }
}