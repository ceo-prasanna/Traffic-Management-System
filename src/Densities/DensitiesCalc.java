package Densities;

public class DensitiesCalc {
	double north;
	double south;
	double west;
	double east;
	public DensitiesCalc(double north,double south,double west,double east ) {
		this.east = east;
		this.west = west;
		this.north = north;
		this.south = south;
	}
	public int[] getdensities() {
		int[] densities = new int[4];
		double deast = (east/100)*25;
		double dwest = (west/100)*25;
		double dnorth = (north/100)*25;
		double dsouth = (south/100)*25;
		double sum = deast+dwest+dnorth+dsouth;
		double peast = (deast/sum)*100;
		double pwest = (dwest/sum)*100;
		double pnorth = (dnorth/sum)*100;
		double psouth = (dsouth/sum)*100;
		
		densities[0] = (int) ((psouth/100)*120);
		densities[1] = (int) ((pwest/100)*120);
		densities[2] = (int) ((pnorth/100)*120);
		densities[3] = (int) ((peast/100)*120);
		
		
		return densities;
		
	}

}