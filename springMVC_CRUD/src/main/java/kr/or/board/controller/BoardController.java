package kr.or.board.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.or.board.model.service.BoardService;
import kr.or.board.model.vo.Board;

@Controller
public class BoardController {
	@Autowired
	private BoardService service;

	// 글쓰기 화면
	@RequestMapping(value = "/boardWriteFrm.do")
	public String boardWriteFrm() {
		return "board/boardWriteFrm";
	}

	// 글쓰기 - multipartfile 매개변수명 = 화면에서의 file 인풋의 name
	@RequestMapping(value = "/boardWrite.do")
	public String boardWrite(Board b, MultipartFile file, HttpServletRequest request) {
		System.out.println(b.getBoardTitle());
		System.out.println(b.getBoardWriter());
		System.out.println(b.getBoardContent());

		// 파일 처리
		// 저장 경로 지정
		// getRealPath() -> webRoot -> webapp 폴더
		String savePath = request.getSession().getServletContext().getRealPath("/resources/upload/board/");

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

		System.out.println("filename : " + filename);
		System.out.println("filepath : " + filepath);

		// 서버에 파일 업로드
		try {
			FileOutputStream fos = new FileOutputStream(new File(savePath + filepath)); //
			BufferedOutputStream bos = new BufferedOutputStream(fos); // 보조스트림 속도개선

			byte[] bytes = file.getBytes(); // byte[] 변환

			bos.write(bytes);
			bos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/boardWriteFrm.do";
	}
}
