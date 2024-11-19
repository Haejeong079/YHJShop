package inhatc.cse.yhjshope.item.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
public class FileService {

        public String uploadFile(String uploadPath, String originalFileName,
                          byte[] fileData) throws IOException {

        UUID uuid = UUID.randomUUID();
        String ext = originalFileName.substring(originalFileName.lastIndexOf("."), originalFileName.length());
        String savedFileName = uuid.toString() + ext;
        String fileUploadFullPath = uploadPath + "/" + savedFileName;


        FileOutputStream fos = new FileOutputStream(fileUploadFullPath);
        fos.write(fileData);
        fos.close();

        return savedFileName;
    }

    private void deleteFile(String filePath){
        File deleteFile = new File(filePath);
        if(deleteFile.exists()){
            deleteFile.delete();
            log.info("파일 삭제요 ");
        }else {
            log.warn(filePath + "파일 존재안함요");
        }
    }

}
