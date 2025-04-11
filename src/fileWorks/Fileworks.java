package fileWorks;

import data.links.vizits.*;

import java.io.*;
import java.util.*;

public class Fileworks {

        /**
         * Сохранение визитов в файл
         * @param fileName
         * @throws Exception
         */
        public static void Write_Vizits_to_File(String fileName) throws IOException {
            ArrayList<Vizits> array = Vizits.getVizitsArray();
//            for (Vizits vz : Vizits.getVizitsArray()) {
//                System.out.println(vz);
//            }
            String tempStr = "";
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                for (Vizits vizit: array) {
                    tempStr += vizit.id + ";" +
                            vizit.date.getDate() + ";" +
                            vizit.date.getMonth() + ";" +
                            vizit.date.getYear() + ";" +
                            vizit.placeID + ";" +
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
     * Чтение визитов из файла
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
                    System.out.println("id считанного: " + vizit.id);
                    System.out.println("CurrentID: " + Vizits.getCurrentID());

                    if (vizit.id > Vizits.getCurrentID()) {
                        Vizits.setCurrentID(vizit.id);
                        System.out.println("Теперь CurrentID после if: " + Vizits.getCurrentID());
                    }
                    System.out.println("Vizits.getCurrentID(): " + Vizits.getCurrentID());
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        }

        public static void helloFromFiles() {
            System.out.println();
            System.out.println();
            System.out.println("Hi from in_out.java !!!");

        }



}
