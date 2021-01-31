package model;

public class CovidTableModel {

	String country;
	int janCol;
	int febCol;
	int marCol;
	int aprCol;
	int mayCol;
	int junCol;
	int julCol;
	int augCol;
	int sepCol;
	int octCol;
	int novCol;
	int decCol;
	/*
	*
	*@author Addison.Chan
	*/
	
	public CovidTableModel(String country, int janCol, int febCol, int marCol, int aprCol, int mayCol,
			int junCol, int julCol, int augCol, int sepCol, int octCol, int novCol, int decCol) {
		super();
		this.country = country;
		this.janCol = janCol;
		this.febCol = febCol;
		this.marCol = marCol;
		this.aprCol = aprCol;
		this.mayCol = mayCol;
		this.junCol = junCol;
		this.julCol = julCol;
		this.augCol = augCol;
		this.sepCol = sepCol;
		this.octCol = octCol;
		this.novCol = novCol;
		this.decCol = decCol;
	}

	/*
	* Getters and setters for all the countries, and monlths 
	*/
	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public int getJanCol() {
		return janCol;
	}


	public void setJanCol(int janCol) {
		this.janCol = janCol;
	}


	public int getFebCol() {
		return febCol;
	}


	public void setFebCol(int febCol) {
		this.febCol = febCol;
	}


	public int getMarCol() {
		return marCol;
	}


	public void setMarCol(int marCol) {
		this.marCol = marCol;
	}


	public int getAprCol() {
		return aprCol;
	}


	public void setAprCol(int aprCol) {
		this.aprCol = aprCol;
	}


	public int getMayCol() {
		return mayCol;
	}


	public void setMayCol(int mayCol) {
		this.mayCol = mayCol;
	}


	public int getJunCol() {
		return junCol;
	}


	public void setJunCol(int junCol) {
		this.junCol = junCol;
	}


	public int getJulCol() {
		return julCol;
	}


	public void setJulCol(int julCol) {
		this.julCol = julCol;
	}


	public int getAugCol() {
		return augCol;
	}


	public void setAugCol(int augCol) {
		this.augCol = augCol;
	}


	public int getSepCol() {
		return sepCol;
	}


	public void setSepCol(int sepCol) {
		this.sepCol = sepCol;
	}


	public int getOctCol() {
		return octCol;
	}


	public void setOctCol(int octCol) {
		this.octCol = octCol;
	}


	public int getNovCol() {
		return novCol;
	}


	public void setNovCol(int novCol) {
		this.novCol = novCol;
	}


	public int getDecCol() {
		return decCol;
	}


	public void setDecCol(int decCol) {
		this.decCol = decCol;
	}
	
	
	
	
	
	
	
}
