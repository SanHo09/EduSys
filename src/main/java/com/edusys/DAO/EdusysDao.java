/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.DAO;

import java.util.List;

/**
 *
 * @author Sang
 */
public abstract class EdusysDao<E,K> {
    abstract public void insert(E entity);
    abstract public void update(E entity);
    abstract public void delete(E entity);
    abstract public List<E> selectAll();
    abstract public E selectByID(K key);
    abstract protected List<E> selectBySql(String SQL, Object ...args);
}
