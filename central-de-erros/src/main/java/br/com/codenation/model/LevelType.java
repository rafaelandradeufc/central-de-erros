package br.com.codenation.model;

public enum LevelType {

	ERROR("error"), WARNING("warning"), INFO("info");

	private final String level;

	LevelType(String levelStr){
        this.level = levelStr;
    }

	public String getLevel() {
		return level;
	}
}
