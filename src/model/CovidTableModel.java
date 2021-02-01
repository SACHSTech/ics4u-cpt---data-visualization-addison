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
	/**
	* Gets the country
	*
	* 
	* @return returns country
	* @author Addison
	*/

	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}

	/**
	* Gets the Jan
	*
	* 
	* @return returns january col
	* @author Addison
	*/
	public int getJanCol() {
		return janCol;
	}


	public void setJanCol(int janCol) {
		this.janCol = janCol;
	}

	/**
	* Gets the feb number
	*
	* 
	* @return returns feb number
	* @author Addison
	*/
	public int getFebCol() {
		return febCol;
	}


	public void setFebCol(int febCol) {
		this.febCol = febCol;
	}

	/**
	* Gets the Mar number
	*
	* 
	* @return returns Mar number
	* @author Addison
	*/
	public int getMarCol() {
		return marCol;
	}


	public void setMarCol(int marCol) {
		this.marCol = marCol;
	}

	/**
	* Gets the Apr number
	*
	* 
	* @return returns Apr number
	* @author Addison
	*/
	public int getAprCol() {
		return aprCol;
	}


	public void setAprCol(int aprCol) {
		this.aprCol = aprCol;
	}

	/**
	* Gets the May number
	*
	* 
	* @return returns May number
	* @author Addison
	*/
	public int getMayCol() {
		return mayCol;
	}


	public void setMayCol(int mayCol) {
		this.mayCol = mayCol;
	}

	/**
	* Gets the Jun number
	*
	* 
	* @return returns Jun number
	* @author Addison
	*/
	public int getJunCol() {
		return junCol;
	}


	public void setJunCol(int junCol) {
		this.junCol = junCol;
	}

	/**
	* Gets the Jul number
	*
	* 
	* @return returns Jul number
	* @author Addison
	*/
	public int getJulCol() {
		return julCol;
	}


	public void setJulCol(int julCol) {
		this.julCol = julCol;
	}

	/**
	* Gets the Aug number
	*
	* 
	* @return returns Aug number
	* @author Addison
	*/
	public int getAugCol() {
		return augCol;
	}

	
	public void setAugCol(int augCol) {
		this.augCol = augCol;
	}

	/**
	* Gets the Sep number
	*
	* 
	* @return returns Sep number
	* @author Addison
	*/
	public int getSepCol() {
		return sepCol;
	}


	public void setSepCol(int sepCol) {
		this.sepCol = sepCol;
	}

	/**
	* Gets the Oct number
	*
	* 
	* @return returns Oct number
	* @author Addison
	*/
	public int getOctCol() {
		return octCol;
	}


	public void setOctCol(int octCol) {
		this.octCol = octCol;
	}

	/**
	* Gets the nov number
	*
	* 
	* @return returns Nov number
	* @author Addison
	*/
	public int getNovCol() {
		return novCol;
	}


	public void setNovCol(int novCol) {
		this.novCol = novCol;
	}

	/**
	* Gets the Dec number
	*
	* 
	* @return returns Dec number
	* @author Addison
	*/
	public int getDecCol() {
		return decCol;
	}


	public void setDecCol(int decCol) {
		this.decCol = decCol;
	}
	
	
	
	
	
	
	
}
