/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import matrix.element.MatrixElement;
import matrix.exception.MatrixException;

/**
 *
 * @author i2070p
 */
public interface MatrixInterface {

    public MatrixInterface add(MatrixElement value);

    public MatrixInterface sub(MatrixElement value);

    public MatrixInterface mul(MatrixElement value);

    public MatrixInterface div(MatrixElement value);

    public MatrixInterface add(MatrixInterface matrix) throws MatrixException;

    public MatrixInterface sub(MatrixInterface matrix) throws MatrixException;

    public MatrixInterface mul(MatrixInterface matrix) throws MatrixException;

    public MatrixInterface div(MatrixInterface matrix) throws MatrixException;

    public MatrixInterface Transpone();

    public MatrixInterface getInverse() throws MatrixException;

    public MatrixElement  getValue(int row, int column) throws MatrixException;

    public MatrixElement  getDeterminant() throws MatrixException;

    public MatrixInterface setValues(MatrixElement  value) throws MatrixException;

    public MatrixInterface setValue(int row, int column, MatrixElement value) throws MatrixException;
    
    public int getWidth();
    
    public int getHeight();

}
