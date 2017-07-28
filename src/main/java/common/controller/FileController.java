package common.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import common.service.FileService;
import common.vo.Project;
import uploadFile.vo.FILEUPLOAD;



@Controller
@RequestMapping("/file")
@EnableWebMvc
public class FileController {
	@Autowired
	private FileService fileService;
	
	@ResponseBody
	@RequestMapping("/getProjectByType")
	public List<Project> getProjectInfo(String userType,String userID){
		return fileService.getProjectInfo(userType,userID);
	}
	
	@ResponseBody
	@RequestMapping("/FileUpload")
	public String fileUpload(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException {
		String path = "projectFile";
		String uploadPath = request.getSession().getServletContext().getRealPath("");
		uploadPath = uploadPath.split("mis")[0];
		int endIndex = uploadPath.lastIndexOf(File.separator);
		uploadPath = uploadPath.substring(0, endIndex + 1) + path + uploadPath.substring(endIndex, endIndex + 1);

		String attachmentSend=null;
		String newDate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		try {
			if (ServletFileUpload.isMultipartContent(request)) { // 判断获取的是不是文件
				MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;//request强制转换注意
				CommonsMultipartFile file = (CommonsMultipartFile) mRequest.getFile("file"); 
				if(!file.isEmpty()){
					String realFileName = file.getOriginalFilename(); 
					System.out.println("文件名：" + realFileName); 
					System.out.println("上传路径：" + uploadPath); 
					File dirPath = new File(uploadPath); 
					if (!dirPath.exists()) { 
					dirPath.mkdir(); 
					} 
					String newName = newDate + "."+ realFileName.substring(realFileName.lastIndexOf(".") + 1);
					File uploadFile = new File(uploadPath + newName); 
					FileCopyUtils.copy(file.getBytes(), uploadFile); 
					attachmentSend = "/projectFile/" + newName;
				}
				FILEUPLOAD fileVO = new FILEUPLOAD();
				fileVO.setFileName(request.getParameter("fileName"));
				fileVO.setFileId(UUID.randomUUID().toString().replace("-", ""));
				fileVO.setFileDesc(request.getParameter("fileDesc"));
				fileVO.setFileAddress(attachmentSend);
				fileVO.setFileType(request.getParameter("fileType"));
				String uploadTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				fileVO.setUploadTime(uploadTime);
				fileVO.setProjectId(request.getParameter("projectId"));
				fileVO.setUploadUserid(request.getParameter("userID"));
				fileService.addNewFile(fileVO);
			}
			return attachmentSend;
		} catch (Exception ex) {
				ex.printStackTrace();
			return "error";
		}
	}
	
	@ResponseBody
	@RequestMapping("/getFileList")
	public List<FILEUPLOAD> getFileList(String userType,String fileType,String startTime,String endTime,String projectId){
		return fileService.getFileList(userType,fileType, startTime, endTime, projectId);
	}
}
