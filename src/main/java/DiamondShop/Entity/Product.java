package DiamondShop.Entity;

import java.sql.Date;

public class Product {

	private long ID;
	private int ID_CATEGORIES;
	private String SIZES;
	private String PRODUCT_NAME;
	private double PRICE;
	private int SALE;
	private String TITLE;
	private int FEATURED_PRODUCT;
	private int NEW_PRODUCT;
	private String DETAIL;
	private Date CREATED_AT;
	private Date UPDATED_AT;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public int getID_CATEGORIES() {
		return ID_CATEGORIES;
	}

	public void setID_CATEGORIES(int iD_CATEGORIES) {
		ID_CATEGORIES = iD_CATEGORIES;
	}

	public String getSIZES() {
		return SIZES;
	}

	public void setSIZES(String sIZES) {
		SIZES = sIZES;
	}

	public String getPRODUCT_NAME() {
		return PRODUCT_NAME;
	}

	public void setPRODUCT_NAME(String pRODUCT_NAME) {
		PRODUCT_NAME = pRODUCT_NAME;
	}

	public double getPRICE() {
		return PRICE;
	}

	public void setPRICE(double pRICE) {
		PRICE = pRICE;
	}

	public int getSALE() {
		return SALE;
	}

	public void setSALE(int sALE) {
		SALE = sALE;
	}

	public String getTITLE() {
		return TITLE;
	}

	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}

	public int getFEATURED_PRODUCT() {
		return FEATURED_PRODUCT;
	}

	public void setFEATURED_PRODUCT(int fEATURED_PRODUCT) {
		FEATURED_PRODUCT = fEATURED_PRODUCT;
	}

	public int getNEW_PRODUCT() {
		return NEW_PRODUCT;
	}

	public void setNEW_PRODUCT(int nEW_PRODUCT) {
		NEW_PRODUCT = nEW_PRODUCT;
	}

	public String getDETAIL() {
		return DETAIL;
	}

	public void setDETAIL(String dETAIL) {
		DETAIL = dETAIL;
	}

	public Date getCREATED_AT() {
		return CREATED_AT;
	}

	public void setCREATED_AT(Date cREATED_AT) {
		CREATED_AT = cREATED_AT;
	}

	public Date getUPDATED_AT() {
		return UPDATED_AT;
	}

	public void setUPDATED_AT(Date uPDATED_AT) {
		UPDATED_AT = uPDATED_AT;
	}
}
