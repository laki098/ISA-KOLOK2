package kolokvijum2vezba.plugin;

import java.util.HashMap;

import org.springframework.http.HttpMethod;

/*
 * Klasa koja sluzi za prenos metapodataka o plaguin-u.
 */
public class PluginDescription {
	private String name;
	private String category;
	private String description;
	private String url; // URL preko kojeg se moze pristupiti plugin-u.
	
	// Spisak svih endpointa koje plugin daje na upotrebu plugin hostu.
	// Endpointi su razvrstani po tipu zahteva a potom po nazivu.
	private HashMap<HttpMethod, HashMap<String, String>> endpoints = new HashMap<HttpMethod, HashMap<String, String>>();
	
	public PluginDescription() {
	}

	public PluginDescription(String name, String category, String description, String url, HashMap<HttpMethod, HashMap<String, String>> endpoints) {
		super();
		this.name = name;
		this.category = category;
		this.description = description;
		this.url = url;
		this.endpoints = endpoints;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public HashMap<HttpMethod, HashMap<String, String>> getEndpoints() {
		return endpoints;
	}

	public void setEndpoints(HashMap<HttpMethod, HashMap<String, String>> endpoints) {
		this.endpoints = endpoints;
	}
	
	/*
	 * Pomocna metoda za dobavljanje endopinta po tipu zahteva i nazivu endpointa.
	 */
	public String getEndpointUrl(HttpMethod method, String endpointName) {
		HashMap<String, String> existingEndpoitns = this.endpoints.get(method);
		if(existingEndpoitns != null) {
			return existingEndpoitns.get(endpointName);
		}
		return null;
	}
}
