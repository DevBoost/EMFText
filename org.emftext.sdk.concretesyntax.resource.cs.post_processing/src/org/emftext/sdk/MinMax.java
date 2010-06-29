package org.emftext.sdk;

/**
 * A helper class to hold information about the cardinality
 * of a feature.
 */
public class MinMax {
	
	private int min;
	private int max;
	
	public MinMax() {
	}
	
	public MinMax(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	public int getMin() {
		return min;
	}
	
	public void setMin(int min) {
		this.min = min;
	}
	
	public int getMax() {
		return max;
	}
	
	public void setMax(int max) {
		this.max = max;
	}
	
	public boolean enclosesMax(MinMax minMax) {
		if (max < 0) {
			return true;
		} else {
			if (minMax.getMax() < 0) {
				return false;
			} else  {
				return max >= minMax.getMax();
			}
		}
	}
	
	public String toString() {
		return min + ".." + max;
	}
}