package edu.thss.monitor.pub.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import edu.thss.monitor.base.logrecord.imp.Log;
import edu.thss.monitor.pub.util.IDGenerator;

/**
 * 平台管理日志表
 * 
 * @author zhuangxy 2012-12-25
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "PLT_MPM_PlatformManageLog")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PlatformManageLog extends Log implements java.io.Serializable {

	public PlatformManageLog(Integer eventType,String recordContent,Date timeStamp){
		this.eventType = eventType;
		this.recordContent = recordContent;
		this.timeStamp = timeStamp;
		
		this.plt_id = IDGenerator.getPltID();
	}
	
	/**
	 * 默认构造函数，自动生成plt_id的时间。若重写构造函数需包含以下代码。
	 */
	public PlatformManageLog() {
		this.plt_id = IDGenerator.getPltID();
	}

	/**
	 * MRO平台特殊需要的属性，对用户不可见
	 */
	@SuppressWarnings("unused")
	@Column(name = "plt_id", columnDefinition = "NVARCHAR2(50)", nullable = false)
	private String plt_id;
	
	/**
	 * oid
	 */
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "edu.thss.monitor.pub.util.UUIDGenerator")
	@Column(name = "plt_oid", columnDefinition = "RAW(32)")
	private String oid;

	/**
	 * 事件类型
	 */
	@Column(name = "plt_eventType", columnDefinition = "NUMBER(2)")
	private Integer eventType;

	/**
	 * 记录内容
	 */
	@Column(name = "plt_recordContent", columnDefinition = "NVARCHAR2(100)")
	private String recordContent;

	/**
	 * 时间戳
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "plt_timeStamp", columnDefinition = "DATE DEFAULT SYSDATE ")
	private Date timeStamp;

	/**
	 * 平台管理日志事件类型主码
	 */
	@Column(name = "plt_mpmEventTypeMC", columnDefinition = "NUMBER(2) DEFAULT 18")
	private Integer mpmEventTypeMC;

	public Integer getEventType() {
		return eventType;
	}

	public void setEventType(Integer eventType) {
		this.eventType = eventType;
	}

	public String getRecordContent() {
		return recordContent;
	}

	public void setRecordContent(String recordContent) {
		this.recordContent = recordContent;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getMpmEventTypeMC() {
		return mpmEventTypeMC;
	}

	public String getOid() {
		return oid;
	}

}
