package sistemaeducativo;

import java.util.Hashtable;

public class Profesor extends Persona
{
    private Hashtable <String, Asignatura> competencia=new Hashtable<String,Asignatura>();
       
    public Profesor(String legajo, String apellido, String nombre, String domicilio, String mail)
    {
        super(legajo, apellido, nombre, domicilio, mail);
    }

    public Profesor()
    {
        super();
    }

    public void setCompetencia(Hashtable<String, Asignatura> competencia)
    {
        this.competencia = competencia;
    }

    public Hashtable<String, Asignatura> getCompetencia()
    {
        return competencia;
    }
    
    
    public void modificarProfesor(String apellido, String nombre, String domicilio, String mail) {
        this.setApellido(apellido);
        this.setNombre(nombre);
        this.setDomicilio(domicilio);
        this.setMail(mail);
    }
    
    /**
     * pre: Se considera que la asignatura a agregar en la competencia del profesor es correcta y no esta repetida.
     * @param a
     */
    public void agregarCompetencia(Asignatura a) {
        this.competencia.put(a.getId(), a);
    }
    
    /**
     * pre: Se considera que la asignatura a eliminar se encuentra en la competencia del profesor.
     * @param a
     */
    public void eliminarCompetencia(Asignatura a)
    {
        this.getCompetencia().remove(a.getId());
    }
    
    
}
