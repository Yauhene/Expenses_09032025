package fileWorks;

import data.links.places.*;
import data.links.products.*;
import data.links.purchases.*;
import data.links.vizits.*;

import java.io.*;
import java.util.*;

public class Fileworks {

    /**
     * Сохранение визитов в файл
     *
     * @param fileName
     * @throws Exception
     */
    public static void writeVizitsToFile(String fileName) throws IOException {
        ArrayList<Vizits> array = Vizits.getVizitsArray();
        String tempStr = "";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Vizits vizit : array) {
                tempStr += vizit.id + ";" +
                        vizit.date.getDate() + ";" +
                        vizit.date.getMonth() + ";" +
                        vizit.date.getYear() + ";" +
                        vizit.placeID + ";" +
                        "\n";
            }
            writer.write(tempStr);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Чтение визитов из файла
     *
     * @param fileName
     * @throws Exception
     */

    public static void readVizitsFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String[] tempStr;
            Vizits vizit;

            while ((line = reader.readLine()) != null) {
                tempStr = line.split(";");

                vizit = new Vizits(Long.parseLong(tempStr[0]),
                        Integer.parseInt(tempStr[1]),
                        Integer.parseInt(tempStr[2]),
                        Integer.parseInt(tempStr[3]),
                        Long.parseLong(tempStr[4]));
                        Vizits.setCurrentID(Vizits.getCurrentID()+1);

                if (vizit.id > Vizits.getCurrentID()) {
                    Vizits.setCurrentID(vizit.id);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Сохранение покупок в файл
     *
     * @param fileName
     * @throws Exception
     */
    public static void writePurchasesToFile(String fileName) throws IOException {
        ArrayList<Purchases> array = Purchases.getPurchasesArray();
        String tempStr = "";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Purchases purch : array) {
                tempStr += purch.id + ";" +
                        purch.vizitID + ";" +
                        purch.productID + ";" +
                        purch.quantity + ";" +
                        purch.price + ";" +
                        purch.currency + ";" +
                        "\n";
            }
            writer.write(tempStr);
//                writer.append("\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Чтение покупок из файла
     *
     * @param fileName
     * @throws Exception
     */

    public static void readPurchasesFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String[] tempStr;
            Purchases purch;

            while ((line = reader.readLine()) != null) {
                tempStr = line.split(";");

                purch = new Purchases(Long.parseLong(tempStr[0]),
                        Long.parseLong(tempStr[1]),
                        Long.parseLong(tempStr[2]),
                        Double.parseDouble(tempStr[3]),
                        Double.parseDouble(tempStr[4]),
                        tempStr[5]);

                if (purch.id > Purchases.getCurrentID()) {
                    Purchases.setCurrentID(purch.id);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        /**
         * Сохранение продуктов в файл
         * @param fileName
         * @throws Exception
         */
        public static void writeProductsToFile(String fileName){
            ArrayList<Products> array = Products.getProductsArray();
            String tempStr = "";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                for (Products prod : array) {
                    tempStr += prod.id + ";" +
                            prod.typeID + ";" +
                            prod.name + ";" +
                            prod.units + ";" +
                            "\n";
                }
                writer.write(tempStr);
                writer.flush();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }



    /**
     * Чтение продуктов из файла
     *
     * @param fileName
     * @throws Exception
     */

    public static void readProductsFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String[] tempStr;
            Products prod;

            while ((line = reader.readLine()) != null) {
                tempStr = line.split(";");

                prod = new Products(Long.parseLong(tempStr[0]),
                        Long.parseLong(tempStr[1]),
                        tempStr[2],
                        tempStr[3]);

                if (prod.id > Products.getCurrentID()) {
                    Products.setCurrentID(prod.id);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Сохранение мест в файл
     * @param fileName
     * @throws Exception
     */
    public static void writePlacesToFile(String fileName){
        ArrayList<Places> array = Places.getPlacesArrayList();
        String tempStr = "";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Places place : array) {
                tempStr += place.id + ";" +
                        place.name + ";" +
                        place.location + ";" +
                        "\n";
            }
            writer.write(tempStr);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



    /**
     * Чтение мест из файла
     *
     * @param fileName
     * @throws Exception
     */

    public static void readPlacesFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String[] tempStr;
            Places place;

            while ((line = reader.readLine()) != null) {
                tempStr = line.split(";");

                place = new Places(Long.parseLong(tempStr[0]),
                        tempStr[1],
                        tempStr[2]);

                    Places.setCurrentID(place.id);
                System.out.println("Places.getCurrentID() после считыввания places.txt:" + Places.getCurrentID());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
