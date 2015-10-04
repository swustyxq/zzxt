package swust.edu.cn.zzxt.selfmodel;

import java.util.List;

import swust.edu.cn.zzxt.model.Function;

public class NavigationModel {
	private int id;
	private String name;
	private String type;
	private int ordinal;
	private int workId;
	private String description;
	private List<Function> columns;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Function> getColumns() {
		return columns;
	}

	public void setColumns(List<Function> columns) {
		this.columns = columns;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}

	public int getWorkId() {
		return workId;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
