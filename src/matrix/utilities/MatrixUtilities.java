/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import matrix.IntegerMatrix;

/**
 *
 * @author i2070p
 */
public final class MatrixUtilities {

    public static IntegerMatrix loadMatrixFromFile(String path, String delimiter) throws FileNotFoundException, IOException {

        List<Integer> numbers = new ArrayList<>();
        int i = 0;
        int width = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                Scanner scanner = new Scanner(line);
                scanner.useDelimiter(delimiter);
                if (i == 0) {
                    width = scanner.nextInt();
                } else {
                    while (scanner.hasNext()) {
                        numbers.add(scanner.nextInt());
                    }
                }
                i++;
            }
        }

        Integer result[] = new Integer[numbers.size()];
        result = numbers.toArray(result);

        return new IntegerMatrix(result, width);
    }

}
