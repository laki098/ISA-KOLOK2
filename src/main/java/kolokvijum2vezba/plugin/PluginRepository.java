package kolokvijum2vezba.plugin;

import java.util.HashMap;

import java.util.ArrayList;

import kolokvijum2vezba.plugin.PluginDescription;

public class PluginRepository {
private HashMap<String, ArrayList<Plugin>> pluginRepository = new HashMap<String, ArrayList<Plugin>>();
	
	public PluginRepository() {
	}
	
	public void registerPlugin(PluginDescription pluginDescription) {
		if(pluginRepository.get(pluginDescription.getCategory()) == null) {
			pluginRepository.put(pluginDescription.getCategory(), new ArrayList<Plugin>());
		}
		Plugin plugin = new Plugin(pluginDescription);
		pluginRepository.get(pluginDescription.getCategory()).add(plugin);
	}
	
	public ArrayList<Plugin> getPlugins(String category) {
		return pluginRepository.get(category);
	}
}

