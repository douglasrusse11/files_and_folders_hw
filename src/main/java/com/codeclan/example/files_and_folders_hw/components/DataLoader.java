package com.codeclan.example.files_and_folders_hw.components;

import com.codeclan.example.files_and_folders_hw.models.File;
import com.codeclan.example.files_and_folders_hw.models.Folder;
import com.codeclan.example.files_and_folders_hw.models.User;
import com.codeclan.example.files_and_folders_hw.repositories.FileRepository;
import com.codeclan.example.files_and_folders_hw.repositories.FolderRepository;
import com.codeclan.example.files_and_folders_hw.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {
        User student = new User("codeclan_student");
        userRepository.save(student);

        User staff = new User("codeclan_staff");
        userRepository.save(staff);

        Folder downloads = new Folder("Downloads", student);
        folderRepository.save(downloads);
        student.addFolder(downloads);

        Folder work = new Folder("codeclan_work", staff);
        folderRepository.save(work);
        staff.addFolder(work);

        Folder documents = new Folder("Documents", student);
        folderRepository.save(documents);
        student.addFolder(documents);

        File file = new File("File", "java", 1.2, work);
        fileRepository.save(file);
        work.addFile(file);

        File pom = new File("pom", "xml", 3.4, work);
        fileRepository.save(pom);
        work.addFile(file);

        File pirateService = new File("PirateService", "zip", 5.3, downloads);
        fileRepository.save(pirateService);
        downloads.addFile(pirateService);
    }
}
