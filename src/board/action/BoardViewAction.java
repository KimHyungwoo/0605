package board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.dto.Board;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String num = request.getParameter("num");
		
		BoardDAO dao = new BoardDAO(); // DB에서 데이터 가지고 오는 것
		
		Board board = dao.seletOnBoardByNum(Integer.parseInt(num)); 
		
		dao.updateHits(Integer.parseInt(num)); // 조회수 증가
		
		request.setAttribute("board", board);
		
		// 해당하는 페이지로 이동
		String url = "./board/view.jsp";
		
		// url을 변경 안 할거니까 포워드방식 사용
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
