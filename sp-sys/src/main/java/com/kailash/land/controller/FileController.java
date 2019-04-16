package com.kailash.land.controller;

import com.kailash.land.util.Result;
import org.apache.poi.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

//@Value("${urldate.importModel}")
//private String idCardParth;
//private String demandFileParth;
//private String contractParth;
//private String importModel;

@Controller
@RequestMapping("file")
public class FileController {
	private static Logger logger = LoggerFactory.getLogger(FileController.class);
	private final static String UPLOAD_DIRS_PREFIX = "upload.dirs.";
	
	@Value("${upload.base-dir}")
	private String uploadDir;

	@Autowired
	private Environment env;
	
	@PostMapping("/upload")
	@ResponseBody
	public Result upload(Integer fileKind, MultipartFile file) {
		Result result = new Result();
		
		String proKey = UPLOAD_DIRS_PREFIX + fileKind;
		String dir = env.getProperty(proKey);
		if(null != dir){
			long now = System.currentTimeMillis();
			String fileName = dir + now + file.getOriginalFilename();
			File dest = new File(uploadDir + fileName);
			if(!dest.getParentFile().exists()){
				dest.getParentFile().mkdirs();
			}
			try {
				file.transferTo(dest);
				result.put("url",fileName);
				return result;
			} catch (IOException e) {
				logger.error(e.toString(), e);
				return Result.error(e.toString());
			}
		} else {
			return Result.error("上传失败！文件类别错误！");
		}
	}

	/*
	 * 下载文件前判断文件是否存在
	 *
	 * @param filePath
	 * 
	 * @return
	 */
	@RequestMapping(value = "/fileExists", method = RequestMethod.GET)
	@ResponseBody
	public Result fileExists(@RequestParam("filePath") String filePath) {
		logger.info("判断文件是否存在的路径：" + filePath);
		File file = new File(filePath);
		if (!file.exists()) {
			return Result.error().put("msg", "文件不存在!");
		} else {
			return Result.ok();
		}
	}

//    @Value("${urldate.importModel}")
	private String importModel;

	/**
	 * 下载导入模板
	 *
	 * @return
	 */
	@RequestMapping(value = "/downImportModelFile", produces = "application/json")
	@ResponseBody
	public Result downImportModelFile(HttpServletRequest request, HttpServletResponse response) {
		Result result = downFile(importModel, request, response);
		return result;
	}

	/**
	 * 下载导入的错误文件
	 *
	 * @return
	 */
	@RequestMapping(value = "/downImportErrorFile", produces = "application/json")
	@ResponseBody
	public Result downImportErrorFile(String fileName, HttpServletRequest request, HttpServletResponse response) {
		Result result = downFile(fileName, request, response);
		return result;
	}

	/**
	 * 下载文件 下载中英文件名的文件
	 * 
	 * @param filePath 文件路径
	 * @return
	 */
	@GetMapping(value = "/downFile")
	public Result downFile(String filePath, HttpServletRequest request, HttpServletResponse response) {
		InputStream fis = null;
		OutputStream toClient = null;
		filePath = uploadDir + "/" + filePath;
		File file = new File(filePath);
		if (!file.exists()) {
			return Result.error("file exists");
		}
		try {
			// 以流的形式下载文件。
			fis = new BufferedInputStream(new FileInputStream(filePath));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			// 设置Response
			setResponse(request, response, file);
			toClient = new BufferedOutputStream(response.getOutputStream());
			toClient.write(buffer);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error();
		} finally {
			try {
				if (null != fis) {
					IOUtils.closeQuietly(fis);
				}
				if (null != toClient) {
					toClient.flush();
					IOUtils.closeQuietly(toClient);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 设置response
	 * 
	 * @param request
	 * @param response
	 * @param file
	 */
	@SuppressWarnings("deprecation")
	public void setResponse(HttpServletRequest request, HttpServletResponse response, File file) {
		ServletContext sc = request.getSession().getServletContext();
		String fileName = file.getName();
		String filePath = file.getPath();
		// 清空response
		response.reset();
		// 设置response的Header
//        response.setHeader("Content-Disposition",
//                "attachment;filename="+ new String(fileName.getBytes(),"ISO8859-1"));
		response.setHeader("Content-Disposition", "attachment;filename*=UTF-8''" + URLEncoder.encode(fileName));
		response.addHeader("Content-Length", "" + file.length());
		response.setContentType(sc.getMimeType(filePath));
	}

}
