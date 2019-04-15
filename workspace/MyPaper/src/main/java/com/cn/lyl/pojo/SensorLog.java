package com.cn.lyl.pojo;

import java.util.Date;

public class SensorLog {
	/**
	 * ���
	 */
	private Integer id;
	/**
	 * ������ʱ��
	 */
	private Date date;
	/**
	 * ��Ԫ
	 */
	private Integer epoch;
	/**
	 * ��������������ţ�
	 */
	private Integer moteId;
	/**
	 * �¶�
	 */
	private Double temperature;
	/**
	 * ʪ��
	 */
	private Double humidity;
	/**
	 * ����
	 */
	private Double light;
	/**
	 * ��ѹ
	 */
	private Double voltage;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getEpoch() {
		return epoch;
	}
	public void setEpoch(Integer epoch) {
		this.epoch = epoch;
	}
	public Integer getMoteId() {
		return moteId;
	}
	public void setMoteId(Integer moteId) {
		this.moteId = moteId;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public Double getHumidity() {
		return humidity;
	}
	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}
	public Double getLight() {
		return light;
	}
	public void setLight(Double light) {
		this.light = light;
	}
	public Double getVoltage() {
		return voltage;
	}
	public void setVoltage(Double voltage) {
		this.voltage = voltage;
	}		
	
}
