package com.poly.controller;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.poly.Service.CarPostService;
import com.poly.dao.PendingCarPostDao;
import com.poly.entity.CarBrand;
import com.poly.entity.PendingCarPost;
import jakarta.servlet.ServletContext;

@Controller
public class PostCarController {

	@Autowired
	private PendingCarPostDao penDao;

	@Autowired
	private CarPostService carPostService;

	private final String UPLOAD_DIR = "src/main/resources/static/images/";

	@Autowired
	ServletContext app;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(CarBrand.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				CarBrand carBrand = carPostService.findByName(text);
				setValue(carBrand);
			}
		});
	}

	@RequestMapping(value = "/index/postcar", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('OWNER')")
	public String postcar(Model model) {
		model.addAttribute("carBrands", carPostService.findAll());
		return "views/postcar";
	}

	@PostMapping("/index/addPost")
	public String addPost(@Validated @ModelAttribute PendingCarPost pendingCarPost,
			@RequestParam("imageName") MultipartFile imageFile,

			BindingResult result) throws IOException {
		if (result.hasErrors()) {
			return "views/postcar";
		}

		try {
			if (!imageFile.isEmpty()) {
				String fileName = imageFile.getOriginalFilename();
				Path uploadPath = Paths.get(UPLOAD_DIR + fileName);
				Files.copy(imageFile.getInputStream(), uploadPath, StandardCopyOption.REPLACE_EXISTING);
				pendingCarPost.setImage("/images/" + fileName);
			}

//            if (!ownershipDocumentFile.isEmpty()) {
//                String fileName = ownershipDocumentFile.getOriginalFilename();
//                Path uploadPath = Paths.get(UPLOAD_DIR + fileName);
//                Files.copy(ownershipDocumentFile.getInputStream(), uploadPath, StandardCopyOption.REPLACE_EXISTING);
//                pendingCarPost.setOwnershipDocument("/images/" + fileName);
//            }
} catch (IOException e) {
			e.printStackTrace();
		}

		carPostService.addPost(pendingCarPost);
		return "views/postcar";
	}

	@RequestMapping(value = "/index/managePosts", method = RequestMethod.GET)
	public String managePosts(Model model) {
		String path = app.getRealPath("/images/");
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