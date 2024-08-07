//package com.poly.controller;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.poly.Service.CarPostService;
//import com.poly.dao.PendingCarPostDao;
//import com.poly.entity.PendingCarPost;
//
//import jakarta.servlet.ServletContext;
//
//@Controller
//public class PostCarController {
//
//    @Autowired
//    private PendingCarPostDao penDao;
//
//    @Autowired
//    private CarPostService carPostService;
//
//    private final String UPLOAD_DIR = "src/main/resources/static/images/";
//
//    @Autowired
//    ServletContext app;
//
//    @RequestMapping(value = "/index/postcar", method = RequestMethod.GET)
//    @PreAuthorize("hasAuthority('OWNER')")
//    public String postcar() {
//        return "views/postcar";
//    }
//
//    @PostMapping("/index/addPost")
//    public String addPost(@ModelAttribute PendingCarPost pendingCarPost, @RequestParam("imageName") MultipartFile imageFile)
//            throws IOException {
//
//        try {
//            if (!imageFile.isEmpty()) {
//                String fileName = imageFile.getOriginalFilename();
//                Path uploadPath = Paths.get(UPLOAD_DIR + fileName);
//                Files.copy(imageFile.getInputStream(), uploadPath, StandardCopyOption.REPLACE_EXISTING);
//                pendingCarPost.setImage("/images/" + fileName);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        carPostService.addPost(pendingCarPost);
//        return "views/postcar";
//    }
//
//    @RequestMapping(value = "/index/managePosts", method = RequestMethod.GET)
//    public String managePosts(Model model) {
//        String path = app.getRealPath("/images/");
//        model.addAttribute("posts", carPostService.getAllPendingPosts());
//        return "views/admin/managePosts";
//    }
//
//    @RequestMapping(value = "/index/approvePost", method = RequestMethod.POST)
//    public String approvePost(@RequestParam int postID) {
//        carPostService.approvePost(postID);
//        return "redirect:/index/managePosts";
//    }
//
//    @RequestMapping(value = "/index/rejectPost", method = RequestMethod.POST)
//    public String rejectPost(@RequestParam int postID) {
//        carPostService.rejectPost(postID);
//        return "redirect:/index/managePosts";
//    }
//}
package com.poly.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poly.Service.CarPostService;
import com.poly.entity.PendingCarPost;

@Controller
public class PostCarController {

    @Autowired
    private CarPostService carPostService;

    private final String UPLOAD_DIR = "uploads/";

    @RequestMapping(value = "/index/postcar", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('OWNER')")
    public String postcar(Model model) {
        // Load car brands and add to model if needed
        return "views/postcar";
    }

    @PostMapping("/index/addPost")
    public String addPost(@ModelAttribute PendingCarPost pendingCarPost,
                          @RequestParam("imageName") MultipartFile imageFile,
                          @RequestParam("ownershipDocument") MultipartFile ownershipDocument) throws IOException {

        // Lưu file ảnh
        if (!imageFile.isEmpty()) {
            String imageFileName = imageFile.getOriginalFilename();
            Path imagePath = Paths.get(UPLOAD_DIR + imageFileName);
            Files.copy(imageFile.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);
            pendingCarPost.setImage("/images/" + imageFileName);
        }

        // Lưu giấy sở hữu xe
        if (!ownershipDocument.isEmpty()) {
            String docFileName = ownershipDocument.getOriginalFilename();
            Path docPath = Paths.get(UPLOAD_DIR + docFileName);
            Files.copy(ownershipDocument.getInputStream(), docPath, StandardCopyOption.REPLACE_EXISTING);
            pendingCarPost.setOwnershipDocument("/images/" + docFileName);
        }

        // Cài đặt carOwnerID từ thông tin người dùng đã đăng nhập
        // Đây chỉ là ví dụ, bạn cần thay đổi theo cách bạn lấy carOwnerID
        

        carPostService.addPost(pendingCarPost);
        return "redirect:/index/managePosts";
    }

    private int getCurrentUserCarOwnerID() {
        // Thực hiện logic để lấy carOwnerID từ người dùng hiện tại
        // Ví dụ: sử dụng SecurityContextHolder hoặc phương pháp khác để lấy ID
        // Trả về ID giả định cho ví dụ này
        return 1;
    }

    @RequestMapping(value = "/index/managePosts", method = RequestMethod.GET)
    public String managePosts(Model model) {
        model.addAttribute("posts", carPostService.getAllPendingPosts());
        return "views/admin/managePosts";
    }

    @RequestMapping(value = "/index/approvePost", method = RequestMethod.POST)
    public String approvePost(@RequestParam int postID) {
        carPostService.approvePost(postID);
        return "redirect:/index/managePosts";
    }

    @RequestMapping(value = "/index/rejectPost", method = RequestMethod.POST)
    public String rejectPost(@RequestParam int postID) {
        carPostService.rejectPost(postID);
        return "redirect:/index/managePosts";
    }
}
