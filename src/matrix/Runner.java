/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import matrix.interfaces.MatrixInterface;
import matrix.utilities.MatrixUtilities;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import matrix.exception.MatrixException;

public class Runner {

    public static void main(String[] args) {

        try {

            MatrixInterface A = MatrixUtilities.loadMatrixFromFile("A.txt", ";");
            MatrixInterface B = MatrixUtilities.loadMatrixFromFile("B.txt", ";");
            MatrixInterface C = A.mul(B);

            System.out.println(A);
            System.out.println(B);
            System.out.println(C);

        } catch (MatrixException | IOException ex) {
            Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
