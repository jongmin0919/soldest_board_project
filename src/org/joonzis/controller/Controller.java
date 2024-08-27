package org.joonzis.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joonzis.vo.CVO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import org.joonzis.service.BBSService;
import org.joonzis.service.BBSServiceImpl;
import org.joonzis.vo.BVO;

@WebServlet("/BBSController")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			String realPath = request.getServletContext().getRealPath("/upload");
			MultipartRequest mr = null;
			HttpSession session = request.getSession();
			String open = null;
			
			String cmd = request.getParameter("cmd");
			if(cmd == null) {
				mr = new MultipartRequest(
						request,
						realPath,
						1024 * 1024 * 10,
						"utf-8",
						new DefaultFileRenamePolicy());
				cmd = mr.getParameter("cmd");
			}
			
			//단순 화면 이동인지 데이터를 전달하는 이동인지 구분해야함
			boolean isForward = true;
			
			String path = "";
			BBSService bservice = new BBSServiceImpl();
			List<BVO> list = null; 
			BVO bvo = null;
			int result = 0;
			
			switch(cmd) {
			case "allList":
				list = bservice.getList();
				request.setAttribute("list", list);
				session.setAttribute("open", null);
				path = "bbs/allList.jsp";
				break;
			case "insertBBSPage":
				path = "bbs/insert_page.jsp";
				break;
			case "insertBBS":
				bvo = new BVO();
				bvo.setWriter(mr.getParameter("writer"));
				bvo.setPw(mr.getParameter("pw"));
				bvo.setTitle(mr.getParameter("title"));
				bvo.setContent(mr.getParameter("content"));
//				bvo.setIp(request.getRemoteAddr()); IPv6
				bvo.setIp(Inet4Address.getLocalHost().getHostAddress());
				
				if(mr.getParameter("filename") != null) {
					bvo.setFilename(mr.getFilesystemName("filename"));
				}else
				{
					bvo.setFilename("");
				}
				result = bservice.getInsertBBS(bvo);
				path = "BBSController?cmd=allList";
				isForward = false;
				break;
			case "view":
				session.setAttribute("b_idx", request.getParameter("b_idx"));
				bvo = bservice.getBBS(session);
				
				open = (String)session.getAttribute("open");
				if(open == null) {
					session.setAttribute("open", "yes");
					int hit = bvo.getHit() + 1;
					bvo.setHit(hit);
					bservice.getUpdateHit(bvo);
				}
				session.setAttribute("bvo", bvo);
				path = "bbs/view.jsp";
				break;
			case "delete":
				session.setAttribute("b_idx", request.getParameter("b_idx"));
				session.setAttribute("pw", request.getParameter("pw"));
				result = bservice.removeBBS(session);
				path = "BBSController?cmd=allList";
				isForward = false;
				break;
			case "updatePage":
				path = "bbs/update_page.jsp";
				break;
			case "update":
				bvo = new BVO();
				bvo.setB_idx(Integer.parseInt(mr.getParameter("b_idx")));
				bvo.setPw(mr.getParameter("pw"));
				bvo.setTitle(mr.getParameter("title"));
				bvo.setContent(mr.getParameter("content"));
				
				File newFile = mr.getFile("filename");
				String oldFile = mr.getParameter("oldfile");
				
				if(newFile != null) {
					if(oldFile != null) {
						File removeFile = new File(realPath + "/" + oldFile);
						if(removeFile.exists()) {
							removeFile.delete();
						}
					}
					bvo.setFilename(newFile.getName());
				}else {
					if(oldFile != null) {
						bvo.setFilename(oldFile);
					}else {
						bvo.setFilename("");
					}
				}
				bservice.updateBBS(bvo);
				path = "BBSController?cmd=view&b_idx=" + bvo.getB_idx();
				break;
			case "download":
				String filename = request.getParameter("filename");
			    File file = new File(realPath + "/" + filename);
			    if (file.exists()) {
			        // 파일 이름에 공백이 있을 경우 "+"로 출력되는 부분 수정
			        filename = URLEncoder.encode(filename, "utf-8");
			        filename = filename.replaceAll("\\+", "%20");

			        // 클라이언트의 헤더 정보에 첨부파일이 있음을 처리
			        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
			        response.setHeader("Content-Length", String.valueOf(file.length()));

			        // 파일을 읽고 클라이언트로 전송합니다
			        try (FileInputStream fis = new FileInputStream(file);
			             BufferedInputStream bis = new BufferedInputStream(fis);
			             BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream())) {

			            byte[] buffer = new byte[4096];
			            int bytesRead;
			            while ((bytesRead = bis.read(buffer)) != -1) {
			                bos.write(buffer, 0, bytesRead);
			            }
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
			    } else {
			        response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
			    }
			    break;
			}
			
			if(isForward) {
				request.getRequestDispatcher(path).forward(request, response);
			}else {
				response.sendRedirect(path);
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
