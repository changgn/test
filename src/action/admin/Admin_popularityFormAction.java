package action.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import mvc.dao.BoardDao;
import mvc.dao.CategoryDao;
import mvc.dao.ComentDao;
import mvc.dao.PhotoDao;
import vo.BoardVo;
import vo.CategoryVo;
import vo.PhotoVo;

public class Admin_popularityFormAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
/*		// 인스턴스 생성
		BoardDao boarddao = BoardDao.getInstance();
		// 객체 생성
		List<BoardVo> boardList = null;
		
		boardList = boarddao.getPopularityList();
*/
		String id = (String)request.getSession().getAttribute("id");
		List<BoardVo> boardList = null;
		List<HashMap> allBoardList = new ArrayList<>();
		
		BoardDao boardDao = BoardDao.getInstance();
		PhotoDao photoDao = PhotoDao.getInstance();
		ComentDao comentDao = ComentDao.getInstance();
		CategoryDao categoryDao = CategoryDao.getInstance();
		boardList = boardDao.getRecoBoarList();
		
		if(boardList!=null){
			for(BoardVo vo : boardList) {
				HashMap<String, Object> boardMap = new HashMap<String, Object>();
				PhotoVo photo = photoDao.getOneByBoardNum(vo.getBoard_num());
				CategoryVo category = categoryDao.getOne(vo.getCategory_id());
				String commentCount = comentDao.getCountByBoardNum(vo.getBoard_num());
				if(commentCount==null)	commentCount="0";
				boolean contentFlag = false;
				String[] contentSub = vo.getContent().split("\n");
				if(contentSub.length > 3) {
					contentFlag = true;
					vo.setContent(contentSub[0] + contentSub[1] + contentSub[2]);
				}
				boardMap.put("board", vo);
				boardMap.put("photo", photo);
				boardMap.put("category", category);
				boardMap.put("commentCount", commentCount);
				boardMap.put("contentFlag", contentFlag);
				allBoardList.add(boardMap);
			}
		}
		request.setAttribute("id", id);
		request.setAttribute("allBoardList", allBoardList);

		return "/administrator/admin_popularityForm.jsp";
	}

}
