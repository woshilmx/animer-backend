package com.lmx.project.until;

import com.lmx.project.config.FileConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
@Slf4j
public class FileUntil {
    @Resource
    private FileConfig fileConfig;

    @Value("${server.port}")
    private String port;

    @Value("${server.servlet.context-path}")
    private String contextpath;



    public boolean saveFile(InputStream inputStream, String filepath) throws IOException {
        File file = new File(fileConfig.getPre() + filepath);
        log.info(fileConfig.getPre() + filepath);
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            FileOutputStream out = new FileOutputStream(file);

            byte[] bytes = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(bytes)) != -1) {
                out.write(bytes, 0, length);
            }
            out.close();
            inputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }


    }

    public String getIpaddress() throws UnknownHostException {
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        String pre="http://";

        return pre+hostAddress+":"+port+contextpath+"/file/";
    }

    public static void main(String[] args) throws UnknownHostException {
        FileUntil fileUntil = new FileUntil();
        System.out.println(fileUntil.getIpaddress());
    }
}
