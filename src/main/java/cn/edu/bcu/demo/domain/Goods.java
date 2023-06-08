package cn.edu.bcu.demo.domain;

import java.sql.Timestamp;

public class Goods {
	private Integer goodsId;
	private String goodsName;
	private double unit;
	private Integer categoryId;
	private String imgUrl;
	private String smallImg;
	private Integer inventory;
	private String description;
	private Timestamp updateTime;
	private Timestamp putTime;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public double getUnit() {
		return unit;
	}
	public void setUnit(double unit) {
		this.unit = unit;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getSmallImg() {
		return smallImg;
	}
	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Timestamp getPutTime() {
		return putTime;
	}
	public void setPutTime(Timestamp putTime) {
		this.putTime = putTime;
	}

	@Override
	public String toString() {
		return "TGoods{" +
				"goodsId=" + goodsId +
				", goodsName='" + goodsName + '\'' +
				", unit=" + unit +
				", categoryId=" + categoryId +
				", imgUrl='" + imgUrl + '\'' +
				", smallImg='" + smallImg + '\'' +
				", inventory=" + inventory +
				", description='" + description + '\'' +
				", updateTime=" + updateTime +
				", putTime=" + putTime +
				", type='" + type + '\'' +
				'}';
	}
}
