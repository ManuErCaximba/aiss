package aiss.model.resources;


import org.restlet.resource.ClientResource;

import aiss.model.youtube.YoutubePlaylistSearch;

public class YoutubePlaylistResource {
	private static final String YOUTUBE_API_KEY = "AIzaSyCgE-gVBhVdk_QVQPIy0LNVhSEBQ1xdrac";
	
	public YoutubePlaylistSearch getPlaylist(String link) {
		String[] array = link.split("=");
		String playlistId = array[1];
		String uri = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId="+playlistId+ "&key=" + YOUTUBE_API_KEY;
		ClientResource cr = new ClientResource(uri);
		YoutubePlaylistSearch playlist = cr.get(YoutubePlaylistSearch.class);
		return playlist;
	}
}
