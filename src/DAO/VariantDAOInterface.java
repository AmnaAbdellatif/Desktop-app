/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;



/**
 *
 * @author hp
 
 * @param <T>
 */
public interface VariantDAOInterface<T> {
    public void insert(T t);
    public void delete (T t);
    public void update (T t);
   //public T findbynomProjet(T t);
    
}
