package org.iesalandalus.programacion.matriculacion.dominio;

import java.time.LocalDate;
import java.util.regex.*;

public class Alumno {

  private String ER_TELEFONO;
  private  String ER_CORREO;
  private String ER_DNI;
  public String FORMATO_FECHA;
  private String ER_NIA;
  private int MIN_EDAD_ALUMNO;
  private String nombre;
  private String telefono;
  private String correo;
  private String dni;
  private LocalDate fechaNacimiento;
  private String nia;

  public Alumno(String nombre,String telefono,String correo,String dni,LocalDate fechaNacimiento,String nia){
    setNombre(nombre);
    setTelefono(telefono);
    setCorreo(correo);
    setDni(dni);
    setFechaNacimiento(fechaNacimiento);
    setNia(nia);
  }
  //metodo para eliminar los espacios en blanco
  private void formateaNombre(){
    String [] nombreNormalizado=nombre.split(" ");

    // StringBuilder para construir el nombre formateado.
    StringBuilder nombreFormateado = new StringBuilder();

    // Recorrer cada palabra.
    for (String palabra : nombreNormalizado) {
      // Convertir la primera letra a mayúsculas y el resto a minúsculas.
      if (palabra.length() > 0) {
        String palabraFormateada = palabra.substring(0, 1).toUpperCase() + palabra.substring(1).toLowerCase();
        nombreFormateado.append(palabraFormateada).append(" ");
      }
    }

    // Eliminar el último espacio adicional.
    setNombre(nombreFormateado.toString().trim());


  }
  private boolean comprobarLetraDni() {
    String udni=getDni();
    boolean resultado = false;
    int numero;
    char letra;
    Pattern patron=Pattern.compile("^(\\d{8})([A-Za-z]{1})$");
    Matcher comparador=patron.matcher(udni);
    char[] LETRAS_DNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
    if (comparador.matches()) {
      numero = Integer.parseInt(comparador.group(1));
      letra = comparador.group(2).charAt(0);

    } else {

      return false;

    }

      int numeroDivido=numero/23;
      int numeroMultiplicado=numeroDivido*23;
      int posicionLetra=numero-numeroMultiplicado;

      if (letra==LETRAS_DNI[posicionLetra]) {
        resultado=true;

      }


    return resultado;
  }

//geters y seters
  public String getNia() {

    return nia;
  }

  public void setNia(String nia) {
    if (nia == null) {
      throw new NullPointerException("El nia no puede ser nulo");
    }
    this.nia = nia;
  }

  public String getNombre() {

    return nombre;
  }

  public void setNombre(String nombre) {
    if (nombre == null) {
      throw new NullPointerException("El nombre no puede ser nulo");
    }
    this.nombre = nombre;
  }

  public String getTelefono() {

    return telefono;
  }

  public void setTelefono(String telefono) {
    if (telefono == null) {
      throw new NullPointerException("El telefono no puede ser nulo");
    }
    this.telefono = telefono;
  }

  public String getCorreo() {

    return correo;
  }

  public void setCorreo(String correo) {
    if (correo == null) {
      throw new NullPointerException("El correo no puede ser nulo");
    }
    this.correo = correo;
  }

  public String getDni() {

    return dni;
  }

  public void setDni(String dni) {
    if (dni == null) {
      throw new NullPointerException("El dni no puede ser nulo");
    }
    this.dni = dni;
  }

  public LocalDate getFechaNacimiento() {

    return fechaNacimiento;
  }

  public void setFechaNacimiento(LocalDate fechaNacimiento) {

    this.fechaNacimiento = fechaNacimiento;
  }


}
