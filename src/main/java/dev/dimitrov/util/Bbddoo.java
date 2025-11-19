package dev.dimitrov.util;

import java.io.File;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import dev.dimitrov.obj.Alumno;
import dev.dimitrov.obj.Instituto;

public class Bbddoo {
    private static final Logger LOG = LoggerFactory.getLogger(Bbddoo.class);
    private ObjectContainer db = null;
    private File ficheroBd = null;
    public Bbddoo(File ficheroBd, boolean overwrite){
        if(overwrite && ficheroBd.exists()){
            LOG.warn("Se borra la anterior DB");
            ficheroBd.delete();
        }

        db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), ficheroBd.getName());
        db.ext().configure().objectClass(Instituto.class).cascadeOnDelete(true);
    }

    public void guardarAlumno(Alumno al) {
        db.store(al);
        LOG.info("Guardado el alumno "+al.toString());
    }

    public List<Alumno> getTodosAlumnos(String nombreInstituto) {
        ObjectSet<Instituto> insti = db.queryByExample(new Instituto(nombreInstituto,null,null));
        Instituto i = insti.get(0);
        return i.getMatriculados();
    }

    public boolean guardarInstituto(Instituto insti) {
        db.store(insti);
        return true;
    }

    public Instituto getInstituto(Instituto institutoBuscado) {
        Instituto resultado = null;
        ObjectSet<Instituto> instis = db.queryByExample(institutoBuscado);
        if(instis.isEmpty()){
            LOG.error("No se encontró ningun instituo con esas caracteristicas");
        }

        return resultado;
    }

    public boolean borrarInstituto(Instituto institutoABorrar) {
        return false;
    }
}
