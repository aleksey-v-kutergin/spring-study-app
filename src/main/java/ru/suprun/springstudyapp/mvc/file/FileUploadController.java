package ru.suprun.springstudyapp.mvc.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Controller
public class FileUploadController
{
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("file")MultipartFile file)
    {
        if(!file.isEmpty())
        {
            try
            {
                byte[] fileBytes = file.getBytes();
                String rootPath = System.getProperty("catalina.home");
                System.out.println("Server root path: " + rootPath);
                System.out.println("File original name: " + file.getOriginalFilename());
                System.out.println("File content type: " + file.getContentType());

                File newFile = new File(rootPath + File.separator + file.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream( new FileOutputStream(newFile));
                stream.write(fileBytes);
                stream.close();

                String message = "File is saved under: " + rootPath + File.separator + file.getOriginalFilename();
                System.out.println(message);
                return message;
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return "File upload is failed: " + e.getMessage();
            }
        }
        else
        {
            return "File upload is failed: File is empty";
        }
    }
}
