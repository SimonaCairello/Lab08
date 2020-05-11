package it.polito.tdp.extflightdelays.db;

import it.polito.tdp.extflightdelays.model.Airport;

public class CoppieAeroporti {
	
	private Airport aeroportoP;
	private Airport aeroportoA;
	private float avg;
	
	public CoppieAeroporti(Airport aeroportoP, Airport aeroportoA, float avg) {
		this.aeroportoP = aeroportoP;
		this.aeroportoA = aeroportoA;
		this.avg = avg;
	}

	public Airport getAeroportoP() {
		return aeroportoP;
	}

	public void setAeroportoP(Airport aeroportoP) {
		this.aeroportoP = aeroportoP;
	}

	public Airport getAeroportoA() {
		return aeroportoA;
	}

	public void setAeroportoA(Airport aeroportoA) {
		this.aeroportoA = aeroportoA;
	}

	public float getAvg() {
		return avg;
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}

}
