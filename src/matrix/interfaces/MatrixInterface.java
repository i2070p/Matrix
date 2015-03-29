/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix.interfaces;

import matrix.exception.MatrixException;

/**
 *
 * @author i2070p
 * @param <T> type of elements
 */
public interface MatrixInterface<T extends Number> {

    public MatrixInterface add(T value);

    public MatrixInterface sub(T value);

    public MatrixInterface mul(T value);

    public MatrixInterface div(T value);

    public MatrixInterface add(MatrixInterface matrix) throws MatrixException;

    public MatrixInterface sub(MatrixInterface matrix) throws MatrixException;

    public MatrixInterface mul(MatrixInterface matrix) throws MatrixException;

    public MatrixInterface div(MatrixInterface matrix) throws MatrixException;

    public MatrixInterface Transpone();

    public MatrixInterface getInverse() throws MatrixException;

    public T  getValue(int row, int column) throws MatrixException;

    public T  getDeterminant() throws MatrixException;

    public MatrixInterface setValues(T value) throws MatrixException;

    public MatrixInterface setValue(int row, int column, T value) throws MatrixException;
    
    public int getWidth();
    
    public int getHeight();

}
