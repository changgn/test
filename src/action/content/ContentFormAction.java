package action.content;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import mvc.dao.BoardDao;
import mvc.dao.PhotoDao;
import vo.BoardVo;
import vo.PhotoVo;

public class ContentFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		// 게시글 번호값 받아오기
		Integer board_num = Integer.parseInt(request.getParameter("board_num"));
		
		// 변수 생성
		List<PhotoVo> photoList = null;
		BoardVo board = null;
		
		// 인스턴스 생성
		PhotoDao photoDao = PhotoDao.getInstance();
		BoardDao boardDao = BoardDao.getInstance();
			
		// 게시물 번호로 정보 가져오기
		board = boardDao.getByBoardNum(board_num);
		photoList = photoDao.getListById(board_num);
		
		if(board != null) { // 가져온 게시글 정보가 있다면
			request.setAttribute("board", board);
		}
		if(photoList != null) { // 가져온 사진 정보가 있다면
			request.setAttribute("photoList", photoList);
		}
		
		
        return "/content/contentForm.jsp";//해당 뷰
	}

}