/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.trainermvcexercise.services;

import java.util.List;
import org.afdemp.trainermvcexercise.dao.TrainerDaoImpl;
import org.afdemp.trainermvcexercise.entities.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Odisseas KD
 */
@Service
@Transactional
public class TrainerServiceImpl implements ITrainerService {

    @Autowired
    TrainerDaoImpl dao;

    @Override
    public List<Trainer> findAllTrainers() {
        List<Trainer> trainers = dao.findAllTrainers();
        return trainers;
    }

    @Override
    public boolean save(Trainer trainer) {
        return dao.save(trainer);
    }
    
    @Override
    public boolean delete(int id) {
        return dao.delete(id);
    }

    @Override
    public Trainer findTrainerById(int id) {
        return dao.findTrainerById(id);
    }
    
    @Override
    public boolean updateTrainer(Trainer trainer) {
        //return dao.updateTrainer(trainer);
		Trainer entity = dao.findTrainerById(trainer.getId());
		if(entity!=null){
			entity.setFirstName(trainer.getFirstName());
			entity.setLastName(trainer.getLastName());
			entity.setSubject(trainer.getSubject());
                        return true;
		}
                return false;
	}

}
