/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import matrix.element.MatrixElement;
import java.lang.reflect.Array;
import matrix.element.IntegerElement;
import matrix.exception.MatrixException;

/**
 *
 * @author i2070p
 */
public class Matrix implements MatrixInterface {

    private final MatrixElement[][] matrix;
    private final int height;
    private final int width;

    public Matrix(int height, int width) {
        this.height = height;
        this.width = width;
        this.matrix = (MatrixElement[][]) Array.newInstance(MatrixElement.class, this.height, this.width);
    }

    public Matrix(Matrix matrix) {
        this(matrix.height, matrix.width);

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.height; j++) {
                this.matrix[i][j].set(matrix.matrix[i][j]);
            }
        }
    }

    @Override
    public MatrixInterface mul(MatrixInterface matrix) throws MatrixException {

        if (this.getHeight() != matrix.getWidth()) {
            throw new MatrixException("Wrong size.");
        }

        MatrixInterface result = new Matrix(this.getHeight(), matrix.getWidth());

        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < matrix.getWidth(); j++) {
                MatrixElement sum = new IntegerElement(0);
                for (int k = 0; k < this.getWidth(); k++) {
                    sum.add(this.getValue(i, k).mul(matrix.getValue(k, j)));
                }
                result.setValue(i, j, sum);
            }
        }

        return result;
    }

    @Override
    public MatrixInterface setValue(int row, int column, MatrixElement value) throws MatrixException {
        if (!(row < this.height && row >= 0 && column < this.width && column >= 0)) {
            throw new MatrixException("Index out of bounds");
        }

        this.matrix[row][column].set(value);
        return this;
    }

    @Override
    public MatrixInterface setValues(MatrixElement value) {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.height; j++) {
                this.matrix[i][j].set(value);
            }
        }
        return this;
    }

    @Override
    public MatrixElement getValue(int row, int column) throws MatrixException {
        if (!(row < this.height && row >= 0 && column < this.width && column >= 0)) {
            throw new MatrixException("Index out of bounds");
        }
        return this.matrix[row][column];
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
        result.append("Size: ").append(this.height).append(" x ").append(this.width).append("\n");
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.height; j++) {
                result.append(this.matrix[i][j]).append(" ");
            }

            result.append("\n");
        }

        return result.toString();
    }

    @Override
    public MatrixInterface Transpone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MatrixInterface add(MatrixElement value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MatrixInterface sub(MatrixElement value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MatrixInterface mul(MatrixElement value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MatrixInterface div(MatrixElement value) {
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
    public MatrixElement getDeterminant() throws MatrixException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
