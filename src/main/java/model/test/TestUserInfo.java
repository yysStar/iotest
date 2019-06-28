package model.test;

import model.UserInfo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;

public class TestUserInfo {

    public static void main(String[] args) throws IOException{
        UserInfo info = new UserInfo();
        info.buildUserID(100).buildUserName("Welcome to Netty");
        int loop = 1000000;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream os = null;
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < loop; i++) {
            bos = new ByteArrayOutputStream();
            os = new ObjectOutputStream(bos);
            os.writeObject(info);
            os.flush();
            os.close();
            byte[] b = bos.toByteArray();
//            System.out.println("The jdk serializable length is : " + b.length);
            bos.close();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("The jdk serializable cost time is : " + (endTime - startTime) + "ms");
        System.out.println("-------------------------------------");
        startTime = System.currentTimeMillis();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        for(int i = 0; i < loop; i++){
            byte[] b = info.codeC(buffer);
        }
        endTime = System.currentTimeMillis();
        System.out.println("The byte array serializable cost time is : " + (endTime - startTime) + "ms");
//        System.out.println("The byte array serializable length is : " + info.codeC(buffer).length);
    }
}
