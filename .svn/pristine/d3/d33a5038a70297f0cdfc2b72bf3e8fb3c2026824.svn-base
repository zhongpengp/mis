package common.service;

import java.util.List;

import common.vo.Project;
import uploadFile.vo.FILEUPLOAD;

public interface FileService {

	List<Project> getProjectInfo(String userType, String userID);

	void addNewFile(FILEUPLOAD fileVO);

	List<FILEUPLOAD> getFileList(String userType, String fileType, String startTime, String endTime, String projectId);

}
