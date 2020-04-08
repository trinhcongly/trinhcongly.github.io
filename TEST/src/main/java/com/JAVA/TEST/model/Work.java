package com.JAVA.TEST.model;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "works")
public class Work {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer workId;
	
	@NotBlank
    @Size(min=3, max = 50)
	private String workName;
	
	private Date dateStart;
	
	private Date dateEnd;
	
	@NotBlank
	@Size(min=3, max = 50)
	private String status;

	/**
	 * @return the wordName
	 */
	public String getWorkName() {
		return workName;
	}
	/**
	 * @param wordName the wordName to set
	 */
	public void setWorkName(String wordName) {
		this.workName = wordName;
	}
	/**
	 * @return the dateStart
	 */
	public Date getDateStart() {
		return dateStart;
	}
	/**
	 * @param dateStart the dateStart to set
	 */
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	/**
	 * @return the dateEnd
	 */
	public Date getDateEnd() {
		return dateEnd;
	}
	/**
	 * @param dateEnd the dateEnd to set
	 */
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @param wordId the wordId to set
	 */
	public void setWordId(Integer wordId) {
		this.workId = wordId;
	}
	/**
	 * @return the workId
	 */
	public Integer getWorkId() {
		return workId;
	}
	/**
	 * @param workId the workId to set
	 */
	public void setWorkId(Integer workId) {
		this.workId = workId;
	}
	public Work(Integer wordId, @NotBlank @Size(min = 3, max = 50) String wordName, Date dateStart,
			Date dateEnd, @NotBlank @Size(min = 3, max = 50) String status) {
		super();
		this.workId = wordId;
		this.workName = wordName;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.status = status;
	}
	public Work() {}

}
