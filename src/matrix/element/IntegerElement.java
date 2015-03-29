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
public class IntegerElement implements MatrixElement<Integer> {

    private Integer value;

    public IntegerElement(Integer value) {
        this.value = value;
    }

    public IntegerElement(IntegerElement value) {
        this.value = value.get();
    }

    @Override
    public MatrixElement add(MatrixElement<Integer> element) {
        this.value += element.get();
        return this;
    }

    @Override
    public MatrixElement sub(MatrixElement<Integer> element) {
        this.value -= element.get();
        return this;
    }

    @Override
    public MatrixElement mul(MatrixElement<Integer> element) {
        this.value *= element.get();
        return this;
    }

    @Override
    public MatrixElement div(MatrixElement<Integer> element) {
        this.value /= element.get();
        return this;
    }

    @Override
    public Integer get() {
        return this.value;
    }

    @Override
    public void set(Integer value) {
        this.value = value;
    }

    @Override
    public void set(MatrixElement<Integer> value) {
        this.value = value.get();
    }

}
