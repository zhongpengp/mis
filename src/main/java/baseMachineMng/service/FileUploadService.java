package baseMachineMng.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	public String returnFilePath(MultipartFile file, HttpServletRequest request) throws IOException {
		System.out.println("开始上传文件" + System.currentTimeMillis());
		// 得到上传的文件
		MultipartFile mFile = file;
		// 得到上传服务器的路径
		String path = request.getSession().getServletContext().getRealPath(File.separator + "excelUpload");
		// 得到上传的文件的文件名
		File f = new File(path);
		// 创建文件夹
		if (!f.exists()) {
			f.mkdirs();
		}
		String filename = mFile.getOriginalFilename();
		filename = System.currentTimeMillis() + filename;
		path += File.separator + filename;

		// File filecheck = new File(path);
		// if (filecheck.exists()) {
		// filecheck.delete();
		// }
		// file.createNewFile();

		InputStream in = mFile.getInputStream();
		// 创建一个文件输出流
		FileOutputStream out = new FileOutputStream(path);
		// 创建一个缓冲区
		byte buffer[] = new byte[1024];
		// 判断输入流中的数据是否已经读完的标识
		int len = 0;
		// 循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
		while ((len = in.read(buffer)) > 0) {
			// 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" +
			// filename)当中
			out.write(buffer, 0, len);
		}
		// 关闭输入流
		in.close();
		// 关闭输出流
		out.close();
		System.out.println("结束上传文件" + System.currentTimeMillis());
		return path;
	}

	public Map<String, String> returnFilePath_baseMachineInfoImport(HttpServletRequest request)
			throws IOException, FileUploadException {
		String selectedImportProjectID = "";
		String path = "";
		// boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload();
		// Parse the request
		FileItemIterator iter = upload.getItemIterator(request);
		while (iter.hasNext()) {
			FileItemStream item = iter.next();
			String name = item.getFieldName();
			InputStream stream = item.openStream();
			if (item.isFormField()) {
				if (name.equals("selectedImportProjectID")) {
					selectedImportProjectID = Streams.asString(stream);
				}
			} else {
				System.out.println("File field " + name + " with file name " + item.getName() + " detected.");
				// Process the input stream
				String filename = item.getName();
				// 得到上传服务器的路径
				path = request.getSession().getServletContext().getRealPath(File.separator + "excelUpload");
				// 得到上传的文件的文件名
				File f = new File(path);
				// 创建文件夹
				if (!f.exists()) {
					f.mkdirs();
				}
				filename = System.currentTimeMillis() + filename;
				path += File.separator + filename;
				InputStream in = item.openStream();
				// 创建一个文件输出流
				FileOutputStream out = new FileOutputStream(path);
				// 创建一个缓冲区
				byte buffer[] = new byte[1024];
				// 判断输入流中的数据是否已经读完的标识
				int len = 0;
				// 循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
				while ((len = in.read(buffer)) > 0) {
					// 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" +
					// filename)当中
					out.write(buffer, 0, len);
				}
				// 关闭输入流
				in.close();
				// 关闭输出流
				out.close();
			}
		}
		Map<String, String> result = new HashMap<>();
		result.put("projectID", selectedImportProjectID);
		result.put("filePath", path);
		return result;
	}
}
