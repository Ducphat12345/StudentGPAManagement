package com.itsol.fileData;

import com.itsol.model.Student;
import java.io.*;
public class Data {
    public void write_file(Object[] data, String file){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(data);
            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public Object[] read_file(String file){
        Object[] objects = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            objects = (Object[]) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return objects;
    }
}
