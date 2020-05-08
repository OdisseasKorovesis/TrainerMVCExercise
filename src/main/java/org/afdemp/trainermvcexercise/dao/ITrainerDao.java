/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.trainermvcexercise.dao;

import java.util.List;
import org.afdemp.trainermvcexercise.entities.Trainer;

/**
 *
 * @author Odisseas KD
 */
public interface ITrainerDao {
    
     public List<Trainer> findAllTrainers();
     public Trainer findTrainerById(int id);
     public boolean save(Trainer trainer);
     public boolean delete(int id);
     //public boolean updateTrainer(Trainer trainer);
    
}
