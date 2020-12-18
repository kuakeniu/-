package csv;
import com.csvreader.*;
import factory.ExerciseFactory;

import java.io.IOException;
import java.nio.charset.Charset;

public class CsvOper {
    public static void writeCorrect(String filePath){
        try {
            // 创建CSV写对象
            CsvWriter csvWriter = new CsvWriter(filePath,',', Charset.forName("GB2312"));
            //CsvWriter csvWriter = new CsvWriter(filePath);

            // 写表头
            String[] headers = {"操作数a","操作符","操作数b","答案","答案对错","用户答案"};
            csvWriter.writeRecord(headers);
            for(int i = 0; i < ExerciseFactory.e.length; i++){
                String[] Content = {String.valueOf(ExerciseFactory.e[i].getA()), String.valueOf(ExerciseFactory.e[i].getOp()), String.valueOf(ExerciseFactory.e[i].getB()),
                        String.valueOf(ExerciseFactory.e[i].getAns()), String.valueOf(ExerciseFactory.e[i].isUserCheck()), String.valueOf(ExerciseFactory.e[i].getUserAns())};
                csvWriter.writeRecord(Content);
            }
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeExercise(String filePath){
        try {
            CsvWriter csvWriter = new CsvWriter(filePath , ',' , Charset.forName("GB2312"));
            String[] headers  = {"操作数a","操作符","操作数b","答案",};
            csvWriter.writeRecord(headers);
            for(int i = 0 ; i < ExerciseFactory.e.length ; i++){
                String[] Content = {String.valueOf(ExerciseFactory.e[i].getA()) , String.valueOf(ExerciseFactory.e[i].getOp()) , String.valueOf(ExerciseFactory.e[i].getB()) ,
                        String.valueOf(ExerciseFactory.e[i].getAns())};
                csvWriter.writeRecord(Content);
            }
            csvWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void writeInterrupt(String filePath){
        try{
            CsvWriter csvWriter = new CsvWriter(filePath , ',' , Charset.forName("GB2312"));
            String[] headers = {"操作数a" , "操作符" , "操作数b" , "用户答案" , "答案"};
            csvWriter.writeRecord(headers);
            for(int i = 0 ; i < ExerciseFactory.e.length ; i++){
                String[] Content = {String.valueOf(ExerciseFactory.e[i].getA()), String.valueOf(ExerciseFactory.e[i].getOp()),
                        String.valueOf(ExerciseFactory.e[i].getB()), String.valueOf(ExerciseFactory.e[i].getUserAns()), String.valueOf(ExerciseFactory.e[i].getAns())};
                        csvWriter.writeRecord(Content);
            }
            csvWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void readCorrect(String path){
        int m=0;
        try{
            CsvReader csvReader = new CsvReader(path);
            csvReader.readHeaders();
            while (csvReader.readRecord()){
                ExerciseFactory.e[m].setA(Integer.parseInt(csvReader.get(0)));    //"操作数a","操作符","操作数b","答案","答案对错","用户答案"
                ExerciseFactory.e[m].setOp(Integer.parseInt(csvReader.get(1)));
                ExerciseFactory.e[m].setB(Integer.parseInt(csvReader.get(2)));
                ExerciseFactory.e[m].setAns(Integer.parseInt(csvReader.get(3)));
                ExerciseFactory.e[m].setUserCheck(Boolean.parseBoolean(csvReader.get(4)));
                ExerciseFactory.e[m].setUserAns(Integer.parseInt(csvReader.get(5)));
                m++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void readExercise(String path){
        int m=0;
        try{
            CsvReader csvReader = new CsvReader(path);
            csvReader.readHeaders();
            while (csvReader.readRecord()){
                ExerciseFactory.e[m].setA(Integer.parseInt(csvReader.get(0)));
                ExerciseFactory.e[m].setOp(Integer.parseInt(csvReader.get(1)));
                ExerciseFactory.e[m].setB(Integer.parseInt(csvReader.get(2)));
                ExerciseFactory.e[m].setAns(Integer.parseInt(csvReader.get(3)));
                m++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void readInterrupt(String path){
        int m=0;
        try{
            CsvReader csvReader = new CsvReader(path);
            csvReader.readHeaders();
            while (csvReader.readRecord()){
                ExerciseFactory.e[m].setA(Integer.parseInt(csvReader.get(0)));
                ExerciseFactory.e[m].setOp(Integer.parseInt(csvReader.get(1)));
                ExerciseFactory.e[m].setB(Integer.parseInt(csvReader.get(2)));
                ExerciseFactory.e[m].setUserAns(Integer.parseInt(csvReader.get(3)));
                ExerciseFactory.e[m].setAns(Integer.parseInt(csvReader.get(4)));
                m++;
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
