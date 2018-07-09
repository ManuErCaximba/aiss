package aiss;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.SpotifyResource;

/**
 * Servlet implementation class SpotifyPlaylistController
 */
public class SpotifyPlaylistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SpotifyPlaylistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accessToken=(String)request.getSession().getAttribute("Spotify-token");
		if(accessToken!=null && !"".equals(accessToken)){
			SpotifyResource s = new SpotifyResource(accessToken);
			s.createPlaylist("PlaylistDePrueba");
			request.getRequestDispatcher("/Spotify.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/AuthController/Spotify").forward(request,response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
