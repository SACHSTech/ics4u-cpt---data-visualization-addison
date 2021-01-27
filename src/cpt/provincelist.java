package cpt;
import java.io.*;
import java.util.ArrayList;
public class provincelist {

    private static ArrayList<province> provinceslist = new ArrayList<province>();

    public provincelist(String fileread) throws IOException{
        BufferedReader provinces = new BufferedReader(new FileReader("src/cpt/"+ fileread));
        String csvreader ="";
        String[] reader;

        while((csvreader=provinces.readLine())!=null){
            reader=csvreader.split(",");
            if(reader[0].equals("Year")){

            }else{
                provinceslist.add(new province(reader));
            }
        }
        provinces.close();
    }

}