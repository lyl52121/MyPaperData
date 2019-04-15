package com.cn.lyl.pojo;

import java.util.Date;

public class SensorLog {
	/**
	 * 序号
	 */
	private Integer id;
	/**
	 * 日期与时间
	 */
	private Date date;
	/**
	 * 历元
	 */
	private Integer epoch;
	/**
	 * 尘粒（传感器编号）
	 */
	private Integer moteId;
	/**
	 * 温度
	 */
	private Double temperature;
	/**
	 * 湿度
	 */
	private Double humidity;
	/**
	 * 光照
	 */
	private Double light;
	/**
	 * 电压
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
