package aiss.model.resources;

import java.util.Map;

import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.resource.ClientResource;

import aiss.model.spotify.SpotifyUser;

public class SpotifyResource {
	private static String uri = "https://api.spotify.com/v1";
	private String access_token;
	
	public SpotifyResource(String access_token) {
		super();
		this.access_token = access_token;
	}
	
	public  String getUser() {
		String id;
		String url = (uri + "/me"+ "?access_token=" + access_token);
		ClientResource cr = new ClientResource(url);
		SpotifyUser user = cr.get(SpotifyUser.class);
		id = user.getId();
		return id;
	}
	
	public void createPlaylist(String playlist) {
		SpotifyResource sr = new SpotifyResource(access_token);
		String id = sr.getUser();
		String url = (uri + "/users/"+id+"/playlists");
		ClientResource cr = new ClientResource(url);
		Map<String, Object> headers = cr.getRequestAttributes();
		headers.put("Content-Type", "application/json");
		cr.post("\"name\":"+playlist);
	}
	
}
