package kr.or.board.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.multi.MultiOptionPaneUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.or.board.model.service.BoardService;
import kr.or.board.model.vo.Board;
import kr.or.board.model.vo.FileTbl;

@Controller
public class BoardController {
	@Autowired
	private BoardService service;

	// 글쓰기 화면
	@RequestMapping(value = "/boardWriteFrm.do")
	public String boardWriteFrm() {
		return "board/boardWriteFrm";
	}

	@RequestMapping(value = "/boardList.do")
	public String boardList() {
		return "";
	}
	
	// 글 쓰기 - 다중 파일 업로드 multipartfile 매개변수명 = 화면에서의 file 인풋의 name
	@RequestMapping(value = "/boardWrite.do")
	public String boardWrite(Board b, MultipartFile files[], HttpServletRequest request, Model model) {

		ArrayList<FileTbl> fileList = new ArrayList<FileTbl>(); // 파일 목록 저장할 리스트 생성

		// 파일 처리
		// 파일이 존재하지 않더라도 배열은 무조건 길이 1을 가짐
		if (!files[0].isEmpty()) { // 첨부파일이 있는 경우
			// 저장 경로 지정
			// getRealPath() -> webRoot -> webapp 폴더
			String savePath = request.getSession().getServletContext().getRealPath("/resources/upload/board/");

			for (MultipartFile file : files) {
				// 실제 유저가 올린 업로드 파일명(filename)
				String filename = file.getOriginalFilename();

				// 유저가 올린 파일명을 마지막 .기준으로 분리 ex) test.txt -> test / .txt
				// indexof : .위치 추출 / substring : begin ~ end 까지 자르기
				String onlyFilename = filename.substring(0, filename.indexOf(".")); // test 자르기
				String extention = filename.substring(filename.indexOf(".")); // .txt 자르기 - .위치부터 끝까지
				String filepath = null;

				int count = 0;

				// 중복이름 필터
				while (true) {

					if (count == 0) {
						filepath = onlyFilename + extention; // test.txt
					} else {
						filepath = onlyFilename + "_" + count + extention; // test_x.txt
					}

					File checkFile = new File(savePath + filepath); // 경로 + 파일명
					// 중복 체크 - 중복이 아닌 경우 break;
					if (!checkFile.exists()) {
						break;
					}
					count++;
				}

				// 파일 정보 저장
				FileTbl f = new FileTbl();
				f.setFilename(filename);
				f.setFilepath(filepath);

				fileList.add(f); // 파일 목록 저장

				// 서버에 파일 업로드
				try {
					FileOutputStream fos = new FileOutputStream(new File(savePath + filepath));
					BufferedOutputStream bos = new BufferedOutputStream(fos); // 보조스트림 속도개선

					byte[] bytes = file.getBytes(); // byte[] 변환

					bos.write(bytes);
					bos.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} // for 문
		} // 파일 처리

		// DB 처리
		int result = service.insertBoard(b, fileList);

		// 글쓰기가 성공하고 + 파일 업로드db 저장이 모두 잘 되었을때
		if (result != -1 && result == fileList.size()) {
			model.addAttribute("msg", "등록 성공");
		} else {
			model.addAttribute("msg", "등록 실패");
		}
		model.addAttribute("loc", "/");
		return "common/msg";
	}
}
