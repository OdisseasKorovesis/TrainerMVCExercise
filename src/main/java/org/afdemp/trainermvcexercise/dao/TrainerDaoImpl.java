/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.trainermvcexercise.dao;

import java.util.List;
import org.afdemp.trainermvcexercise.entities.Trainer;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Odisseas KD
 */
@Repository(("trainerDao"))
public class TrainerDaoImpl extends AbstractDao<Integer, Trainer> implements ITrainerDao {

    @Override
    public List<Trainer> findAllTrainers() {
        Criteria criteria = createEntityCriteria();
        return (List<Trainer>) criteria.list();
    }

    @Override
    public boolean save(Trainer trainer) {
        boolean Saved = persist(trainer);
        if (!Saved) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        Trainer trainer = getByKey(id);
        if (trainer != null) {
            delete(trainer);
            if (getByKey(id) == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Trainer findTrainerById(int id) {
        return getByKey(id);
    }

    @Override
    public boolean updateTrainer(Trainer trainer) {
        Trainer t = findTrainerById(trainer.getId());
        if (t != null) {
            t.setFirstName(trainer.getFirstName());
            t.setLastName(trainer.getLastName());
            t.setSubject(trainer.getSubject());
            return save(t);
        }
        return false;
    }

}
