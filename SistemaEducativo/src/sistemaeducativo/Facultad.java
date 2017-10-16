package sistemaeducativo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Facultad {
    public static int PROXLEGAJOALUM;
    public static int PROXLEGAJOPROF;
    public static int PROXIDCURSADA;
    public static int PROXIDASIGNATURA;
    private TreeMap<String, Alumno> alumnos = new TreeMap<>();
    private TreeMap<String, Profesor> profesores = new TreeMap<>();
    private TreeMap<String, Asignatura> asignaturas = new TreeMap<>();
    private TreeMap<String, Cursada> cursadas = new TreeMap<>();

    public Facultad() {
        super();
        PROXLEGAJOALUM = 0;
        PROXLEGAJOPROF = 0;
        PROXIDASIGNATURA = 0;
        PROXIDCURSADA = 0;
    }

    public TreeMap<String, Alumno> getAlumnos() {
        return alumnos;
    }

    public TreeMap<String, Profesor> getProfesores() {
        return profesores;
    }

    public TreeMap<String, Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public TreeMap<String, Cursada> getCursadas() {
        return cursadas;
    }

    public void agregarAlumno(String apellido, String nombre, String domicilio, String mail) {
        String s = String.format("%04d", PROXLEGAJOALUM);
        String leg = "ALU" + s;
        Alumno a = new Alumno(leg, apellido, nombre, domicilio, mail);
        this.getAlumnos().put(a.getLegajo(), a);
    }

    public void agregarProfesor(String apellido, String nombre, String domicilio, String mail) {
        String s = String.format("%04d", ++PROXLEGAJOPROF);
        String leg = "PRO" + s;
        Profesor a = new Profesor(leg, apellido, nombre, domicilio, mail);
        this.getProfesores().put(a.getLegajo(), a);
    }

    public void agregarAsignatura(String nombre) {
        String s = String.format("%04d", ++PROXIDASIGNATURA);
        String id = "ASI" + s;
        Asignatura a = new Asignatura(id, nombre);
        this.getAsignaturas().put(a.getId(), a);
    }

    public void agregarCursada(Asignatura asignatura, String dia, String hora, String periodo) {
        String s = String.format("%04d", ++PROXIDCURSADA);
        String id = "ASI" + s;
        Cursada a = new Cursada(id, asignatura, periodo);
        this.getCursadas().put(a.getId(), a);
    }
    
    
    /**
     * pre: el id de la cursada es valido. El Alumno a es distinto de null.
     * @param cursadaId
     * @param a
     */
    public void agregarAlumnoACursada(String cursadaId, Alumno a) throws AlumnoInhabilitadoException, AlumnoRegistradoEnCursadaException {
        Cursada c=this.getCursadas().get(cursadaId);
        c.agregarAlumno(a);
    }
    
    public void agregarProfesorACursada(String cursadaId, Profesor p) throws ProfesorRegistradoEnCursadaException, ProfesorInhabilitadoParaCursadaException {
        Cursada c=this.getCursadas().get(cursadaId);
        c.agregarProfesor(p);
    }

    //Preguntar si cada alumno no tiene una coleccion de cursadas actuales. Idem profesores.

    /**
     * pre: Se considera que el legajo es de un alumno existente.
     * @param id
     */
    public void bajaAlumno(String legajo) {
        this.getAlumnos().remove(legajo);
        Cursada c;
        Iterator it = this.getCursadas()
                          .entrySet()
                          .iterator();
        while (it.hasNext()) {
            Map.Entry m = (Map.Entry) it.next();
            c = (Cursada) m.getValue();
            c.eliminarAlumno(legajo);
        }
    }

    public void bajaProfesor(String legajo) {
        this.getProfesores().remove(legajo);
        Cursada c;
        Iterator it = this.getCursadas()
                          .entrySet()
                          .iterator();
        while (it.hasNext()) {
            Map.Entry m = (Map.Entry) it.next();
            c = (Cursada) m.getValue();
            c.eliminarProfesor(legajo);
        }
    }

    public ArrayList<Alumno> buscarAlumnoPorNombre(String nombre, String apellido) {
        ArrayList<Alumno> alumnosReturn = new ArrayList<>();
        Alumno a;
        Iterator it = this.getAlumnos()
                          .entrySet()
                          .iterator();
        while (it.hasNext()) {
            Map.Entry m = (Map.Entry) it.next();
            a = (Alumno) m.getValue();
            if (a.getNombre().equals(nombre) && a.getApellido().equals(apellido)) {
                alumnosReturn.add(a);
            }
        }
        return alumnosReturn;
    }
    
    private ArrayList<Profesor> buscarProfesorPorNombre(String nombre, String apellido) {
        ArrayList<Profesor> profesoresReturn = new ArrayList<>();
        Profesor p;
        Iterator it = this.getProfesores()
                          .entrySet()
                          .iterator();
        while (it.hasNext()) {
            Map.Entry m = (Map.Entry) it.next();
            p = (Profesor) m.getValue();
            if (p.getNombre().equals(nombre) && p.getApellido().equals(apellido)) {
                profesoresReturn.add(p);
            }
        }
        return profesoresReturn;
    }

    public ArrayList<Cursada> buscarCursadaPorNombre(String asignatura) {
        ArrayList<Cursada> cursadasReturn = new ArrayList<>();
        Cursada c;
        Iterator it = this.getCursadas()
                          .entrySet()
                          .iterator();
        while (it.hasNext()) {
            Map.Entry m = (Map.Entry) it.next();
            c = (Cursada) m.getValue();
            if (c.getAsignatura().equals(asignatura)) {
                cursadasReturn.add(c);
            }
        }
        return cursadasReturn;
    }
}
