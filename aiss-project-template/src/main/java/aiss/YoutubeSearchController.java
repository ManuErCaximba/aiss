package aiss;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.YoutubePlaylistResource;
import aiss.model.youtube.YoutubePlaylistSearch;

/**
 * Servlet implementation class YoutubeSearchController
 */
public class YoutubeSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YoutubeSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String link = request.getParameter("searchQuery");
		RequestDispatcher rd = null;
		YoutubePlaylistResource youtube = new YoutubePlaylistResource();
		YoutubePlaylistSearch playlist = youtube.getPlaylist(link);
		
		if(playlist!=null) {
			rd = request.getRequestDispatcher("/success.jsp");
			request.setAttribute("canciones", playlist.getItems());
		}else {
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
