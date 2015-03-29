/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import matrix.interfaces.MatrixInterface;
import java.lang.reflect.Array;
import matrix.exception.MatrixException;

/**
 *
 * @author i2070p
 */
public class IntegerMatrix implements MatrixInterface<Integer> {

    private final Integer[][] matrix;
    private final int height;
    private final int width;

    public IntegerMatrix(int height, int width) {
        this.height = height;
        this.width = width;
        this.matrix = (Integer[][]) Array.newInstance(Integer.class, this.height, this.width);
    }

    public IntegerMatrix(Integer[] matrix, int width) {
        this(matrix.length / width, width);

        for (int i = 0; i < matrix.length; i++) {
            int column = i % width;
            int row = i / width;

            this.matrix[row][column] = matrix[i].intValue();
        }

    }

    public IntegerMatrix(Integer[][] matrix) {
        this(matrix.length, matrix[0].length);

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.matrix[i][j] = matrix[i][j].intValue();
            }
        }

    }

    public IntegerMatrix(IntegerMatrix matrix) {
        this(matrix.matrix);
    }

    @Override
    public MatrixInterface mul(MatrixInterface matrix) throws MatrixException {
        if (this.getWidth() != matrix.getHeight()) {
            throw new MatrixException("Wrong size.");
        }

        MatrixInterface result = new IntegerMatrix(this.getHeight(), matrix.getWidth());

        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < matrix.getWidth(); j++) {

                Integer sum = 0;

                for (int k = 0; k < this.getWidth(); k++) {
                    sum += this.getValue(i, k).intValue() * matrix.getValue(k, j).intValue();
                }
                result.setValue(i, j, sum);
            }
        }

        return result;
    }

    @Override
    public MatrixInterface setValue(int row, int column, Integer value) throws MatrixException {
        if (!(row < this.height && row >= 0 && column < this.width && column >= 0)) {
            throw new MatrixException("Index out of bounds");
        }

        this.matrix[row][column] = value.intValue();

        return this;
    }

    @Override
    public MatrixInterface setValues(Integer value) {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.matrix[i][j] = value.intValue();
            }
        }

        return this;
    }

    @Override
    public Integer getValue(int row, int column) throws MatrixException {
        if (!(row < this.height && row >= 0 && column < this.width && column >= 0)) {
            throw new MatrixException("Index out of bounds");
        }

        return this.matrix[row][column].intValue();
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                result.append(this.matrix[i][j]).append(" ");
            }

            result.append("\n");
        }

        return  result.append("Size: ").append(this.height).append(" x ").append(this.width).append("\n").toString();
    }

    @Override
    public MatrixInterface Transpone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MatrixInterface add(Integer value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MatrixInterface sub(Integer value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MatrixInterface mul(Integer value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MatrixInterface div(Integer value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MatrixInterface add(MatrixInterface matrix) throws MatrixException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MatrixInterface sub(MatrixInterface matrix) throws MatrixException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MatrixInterface div(MatrixInterface matrix) throws MatrixException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MatrixInterface getInverse() throws MatrixException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getDeterminant() throws MatrixException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
