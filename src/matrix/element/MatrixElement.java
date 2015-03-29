/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix.element;

/**
 *
 * @author i2070p
 */
public interface MatrixElement<T> {
    public MatrixElement add(MatrixElement<T> element);
    public MatrixElement sub(MatrixElement<T> element);
    public MatrixElement mul(MatrixElement<T> element);
    public MatrixElement div(MatrixElement<T> element);  
    public T get();
    public void set(T value);
    public void set(MatrixElement<T> value);    
}
