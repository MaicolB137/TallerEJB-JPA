/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.student.session;

import co.edu.unipiloto.arquitectura.student.entity.EstudianteCurso;
import co.edu.unipiloto.arquitectura.student.entity.EstudianteCursoPK;
import static co.edu.unipiloto.arquitectura.student.entity.EstudianteCurso_.estudianteCursoPK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Michael
 */
@Stateless
public class EstudianteCursoFacade extends AbstractFacade<EstudianteCurso> implements EstudianteCursoFacadeLocal {

    @PersistenceContext(unitName = "Student-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudianteCursoFacade() {
        super(EstudianteCurso.class);
    }

    @Override
    public void create(EstudianteCurso estudianteCurso) {
        em.persist(estudianteCurso); // Persistir la entidad
    }

}
