import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<String> fFC = new ArrayList<>();
        ArrayList<Integer> intArrayList = new ArrayList<>();
        String filepath = "C:\\Users\\sebas\\OneDrive\\Documentos\\codigos_postales_hmo.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String firstFive = line.substring(0, Math.min(5, line.length()));
                fFC.add(firstFive);
            }
        } catch (IOException e) {
            System.err.println("Error al contar ff5 " + e.getMessage());
        }
        for (String value : fFC) {
            try {
                int enteros = Integer.parseInt(value);
                intArrayList.add(enteros);
            } catch (NumberFormatException ignored) {
            }
        }
        int cuentaTot = 0;
        for (int i = 0; i < intArrayList.size(); i++) {
            int num = intArrayList.get(i);
            int count = 1; // Inicializa la cuenta en 1
            for (int j = i + 1; j < intArrayList.size(); j++) { // Checa si ya se repitió
                if (intArrayList.get(j) == num) {
                    count++;
                    intArrayList.remove(j); // Se quita para no contarse en siguientes iteraciones
                    j--; // Se ajusta el índice
                }
            }
            if (count > 1) {
                cuentaTot += count;
            }
        }
        System.out.println("Cuenta total de areas que comparten codigos postales: " + cuentaTot);
    }
}
